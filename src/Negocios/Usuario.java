/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LUIS
 */
public class Usuario {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    
    public void IngresarUsuario(clsUsuario us){
        try {
            PreparedStatement pst = con.prepareStatement("insert into usuario(usuario_txt_dni,usuario_txt_nom,usuario_txt_ape,rol_num_cod) values(?,?,?,?)");
            pst.setString(1,us.getUsuario_txt_dni());
            pst.setString(2,us.getUsuario_txt_nom());
            pst.setString(3,us.getUsuario_txt_ape());
            pst.setString(4,us.getRol_num_cod());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al ingresar usuario : " + e.getMessage());
        }
    }
    public void ModificarUsuario(String a,String b,String c){
        try {
            PreparedStatement pst = con.prepareStatement("update usuario set usuario_txt_nom='"+a+"', usuario_txt_ape = '" + b + "' where usuario_txt_dni='" + c + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar usuario : "+ e.getMessage());
        }
    }
    
    public ArrayList<clsUsuario> MostrarUsuario(){
        ArrayList<clsUsuario> us = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from usuario");
            rs = pst.executeQuery();
            while(rs.next()){
                clsUsuario u = new clsUsuario();
                u.setUsuario_txt_dni(rs.getString("usuario_txt_dni"));
                us.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error al Mostar Usuario : " + e.getMessage());
        }
        return us;
    }
}