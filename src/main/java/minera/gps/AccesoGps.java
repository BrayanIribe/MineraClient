/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minera.gps;

import minera.modelo.ResultadoGps;

/**
 *
 * @author braya
 */
public class AccesoGps implements InterfazAccesoGps {

    private static AccesoGps accesoGps;
    
    public static AccesoGps GetSingleton(){
        if (accesoGps == null){
            accesoGps = new AccesoGps();
        }
        return accesoGps;
    }
    
    @Override
    public ResultadoGps obtenerPosicion() {
        ResultadoGps gps = new ResultadoGps();
        gps.latitud = 27.492956427560216;
        gps.longitud = -109.97117251271976;
        gps.radio = 1.0d;
        return gps;
    }

}
