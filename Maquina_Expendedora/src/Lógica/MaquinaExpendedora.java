package Lógica;
import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaExpendedora {
	
	private Cargador empleado = new Cargador();
	private Scanner lectura = new Scanner(System.in);
	private ArrayList<Producto> maquina = empleado.cargarProductos();	
	
	public MaquinaExpendedora() {
		cargarMaquina();
	}
	
	public void cargarMaquina() {
		maquina = empleado.cargarProductos();
	}
	
	public int mostrarCantidadSanguches() {
		int contadorSanguches = 0;

		for(Producto p: maquina) {
			if(p.getCodigo().charAt(0) == 'A') {
				contadorSanguches++;
			}
 		}
		
		return contadorSanguches;
	}
	
	public int mostrarCantidadBebidas() {
		int contador = 0;

		for(Producto p: maquina) {
			if(p.getCodigo().charAt(0) == 'B') {
				contador++;
			}
 		}
		
		return contador;
	}
	
	public int mostrarCantidadGolosinas() {
		int contador = 0;

		for(Producto p: maquina) {
			if(p.getCodigo().charAt(0) == 'C') {
				contador++;
			}
 		}
		
		return contador;
	}
	
	public int mostrarCantidadSaludables() {
		int contador = 0;

		for(Producto p: maquina) {
			if(p.getCodigo().charAt(0) == 'D') {
				contador++;
			}
 		}
		
		return contador;
	}
	public void verCualquierTipo(TipoProducto aux) {
		for(Producto p: maquina) {
			if(p.getTipo() == aux) {
				System.out.println(p.getCodigo() + " | " + p.getNombre());
			}
		}
		esperar();
		espacioEnBlanco();
	}
	
	
	public void esperar() {
		boolean salir = false;
		System.out.println("Aprete 1 para volver");
		int opcion = lectura.nextInt();
		do {
			if(opcion == 1) {
				salir = true;
			}
			else {
				System.out.println("Error, valor fuera de rango");
				salir = true;
			}
		}while(!salir);
	}
	
	public void espacioEnBlanco() {
		for(int i = 0; i < 20; i++) {
			System.out.println("");
		}
		
	}
	
	
	public void comprar() {
		boolean salir = false;
		Producto auxiliar = null;
		do {
			System.out.println("Ingrese el código del producto (ejem. A3)");
			lectura.nextLine(); //Limpiar el buffer
			String codigoProducto = lectura.nextLine();
			
			for(Producto p: maquina) {
				if(p.getCodigo().equals(codigoProducto) && p.getUnidades() != 0) {
					System.out.println(p.getNombre() + " | " + p.getLeyenda());
					auxiliar = p;
				}
			}
			
			
			if(auxiliar != null) {
					System.out.println("Elija una opcion");
					System.out.println("1) Comprar");
					System.out.println("2) Volver");
					
					int opcion = lectura.nextInt();
						
					switch(opcion) {
					case 1:
							pagar(auxiliar);
							salir = true;
							break;
						case 2:
							salir = true;
							break;
						default:
							System.out.println("Error, fuera de rango");
							esperar();
							break;
						}
				}
				if(auxiliar == null){
					System.out.println("No hay un objeto con el mismo codigo");
					salir = true;
					esperar();
					espacioEnBlanco();
				}
			
			
			
			
			
		}while(!salir);	
	}
	
	public void pagar(Producto auxiliar) {
		System.out.println("---------------Compra----------------------------");
		System.out.println(auxiliar.getNombre() + " | " + auxiliar.getPrecio());
		System.out.println("Ingrese el dinero");
		int dinero = lectura.nextInt();
		
		
		if(dinero == auxiliar.getPrecio()) {
			System.out.println("Disfrute su producto");
			auxiliar.disminuirCantidad();
			esperar();
		}
		if(dinero > auxiliar.getPrecio()) {
			int cambio = dinero - auxiliar.getPrecio();
			System.out.println("Aca esta su vuelto " + cambio);
			auxiliar.disminuirCantidad();
			esperar();
		}
		if(dinero < auxiliar.getPrecio() && dinero >0) {
			System.out.println("No tiene suficiente dinero, pobre");
			esperar();
		}
		if(dinero < 0) {
			System.out.println("NO INGRESE DINERO NEGATIVO");
			esperar();
		}
		
	}
	
	public void paraQueMeAlcanza() {
		boolean salir = false;
		do {
			System.out.println("Ingrese la cantidad de dinero que quiera gastar");
			int dinero = lectura.nextInt();
			ArrayList<Producto> comprables = new ArrayList<>();
			
			for(Producto p: maquina) {
				if(p.getPrecio() == dinero && p.getUnidades() > 0) {
					System.out.println(p.getCodigo() + " | " + p.getNombre());
					comprables.add(p);
				}
			}
			if(comprables.size() > 0) {
				System.out.println("Elija una opcion");
				System.out.println("1) Comprar");
				System.out.println("2) volver");

				int opcion = lectura.nextInt();
				
				switch(opcion) {
				case 1:
					comprar();
					salir = true;
					break;
				case 2:
					salir = true;
					break;
				default:
					System.out.println("Error, fuera de rango");
					break;
				}
			}
			else {
				System.out.println("No hay elementos con ese precio");
				esperar();
				salir = true;
			}
		}while(!salir);
	}
	

}
