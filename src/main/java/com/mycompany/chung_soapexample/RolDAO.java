/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chung_soapexample;
import com.mycompany.chung_soapexample.Rol;
import com.mycompany.chung_soapexample.RolDAO;
/**
 *
 * @author dell
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author darkdestiny
 *
 */

public class RolDAO {

    private static final String SQL_INSERT
            = "{call spInsertar(?, ?)}";

    private static final String SQL_UPDATE
            = "{call spActualizar(?, ?)}";

    private static final String SQL_DELETE
            = "{call spBorrar(?)}";

    private static final String SQL_READ
            = "{call spLeer(?)}";

    private static final String SQL_READ_ALL
            = "{call spLeerTodo()}";

    private Connection con;

    public void create(Rol r) throws SQLException {

        obtenerConexion();

        CallableStatement cs = null;

        try {

            cs = con.prepareCall(SQL_INSERT);

            cs.setInt(1, r.getIdRol());

            cs.setString(2, r.getTipoRol());

            cs.executeUpdate();

        } finally {

            if (cs != null) {
                cs.close();
            }

            if (con != null) {
                con.close();
            }

        }

    }

    public void update(Rol r) throws SQLException {

        obtenerConexion();

        CallableStatement cs = null;

        try {

            cs = con.prepareCall(SQL_UPDATE);
            
            cs.setInt(1, r.getIdRol());

            cs.setString(2, r.getTipoRol());

            
            cs.executeUpdate();

        } finally {

            if (cs != null) {
                cs.close();
            }

            if (con != null) {
                con.close();
            }

        }

    }

    public void delete(Rol r) throws SQLException {

        obtenerConexion();

        CallableStatement cs = null;

        try {

            cs = con.prepareCall(SQL_DELETE);

            cs.setInt(1, r.getIdRol());

            
            cs.executeUpdate();

        } finally {

            if (cs != null) {
                cs.close();
            }

            if (con != null) {
                con.close();
            }

        }

    }

//    public List readAll() throws SQLException {
//
//        obtenerConexion();
//
//        CallableStatement cs = null;
//
//        ResultSet rs = null;
//
//        try {
//
//            cs = con.prepareCall(SQL_READ_ALL);
//
//            rs = cs.executeQuery();
//
//            List resultados = obtenerResultados(rs);
//
//            if (resultados.size() > 0) {
//
//                return resultados;
//
//            } else {
//
//                return null;
//
//            }
//
//        } finally {
//
//            if (cs != null) {
//                cs.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//
//        }
//
//    }
    public Rol[] readAll() throws SQLException {

        obtenerConexion();

        CallableStatement cs = null;

        ResultSet rs = null;

        try {

            cs = con.prepareCall(SQL_READ_ALL);

            rs = cs.executeQuery();

            List resultados = obtenerResultados(rs);

            if (resultados.size() > 0) {
                Rol[] array = new Rol[resultados.size()];
                resultados.toArray(array);
                //return resultados;
                return array;

            } else {

                return null;

            }

        } finally {

            if (cs != null) {
                cs.close();
            }

            if (con != null) {
                con.close();
            }

        }

    }

    public Rol read(Rol r) throws SQLException {
        System.out.println("bien conexion");
        obtenerConexion();
        System.out.println("bien conexion");
        CallableStatement cs = null;
        System.out.println("bien statement");
        ResultSet rs = null;

        try {
  System.out.println("bien 1");          
            cs = con.prepareCall(SQL_READ);
System.out.println("bien 2");
            cs.setInt(1, r.getIdRol());
            //cs.setInt(1, 2);
System.out.println("bien 3");
            rs = cs.executeQuery();
System.out.println("bien 4");
            List resultados = obtenerResultados(rs);
System.out.println("bien 5");
            if (resultados.size() > 0) {
                //System.out.println(resultados.get(0));
                return (Rol) resultados.get(0);

            } else {

                return null;

            }

        } finally {

            if (cs != null) {
                cs.close();
            }

            if (con != null) {
                con.close();
            }

        }

    }

    private void obtenerConexion() {
        String driverSQL = "com.mysql.jdbc.Driver";
        //String driverSQL = "com.mysql.cj.jdbc.Driver";
        String userDB = "root";
        String passwordDB = "root";
        String urlBD = "jdbc:mysql://localhost:3306/rolesdb";

        try {
            Class.forName(driverSQL);
            con = DriverManager.getConnection(urlBD,
                    userDB, passwordDB);
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }


    private List obtenerResultados(ResultSet rs)
            throws SQLException {

        List resultados = new ArrayList();

        while (rs.next()) {

            Rol r = new Rol();

            r.setIdRol(rs.getInt("id"));

            r.setTipoRol(rs.getString("tipo"));
            
            
            resultados.add(r);

        }

        return resultados;
    }

//    public static void main(String[] args) {
//       Rol c = new Rol();
//       RolDAO cdao = new RolDAO();
////       c.setIdRol(6);
////       c.setTipoRol("DBA");
////       System.out.println("bien setc");
//        try {
////            //cdao.read(c);
////            //cdao.create(c);
////            //cdao.update(c);
////            //cdao.delete(c);
//            System.out.println(cdao.readAll()[6].toString());
////            System.out.println("bien try");
//        } catch (SQLException ex) {
//        }
//    }
}
