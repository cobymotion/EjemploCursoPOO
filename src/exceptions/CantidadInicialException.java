package exceptions;

public class CantidadInicialException extends Exception {
    
    public CantidadInicialException(){
        super("La cantidad no puede ser menor a cero");
    }
    
}
