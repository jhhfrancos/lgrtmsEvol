/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionevolutiva;

/**
 *
 * @author JhhToshiba
 */
public class ComputacionEvolutiva {

    /**
     * @param args the command line arguments
     */
    
    public int[][] generacion;
    int[] h1 = new int[8];
    int[] h2 = new int[8];
    public ComputacionEvolutiva() {
    }
    public void generarHijos(){
        for(int i=0; i<=127; i+=2){
            for(int j=0; j<=3; j++){
                h1[j] = generacion[i][j];
                h2[j] = generacion[i+1][j];
            }
            for(int j=4; j<=7; j++){
                h1[j] = generacion[i+1][j];
                h2[j] = generacion[i][j];
            }
        }
    }
    public void generarAleatorios(){
        generacion = new int[128][8];
        for(int i=0; i<=127; i++){
            for(int j=0; j<=7; j++){
                generacion[i][j] = (Math.random()<=0.5)?0:1;
                System.out.print(" " + generacion[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        ComputacionEvolutiva comp = new ComputacionEvolutiva();
        comp.generarAleatorios();
    }
}
