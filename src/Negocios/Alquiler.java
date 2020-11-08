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
import java.sql.Date;
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
        public void ModificarEstado1(String a){
        try {
            PreparedStatement pst = con.prepareStatement("update alquiler set alquiler_bl_est='0' where tarjeta_num_cod='" + a + "'");
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
    public int ObtenerCodigoAlquiler(){
        int b=0;
        try {
            PreparedStatement pst = con.prepareStatement("select max(alquiler_num_cod) from alquiler where tarjeta_num_cod ='" + lo.codigo + "' and alquiler_bl_est='1'");
            rs = pst.executeQuery();
            while(rs.next()){
                b = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener codigo : " + e.getMessage());
        }
        return b;
    }
    public int ObtenerCodigoAlquiler1(){
        int b=0;
        try {
            PreparedStatement pst = con.prepareStatement("select max(alquiler_num_cod) from alquiler where tarjeta_num_cod ='" + lo.codigo + "' and alquiler_bl_est='0'");
            rs = pst.executeQuery();
            while(rs.next()){
                b = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener codigo : " + e.getMessage());
        }
        return b;
    }
    public void FechaPres(String a){
        try {
            PreparedStatement pst = con.prepareStatement("update alquiler set alquiler_date_fechaPres='" + a + "' where tarjeta_num_cod='" + lo.codigo + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Fecha Prestamo : " + e.getMessage());
        }
    }
    
    public String ObtenerFecha(){
        String b = "";
        try {
            PreparedStatement pst = con.prepareStatement("select max(alquiler_date_fechaPres) from alquiler where tarjeta_num_cod='" + lo.codigo + "' and alquiler_bl_est='1'");
            rs = pst.executeQuery();
            while(rs.next()){
                b = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener Fecha : " + e.getMessage());
        }
        return b;
    }
    
    public void ModificarFechaDe(String a){
        try {
            PreparedStatement pst = con.prepareStatement("update alquiler set alquiler_date_fechaDe='" + a + "' where tarjeta_num_cod='" + lo.codigo + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Modificar Fecha: " + e.getMessage());
        }
    }
    public String CantidadDias(){
        String b="";
        String c="";
        String e="";
        int d = ObtenerCodigoAlquiler();
        try {
            PreparedStatement pst = con.prepareStatement("select * from alquiler where alquiler_num_cod='" + d + "'");
            rs = pst.executeQuery();
            while(rs.next()){
                b = rs.getString("alquiler_date_fechaPres");
                c = rs.getString("alquiler_date_fechaDe");
            }
        } catch (Exception f) {
            System.out.println("Error al Encontrar dias : " + f.getMessage());
        }
        try {
            PreparedStatement pst = con.prepareCall("select DATEDIFF('" + c + "','" + b + "') from alquiler where alquiler_num_cod='" + d +"'");
            rs = pst.executeQuery();
            while(rs.next()){
                e = rs.getString(1);
            } 
        } catch (Exception f) {
            System.out.println("Error al Calcular Dias : " + f.getMessage());
        }
        System.out.println(c);
        System.out.println(b);
        System.out.println(e);
        return e;
    }
    public void ModificarPrecioNeto(String a){
        int b = ObtenerCodigoAlquiler();
        try {
            PreparedStatement pst = con.prepareStatement("update alquiler set alquiler_double_neto = '"+ a + "' where alquiler_num_cod='"+ b+ "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Modificar Fecha : " + e.getMessage());
        }
    }
}
