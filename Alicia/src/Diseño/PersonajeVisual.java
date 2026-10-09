package Diseño;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Logica.Mundo;
import Logica.Personaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PersonajeVisual extends JPanel {

	private static final long serialVersionUID = 1L;

	JSpinner spinner;
	
	JLabel labelPersonaje;
	JLabel labelIngreseId;
	
	JButton botonBuscar;
	
	JDialog dialog;
	
	Mundo m;
	public PersonajeVisual(Mundo m) {
		this.m = m;
		setLayout(null);
		
		crearLabels();
		crearSpinner();
		crearBotones();
		
		actualizarRangoSpinner();
		
		
		accionesBotones();
		
		validate();
	}
	private void crearLabels() {
		labelPersonaje = new JLabel("Bienvenido a personaje");
		labelPersonaje.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelPersonaje.setBounds(92, 23, 219, 30);
		add(labelPersonaje);
		
		labelIngreseId = new JLabel("Ingrese ID personaje");
		labelIngreseId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelIngreseId.setBounds(50, 128, 144, 35);
		add(labelIngreseId);
	}
	
	private void crearSpinner() {
		spinner = new JSpinner();
		
		spinner.setModel(new SpinnerNumberModel(1, 1, 23, 1));
		spinner.setBounds(231, 128, 61, 37);
		add(spinner);
	}
	
	private void crearBotones() {
		botonBuscar = new JButton();
		botonBuscar.setText("Buscar");
		botonBuscar.setBounds(142, 210, 95, 27);
		add(botonBuscar);
	}
	
	private void accionesBotones() {
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int) spinner.getValue() - 1;
				if(m.getLosPersonajes().size() > 0) {
					mostrarDialogo(n);
				}
				else {
					mostrarDialogoExitoso();
				}
				
			}
		});
	}
	
	private void crearDialogo() {
		Window parentWindow = SwingUtilities.getWindowAncestor(this);
		dialog = new JDialog(parentWindow, "Diálogo desde JPanel", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(parentWindow);
        dialog.getContentPane().setLayout(new BorderLayout());
        
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> dialog.dispose());
        dialog.getContentPane().add(botonCerrar, BorderLayout.SOUTH);
	}
	
	private void mostrarDialogo(int n) {
		crearDialogo(); 
	    Personaje p = buscarPersonaje(n);
	    
	    JPanel panelContenedorLabels = new JPanel();
	    panelContenedorLabels.setLayout(new BoxLayout(panelContenedorLabels, BoxLayout.Y_AXIS));
		
		JLabel labelSecreto = new JLabel("Secreto: " + p.getSecreto());
		JLabel labelUbicacion = new JLabel("Ubicación: " + p.getUbicacion());
		JLabel labelLocura = new JLabel("Locura: " + p.getLocura());
	    
	 
	    labelSecreto.setAlignmentX(Component.CENTER_ALIGNMENT);
	    labelUbicacion.setAlignmentX(Component.CENTER_ALIGNMENT);
	    labelLocura.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    panelContenedorLabels.add(Box.createVerticalGlue()); 
	    panelContenedorLabels.add(labelLocura);
	    panelContenedorLabels.add(Box.createVerticalStrut(10)); 
	    panelContenedorLabels.add(labelUbicacion);
	    panelContenedorLabels.add(Box.createVerticalStrut(10)); 
	    panelContenedorLabels.add(labelSecreto);
	    panelContenedorLabels.add(Box.createVerticalGlue()); 
	    
	    dialog.getContentPane().add(panelContenedorLabels, BorderLayout.CENTER);
	    

	    dialog.revalidate();
	    dialog.repaint();
	    dialog.setVisible(true);
	}
	
	private Personaje buscarPersonaje(int n) {
		Personaje p;
		p = m.getLosPersonajes().get(n);
		
		return p;
	}
	
	private void mostrarDialogoExitoso() {
		crearDialogo();
		
        JLabel labelMensaje = new JLabel("No hay ningun personaje", SwingConstants.CENTER);
        dialog.getContentPane().add(labelMensaje, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
	public void actualizarRangoSpinner() {
	    int total = m.getLosPersonajes().size();
	    if (total > 0) {
	        spinner.setModel(new SpinnerNumberModel(1, 1, total, 1));
	    } else {

	        spinner.setModel(new SpinnerNumberModel(1, 1, 1, 1));
	    }
	}
}
