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






    public class ventanaValorPromedio extends JFrame  {
        private JTextField jtCombo, jtMora, jtPordia,jtFecha1,jtFecha2;
        private JComboBox<String> jcOperaciones;
        private JLabel jlTipo, jlPorcentaje,jlFecha1,jlFecha2;
        private String  valor, operacion;
        private int a, b;
        private ArrayList<String> operacionesArrayList;
        private float mora=0;

        private JLabel jlFecha,jlResultado1,jlResultado2;
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
        setSize(400,400);
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
//        jcOperaciones.addItemListener(this);

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
        jlPorcentaje.setBounds(10,160,250,14);
        add(jlPorcentaje);
        JButton btnNewButton = new JButton("Realizar Calculo");
        btnNewButton.setBounds(10, 110, 150, 40);
        getContentPane().add(btnNewButton);




        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String entradaFecha1=jtFecha1.getText();
                String entradaFecha2=jtFecha2.getText();

                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha1);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                Date date2= null;
                try {
                    date2 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha2);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                String seleccionado = (String) jcOperaciones.getSelectedItem();

                float resultado1 = ControladorOperacion.calcularValorPromedioTasa(seleccionado,date1,date2)  ;
                float resultado2 = ControladorOperacion.totalChequesYPagares(seleccionado,date1,date2)  ;


//                float Comision= ControladorOperacion.calcularComisionesCheques(date1);

                jlResultado1 = new JLabel( "Valor promedio tasa dcto: " + resultado1);
                jlResultado1.setBounds(10,180,200,100);
                add(jlResultado1);
                jlResultado2 = new JLabel( "Valor total cheques y pagare: " + resultado2);
                jlResultado2.setBounds(10,200,200,100);
                add(jlResultado2);
             //   setVisible(true);
            }

        });


//
        setVisible(true);


        }






   }
