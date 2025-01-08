/**
 * DatosCliente.java
 * 17 nov 2024 12:43:14
 * @author Alejandro
 */
package paneles;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

// TODO: Auto-generated Javadoc
/**
 * Clase DatosCliente, donde se encuentra los datos del cliente.
 */
public class DatosCliente extends JPanel implements DocumentListener {

    /**  Las constraints. */
    private GridBagConstraints constraints;

	/**  La variable Layout. */
	private GridBagLayout layout = new GridBagLayout();

	/**  La fuente para las etiquetas. */
	private Font fuenteLabels = new Font("Playfair Display", Font.BOLD, 16);
	
	/**  Un radio button con respuesta si por si el cliente se hospeda por motivos de trabajo. */
	private static JRadioButton radioSi = new JRadioButton("Sí");
	
	/**  Un radio button con respuesta no por si el cliente se hospeda por motivos de trabajo. */
	private static JRadioButton radioNo = new JRadioButton("No");
	
	/**  El grupo de los radio button. */
	private ButtonGroup grupoRadio = new ButtonGroup();

	/**  Etiqueta apellido. */
	private static JLabel apellidoLabel = new JLabel("Apellidos: ");

    /**  Campo texto para apellido. */
    private static JTextField tvApellido = new JTextField();

	/**  Etiqueta nombre. */
	private static JLabel nombreLabel = new JLabel("Nombre: ");

	/**  Campo texto para nombre. */
	private static JTextField tvNombre = new JTextField();

	/**  Etiqueta dni. */
	private static JLabel dniLabel = new JLabel("DNI: ");

	/**  Campo texto para dni. */
	private static JTextField tvDni = new JTextField();

	/**  Etiqueta telefono. */
	private static JLabel telefonoLabel = new JLabel("Teléfono: ");

	/**  Campo texto para telefono. */
	private static JFormattedTextField tvTelefono = new JFormattedTextField();

    /**  Etiqueta para la fecha entrada. */
    private static JLabel fechaEntradaLabel = new JLabel("Fecha de entrada: ");

	/**  Campo texto para la fecha entrada. */
	private static JTextField tvFechaEntrada = new JTextField();

    /**  Etiqueta fecha salida. */
    private static JLabel fechaSalidaLabel = new JLabel("Fecha de salida: ");

	/**  Campo texto para la fecha salida. */
	private static JTextField tvfechaSalida = new JTextField();

	/**  variable para el formato de las fechas. */
	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**  Etiqueta dias estancia. */
	private static JLabel diasEstanciaLabel = new JLabel("Dias Estancia: ");

	/**  Campo texto para la diferencia de dias. */
	private static JFormattedTextField tvDiasEstancia = new JFormattedTextField();
	
	/**  Etiqueta trabajo. */
	private static JLabel trabajoLabel = new JLabel("¿Viajas por trabajo?: ");



	/**
	 * Clase constructora para crear el panel de datos cliente.
	 */
	public DatosCliente() {
		setBorder(BorderFactory.createLineBorder(Color.decode("#cd6155"),5));
		radioSi.setBackground(Color.decode("#fad7a0"));
		radioNo.setBackground(Color.decode("#fad7a0"));
		setBackground(Color.decode("#fad7a0"));
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 0, 5, 0);

        nombreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		apellidoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dniLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        telefonoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        fechaEntradaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        fechaSalidaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        diasEstanciaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        trabajoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        constraints.weightx = 0;
		agregarComponente(nombreLabel, 0,0, 1, 1);

		constraints.weightx = 1.0;
		agregarComponente(tvNombre, 1, 0, 1, 1);

        constraints.weightx = 0;
		agregarComponente(apellidoLabel, 2,0, 1, 1);

		constraints.weightx = 1.0;
		agregarComponente(tvApellido, 3, 0, 2, 1);

		setFormatoDni();

        constraints.weightx = 0;
		agregarComponente(dniLabel, 0,1, 1, 1);

		constraints.weightx = 1.0;
		agregarComponente(tvDni, 1,1, 1, 1);
		
		
		constraints.weightx = 0;
		agregarComponente(telefonoLabel, 2,1, 1, 1);
		
		constraints.weightx = 1.0;
		agregarComponente(tvTelefono, 3,1, 2, 1);
		
		setFormatoFecha();
		
		constraints.weightx = 0;
		agregarComponente(fechaEntradaLabel, 0,2, 1, 1);
		
		constraints.weightx = 1.0;
		agregarComponente(tvFechaEntrada, 1,2, 1, 1);
		
		constraints.weightx = 0;
		agregarComponente(fechaSalidaLabel, 2,2, 1, 1);
		
		constraints.weightx = 1.0;
		agregarComponente(tvfechaSalida, 3,2, 2, 1);

		constraints.weightx = 0;
		agregarComponente(diasEstanciaLabel, 0, 3, 1, 1);
		
		constraints.weightx = 1.0;
		tvDiasEstancia.setEditable(false);
		agregarComponente(tvDiasEstancia, 1,3, 1, 1);
		
		agregarComponente(trabajoLabel, 2, 3, 1, 1);
		
		agregarComponente(radioSi, 3, 3, 1, 1);
		
