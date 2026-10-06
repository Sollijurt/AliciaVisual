package Diseño;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.SpinnerNumberModel;

public class PersonajeVisual extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PersonajeVisual() {
		setLayout(null);
		
		JLabel labelPersonaje = new JLabel("Bienvenido a personaje");
		labelPersonaje.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelPersonaje.setBounds(92, 23, 219, 30);
		add(labelPersonaje);
		
		JLabel lblNewLabel = new JLabel("Ingrese ID personaje");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(92, 64, 124, 17);
		add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(247, 63, 36, 20);
		add(spinner);

	}
}
