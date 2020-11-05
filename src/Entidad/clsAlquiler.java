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
public class clsAlquiler {
    private String alquiler_num_cod;
    private String alquiler_double_neto;
    private String tarjeta_num_cod;
    private String alquiler_date_fechaPres;
    private String alquiler_date_fechaDe;

    public String getAlquiler_date_fechaPres() {
        return alquiler_date_fechaPres;
    }

    public void setAlquiler_date_fechaPres(String alquiler_date_fechaPres) {
        this.alquiler_date_fechaPres = alquiler_date_fechaPres;
    }

    public String getAlquiler_date_fechaDe() {
        return alquiler_date_fechaDe;
    }

    public void setAlquiler_date_fechaDe(String alquiler_date_fechaDe) {
        this.alquiler_date_fechaDe = alquiler_date_fechaDe;
    }
    

    public String getAlquiler_num_cod() {
        return alquiler_num_cod;
    }

    public void setAlquiler_num_cod(String alquiler_num_cod) {
        this.alquiler_num_cod = alquiler_num_cod;
    }

    public String getAlquiler_double_neto() {
        return alquiler_double_neto;
    }

    public void setAlquiler_double_neto(String alquiler_double_neto) {
        this.alquiler_double_neto = alquiler_double_neto;
    }

    public String getTarjeta_num_cod() {
        return tarjeta_num_cod;
    }

    public void setTarjeta_num_cod(String tarjeta_num_cod) {
        this.tarjeta_num_cod = tarjeta_num_cod;
    }
    
    
}
