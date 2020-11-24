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


public class ventanaModificarOperacionCheque extends JFrame {
    private JTextField jtCuit, jtBanco,jtImporte,jtTasa,jtFecha,jtCuotas,jtID;
    private JComboBox<String> jcOperaciones, jcReferencia, jcUsuario;
    private JLabel jlCuit, jlOperacion,jlBanco,jlImporte,jlTasa,jlFecha,jlCuotas,jlUsuario,jlReferencia,jlID;
    private String valor;
    private JTextField jtCheque,jtCuitfirmante;
    private JComboBox<String>  jcOperaciones2, jcOperaciones3;
    private JLabel jlCheque,jlCuitfirmante;





    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaModificarOperacionCheque tester = new vistas.ventanaModificarOperacionCheque();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaModificarOperacionCheque() {






        setTitle("Modificar Operacion Cheque");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(210, 10, 200, 18);
        add(jtCuit);

        jlOperacion = new JLabel("Seleccione Tipo de cheque:");
        jlOperacion.setBounds(10,40,160,18);
        add(jlOperacion);


        jcOperaciones = new JComboBox<String>();
        jcOperaciones.setBounds(210, 40, 200, 18);
        add(jcOperaciones);
        jcOperaciones.addItem("ChequePropio");
        jcOperaciones.addItem("ChequeDeTerceros");
        jcOperaciones.addItem("PagareBursatil");

        jlBanco = new JLabel("Ingrese Banco: ");
        jlBanco.setBounds(10,70,160,18);
        add(jlBanco);
        jtBanco = new JTextField();
        jtBanco.setBounds(210,70,200,18);
        add(jtBanco);
        jlCheque = new JLabel("Ingrese Numero Cheque:");
        jlCheque.setBounds(10,100,160,18);
        add(jlCheque);
        jtCheque = new JTextField();
        jtCheque.setBounds(210,100,200,18);
        add(jtCheque);





        jlFecha = new JLabel("Ingrese Fecha Vencimiento:");
        jlFecha.setBounds(10,130,160,18);
        add(jlFecha);
        jtFecha = new JTextField();
        jtFecha.setBounds(210,130,200,18);
        add(jtFecha);

        jlCuitfirmante = new JLabel("Ingrese Cuit del firmante:");
        jlCuitfirmante.setBounds(10,160,160,18);
        add(jlCuitfirmante);
        jtCuitfirmante = new JTextField();
        jtCuitfirmante.setBounds(210,160,200,18);
        add(jtCuitfirmante);

        jlImporte = new JLabel("Ingrese Importe:");
        jlImporte.setBounds(10,190,160,18);
        add(jlImporte);
        jtImporte = new JTextField();
        jtImporte.setBounds(210,190,200,18);
        add(jtImporte);






        jlReferencia = new JLabel("Seleccione Referencia:");
        jlReferencia.setBounds(10,220,200,18);
        add(jlReferencia);


        jcReferencia = new JComboBox<String>();
        jcReferencia.setBounds(150, 220, 300, 18);

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
        jlUsuario.setBounds(10,250,200,18);
        add(jlUsuario);


        jcUsuario = new JComboBox<String>();
        jcUsuario.setBounds(150, 250, 300, 18);
        add(jcUsuario);
        jcUsuario.addItem("x500400");
        jcUsuario.addItem("x647423");
        jcUsuario.addItem("x200242");
        jcUsuario.addItem("x421000");







        JButton btnNewButton = new JButton("Modificar");
        btnNewButton.setBounds(200, 280, 190, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int entradaCuit=Integer.parseInt(jtCuit.getText());
                String seleccionado = (String) jcOperaciones.getSelectedItem();
                String entradaBanco = jtBanco.getText();
                int entradaNumeroCheque = Integer.parseInt(jlCheque.getText());




                String entradaFecha1=jtFecha.getText();


                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha1);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }



                int entradaCuitFirmante = Integer.parseInt(jtCuitfirmante.getText());
                float entradaImporte = Float.parseFloat(jtImporte.getText());
                String ID= (String) jtID.getText();
                String seleccionado2 = (String) jcReferencia.getSelectedItem();
                String seleccionado3 = (String) jcUsuario.getSelectedItem();



                ControladorSocio.modificarOperacionCheque(entradaCuit,seleccionado,entradaBanco,entradaNumeroCheque,date1,entradaCuitFirmante,entradaImporte,ID,seleccionado2,seleccionado3);
//                    FALTA SOLICITAR sTRING

                ventanaOK tester = new ventanaOK();
                tester.setVisible(true);

            }

        });



        setVisible(true);


    }
}