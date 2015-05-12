/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enlace;

import java.io.IOException;
import org.jdom2.JDOMException;

import Arbolesparaproyecto.ListaDE;
import Arbolesparaproyecto.arbolRojiNegro;
import Arbolesparaproyecto.árbolAVL;

import static Enlace.Constantes_para_enlace.ARCHIVO_EN_EL_QUE_ESTAN_LAS_URLS_INICIALES;
import Logica.Lectura_de_archivos;
import Logica.Lecturaxml;

/**
 *
 * @author rafael
 */
public class SpiderSearch {

    /**
     * @param args the command line arguments
     * @throws org.jdom2.JDOMException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws JDOMException, IOException {
        ListaDE lista_doble_enlazada_para_arbol = new ListaDE(0, null, null
                                                               , null, null);
        árbolAVL arbol_para_avl = new árbolAVL();
        arbolRojiNegro arbol_para_rojonegro = new arbolRojiNegro();
        Lectura_de_archivos llama_a_clase_lectura_de_archivos = new Lectura_de_archivos();
        ListaDE  lista_doble_enlazada_para_la_salida_del_heap = new ListaDE(0, 
                                                       null, null, null, null);
        Lecturaxml llama_a_la_clase_Lecturaxml = new Lecturaxml();
        llama_a_la_clase_Lecturaxml .Lecturaxml(
                        ARCHIVO_EN_EL_QUE_ESTAN_LAS_URLS_INICIALES
                        , lista_doble_enlazada_para_la_salida_del_heap
                        , llama_a_clase_lectura_de_archivos
                        ,arbol_para_rojonegro
                        ,arbol_para_avl 
                        ,lista_doble_enlazada_para_arbol);

       
    }

}
