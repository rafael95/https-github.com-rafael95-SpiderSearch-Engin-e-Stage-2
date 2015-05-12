package Arbolesparaproyecto;
/**
 *
 * @author anderson
 */
public class árbolAVL {
    public nodoAVL root;
    
    public árbolAVL(){
        root=null;
    }
    //Método que busca un nodo ingresado
   
    
    
     public void Inorden ( nodoAVL Nodo){	
		if(Nodo == null)
			return ;
		else{
			Inorden (Nodo.hijoIzquierdo);
			System.out.print(Nodo.dato + " "+Nodo.palabra);
			Inorden (Nodo.hijoDerecho);
		}
	}
    //Método para obtener el factor equilibrio
     public nodoAVL buscar(int Dato, nodoAVL Root){
        if(root==null){
            return null;
        }else if(Root.dato==Dato){
            return Root;            
        }else if(Root.dato<Dato){
            return buscar(Dato,Root.hijoDerecho);
        }else{
            return buscar(Dato,Root.hijoIzquierdo);
        }
    }
    //Método para obtener el factor equilibrio
    public int obtenerFactorEquilibrio(nodoAVL nodo){
        if(nodo==null){
            return -1;
        }else{
            return nodo.factorEquilibrio;
        }
    }
    //Rotación simple a la izquierda
    public nodoAVL rotacionIzquierda(nodoAVL nodo){
        nodoAVL auxiliar=nodo.hijoIzquierdo;
        nodo.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=nodo;
        nodo.factorEquilibrio=Math.max(obtenerFactorEquilibrio(nodo.hijoIzquierdo),obtenerFactorEquilibrio(nodo.hijoDerecho))+1;
        auxiliar.factorEquilibrio=Math.max(obtenerFactorEquilibrio(nodo.hijoIzquierdo),obtenerFactorEquilibrio(nodo.hijoDerecho))+1;
        return auxiliar;
    }
    //Rotación simple a la derecha
    public nodoAVL rotacionDerecha(nodoAVL nodo){
        nodoAVL auxiliar=nodo.hijoDerecho;
        nodo.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=nodo;
        nodo.factorEquilibrio=Math.max(obtenerFactorEquilibrio(nodo.hijoDerecho),obtenerFactorEquilibrio(nodo.hijoIzquierdo))+1;
        auxiliar.factorEquilibrio=Math.max(obtenerFactorEquilibrio(nodo.hijoDerecho),obtenerFactorEquilibrio(nodo.hijoIzquierdo))+1;
        return auxiliar;
    }
    //Rotación doble a la izquierda
    public nodoAVL rotacionDobleIzquierda(nodoAVL nodo){
        nodoAVL temp;
        nodo.hijoIzquierdo=rotacionDerecha(nodo.hijoIzquierdo);
        temp=rotacionIzquierda(nodo);
        return temp;
    }
    //Rotación doble a la derecha
    public nodoAVL rotacionDobleDerecha(nodoAVL nodo){
        nodoAVL temp;
        nodo.hijoDerecho=rotacionDerecha(nodo.hijoIzquierdo);
        temp=rotacionDerecha(nodo);
        return temp;
    }
    //Método para insertar nodos de forma equilibrada
    public nodoAVL insertarAVL(nodoAVL nuevo, nodoAVL subArbol){
        nodoAVL nuevoPadre=subArbol;
        if(nuevo.dato<subArbol.dato){
            if(subArbol.hijoIzquierdo==null){
                subArbol.hijoIzquierdo=nuevo;
            }else{
                subArbol.hijoIzquierdo=insertarAVL(nuevo,subArbol.hijoIzquierdo);
                if((obtenerFactorEquilibrio(subArbol.hijoIzquierdo)-obtenerFactorEquilibrio(subArbol.hijoDerecho)==2)){
                    if(nuevo.dato<subArbol.hijoIzquierdo.dato){
                        nuevoPadre=rotacionIzquierda(subArbol);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subArbol);
                    }                    
                }
            }
        }else if(nuevo.dato>subArbol.dato){
            if(subArbol.hijoDerecho==null){
                subArbol.hijoDerecho=nuevo;
            }else{
                subArbol.hijoDerecho=insertarAVL(nuevo,subArbol.hijoDerecho);
                if((obtenerFactorEquilibrio(subArbol.hijoDerecho)-obtenerFactorEquilibrio(subArbol.hijoIzquierdo)==2)){
                    if(nuevo.dato>subArbol.hijoDerecho.dato){
                        nuevoPadre=rotacionDerecha(subArbol);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subArbol);
                    }
                }
            }
        }else{
            System.out.println("nodo repetido");
        }
        //Actualizar la altura
        if((subArbol.hijoIzquierdo==null) && (subArbol.hijoDerecho!=null)){
            subArbol.factorEquilibrio=subArbol.hijoDerecho.factorEquilibrio+1;            
        }else if((subArbol.hijoDerecho==null)&&(subArbol.hijoIzquierdo!=null)){
            subArbol.factorEquilibrio=subArbol.hijoIzquierdo.factorEquilibrio+1;
        }else{
            subArbol.factorEquilibrio=Math.max(obtenerFactorEquilibrio(subArbol.hijoIzquierdo), obtenerFactorEquilibrio(subArbol.hijoDerecho))+1;
        }
        return nuevoPadre;
    }
    //Método que inserta simple
    public void insertar(int dato,String palabra){
        nodoAVL nuevo=new nodoAVL(dato,palabra);
        if(root==null){
            root=nuevo;
        }else{
            root=insertarAVL(nuevo,root);
        }
}}