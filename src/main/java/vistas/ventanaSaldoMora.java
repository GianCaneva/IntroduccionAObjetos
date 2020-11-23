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

public class ventanaSaldoMora {

    private JFrame f = new JFrame();
    private JTextField jtCuil,jtMora,jtPordia;
    private JLabel jlCuil,jlMora,jlPordia;
    private String mora,pordia;
    private double a,b;

    public static void main(String[] args) {
        vistas.ventanaSaldoMora tester = new vistas.ventanaSaldoMora();

    }


    public ventanaSaldoMora() {
        a=10.3;
        b=5.4;

        f.setTitle("Calculo de mora");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(356, 360);
        f.getContentPane().setLayout(null);


        jlCuil = new JLabel("Cuil: ");
        jlCuil.setBounds(10, 11, 46, 14);
        f.getContentPane().add(jlCuil);
        jtCuil = new JTextField();
        jtCuil.setBounds(60, 11, 60, 18);
        f.add(jtCuil);
        f.getContentPane().add(jtCuil);



        JButton btnNewButton = new JButton("Calcular mora");
        btnNewButton.setBounds(10, 46, 150, 40);
        f.getContentPane().add(btnNewButton);
        f.setVisible(true);


        pordia = Double.toString(a);
        jlMora = new JLabel("Saldo de mora total: "+ pordia);
        jlMora.setBounds(10,110,150,14);
        f.add(jlMora);

//        jlPordia = new JLabel();
        mora=Double.toString(b);
//        jlPordia.setText(prueba);
        jlPordia = new JLabel("Saldo de mora por dia: "+ mora);
        jlPordia.setBounds(10,140,190,14);
        f.add(jlPordia);
//
//        jtMora = new JTextField(a);
//        jtMora.setBounds(160,110,60,14);







    }


}
