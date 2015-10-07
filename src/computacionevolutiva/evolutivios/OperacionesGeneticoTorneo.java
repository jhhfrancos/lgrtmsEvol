/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package computacionevolutiva.evolutivios;

import computacionevolutiva.Funciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhh
 */
public class OperacionesGeneticoTorneo extends OperacionesGeneticoInterface{

    @Override
    public ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, Funciones fitness) {
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
    @Override
    public ArrayList<Genoma> cruce(ArrayList<Genoma> padres) {
        Genoma[] arrayhijos = new Genoma[2];
        ArrayList<Genoma> hijos = new ArrayList<>(padres.size());
        for(int i = 0; i < padres.size(); i=i+2){
            arrayhijos = generarHijos(padres.get(i), padres.get(i+1));
            hijos.add(arrayhijos[0]);
            hijos.add(arrayhijos[1]);
        }
        return hijos;
    }

    @Override
    public Genoma[] generarHijos(Genoma padre1, Genoma padre2) {
        int[] hijo1, hijo2;
        if (!(padre1.cadena.length == padre2.cadena.length)) {
            return new Genoma[]{null,null};
        }
        hijo1 = new int[padre1.cadena.length];
        hijo2 = new int[padre2.cadena.length];
        for(int i = 0; i < padre1.cadena.length/2; i++){
            hijo1[i] = padre1.cadena[i];
            hijo2[i] = padre2.cadena[i];
        }
        for(int i = padre1.cadena.length/2; i < padre1.cadena.length; i++){
            hijo1[i] = padre2.cadena[i];
            hijo2[i] = padre1.cadena[i];
        }
        return new Genoma[]{new Genoma(hijo1),new Genoma(hijo2)};
    }
    
}
