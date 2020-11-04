/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsPelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author LUIS
 */
public class Pelicula {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    
    public void IngresarPelicula(clsPelicula pe){
        try {
            PreparedStatement pst = con.prepareStatement("insert into pelicula(pelicula_txt_nom,pelicula_txt_sipnosis,pelicula_num_existencia,pelicula_double_precio,genero_num_cod) values (?,?,?,?,?)");
            pst.setString(1,pe.getPelicula_txt_nom());
            pst.setString(2,pe.getPelicula_txt_sipnosis());
            pst.setString(3,pe.getPelicula_num_existencia());
            pst.setString(4,pe.getPelicula_double_precio());
            pst.setString(5,pe.getGenero_num_cod());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Pelicula : "+  e.getMessage());
        }
    }
    
    public void ModificarPelicula(String a,String b,String c,Double d,String f){
        try {
            PreparedStatement pst = con.prepareStatement("update pelicula set pelicula_txt_nom= '" + a + "', pelicula_txt_sipnosis='" + b + "',pelicula_num_existencia='" + c + "', pelicula_double_precio='" + d + "' where pelicula_num_cod='" + f + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar pelicula : " + e.getMessage());
        }
    }
        public void ModificarExistencias(String b){
            int c = 0;
            try {
                PreparedStatement pst = con.prepareStatement("select * from pelicula");
                rs = pst.executeQuery();
                while(rs.next()){
                    c = rs.getInt("pelicula_num_existencia");
                }
            } catch (Exception e) {
                System.out.println("Error al Mostrar Existencias : " + e.getMessage());
            }
            c = c - 1;
            try {
                PreparedStatement pst = con.prepareStatement("update pelicula set pelicula_num_existencia='" + c + "' where pelicula_num_cod='" + b + "'");
                pst.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al Modificar Existencias : " + e.getMessage());
            }
    }
}
