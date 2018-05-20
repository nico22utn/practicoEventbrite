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

    public void jugarPc(int valorAdivinar){
       
        try {
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
        catch(NumberFormatException e){
            System.out.println("Caracter no valido. Fin Aplicacion.");
        }
    }
    public boolean jugarMaquina(){
        try {
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
                tipoBandera=caracter;
                descartar();
            }
            else{
                System.out.println("Ingrese un caracter apropiado");
            }
            return jugarMaquina();
        }
        }
        catch(StackOverflowError e){
           return false;
        }
        return true;
    }
    
    public int evaluarBanderas(int bandera, String tipoBandera) throws StackOverflowError{
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
    public void descartar(){
        if(tipoBandera.equals(CalculoUtils.AUMENTAR)){
            for(int i=0;i<=bandera;i++)
                if(!descartados.contains(i)){
                    descartados.add(i);
                }
        }
        else 
            if(tipoBandera.equals(CalculoUtils.DISMINUIR)){
            for(int i=bandera;i<100;i++){
                if(!descartados.contains(i)){
                    descartados.add(i);
                }
            }
        }
    }
    public  String tomarValor(){
        Scanner lector=new Scanner(System.in);
        return lector.next();
    }

}
