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

public class ventanaSaldoMora extends JFrame{

    private JFrame f = new JFrame("Calculo de comision");
    // private JFormattedTextField jtCuit;
    private JLabel jlCuit,jlResultado,jlResultado2;
    private JTextField jtCuit;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try{ventanaSaldoMora tester = new ventanaSaldoMora();
                    tester.setVisible(true);

                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });



    }


    public ventanaSaldoMora() {
        String entradaFecha;
        Float Comision;
        setTitle("Consulta Mora");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(356, 360);
        getContentPane().setLayout(null);

        jlCuit = new JLabel("Ingrese Cuit: ");
        jlCuit.setBounds(10, 11, 90, 18);
        getContentPane().add(jlCuit);

        jtCuit = new JTextField();
        jtCuit.setBounds(90,12,80,18);
        add(jtCuit);







        JButton btnNewButton = new JButton("Realizar consulta");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int entradaCuit=Integer.parseInt(jtCuit.getText());
                float resultado1= ControladorOperacion.obtenerMoraTotal(entradaCuit);
                float resultado2= ControladorOperacion.obtenerMoraPorDia(entradaCuit);




//

                jlResultado = new JLabel("El total de mora es "+ resultado1+"$");
                jlResultado.setBounds(10,95,200,20);
                add(jlResultado);
                jlResultado2 = new JLabel("La mora por dia es "+ resultado2+"$");
                jlResultado2.setBounds(10,130,200,20);
                add(jlResultado2);
                ventanaOK tester = new ventanaOK();
                tester.setVisible(true);
            }

        });
        btnNewButton.setBounds(40, 46, 150, 40);
        getContentPane().add(btnNewButton);

        setVisible(true);
    }


}