/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author LUIS
 */
public class clsUsuario {
    private String usuario_txt_dni;
    private String usuario_txt_nom;
    private String usuario_txt_ape;
    private String usuario_bl_estado;
    private String rol_num_cod;

    public String getRol_num_cod() {
        return rol_num_cod;
    }

    public void setRol_num_cod(String rol_num_cod) {
        this.rol_num_cod = rol_num_cod;
    }
    

    public String getUsuario_txt_dni() {
        return usuario_txt_dni;
    }

    public void setUsuario_txt_dni(String usuario_txt_dni) {
        this.usuario_txt_dni = usuario_txt_dni;
    }

    public String getUsuario_txt_nom() {
        return usuario_txt_nom;
    }

    public void setUsuario_txt_nom(String usuario_txt_nom) {
        this.usuario_txt_nom = usuario_txt_nom;
    }

    public String getUsuario_txt_ape() {
        return usuario_txt_ape;
    }

    public void setUsuario_txt_ape(String usuario_txt_ape) {
        this.usuario_txt_ape = usuario_txt_ape;
    }

    public String getUsuario_bl_estado() {
        return usuario_bl_estado;
    }

    public void setUsuario_bl_estado(String usuario_bl_estado) {
        this.usuario_bl_estado = usuario_bl_estado;
    }
    
}
