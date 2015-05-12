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
public class ListaDE extends NodoDE {
   NodoDE head;
   NodoDE tail;
    public ListaDE(int nLlave,String directorio,String Url,NodoDE Next,NodoDE Prev){
        super( nLlave=0, directorio=null,Url=null, Next=null,Prev=null);
        head=null;
        tail=null;
    }

    
   public   NodoDE  MostrarNodo(){
            NodoDE aux=head;
           if(aux==null){
            return null;
           }
       
          
         return (aux);
    }
    
    public void insertHead(int nLlave,String directorio,String Url){
        NodoDE temp=new NodoDE(nLlave, directorio, Url,null,null);
       
        if(head==null){
            head=temp;
            tail=temp;
        }
        else{
            temp.Next=head;
            head.Prev=temp;
            head=temp;
        }
    }
    public void insertTail(int nLlave,String directorio,String Url){
        NodoDE temp=new NodoDE(nLlave, directorio, Url,null,null);
       
        if(head==null){
            head=temp;
            tail=temp;
        }else{
            tail.Next=temp;
            temp.Prev=tail;
            tail=temp;
        }
    }
    public void BorrarHead(){
        if(head.Next==null){
           head=null;
           
        }
        else{
        head=head.Next;
        head.Prev=null;
        }
    }
    public void BorrarTail(){
        if(tail.Prev==null){
            head=null;
            tail=null;
        }else{
            tail=tail.Prev;
            tail.Next=null;
        }
    }
    
    public void buscarNodo(int Dato,String directorio1){
        NodoDE actual;
        actual=tail;
      if (actual==null){
          insertHead( Dato,directorio1,null);
         
        }
    
            
         
        while(actual!=null){
            //System.out.println(directorio1+actual.directorio);
        if(actual.directorio == null ? directorio1 == null : actual.directorio.equals(directorio1)){
            actual.nLlave=actual.nLlave+1;
           break;
        }
        actual=actual.Prev;
   }
         if (actual==null){
          insertHead( Dato,directorio1,null);
         
        }
    }
 public String mostrardesdeHead(){
        NodoDE actual;
        actual=head;
        String respuesta="";
        if(actual==null){
            return null;
        }
        do{
            respuesta= respuesta+actual.nLlave+actual.directorio+actual.Url;
            actual=actual.Next;
           
            
        }
      
        while(actual!=null);
           return(respuesta);
    }

public void mostrardesdeTail(){
        NodoDE actual;
        actual=tail;
        
        do{
            System.out.println( actual.nLlave+actual.directorio+actual.Url);
            actual=actual.Prev;
        }
        while(actual!=null);
    } 
}
