package Visual;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import Lógica.MaquinaExpendedora;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private MaquinaExpendedora maquina = new MaquinaExpendedora();
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
	
	private Menu menu = new Menu(maquina);
	private VerTipos tipos= new VerTipos();
	private Comprar comprar = new Comprar();
	private ParaQueMeAlcanza alcanza = new ParaQueMeAlcanza();
	
	private JButton botonMenu;
	private JButton botonVerAlimentos;
	private JButton botonComprar;
	private JButton botonPaQueAlcanza;
	
	private JToolBar toolBar = new JToolBar();
	
	private CardLayout cl = new CardLayout();
	
	public Principal() {
		//--------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 400, 400);
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		System.out.println(maquina.mostrarCantidadSanguches() +"");
		
		cargarBarraTareas();
		cargarBotones();
		usosBotones();
		
		
		panel.setBounds(0, 38, 384, 323);
		contentPane.add(panel);
		panel.setLayout(cl);
		panel.add(menu, "Menu");
		panel.add(tipos, "Tipos");
		panel.add(comprar, "Comprar");
		panel.add(alcanza, "Alcanza");
		
		cl.show(panel, "Menu");
		
		setContentPane(contentPane);
		// Acciones
		
	}
	
	private void cargarBotones() {
		botonMenu = new JButton("Menu");
		toolBar.add(botonMenu);
		
		botonVerAlimentos = new JButton("Ver tipos");
		toolBar.add(botonVerAlimentos);
		
		botonComprar = new JButton("Comprar");
		toolBar.add(botonComprar);
		
		botonPaQueAlcanza = new JButton("Pa' que me alcanza");
		toolBar.add(botonPaQueAlcanza);
	}
	
	private void cargarBarraTareas() {
		toolBar.setBounds(0, 0, 384, 41);
		contentPane.add(toolBar);
	}
	
	private void usosBotones() {
		botonPaQueAlcanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Alcanza");
			}
		});
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Menu");
			}
		});
		
		botonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Comprar");
			}
		});
		botonVerAlimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel, "Tipos");
			}
		});
		
	}

}
