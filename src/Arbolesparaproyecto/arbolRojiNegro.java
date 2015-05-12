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
public class arbolRojiNegro{
	String outm;
	String rota;
	public nodoRojiNegro raiz;
	public static final int rojo=0;
	public static final int negro=1;
	
	//crea el arbol
	public arbolRojiNegro(){
	}
	
	//crea el arbol con la llave
	public arbolRojiNegro(int codcu,String url){
		raiz = new nodoRojiNegro(codcu, url);
		raiz.color = negro;
	}
	
	//Inserta una llave en el arbol roji-negro
	public nodoRojiNegro Insertar(int codcu,nodoRojiNegro t,String url){
		raiz=t;
		try{
			          
			if (estaVacio()){
		  		raiz = new nodoRojiNegro(codcu, url);
		  		raiz.color = negro;
		  		
				
			}
			else
		  		raiz = insertaraux(codcu,t, url);
		}
		catch(Exception e){
		}
		return raiz;
	}
	
	//Ayuda al metodo de insertar
	public nodoRojiNegro insertaraux(int codcu, nodoRojiNegro t,String url) {
		try{
			//Insercion normal, y le asigna el padre en otra referencia
			nodoRojiNegro y=null;
			nodoRojiNegro x = t;
			while (x != null){
		  	y = x;
		  	if (codcu < x.Codcur)
		    	x = x.hIzq;
		  	else
		    	x = x.hDer;
			}
			nodoRojiNegro z = new nodoRojiNegro(codcu,y, url);
			if (codcu < y.Codcur)
		 		y.hIzq = z;
			else
		  		y.hDer = z;
		  	
			
			rota=rota+"Elemento: " +z.Codcur+"\n";
			//inserta en el arbol para arreglarlo
			t = insertarArreglado(t, z);
		}
		catch(Exception e){
		}
		return t;
	}
	
  	//Recibe la raiz con el elemento metido y el elemento
  	//para arreglarlo 
	public nodoRojiNegro insertarArreglado(nodoRojiNegro t, nodoRojiNegro z){
		try{
			
			//si el padre z es rojo
			while ((z.padre != null) && (z.padre.padre != null) && (z.padre.color == rojo)){
			  //si el padre es hijo izquierdo de abuelo
				if (z.padre == z.padre.padre.hIzq){
					nodoRojiNegro y = z.padre.padre.hDer;
			        //si el tio de z tambien es rojo
			        if (y!=null && y.color == rojo){
						//cambia al tio de z negro, al padre de z negro
						
						rota=rota+"Cambio de color\n";
						z.padre.color = negro;
						y.color = negro;
						z.padre.padre.color = rojo;
						z = z.padre.padre;
			        }
			        else {
			        	//Si z es hijo derecho
						if (z.padre.hDer!=null && z == z.padre.hDer) {
							
							rota=rota+"Rotacion Izquierda\n";
							z = z.padre;
							t = rotarIzq(t, z);
						}
						else{
							
							rota=rota+"Rotacion Derecha\n";
							//Caso 3
							z.padre.color = negro;
							z.padre.padre.color = rojo;
							t = rotarDer(t, z.padre.padre);
						}
			        }
			  	}
		  	//Si el padre de z es hijo derecho
				else{
					nodoRojiNegro y = z.padre.padre.hIzq;
					//si el tio de z es rojo
					if (y!=null && y.color == rojo) {
					  // cambiar colores
					 
					  rota=rota+"Cambio de color\n";
					  z.padre.color = negro;
					  y.color = negro;
					  z.padre.padre.color = rojo;
					  z = z.padre.padre;
					}
					else {
					  //si z es hijo izquierdo
					  if (z == z.padre.hIzq) {
					  	
					  	rota=rota+"Rotacion Derecha\n";
					    z = z.padre;
					    t = rotarDer(t, z);
					  }
					  else{
					  	
					  	rota=rota+"Rotacion Izquierda\n";
					  	//Caso 3
					  	z.padre.color = negro;
					  	z.padre.padre.color = rojo;
					  	t = rotarIzq(t, z.padre.padre);
					  }
					} 
				}
			}
			
		}
		catch (Exception e){
			
		}
		t.color = negro;
		return t;
	}
	
	//rotacion izquierda
	public nodoRojiNegro rotarIzq(nodoRojiNegro t, nodoRojiNegro x) {
		nodoRojiNegro y = x.hDer;
		x.hDer = y.hIzq;
		if (y.hIzq != null)
		  y.hIzq.padre = x;
		y.padre = x.padre;
		if (x.padre == null)
		  t = y;
		else if (x == x.padre.hIzq)
		  x.padre.hIzq = y;
		else
		  x.padre.hDer = y;
		y.hIzq = x;
		x.padre = y;
		return t;
	}
	
	//rotacion derecha
	public nodoRojiNegro rotarDer(nodoRojiNegro t, nodoRojiNegro x) {
		nodoRojiNegro y = x.hIzq;
		x.hIzq = y.hDer;
		if (y.hDer != null)
		  y.hDer.padre = x;
		y.padre = x.padre;
		if (x.padre == null)
		  t = y;
		else if (x == x.padre.hIzq)
		  x.padre.hIzq = y;
		else
		  x.padre.hDer = y;
		y.hDer = x;
		x.padre = y;
		return t;
	}
	
	//busca un elemento
	public boolean Miembro(int x, nodoRojiNegro r){
		raiz=r;
		boolean si=false;
		nodoRojiNegro temp = raiz;
		while (temp != null && si==false) {
		  if(x==temp.Codcur){
		  	si=true;
		  }
		  else{
		  	if (x < temp.Codcur)
		    	temp = temp.hIzq;
		    else
		    	if(x > temp.Codcur)
		    		temp = temp.hDer;
		  }
		}
		return si;
	} 
	
	//retorna true si el arbol esta vacio
	public boolean estaVacio(){
		return (raiz == null);
	}
	
	//Imprime en inorden
	public void Imprimir(nodoRojiNegro t){
		if(estaVacio())
		  System.out.println("Arbol Vacio");
		else
		  imprimirArbol(t);
	}
	
	//auxiliar
	public void imprimirArbol(nodoRojiNegro t){
		if(t != null){
	      imprimirArbol(t.hIzq);
	      if(t.color==1)
	      	System.out.println(t.Codcur + " negro "+t.url);
	      else
	      	System.out.println(t.Codcur + " rojo "+t.url);
	      imprimirArbol(t.hDer);
		}
    }
}

