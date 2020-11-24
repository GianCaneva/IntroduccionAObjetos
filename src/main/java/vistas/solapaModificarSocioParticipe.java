package vistas;

import controller.ControladorSocio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class solapaModificarSocioParticipe extends JInternalFrame{
    private JPanel pnlPrincipal;
    private JTextField jtCuit;
    private JTextField jtRazonSocial;
    private JTextField jtFechaInicio;
    private JComboBox jcbTipo;
    private JTextField jtActividadPrincipal;
    private JTextField jtDireccion;
    private JTextField jtTelefono;
    private JTextField jtCorreoElectronico;
    private JComboBox jcbReferencia;
    private JComboBox jcbUsuario;
    private JButton modificarButton;
    private JButton limpiarFormularioButton;

    public solapaModificarSocioParticipe(String titulo) {
        super(titulo);

        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int referencia=0;

                Date date1 = null;
                try {
                    date1=new SimpleDateFormat("dd/MM/yyyy").parse(jtFechaInicio.getText());
                } catch (ParseException parseException){
                    parseException.printStackTrace();
                }

                //ventanaPrincipal vent = new ventanaPrincipal();
                //ControladorSocio controladorSocio = vent.devolverControladorSocio();
                ControladorSocio controladorSocio = ventanaPrincipal.getVentanaPrincipal("Tabs").controladorSocio;
                controladorSocio.modificarSocioParticipe( Integer.parseInt(jtCuit.getText().trim()), jtRazonSocial.getText(), date1, jcbTipo.getSelectedItem().toString(), jtActividadPrincipal.getText(), jtDireccion.getText(), Integer.parseInt( jtTelefono.getText().trim()), jtCorreoElectronico.getText(),jcbReferencia.getSelectedItem().toString(),jcbUsuario.getSelectedItem().toString());


                jtCuit.setText("");
                jtRazonSocial.setText("");
                jtFechaInicio.setText("");
                jtActividadPrincipal.setText("");
                jtDireccion.setText("");
                jtTelefono.setText("");
                jtCorreoElectronico.setText("");

                JOptionPane.showMessageDialog(null, "Se ha modificado el socio Participe");
            }
        });
        limpiarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtCuit.setText("");
                jtRazonSocial.setText("");
                jtFechaInicio.setText("");
                jtActividadPrincipal.setText("");
                jtDireccion.setText("");
                jtTelefono.setText("");
                jtCorreoElectronico.setText("");
            }
        });
    }
}
