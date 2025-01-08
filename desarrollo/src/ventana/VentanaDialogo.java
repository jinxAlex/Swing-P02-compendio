/**
 * VentanaDialogo.java
 * 17 nov 2024 12:41:08
 * @author Alejandro
 */
package ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import paneles.*;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * Clase VentanaDialogo.
 */
public class VentanaDialogo extends JDialog implements ActionListener{

    /** Variable para la pantalla. */
    private Toolkit pantalla = Toolkit.getDefaultToolkit();

    /** Tamaño de la pantalla. */
    Dimension sizePantalla = pantalla.getScreenSize();
    
    /**  Imagen de guardar. */
    private ImageIcon  IMG_GUARDAR = new ImageIcon(getClass().getResource("/resources/ventanaAltaReserva/guardar.png"));

    /**  Imagen de nuevo. */
    private ImageIcon  IMG_NUEVO = new ImageIcon(getClass().getResource("/resources/ventanaAltaReserva/nuevo.png"));

    /**  Imagen de imprimir. */
    private ImageIcon  IMG_IMPRIMIR = new ImageIcon(getClass().getResource("/resources/ventanaAltaReserva/imprimir.png"));

    /**  Panel principal. */
    private  JPanel panelPrincipal = new JPanel();

    /**  Panel titulo. */
    private  Titulo titulo = new Titulo();

    /**  Panel datosCliente. */
    private  DatosCliente datosCliente = new DatosCliente();

    /**  Panel datosHabitacion. */
    private  DatosHabitacion datosHabitacion = new DatosHabitacion();

    /**  Panel Impresion. */
    private  Impresion impresion = new Impresion();

    /**  Panel con botones. */
    private  JPanel panelBotones = new JPanel();

    /**  Boton imprimir. */
    private  JButton btnImprimir = new JButton("Imprimir a Documento", IMG_IMPRIMIR);

    /**  Boton nuevo. */
    private  JButton btnNuevo = new JButton("Nuevo", IMG_NUEVO);

    /**  Boton guardar. */
    private  JButton btnGuardar = new JButton("Guardar", IMG_GUARDAR);


    /**
     * Constructor de la clase Ventana Dialogo.
     *
     * @param parent the parent
     */
    public VentanaDialogo(JFrame parent){
        super(parent,"Alta Reservas",true);

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

        add(panelPrincipal);

        panelPrincipal.add(titulo);
        panelPrincipal.add(datosCliente);
        panelPrincipal.add(datosHabitacion);
        panelPrincipal.add(impresion);

        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.add(btnImprimir);
        panelBotones.add(Box.createHorizontalStrut(30));
        panelBotones.add(btnNuevo);
        panelBotones.add(Box.createHorizontalStrut(30));
        panelBotones.add(btnGuardar);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 10));

        panelPrincipal.add(panelBotones);
        setSize(sizePantalla.width, sizePantalla.height);
        setListeners();
        this.setVisible(true);
    }

    /**
     * Establece los listeners.
     */
    private void setListeners(){
        btnImprimir.addActionListener(this);
        btnNuevo.addActionListener(this);
        btnGuardar.addActionListener(this);
    }


    /**
     * Método para lanzar los distintos eventos según el boton que se presione.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnImprimir){
        	int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas imprimir los datos?","Confirmación",JOptionPane.YES_NO_OPTION);
        	if(respuesta == 0 ) {
        		if(datosCliente.comprobarDatos() && datosHabitacion.comprobarDatos()){
        			impresion.reiniciarDatos();
        			impresion.configurarPanelDatosCliente(datosCliente.getDatos());
        			impresion.configurarPanelDatosHabitacion(datosHabitacion.getDatos());
        			impresion.cambiarFuente();
        		}
            }
        }else if(e.getSource() == btnGuardar){
        	int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas guardar los datos?","Confirmación",JOptionPane.YES_NO_OPTION);
        	if(respuesta == 0 ) {
        		JOptionPane.showMessageDialog(null,  "Se han guardado los datos correctamente", "Completado", JOptionPane.INFORMATION_MESSAGE);
        	}
        }else if (e.getSource() == btnNuevo) {
        	int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que deseas borrar los datos?","TODO SERA BORRADO",JOptionPane.YES_NO_OPTION);
        	if(respuesta == 0 ) {
                datosCliente.reiniciarDatos();
                datosHabitacion.reiniciarDatos();
                impresion.reiniciarDatos();
        	}
        }
    }
    
}
