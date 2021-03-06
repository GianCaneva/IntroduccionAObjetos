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


public class ventanaPresentarDoc extends JFrame {
    private JTextField jtCuit, jtBanco,jtImporte,jtMonto,jtFecha,jtCuotas,jtMora;
    private JComboBox<String> jcTipo, jcEstado, jcUsuario;
    private JLabel jlCuit, jlOperacion,jlEstado,jlImporte,jlTasa,jlMonto,jlMora,jlUsuario,jlReferencia,jlID;
    private String valor;
    private JTextField jtCheque,jtCuitfirmante;
    private JComboBox<String>  jcTipo2, jcTipo3;
    private JLabel jlCheque,jlCuitfirmante;





    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaPresentarDoc tester = new vistas.ventanaPresentarDoc();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaPresentarDoc() {






        setTitle("Cargar Documentacion");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 260);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(150, 10, 200, 18);
        add(jtCuit);


        jlOperacion = new JLabel("Seleccione Tipo: ");
        jlOperacion.setBounds(10, 40, 100, 18);
        add(jlOperacion);

        jcTipo = new JComboBox<String>();
        jcTipo.setBounds(150, 40, 200, 18);
        add(jcTipo);
        jcTipo.addItem("Estatuto");
        jcTipo.addItem("Contrato Social");
        jcTipo.addItem("Ultimos 3 balances certificados");
        jcTipo.addItem("Manifestacion de bienes de socios");



        jlEstado = new JLabel("Seleccione Estado: ");
        jlEstado.setBounds(10, 70, 120, 18);
        add(jlEstado);

        jcEstado = new JComboBox<String>();
        jcEstado.setBounds(150, 70, 200, 18);
        add(jcEstado);
        jcEstado.addItem("ingresado");
        jcEstado.addItem("controlado");
        jcEstado.addItem("rechazado");



        jlUsuario = new JLabel("Seleccione Usuario:");
        jlUsuario.setBounds(10,100,200,18);
        add(jlUsuario);


        jcUsuario = new JComboBox<String>();
        jcUsuario.setBounds(150, 100, 200, 18);
        add(jcUsuario);
        jcUsuario.addItem("x500400");
        jcUsuario.addItem("x647423");
        jcUsuario.addItem("x200242");
        jcUsuario.addItem("x421000");








        JButton btnNewButton = new JButton("Agregar");
        btnNewButton.setBounds(150, 130, 190, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int entradaCuit=Integer.parseInt(jtCuit.getText());
                String entradaTipo = (String) jcTipo.getSelectedItem();
                String entradaEstado = (String) jcEstado.getSelectedItem();
                String entradaUsuario = (String) jcUsuario.getSelectedItem();
                



                ControladorSocio.presentarDocumento(entradaCuit,entradaTipo,entradaEstado,entradaUsuario);
//                    FALTA SOLICITAR sTRING
                ventanaOK tester = new ventanaOK();
                tester.setVisible(true);


            }

        });



        setVisible(true);


    }
}