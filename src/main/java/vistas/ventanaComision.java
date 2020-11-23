package vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import controller.*;

import static controller.ControladorOperacion.*;

public class ventanaComision {

    private JFrame f = new JFrame("Calculo de comision");
   // private JFormattedTextField jtFecha;
    private JLabel jlFecha,jlResultado;
    private JTextField jtFecha;

    public static void main(String[] args) {
        ventanaComision tester = new ventanaComision();

    }


    public ventanaComision() {
        String entradaFecha;
        int Comision;
        f.setTitle("Calculo de comision");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(356, 360);
        f.getContentPane().setLayout(null);

//////////////// FECHA ///////////////////

        // jtFecha = new JTextField();

        jlFecha = new JLabel("Fecha: ");
        jlFecha.setBounds(10, 11, 46, 14);
        f.getContentPane().add(jlFecha);

        jtFecha = new JTextField();
        jtFecha.setBounds(50,11,80,14);
        f.add(jtFecha);
        entradaFecha=jtFecha.getText();
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY");

//        Date fecha=format.parse(entradaFecha);

//        Comision= ControladorOperacion.calcularComisionesCheques(fecha);

        jlResultado = new JLabel("El Total de comisiones calculadas por dia es  ");
        jlResultado.setBounds(50,95,200,20);
        f.add(jlResultado);





//        JLabel lblNewLabel = new JLabel("Nombre");
//        lblNewLabel.setBounds(183, 11, 46, 14);
//        f.getContentPane().add(lblNewLabel);
//
//        textField = new JTextField();
//        textField.setBounds(236, 8, 86, 20);
//        f.getContentPane().add(textField);
//        textField.setColumns(10);

        JButton btnNewButton = new JButton("Realizar Calculo");
        btnNewButton.setBounds(10, 46, 150, 40);
        f.getContentPane().add(btnNewButton);
        f.setVisible(true);
    }


}