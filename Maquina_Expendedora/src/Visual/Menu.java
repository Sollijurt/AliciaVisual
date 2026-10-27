package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Lógica.MaquinaExpendedora;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MaquinaExpendedora maquina;
	
	private JLabel labelPregunta;
	private JLabel labelTitulo;
	private JLabel labelSanguche;
	private JLabel labelBebida;
	private JLabel labelGolosina;
	private JLabel labelSaludable;
	private JLabel labelCantidadS;
	private JLabel labelCantidadB;
	private JLabel labelCantidadG ;
	private JLabel labelCantidadSA;
	
	
	public Menu(MaquinaExpendedora maquina) {
		this.maquina = maquina;
		setLayout(null);
		setBounds(0, 0, 384, 324);
		crearLabels();
		
		
	}
	
	private void crearLabels() {
		
		labelTitulo = new JLabel("Bienvenido al programa de La MáQUina");
		labelTitulo.setBounds(35, 27, 328, 61);
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(labelTitulo);
		
		labelPregunta = new JLabel("Cantidades");
		labelPregunta.setBounds(60, 99, 85, 23);
		labelPregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelPregunta);
		
		labelSanguche = new JLabel("Sanguches: ");
		labelSanguche.setBounds(81, 133, 97, 23);
		labelSanguche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelSanguche);
		
		labelBebida = new JLabel("Bebidas:");
		labelBebida.setBounds(81, 167, 60, 23);
		labelBebida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelBebida);
		
		labelGolosina = new JLabel("Golosinas:");
		labelGolosina.setBounds(81, 208, 74, 23);
		labelGolosina.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelGolosina);
		
		labelSaludable = new JLabel("Saludables:");
		labelSaludable.setBounds(81, 242, 85, 23);
		labelSaludable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelSaludable);
		
		labelCantidadS = new JLabel(maquina.mostrarCantidadSanguches() + "");
		labelCantidadS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCantidadS.setBounds(177, 133, 97, 23);
		add(labelCantidadS);
		labelCantidadB = new JLabel(maquina.mostrarCantidadBebidas() + "");
		labelCantidadB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCantidadB.setBounds(177, 167, 97, 23);
		add(labelCantidadB);
		
		labelCantidadG = new JLabel(maquina.mostrarCantidadGolosinas() + "");
		labelCantidadG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCantidadG.setBounds(177, 208, 97, 23);
		add(labelCantidadG);
		
		labelCantidadSA = new JLabel(maquina.mostrarCantidadSaludables() + "");
		labelCantidadSA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCantidadSA.setBounds(176, 242, 97, 23);
		add(labelCantidadSA);
	}
	
}
