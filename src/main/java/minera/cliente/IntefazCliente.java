/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package minera.cliente;

import minera.modelo.ResultadoGps;

/**
 *
 * @author braya
 */
public interface IntefazCliente {
    
    public boolean ServidorDisponible();
    public boolean RegistrarPosicion(String matricula, ResultadoGps gps);
    
}
