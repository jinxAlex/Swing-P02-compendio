/**
 * VentanaPrincipal.java
 * 17 nov 2024 12:39:23
 * @author Alejandro Fernández Sánchez
 */
package ventana;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * Clase VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements ActionListener{

    /**  Variable para la pantalla, útil para ajustar tamaño y demás. */
    private Toolkit pantalla = Toolkit.getDefaultToolkit();

    /**  Tamaño ventana. */
    Dimension sizePantalla = pantalla.getScreenSize();

    /**  Imagen para el icono reserva. */
    private final Image IMG_ICONO = pantalla.getImage(getClass().getResource("/resources/icono.png"));

    /**  Imagen para alta reserva. */
    private ImageIcon  IMG_ALTA = new ImageIcon(getClass().getResource("/resources/ventanaPrincipal/altaReserva.png"));

    /**  Imagen para baja reserva. */
    private ImageIcon  IMG_BAJA = new ImageIcon(getClass().getResource("/resources/ventanaPrincipal/bajaReserva.png"));

    /**  El panel donde se colocan los botones. */
    private  JPanel panel = new JPanel();

    /**  Menú barra. */
    private  JMenuBar barra = new JMenuBar();

    /**  Menú archivo. */
    private  JMenu archivo = new JMenu("Archivo");

    /**  Menú registro. */
    private  JMenu registro = new JMenu("Registro");

    /**  Menú ayuda. */
    private  JMenu ayuda = new JMenu("Ayuda");

    /**  Menú para salirse de la aplicación. */
    private  JMenuItem salir = new JMenuItem("Salir");

    /**  Menú para lanzar el acerda de. */
    private  JMenuItem acerdaDe = new JMenuItem("Acera de...");

    /**  Menú para lanzar alta Reservas. */
    private  JMenuItem altaReservas = new JMenuItem("Altas Reservas");

    /**  Menú para lanzar baja Reservas. */
    private  JMenuItem bajaReservas = new JMenuItem("Bajas Reservas ");

    /**  Boton para lanzar alta Reservas. */
    private  JButton btnAltaReservas = new JButton(" Alta reservas ",IMG_ALTA);

    /**  Boton para lanzar baja Reservas. */
    private  JButton btnBajaReservas = new JButton("Baja reservas", IMG_BAJA);

    /**
     * Se crea una nueva ventana principal.
     */
    VentanaPrincipal(){
        super("Gestión Hotel Transylvania");
        setIconImage(IMG_ICONO);
        setLayout(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        add(panel, BorderLayout.CENTER);
        addMenu();
        addBotones();
        setListeners();
        centrarVentana();
        setVisible(true);
    }

    /**
     * Centrar ventana.
     */
    private void centrarVentana(){
		int altoPantalla = sizePantalla.height;
		int anchoPantalla = sizePantalla.width;
		
		this.setSize(anchoPantalla/2, altoPantalla/2);
		this.setLocation(anchoPantalla/4, altoPantalla/4);
    }

    /**
     * Pone los listeners.
     */
    private void setListeners(){
        acerdaDe.addActionListener(this);
        salir.addActionListener(this);
        altaReservas.addActionListener(this);
        bajaReservas.addActionListener(this);
        btnAltaReservas.addActionListener(this);
        btnBajaReservas.addActionListener(this);
    }

    /**
     * Añade el menu a la ventana.
     */
    private void addMenu(){
        barra.add(archivo);
        barra.add(registro);
        archivo.add(salir);
        archivo.setMnemonic(KeyEvent.VK_A);
        barra.add(ayuda);
        ayuda.add(acerdaDe);
        registro.add(altaReservas);
        altaReservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        bajaReservas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        registro.add(bajaReservas);
        setJMenuBar(barra);
    }

    /**
     * Añade los botones a la ventana.
     */
    private void addBotones(){
        btnAltaReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBajaReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createHorizontalGlue());
        panel.add(btnAltaReservas);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(btnBajaReservas);
        panel.add(Box.createHorizontalGlue());
    }

    /**
     * Método que ejecuta metodos según el boton pulsado.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAltaReservas || e.getSource() == altaReservas){
            new VentanaDialogo(this);
        }else if(e.getSource() == btnBajaReservas || e.getSource() == bajaReservas){
            JOptionPane.showMessageDialog(null, "Esta opción no esta implementada aún", "Información", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource() == acerdaDe){
            JOptionPane.showMessageDialog(null, "Hecha para el hotel Transylvania", "Aplicación desarrollada por Alejandro Fernnández Sánchez", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource() == salir){
            this.dispose();
        }
    }
}
