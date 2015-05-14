/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Arbolesparaproyecto.ArbolHeap;
import Arbolesparaproyecto.ListaDE;
import Arbolesparaproyecto.arbolRojiNegro;
import Arbolesparaproyecto.árbolAVL;
import static Logica.Constantes_para_logica.DIRECTORIO_ARCHIVO;
import static Logica.Constantes_para_logica.DIRECTORIO_COMPUTADORA;
import static Logica.Constantes_para_logica.PESO_ASOCIADO;
import static Logica.Constantes_para_logica.SEPARADOR;

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import org.jdom2.input.SAXBuilder;

/**
 * Lee los parametros del xml para poder inicializar las listas
 *
 * @author rafael, anderson
 * Este método se encarga de cargar el archivo xml con las urls y el peso asociado 
 * para que los con la dirección de los archivos sean creados y enviados para obtener
 * las palabras

 * *@param xmlFile
 * *@param lo
 * *@param Listaurl
 * *@param Leer1
 */
public class Lecturaxml {

    public void Lecturaxml(String xmlFile
                          ,ListaDE pLista_doble_enlazada_para_la_salida_del_heap
                          ,Lectura_de_archivos pLlama_a_clase_lectura_de_archivos
                          ,arbolRojiNegro pArbol_para_rojonegro
                          ,árbolAVL pArbol_para_avl
                          ,ListaDE pLista_doble_enlazada_para_arbol)
                           throws JDOMException, IOException {

        Arbolesparaproyecto.Nodoparaheap[] lista_heap_final;
        Lecuradeconfiguracion referencia_clase_Lecuradeconfiguracion
                                       = new Lecuradeconfiguracion();
        ListarDirectorioRecursivamente referencia_clase_ListarDirectorioRecursivamente 
                                       = new ListarDirectorioRecursivamente();
       
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren();
        ArbolHeap arbol_para_heap = new ArbolHeap();

        for (Object list1 : list) {
            Element node = (Element) list1;
            String valor = node.getValue();
            String numeroasociado = node.getAttributeValue(PESO_ASOCIADO);
            String etiqueta = node.getName();
            if (DIRECTORIO_ARCHIVO.equals(etiqueta)) {
                String sDirectorio = valor;
                File directorio = new File(sDirectorio);

              referencia_clase_ListarDirectorioRecursivamente.listarDirectorio(
                                                 directorio
                                                 ,SEPARADOR
                                                 ,Integer.parseInt(numeroasociado)
                                                 ,DIRECTORIO_COMPUTADORA
                                                 , valor,arbol_para_heap);

            } else {
                arbol_para_heap.inserta(Integer.parseInt(numeroasociado), etiqueta, valor);
            }
        }

        lista_heap_final = arbol_para_heap.muestra();

        referencia_clase_Lecuradeconfiguracion.Lecturaconfig(
                         lista_heap_final
                        ,pLista_doble_enlazada_para_la_salida_del_heap
                        ,pLlama_a_clase_lectura_de_archivos
                        ,pArbol_para_rojonegro
                        ,pArbol_para_avl
                        ,pLista_doble_enlazada_para_arbol);

    }
}
