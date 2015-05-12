/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Arbolesparaproyecto.ListaDE;
import Arbolesparaproyecto.NodoDE;
import Arbolesparaproyecto.Nodoparaheap;
import Arbolesparaproyecto.arbolRojiNegro;
import Arbolesparaproyecto.árbolAVL;
import static Enlace.Constantes_para_enlace.ARCHIVO_EN_EL_QUE_ESTAN_LAS_CONFIGURACIONES;
import static Logica.Constantes_para_logica.SUMATORIA;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tika.exception.TikaException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


/**
 *
 * @author rafael
 */
public class Lecuradeconfiguracion {

    int contador = 0, maxthreads = 0, recursivity = 0, reindex = 0;

    NodoDE Node_de_heap;

    public void Lecturaxml(
                              Nodoparaheap[] lista_heap_final
                            , ListaDE lista_doble_enlazada_para_la_salida_del_heap 
                            , Lectura_de_archivos pLlama_a_clase_lectura_de_archivos
                            , arbolRojiNegro pArbol_para_rojonegro
                            , árbolAVL pArbol_para_avl
                            , ListaDE pLista_doble_enlazada_para_arbol)
                            throws JDOMException, IOException {

        while (lista_heap_final[contador] != null) {

            lista_doble_enlazada_para_la_salida_del_heap .insertTail(
                                      lista_heap_final[contador].codl
                                    , lista_heap_final[contador].directorio
                                    , lista_heap_final[contador].nombre);
         
            contador = contador + SUMATORIA;
        }
        SAXBuilder builder = new SAXBuilder();
        Document document = (Document) 
        builder.build(ARCHIVO_EN_EL_QUE_ESTAN_LAS_CONFIGURACIONES);
        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren();
        String configuracion[] = new String[3];

        for (int e = 0; e < list.size(); e++) {

            Element node = (Element) list.get(e);

            
            configuracion[e] = node.getValue();

        }

        maxthreads = Integer.parseInt(configuracion[0]);
        recursivity = Integer.parseInt(configuracion[1]);
        reindex = Integer.parseInt(configuracion[2]);

        final CyclicBarrier barreraInicio = new CyclicBarrier(maxthreads +SUMATORIA);
        final CyclicBarrier barreraFin = new CyclicBarrier(maxthreads+ SUMATORIA);

        for (int i = 0; i < maxthreads; i++) {
            Thread hilo = new Thread("h" + i) {
                @Override
                public void run() {

                    try {
                        barreraInicio.await();
                        while (lista_doble_enlazada_para_la_salida_del_heap .MostrarNodo() != null) {

                            synchronized (lista_doble_enlazada_para_la_salida_del_heap ) {

                                Node_de_heap= lista_doble_enlazada_para_la_salida_del_heap .MostrarNodo();
                                System.out.println(Node_de_heap.Url);
                                lista_doble_enlazada_para_la_salida_del_heap .BorrarHead();
                                pLlama_a_clase_lectura_de_archivos.archivos(
                                                        Node_de_heap.nLlave
                                                      , Node_de_heap.directorio
                                                      , Node_de_heap.Url
                                                      , pArbol_para_rojonegro
                                                      , pArbol_para_avl
                                                      , pLista_doble_enlazada_para_arbol);

                            }

                        }

                    } catch (InterruptedException | BrokenBarrierException 
                                           | IOException | TikaException ex) {
                        Logger.getLogger(Lecuradeconfiguracion.class.getName()).log
                                                             (Level.SEVERE, null, ex);
                    }

                    try {
                        barreraFin.await();

                    } catch (InterruptedException | BrokenBarrierException ex) {
                        Logger.getLogger(Lecuradeconfiguracion.class.getName()).log
                                                           (Level.SEVERE, null, ex);
                    }

                }

            };
            hilo.start();

        }

        try {

            barreraInicio.await();
            barreraFin.await();

        } catch (InterruptedException | BrokenBarrierException e) {
        }
        pArbol_para_rojonegro.imprimirArbol(pArbol_para_rojonegro.raiz);
        pArbol_para_avl.Inorden(pArbol_para_avl.root);
        while (pLista_doble_enlazada_para_arbol != null) {
            NodoDE nodo_lista_enlazada = pLista_doble_enlazada_para_arbol.MostrarNodo();
            pArbol_para_avl.insertar(nodo_lista_enlazada.nLlave, nodo_lista_enlazada.directorio);
            pLista_doble_enlazada_para_arbol.BorrarHead();
        }
      //  System.out.println(lo.ImprimirNodo());

      //  System.out.println(listaurl.mostrar());
        //  System.out.println(listadoble.mostrardesdeHead());
    }
}
