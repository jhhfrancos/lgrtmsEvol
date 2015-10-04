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
public class SimulatedAnnealing {
    Random rand = new Random(); //rand.nextGaussian();
    MathEval mathEval = new MathEval();
    Funciones funciones = new Funciones();
    
    public SimulatedAnnealing(){
    }
    public void simulatedAnnealing(int iteraciones,double temperatura, double[] values, int K, int A){
        double T = temperatura;
        int iter = 0;
        int k = 0;
        int a = 0;
        double actualFunc = funciones.Griewangk(values);
        double nextFunc;
        double[] nextValues = new double[values.length];
        while (iter<=iteraciones){
            while (k < K && a < A){
                
                generar j en N(i)
                if (c(j) – c(i) < 0)
                        i = j
                        a = a + 1
                else
                        generar un numero r al azar (pseudo-random number)
                        if (r < exp [(c(i) – c(j))/T])
                                i = j
                                a = a + 1
                k = k + 1
            }
        }
	T = T
	K = K
	k = 0
	a = 0
 mostrar i, c(i)

    }
}

