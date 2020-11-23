package vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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

public class ventanaComision extends JFrame{

    private JFrame f = new JFrame("Calculo de comision");
    private JLabel jlFecha,jlResultado;
    private JTextField jtFecha;




    public ventanaComision() {
        String entradaFecha;
        Float Comision;
        setTitle("Calculo de comision");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(356, 360);
        getContentPane().setLayout(null);

        jlFecha = new JLabel("Fecha: ");
        jlFecha.setBounds(10, 11, 46, 18);
        getContentPane().add(jlFecha);

        jtFecha = new JTextField();
        jtFecha.setBounds(50,11,80,18);
        add(jtFecha);








//        JLabel lblNewLabel = new JLabel("Nombre");
//        lblNewLabel.setBounds(183, 11, 46, 14);
//        getContentPane().add(lblNewLabel);
//
//        textField = new JTextField();
//        textField.setBounds(236, 8, 86, 20);
//        getContentPane().add(textField);
//        textField.setColumns(10);

        JButton btnNewButton = new JButton("Realizar Calculo");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String entradaFecha=jtFecha.getText();

//                DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entradaFecha);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

//               Date fecha=format.parse(entradaFecha);

                float Comision= ControladorOperacion.calcularComisionesCheques(date1);

                jlResultado = new JLabel("El Total de comisiones calculadas por dia es  "+ Comision);
                jlResultado.setBounds(50,95,200,20);
                add(jlResultado);
            }

        });
        btnNewButton.setBounds(10, 46, 150, 40);
        getContentPane().add(btnNewButton);

       setVisible(true);
    }


 public static void main(String[] args) {
    vistas.ventanaComision tester = new vistas.ventanaComision();


}}
