package com.company;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import static com.company.Const.URL;

public class MainClient {
    public static void main(String[] args) throws MalformedURLException {

        URL wsdlURL = new URL(URL + "?wsdl");
        QName qname = new QName("http://company.com/", "SOAPService");
        Service service = null;
        try {
            service = Service.create(wsdlURL, qname);
        } catch (WebServiceException e) {
            System.err.println("Server " + URL + " is not available.");
            return;
        }
        ISoap sp = service.getPort(ISoap.class);

        Date date = sp.whatTimeIsItNow();
        String[] dirList = sp.ls("/home/samusev");

        System.out.println(date);
        System.out.println(Arrays.asList(dirList));
    }
}