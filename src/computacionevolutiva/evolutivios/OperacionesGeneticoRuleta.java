/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package computacionevolutiva.evolutivios;

import computacionevolutiva.Funciones;
import java.util.ArrayList;

/**
 *
 * @author Jhh
 */
public class OperacionesGeneticoRuleta extends OperacionesGeneticoInterface{

    @Override
    public ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, Funciones fitness) {
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
