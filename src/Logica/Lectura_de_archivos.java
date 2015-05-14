/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Arbolesparaproyecto.ListaDE;
import Arbolesparaproyecto.arbolRojiNegro;
import Arbolesparaproyecto.árbolAVL;
import static Logica.Constantes_para_logica.CONTRASEÑA;
import static Logica.Constantes_para_logica.DIRECTORIO_COMPARTIDO;
import static Logica.Constantes_para_logica.DIRECTORIO_COMPUTADORA;
import static Logica.Constantes_para_logica.DIRECTORIO_RED;
import static Logica.Constantes_para_logica.USUARIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

/**
 *clase que se encarga de obtener los archivos de los lugares donde son contenidos 
 * ya sea carpetas compartidas, urls, asrchivos de computadora y los convierte en 
 * un string para mandarselo a la clase Filtro para texto
 * @author rafael
 */
public class Lectura_de_archivos {

    public void archivos(int pvalor, String pdirectorio, String purl
                         ,arbolRojiNegro parbol_para_rojonegro
                         ,árbolAVL parbol_para_avl
                         ,ListaDE  plista_doble_enlazada_para_arbol) 
                          throws IOException, TikaException {

        Filtroparatexto referencia_de_la_clase_Filtroparatexto= new Filtroparatexto();
        String filecontent = null;

        if (DIRECTORIO_COMPUTADORA.equals(pdirectorio)) {

            File file = new File(purl);
            Tika tika = new Tika();
            filecontent = tika.parseToString(file);

        }
        if (DIRECTORIO_RED.equals(pdirectorio)) {
            URL file = new URL(purl);
            Tika tika = new Tika();
            filecontent = tika.parseToString(file);

        }

        if (DIRECTORIO_COMPARTIDO.equals(pdirectorio)) {

            String user = USUARIO + ":" + CONTRASEÑA;
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
            SmbFile sFile = new SmbFile(purl, auth);
            SmbFileInputStream archivo_compartivo = new SmbFileInputStream(sFile);
            Tika tika = new Tika();
            String filecontent1 = tika.parseToString( archivo_compartivo);
            filecontent = filecontent1;

        }

        referencia_de_la_clase_Filtroparatexto.Filtroparatexto(filecontent
                                               ,pvalor, pdirectorio, purl
                                               ,parbol_para_rojonegro
                                               ,parbol_para_avl
                                               ,plista_doble_enlazada_para_arbol);
    }

}
