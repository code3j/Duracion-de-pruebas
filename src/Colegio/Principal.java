/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colegio;
import java.io.*;
import java.util.*;
/**
 *
 * @author NB-3170
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int cant= Apoyo.cant_reg();
        String nombre[]= new String[cant];
        String horas[][]= new String[cant][2];
        int ho_enteros[][]=new int [cant][4];
        String tiempos[]=new String [cant];
        int duracion[]= new int [cant];
        
        Apoyo.leo_regis(nombre, horas);
        Apoyo.horas_enteras(horas, ho_enteros);
        Apoyo.operaciones(ho_enteros, tiempos, duracion);
        Apoyo.mostrar(nombre, horas, tiempos, duracion);
        
        
        
    }
    
}
