/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author JhhToshiba
 */
public class Genoma {
    public int[] cadena;
    public int[] padre1;
    public int[] padre2;
    public int[] hijo1;
    public int[] hijo2;
    public int tamGen;
    public Genoma(int tamGen){
        this.tamGen = tamGen;
        cadena = new int[tamGen];
        generarGen();
    }
    public Genoma(int[] cadena){
        this.cadena = cadena;
        this.tamGen = cadena.length;
    }
    public Genoma(int[] padre1, int[] padre2){
        this.padre1 = padre1;
        this.padre1 = padre2;
        this.tamGen = padre1.length;
    }
    public void generarGen(){
        if((tamGen % 2) != 0 ) tamGen++;
        for(int i = 0; i < tamGen; i++){
            cadena[i] = (int) new Random().nextInt(100); // genera numero aleatorio entre 0 y 100
        }
    }
    public void generarHijos(int[] padre1, int[] padre2){
        if (!validarPadres(padre1, padre2)) {
            hijo1 = new int[padre1.length];
            hijo2 = new int[padre2.length];
        }
        hijo1 = new int[padre1.length];
        hijo2 = new int[padre2.length];
        for(int i = 0; i < padre1.length/2; i++){
            hijo1[i] = padre1[i];
            hijo2[i] = padre2[i];
        }
        for(int i = padre1.length/2; i < padre1.length; i++){
            hijo1[i] = padre2[i];
            hijo2[i] = padre1[i];
        }
    }
    public boolean validarPadres(int[] padre1, int[] padre2){
        return (padre1.length == padre2.length);
    }
    @Override
    public String toString(){
        return Arrays.toString(cadena);
    }
}
