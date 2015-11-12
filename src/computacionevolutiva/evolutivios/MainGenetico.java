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
    
    private void algoritmoGeneticoDesterministicCrowding(int tamGen,int numeroPoblacion,int tamMuestraTorneo, double probMutacion, double probCruce, int condicionParada, boolean reglaReemplazamiento, String funcionFitness,double[] restricciones,boolean general) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Jhh\\Documents\\NetBeansProjects\\lgrtmsEvol\\evolutivosDeterministicCrowding.csv");
        OperacionesDeterministicCrowding operacionesGenetico = new OperacionesDeterministicCrowding();
        GeneticoBase geneticoBase = new GeneticoBase(numeroPoblacion,tamGen,funcionFitness, restricciones);
        
        ArrayList<Genoma> poblacion = new ArrayList<Genoma>();
        geneticoBase.generarPoblacion();
        poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
        
        int j = 1;
            
            int i=1;
            while (i<=condicionParada) {
                
                    System.out.println("\nGeneracion " + i);
                    System.out.println(geneticoBase.toString());
                    if(general){
                        poblacion = (ArrayList<Genoma>) operacionesGenetico.crowdingStep(poblacion, tamMuestraTorneo, probMutacion,probCruce,i,reglaReemplazamiento,funcionFitness).clone();
                    } else{
                        poblacion = (ArrayList<Genoma>) operacionesGenetico.simpleStep(poblacion, probMutacion, i, reglaReemplazamiento, funcionFitness);
                    }
                    i++;
                    System.out.println("\nMejor Fitness " + operacionesGenetico.mejorFitness(poblacion));
                    writer.append(j+"");
                    writer.append(',');
                    writer.append(operacionesGenetico.mejorFitness(poblacion)+"");
                    writer.append('\n');
                    j++;
                
            }
        
         writer.flush();
	 writer.close();
    }
        
    private void algoritmoGeneticoBase(int condicionParada, int numeroPoblacion, int tamGen, String funcionFitness,double[] restricciones, String metodoSeleccion) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Jhh\\Documents\\NetBeansProjects\\lgrtmsEvol\\evolutivos.csv");
        OperacionesGeneticoInterface operacionesGeneticoBase = new OperacionesGenetico();
        GeneticoBase geneticoBase = new GeneticoBase(numeroPoblacion,tamGen,funcionFitness, restricciones);
        
        ArrayList<Genoma> poblacion = new ArrayList<Genoma>();
        geneticoBase.generarPoblacion();
        poblacion = (ArrayList<Genoma>) geneticoBase.poblacion.clone();
        int j = 1;
            int i=1;
            while (i<=condicionParada) {
                System.out.println("\nGeneracion " + i);
                System.out.println(geneticoBase.toString());
                poblacion = (ArrayList<Genoma>) operacionesGeneticoBase.seleccionPadres(poblacion, metodoSeleccion).clone();
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
         writer.flush();
	 writer.close();
    }
    
    public static void main(String[] args) throws IOException {
        MainGenetico mainGenetico = new MainGenetico();
        
        int condicionParada = 1000;
        int numeroPoblacion = 1000;
        int tamGen = 6;
        double[] restricciones = {-100,100};
        String metodoSeleccion = "Torneo"; //Selecciones posibles: Torneo, Ranking, Ruleta, cruce-simple
        String funcionFitness = "F1"; //Funciones diponibles:F1, Griewangk, Rastrigin, Rosenbrock, Schwefel y funciones con variables de la forma x1,x2,x3,xn
        mainGenetico.algoritmoGeneticoBase(condicionParada,numeroPoblacion,tamGen, funcionFitness,restricciones, metodoSeleccion);
    }
}
