package vistas;

import controller.ControladorSocio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarAccionista extends JInternalFrame{
    private JPanel pnlPrincipal;
    private JTextField jtCuitEmpresa;
    private JTextField jtCuitAccionista;
    private JButton eliminarButton;
    private JButton limpiarFormularioButton;

    public eliminarAccionista(String titulo) {
        super(titulo);

        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaPrincipal vent = new ventanaPrincipal();
                ControladorSocio controladorSocio = vent.devolverControladorSocio();
                controladorSocio.eliminarAccionista( Integer.parseInt(jtCuitEmpresa.getText().trim()), Integer.parseInt(jtCuitAccionista.getText().trim()));


                jtCuitEmpresa.setText("");
                jtCuitAccionista.setText("");

                JOptionPane.showMessageDialog(null, "Se elimino nuevo accionista! :(");

            }
        });
        limpiarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtCuitEmpresa.setText("");
                jtCuitAccionista.setText("");
            }
        });
    }
}
