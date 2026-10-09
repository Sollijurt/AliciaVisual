package Diseño;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.event.ChangeListener;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CargarPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton botonBorrarTodo;
	private JButton botonCargar;
	
	private JSpinner spinnerSecreto;
	private JSpinner spinnerLocura;
	private JSpinner spinnerUbicacion;
	
	private JLabel labelTitulo;
	private JLabel labelLocura;
	private JLabel labelSecreto;
	private JLabel labelUbicacion;
	private JLabel labelIngrese;
	
	Mundo m = new Mundo();
	public CargarPersonaje(Mundo m) {
		this.m = m;
		setLayout(null);
		setBounds(0, 42, 384, 319);
		
		
		crearBotones();
		crearLabel();
		crearSpinner();
		
		usosBotones();
		
	}
	private void mostrarDialogo() {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog(parentWindow, "Diálogo desde JPanel", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(parentWindow);

        JLabel lblMensaje = new JLabel("Cargado exitosamente", SwingConstants.CENTER);
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());

        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(lblMensaje, BorderLayout.CENTER);
        dialog.getContentPane().add(btnCerrar, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
	
	private void crearBotones() {
		botonCargar = new JButton("Cargar");
		botonCargar.setForeground(new Color(0, 128, 128));
		botonCargar.setBackground(new Color(0, 255, 128));
		botonCargar.setBounds(285, 285, 89, 23);
		add(botonCargar);
		
		botonBorrarTodo = new JButton("Borrar todo");
		botonBorrarTodo.setForeground(new Color(255, 128, 128));
		botonBorrarTodo.setBackground(new Color(255, 0, 128));
		botonBorrarTodo.setBounds(186, 285, 89, 23);
		add(botonBorrarTodo);
	}
	
	private void crearLabel() {
		labelTitulo = new JLabel("Cargar personaje");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelTitulo.setBounds(112, 11, 169, 39);
		add(labelTitulo);
		
		labelSecreto = new JLabel("Cantidad secreto");
		labelSecreto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelSecreto.setBounds(99, 111, 124, 22);
		add(labelSecreto);
		
		labelLocura = new JLabel("Cantidad locura");
		labelLocura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLocura.setBounds(99, 170, 112, 22);
		add(labelLocura);
		
		labelUbicacion = new JLabel("Ubicación");
		labelUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelUbicacion.setBounds(99, 239, 95, 22);
		add(labelUbicacion);
		
		labelIngrese = new JLabel("Ingrese lo siguiente");
		labelIngrese.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelIngrese.setBounds(99, 64, 198, 22);
		add(labelIngrese);
	}
	
	private void crearSpinner() {
		spinnerSecreto = new JSpinner();
		spinnerSecreto.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		spinnerSecreto.setBounds(233, 109, 48, 30);
		add(spinnerSecreto);
		
		spinnerLocura = new JSpinner();
		spinnerLocura.setModel(new SpinnerNumberModel(0, 0, 1000000000, 1));
		spinnerLocura.setBounds(233, 168, 48, 30);
		add(spinnerLocura);
		
		spinnerUbicacion = new JSpinner();
		spinnerUbicacion.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
		spinnerUbicacion.setBounds(233, 237, 48, 30);
		add(spinnerUbicacion);
	}
	
	private void usosBotones() {
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
				m.agregarLosPersonajes(pj);
				
				 mostrarDialogo();
			}
		});
	}
}
