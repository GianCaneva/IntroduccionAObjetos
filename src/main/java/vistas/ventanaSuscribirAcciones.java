package vistas;
import controller.ControladorOperacion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControladorOperacion;
import controller.ControladorOperacion;
import controller.ControladorSocio;


public class ventanaSuscribirAcciones extends JFrame {
    private JTextField jtCuit, jtVendedor,jtprecio,jtPorcentaje,jtCantidad;
    private JComboBox<String> jcOperaciones, jcOperaciones2, jcOperaciones3;
    private JLabel jlCuit, jlprecio, jlVendedor, jlCantidad, jlPorcentaje2;
    private String valor;
    private int a, b;
    private ArrayList<String> operacionesArrayList;
    private float mora = 0;

    private JLabel jlPorcentaje, jlResultado1, jlResultado2;


    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaSuscribirAcciones tester = new vistas.ventanaSuscribirAcciones();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaSuscribirAcciones() {

        // String[] operacionesArraylist = new String[""];

//        setTitle("Calculo de Porcentaje Comision");
        setTitle("Suscribir Acciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(170, 10, 80, 18);
        add(jtCuit);
        jlVendedor = new JLabel("Ingrese Cuit Vendedor: ");
        jlVendedor.setBounds(10,35,160,18);
        add(jlVendedor);
        jtVendedor = new JTextField();
        jtVendedor.setBounds(170,35,80,18);
        add(jtVendedor);
        jlPorcentaje = new JLabel("Ingrese Porcentaje:");
        jlPorcentaje.setBounds(10,60,160,18);
        add(jlPorcentaje);
        jtPorcentaje = new JTextField();
        jtPorcentaje.setBounds(170,60,80,18);
        add(jtPorcentaje);
        jlprecio = new JLabel("Ingrese Precio Unitario:");
        jlprecio.setBounds(10,90,160,18);
        add(jlprecio);
        jtprecio = new JTextField();
        jtprecio.setBounds(170,90,80,18);
        add(jtprecio);

        jlCantidad = new JLabel("Ingrese Cantidad Acciones:");
        jlCantidad.setBounds(10,120,160,18);
        add(jlCantidad);
        jtCantidad = new JTextField();
        jtCantidad.setBounds(170,120,80,18);
        add(jtCantidad);



//        jlOperacion = new JLabel("Seleccione Operacion:");
//        jlOperacion.setBounds(10,105,200,18);
//        add(jlOperacion);

//
//        jcOperaciones = new JComboBox<String>();
//        jcOperaciones.setBounds(10, 130, 200, 18);
//        add(jcOperaciones);
//        jcOperaciones.addItem("ChequePropio");
//        jcOperaciones.addItem("ChequeDeTerceros");
//        jcOperaciones.addItem("PagareBursatil");
//        jcOperaciones.addItem("Prestamo");
//        jcOperaciones.addItem("TarjetaDeCredito");
//        jcOperaciones.addItem("TarjetaDeCredito");
//        jcOperaciones.addItemListener((ItemListener) this);



        JButton btnNewButton = new JButton("Suscribir acciones");
        btnNewButton.setBounds(45, 150, 190, 40);
        getContentPane().add(btnNewButton);



        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int entradaCuit=Integer.parseInt(jtCuit.getText());
                int entradaCuitVendedor=Integer.parseInt(jtVendedor.getText());
                float porcentaje = Float.parseFloat(jtPorcentaje.getText());
                float precio = Float.parseFloat(jtprecio.getText());
                int entradaCantidad=Integer.parseInt(jtCantidad.getText());





                ControladorSocio.suscribirAccion(entradaCuit,entradaCuitVendedor,porcentaje,precio,entradaCantidad) ;






            }

        });


//
        setVisible(true);


    }
}