/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LUIS
 */
public class Detalle {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    Alquiler al = new Alquiler();
    public void IngresarDetalle(clsDetalle de){
        try {
            PreparedStatement pst = con.prepareStatement("insert into detalle(detalle_num_can,pelicula_num_cod,detalle_double_importeBruto,alquiler_num_cod) values (?,?,?,?)");
            pst.setString(1,de.getDetalle_num_can());
            pst.setString(2,de.getPelicula_num_cod());
            pst.setString(3,de.getDetalle_double_importeBruto());
            pst.setString(4,String.valueOf(al.ObtenerAlquiler()));
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Datos : " + e.getMessage());
        }
    }
    public int SumaDetalle(String a){
        int b =0;
        try {
            PreparedStatement pst = con.prepareStatement("select sum(detalle_double_importeBruto) from detalle where alquiler_num_cod='" + a + "'");
            rs = pst.executeQuery();
            while(rs.next()){
            b = rs.getInt(1);
        }
        } catch (Exception e) {
            System.out.println("ERROR AL SUMAR DETALLE : " + e.getMessage());
        }
        return b;
    }
}
