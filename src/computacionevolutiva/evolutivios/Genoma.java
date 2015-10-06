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
    public Genoma padre1;
    public Genoma padre2;
    public Genoma hijo1;
    public Genoma hijo2;
    public int tamGen;
    public Genoma(int tamGen){
        if((tamGen % 2) != 0 ) tamGen++;
        this.tamGen = tamGen;
        cadena = new int[this.tamGen];
        generarGen();
    }
    public Genoma(int[] cadena){
        this.cadena = cadena;
        this.tamGen = cadena.length;
    }
    public Genoma(Genoma padre1, Genoma padre2){
        this.padre1 = padre1;
        this.padre1 = padre2;
        this.tamGen = padre1.cadena.length;
    }
    
    public void generarGen() {
        for(int i = 0; i < tamGen; i++){
            cadena[i] = (int) new Random().nextInt(100); // genera numero aleatorio entre 0 y 100
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(cadena);
    }
}
