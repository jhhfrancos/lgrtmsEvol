/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva.evolutivios;

import computacionevolutiva.Funciones;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author JhhToshiba
 */
public class Genoma {
    public double[] cadena;
    public double fitness;
    public int tamGen;
    
    private String funcionFitness;
    
    public Genoma(int tamGen, String funcionFitness){
        if((tamGen % 2) != 0 ) tamGen++; //Si el gen es inpar lo vuelve par (dimensiones)
        this.tamGen = tamGen;
        cadena = new double[this.tamGen];
        this.funcionFitness = funcionFitness;
        System.out.println(Funciones.Griewangk(cadena));
        generarGen(); 
        generarFitness(); 
    }
    public Genoma(double[] cadena){
        this.cadena = cadena;
        this.tamGen = cadena.length;
        generarFitness();
    }
    //Genera gen aleatorio
    public void generarGen() {
        for(int i = 0; i < tamGen; i++){
            cadena[i] = (double) new Random().nextInt(100); // genera numero aleatorio entre 0 y 100
        }
    }
    //Define el fitness para ese gen
    public void generarFitness(){
        //TODO
    }
    @Override
    public String toString(){
        return Arrays.toString(cadena);
    }
}
