package modelo;

import exceptions.CantidadInicialException;
import java.util.UUID;

/**
 * Clase para manejar las operaciones con la cuenta
 * @author luiscobian
 */
public class Cuenta {
    private String numCuenta; 
    private String titular; 
    private boolean activa;             
    private double cuenta;  // atributo para almacenar el saldo
    
    public Cuenta(String titular, double cuenta) throws CantidadInicialException {
        if(cuenta < 0)
            throw  new CantidadInicialException();
        this.titular = titular;
        this.cuenta = cuenta;
        this.activa = true; 
        this.numCuenta = UUID.randomUUID().toString();
    } 

    //aumenta el saldo en 100 
    public double deposito(double cantidad) throws CantidadInicialException{   
        if(activa){ 
            cuenta += cantidad;
            return cuenta; 
        }
        else 
            throw new CantidadInicialException("La cuenta no esta activa");
    }
    
    //disminuye el saldo en 100 
    public double retiro(double cantidad) throws CantidadInicialException{
        if(!activa)
            throw new CantidadInicialException("La cuenta no esta activa");
        if(cantidad>cuenta)
            throw new CantidadInicialException("Saldo insuficiente");
        this.cuenta -=cantidad ; 
        return cuenta;
    }
    
    public double getCuenta(){
        return cuenta;
    }
    
    public boolean habilitar(){
        boolean cambio = true;
        if(!activa)
            activa = true; 
        else 
            cambio = false;
        return cambio; 
    }
    
    public boolean deshabilitar(){
        boolean cambio=true; 
        if(activa)
            activa = false;        
        else 
            cambio = false;
        return cambio; 
    }
    
    
    public boolean getEstatus(){        
        return activa; 
    }
    
    public String getDetallesCuenta(){        
        String detalles = ""; 
        if(activa)
            detalles = "Cuenta: " + numCuenta + "\nNombre: " + titular + "\nSaldo: $" + cuenta;
        else 
            detalles = "No esta activa";
        return detalles;
    }
    
}