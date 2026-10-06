package Diseño;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu() {
		setBounds(0, 0, 384, 324);
		setLayout(null);
		
		
		JButton botonMostrarTodo = new JButton("Mostrar todo\r\n");
		botonMostrarTodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonMostrarTodo.setBounds(124, 222, 145, 23);
		add(botonMostrarTodo);
		
		JLabel labelPregunta = new JLabel("¿Que quieres hacer?");
		labelPregunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPregunta.setBounds(131, 99, 124, 23);
		add(labelPregunta);
		
		JButton botonAtajoPersonaje = new JButton("Crear personaje\r\n");
		botonAtajoPersonaje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonAtajoPersonaje.setBounds(124, 159, 145, 23);
		add(botonAtajoPersonaje);
		
		JLabel labelTitulo = new JLabel("Bienvenido al programa de Alicia");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelTitulo.setBounds(61, 27, 270, 61);
		add(labelTitulo);
		
		botonAtajoPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}

}
