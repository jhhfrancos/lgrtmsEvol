/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package computacionevolutiva.evolutivios;


import computacionevolutiva.Funciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Jhh
 */
public abstract class OperacionesGeneticoInterface {
    
    public abstract ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, Funciones fitness);
    public abstract ArrayList<Genoma> cruce(ArrayList<Genoma> padres);
    public abstract Genoma[] generarHijos(Genoma padre1, Genoma padre2);
    public double mejorFitness(ArrayList<Genoma> poblacion, Funciones fitness){
        //TODO
        return 0;
    }
    public ArrayList<Genoma> torneo(ArrayList<Genoma> poblacion, Funciones fitness){
        ArrayList<Genoma> seleccionados = new ArrayList<>();
        int tamano = poblacion.size();
        for (int i = 0; i < tamano; i++) {
            //según n(tamaño) individuos de la población se hace n torneos para seleccionar n padres
            ArrayList<Genoma> muestreo = selAleatoria(poblacion,16); // 16 es el número de muestreo para cada los n torneos, 16individuos participan cada torneo
            seleccionados.add(torneoRecursivo(muestreo.subList(0, muestreo.size())));
        }
        return new ArrayList<Genoma>(seleccionados);
    }
    private ArrayList<Genoma> selAleatoria(ArrayList<Genoma> poblacion,int tamano){
        ArrayList<Genoma> muestra = new ArrayList<>();
        for(int i=0; i<tamano; i++){
            muestra.add(poblacion.get((int) (Math.random()*poblacion.size()))); //selecciona aleatoriamente un individuo de la población
        }
        return muestra;
    }
    private Genoma torneoRecursivo(List<Genoma> muestra){
        Genoma uno, dos;
        if(muestra.size()>2){
            uno = torneoRecursivo(muestra.subList(0, muestra.size()/2));
            dos = torneoRecursivo(muestra.subList(muestra.size()/2, muestra.size()));
        }else {
            uno = muestra.get(0);
            dos = muestra.get(1);
        }
        double prob1 = (double)uno.fitness/(double)(uno.fitness+dos.fitness);
        if(Math.random()< prob1)return uno;
        else return dos;
    }
    public ArrayList<Genoma> ranking(ArrayList<Genoma> poblacion, Funciones fitness){
        ArrayList<Genoma> seleccionados1 = poblacion;
        int tamano = poblacion.size();
        Collections.sort(seleccionados1, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Genoma i1 = (Genoma) o1;
                    Genoma i2 = (Genoma) o2;
                    return new Double(i2.fitness).compareTo(new Double(i1.fitness));
                }
            });
        
        ArrayList<Genoma> seleccionados = new ArrayList<Genoma>();
        while(tamano>0) {  //según n (tamaño) padres a seleccionar de la población se hace n lanzamientos de la ruleta.
            int sel = (int) (Math.random()*poblacion.size());
            Genoma individuo = poblacion.get(sel);
            if(Math.random()< 1.0 / (double)(double)Math.pow(2, sel)){
                seleccionados.add(individuo);
                tamano--;
            }
        }
        return new ArrayList<Genoma>(seleccionados);
    }
    public ArrayList<Genoma> ruleta(ArrayList<Genoma> poblacion, Funciones fitness){
        ArrayList<Genoma> seleccionados = new ArrayList<>();
        int tamano = poblacion.size();
        while(tamano>0) {  //según n (tamaño) padres a seleccionar de la población se hace n lanzamientos de la ruleta.
            Genoma gen = poblacion.get((int) (Math.random()*poblacion.size()));
            if(Math.random()< ((double)gen.fitness) / (double)mejorFitness(poblacion, fitness)){
                seleccionados.add(gen);
                tamano--;
            }
        }
        return new ArrayList<Genoma>(seleccionados);
    }
    
    
}

