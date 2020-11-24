package vistas;

import javax.swing.*;

public class solapaCargarSocioParticipe extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton confirmarButton;
    private JButton limpiarFormularioButton;

    public solapaCargarSocioParticipe(String titulo) {
        super(titulo);

        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }
}
