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
        System.out.println("Bienveinido al juego ENTRE100");
        System.out.println("Ingrese '1' para elegir el modo 'Adivina el numero la persona.'");
        System.out.println("Ingrese '2' para elegir el modo 'Adivina el numero la maquina.'");
        Calculo calculo= new Calculo();
        Scanner lector=new Scanner(System.in); 
        int valorPantalla=lector.nextInt();
        if(valorPantalla==1){
            //La maquina crea un numero y el flaco tiene que averiguar cual es.
            Random r= new Random();
            int valorAdivinar=r.nextInt(100);
            System.out.println("Cuál es el numero?");
            calculo.jugarPc(valorAdivinar);
        }
        else 
        if(valorPantalla==2){
            //En esta ocasion la maquina intentará adivinar el numero que pensó el humano.
            calculo.jugarMaquina();
            System.out.println("Adiviné tu número, humano!");
        }
    }
    
            
}
