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
public class ArbolHeap {
   // Arreglo en el cual se almacenan los elementos.
	  Nodoparaheap[] llave;
	// Posici�n en la cual se va a insertar.
	int posicion;
	
	//Contructor
	public ArbolHeap(){
	
                 llave = new Nodoparaheap[100];
		posicion = 0;
	}
	
	//Obtiene el hijo derecho seg�n la posicion del padre
	public int hDer(int posPadre){
		return (2 * posPadre) + 1;
	}
	
	//Obtiene el hijo izquierdo seg�n la posicion del padre
	public int hIzq(int posPadre){
		return (2 * posPadre);
	}
	
	//Inserta un elemento dentro del arbol de Heap.
	public void inserta(int nLlave,String directorio,String Url){
             Nodoparaheap hola = new Nodoparaheap(nLlave,directorio,Url);
              Nodoparaheap auxiliar ;
		int padre;
		
		int siguiente;
		siguiente = posicion;
		padre = (siguiente / 2);
		if(padre < 0)
			padre = 0;
		llave[siguiente] = hola;
		// se acomodan los elementos para que el padre sea mayor que cualquiera de los hijos.
		while((siguiente != 0) && (llave[padre].codl <= llave[siguiente].codl)){
			auxiliar = llave[padre];
			llave[padre] = llave[siguiente];
			llave[siguiente] = auxiliar;
			siguiente = padre;
			padre = (siguiente / 2);
		}
		posicion++;
	}
	
	//Ordena el �rbol de manera que quede en una cola de prioridad.
	public void HeapSort(){
		int padre, hijo;
		int ultima = posicion-1;
                  Nodoparaheap llaveAnterior ;
		for(int i = 10; i >= 1;i--){	
			llaveAnterior = llave[ultima];
			llave[ultima] = llave[0];
			ultima = ultima - 1; 
			padre = 0;
			if((ultima >= 2) && (llave[2].codl > llave[1].codl))
				hijo = 2;	
			else
				hijo = 1;
			while((hijo <= ultima) && (llave[hijo].codl > llaveAnterior.codl)){
				llave[padre] = llave[hijo];
				padre = hijo;
				hijo = padre * 2;
				if(((hijo + 1) <= ultima) && (llave[hijo + 1].codl > llave[hijo].codl))
					hijo++;	
				
				
			}
			llave[padre] = llaveAnterior;
			
		}
	}
	
	//Muestra al arreglo
	
	
	//Muestra sin mandarlo al archivo
	public Nodoparaheap[] muestra(){
		
		int i = 0;	
              Nodoparaheap[] impresor = new Nodoparaheap[100];
             
		while( i <= 99){	
			if(llave[i]==null){
				return impresor;
			}
			else{		
				impresor[i]=llave[i];
			}	
			i++;
		}
		return impresor;
	}

}
