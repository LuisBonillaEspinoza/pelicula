/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsGenero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LUIS
 */
public class Genero {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    
    public ArrayList<clsGenero> MostrarGenero(){
        ArrayList<clsGenero> gen = new ArrayList<clsGenero>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from genero");
            rs = pst.executeQuery();
            while(rs.next()){
                clsGenero ge = new clsGenero();
                ge.setGenero_txt_descrip(rs.getString("genero_txt_descrip"));
                gen.add(ge);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar genero : " + e.getMessage());
        }
        return gen;
    }
}
