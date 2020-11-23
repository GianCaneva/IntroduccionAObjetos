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
import dto.enumeration.CtaCorriente;
import dto.enumeration.Prestamo;
import dto.enumeration.TipoCheque;
import controller.ControladorOperacion;

public class ventanaValorPromedio extends JFrame implements ItemListener {

    private JFrame f = new JFrame();
    private JTextField jtCombo, jtMora, jtPordia;
    private JComboBox<String> jcOperaciones;
    private JLabel jlTipo, jlPorcentaje;
    private String  valor, operacion;
    private int a, b;
    private ArrayList<String> operacionesArrayList;
    private float mora=0;




    public ventanaValorPromedio(){

        // String[] operacionesArraylist = new String[""];

//        f.setTitle("Calculo de Porcentaje Comision");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(356,200);
        f.getContentPane().setLayout(null);


        jlTipo=new JLabel();
//        mora = Double.toString(b);
//        jlPorcentaje.setText(prueba);
        jlTipo=new JLabel("Seleccione el tipo de empresa: ");
        jlTipo.setBounds(10,10,250,14);
        f.add(jlTipo);


        jcOperaciones=new JComboBox<String>();
        jcOperaciones.setBounds(10,40,200,18);
        f.add(jcOperaciones);
        jcOperaciones.addItem("Pequenia");
        jcOperaciones.addItem("Mediana");
        jcOperaciones.addItem("Grande");
        jcOperaciones.addItemListener(this);


//        jlPorcentaje = new JLabel();
//        mora = Double.toString(b);
//        jlPorcentaje.setText(prueba);
//        type seleccionadoToEnum = type.valueOf(seleccionado);

//        mora = ControladorOperacion.calcularPorcentajeComision(seleccionadoToEnum);

        jlPorcentaje=new JLabel();
        jlPorcentaje.setBounds(10,65,250,14);
        f.add(jlPorcentaje);

//
        f.setVisible(true);


        }


    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jcOperaciones) {
            String seleccionado = (String) jcOperaciones.getSelectedItem();
            f.setTitle(seleccionado);


            jlPorcentaje.setText("El procetaje es "+ mora + "%");

            // NO ME ESTA TRAYENDO EL RESULTADO ED CALCULAR PORCENTAJE COMISION//
//            f.setVisible(true);




        }
    }



    public static void main(String[] args) {
        vistas.ventanaValorPromedio tester = new vistas.ventanaValorPromedio();

    }}
