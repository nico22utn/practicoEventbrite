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
public class Calculo {
    
    int bandera=0;
    CaracterJuegoPC tipoBandera=null;
    
    public modoJuego elegirModo(String a){
        if(a.equals(modoJuego.PC.name())){
            System.out.println("MODO 'PC' elegido");
            return modoJuego.PC;
        }
        else 
        if(a.equals(modoJuego.PERSONA.name())){
            System.out.println("MODO 'PERSONA' elegido");
            System.out.println("Conteste a las preguntas con los siguientes simbolos..");
            System.out.println("Con '+' para indicar a la maquina que el numero a adivinar es mayor.");
            System.out.println("Con '-' para indicar a la maquina que el numero a adivinar es menor.");
            System.out.println("Con '=' para indicar que ha adivinado el numero.");
            return modoJuego.PERSONA;
        }
        return null;
    }
    public void jugarPc(int valorAdivinar){
       
        int valorTomado=new Integer(tomarValor());
            if(valorTomado<valorAdivinar){
                System.out.println("El valor a adivinar es mayor que el que ingresaste.");
                jugarPc(valorAdivinar);
            }
            if(valorTomado>valorAdivinar){
                System.out.println("El valor a adivinar es menor que el que ingresaste.");
                jugarPc(valorAdivinar);
            }
            if(valorTomado==valorAdivinar){
                System.out.println("Adivinaste!");
            }
    }
    public void jugarMaquina(){
        int aleatorio=0;
        if(bandera!=0 && tipoBandera!=null){
            evaluarBanderas(bandera, tipoBandera);
        }
        else{
            aleatorio=valorRandom();
        }
        System.out.println("Su numero es "+aleatorio+"?");
        String caracter=tomarValor();
        if(!caracter.equals(CaracterJuegoPC.IGUAL.name())){
            if(caracter.equals(CaracterJuegoPC.AUMENTAR.name()) || caracter.equals(CaracterJuegoPC.DISMINUIR.name())){
                bandera=aleatorio;
                tipoBandera=CaracterJuegoPC.valueOf(caracter);
            }
            else{
                System.out.println("Ingrese un caracter apropiado");
            }
            jugarMaquina();
        }
        System.out.println("Adiviné tu número, humano.");
        
    }
    
    public int evaluarBanderas(int bandera, CaracterJuegoPC tipoBandera){
        int aleatorio=valorRandom();
        if(tipoBandera.equals(CaracterJuegoPC.AUMENTAR)){
            if(aleatorio<bandera){
                evaluarBanderas(bandera, tipoBandera);
            }
        }
        if(tipoBandera.equals(CaracterJuegoPC.DISMINUIR)){
            if(aleatorio>bandera){
                evaluarBanderas(bandera, tipoBandera);
            }
        }
        return aleatorio;
    }
    
    private int valorRandom(){
        Random r=new Random();
        return r.nextInt(100);
    }
    public  String tomarValor(){
        Scanner lector=new Scanner(System.in);
        return lector.next();
    }
    public enum modoJuego{
        PC,PERSONA
    }
    public enum CaracterJuegoPC{
        AUMENTAR("+"),DISMINUIR("-"),IGUAL("=");

        private final String simbolo;
        CaracterJuegoPC(String car) {
        this.simbolo=car;    
        }

        public String getSimbolo() {
            return simbolo;
        }
    }
}
