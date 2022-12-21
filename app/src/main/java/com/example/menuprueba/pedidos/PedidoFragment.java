package com.example.menuprueba.pedidos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menuprueba.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PedidoFragment extends Fragment {
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private static final String DIR_ARCHIVO = "./src/prueba/pedidos/pedidos.xml";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PedidoFragment newInstance(String param1, String param2) {
        PedidoFragment fragment = new PedidoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_pedido, container, false);
    }

    public static void leerPedidos() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(DIR_ARCHIVO));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName().toUpperCase());
            NodeList listapedidos = doc.getElementsByTagName("pedido");

            for (int cualItem = 0; cualItem < listapedidos.getLength(); cualItem++) {
                Node node = listapedidos.item(cualItem);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    ArrayList<Detalle> detalles = new ArrayList<>();
                    Pedido pedido;
                    int partner, factura, trans, comer;

                    try {
                        partner = Integer.parseInt(element.getElementsByTagName("partner").item(0).getTextContent());
                    } catch (NumberFormatException enu) {
                        partner = 0;
                    }

                    try {
                        factura = Integer.parseInt(element.getElementsByTagName("factura").item(0).getTextContent());
                    } catch (NumberFormatException enu) {
                        factura = 0;
                    }
                    try {
                        trans = Integer.parseInt(element.getElementsByTagName("transportista").item(0).getTextContent());
                    } catch (NumberFormatException enu) {
                        trans = 0;
                    }
                    try {
                        comer = Integer.parseInt(element.getElementsByTagName("comercial").item(0).getTextContent());
                    } catch (NumberFormatException enu) {
                        comer = 0;
                    }
                    NodeList detallesList = element.getElementsByTagName("detalle");

                    for (int cualDetalle = 0; cualDetalle < detallesList.getLength(); cualDetalle++) {
                        Node nodo = detallesList.item(cualDetalle);
                        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                            Element linea = (Element) nodo;
                            Detalle detalle;
                            int articulo, cantidad, precio;

                            try {
                                articulo = Integer.parseInt(linea.getElementsByTagName("articulo").item(0).getTextContent());
                            } catch (NumberFormatException enu) {
                                articulo = 0;
                            }
                            try {
                                cantidad = Integer.parseInt(linea.getElementsByTagName("cantidad").item(0).getTextContent());
                            } catch (NumberFormatException enu) {
                                cantidad = 0;
                            }
                            try {
                                precio = Integer.parseInt(linea.getElementsByTagName("precio").item(0).getTextContent());
                            } catch (NumberFormatException enu) {
                                precio = 0;
                            }

                            detalle = new Detalle(articulo, cantidad, precio);
                            detalles.add(detalle);
                        }
                    }

                    pedido = new Pedido(partner, factura, trans, comer, detalles);
                    pedidos.add(pedido);
                }
            }
        } catch (ParserConfigurationException ep) {
            System.err.println("ERROR. Configuración de parse incorrecta.");
        } catch (IOException eio) {
            System.err.println("ERROR. Fallo en lectura de archivo.");
        } catch (SAXException esax) {
            System.err.println("ERROR. SAX exception.");
        } catch (NullPointerException en) {
            System.err.println("ERROR. XML mal formado o etiqueta buscada inexistente.");
        }
    }
}