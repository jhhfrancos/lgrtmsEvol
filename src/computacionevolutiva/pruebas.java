/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva;

import java.util.Random;

/**
 *
 * @author JhhToshiba
 */
public class pruebas {
    Random rand = new Random();
    public pruebas(){}
    public double gaus(){
        return rand.nextGaussian() % 0.1;
    }
    public static void main(String args[]){
        pruebas prueba = new pruebas();
        for(int i=0; i<=100; i++)
            System.out.println(prueba.gaus());
    }
}
