/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package computacionevolutiva.evolutivios;

import computacionevolutiva.Funciones;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jhh
 */
public class OperacionesGenetico extends OperacionesGeneticoInterface{
    Random aleat = new Random();
    @Override
    public ArrayList<Genoma> cruce(ArrayList<Genoma> padres) {
        Genoma[] arrayhijos = new Genoma[2]; //Par de hijos cada par de padres
        ArrayList<Genoma> hijos = new ArrayList<>(padres.size());
            for(int i = 0; i < padres.size(); i=i+2){
                double random = Math.random();// generamos un numero al azar entre 0 y 1
                if(random < 0.6){  //Probabilidad de cruce 60%
                    int puntoCorte = 1 + aleat.nextInt(padres.get(i).tamGen-1);
                    arrayhijos = generarHijos(padres.get(i), padres.get(i+1),puntoCorte);
                    //Aplicar mutaciones a los hijos
                    hijos.add(arrayhijos[0]);
                    hijos.add(arrayhijos[1]);
                } else{
                    //Aplicar mutaciones a los hijos
                    hijos.add(new Genoma(padres.get(i).cadena,padres.get(i).funcionFitness, padres.get(i).restricciones));
                    hijos.add(new Genoma(padres.get(i+1).cadena,padres.get(i+1).funcionFitness, padres.get(i+1).restricciones));
                }
            }
        
        return hijos;
    }

    public Genoma[] generarHijos(Genoma padre1, Genoma padre2, int puntoCorte) { //Genera los nuevos hijos y mutacion de los mismos
        double[] hijo1, hijo2;
        if (!(padre1.cadena.length == padre2.cadena.length)) {
            return new Genoma[]{null,null};
        }
        hijo1 = new double[padre1.cadena.length];
        hijo2 = new double[padre2.cadena.length];
        for(int i = 0; i < puntoCorte; i++){
            hijo1[i] = padre1.cadena[i];
            hijo2[i] = padre2.cadena[i];
        }
        for(int i = puntoCorte; i < padre1.cadena.length; i++){
            hijo1[i] = padre2.cadena[i];
            hijo2[i] = padre1.cadena[i];
        }
        
        return new Genoma[]{new Genoma(hijo1,padre1.funcionFitness,padre1.restricciones),new Genoma(hijo2,padre2.funcionFitness,padre2.restricciones)};
    }
    
    public ArrayList<Genoma> mutacion(ArrayList<Genoma> genMutar, double probMutacion){
        ArrayList<Genoma> poblacionMutada = new ArrayList<Genoma>();
        double randomProbMutacion;
        double randomProbOperador = 0;
        for(Genoma gen : genMutar){
            for(int i = 0; i < gen.tamGen; i++){
                randomProbMutacion = Math.random();// generamos un numero al azar entre 0 y 1
                if(randomProbMutacion < probMutacion)
                    randomProbOperador = Math.random();// generamos mutacion de operadores +10 o -10
                    if(randomProbOperador <= 0.5){
                        gen.cadena[i] = (gen.cadena[i] - 10) % gen.restricciones[0] ;
                    } else{
                        gen.cadena[i] = (gen.cadena[i] + 10) % gen.restricciones[1];
                    }
            }
            poblacionMutada.add(new Genoma(gen.cadena, gen.funcionFitness,gen.restricciones));
        }
        return poblacionMutada;
    }

    @Override
    public ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, String metodoSeleccion) {
        ArrayList<Genoma> seleccionados;
        switch (metodoSeleccion){
            case ("Torneo"):
                seleccionados = new ArrayList<Genoma>(torneo(poblacion));
                break;
            case ("Ruleta"):
                seleccionados = new ArrayList<Genoma>(ruleta(poblacion));
                break;
            case ("Ranking"):
                seleccionados = new ArrayList<Genoma>(ranking(poblacion));
                break;
            default:
                seleccionados = new ArrayList<Genoma>(poblacion);
        }
        return seleccionados;
    }
}
