package Diseño;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Mundo;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Mundo mundo = new Mundo();
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

	private JPanel panel = new JPanel();
	
	private PersonajeVisual personajeVisua = new PersonajeVisual(mundo);
	private CargarPersonaje cargarPJ = new CargarPersonaje(mundo);
	private MundoVisual mundoVer = new MundoVisual(mundo);
	private Menu menu = new Menu();
	
	private JButton botonMenu;
	private JButton botonPersonaje;
	private JButton botonMundo;
	private JButton botonCargarPersonaje;
	
	private JToolBar toolBar = new JToolBar();
	
	private CardLayout cl = new CardLayout();
	
	public Principal() {

		
		//--------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 400, 400);
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		
		cargarBarraTareas();
		cargarBotones();
		usosBotones();
		
		
		panel.setBounds(0, 38, 384, 323);
		contentPane.add(panel);
		panel.setLayout(cl);
		panel.add(mundoVer, "Mundo");
		panel.add(cargarPJ, "CargarPJ");
		panel.add(personajeVisua, "PersonajeVisual");
		panel.add(menu, "Menu");
		
		cl.show(panel, "Menu");
		
		setContentPane(contentPane);
		// Acciones
		
	}
	
	private void cargarBotones() {
		botonMenu = new JButton("Menu");
		toolBar.add(botonMenu);
		
		botonPersonaje = new JButton("Personaje");
		toolBar.add(botonPersonaje);
		
		botonMundo = new JButton("Mundo");
		toolBar.add(botonMundo);
		
		botonCargarPersonaje = new JButton("Cargar personaje");
		toolBar.add(botonCargarPersonaje);
	}
	
	private void cargarBarraTareas() {
		toolBar.setBounds(0, 0, 384, 41);
		contentPane.add(toolBar);
	}
	
	private void usosBotones() {
		botonCargarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "CargarPJ");
			}
		});
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Menu");
			}
		});
		
		botonMundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Mundo");
			}
		});
		botonPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "PersonajeVisual");
			}
		});
		
	}
}
