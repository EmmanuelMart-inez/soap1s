/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chung_soapexample;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */

@XmlRootElement
public class Rol implements Serializable{
    private int idRol;
    private String tipoRol;

    public Rol() {
    }

    public Rol(int idRol, String tipoRol) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", tipoRol=" + tipoRol + '}';
    }
    
    
}
