/**
 * Titulo.java
 * 17 nov 2024 12:41:44
 * @author Alejandro
 */
package paneles;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * La clase titulo.
 */
public class Titulo extends JPanel{

    /**  Constante para la variable titulo. */
    private static final Label labelTitulo = new Label("Hotel Transylvania");

    /**
     * Crea una nueva clase.
     */
    public Titulo(){
        labelTitulo.setFont(new Font("Playfair Display", Font.BOLD, 36));
        setBorder(BorderFactory.createLineBorder(Color.decode("#cd6155"),5));
        add(labelTitulo);
        setBackground(Color.decode("#f8c471"));
    }
}
