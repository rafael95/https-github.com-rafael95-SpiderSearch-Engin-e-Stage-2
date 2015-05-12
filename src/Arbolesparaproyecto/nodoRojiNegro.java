/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbolesparaproyecto;

/**
 *
 * @author rafael
 */
public class nodoRojiNegro{
	int Codcur;    	// la llave del arbol
	
	String Nombre;
	String url;
	nodoRojiNegro padre;    // el padre del nodo
	nodoRojiNegro hIzq;      // Hijo izquierdo
	nodoRojiNegro hDer;      // Hijo derecho
	int color;      		// Color
	// Constructores
	nodoRojiNegro(){
		padre=hIzq=hDer=null;
		color=0;
	}
	nodoRojiNegro (int codcu,String url){
		Codcur= codcu;
		
		this.url=url;
		padre= hIzq = hDer = null;
		color= 0;
	}
	public nodoRojiNegro(int codcu, nodoRojiNegro pa,String url){
		Codcur= codcu;
		this.url=url;
		hIzq= hDer=null;
		padre= pa;
		color= 0;
	}
}
