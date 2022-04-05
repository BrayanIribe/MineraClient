/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minera.cliente;

import minera.http.HttpProvider;
import minera.http.HttpResult;
import minera.modelo.ResultadoGps;
import org.json.*;

/**
 *
 * @author braya
 */
public class Cliente implements IntefazCliente {

    private static Cliente cliente;
    
    public static Cliente GetSingleton(){
        if (cliente == null){
            cliente = new Cliente();
        }
        return cliente;
    }
    
    @Override
    public boolean ServidorDisponible() {
        HttpResult result = HttpProvider.Get("/status");
        if (result.responseCode != 200)
            return false;
        
        JSONObject j = new JSONObject(result.data);
        return j.getBoolean("ok") == true;
    }

    @Override
    public boolean RegistrarPosicion(String matricula, ResultadoGps gps) {
        String url = "/posiciones/" + matricula;
        HttpResult result = HttpProvider.Post(url, gps.serialize().toString());
        if (result.responseCode != 201)
            return false;
        
        JSONObject j = new JSONObject(result.data);
        return j.getBoolean("ok") == true;
    }
    
}
