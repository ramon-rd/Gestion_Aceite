package com.example.aceite;

import android.os.Environment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by USUARIO on 29/05/2014.
 */
public class Pedidos {
    String cliente="";
    String cantidad="";
    String fecha="";

    /**
     * Constructor vacío. Lo implemento para no recibir nullpointerexception en la creacion de la actividad
     */
    public Pedidos() {
    }

    public String getCliente(){
        return cliente;
    }
    public String getCantidad(){
        return cantidad;
    }
    public String getFecha(){
        return fecha;
    }

        /**
         * Serializa a xml el pedido
         */
        void toXML () {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            try {
                docBuilder = docFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

            // root elements
            Document doc = docBuilder.newDocument();
            Element cliente = doc.createElement("Cliente");
            doc.appendChild(cliente);


            // set attribute to staff element
            cliente.setAttribute("cliente", this.cliente);
            cliente.setAttribute("cantidad", this.cantidad);
            cliente.setAttribute("fecha", this.fecha);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {

                File sdcard = Environment.getExternalStorageDirectory();
                File directorio = new File(sdcard.getAbsolutePath() + "/pedidos/");

                if (directorio.exists() == false) {
                    directorio.mkdirs();
                }

                transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);

                StreamResult result = new StreamResult(new File(sdcard.getAbsolutePath() + "/pedidos/" + this.cliente + ".xml"));

                transformer.transform(source, result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void LeerPedidos(String nombre) {
            File sdcard = Environment.getExternalStorageDirectory();
            File fXmlFile = new File(sdcard+"/pedidos/"+nombre);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
                Element player = (Element) doc.getElementsByTagName("Cliente").item(0);
                this.cliente = player.getAttribute("cliente");
                this.cantidad = player.getAttribute("cantidad");
                this.fecha = player.getAttribute("fecha");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }