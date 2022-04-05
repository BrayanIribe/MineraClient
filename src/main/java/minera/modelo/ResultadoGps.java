/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minera.modelo;

import org.json.JSONObject;

/**
 *
 * @author braya
 */
public class ResultadoGps {
    
    public Double longitud;
    public Double latitud;
    public Double radio;
    
    public JSONObject serialize(){
        JSONObject json = new JSONObject();
        json.put("longitud", longitud);
        json.put("latitud", latitud);
        json.put("radio", radio);
        return json;
    }
}
