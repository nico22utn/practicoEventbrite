/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvenido al juego ENTRE100");
        System.out.println("Ingrese '"+CalculoUtils.MODO_PERSONA+"' para elegir el modo 'Adivina el numero la persona.'");
        System.out.println("Ingrese '"+CalculoUtils.MODO_PC+"' para elegir el modo 'Adivina el numero la maquina.'");
        Calculo calculo= new Calculo();
        Scanner lector=new Scanner(System.in); 
        String valorPantalla=lector.next();
        if(valorPantalla.equals(CalculoUtils.MODO_PERSONA)){
            //La maquina crea un numero y elda flaco tiene que averiguar cual es.
            System.out.println("MODO '"+CalculoUtils.MODO_PERSONA+"' elegido");
            Random r= new Random();
            int valorAdivinar=r.nextInt(100);
            System.out.println("Cuál es el numero?");
            calculo.jugarPc(valorAdivinar);
        }
        else 
        if(valorPantalla.equals(CalculoUtils.MODO_PC)){
            //En esta ocasion la maquina intentará adivinar el numero que pensó el humano.
            //Instrucciones
            System.out.println("MODO '"+CalculoUtils.MODO_PC+"' elegido");
            System.out.println("Conteste a las preguntas con los siguientes simbolos..");
            System.out.println("Con '"+CalculoUtils.AUMENTAR+"' para indicar a la maquina que el numero a adivinar es mayor.");
            System.out.println("Con '"+CalculoUtils.DISMINUIR+"' para indicar a la maquina que el numero a adivinar es menor.");
            System.out.println("Con '"+CalculoUtils.IGUAL+"' para indicar que ha adivinado el numero.");
            boolean resultado=calculo.jugarMaquina();
            if(resultado){
                System.out.println("Adiviné tu número, humano!");
            }
            else{
                System.out.println("Ya deberia haber sido adivinado tu numero.");
            }
        }
        else{
            System.out.println("Modo no habilitado.");
        }
    }
    
            
}
