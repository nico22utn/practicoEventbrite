/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 * Esta clase se va a encargar de los 2 modulos del juego
 */
public class Calculo {
    
    int bandera=0;
    String tipoBandera=null;
    int aleatorio=0;
    List<Integer> descartados=new ArrayList<>();
    
    public modoJuego elegirModo(String a){
        if(a.equals(modoJuego.PC.name())){
            System.out.println("MODO 'PC' elegido");
            return modoJuego.PC;
        }
        else 
        if(a.equals(modoJuego.PERSONA.name())){
            System.out.println("MODO 'PERSONA' elegido");
            System.out.println("Conteste a las preguntas con los siguientes simbolos..");
            System.out.println("Con '"+CalculoUtils.AUMENTAR+"' para indicar a la maquina que el numero a adivinar es mayor.");
            System.out.println("Con '"+CalculoUtils.DISMINUIR+"' para indicar a la maquina que el numero a adivinar es menor.");
            System.out.println("Con '"+CalculoUtils.IGUAL+"' para indicar que ha adivinado el numero.");
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
        if(bandera!=0 && tipoBandera!=null){
            evaluarBanderas(bandera, tipoBandera);
        }
        else{
            aleatorio=valorRandom();
        }
        System.out.println("Su numero es "+aleatorio+"?");
        String caracter=tomarValor();
        if(!caracter.equals(CalculoUtils.IGUAL)){
            if(caracter.equals(CalculoUtils.AUMENTAR) || caracter.equals(CalculoUtils.DISMINUIR)){
                bandera=aleatorio;
                descartados.add(bandera);
                tipoBandera=caracter;
            }
            else{
                System.out.println("Ingrese un caracter apropiado");
            }
            jugarMaquina();
        }
    }
    
    public int evaluarBanderas(int bandera, String tipoBandera){
        aleatorio=valorRandom();
        if(!descartados.contains(aleatorio)){
            if(tipoBandera.equals(CalculoUtils.AUMENTAR)){
                if(aleatorio<bandera){
                    evaluarBanderas(bandera, tipoBandera);
                }
        }
            if(tipoBandera.equals(CalculoUtils.DISMINUIR)){
                if(aleatorio>bandera){
                    evaluarBanderas(bandera, tipoBandera);
                }
            } 
        }
        else{
            evaluarBanderas(bandera, tipoBandera);
        }
        return aleatorio;
    }
    
    public int valorRandom(){
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
}
