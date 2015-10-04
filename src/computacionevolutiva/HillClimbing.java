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
public class HillClimbing {
    Random rand = new Random(); //rand.nextGaussian();
    MathEval mathEval = new MathEval();
    Funciones funciones = new Funciones();
    public HillClimbing(){
    }
    public boolean evalRestrictions(String[] restrictions,String[] params, double[] values){
        boolean flag = true;
        for(int i = 0; i<params.length; i++)
            mathEval.setVariable(params[i], values[i]);
        for(int i=0; i<restrictions.length;i++){
            String function = restrictions[i];
            if (mathEval.evaluate(function) <= 0)
                flag = true;
            else{
                return false;
            }
        }
        return flag;
    }
    public double evalFunction(String func, String[] params, double[] values){
        for(int i = 0; i<params.length; i++)
            mathEval.setVariable(params[i], (double) values[i]);
        double f = mathEval.evaluate(func);
        return f;
    }
    public void hillClimbing(int iteraciones,String func, String[] restric, String[] params, double[] valuesInitial, double delta){
        int itera = 0;
        if (!evalRestrictions(restric, params, valuesInitial))
                return;
        double valFunc;
        double nextValFunc;
        double randomGaus;
        double[] nextValues;
        while (itera<=iteraciones){
            nextValues = valuesInitial.clone();
            //valFunc = evalFunction(func, params, nextValues);
            valFunc = funciones.Griewangk(nextValues);
            for (int i=0; i<nextValues.length;i++){
                randomGaus = rand.nextGaussian() % delta;
                nextValues[i] = nextValues[i] + randomGaus;
            }
            //nextValFunc = evalFunction(func, params, nextValues);
            nextValFunc = funciones.Griewangk(nextValues);
            
            if(valFunc>=nextValFunc && evalRestrictions(restric, params, nextValues)) //maximizar o minimizar
                valuesInitial = nextValues;
            else
                valuesInitial = valuesInitial;
            System.out.println("valor func " + valFunc + " punto " + valuesInitial[0]);
            itera++;
        }
    }
    public static void main(String[] args) {
        HillClimbing hill = new HillClimbing();
        String ecuacion = "2*x1+3*x2";
        String[] variables = {"x1"};
        int iteraciones = 1000; // x1<500 -> x1-500<0
        String[] restricciones = {"-x1-500","x1-500"}; //,"-x2-500","x2-500"
        /*String ecuacion = "sin(x1)+sin(x2)";
        String[] variables = {"x1","x2"};
        String[] restricciones = {"-x1-6","-x2-6","x1-6","x2-6"};*/
        double delta = 0.1;
        double[] valores = {41};
        //System.out.println(hill.evalRestrictions(restricciones,variables,valores));
        hill.hillClimbing(iteraciones,ecuacion, restricciones, variables, valores, delta);
    }
}
