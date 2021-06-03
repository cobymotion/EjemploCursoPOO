package control;

import exceptions.CantidadInicialException;
import java.util.InputMismatchException;
import modelo.Cuenta;
import java.util.Scanner;


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
        String nombreTitular = ""; 
        boolean ban = false; 
        do{
            try{
                System.out.println("Proporciona el nombre de la persona:");
                nombreTitular = new Scanner(System.in).nextLine();
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
                c1 = new Cuenta(nombreTitular, cantidadInicial); // objeto   
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
            System.out.println("1)Hacer un deposito");
            System.out.println("2)Retiirar donero de la cuenta");
            System.out.println("3)Deshabilitar cuenta");
            System.out.println("4)Habilitar cuenta");
            System.out.println("5)Mostrar detalles de la cuenta");
            System.out.println("6)Salir");
            opc = new Scanner(System.in).nextInt(); 
            switch(opc){
                case 1: 
                    System.out.println("Dame la cantidad a depositar");
                    int depositar = new Scanner(System.in).nextInt(); 
                    try {
                        System.out.println("Su saldo: " + c1.deposito(depositar));
                    }catch(CantidadInicialException ex){
                        System.out.println(ex.getMessage());
                    }
                    break; 
                case 2:
                    System.out.println("Dame la cantidad a retirar");
                    int retiro = new Scanner(System.in).nextInt(); 
                    try {
                        System.out.println("Su saldo: " + c1.retiro(retiro));
                    }catch(CantidadInicialException ex){
                        System.out.println(ex.getMessage());
                    }
                    break; 
                case 3:
                    System.out.println(c1.deshabilitar()
                            ?"Se deshabilito la cuenta":
                            "Error: La cuenta ya esta deshabilitada");   
                    break;
                case 4:
                    System.out.println(c1.habilitar()
                            ?"Se habilito la cuenta":
                            "Error: La cuenta ya esta habilitada");
                    break;
                case 5: 
                    System.out.println(c1.getDetallesCuenta());
                    break; 
                case 6: 
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción Inválida");
            }
            
        }while(opc!=6); 
        
    }
    
}
