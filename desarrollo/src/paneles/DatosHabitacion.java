/**
 * DatosHabitacion.java
 * 17 nov 2024 12:42:54
 * @author Alejandro
 */
package paneles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// TODO: Auto-generated Javadoc
/**
 * La clase datos abitacion.
 */
public class DatosHabitacion extends JPanel implements ItemListener, ActionListener, ChangeListener{

	/**  Variable que contiene el panel extras niño. */
	private  static ExtrasChild extrasChild = new ExtrasChild();
	
	/**  Fuente para las etiquetas. */
	private Font fuenteLabels = new Font("Playfair Display", Font.BOLD, 16);

	/**  El panel imagenes. */
	private JPanel panelImagenes = new JPanel();

    /**  Las constraints. */
    private GridBagConstraints constraints;

	/**  El layout. */
	private GridBagLayout layout = new GridBagLayout();

	/**  Etiqueta del tipo de habitación. */
	private static JLabel tipoLabel = new JLabel("Tipo de habitación: ");

    /**  Array con los tipos de habitaciones. */
    private static String[] tiposHabitaciones = {"Simple", "Doble", "Suite"};

	/**  Array con las imagenes de las habitaciones. */
	private static String[] imagenesHabitaciones = {"/resources/habitaciones/habitacion1.jpg", "/resources/habitaciones/habitacion2.jpg", "/resources/habitaciones/habitacion3.jpg"};

    /**  Combo box con los tipos de habitaciones. */
    private static JComboBox<String> tipoHabitacion = new JComboBox<>(tiposHabitaciones);

	/**  Etiqueta para el numero de habitaciones. */
	private static JLabel numHabitacionesLabel = new JLabel("Nº de habitaciones: ");

	/**  El modelo para el spinner. */
	private static SpinnerNumberModel  modelo = new SpinnerNumberModel(0, 0, 50, 1);

	/**  Spinner para el número de habitaciones. */
	private static JSpinner spinnerNumHabitaciones = new JSpinner(modelo);
	
	/**  Etiqueta niño. */
	private static JLabel childLabel = new JLabel("¿Niños?: ");

    /**  CheckBox para comprobar si el cliente lleva un niño. */
    private static JCheckBox checkChild = new JCheckBox();

    /**  Etiqueta importe. */
    private static JLabel importeLabel = new JLabel("Importe habitación: ");

    /**  Imagen 2. */
    private JLabel ivImagen1 = new JLabel();
    
    /**  Imagen 2. */
    private JLabel ivImagen2 = new JLabel();
    
    /**  Imagen 3. */
    private JLabel ivImagen3 = new JLabel();

	/**  Variable con el importe. */
	private static int importe = 0;

	/**  El campo importe. */
	private static JTextField tvImporte = new JTextField();


	/**
	 * Crea una nueva clase.
	 */
	public DatosHabitacion() {
        setBorder(BorderFactory.createLineBorder(Color.decode("#cd6155"),5));
        extrasChild.setBackground(Color.decode("#a9cce3"));
        checkChild.setBackground(Color.decode("#a9cce3"));
        panelImagenes.setBackground(Color.decode("#a9cce3"));
        tvImporte.setBackground(Color.decode("#a9cce3"));
        setBackground(Color.decode("#a9cce3"));
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);

		setListeners();

        numHabitacionesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tipoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        childLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        importeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		constraints.weightx = 1.0;
        constraints.weighty = 1;

        constraints.weightx = 0;
		agregarComponente(tipoLabel, 0,0, 1, 1);

		constraints.weightx = 1.0;
		agregarComponente(tipoHabitacion, 1, 0, 1, 1);

        constraints.weightx = 0;
		agregarComponente(numHabitacionesLabel, 2,0, 1, 1);

        constraints.weightx = 1.0;
		agregarComponente(spinnerNumHabitaciones, 3, 0, 1, 1);

        constraints.weightx = 0;
		agregarComponente(childLabel, 0,1, 1, 1);

        constraints.weightx = 1.0;
		agregarComponente(checkChild, 1,1, 1, 1);

		constraints.weightx = 0;
		agregarComponente(importeLabel, 0,4, 1, 1);

	    panelImagenes.setLayout(new FlowLayout());
	    panelImagenes.add(ivImagen1);
	    panelImagenes.add(ivImagen2);
	    panelImagenes.add(ivImagen3);
		agregarComponente(panelImagenes, 0,2, 2, 1);

		tvImporte.setEditable(false);
		constraints.weightx = 1.0;
		agregarComponente(tvImporte, 1,4, 1, 1);

		agregarComponente(extrasChild, 2,1,2,4);

		cambiarFuente();
		cambiarImagen();
		mostrarPanelChild();
		cambiarImporte();
		this.setVisible(true);
	}

	/**
	 * Sets the listeners.
	 */
	private void setListeners(){
		tipoHabitacion.addItemListener(this);
		checkChild.addActionListener(this);
		spinnerNumHabitaciones.addChangeListener(this);
	}
	
	/**
	 * Cambiar fuente.
	 */
	private void cambiarFuente() {
		for (Component componente : getComponents()) {
			if(componente instanceof JLabel) {
				componente.setFont(fuenteLabels);
			}
		}
	}
		
	/**
	 * Agregar componente.
	 *
	 * @param component the component
	 * @param column the column
	 * @param row the row
	 * @param width the width
	 * @param height the height
	 */
	private void agregarComponente(Component component, int column, int row, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;

		layout.setConstraints(component, constraints);
		this.add(component);
	}

	/**
	 * Item state changed.
	 *
	 * @param e the e
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == tipoHabitacion){
			cambiarImporte();
			cambiarImagen();
		}
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkChild){
			mostrarPanelChild();
		}
	}
	
	/**
	 * Mostrar panel child.
	 */
	private void mostrarPanelChild(){
		if(checkChild.isSelected()){
			extrasChild.setVisible(true);
			cambiarImporte();
		}else{
			extrasChild.setVisible(false);
			cambiarImporte();
		}
	}

	/**
	 * Cambiar imagen.
	 */
	private void cambiarImagen(){
		ivImagen1.setIcon(new ImageIcon(getClass().getResource(imagenesHabitaciones[0])));
		ivImagen2.setIcon(new ImageIcon(getClass().getResource(imagenesHabitaciones[1])));
		ivImagen3.setIcon(new ImageIcon(getClass().getResource(imagenesHabitaciones[2])));
	}

	/**
	 * Cambia el importe.
	 */
	public static void cambiarImporte(){
		importe = 0;
		int numDias = (int)DatosCliente.getNumDias();
		int numHabitaciones = (int)spinnerNumHabitaciones.getValue();
		switch ((String)tipoHabitacion.getSelectedItem()) {
			case "Simple":
				importe = numDias * 50 * numHabitaciones;
				break; 
			case "Doble":
				importe = numDias * 75  * numHabitaciones ;
				break;
			case "Suite":
				importe = numDias * 125 * numHabitaciones;
				break;
		}

		if(checkChild.isSelected()){
			importe += 20;
		}
		tvImporte.setText(Integer.toString(importe) + " €");
	}

	/**
	 * Comprobar datos.
	 *
	 * @return true, if successful
	 */
	public boolean comprobarDatos() {
		boolean esCorrecto = true;
		if((int)spinnerNumHabitaciones.getValue() == 0){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "El número de habitaciones introducido no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return esCorrecto;
	}

    /**
     * Obtiene los datos.
     *
     * @return the datos
     */
    public String[] getDatos() {
		String[] datos = {String.valueOf(tipoHabitacion.getSelectedItem()),String.valueOf(spinnerNumHabitaciones.getValue()), checkChild.isSelected() ? "true" : "false", checkChild.isSelected() ? String.valueOf(extrasChild.getEdad()) : "", checkChild.isSelected() ? extrasChild.getExtras() : "", tvImporte.getText()};
		return datos;
    }

	/**
	 * Reiniciar datos.
	 */
	public void reiniciarDatos() {
		tipoHabitacion.setSelectedIndex(0);
		spinnerNumHabitaciones.setValue(0);
		checkChild.setSelected(false);
		extrasChild.reiniciarDatos();
		mostrarPanelChild();
	}

	/**
	 * State changed.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == spinnerNumHabitaciones) {
			cambiarImporte();
		}
	}
}
