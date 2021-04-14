package com;

/**
 * Clase para manejar las operaciones con la cuenta
 * @author luiscobian
 */
public class Cuenta {
    
    double cuenta;  // atributo para almacenar el saldo
    //aumenta el saldo en 100 
    public void deposito(){
        cuenta += 100;
        System.out.println("Saldo: " + cuenta);
    }
    //disminuye el saldo en 100 
    public void retiro(){
        cuenta -=100; 
        System.out.println("Saldo: " + cuenta);
    }
    
}
