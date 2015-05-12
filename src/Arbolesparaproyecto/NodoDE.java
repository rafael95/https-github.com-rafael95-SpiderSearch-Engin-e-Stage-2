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
public class NodoDE {
 public   int nLlave;
  public    String directorio;
  public    String Url;
   NodoDE Next;
   NodoDE Prev;
  public  NodoDE(int nLlave,String directorio,String Url,NodoDE Next,NodoDE Prev){
        this.nLlave=nLlave;
       this.directorio=  directorio;
         this.Url=Url;
      this.Prev=  Prev;
        this.Next=Next;
}

   
    
}
