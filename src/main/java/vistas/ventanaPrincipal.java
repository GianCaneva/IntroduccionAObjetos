package vistas;

import controller.ControladorOperacion;
import controller.ControladorSocio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class ventanaPrincipal extends JFrame implements ActionListener {
    private JPanel mainPanel ;//= new JPanel();
    private JMenuBar mb;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6, menu7;
    private JMenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7,mi8,mo1,mo2,mo3,mo4,mo5,mo6,mo7,mo8,mo9,mo10,mo11,mo12,mo13,mo14,mo15,mo16,mo17;

    private ventanaPrincipal self;
    ControladorSocio controladorSocio = new ControladorSocio();
    public ControladorSocio devolverControladorSocio(){
        return controladorSocio;
    }
    public ventanaPrincipal(){

    }
    public ventanaPrincipal(String title) {

        super(title);
        //ControladorSocio controladorSocio = new ControladorSocio();
        ControladorOperacion controladorOperacion=new ControladorOperacion();
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

        menu4 = new JMenu("Operaciones");
        menu2.addActionListener(this);
        menu2.add(menu4);

        mo1 = new JMenuItem("Asignar linea de credito");
        menu4.add(mo1);
        mo1.addActionListener(this);

        mo2 = new JMenuItem("Suscribir acciones");
        menu4.add(mo2);
        mo2.addActionListener(this);

        mo3 = new JMenuItem("Solicitar operacion prestamo");
        menu4.add(mo3);
        mo3.addActionListener(this);

        mo4 = new JMenuItem("Modificar operacion prestamo");
        menu4.add(mo4);
        mo4.addActionListener(this);

        mo5 = new JMenuItem("Solicitar operacion cheque");
        menu4.add(mo5);
        mo5.addActionListener(this);

        mo6 = new JMenuItem("Modificar operacion cheque");
        menu4.add(mo6);
        mo6.addActionListener(this);

        mo7 = new JMenuItem("Solicitar operacion cc");
        menu4.add(mo7);
        mo7.addActionListener(this);

        mo8 = new JMenuItem("Modificar operacion cc");
        menu4.add(mo8);
        mo8.addActionListener(this);


        mo9 = new JMenuItem("Operacion prosperada");
        menu4.add(mo9);
        mo9.addActionListener(this);

        mo10 = new JMenuItem("Agregar desembolso");
        menu4.add(mo10);
        mo10.addActionListener(this);

        mo11 = new JMenuItem("Eliminar desembolso");
        menu4.add(mo11);
        mo11.addActionListener(this);

        mo12 = new JMenuItem("Emitir facturas pendientes");
        menu4.add(mo12);
        mo12.addActionListener(this);


        mo13 = new JMenuItem("Presentar Documentacion");
        menu4.add(mo13);
        mo13.addActionListener(this);

        mo14 = new JMenuItem("Modificar Documentacion");
        menu4.add(mo14);
        mo14.addActionListener(this);

        mo15 = new JMenuItem("Aprobar Documentacion");
        menu4.add(mo15);
        mo15.addActionListener(this);

        mo16 = new JMenuItem("Operar");
        menu4.add(mo16);
        mo16.addActionListener(this);










        menu3 = new JMenu("Consultas Generales");
        menu1.add(menu3);
        mi2 = new JMenuItem("Comisiones calculadas por dia"); //1 OK
        menu3.add(mi2);
        mi2.addActionListener(this);
        mi3 = new JMenuItem("Operaciones por Socio");  //2  OK
        menu3.add(mi3);
        mi3.addActionListener(this);
        mi4 = new JMenuItem("Valor promedio Tasa Descuentos"); //3  OK
        menu3.add(mi4);
        mi4.addActionListener(this);

//
//        mi5 = new JMenuItem("Calculo de Comision"); ///4
//        menu3.add(mi5);
//        mi5.addActionListener(this);

        mi6 = new JMenuItem("Consulta Consolidada"); ///6 OK
        menu3.add(mi6);
        mi6.addActionListener(this);

        mi7 = new JMenuItem("Consulta Mora"); ///5
        menu3.add(mi7);
        mi7.addActionListener(this);

        mi8 = new JMenuItem("Consulta Porcentaje Comision");//4 OK
        menu3.add(mi8);
        mi8.addActionListener(this);

        this.self = this;
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
                                               ventanaGestionEmpresa frame = new ventanaGestionEmpresa(self,"Gestion Empresa");
                                               frame.setVisible(true);

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
//                                       } else if (e.getSource() == mi5) {
//                                           try {
//                                               ventanaComision frame = new ventanaComision();
//                                           } catch (Exception e) {
//                                               e.printStackTrace();
//                                           }
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

                                       }else if (e.getSource() == mo1) {
                                           try {
                                               ventanaLineaCredito frame = new ventanaLineaCredito();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo2) {
                                           try {
                                               ventanaSuscribirAcciones frame = new ventanaSuscribirAcciones();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo3) {
                                           try {
                                               ventanaSolicitarPrestamo frame = new ventanaSolicitarPrestamo();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo4) {
                                           try {
                                               ventanaModificarOperacion frame = new ventanaModificarOperacion();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo5) {
                                           try {
                                               ventanaSolicitarOPch frame = new ventanaSolicitarOPch();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo6) {
                                           try {
                                               ventanaModificarCheque frame = new ventanaModificarCheque();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo7) {
                                           try {
                                               ventanaSolicitarOPcc frame = new ventanaSolicitarOPcc();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo8) {
                                           try {
                                               ventanaModificarOpcc frame = new ventanaModificarOpcc();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo9) {
                                           try {
                                               ventanaOperacionProsperada frame = new ventanaOperacionProsperada();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo10) {
                                           try {
                                               ventanaAgregarDesembolso frame = new ventanaAgregarDesembolso();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo11) {
                                           try {
                                               ventanaEliminarDesembolso frame = new ventanaEliminarDesembolso();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo12) {
                                           try {
                                               ventanaEmisionFacturas frame = new ventanaEmisionFacturas();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo13) {
                                           try {
                                               ventanaPresentarDoc frame = new ventanaPresentarDoc();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo14) {
                                           try {
                                               ventanaModificarDoc frame = new ventanaModificarDoc();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo15) {
                                           try {
                                               ventanaAprobardoc frame = new ventanaAprobardoc();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }else if (e.getSource() == mo16) {
                                           try {
                                               ventanaOperarOP frame = new ventanaOperarOP();
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

                                       }

                                   }
                               }
        );
    }
}










