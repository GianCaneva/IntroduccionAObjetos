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






    public class ventanaValorPromedio extends JFrame implements ItemListener {
        private JTextField jtCombo, jtMora, jtPordia,jtFecha1,jtFecha2;
        private JComboBox<String> jcOperaciones;
        private JLabel jlTipo, jlPorcentaje,jlFecha1,jlFecha2;
        private String  valor, operacion;
        private int a, b;
        private ArrayList<String> operacionesArrayList;
        private float mora=0;

        private JLabel jlFecha,jlResultado;
        private JTextField jtFecha;

        public static void main(String[] args) throws Exception {
            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    try{
                        vistas.ventanaValorPromedio tester = new vistas.ventanaValorPromedio();
                        tester.setVisible(true);

                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });



        }




    public ventanaValorPromedio(){

        // String[] operacionesArraylist = new String[""];

//        setTitle("Calculo de Porcentaje Comision");
        setTitle("Calculo de Valor Promedio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(356,250);
        getContentPane().setLayout(null);



        jlTipo=new JLabel("Seleccione el tipo de empresa: ");
        jlTipo.setBounds(10,10,250,14);
        add(jlTipo);


        jcOperaciones=new JComboBox<String>();
        jcOperaciones.setBounds(10,40,200,18);
        add(jcOperaciones);
        jcOperaciones.addItem("Pequenia");
        jcOperaciones.addItem("Mediana");
        jcOperaciones.addItem("Grande");
        jcOperaciones.addItemListener(this);

        jlFecha1=new JLabel("Desde: ");
        jlFecha1.setBounds(10,70,70,18);
        add(jlFecha1);
        jtFecha1 = new JTextField();
        jtFecha1.setBounds(65,70,70,18);
        add(jtFecha1);
        jlFecha2=new JLabel("Hasta: ");
        jlFecha2.setBounds(140,70,70,18);
        add(jlFecha2);
        jtFecha2 = new JTextField();
        jtFecha2.setBounds(180,70,70,18);
        add(jtFecha2);



        jlPorcentaje=new JLabel();
        jlPorcentaje.setBounds(10,110,250,14);
        add(jlPorcentaje);

//
        setVisible(true);


        }


    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jcOperaciones) {
            String seleccionado = (String) jcOperaciones.getSelectedItem();



            jlPorcentaje.setText("En ese periodo el VP es "+ mora + "%");

          


        }
    }




   }
