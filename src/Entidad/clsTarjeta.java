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
public class clsTarjeta {
    private String tarjeta_num_cod;
    private String tarjeta_double_saldo;
    private String tarjeta_txt_pass;
    private String tarjeta_bl_estado;
    private String usuario_txt_dni;

    public String getTarjeta_num_cod() {
        return tarjeta_num_cod;
    }

    public void setTarjeta_num_cod(String tarjeta_num_cod) {
        this.tarjeta_num_cod = tarjeta_num_cod;
    }

    public String getTarjeta_double_saldo() {
        return tarjeta_double_saldo;
    }

    public void setTarjeta_double_saldo(String tarjeta_double_saldo) {
        this.tarjeta_double_saldo = tarjeta_double_saldo;
    }

    public String getTarjeta_txt_pass() {
        return tarjeta_txt_pass;
    }

    public void setTarjeta_txt_pass(String tarjeta_txt_pass) {
        this.tarjeta_txt_pass = tarjeta_txt_pass;
    }

    public String getTarjeta_bl_estado() {
        return tarjeta_bl_estado;
    }

    public void setTarjeta_bl_estado(String tarjeta_bl_estado) {
        this.tarjeta_bl_estado = tarjeta_bl_estado;
    }

    public String getUsuario_txt_dni() {
        return usuario_txt_dni;
    }

    public void setUsuario_txt_dni(String usuario_txt_dni) {
        this.usuario_txt_dni = usuario_txt_dni;
    }
    
    
}
