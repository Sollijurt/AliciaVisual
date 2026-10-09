package Logica;
public class Personaje {
	private int locura;
	private int ubicacion;
	private int secreto;
	private static final int MAXIMO_LOCURA = 100;
	
	public Personaje(int locura, int ubicacion, int secreto) {
		this.locura = locura;
		this.ubicacion = ubicacion;
		this.secreto = secreto;
	}
	
	public Personaje() {

	}
	
	public void embellecer(int locuraAnadida) {
		locura += locuraAnadida;
		if(secreto - 10 < 0) {
			secreto = 0;
		}else {
			secreto -= 10;
		}
		
	}
	
	public boolean estaEnMaravilla() {
		if(ubicacion < 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esLindo() {
		if(locura > (MAXIMO_LOCURA * 0.75) && estaEnMaravilla()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esNormal() {
		if(locura < 10 && secreto >= 500) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setLocura(int locura) {
		this.locura = locura;
	}
	
	public int getLocura() {
		return locura;
	}
	
	public void setSecreto(int secreto) {
		this.secreto = secreto;
	}
	
	public int getSecreto() {
		return secreto;
	}
	
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public int getUbicacion() {
		return ubicacion;
	}

	public void setEdad(int value) {
		// TODO Auto-generated method stub
		
	}
	
}
