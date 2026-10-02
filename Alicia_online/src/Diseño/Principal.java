package Diseño;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {

		
		//--------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		CardLayout cl = new CardLayout();
		contentPane.setLayout(null);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 384, 323);
		contentPane.add(panel);
		panel.setLayout(cl);
		PersonajeVisual personajeVisua = new PersonajeVisual();
		CargarPersonaje cargarPJ = new CargarPersonaje();
		MundoVisual mundoVer = new MundoVisual();
		Menu menu = new Menu();
		panel.add(mundoVer, "Mundo");
		panel.add(cargarPJ, "cargarPJ");
		panel.add(personajeVisua, "personajeVisual");
		panel.add(menu, "menu");
		
		cl.show(panel, "menu");
		
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 384, 41);
		contentPane.add(toolBar);
		
		JButton botonPersonaje = new JButton("Personaje");
		toolBar.add(botonPersonaje);
		
		JButton botonMundo = new JButton("Mundo");
		toolBar.add(botonMundo);
		
		JButton botonCargarPersonaje = new JButton("Cargar personaje");
		toolBar.add(botonCargarPersonaje);
		
		
		
		botonCargarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "cargarPJ");
			}
		});
		
		
		
		
		// Acciones
		
	}
}
