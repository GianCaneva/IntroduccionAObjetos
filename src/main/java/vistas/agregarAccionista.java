package vistas;

import controller.ControladorSocio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class agregarAccionista extends JInternalFrame{
    private JTextField jtCuitEmpresa;
    private JTextField jtCuitAccionista;
    private JTextField jtRazonSocial;
    private JTextField jtParticipacion;
    private JButton agregarButton;
    private JButton limpiarFormularioButton;
    private JPanel pnlPrincipal;

    public agregarAccionista(String titulo) {
        super(titulo);

        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //ventanaPrincipal vent = new ventanaPrincipal();
                //ControladorSocio controladorSocio = vent.devolverControladorSocio();
                ControladorSocio controladorSocio = ventanaPrincipal.getVentanaPrincipal("Tabs").controladorSocio;
                controladorSocio.agregarAccionista( Integer.parseInt(jtCuitEmpresa.getText().trim()), Integer.parseInt(jtCuitAccionista.getText().trim()),jtRazonSocial.getText(), Float.parseFloat(jtParticipacion.getText().trim()));


                jtCuitEmpresa.setText("");
                jtCuitAccionista.setText("");
                jtRazonSocial.setText("");
                jtParticipacion.setText("");

                JOptionPane.showMessageDialog(null, "Se agrego nuevo accionista!");

            }
        });
        limpiarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtCuitEmpresa.setText("");
                jtCuitAccionista.setText("");
                jtRazonSocial.setText("");
                jtParticipacion.setText("");
            }
        });
    }
}
