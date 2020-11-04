/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsAlquiler;
import Presentacion.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LUIS
 */
public class Alquiler {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    public void GenerarAlquiler(clsAlquiler al){
        try {
            PreparedStatement pst = con.prepareStatement("insert into alquiler(tarjeta_num_cod) values (?)");
            pst.setString(1,al.getTarjeta_num_cod());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Insertar Alquiler : " + e.getMessage());
        }
    }
    Login lo = new Login();
    public int ObtenerAlquiler(){
        int a=0;
        try {
            PreparedStatement pst = con.prepareStatement("select max(alquiler_num_cod) from alquiler where tarjeta_num_cod ='" + lo.codigo + "'");
            rs = pst.executeQuery();
            while(rs.next()){
                a = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER ALQUILER :  " + e.getMessage());
        }
        return a;
    }
    public void ModificarEstado(String a){
        try {
            PreparedStatement pst = con.prepareStatement("update alquiler set alquiler_bl_est='1' where tarjeta_num_cod='" + a + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Modificar Estado : "+ e.getMessage());
        }
    }
    public int ObtenerEstado(){
        int a = 0;
        try {
            PreparedStatement pst = con.prepareStatement("select * from alquiler where tarjeta_num_cod = '" + lo.codigo + "'");
            rs = pst.executeQuery();
            while(rs.next()){
                a = rs.getInt("alquiler_bl_est");
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener Estado");
        }
        return a;
    }
}
