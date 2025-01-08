/**
 * ExtrasChild.java
 * 17 nov 2024 12:42:32
 * @author Alejandro
 */
package paneles;


import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


// TODO: Auto-generated Javadoc
/**
 * La clase Extra Child.
 */
public class ExtrasChild extends JPanel implements FocusListener{
	
	/**  La fuente para las labels. */
	private Font fuenteLabels = new Font("Playfair Display", Font.BOLD, 16);
    
    /**  E. */
    private static JLabel edadLabel = new JLabel("Edad del niño:");

    /**  Modelo para el spinner. */
    private static SpinnerNumberModel  modelo = new SpinnerNumberModel(0, 0, 14, 1);

    /** The extras label. */
    private static JLabel extrasLabel = new JLabel("Extras:");

    /** The edad spinner. */
    private static JSpinner edadSpinner = new JSpinner(modelo);

    /** The tv extra. */
    private static JTextField tvExtra = new JTextField();

    /**
     * Constructor de la clase ExtrasChild.
     */
    public ExtrasChild(){
        setLayout(new GridLayout(2,2, 10, 75));
        edadLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        extrasLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(edadLabel);
        add(edadSpinner);
        add(extrasLabel);
        add(tvExtra);
        setListeners();
        cambiarFuente();
    }
    
	/**
	 * Cambia la fuente.
	 */
	private void cambiarFuente() {
		for (Component componente : getComponents()) {
			if(componente instanceof JLabel) {
				componente.setFont(fuenteLabels);
			}
		}
	}

    /**
     * Establece los listeners.
     */
    public void setListeners(){
        tvExtra.addFocusListener(this);
    }

    /**
     * Método para cuando gana el foco.
     *
     * @param e the e
     */
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == tvExtra){
            actualizarCampoExtra();
        }
    }

    /**
     * Método para cuando pierde el foco.
     *
     * @param e the e
     */
    @Override
    public void focusLost(FocusEvent e) {}

    /**
     * Actualiza el campo extra.
     */
    public void actualizarCampoExtra(){
        int edad = (int)edadSpinner.getValue();

        if (edad >= 0 && edad <= 3) {
            tvExtra.setText("cuna");
        } else if (edad >= 4 && edad <= 10) {
            tvExtra.setText("cama supletoria pequeña");
        } else {
            tvExtra.setText("cama supletoria normal");
        }
    }

    /**
     * Obtener la edad.
     *
     * @return the edad
     */
    public int getEdad(){
        return (int)edadSpinner.getValue();
    }

    /**
     * Obtener los extras.
     *
     * @return the extras
     */
    public String getExtras(){
        return tvExtra.getText();
    }

    /**
     * Reinicia los datos.
     */
    public void reiniciarDatos() {
        edadSpinner.setValue(0);
        actualizarCampoExtra();
    }
}
