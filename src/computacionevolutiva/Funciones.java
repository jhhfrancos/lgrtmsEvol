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
public class Funciones {
    
    public Funciones(){}
    
    public static double Rosenbrock(double[] values){
        MathEval mathEval = new MathEval();
        if(values[0]<-2048 || values[0]>2048 || values[1]<-2048 || values[1]>2048) return -1;
        mathEval.setVariable("x1", values[0]);
        mathEval.setVariable("x2", values[1]);
        double f = mathEval.evaluate("100*(x1^2 - x2)^2 + (1 - x1)^2");
        return f;
    }
    public static double Schwefel(double[] values){
        MathEval mathEval = new MathEval();
        double f=0;
        int n = values.length;
        mathEval.setVariable("n", n);
        for(int i = 0; i<n; i++){
            if(values[i]<-512 || values[i]>512) return -1;
            mathEval.setVariable("x"+(i+1), values[i]);
            f = f + mathEval.evaluate("-x"+(i+1)+ " * sin(sqrt(abs(x"+(i+1)+")))");
        }
        f = mathEval.evaluate("418.9829 * n") + f;
        return f;
    }
    public static double Rastrigin(double values[]){
        MathEval mathEval = new MathEval();
        double f=0;
        int n = values.length;
        int A = 10;
        mathEval.setVariable("n", n);
        mathEval.setVariable("A", A);
        for(int i = 0; i<n; i++){
            if(values[i]<-5.12 || values[i]>5.12) return -1;
            mathEval.setVariable("x"+(i+1), values[i]);
            f = f + mathEval.evaluate("(x"+(i+1)+"^2 - (A * cos(2*pi*x"+(i+1)+")))");
        }
        f = mathEval.evaluate("A * n") + f;
        return f;
    }
    public static double Griewangk(double values[]){
        MathEval mathEval = new MathEval();
        double f=0;
        double g=1;
        int n = values.length;
        mathEval.setVariable("n", n);
        for(int i = 0; i<n; i++){
            if(values[i]<-600 || values[i]>600) return -1;
            mathEval.setVariable("x"+(i+1), values[i]);
            f = f + mathEval.evaluate("((x"+(i+1)+"^2 )/4000)");
            g = g * mathEval.evaluate("cos((x"+(i+1)+" )/sqrt(" + (i+1) + "))");
        }
        f = 1 + f - g;
        return f;
    }
    public static double other(String function, double values[]){
        MathEval mathEval = new MathEval();
        double f=0;
        int n = values.length;
        for(int i = 0; i<n; i++)
            mathEval.setVariable("x"+(i+1), values[i]);
        f = f + mathEval.evaluate(function);
        return f;
    }
    public static double F1(double[] values){
        MathEval mathEval = new MathEval();
        double f=0;
        int D = values.length;
        mathEval.setVariable("D", D);
        for(int i = 0; i<D; i++){
            if(values[i]<-100 || values[i]>100) return -1;
            mathEval.setVariable("x"+(i+1), values[i]);
            f = f + mathEval.evaluate("x"+(i+1)+ "^2 * 10^((6*((("+(i+1)+"-1)/(D-1)))))");
        }
        return f;
    }
    public static double F2(double[] values){
        MathEval mathEval = new MathEval();
        double f=0;
        int n = values.length;
        int A = 10;
        mathEval.setVariable("n", n);
        mathEval.setVariable("A", A);
        for(int i = 0; i<n; i++){
            if(values[i]<-5.12 || values[i]>5.12) return -1;
            mathEval.setVariable("x"+(i+1), values[i]);
            f = f + mathEval.evaluate("(x"+(i+1)+"^2 - (A * cos(2*pi*x"+(i+1)+")))");
        }
        f = mathEval.evaluate("A * n") + f;
        return f;
    }
    public static void main(String args[]){
        double[] values = new double[100];
        Random rand = new Random();
        for(int i=0; i<values.length; i++){
            values[i] = (double)rand.nextInt((100+100) + 1) -100;
        }
        System.out.println(Arrays.toString(values));
        System.out.println(Funciones.F1(values));
    }
}
