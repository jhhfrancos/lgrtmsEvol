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
 * @author JhhToshiba
 */
public class MainGenetico {

    private void algoritmoGeneticoBase(int condicionParada, int numeroPoblacion, int tamGen, Funciones fitness) {
        GeneticoBase geneticoBase = new GeneticoBase(numeroPoblacion,tamGen,fitness);
        OperacionesGeneticoInterface operacionesGeneticoBase = new OperacionesGenetico();
        ArrayList<Genoma> poblacion = new ArrayList<Genoma>();
        geneticoBase.generarPoblacion();
        poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
        int i=1;
        while (i<=condicionParada) {
            System.out.println("Poblacion " + i);
            System.out.println(geneticoBase.toString());
            poblacion = (ArrayList<Genoma>) operacionesGeneticoBase.seleccionPadres(poblacion, new Funciones()).clone();
            poblacion = (ArrayList<Genoma>) operacionesGeneticoBase.cruce(poblacion).clone();
            geneticoBase.poblacion = (ArrayList<Genoma>) poblacion.clone();
            i++;
        }
            
        
    }
    
    public static void main(String[] args) {
        MainGenetico mainGenetico = new MainGenetico();
        int condicionParada = 100;
        int numeroPoblacion = 100;
        int tamGen = 6;
        Funciones fitness = new Funciones();
        mainGenetico.algoritmoGeneticoBase(condicionParada,numeroPoblacion,tamGen, fitness);
    }

}
