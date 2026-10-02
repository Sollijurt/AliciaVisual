package Logica;
import java.util.ArrayList;

public class Mundo {
	private ArrayList<Personaje> losPersonajes = new ArrayList<>();
	
	public Mundo() {
		
	}
	
	
	public boolean hayNormales(){
		for(Personaje p: losPersonajes) {
			if(p.esNormal()) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList <Personaje> personajesLindos(){
		ArrayList<Personaje> losPersonajesLindos = new ArrayList<>();
		for(Personaje p: losPersonajes) {
			if(p.esLindo() && p.estaEnMaravilla()) {
				losPersonajesLindos.add(p);
			}
		}
		return losPersonajesLindos;
	}
	
	public int cuantosEnMaravilla(){
		int auxiliar = 0;
		for(Personaje p: losPersonajes) {
			if(p.estaEnMaravilla()) {
				auxiliar++;
			}
		}
		return auxiliar;
	}
	
	public Personaje elMasLoco() {
		int auxiliar =0;
		int masLoco = losPersonajes.get(0).getLocura();
		for(int i = 0; i < losPersonajes.size(); i++) {
			if(losPersonajes.get(i).getLocura() > masLoco) {
				auxiliar = i;
				masLoco = losPersonajes.get(auxiliar).getLocura();
			}
		}
		return losPersonajes.get(auxiliar);
	}
	
	public boolean masLindosQueNormales()
	{
		int cantidadLindos = 0;
		int cantidadNormales = 0;
		for(Personaje p: losPersonajes) {
			if(p.esNormal()) {
				cantidadNormales++;
			}
			if(p.esLindo()) {
				cantidadLindos++;
			}
		}
		if(cantidadLindos > cantidadNormales) {
			return true;
		}else {
			return false;
		}
	}
	
	public void agregarLosPersonajes(Personaje personaje) {
		losPersonajes.add(personaje);
	}
	
	public ArrayList<Personaje> getLosPersonajes(){
		return losPersonajes;
	}
}
