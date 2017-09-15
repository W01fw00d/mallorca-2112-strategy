package juego_2112;

public class Jugador {

	int id; // 1 , 2, 3 o 4 ; el numero que le identifica
	String nombre;
	String grupo;
	int territorios;  // territorios que controla
	Boolean humano; // true si es un jugador humano, false si se trata de una IA
	Boolean vivo;  // false si está fuera de juego
	
	protected Jugador(){
		
	}
	
	protected Jugador(int id, String nombre, String grupo, int territorios,
			Boolean humano, Boolean vivo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grupo = grupo;
		this.territorios = territorios;
		this.humano = humano;
		this.vivo = vivo;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getGrupo() {
		return grupo;
	}

	protected void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	protected int getTerritorios() {
		return territorios;
	}

	protected void setTerritorios(int territorios) {
		this.territorios = territorios;
	}

	protected Boolean getHumano() {
		return humano;
	}

	protected void setHumano(Boolean humano) {
		this.humano = humano;
	}

	protected Boolean getVivo() {
		return vivo;
	}

	protected void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}
	
	
	
}
