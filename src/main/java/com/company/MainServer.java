package com.company;

import javax.xml.ws.Endpoint;

import static com.company.Const.URL;

public class MainServer {
    public static void main(String[] args) {
        Endpoint.publish(URL, new SOAP());
        System.out.println("Server started.");
    }
}