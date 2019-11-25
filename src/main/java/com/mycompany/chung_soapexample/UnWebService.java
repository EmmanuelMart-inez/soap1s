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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@WebService
@SOAPBinding(style = Style.RPC)
public class UnWebService {
   @WebMethod
   public double suma(double a, double b) {
      return a + b;
   }
   @WebMethod
   public double resta(double a, double b){
      return a - b; 
   }
   @WebMethod
   public Rol create(int idd){
      Rol c = new Rol();
       RolDAO cdao = new RolDAO();
       c.setIdRol(6);
       try {
           return cdao.read(c);
       } catch (SQLException ex) {
       }
       return c;
  } 
}