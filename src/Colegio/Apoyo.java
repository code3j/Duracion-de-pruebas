/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colegio;
import java.io.*;
import  java.util.*;
/**
 *
 * @author NB-3170
 */
public class Apoyo {
    public static int cant_reg()throws IOException{
        Scanner leo = new Scanner(new File("Alumnos.txt"));
        int cant_regis=0;
        while(leo.hasNextLine()){
            leo.nextLine();
            cant_regis++;
        }
        return cant_regis;
    }
public static void leo_regis(String nombre[],String horas [][] ) throws IOException{
    int cont=0;
      Scanner leo = new Scanner(new File("Alumnos.txt"));
    while (leo.hasNextLine()){
        nombre[cont]=leo.next();
        for (int i = 0; i < horas[0].length; i++) {
            horas[cont][i]=leo.next();
        }
        cont++;
    }leo.close();
}
public static void horas_enteras(String horas[][],int ho_enteros[][])throws IOException{
 
    for (int i = 0; i < horas.length; i++) {
         int cont=0; 
        for (int j = 0; j < horas[0].length; j++) {
             String tem=" ";
             tem = horas[i][j];
             Scanner leo =new Scanner (tem);
             leo.useDelimiter(":");
             ho_enteros[i][cont++]=Integer.parseInt(leo.next());
             ho_enteros[i][cont++]=Integer.parseInt(leo.next());
                     
        }
        
    }
} 
public static void operaciones (int ho_enteros[][],String tiempos[], int duracion[]){
    int minE=0, minS=0, tie_mi=0,tie_ho=0,dif=0,tiempI=0,tiempoS=0;
    for (int i = 0; i < ho_enteros.length; i++) {
       tiempI=ho_enteros[i][0]*60 +ho_enteros[i][1];
       duracion[i]=tiempI;
       if( tiempI>=750){
           tiempos[i]="00:00";
       }
       if(tiempI<750){
            tiempoS=ho_enteros[i][2]*60+ho_enteros[i][3];
            dif=tiempoS-tiempI;
            tie_ho=dif/60;
            tie_mi=dif%60;
            if((tie_mi>0) &&(tie_mi<10) ){
                tiempos[i]="0"+tie_ho+":0"+tie_mi;
            }
            else if(tie_mi>=10){
                tiempos[i]="0"+tie_ho+":"+tie_mi;
            }
            else if(tie_mi==0){
             tiempos[i]="0"+tie_ho+":00";
       }
            
       }
        
    }
    
}
public static void mostrar(String nombre [], String horas [][],String tiempos [],int duracion[]){
    System.out.println("\tListado de Tiempo Pruebas 2020");
     System.out.println("");
    System.out.println("Nombre        Hi:Mi    Hs:Ms     Duración");
    int cont=0;
    
     for (int i = 0; i < nombre.length; i++) {
      
         System.out.printf("%-8s",nombre[i]);
         
         for (int j = 0; j < horas[0].length; j++) {
             System.out.printf("%10s",horas[i][j]);
             
         }
         if(duracion[i]>=750){
             System.out.printf("%12s   No entro en la prueba",tiempos[i]);
         }else{
             System.out.printf("%12s",tiempos[i]);
         }
         System.out.println(" ");
    }
}
  

}
