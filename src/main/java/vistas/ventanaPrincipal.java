package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class ventanaPrincipal extends JFrame implements ActionListener {
    private JPanel mainPanel ;//= new JPanel();
    private JMenuBar mb;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6, menu7;
    private JMenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7,mi8;



    public ventanaPrincipal(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
       
        /*
        JFrame mainPanel = new JFrame("Gestionar Empresas");
        mainPanel.setLayout(new BorderLayout(30, 25));
        mainPanel.setSize(800, 480);
        mainPanel.setLocation(60, 40);
        mainPanel.setBackground(Color.CYAN );
        mainPanel.setResizable(true);
        mainPanel.setVisible(true);
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */


        this.pack();
        getContentPane().setLayout(null);

        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Herramientas");
        mb.add(menu1);


        menu2 = new JMenu("Empresas");
        menu1.add(menu2);
        mi1 = new JMenuItem("Gestionar Empresas");
        mi1.addActionListener(this);
        menu2.add(mi1);
        menu3 = new JMenu("Consultas Generales");
        menu1.add(menu3);
        mi2 = new JMenuItem("Comisiones calculadas por dia");
        menu3.add(mi2);
        mi2.addActionListener(this);
        mi3 = new JMenuItem("Operaciones por Socio");
        menu3.add(mi3);
        mi3.addActionListener(this);
        mi4 = new JMenuItem("Valor promedio Tasa Descuentos");
        menu3.add(mi4);
        mi4.addActionListener(this);


        mi5 = new JMenuItem("Calculo de Comision");
        menu3.add(mi5);
        mi5.addActionListener(this);

        mi6 = new JMenuItem("Consulta Consolidada");
        menu3.add(mi6);
        mi6.addActionListener(this);

        mi7 = new JMenuItem("Consulta Mora");
        menu3.add(mi7);
        mi7.addActionListener(this);

        mi8 = new JMenuItem("Consulta Porcentaje Comision");
        menu3.add(mi8);
        mi8.addActionListener(this);
    }

    public static void main(String[] ar) {
        ventanaPrincipal frame = new ventanaPrincipal("TPO Grupo3");
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {

                                   public void run() {
                                       if (e.getSource() == mi1) {
                                           try {
                                               ventanaEmpresa frame = new ventanaEmpresa();

                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       } else if (e.getSource() == mi2) {
                                           try {
                                               ventanaComision frame = new ventanaComision();
                                           } catch (Exception e) {
                                               e.printStackTrace();

                                           }
                                       } else if (e.getSource() == mi3) {
                                           try {
                                               ventanaOperacionesSocio frame = new ventanaOperacionesSocio();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }


                                       } else if (e.getSource() == mi4) {
                                           try {
                                               ventanaValorPromedio frame = new ventanaValorPromedio();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }
                                       } else if (e.getSource() == mi5) {
                                           try {
                                               ventanaComision frame = new ventanaComision();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }
                                       } else if (e.getSource() == mi6) {
                                           try {
                                               ventanaConsultaConsolidad frame = new ventanaConsultaConsolidad();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mi7) {
                                           try {
                                               ventanaSaldoMora frame = new ventanaSaldoMora();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mi8) {
                                           try {
                                               ventanaPorcentajeComision frame = new ventanaPorcentajeComision();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }

                                   }
                               }
        );
    }
}










