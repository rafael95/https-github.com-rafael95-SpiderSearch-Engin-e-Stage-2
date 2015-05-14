/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Arbolesparaproyecto.ListaDE;
import Arbolesparaproyecto.arbolRojiNegro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Arbolesparaproyecto.árbolAVL;
import static Logica.Constantes_para_logica.REGEX_HIPER_PATTER;

/**
 *Clase para obtener palabras de un texto
 * @author rafael, anderson
 * * @param filtro1
 */
public class Filtroparatexto {
int NUMERO_DE_PALABRAS_EN_LOS_ARCHIVOS=0;
   
    /**
 *Metodo para obtener palabras de un texto
 * @author rafael, anderson
     * @param ptexto
     * @param pvalor
     * @param pdirectorio
     * @param purl
     * @param parbol_para_rojonegro
     * @param parbol_para_avl
     * @param plista_doble_enlazada_para_arbol
 */
    
    public void Filtroparatexto(String ptexto,int pvalor,String pdirectorio,
                                String purl, arbolRojiNegro parbol_para_rojonegro,
                                árbolAVL  parbol_para_avl,
                                ListaDE plista_doble_enlazada_para_arbol) {

    
        
        Pattern p = Pattern.compile(REGEX_HIPER_PATTER);
        Matcher m = p.matcher(ptexto);
        while (m.find()) {
          NUMERO_DE_PALABRAS_EN_LOS_ARCHIVOS=NUMERO_DE_PALABRAS_EN_LOS_ARCHIVOS+1;  
       //  System.out.println(m.group());
         plista_doble_enlazada_para_arbol.buscarNodo(1, m.group());
           
        }
      
       
    parbol_para_rojonegro .Insertar(NUMERO_DE_PALABRAS_EN_LOS_ARCHIVOS,
                                     parbol_para_rojonegro .raiz, purl);
     System.out.println(NUMERO_DE_PALABRAS_EN_LOS_ARCHIVOS);
    plista_doble_enlazada_para_arbol.mostrardesdeTail();
    }

}
