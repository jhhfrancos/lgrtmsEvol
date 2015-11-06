/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva.evolutivios;

import java.util.ArrayList;

/**
 *
 * @author JhhToshiba
 */
//Clase que contiene la informacion del algoritmo genetico: Poblacion, Tamaño de la poblacion, tamaño del Gen, funcion Fitness
public class GeneticoBase {
    
    public ArrayList<Genoma> poblacion;
    public int tamPoblacion;
    public int tamGen;
    public String funcionFitness;
    public double[] restricciones;
    public boolean reales; //si es true: hara operaciones sobre reales, si es False, hara operaciones sobre binarios
    
    public GeneticoBase(int tamPoblacion, int tamGen, String func, double[] restricciones){
        if((tamPoblacion % 2) != 0) tamPoblacion++; //si la poblacion es inpar la vuelve par
        poblacion = new ArrayList<>();
        this.tamPoblacion = tamPoblacion;
        this.tamGen = tamGen;
        this.funcionFitness = func;
        this.restricciones = restricciones;
    }
    public GeneticoBase(ArrayList<Genoma> poblacion, int tamGen, String func, double[] restricciones){
        this.poblacion = new ArrayList<>();
        for(Genoma gen: poblacion)
            this.poblacion.add(new Genoma(gen.cadena,func,restricciones));
        this.tamPoblacion = poblacion.size();
        this.tamGen = tamGen;
        this.funcionFitness = func;
        this.restricciones = restricciones;
    }
    public void generarPoblacion(){ //Genera poblacion inicial
        for(int i = 0; i < tamPoblacion; i++){
            poblacion.add(new Genoma(tamGen,funcionFitness,restricciones));
        }
    }
    
    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < poblacion.size(); i++)
            result = result + "\n" + poblacion.get(i).toString();
        return result;
    }
}