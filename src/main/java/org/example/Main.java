package org.example;

import javax.xml.ws.Endpoint;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8090/FlightService", new FlightService());
        System.out.println("Service is published at http://localhost:8090/FlightService?wsdl");
    }
}