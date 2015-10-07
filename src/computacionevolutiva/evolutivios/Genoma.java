/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva.evolutivios;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author JhhToshiba
 */
public class Genoma {
    public int[] cadena;
    public double fitness;
    public int tamGen;
    
    public Genoma(int tamGen){
        if((tamGen % 2) != 0 ) tamGen++;
        this.tamGen = tamGen;
        cadena = new int[this.tamGen];
        generarGen();
        generarFitness();
    }
    public Genoma(int[] cadena){
        this.cadena = cadena;
        this.tamGen = cadena.length;
        generarFitness();
    }
    
    public void generarGen() {
        for(int i = 0; i < tamGen; i++){
            cadena[i] = (int) new Random().nextInt(100); // genera numero aleatorio entre 0 y 100
        }
    }
    public void generarFitness(){
        //TODO
    }
    @Override
    public String toString(){
        return Arrays.toString(cadena);
    }
}
