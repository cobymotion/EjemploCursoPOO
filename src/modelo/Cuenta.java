package modelo;

import exceptions.CantidadInicialException;

/**
 * Clase para manejar las operaciones con la cuenta
 * @author luiscobian
 */
public class Cuenta {
    
    private double cuenta;  // atributo para almacenar el saldo
    
    public Cuenta(double cuenta) throws CantidadInicialException{
        if(cuenta < 0)
            throw  new CantidadInicialException();
        this.cuenta = cuenta;
    } 

    //aumenta el saldo en 100 
    public void deposito(){        
        cuenta += 100;
        System.out.println("Saldo: " + this.cuenta);
    }
    //disminuye el saldo en 100 
    public void retiro(){
        this.cuenta -=100; 
        System.out.println("Saldo: " + cuenta);
    }
    
    
    public double getCuenta(){
        return cuenta;
    }
    
}
