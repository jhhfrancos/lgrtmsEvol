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
 * @author Jhh
 */
public interface OperacionesGeneticoInterface {
    public ArrayList<Genoma> seleccionPadres(ArrayList<Genoma> poblacion, Funciones fitness);
    public ArrayList<Genoma> cruce(ArrayList<Genoma> padres);
    public Genoma[] generarHijos(Genoma padre1, Genoma padre2);
}
