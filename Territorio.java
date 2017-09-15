package juego_2112;

import javax.swing.JButton;

public class Territorio {

	int posicion;
	String nombre;
	int jugador; // 1, 2, 3 o 4
	int soldados; //soldados presentes en el territorio
	JButton boton;
	
	int [] colindantes; // territorios que hacen frontera con éste
	
	protected Territorio(){
		
	}
	
	protected Territorio(int posicion, String nombre, int jugador, int [] colindantes, JButton boton) {
		
		this.posicion = posicion;
		this.nombre = nombre;
		this.jugador = jugador;
		this.soldados = 1;
		this.colindantes = colindantes;
		this.boton = boton;
		
	}

	protected int getPosicion() {
		return posicion;
	}

	protected void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected int getJugador() {
		return jugador;
	}

	protected void setJugador(int jugador) {
		this.jugador = jugador;
	}

	protected int getSoldados() {
		return soldados;
	}

	protected void setSoldados(int soldados) {
		this.soldados = soldados;
	}


	protected int[] getColindantes() {
		return colindantes;
	}

	protected void setColindantes(int[] colindantes) {
		this.colindantes = colindantes;
	}

	protected JButton getBoton() {
		return boton;
	}

	protected void setBoton(JButton boton) {
		this.boton = boton;
	}

	@Override
	public String toString() {
		return "Territorio [posicion=" + posicion + ", nombre=" + nombre
				+ ", jugador=" + jugador + ", soldados=" + soldados
				+ ", colindantes=" + colindantes + "]";
	}
	
	
	
}

