package vistas;

import javax.swing.*;
import java.awt.*;

public class ventanaGestionEmpresa extends JDialog{

    private JPanel pnlGestionEmpresa;
    private JTabbedPane tabbedPane1;
    private JDesktopPane desktopPaneCargarSocioProtector;
    private JDesktopPane desktopPaneModificarSocioProtector;
    private JDesktopPane desktopPaneCargarSocioParticipe;
    private JDesktopPane desktopPaneModificarSocioParticipe;
    private JDesktopPane desktopPaneAgregarAccionista;
    private JDesktopPane desktopPaneEliminarAccionista;

    public ventanaGestionEmpresa(Window owner, String titulo){
        super(owner, titulo);
        this.setContentPane(pnlGestionEmpresa);
        this.setModal(true);
        this.setSize(720,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        solapaCargarSocioProtector frameSolapa1 = new solapaCargarSocioProtector("Solapa Carga Socio Protector");
        frameSolapa1.setVisible(true);
        desktopPaneCargarSocioProtector.add(frameSolapa1);
        solapaCargarSocioParticipe frameSolapa2 = new solapaCargarSocioParticipe("Solapa Carga Socio Participe");
        frameSolapa2.setVisible(true);
        desktopPaneCargarSocioParticipe.add(frameSolapa2);
        solapaModificarSocioParticipe frameSolapa3 = new solapaModificarSocioParticipe("Solapa Modificar Socio Participe");
        frameSolapa3.setVisible(true);
        desktopPaneModificarSocioParticipe.add(frameSolapa3);
        solapaModificarSocioProtector frameSolapa4 = new solapaModificarSocioProtector("Solapa Modificar Socio Protector");
        frameSolapa4.setVisible(true);
        desktopPaneModificarSocioProtector.add(frameSolapa4);
        agregarAccionista frameSolapa5 = new agregarAccionista("Solapa Agregar Accionista");
        frameSolapa5.setVisible(true);
        desktopPaneAgregarAccionista.add(frameSolapa5);
        eliminarAccionista frameSolapa6 = new eliminarAccionista("Solapa Eliminar Accionista");
        frameSolapa6.setVisible(true);
        desktopPaneEliminarAccionista.add(frameSolapa6);
    }
}
