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


public class ventanaOK extends JFrame {
    private JTextField jtCuit, jtBanco,jtImporte,jtMonto,jtFecha,jtCuotas,jtMora;
    private JComboBox<String> jcOperaciones, jcReferencia, jcUsuario;
    private JLabel jlCuit, jlOperacion,jlBanco,jlImporte,jlTasa,jlMonto,jlMora,jlUsuario,jlReferencia,jlID;
    private String valor;
    private JTextField jtCheque,jtCuitfirmante;
    private JComboBox<String>  jcOperaciones2, jcOperaciones3;
    private JLabel jlCheque,jlCuitfirmante;





    public static void main(String[] args)  {



                    vistas.ventanaOK tester = new vistas.ventanaOK();
                    tester.setVisible(true);



    }


    public ventanaOK() {






        setTitle("Proceso Correcto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(800,400);
        setSize(300, 100);
        getContentPane().setLayout(null);

        setVisible(true);


        jlCuit = new JLabel("Carga Correcta!! ");
        jlCuit.setBounds(80, 10, 160, 18);
        add(jlCuit);








    }
}