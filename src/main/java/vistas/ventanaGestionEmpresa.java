package vistas;

import javax.swing.*;
import java.awt.*;

public class ventanaGestionEmpresa extends JDialog{

    private JPanel pnlGestionEmpresa;
    private JTabbedPane tabbedPane1;
    private JDesktopPane desktopPaneCargarSocioProtector;
    private JDesktopPane desktopPaneModificarSocioProtector;

    public ventanaGestionEmpresa(Window owner, String titulo){
        super(owner, titulo);
        this.setContentPane(pnlGestionEmpresa);
        this.setModal(true);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        solapaCargarSocioProtector frameSolapa1 = new solapaCargarSocioProtector("Solapa Carga Socio Protector");
        frameSolapa1.setVisible(true);
        desktopPaneCargarSocioProtector.add(frameSolapa1);
    }
}
