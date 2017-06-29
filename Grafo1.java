/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_algoritmo_grafos;

import java.util.Scanner;
import java1.uac.Grafo;
import java1.uac.GrafoCol;
import java1.uac.LimiteException;

/**
 *
 * @author martin
 */
public class Grafo1{
    String con="";
    Grafo<Integer> crear() throws LimiteException{
    Grafo<Integer> g = new GrafoCol<>();
       
        
        g.insVertice(0);
        g.insVertice(1); 
        g.insVertice(2);
        g.insVertice(3);
        g.insVertice(4);
        
        
        g.insArco(0, 1, 3);
        g.insArco(1, 0, 3);
        
        g.insArco(0, 2, 10);
        g.insArco(2, 0, 10);
        
        g.insArco(1, 3, 5);
        g.insArco(3, 1, 5);
        
        g.insArco(2, 3, 0); 
        g.insArco(3, 2, 0);  
        
        g.insArco(2, 4, 15);
        g.insArco(4, 2, 15);
        
        g.insArco(3, 4, 4);
        g.insArco(4, 3, 4);
       
        return g;
    }

    public String mostrar(Grafo<Integer> g) throws LimiteException{
       
        for (int i = 0; i < g.ordenGrafo(); i++) {
            con+="Vertice "+g.infoVertice(i);
            for (int j = 0; j < g.ordenGrafo(); j++) {
                con+= " a "+j+" : "+g.costoArco(i, j)+" -- ";
            }
            con+="\n";
        }
        return con;
    }
    
    public static void main(String[] args) throws LimiteException {
        Grafo1 g=new Grafo1();
        Grafo<Integer> crear=g.crear();
        System.out.println(" "+g.mostrar(g.crear()));
        
        Scanner sn= new Scanner(System.in);
        System.out.println("Digite el vertice de origen");
        int origen=sn.nextInt();
        Disjkstra camino=new Disjkstra(origen, crear);
        camino.caminoMinimo();
        System.out.println("Digite el vertice al que quiere llegar");
        int llegar=sn.nextInt();
        camino.ruta(llegar);
    }

    
}
