/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karelarea;

import becker.robots.*;
import java.awt.Color;
/**
 *
 * @author david
 */
public class Escenario {
    private City ciudad;
    private Robot robot;
    
    public Escenario(){
        
        this.ciudad = new City();
        
        for(int i = 1; i<=5; i++){
           Wall pared1= new Wall(ciudad,i,1,Direction.WEST); 
           Wall pared2= new Wall(ciudad,i,1,Direction.EAST);
           Wall pared3= new Wall(ciudad,i,6,Direction.WEST); 
           Wall pared4= new Wall(ciudad,i,6,Direction.EAST);
        }
        
        for(int i = 2; i<=5; i++){
           Wall pared1= new Wall(ciudad,3,i,Direction.NORTH);
           Wall pared2= new Wall(ciudad,3,i,Direction.SOUTH);
        }
        
        Wall pared2 = new Wall(ciudad, 5, 6, Direction.SOUTH);
        Wall pared3 = new Wall(ciudad, 5, 1, Direction.SOUTH);
        Wall pared4 = new Wall(ciudad, 1, 1, Direction.NORTH);
        Wall pared5 = new Wall(ciudad, 1, 6, Direction.NORTH);
        Wall pared6 = new Wall(ciudad, 5, 2, Direction.SOUTH);
        Wall pared7 = new Wall(ciudad, 5, 2, Direction.NORTH);
        Wall pared8 = new Wall(ciudad, 5, 2, Direction.EAST);

        
        
        
        
        this.robot = new Robot(ciudad, 4, 3,Direction.WEST);
        
        Thing cosa = new Thing(ciudad, 4, 4);
        cosa.getIcon().setColor(Color.ORANGE);
    }
    
    public void girar(int giros){
        for (int i=0;i<giros;i++) {
            this.robot.turnLeft();
        }
    }
    
    public void move(int parametroEntrada){
        for (int i = 0; i < parametroEntrada; i++){
            if(robot.frontIsClear()){
                robot.move();
            }else{
                girar(1);
            }
        }
    }
   
    public int mayor(int a, int b){
        int c;
        if(a>b){
            c=a;
        }else{
            c=b;
        }
        return c;
    }
    
    public int menor(int a, int b){
        int c;
        if(a<b){
            c=a;
        }else{
            c=b;
        }
        return c;
    }
    
    public int sumarAreaColumna(int [][] A, int i, int j, int n, int cont){
        int k=0,z=i;
        if(i==n-1){
            return cont;
        }else if(A[z][j]==2){
            z++;
            while(A[z][j]!=2 && z<n-1){
                k++;
                z++;
            }
            if(A[i][j]==2 && A[z][j]==2){
                cont+=k;
            }
            return sumarAreaColumna(A, z, j, n, cont);
        }else if(A[z][j]==1){
            return sumarAreaColumna(A, z+1, j, n, cont);
        }
        return 0;
    }
    
    public void proced(){
        int a1=robot.getAvenue();
        int b1=robot.getStreet();
        int a2=8;
        int b2=8;
        int tamf=0;
        int tamc=0;
        //Proceso para incializar el proceso de recorrido para reconocer el area y asignarle un tamaño de matriz
        boolean bandera=false;
        while(!bandera){
            
            bandera = robot.canPickThing();
            girar(3);
            
            a1=robot.getStreet();
            b1=robot.getAvenue();
            
            if(robot.frontIsClear()){
                move(1);
                if(!robot.frontIsClear()){
                    girar(1);
                    if(!robot.frontIsClear()){
                        girar(1);
                    }
                    move(1);
                }
            }else{
                girar(1);
                move(1);
            }
            
            tamf=mayor(tamf,a1); //tamañp de las filas de la matriz
            tamc=mayor(tamc,b1); //tamañp de las columnas de la matriz
            a2=menor(a2,a1);
            b2=menor(b2,b1);
        }
        
        int Area[][]=new int[tamf-a2+1][tamc-b2+1]; //incializacion de la matriz asociada al area
        
        //se rellena la matriz de unos para contar el area
        for (int i = 0; i < tamf-a2+1; i++) {
            for (int j = 0; j < tamc-b2+1; j++) {
                Area[i][j]=1;
            }
        }
        
        //Segundo recorrido para contornear la forma del terreno con dos
        bandera=false;
        while(!bandera){
            
            bandera = robot.canPickThing();
            girar(3);
            
            a1=robot.getStreet();
            b1=robot.getAvenue();
            
            if(robot.frontIsClear()){
                move(1);
                if(!robot.frontIsClear()){
                    girar(1);
                    if(!robot.frontIsClear()){
                        girar(1);
                    }
                    move(1);
                }
            }else{
                girar(1);
                move(1);
            }
            
            Area[a1-a2][b1-b2]=2;
        }
        
        int cont=0;
        //suma de los unos que estén dentro del contorno de 2 de la matriz asociada al terreno
        for (int j = 0; j < tamc-b2+1; j++) {
            cont=sumarAreaColumna(Area, 0, j, tamf-a2+1, cont);  
        }
        
        System.out.println(cont);
    }
}
