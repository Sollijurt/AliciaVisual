package Diseño;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
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
import javax.swing.JList;
import javax.swing.JTextArea;

public class MundoVisual extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String mensajeProhibicion = "No hay personajes, carge alguno";
	private DefaultListModel<String> modeloLista;
	private Mundo m;
	
	// labels
	JLabel labelTitulo;
	JLabel labelCantidadPersonaje;
	JLabel labelContador;
	JLabel labelCantidadPersonajeM;
	JLabel labelContadorM ;
	
	// botones
	JButton botonHayMasLindos;
	JButton botonElMasLoco;
	JButton botonHayNormal;
	JButton botonMostrarPersonajeLindo;
	
	// JDialog
	JDialog dialog;
	public MundoVisual(Mundo m) {
		this.m = m;
		setLayout(null);
		
		crearLabels();
		crearBotones();
		
		accionesBotones();

		cambiarNumeroHabitantes();
		validate();
	}
	
	public void crearLista() {
		crearJDialogo();
		JList<String> list;
		
		modeloLista = new DefaultListModel<>();
		list = new JList<>(modeloLista);
		list.setVisibleRowCount(8);
		JScrollPane scrollPane = new JScrollPane(list);
		cargarLista();
		dialog.getContentPane().add(scrollPane, BorderLayout.CENTER);
		dialog.setVisible(true);
	}
	
	private void mostrarDialogoExitoso(String n) {
		crearJDialogo();
		
        JLabel labelMensaje = new JLabel(n, SwingConstants.CENTER);
        dialog.getContentPane().add(labelMensaje, BorderLayout.CENTER);
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
	
	public void cargarLista() {
		
		ArrayList<String> nombres = new ArrayList<>();
		ArrayList<Integer> numeros = m.numeroPersonajesLindos();
		
        for(int i = 0; i < numeros.size(); i++) {
        	nombres.add(String.valueOf(numeros.get(i)));
        }
        modeloLista.clear();
        for (String item : nombres) {
            modeloLista.addElement(item);
        }
	}
	
	public void crearLabels() {
		labelTitulo = new JLabel("Bienvenido a Mundo");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelTitulo.setBounds(148, 8, 165, 32);
		add(labelTitulo);
		
		labelCantidadPersonaje = new JLabel("Cantidad personajes:");
		labelCantidadPersonaje.setBounds(98, 36, 128, 14);
		add(labelCantidadPersonaje);
		
		labelContador = new JLabel("0");
		labelContador.setBounds(236, 36, 89, 14);
		add(labelContador);
		
		labelCantidadPersonajeM = new JLabel("Cantidad personajes en maravilla:");
		labelCantidadPersonajeM.setBounds(43, 61, 183, 14);
		add(labelCantidadPersonajeM);
		
		labelContadorM = new JLabel("0");
		labelContadorM.setBounds(236, 61, 89, 14);
		add(labelContadorM);
	}
	
	public void cambiarNumeroHabitantes() {
		labelContadorM.setText(String.valueOf(m.cuantosEnMaravilla()));
		labelContador.setText(String.valueOf(m.obtenerCantidaLogica()));
	}
	
	public void crearBotones() {
		botonHayMasLindos = new JButton("¿Hay más lindos?");
		botonHayMasLindos.setBounds(54, 97, 148, 23);
		add(botonHayMasLindos);
		
		botonElMasLoco = new JButton("El más loco");
		botonElMasLoco.setBounds(54, 143, 148, 23);
		add(botonElMasLoco);
		
		botonHayNormal = new JButton("¿Hay un normal?");
		botonHayNormal.setBounds(54, 239, 148, 23);
		add(botonHayNormal);
		
		botonMostrarPersonajeLindo = new JButton("Mostra lindos");
		botonMostrarPersonajeLindo.setBounds(54, 191, 148, 23);
		add(botonMostrarPersonajeLindo);
	}
	
	public void accionesBotones() {
		botonMostrarPersonajeLindo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.obtenerCantidaLogica() == 0) {
					mostrarDialogoExitoso(mensajeProhibicion);
				}else {
					crearLista();
				}
			}
		});
		
		botonHayMasLindos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogoExitoso(mensajeProhibicion);
				}else {
					if(m.masLindosQueNormales()) {
						mostrarDialogoExitoso("Hay más lindos");
					}else {
						mostrarDialogoExitoso("Hay más normales");
					}
				}
				
			}
		});
		
		botonElMasLoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogoExitoso(mensajeProhibicion);
				}else {
					mostrarDialogoExitoso("Personaje de ID: " + obtenerID(m.elMasLoco(), m));
				}
				
			}
		});
		botonHayNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.getLosPersonajes().size() == 0) {
					mostrarDialogoExitoso(mensajeProhibicion);
				}else {
					if(m.hayNormales()) {
						mostrarDialogoExitoso("Hay normales");
					}
					else {
						mostrarDialogoExitoso("No hay normales");
					}
				}
			}
		});
	}
	
	public void crearJDialogo() {
		Window parentWindow = SwingUtilities.getWindowAncestor(this);
		dialog = new JDialog(parentWindow, "Diálogo desde JPanel", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(parentWindow);
        dialog.getContentPane().setLayout(new BorderLayout());
        
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> dialog.dispose());
        dialog.getContentPane().add(botonCerrar, BorderLayout.SOUTH);
	}
}
