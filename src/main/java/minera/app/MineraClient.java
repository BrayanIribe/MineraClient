/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package minera.app;

import minera.cliente.Cliente;
import minera.gps.AccesoGps;
import minera.http.HttpProvider;
import minera.http.HttpResult;
import minera.modelo.ResultadoGps;

/**
 *
 * @author braya
 */
public class MineraClient {

    public static void main(String[] args) {
        System.out.println("Minera client developed in Java for vehicles & payload registration.\n\n");
        System.out.println("[*] Checking if Minera restful server is running...");
        if (!Cliente.GetSingleton().ServidorDisponible()){
            System.out.println("[-] Minera restful server IS NOT RUNNING. Check http://localhost:8080/status result for more info.");
            return;
        }
        
        System.out.println("[+] Minera restful server is running!");
        System.out.println("===================================\n");
        
        while(true){
            try{
            ResultadoGps gps = AccesoGps.GetSingleton().obtenerPosicion();
            System.out.printf("[*] Sending ITSON position.\nLat: %.6f\nLng: %.6f\nRad: %.6f\n", gps.latitud, gps.longitud, gps.radio);
            Boolean result = Cliente.GetSingleton().RegistrarPosicion("WAX384-1", gps);
            if (result){
                System.out.println("[+] Registered ITSON position on Minera server.");
            }else{
                System.out.println("[-] Could not register ITSON position on Minera server.");
            }
            Thread.sleep(5000);
            }catch(Exception e){
                System.out.println("[EX] " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
