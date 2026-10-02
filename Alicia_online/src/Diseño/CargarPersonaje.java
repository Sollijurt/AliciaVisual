package Diseño;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.ChangeListener;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class CargarPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CargarPersonaje() {
		
		setLayout(null);
		setBounds(0, 42, 384, 319);
		
		Mundo mundo  = new Mundo();
		
		JLabel labelAviso = new JLabel("\r\nCARGO EXITOSAMENTE\r\n");
		labelAviso.setForeground(new Color(63, 63, 63));
		labelAviso.setBackground(new Color(176, 196, 222));
		labelAviso.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelAviso.setBounds(29, 237, 277, 68);
		add(labelAviso);
		
		JLabel labelTitulo = new JLabel("Cargar personaje");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelTitulo.setBounds(112, 11, 169, 39);
		add(labelTitulo);
		
		JSpinner spinnerSecreto = new JSpinner();
		spinnerSecreto.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		spinnerSecreto.setBounds(233, 109, 48, 30);
		add(spinnerSecreto);
		
		JSpinner spinnerLocura = new JSpinner();
		spinnerLocura.setModel(new SpinnerNumberModel(0, 0, 1000000000, 1));
		spinnerLocura.setBounds(233, 168, 48, 30);
		add(spinnerLocura);
		
		JSpinner spinnerUbicacion = new JSpinner();
		spinnerUbicacion.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
		spinnerUbicacion.setBounds(233, 237, 48, 30);
		add(spinnerUbicacion);
		
		JLabel labelSecreto = new JLabel("Cantidad secreto");
		labelSecreto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelSecreto.setBounds(99, 111, 124, 22);
		add(labelSecreto);
		
		JLabel labelLocura = new JLabel("Cantidad locura");
		labelLocura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLocura.setBounds(99, 170, 112, 22);
		add(labelLocura);
		
		JLabel labelUbicacion = new JLabel("Ubicación");
		labelUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelUbicacion.setBounds(99, 239, 95, 22);
		add(labelUbicacion);
		
		JLabel labelIngrese = new JLabel("Ingrese lo siguiente");
		labelIngrese.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelIngrese.setBounds(99, 64, 198, 22);
		add(labelIngrese);
		
		JButton botonCargar = new JButton("Cargar");
		botonCargar.setForeground(new Color(0, 128, 128));
		botonCargar.setBackground(new Color(0, 255, 128));
		botonCargar.setBounds(285, 285, 89, 23);
		add(botonCargar);
		
		JButton botonBorrarTodo = new JButton("Borrar todo");
		botonBorrarTodo.setForeground(new Color(255, 128, 128));
		botonBorrarTodo.setBackground(new Color(255, 128, 128));
		botonBorrarTodo.setBounds(186, 285, 89, 23);
		add(botonBorrarTodo);

		botonBorrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spinnerSecreto.setValue(0);
				spinnerLocura.setValue(0);
				spinnerUbicacion.setValue(0);
			}
		});
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personaje pj = new Personaje((int) spinnerLocura.getValue(), (int) spinnerUbicacion.getValue(), (int) spinnerSecreto.getValue());
				mundo.agregarLosPersonajes(pj);
			}
		});
		
	}
}
