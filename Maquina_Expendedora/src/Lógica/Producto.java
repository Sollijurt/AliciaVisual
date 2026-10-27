package Lógica;

public class Producto {
	private String codigo;
	private String nombre;
	private String leyenda;
	private int precio;
	private int unidades;
	private TipoProducto tipo;
	
	public Producto(String codigo, String nombre, String leyenda, int precio, int unidades) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.leyenda = leyenda;
		this.precio = precio;
		this.unidades = unidades;
	}
	public void disminuirCantidad() {
		unidades--;
	}
	
	public TipoProducto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getLeyenda() {
		return leyenda;
	}


	public int getPrecio() {
		return precio;
	}


	public int getUnidades() {
		return unidades;
	}


}
