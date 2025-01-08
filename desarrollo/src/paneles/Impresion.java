/**
 * Impresion.java
 * 17 nov 2024 12:42:10
 * @author Alejandro Fernández Sánchez
 */
package paneles;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

// TODO: Auto-generated Javadoc
/**
 * Clase Impresion.
 */
public class Impresion extends JPanel {
	
	/** La fuente para las labels. */
	private Font fuenteLabels = new Font("Playfair Display", Font.BOLD, 16);

    /**  El panel datos cliente. */
    private static JPanel panelDatosCliente = new JPanel();

    /**  El panel datos habitación. */
    private static JPanel panelDatosHabitacion = new JPanel();

    /**  Las pestañas. */
    private static JTabbedPane tabs;

    /**
     * Crea una nueva Impresion.
     */
    public Impresion(){
        setBorder(BorderFactory.createLineBorder(Color.decode("#566573"),5));
        setBackground(Color.decode("#b2babb"));
        setLayout(new BorderLayout());
	    tabs = new JTabbedPane();
        tabs.addTab( "Datos del cliente", panelDatosCliente);
	    tabs.addTab ( "Datos de la habitación",panelDatosHabitacion);
        //configurarPanelDatosHabitacion();
	    add(tabs, BorderLayout.CENTER);
    }


    /**
     * Configurar el panel datos Cliente.
     *
     * @param datos the datos
     */
    public void configurarPanelDatosCliente(String[] datos){
        panelDatosCliente.setLayout(new GridLayout(4,2));
        panelDatosCliente.add(new JLabel("Nombre: " + datos[0]));
        panelDatosCliente.add(new JLabel("Apellidos: " + datos[1]));
        panelDatosCliente.add(new JLabel("DNI: " + datos[2]));
        panelDatosCliente.add(new JLabel("Teléfono: " + datos[3]));
        panelDatosCliente.add(new JLabel("Fecha de entrada: " + datos[4]));
        panelDatosCliente.add(new JLabel("Fecha de Salida: " + datos[5]));
        panelDatosCliente.add(new JLabel("Dias de estancia: " + datos[6]));
        panelDatosCliente.add(new JLabel("¿Por motivos de trabajo?: " + datos[7]));
    }

    /**
     * Configura el panel datos Habitacion.
     *
     * @param datos the datos
     */
    public void configurarPanelDatosHabitacion(String[] datos){
        panelDatosHabitacion.setLayout(new GridLayout(3,2));
        panelDatosHabitacion.add(new JLabel("Tipo de habitación : " + datos[0]));
        panelDatosHabitacion.add(new JLabel("Nº de habitaciones: " + datos[1]));
        panelDatosHabitacion.add(new JLabel("¿Niños?: " + ((datos[2] == "true") ? "Sí": "No")));
        if(datos[2] == "true"){
            panelDatosHabitacion.add(new JLabel("Edad del niño: " + datos[3]));
            panelDatosHabitacion.add(new JLabel("Extras: " + datos[4]));
        }
        panelDatosHabitacion.add(new JLabel("Importe de habitación: " + datos[5]));

    }
    
	/**
	 * Cambia la fuente.
	 */
	public void cambiarFuente() {
		for (Component componente : panelDatosCliente.getComponents()) {
			if(componente instanceof JLabel) {
				componente.setFont(fuenteLabels);
			}
		}
		for (Component componente : panelDatosCliente.getComponents()) {
			if(componente instanceof JLabel) {
				componente.setFont(fuenteLabels);
			}
		}
	}


    /**
     * Reinicia los datos.
     */
    public void reiniciarDatos() {
        panelDatosCliente.removeAll();
        panelDatosHabitacion.removeAll();
    }
}

