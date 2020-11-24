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
    private JTextField jtCuit, jtMonto,jtprecio,jtPorcentaje;
    private JComboBox<String> jcOperaciones, jcOperaciones2, jcOperaciones3;
    private JLabel jlCuit, jlprecio, jlMonto, jlPorcentaje1, jlPorcentaje2;
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
        setTitle("Asignar Linea Credito");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(170, 10, 80, 18);
        add(jtCuit);
        jlMonto = new JLabel("Ingrese Monto: ");
        jlMonto.setBounds(10,35,160,18);
        add(jlMonto);
        jtMonto = new JTextField();
        jtMonto.setBounds(170,35,80,18);
        add(jtMonto);
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
        add(jtPorcentaje);


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



        JButton btnNewButton = new JButton("Asignar Linea Credito");
        btnNewButton.setBounds(45, 130, 190, 40);
        getContentPane().add(btnNewButton);



        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int entradaCuit=Integer.parseInt(jtCuit.getText());
                float entradaMonto=Float.parseFloat(jtMonto.getText());

                String entradaFecha1=jtPorcentaje.getText();


                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha1);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }



                ControladorSocio.asignarLineaDeCredito( entradaCuit,entradaMonto,date1) ;






            }

        });


//
        setVisible(true);


    }
}