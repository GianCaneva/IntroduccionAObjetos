package vistas;

import javax.swing.*;
import java.awt.*;

public class solapaCargarSocioProtector extends JInternalFrame {

    private JPanel pnlPrincipal;
    private JButton button1;
    private JButton button2;

    public solapaCargarSocioProtector(String titulo){
        super(titulo);

        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

    }
}
