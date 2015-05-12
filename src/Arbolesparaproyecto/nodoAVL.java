package Arbolesparaproyecto;
/**
 *
 * @author anderson
 */
public class nodoAVL {
    int dato,factorEquilibrio;
    String palabra;
    nodoAVL hijoIzquierdo;
    nodoAVL hijoDerecho;
    public nodoAVL(int dato,String palabra){
        this.dato=dato;
        this.factorEquilibrio=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
        this.palabra=palabra;
    }
}
