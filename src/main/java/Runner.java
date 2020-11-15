import controller.ControladorOperacion;
import controller.ControladorSocio;

import java.io.IOError;
import java.io.IOException;
import java.util.logging.Logger;

public class Runner {
    private static ControladorOperacion controladorOperacion;
    private static ControladorSocio controladorSocio;

    public static void main(final String[] args) throws IOException {

        controladorOperacion = new ControladorOperacion();
        controladorSocio = new ControladorSocio();

        System.out.println("Iniciando programa SGR.....");
        while(true){

        }

    }
}
