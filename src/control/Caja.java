package control;

import exceptions.CantidadInicialException;
import java.util.InputMismatchException;
import modelo.Cuenta;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite interactuar con el sistema bancario
 * @author luiscobian
 */
public class Caja {
    // no atributos
    public static void main(String[] args) {
        System.out.println("Iniciando mi aplicación");
        System.out.println("Creando cuenta");
        
        double cantidadInicial = 0;
        boolean ban = false; 
        do{
            try{
                System.out.println("Proporciona la cantidad con la que se abrira la cuenta:");
                cantidadInicial = new Scanner(System.in).nextDouble(); 
                ban = false; 
                if(cantidadInicial<0)
                    throw new CantidadInicialException(); // obligar a lanzar exception
            }catch(InputMismatchException ex){
                System.out.println("Numero incorrecto");
                ban = true; 
            }catch(CantidadInicialException ex2){
                System.out.println(ex2.getMessage());
                ban = true;
            }
        }while(ban);
        // pedir cuenta : cantidad try catch
        ban = false; 
        Cuenta c1 = null; 
        do{ // segunda validacion 
            
            try {
                c1 = new Cuenta(cantidadInicial); // objeto   
                ban = false;
            } catch (CantidadInicialException ex) {
                ban = true; 
                System.out.println("Proporciona la cantidad con la que se abrira la cuenta:");
                cantidadInicial = new Scanner(System.in).nextDouble();
            }            
        }while(ban);
        int opc=0;        
        do{
            System.out.println("Menu");
            System.out.println("1)Depositar");
            System.out.println("2)Retirar");
            System.out.println("3)Mostrar saldo");
            System.out.println("4)Salir");
            opc = new Scanner(System.in).nextInt(); 
            switch(opc){
                case 1: 
                    c1.deposito();
                    break; 
                case 2:
                    c1.retiro();
                    break; 
                case 3:
                    System.out.println("Saldo: " + c1.getCuenta());
                    break; 
                case 4:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción Inválida");
            }
            
        }while(opc!=4); 
        
    }
    
}
