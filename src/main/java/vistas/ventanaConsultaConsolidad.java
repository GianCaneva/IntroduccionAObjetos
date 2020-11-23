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

public class ventanaConsultaConsolidad extends JFrame{

    private JFrame f = new JFrame("Calculo de comision");
    // private JFormattedTextField jtCuit;
    private JLabel jlCuit,jlResultado,jlResultado2;
    private JTextField jtCuit;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try{ventanaConsultaConsolidad tester = new ventanaConsultaConsolidad();
                    tester.setVisible(true);

                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });



    }


    public ventanaConsultaConsolidad() {
        String entradaFecha;
        Float Comision;
        setTitle("Consulta Consolidada");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(356, 360);
        getContentPane().setLayout(null);

        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 11, 90, 18);
        getContentPane().add(jlCuit);

        jtCuit = new JTextField();
        jtCuit.setBounds(90,12,80,18);
        add(jtCuit);







        JButton btnNewButton = new JButton("Realizar Calculo");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int entradaCuit=Integer.parseInt(jtCuit.getText());
                float resultado1= ControladorOperacion.calcularConsolidadaUtilizado(entradaCuit);
                float resultado2= ControladorOperacion.calcularConsolidadaRiesgo(entradaCuit);




//

                jlResultado = new JLabel("Consulta consolidada por utilidad "+ resultado1+"$");
                jlResultado.setBounds(10,95,200,20);
                add(jlResultado);
                jlResultado2 = new JLabel("Consulta consolidada por riesgo vivo "+ resultado2+"$");
                jlResultado2.setBounds(10,130,200,20);
                add(jlResultado2);
            }

        });
        btnNewButton.setBounds(40, 46, 150, 40);
        getContentPane().add(btnNewButton);

//        setVisible(true);
    }


}