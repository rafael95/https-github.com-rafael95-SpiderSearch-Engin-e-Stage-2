/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Arbolesparaproyecto.ArbolHeap;
import static Logica.Constantes_para_logica.REQURIMIENTO_PARA_DIRECTORIO;
import static Logica.Constantes_para_logica.SEPARADOR_PALABRA;
import java.io.File;

/**
 *
 * @author rafael
 */
public class ListarDirectorioRecursivamente {

    public void listarDirectorio(
                                 File pArchivo_url
                               , String pseparador
                               , int pNumeroasociado
                               , String pdirectorio
                               , String pvalor
                               , ArbolHeap arbol_para_heap) {
       
        File[] ficheros = pArchivo_url.listFiles();

        for (File fichero : ficheros) {
            pNumeroasociado = pNumeroasociado + 1;
           arbol_para_heap.inserta(pNumeroasociado, pdirectorio, pvalor + 
                         REQURIMIENTO_PARA_DIRECTORIO + fichero.getName());
            
           if (fichero.isDirectory()) {
                String nuevo_separador;
                nuevo_separador = pArchivo_url+ SEPARADOR_PALABRA;
                listarDirectorio(
                            fichero
                          , nuevo_separador
                          , pNumeroasociado
                          , pdirectorio
                          , pvalor
                          , arbol_para_heap);
            }
        }
    }
}
