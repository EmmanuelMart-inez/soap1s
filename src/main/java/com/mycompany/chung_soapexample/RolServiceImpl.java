/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chung_soapexample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

import com.mycompany.chung_soapexample.Rol;
import com.mycompany.chung_soapexample.RolDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
@WebService(endpointInterface = "com.mycompany.chung_soapexample.RolService")
public class RolServiceImpl implements RolService {

    private static Map<Integer, Rol> roles = new HashMap<Integer, Rol>();
    private RolDAO rdao = new RolDAO();

    @Override
    public boolean addRol(Rol r) {
//        if(roles.get(r.getIdRol()) != null) return false;
//		roles.put(r.getIdRol(), r);
//		return true;
        try {
        rdao.create(r);
        return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
       
    @Override
    public boolean deleteRol(Rol r) {
//        if (roles.get(id) == null) {
//            return false;
//        }
//        roles.remove(id);
//        return true;
        try {
        rdao.delete(r);
        return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    @Override
    public boolean updateRol(Rol r) {
//        if(roles.get(r.getIdRol()) != null) return false;
//		roles.put(r.getIdRol(), r);
//		return true;
        try {
        rdao.update(r);
        return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    //public Rol getRol(int id) {
    public Rol getRol(Rol r) {
        try {
            //return roles.get(id);
            return rdao.read(r);
        } catch (SQLException ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Rol[] getAllRoles() {
//        Set<Integer> ids = roles.keySet();
//        Rol[] r = new Rol[ids.size()];
//        int i = 0;
//        for (Integer id : ids) {
//            r[i] = roles.get(id);
//            i++;
//        }
//        return r;
//    }
        try {
            return rdao.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
