package vistas;
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

//public class ventanaOperacionesSocio extends JFrame {
//    private JPanel  contentPane;
//    private JTable table;
//    private JPanel panelEmpresa;
//    private JTextField textField1;

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ventanaOperacionesSocio frame = new ventanaOperacionesSocio();
//                    frame.setVisible(true);
//                } catch (Exception var2) {
//                    var2.printStackTrace();
//                }
//
//            }
//        });
public class ventanaOperacionesSocio implements ActionListener{

    private JButton  btIng, btLim, btDes,  btCargarEmp,btElim,btGarantias;
    private JTextArea jtAMos = new JTextArea(10, 50);
    JPanel jp1;
    private JLabel jlCuit, jlRazonsocial,jlFechaInicio, jlTipo, jlActividadPrincipal, jlDireccion,jlTelefono,jlCorreoElectronico,jlElimEmp,jlGarantias;
    private JTextField  jtCuit,jtRazonsocial,jtFechaInicio,jtTipo, jtActividadPrincipal, jtDireccion, jtTelefono,jtCorreoElectronico, jtElimEmp,jtGarantias;

    JFrame  VenIng,venDelete,ventGarantias;

    public ventanaOperacionesSocio(){

        JFrame VentMain = new JFrame("Gestionar Empresas");
        VentMain.setLayout(new BorderLayout(30, 25));
        VentMain.setSize(800, 480);
        VentMain.setLocation(60, 40);
        VentMain.setBackground(Color.green );
        VentMain.setResizable(true);
        VentMain.setVisible(true);
        VentMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botones();

        jtAMos.setEditable(true);
        jtAMos.setBackground(Color.cyan);
        VentMain.add(jp1, BorderLayout.WEST);
        VentMain.add(jtAMos, BorderLayout.EAST);
    }

    private void botones (){

        jp1 = new JPanel( new GridLayout(3, 1, 25, 55));


        btIng = new JButton("Agregar Empresa");
        btLim = new JButton("Eliminar empresa");
        btDes = new JButton("Agregar Garantias");
        jp1.setBackground(Color.cyan);


        jp1.add(btIng); jp1.add(btLim); jp1.add(btDes);

        btIng.setEnabled(true); btLim.setEnabled(true); btDes.setEnabled(true);

        btIng.addActionListener(this);
        btLim.addActionListener(this);
        btDes.addActionListener(this);

        jp1.setVisible(true);
    }




    public void ingresar() {

        VenIng = new JFrame("VenIng");
        VenIng.setLayout(null);

        jlCuit = new JLabel("CUIT ");
        jtCuit = new JTextField();
        jlRazonsocial = new JLabel("Razon Social ");
        jtRazonsocial = new JTextField();
        jlFechaInicio = new JLabel("Fecha Inicio Actividad "); jtFechaInicio = new JTextField();
        jlTipo = new JLabel("Tipo "); jtTipo = new JTextField();
        jlActividadPrincipal = new JLabel("Actividad Principal "); jtActividadPrincipal = new JTextField();
        jlDireccion = new JLabel("Direccion "); jtDireccion = new JTextField();
        jlTelefono = new JLabel("Telefono "); jtTelefono = new JTextField();
        jlCorreoElectronico = new JLabel("Correo Electronico "); jtCorreoElectronico = new JTextField();
        btCargarEmp = new JButton("Agregar Empresa");

        VenIng.add(jlCuit);
        VenIng.add(jtCuit);
        VenIng.add(jlRazonsocial);
        VenIng.add(jtRazonsocial);
        VenIng.add(jlFechaInicio);
        VenIng.add(jtFechaInicio);
        VenIng.add(jlTipo);
        VenIng.add(jtTipo);
        VenIng.add(jlActividadPrincipal);
        VenIng.add(jtActividadPrincipal);
        VenIng.add(jlDireccion);
        VenIng.add(jtDireccion);
        VenIng.add(jlTelefono);
        VenIng.add(jtTelefono);
        VenIng.add(jlCorreoElectronico);
        VenIng.add(jtCorreoElectronico);
        VenIng.add(btCargarEmp);

        jlCuit.setBounds(10, 20, 90, 24);
        jtCuit.setBounds(160, 20, 90, 24);
        jlRazonsocial.setBounds(10, 45, 90, 24);
        jtRazonsocial.setBounds(160, 45, 90, 24);
        jlFechaInicio.setBounds(10, 70, 90, 24);
        jtFechaInicio.setBounds(160, 70, 90, 24);
        jlTipo.setBounds(10, 95, 90, 24);
        jtTipo.setBounds(160, 95, 90, 24);
        jlActividadPrincipal.setBounds(10, 120, 90, 24);
        jtActividadPrincipal.setBounds(160, 120, 90, 24);
        jlDireccion.setBounds(10, 145, 90, 24);
        jtDireccion.setBounds(160, 145, 90, 24);
        jlTelefono.setBounds(10, 170, 90, 24);
        jtTelefono.setBounds(160, 170, 90, 24);
        jlCorreoElectronico.setBounds(10, 195, 90, 24);
        jtCorreoElectronico.setBounds(160, 195, 90, 24);


        btCargarEmp.setBounds(30, 220, 90, 24);

        jtFechaInicio.addActionListener(this);
        jtTipo.addActionListener(this);
        jtActividadPrincipal.addActionListener(this);
        jtDireccion.addActionListener(this);
        jtTelefono.addActionListener(this);
        jtCorreoElectronico.addActionListener(this);
        jtRazonsocial.addActionListener(this);



        btCargarEmp.addActionListener(this);

        VenIng.setVisible(true);
        VenIng.setResizable(true);
        VenIng.setSize(350, 500);
        VenIng.setLocation(100, 60);
    }


