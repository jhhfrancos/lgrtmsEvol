/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva.evolutivios;

import computacionevolutiva.Funciones;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JhhToshiba
 */
public class MainGenetico {
    
    
        
    private void algoritmoGeneticoBase(int condicionParada, int numeroPoblacion, int tamGen, String funcionFitness,double[] restricciones, String metodoSeleccion) throws IOException {
        FileWriter writer = new FileWriter("E:\\evolutivos.csv");
        OperacionesGeneticoInterface operacionesGeneticoBase = new OperacionesGenetico();
        GeneticoBase geneticoBase = new GeneticoBase(numeroPoblacion,tamGen,funcionFitness);
        
        ArrayList<Genoma> poblacion = new ArrayList<Genoma>();
        geneticoBase.generarPoblacion();
        poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
        
        int j = 1;
        for(int k = 1; k <= 3; k++){
            if(k==2) {
                geneticoBase = new GeneticoBase(poblacion, tamGen, "x1^3 - 2*x1^2 + 3 -x2" );
                poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
            }
            if(k==3) {
                geneticoBase = new GeneticoBase(poblacion, tamGen, "x1^2 - 3*x1 + 2 -x2" ); 
                poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
            }
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
                writer.append(j+"");
                writer.append(',');
                writer.append(operacionesGeneticoBase.mejorFitness(poblacion)+"");
                writer.append('\n');
                j++;
            }
        }
         writer.flush();
	 writer.close();
    }
    
    public static void main(String[] args) throws IOException {
        MainGenetico mainGenetico = new MainGenetico();
        
        int condicionParada = 100;
        int numeroPoblacion = 100;
        int tamGen = 2; 
        double[] restricciones = {100,100};
        if(restricciones.length != tamGen) return;
        String metodoSeleccion = "Torneo"; //Selecciones posibles: Torneo, Ranking, Ruleta, cruce-simple
        String funcionFitness = "x1^2 + x1 + 3 - x2"; //Funciones diponibles: Griewangk, Rastrigin, Rosenbrock, Schwefel y funciones con variables de la forma x1,x2,x3,xn
        mainGenetico.algoritmoGeneticoBase(condicionParada,numeroPoblacion,tamGen, funcionFitness,restricciones, metodoSeleccion);
    }

}
