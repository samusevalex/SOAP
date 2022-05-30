package com.company;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.File;
import java.util.Date;

@WebService(endpointInterface = "com.company.ISoap")
public class SOAP implements ISoap {

    @WebMethod
    public Date whatTimeIsItNow() {
        System.out.println("Server process SOAP whatTimeIsItNow() request.");
        return new Date();
    }

    @WebMethod
    public String[] ls(String dir) {
        System.out.println("Server process SOAP ls() request.");
        return new File(dir).list();
    }
}