    public void Eliminar (){
        venDelete = new JFrame("Ventana Eliminacion");
        venDelete.setLayout(null);

        jlElimEmp = new JLabel("CUIT Empresa");
        jtElimEmp = new JTextField();

        btElim = new JButton("Eliminar Empresa");


        venDelete.add(jlElimEmp);
        venDelete.add(jtElimEmp);
        venDelete.add(btElim);





        jtElimEmp.addActionListener(this);
        btElim.addActionListener(this);

        jlElimEmp.setBounds(10,20,65,24);
        jtElimEmp.setBounds(80,20,65,24);
        btElim.setBounds(30,70,90,24);

        venDelete.setVisible(true);
        venDelete.setResizable(false);
        venDelete.setSize(350,500);
        venDelete.setLocation(100,60)    ;






    }
    public void Garantias (){
        ventGarantias = new JFrame("Carga Garantias");
        ventGarantias.setLayout(null);

        jlCuit = new JLabel("CUIT Empresa");
        jtCuit = new JTextField();
        jlGarantias = new JLabel("Monto Garantia Expresada en $");
        jtGarantias = new JTextField();

        btGarantias = new JButton("Asignar Garantia a Empresa");


        ventGarantias.add(jlCuit);
        ventGarantias.add(jtCuit);
        ventGarantias.add(jlGarantias);
        ventGarantias.add(jtGarantias);
        ventGarantias.add(btGarantias);





        jtCuit.addActionListener(this);
        jtGarantias.addActionListener(this);
        btGarantias.addActionListener(this);

        jlCuit.setBounds(10,20,100,24);
        jtCuit.setBounds(120,20,100,24);
        jlGarantias.setBounds(10,45,100,24);
        jtGarantias.setBounds(120,45,100,24);
        btGarantias.setBounds(30,70,90,24);

        ventGarantias.setVisible(true);
        ventGarantias.setResizable(false);
        ventGarantias.setSize(350,350);
        ventGarantias.setLocation(100,60)    ;






    }

    public static void main(String[] args) {
        ventanaOperacionesSocio Vent1 = new ventanaOperacionesSocio() {} ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btIng){
            ingresar();
        }else if(e.getSource() == btCargarEmp || e.getSource() == jtRazonsocial){
            if (jtCuit.getText().equals("")|| jtRazonsocial.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite valores validos en todos los campos campos");
            }
            else{        jtAMos.append("Cuit: "+ jtCuit.getText() +  "Razon Social : "+jtRazonsocial.getText() //+"Fecha Inicio: "+ jtFechaInicio//+ //"Tipo: "+
                    //jtTipo//+ "Actividad Principal: "+jtActividadPrincipal+ "Direccion: "+ jtDireccion+ "Telefono: "+ jtTelefono + "Correo Electronico: "+ jtCorreoElectronico
                    + "\n");
                VenIng.dispose();

            }}

        else if(e.getSource() == btLim){
            Eliminar();
        }else if (e.getSource()==btElim){
            return;
            //accion de eliminar el registro.
        }


        else if(e.getSource() == btDes){
            Garantias();
        }else if (e.getSource()==btGarantias){
            return;
            //accion de cargar garantias
        }

    }



}