/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva.evolutivios;

import computacionevolutiva.Funciones;
import java.util.ArrayList;

/**
 *
 * @author JhhToshiba
 */
public class GeneticoBase {
    
    public ArrayList<Genoma> poblacion;
    public int tamPoblacion;
    public int tamGen;
    public Funciones func;
    
    public GeneticoBase(int tamPoblacion, int tamGen, Funciones func){
        if((tamPoblacion % 2) != 0) tamPoblacion++;
        poblacion = new ArrayList<>();
        this.tamPoblacion = tamPoblacion;
        this.tamGen = tamGen;
        this.func = func;
    }
    public void generarPoblacion(){
        for(int i = 0; i < tamPoblacion; i++){
            poblacion.add(new Genoma(tamGen));
        }
    }
    
    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < poblacion.size(); i++)
            result = result + "\n" + poblacion.get(i).toString();
        return "poblacion\n" + result;
    }
    
}
