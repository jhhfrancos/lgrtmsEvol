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
public abstract class OperacionesGeneticoInterface {
    
    public abstract ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, Funciones fitness);
    public abstract ArrayList<Genoma> cruce(ArrayList<Genoma> padres);
    public abstract Genoma[] generarHijos(Genoma padre1, Genoma padre2);
    public double mejorFitness(ArrayList<Genoma> poblacion, Funciones fitness){
        //TODO
        return 0;
    }
    
}

