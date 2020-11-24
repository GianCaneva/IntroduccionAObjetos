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


public class ventanaSolicitarOPcc extends JFrame {
    private JTextField jtCuit, jtBanco,jtImporte,jtTasa,jtFecha,jtCuotas;
    private JComboBox<String> jcOperaciones, jcOperaciones2, jcOperaciones3;
    private JLabel jlCuit, jlOperacion,jlBanco,jlImporte,jlTasa,jlFecha,jlCuotas;
    private String valor;



    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaSolicitarOPcc tester = new vistas.ventanaSolicitarOPcc();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaSolicitarOPcc() {


        setTitle("Solicitar Cuenta Corriente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 300);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(170, 10, 80, 18);
        add(jtCuit);
        jlBanco = new JLabel("Ingrese Banco: ");
        jlBanco.setBounds(10,35,160,18);
        add(jlBanco);
        jtBanco = new JTextField();
        jtBanco.setBounds(170,35,80,18);
        add(jtBanco);
        jlImporte = new JLabel("Ingrese Importe:");
        jlImporte.setBounds(10,60,160,18);
        add(jlImporte);
        jtImporte = new JTextField();
        jtImporte.setBounds(170,60,80,18);
        add(jtImporte);

        jlFecha = new JLabel("Ingrese Fecha Vencimiento:");
        jlFecha.setBounds(10,90,160,18);
        add(jlFecha);
        jtFecha = new JTextField();
        jtFecha.setBounds(170,90,80,18);
        add(jtFecha);


        jlOperacion = new JLabel("Seleccione Tipo:");
        jlOperacion.setBounds(10,120,200,18);
        add(jlOperacion);


        jcOperaciones = new JComboBox<String>();
        jcOperaciones.setBounds(150, 120, 120, 18);
        add(jcOperaciones);
        jcOperaciones.addItem("CuentaCorrienteComercial");
        jcOperaciones.addItem("TarjetaDeCredito");






        JButton btnNewButton = new JButton("Solicitar");
        btnNewButton.setBounds(45, 150, 190, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int entradaCuit=Integer.parseInt(jtCuit.getText());
                String entradaBanco = jtBanco.getText();
                float entradaImporte = Float.parseFloat(jtImporte.getText());


                String seleccionado = (String) jcOperaciones.getSelectedItem();

                String entradaFecha1=jtFecha.getText();


                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha1);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

               ControladorSocio.solicitarOperacionCCC(entradaCuit,entradaBanco,date1,seleccionado,entradaImporte);
                //    FALTA SOLICITAR sTRING


                ventanaOK tester = new ventanaOK();
                tester.setVisible(true);


            }

        });



        setVisible(true);


    }
}