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


public class ventanaModificarOpcc extends JFrame {
    private JTextField jtCuit, jtBanco,jtImporte,jtTasa,jtFecha,jtCuotas,jtID;
    private JComboBox<String> jcOperaciones, jcReferencia, jcUsuario;
    private JLabel jlCuit, jlOperacion,jlBanco,jlImporte,jlTasa,jlFecha,jlCuotas,jlUsuario,jlReferencia,jlID;
    private String valor;



    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaModificarOpcc tester = new vistas.ventanaModificarOpcc();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaModificarOpcc() {


        setTitle("Modificar Operacion CC");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 380);
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


        jlID = new JLabel("Ingrese ID:");
        jlID.setBounds(10,150,160,18);
        add(jlID);
        jtID = new JTextField();
        jtID.setBounds(170,150,80,18);
        add(jtID);







        jlOperacion = new JLabel("Seleccione Tipo:");
        jlOperacion.setBounds(10,120,200,18);
        add(jlOperacion);


        jcOperaciones = new JComboBox<String>();
        jcOperaciones.setBounds(150, 120, 120, 18);
        add(jcOperaciones);
        jcOperaciones.addItem("CuentaCorrienteComercial");
        jcOperaciones.addItem("TarjetaDeCredito");



        jlReferencia = new JLabel("Seleccione Referencia:");
        jlReferencia.setBounds(10,180,200,18);
        add(jlReferencia);


        jcReferencia = new JComboBox<String>();
        jcReferencia.setBounds(150, 180, 300, 18);

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
        jlUsuario.setBounds(10,210,200,18);
        add(jlUsuario);


        jcUsuario = new JComboBox<String>();
        jcUsuario.setBounds(150, 210, 300, 18);
        add(jcUsuario);
        jcUsuario.addItem("x500400");
        jcUsuario.addItem("x647423");
        jcUsuario.addItem("x200242");
        jcUsuario.addItem("x421000");







        JButton btnNewButton = new JButton("Modificar");
        btnNewButton.setBounds(200, 240, 190, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int entradaCuit=Integer.parseInt(jtCuit.getText());
                String entradaBanco = jtBanco.getText();
                float entradaImporte = Float.parseFloat(jtImporte.getText());
                float entradaTasa = Float.parseFloat(jtTasa.getText());
                int entradaCantCuotas= Integer.parseInt(jtCuotas.getText());
                String seleccionado = (String) jcOperaciones.getSelectedItem();

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


              //  ControladorSocio.modificarOperacionCCC(entradaCuit,entradaBanco,date1,seleccionado,entradaImporte,ID,seleccionado2,seleccionado3);
                //CAMBIAR METODO PARA QUE RECIBA STRING





            }

        });



        setVisible(true);


    }
}