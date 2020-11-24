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






public class ventanaOperacionesSocio extends JFrame  {
    private JTextField jtCuit, jtMora, jtPordia,jtAnio,jtFecha1,jtFecha2;
    private JComboBox<Integer> jcOperaciones1,jcOperaciones2,jcOperaciones3;
    private JLabel jlCuit, jlPorcentaje,jlAnio,jlFecha1,jlFecha2;
    private String  valor;
    private int a, b;
    private ArrayList<String> operacionesArrayList;
    private float mora=0;

    private JLabel jlFecha,jlResultado1,jlResultado2;
    private JTextField jtFecha;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try{
                    vistas.ventanaOperacionesSocio tester = new vistas.ventanaOperacionesSocio();
                    tester.setVisible(true);

                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });



    }




    public ventanaOperacionesSocio(){

        // String[] operacionesArraylist = new String[""];

//        setTitle("Calculo de Porcentaje Comision");
        setTitle("Operaciones Socio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,800);
        getContentPane().setLayout(null);



        jlCuit=new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10,10,80,18);
        add(jlCuit);
        jtCuit=new JTextField();
        jtCuit.setBounds(85,10,80,18);
        add(jtCuit);

        jlAnio=new JLabel("Año: ");
        jlAnio.setBounds(10,40,30,18);
        add(jlAnio);
        jlFecha1=new JLabel("Desde:");
        jlFecha1.setBounds(10,70,40,18);
        add(jlFecha1);

        jlFecha2=new JLabel("Hasta:");
        jlFecha2.setBounds(130,70,40,18);
        add(jlFecha2);


        jcOperaciones1=new JComboBox<Integer>();
        jcOperaciones1.setBounds(60,40,60,18);
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

        jcOperaciones2=new JComboBox<Integer>();
        jcOperaciones2.setBounds(60,70,40,18);
        add(jcOperaciones2);
        jcOperaciones2.addItem(1);
        jcOperaciones2.addItem(2);
        jcOperaciones2.addItem(3);
        jcOperaciones2.addItem(4);
        jcOperaciones2.addItem(5);
        jcOperaciones2.addItem(6);
        jcOperaciones2.addItem(7);
        jcOperaciones2.addItem(8);
        jcOperaciones2.addItem(9);
        jcOperaciones2.addItem(10);
        jcOperaciones2.addItem(11);
        jcOperaciones2.addItem(12);



        jcOperaciones3=new JComboBox<Integer>();
        jcOperaciones3.setBounds(180,70,40,18);
        add(jcOperaciones3);
        jcOperaciones3.addItem(1);
        jcOperaciones3.addItem(2);
        jcOperaciones3.addItem(3);
        jcOperaciones3.addItem(4);
        jcOperaciones3.addItem(5);
        jcOperaciones3.addItem(6);
        jcOperaciones3.addItem(7);
        jcOperaciones3.addItem(8);
        jcOperaciones3.addItem(9);
        jcOperaciones3.addItem(10);
        jcOperaciones3.addItem(11);
        jcOperaciones3.addItem(12);




        jlPorcentaje=new JLabel();
        jlPorcentaje.setBounds(10,160,250,14);
        add(jlPorcentaje);
        JButton btnNewButton = new JButton("Realizar Calculo");
        btnNewButton.setBounds(10, 110, 150, 40);
        getContentPane().add(btnNewButton);






        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int entradaCuit=Integer.parseInt(jtCuit.getText());
                int entradaAnio= (int) jcOperaciones1.getSelectedItem();
                int entradaMes1 = (int)jcOperaciones2.getSelectedItem();
                int entradaMes2= (int) jcOperaciones3.getSelectedItem();





                JList<Operacion> ListaOperaciones= new JList<>();
                ListaOperaciones= (JList) ControladorOperacion.calcularCantidadOpMonetizadas(entradaCuit,entradaAnio,entradaMes1,entradaMes2);
                ListaOperaciones.setBounds(10,160,160,300);
                add(ListaOperaciones);

                ventanaOK tester = new ventanaOK();
                tester.setVisible(true);

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
