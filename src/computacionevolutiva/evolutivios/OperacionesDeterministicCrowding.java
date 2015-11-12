/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package computacionevolutiva.evolutivios;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jhh
 */
public class OperacionesDeterministicCrowding extends OperacionesGeneticoInterface{

    @Override
    public ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, String metodoSeleccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Genoma> cruce(ArrayList<Genoma> padres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Genoma> mutacion(ArrayList<Genoma> genMutar, double probMutacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Genoma mutacion(Genoma genHijo, double probMutacion){
        Genoma hijoMutado;
        double randomProbMutacion;
        double randomProbOperador = 0;
        
            for(int i = 0; i < genHijo.tamGen; i++){
                randomProbMutacion = Math.random();// generamos un numero al azar entre 0 y 1
                if(randomProbMutacion < probMutacion)
                    randomProbOperador = Math.random();// generamos mutacion de operadores +10 o -10
                    if(randomProbOperador <= 0.5){
                        genHijo.cadena[i] = (genHijo.cadena[i] - 10) % genHijo.restricciones[0] ;
                    } else{
                        genHijo.cadena[i] = (genHijo.cadena[i] + 10) % genHijo.restricciones[1];
                    }
            }
            hijoMutado = new Genoma(genHijo.cadena, genHijo.funcionFitness,genHijo.restricciones);
        
        return hijoMutado;
    }
    public ArrayList<Genoma> crowdingStep(ArrayList<Genoma> poblacion, int tamMuestraTorneo, double probMutacion, double probCruce, int generacion, boolean reglaReemplazamiento, String funcionFitness) {
        int k=0;
        Random randDouble = new Random();
        Random randInt = new Random();
        int[] indexPool = new int[poblacion.size()];
        for(int i=0; i<poblacion.size();i++)
            indexPool[i] = i;
        while(indexPool.length>1){
            ArrayList<Genoma> padres = new ArrayList<Genoma>(tamMuestraTorneo);
            for(int i=0; i<tamMuestraTorneo;i++){
                int aleatorio = randInt.nextInt(indexPool.length+1);
                int j = indexPool[aleatorio];
                padres.add(i,poblacion.get(j));
                indexPool[aleatorio]
            }
        }
    }
    public ArrayList<Genoma> simpleStep(ArrayList<Genoma> poblacion, double probMutacion, int generacion, boolean reglaReemplazamiento, String funcionFitness) {
        ArrayList<Genoma> poblacionNueva = new ArrayList<Genoma>();
        int i=0;
        while(i<poblacion.size()){
            Genoma hijo = mutacion(poblacion.get(i),probMutacion);
            if(hijo.fitness<poblacion.get(i).fitness)
                poblacionNueva.add(new Genoma(poblacion.get(i).cadena, poblacion.get(i).funcionFitness,poblacion.get(i).restricciones));
            else
                poblacionNueva.add(new Genoma(hijo.cadena,hijo.funcionFitness,hijo.restricciones));
            i++;
        }
        return poblacionNueva;
    }
}

    

