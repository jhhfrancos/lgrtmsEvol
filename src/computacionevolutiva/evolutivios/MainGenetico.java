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

    private void algoritmoGeneticoBase(int condicionParada, int numeroPoblacion, int tamGen, String funcionFitness, String metodoSeleccion) {
        GeneticoBase geneticoBase = new GeneticoBase(numeroPoblacion,tamGen,funcionFitness);
        OperacionesGeneticoInterface operacionesGeneticoBase = new OperacionesGenetico();
        ArrayList<Genoma> poblacion = new ArrayList<Genoma>();
        geneticoBase.generarPoblacion();
        poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
        int i=1;
        while (i<=condicionParada) {
            System.out.println("\nGeneracion " + i);
            System.out.println(geneticoBase.toString());
            poblacion = (ArrayList<Genoma>) operacionesGeneticoBase.seleccionPadres(poblacion, metodoSeleccion);
            poblacion = (ArrayList<Genoma>) operacionesGeneticoBase.cruce(poblacion).clone();
            poblacion = (ArrayList<Genoma>) operacionesGeneticoBase.mutacion(poblacion, (double) 1/tamGen).clone();
            geneticoBase.poblacion = (ArrayList<Genoma>) poblacion.clone();
            i++;
            System.out.println("\nMejor Fitness " + operacionesGeneticoBase.mejorFitness(poblacion));
        }
    }
    
    public static void main(String[] args) {
        MainGenetico mainGenetico = new MainGenetico();
        int condicionParada = 100;
        int numeroPoblacion = 100;
        int tamGen = 10; 
        String metodoSeleccion = "Torneo"; //Selecciones posibles: Torneo, Ranking, Ruleta, cruce-simple
        String funcionFitness = "Griewangk"; //Funciones diponibles: Griewangk, Rastrigin, Rosenbrock, Schwefel y funciones con variables de la forma x1,x2,x3,xn
        mainGenetico.algoritmoGeneticoBase(condicionParada,numeroPoblacion,tamGen, funcionFitness, metodoSeleccion);
    }

}