		agregarComponente(radioNo, 4, 3, 1, 1);
		
		grupoRadio.add(radioSi);
		radioSi.setToolTipText("Selecciona esta opción si viajas por motivos laborales.");
		radioNo.setToolTipText("Selecciona esta opción si no viajas por motivos laborales.");
		grupoRadio.add(radioNo);
		setFormatoFecha();
		setListeners();
		setTvDias();
		cambiarFuente();
		this.setVisible(true);
	}

	/**
	 * Cambia la fuente de todos los labels.
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
	private void setListeners(){
		tvFechaEntrada.getDocument().addDocumentListener(this);
		tvfechaSalida.getDocument().addDocumentListener(this);
	}

	
	/**
	 * Metodo que se ejecuta cuando se inserta algo en el campo fecha.
	 *
	 * @param e the e
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		setTvDias();
		DatosHabitacion.cambiarImporte();
	}

	/**
	 * Metodo que se ejecuta cuando se elimina algo en el campo fecha.
	 *
	 * @param e the e
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		setTvDias();
		DatosHabitacion.cambiarImporte();
	}

	/**
	 * Metodo que se ejecuta cuando se actualiza un campo fecha.
	 *
	 * @param e the e
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		setTvDias();
		DatosHabitacion.cambiarImporte();
	}
		
	/**
	 * Establece el formato fecha a los campos fecha.
	 */
	private void setFormatoFecha() {
        LocalDate fechaEntrada = LocalDate.now();
		LocalDate fechaSalida = fechaEntrada.plusDays(1);

        tvFechaEntrada.setText(formato.format(fechaEntrada));
		tvfechaSalida.setText(formato.format(fechaSalida));
	}

	/**
	 * Establece el formato dni al tvDni.
	 */
	private void setFormatoDni() {
		MaskFormatter mascaraDni = null;
        try{
            mascaraDni = new MaskFormatter("########U");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
		tvDni = new JFormattedTextField(mascaraDni);
	}

	/**
	 * Obtiene el numero de dias.
	 *
	 * @return the num dias
	 */
	public static long getNumDias(){
        try {
            LocalDate entrada = LocalDate.parse(tvFechaEntrada.getText(), formato);
            LocalDate salida = LocalDate.parse(tvfechaSalida.getText(), formato);
            return ChronoUnit.DAYS.between(entrada, salida);
        } catch (DateTimeParseException e) {
            return 0;
        }
	}

	/**
	 * Agrega componentes al panel.
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
	 * Establece el campo dias.
	 */
	private void setTvDias(){
		Long dias = getNumDias();
		if(dias >= 0){
			tvDiasEstancia.setText(Long.toString(dias));
		}
		
	}

    /**
     * Comprueba los datos si son correctos.
     *
     * @return verdadero si es exitoso
     */
    public boolean comprobarDatos() {
		boolean esCorrecto = true;
    	try {
            LocalDate fechaEntrada = LocalDate.parse(tvFechaEntrada.getText(), formato);
            LocalDate fechaSalida = LocalDate.parse(tvfechaSalida.getText(), formato);
    		if (fechaEntrada.isBefore(LocalDate.now())) {
    		    esCorrecto = false;
    		    JOptionPane.showMessageDialog(null, "La fecha de entrada no puede ser anterior a hoy", "ERROR", JOptionPane.ERROR_MESSAGE);
    		}

    		if (fechaSalida.isBefore(fechaEntrada)) {
    		    esCorrecto = false;
    		    JOptionPane.showMessageDialog(null, "La fecha de salida no puede ser anterior a la fecha de entrada", "ERROR", JOptionPane.ERROR_MESSAGE);
    		}
    	}catch(Exception e) {
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "El formato de la fecha es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
    	}

		if(tvNombre.getText().isEmpty()){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "El nombre introducido no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		if(tvApellido.getText().isEmpty()){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "El apellido introducido no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		if(Integer.parseInt(tvDiasEstancia.getText()) == 0){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "La fecha introducido no es valida", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		if(tvTelefono.getText().isEmpty() && tvTelefono.getText().length() < 9){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "El teléfono introducido no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		if(tvDni.getText().isBlank()){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "El dni introducido no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		if(grupoRadio.getSelection() == null){
			esCorrecto = false;
			JOptionPane.showMessageDialog(null, "Conteste si viaja por motivos de trabajo", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return esCorrecto;
    }

	/**
	 * Obtiene los datos.
	 *
	 * @return los datos
	 */
	public String[] getDatos() {
		String[] datos = {tvNombre.getText(),tvApellido.getText(), tvDni.getText(), tvTelefono.getText(), tvFechaEntrada.getText(), tvfechaSalida.getText(), tvDiasEstancia.getText(),
				(grupoRadio.getSelection() == radioSi) ? "Si" : "No"};
		return datos;
	}

	/**
	 * Reinicia los datos,.
	 */
	public void reiniciarDatos() {
		tvNombre.setText("");
		tvApellido.setText("");
		tvDni.setText("");
		tvTelefono.setText("");
        tvFechaEntrada.setText(formato.format(LocalDate.now()));
		tvfechaSalida.setText(formato.format(LocalDate.now().plusDays(1)));
		tvNombre.requestFocus();
	}
}