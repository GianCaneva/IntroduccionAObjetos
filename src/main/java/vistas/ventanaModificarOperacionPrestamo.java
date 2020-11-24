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


public class ventanaModificarOperacionPrestamo extends JFrame {
    private JTextField jtCuit, jtBanco,jtImporte,jtTasa,jtFecha,jtCuotas,jtID;
    private JComboBox<String> jcSistemas, jcReferencia, jcUsuario;
    private JLabel jlCuit, jlSistema,jlBanco,jlImporte,jlTasa,jlFecha,jlCuotas,jlUsuario,jlReferencia,jlID;
    private String valor;



    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaModificarOperacionPrestamo tester = new vistas.ventanaModificarOperacionPrestamo();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaModificarOperacionPrestamo() {


        setTitle("Modificar Prestamo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(170, 10, 80, 18);
        add(jtCuit);
        jlBanco = new JLabel("Ingrese Empresa: ");
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
        jlTasa = new JLabel("Ingrese Tasa:");
        jlTasa.setBounds(10,90,160,18);
        add(jlTasa);
        jtTasa = new JTextField();
        jtTasa.setBounds(170,90,80,18);
        add(jtTasa);
        jlFecha = new JLabel("Ingrese Fecha Acreditacion:");
        jlFecha.setBounds(10,120,160,18);
        add(jlFecha);
        jtFecha = new JTextField();
        jtFecha.setBounds(170,120,80,18);
        add(jtFecha);

        jlCuotas = new JLabel("Ingrese Cantidad Cuotas:");
        jlCuotas.setBounds(10,150,160,18);
        add(jlCuotas);
        jtCuotas = new JTextField();
        jtCuotas.setBounds(170,150,80,18);
        add(jtCuotas);

        jlID = new JLabel("Ingrese ID:");
        jlID.setBounds(10,180,160,18);
        add(jlID);
        jtID = new JTextField();
        jtID.setBounds(170,180,80,18);
        add(jtID);










        jlSistema = new JLabel("Seleccione sistema:");
        jlSistema.setBounds(10,210,200,18);
        add(jlSistema);


        jcSistemas = new JComboBox<String>();
        jcSistemas.setBounds(150, 210, 300, 18);
        add(jcSistemas);
        jcSistemas.addItem("Frances");
        jcSistemas.addItem("Aleman");
        jcSistemas.addItem("Americano");




        jlReferencia = new JLabel("Seleccione Referencia:");
        jlReferencia.setBounds(10,240,200,18);
        add(jlReferencia);


        jcReferencia = new JComboBox<String>();
        jcReferencia.setBounds(150, 240, 300, 18);

        add(jcReferencia);
        jcReferencia.addItem("Actualizacion de numero telefonico");
        jcReferencia.addItem("Cambio de Razon Social");
        jcReferencia.addItem("Cambio de Domicilio");
        jcReferencia.addItem("Cambio de Telefono");
        jcReferencia.addItem("Cambio de Correo");
        jcReferencia.addItem("Cambio de Segmento");
        jcReferencia.addItem("Correcion de fecha de inicio de Actividad");
        jcReferencia.addItem("Correcion de datos");




        jlUsuario = new JLabel("Seleccione Usuario:");
        jlUsuario.setBounds(10,270,200,18);
        add(jlUsuario);


        jcUsuario = new JComboBox<String>();
        jcUsuario.setBounds(150, 270, 300, 18);
        add(jcUsuario);
        jcUsuario.addItem("x500400");
        jcUsuario.addItem("x647423");
        jcUsuario.addItem("x200242");
        jcUsuario.addItem("x421000");







        JButton btnNewButton = new JButton("Modificar");
        btnNewButton.setBounds(200, 300, 190, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int entradaCuit=Integer.parseInt(jtCuit.getText());
                String entradaBanco = jtBanco.getText();
                float entradaImporte = Float.parseFloat(jtImporte.getText());
                float entradaTasa = Float.parseFloat(jtTasa.getText());
                int entradaCantCuotas= Integer.parseInt(jtCuotas.getText());
                String seleccionado = (String) jcSistemas.getSelectedItem();

                String entradaFecha1=jtFecha.getText();


                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha1);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                String ID= (String) jtID.getText();
                String seleccionado2 = (String) jcReferencia.getSelectedItem();
                String seleccionado3 = (String) jcUsuario.getSelectedItem();


                ControladorSocio.modificarOperacionPrestamo(entradaCuit,entradaBanco,entradaImporte,entradaTasa,date1,entradaCantCuotas,seleccionado,ID,seleccionado2,seleccionado3);






            }

        });



        setVisible(true);


    }
}