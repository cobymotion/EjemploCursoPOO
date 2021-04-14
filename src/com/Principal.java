package com;

import java.util.Scanner;

/**
 * Clase que permite interactuar con el sistema bancario
 * @author luiscobian
 */
public class Principal {
    // no atributos
    public static void main(String[] args) {
        System.out.println("Iniciando mi aplicación");
        System.out.println("Creando cuenta");
        Cuenta c1 = new Cuenta(); // objeto 
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
                    System.out.println("Saldo: " + c1.cuenta);
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
