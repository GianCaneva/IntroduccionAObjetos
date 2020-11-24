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
import controller.ControladorSocio;
import dto.Operacion.Operacion;






public class ventanaLineaCredito extends JFrame {
    private JTextField jtCuit, jtMonto, jtPordia, jtAnio, jtFecha1, jtFecha2;
    private JComboBox<Integer> jcOperaciones1, jcOperaciones2, jcOperaciones3;
    private JLabel jlCuit, jlPorcentaje, jlMonto, jlFecha1, jlFecha2;
    private String valor;
    private int a, b;
    private ArrayList<String> operacionesArrayList;
    private float mora = 0;

    private JLabel jlFecha, jlResultado1, jlResultado2;
    private JTextField jtFecha;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaLineaCredito tester = new vistas.ventanaLineaCredito();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaLineaCredito() {

        // String[] operacionesArraylist = new String[""];

//        setTitle("Calculo de Porcentaje Comision");
        setTitle("Operaciones Socio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 800);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 80, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(85, 10, 80, 18);
        add(jtCuit);
        jlMonto = new JLabel("Ingrese monto ");
        jlMonto.setBounds(10,30,80,18);
        add(jlMonto);
        jtMonto = new JTextField();
        jtMonto.setBounds(80,30,80,18);
        add(jtMonto);




        jcOperaciones1 = new JComboBox<Integer>();
        jcOperaciones1.setBounds(60, 40, 60, 18);
        add(jcOperaciones1);
        jcOperaciones1.addItem(2010);
        jcOperaciones1.addItem(2011);
        jcOperaciones1.addItem(2012);
        jcOperaciones1.addItem(2013);
        jcOperaciones1.addItem(2014);
        jcOperaciones1.addItem(2015);
        jcOperaciones1.addItem(2016);
        jcOperaciones1.addItem(2017);
        jcOperaciones1.addItem(2018);
        jcOperaciones1.addItem(2019);
        jcOperaciones1.addItem(2020);



        jlPorcentaje = new JLabel();
        jlPorcentaje.setBounds(10, 160, 250, 14);
        add(jlPorcentaje);
        JButton btnNewButton = new JButton("Realizar Calculo");
        btnNewButton.setBounds(10, 110, 150, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int entradaCuit = Integer.parseInt(jtCuit.getText());
                int entradaAnio = (int) jcOperaciones1.getSelectedItem();
                int entradaMes1 = (int) jcOperaciones2.getSelectedItem();
                int entradaMes2 = (int) jcOperaciones3.getSelectedItem();


                JList<Operacion> ListaOperaciones = new JList<>();
                ListaOperaciones = (JList) ControladorOperacion.calcularCantidadOpMonetizadas(entradaCuit, entradaAnio, entradaMes1, entradaMes2);
                ListaOperaciones.setBounds(10, 160, 160, 300);
                add(ListaOperaciones);


//
//                jlResultado1= new JLabel("mostrar " +entradaCuit+" "+entradaAnio+" "+entradaMes1+" "+entradaMes2  );
//                jlResultado1.setBounds(10,180,200,100);
//                add(jlResultado1);

                //   setVisible(true);
            }

        });


//
        setVisible(true);


    }
}