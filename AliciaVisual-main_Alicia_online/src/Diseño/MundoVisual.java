package Diseño;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class MundoVisual extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String mensajeProhibicion = "No hay personajes, carge alguno";
	/**
	 * Create the panel.
	 */
	public MundoVisual(Mundo m) {
		setLayout(null);
		
		JLabel labelTitulo = new JLabel("Bienvenido a Mundo");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelTitulo.setBounds(148, 8, 165, 32);
		add(labelTitulo);
		
		JButton botonHayMasLindos = new JButton("¿Hay más lindos?");
		botonHayMasLindos.setBounds(54, 97, 148, 23);
		add(botonHayMasLindos);
		
		JButton botonElMasLoco = new JButton("El más loco");
		botonElMasLoco.setBounds(54, 143, 148, 23);
		add(botonElMasLoco);
		
		JButton botonHayNormal = new JButton("¿Hay un normal?");
		botonHayNormal.setBounds(54, 239, 148, 23);
		add(botonHayNormal);
		
		JLabel labelCantidadPersonaje = new JLabel("Cantidad personajes:");
		labelCantidadPersonaje.setBounds(98, 36, 128, 14);
		add(labelCantidadPersonaje);
		
		JLabel labelContador = new JLabel("New label");
		labelContador.setBounds(236, 36, 89, 14);
		add(labelContador);
		
		JLabel labelCantidadPersonajeM = new JLabel("Cantidad personajes en maravilla:");
		labelCantidadPersonajeM.setBounds(43, 61, 183, 14);
		add(labelCantidadPersonajeM);
		
		JLabel labelContadorM = new JLabel("New label");
		labelContadorM.setBounds(236, 61, 89, 14);
		add(labelContadorM);
		
		JButton botonMostrarPersonajeLindo = new JButton("Mostra lindos");
		botonMostrarPersonajeLindo.setBounds(54, 191, 148, 23);
		add(botonMostrarPersonajeLindo);
		
		botonMostrarPersonajeLindo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogo(mensajeProhibicion);
				}
			}
		});
		
		botonHayMasLindos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogo(mensajeProhibicion);
				}else {
					if(m.masLindosQueNormales()) {
						mostrarDialogo("Hay más lindos");
					}else {
						mostrarDialogo("Hay más normales");
					}
				}
				
			}
		});
		
		botonElMasLoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogo(mensajeProhibicion);
				}else {
					mostrarDialogo("Personaje de ID: " + obtenerID(m.elMasLoco(), m));
				}
				
			}
		});
		botonHayNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogo(mensajeProhibicion);
				}else {
					if(m.hayNormales()) {
						mostrarDialogo("Hay normales");
					}
					else {
						mostrarDialogo("No hay normales");
					}
				}
			}
		});
	}
	private void mostrarDialogo(String n) {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog(parentWindow, "Diálogo desde JPanel", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(parentWindow);

        JLabel labelMensaje = new JLabel(n, SwingConstants.CENTER);
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> dialog.dispose());

        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(labelMensaje, BorderLayout.CENTER);
        dialog.getContentPane().add(botonCerrar, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
	
	public int obtenerID(Personaje p, Mundo m) {
		ArrayList<Personaje> s =  m.getLosPersonajes();
		int i = 0;
		boolean salir = true;
		while(salir) {
			if(s.get(i) == p) {
				salir = false;
			}
			i++;
		}
		return i;
	}
}
