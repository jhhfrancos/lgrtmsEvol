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

/**
 *
 * @author Jhh
 */
public class OperacionesGeneticoRanking extends OperacionesGeneticoInterface{

    @Override
    public ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, Funciones fitness) {
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

    @Override
    public ArrayList<Genoma> cruce(ArrayList<Genoma> padres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genoma[] generarHijos(Genoma padre1, Genoma padre2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
