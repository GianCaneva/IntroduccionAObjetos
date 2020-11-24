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


public class ventanaRetirarAport extends JFrame {
    private JTextField jtCuit,jtFecha;
    private JComboBox<String> jcOperaciones, jcReferencia, jcUsuario;
    private JLabel jlCuit, jlFecha;





    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    vistas.ventanaRetirarAport tester = new vistas.ventanaRetirarAport();
                    tester.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public ventanaRetirarAport() {






        setTitle("Retirar Aporte");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 180);
        getContentPane().setLayout(null);


        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 10, 160, 18);
        add(jlCuit);
        jtCuit = new JTextField();
        jtCuit.setBounds(110, 10, 200, 18);
        add(jtCuit);


        jlFecha = new JLabel("Ingrese Fecha: ");
        jlFecha.setBounds(10, 40, 160, 18);
        add(jlFecha);
        jtFecha = new JTextField();
        jtFecha.setBounds(110, 40, 200, 18);
        add(jtFecha);






        JButton btnNewButton = new JButton("Retirar Aporte");
        btnNewButton.setBounds(110, 70, 190, 40);
        getContentPane().add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int entradaCuit=Integer.parseInt(jtCuit.getText());

                String entradaFecha1=jtFecha.getText();


                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha1);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }


                ControladorSocio.retirarAportes(entradaCuit,date1);
//                    FALTA SOLICITAR sTRING
                ventanaOK tester = new ventanaOK();
                tester.setVisible(true);


            }

        });



        setVisible(true);


    }
}