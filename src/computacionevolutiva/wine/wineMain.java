/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva.wine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JhhToshiba
 */
public class wineMain {
    public ArrayList<double[]> poblacion;
    public wineMain(){}
    public ArrayList<double[]> cargarPoblacion() throws FileNotFoundException, IOException{
        FileReader archivoWine = new FileReader("E:\\Computacion evolutiva\\wine.data");
        BufferedReader archivoData = new BufferedReader(archivoWine);
        String sCadena;
        double[] mayores = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        ArrayList<double[]> poblacion = new ArrayList<double[]>();
        while ((sCadena = archivoData.readLine())!=null) {
            double[] cadena = new double[14];
            int j=0;
            String numero = "";
            for(int i = 0; i < sCadena.length(); i++){
                if(sCadena.charAt(i) != ',')
                    numero = numero + sCadena.charAt(i);
                else{
                    cadena[j++] = new Double(numero);
                    numero = "";
                }
            }
            cadena[j++] = new Double(numero);
            for(int k = 0; k < cadena.length; k++){
                if(cadena[k] > mayores[k])
                    mayores[k] = cadena[k];
            }
            poblacion.add(cadena);
        }
        poblacion.add(mayores);
        return poblacion;
    }
    
    public ArrayList<double[]> normalizar(ArrayList<double[]> datos){
        ArrayList<double[]> datosNormalizados = new ArrayList<>();
        double[] mayores = datos.get(datos.size()-1);
        for(int j = 0; j < datos.size()-1; j++){
            double[] cadena = datos.get(j).clone();
            for(int i = 1; i < cadena.length; i++)
                cadena[i] = cadena[i] / mayores[i];
            datosNormalizados.add(cadena);
        }
        return datosNormalizados;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        wineMain wine = new wineMain();
        ArrayList<double[]> poblacion = (ArrayList<double[]>) wine.cargarPoblacion().clone();
        ArrayList<double[]> poblacionNormalizada = (ArrayList<double[]>) wine.normalizar(poblacion).clone();
        for (double[] poblacionN : poblacionNormalizada) {
            System.out.println(Arrays.toString(poblacionN));
        }
        
    }
}