/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chung_soapexample;

/**
 *
 * @author dell
 */
import javax.xml.ws.Endpoint;



public class Main {
   /**
    * @param args
    */
   public static void main() {
      //Endpoint.publish("http://localhost:8080/UnWebService", new UnWebService());
      Endpoint.publish("http://localhost:8081/UnnWebService2", new RolServiceImpl());
   }
}