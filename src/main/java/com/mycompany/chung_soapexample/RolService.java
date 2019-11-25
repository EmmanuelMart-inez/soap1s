/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chung_soapexample;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


import com.mycompany.chung_soapexample.Rol;
import com.mycompany.chung_soapexample.RolDAO;
import java.util.List;
/**
 *
 * @author dell
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RolService {
    
    @WebMethod
    public boolean addRol(Rol r);
    
    @WebMethod
    public boolean deleteRol(Rol r);

    @WebMethod
    public boolean updateRol(Rol r);
    
    @WebMethod
    public Rol getRol(Rol r);
    
    @WebMethod
    public Rol[] getAllRoles();
    
}
