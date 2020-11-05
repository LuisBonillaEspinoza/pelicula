/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsTarjeta;
import Presentacion.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LUIS
 */
public class Tarjeta {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    
    public void IngresoTarjeta(clsTarjeta tar){
        try {
            PreparedStatement pst = con.prepareStatement("insert into tarjeta(tarjeta_num_cod,tarjeta_double_saldo,tarjeta_txt_pass,usuario_txt_dni) values(?,?,?,?)");
            pst.setString(1,tar.getTarjeta_num_cod());
            pst.setString(2,tar.getTarjeta_double_saldo());
            pst.setString(3,tar.getTarjeta_txt_pass());
            pst.setString(4,tar.getUsuario_txt_dni());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Tarjeta : " + e.getMessage());
        }
    }
    public void ModificarTarjeta(Double a,String b,int c,String d){
        try {
            PreparedStatement pst = con.prepareStatement("update tarjeta set tarjeta_double_saldo = '" + a + "', tarjeta_txt_pass ='" + b + "', tarjeta_bl_est ='" + c + "' where tarjeta_num_cod = '" + d + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Modificar Tarjeta : " + e.getMessage());
        }
    }
    
    public void ModificarSaldo(Double a,String b){
        Double g=0.0;
        try {
            PreparedStatement pst = con.prepareStatement("select tarjeta_double_saldo from tarjeta where tarjeta_num_cod = '" + b + "'");
            rs = pst.executeQuery();
            while(rs.next()){
                g = rs.getDouble("tarjeta_double_saldo");
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Saldo");
        }
        g = g + a;
        try {
            PreparedStatement pst = con.prepareStatement("update tarjeta set tarjeta_double_saldo = '" + g + "' where tarjeta_num_cod = '" + b + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Modificar Saldo : " + e.getMessage());
        }
    }
    public void Pagar(Double a,String b){
        Double g=0.0;
         try {
            PreparedStatement pst = con.prepareStatement("select tarjeta_double_saldo from tarjeta where tarjeta_num_cod = '" + b + "'");
            rs = pst.executeQuery();
            while(rs.next()){
                g = rs.getDouble("tarjeta_double_saldo");
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Saldo");
        }
         g = g -a;
         try {
            PreparedStatement pst = con.prepareStatement("update tarjeta set tarjeta_double_saldo = '" + g + "' where tarjeta_num_cod = '" + b + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Modificar Saldo : " + e.getMessage());
        }
    }
    public Double ObtenerSaldo(){
        Double a =0.0;
        Login lo = new Login();
        try {
            PreparedStatement pst = con.prepareStatement("select * from tarjeta where tarjeta_num_cod='" + lo.codigo +"'");
            rs = pst.executeQuery();
            while(rs.next()){
                a = rs.getDouble("tarjeta_double_saldo");
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Saldo");
        }
        return a;
    }
}
