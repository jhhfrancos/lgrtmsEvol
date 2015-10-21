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
    
    public String funcionFitness;
    
    public Genoma(int tamGen, String funcionFitness){
        if((tamGen % 2) != 0 ) tamGen++; //Si el gen es inpar lo vuelve par (dimensiones)
        this.tamGen = tamGen;
        cadena = new double[this.tamGen];
        this.funcionFitness = funcionFitness;
        generarGenAleatorio(); 
        calcularFitness(); 
    }
    public Genoma(double[] cadena, String funcionFitness){
        this.cadena = cadena.clone();
        this.tamGen = cadena.length;
        this.funcionFitness = funcionFitness;
        calcularFitness();
    }
    //Genera gen aleatorio
    public void generarGenAleatorio() {
        for(int i = 0; i < tamGen; i++){
            cadena[i] = (double) new Random().nextInt(100); // genera numero aleatorio entre 0 y 10
        }
    }
    //Define el fitness para ese gen
    public void calcularFitness(){
        switch (funcionFitness){
            case ("Griewangk"):
                fitness = Funciones.Griewangk(cadena);
                break;
            case("Rastrigin"):
                fitness = Funciones.Rastrigin(cadena);
                break;
            case("Rosenbrock"):
                fitness = Funciones.Rosenbrock(cadena);
                break;
            case("Schwefel"):
                fitness = Funciones.Schwefel(cadena);
                break;
            default:
                fitness = Funciones.other(funcionFitness, cadena);
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(cadena) + " Fitness " + fitness;
    }
}
