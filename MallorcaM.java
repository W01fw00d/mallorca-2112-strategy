package juego_2112;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Modelo

public class MallorcaM {
	
	
	static String nombre_bandera = "";
	static String ejercito_desc = "";
	
	int [] dados_atacante = {0, 0, 0, 1}; // {dado 1, dado 2, dado 3, numero de dados en juego}
	int [] dados_defensor = {0, 0, 0, 1};
	int muertes_atacante;

	protected static Territorio atacante;
	protected static Territorio defensor;

	protected static Jugador [] jugadores = {
		(new Jugador(0, "Llonguet", "Dictadura del Llonguet", 8, true, true )), 
		(new Jugador(1, "Miriam IV", "The Kingdom of Balconia ", 8, true, true )), 
		(new Jugador(2, "Alten", "Beer Republic", 8, true, true )),
		(new Jugador(3, "Tomeu", "Comuna de Pagesia", 8, true, true ))
	};
	
	protected static Jugador ganador = new Jugador(0, "Llonguet", "Dictadura del Llonguet", 8, true, true);

	protected static Territorio [] territorios= {
		(new Territorio(0, "Andratx", 0, new int[]{1, 2}, MallorcaV.button1)), 
		(new Territorio(1, "Banyalbufar", 0, new int[]{0, 2, 3, 8}, MallorcaV.button2)),
		(new Territorio(2, "Calvià", 0, new int[]{0, 1, 3}, MallorcaV.button3)),
		(new Territorio(3, "Ciutat", 0, new int[]{1, 2, 4, 6, 8, 16}, MallorcaV.button4)),
		(new Territorio(4, "Bunyola", 0, new int[]{3, 5, 6, 7, 8, 9}, MallorcaV.button5)),
		(new Territorio(5, "Sant Alaró", 0, new int[]{4, 7, 10}, MallorcaV.button6)),
		(new Territorio(6, "Marratxí", 0, new int[]{3, 4, 7, 16}, MallorcaV.button7)),
		(new Territorio(7, "Biniconsell", 0, new int[]{4, 5, 6, 10, 15, 17}, MallorcaV.button8)),
		(new Territorio(8, "Valldemossa", 1, new int[]{1, 3, 4, 9}, MallorcaV.button9)),
		(new Territorio(9, "Sóller", 1, new int[]{8, 4, 10}, MallorcaV.button10)),
		(new Territorio(10, "Fornacor", 1, new int[]{5, 9, 11, 14}, MallorcaV.button11)),
		(new Territorio(11, "Escorca", 1, new int[]{10, 12, 14}, MallorcaV.button12)),
		(new Territorio(12, "Pollença", 1, new int[]{11, 13, 14}, MallorcaV.button13)),
		(new Territorio(13, "Alcúdia", 1, new int[]{12, 24}, MallorcaV.button14)),
		(new Territorio(14, "Selvanet", 1, new int[]{10, 11, 12, 15, 24}, MallorcaV.button15)),
		(new Territorio(15, "Inca", 1, new int[]{7, 10, 14, 17, 18, 24}, MallorcaV.button16)),
		(new Territorio(16, "Palma", 2, new int[]{3, 6, 17, 19, 20}, MallorcaV.button17)),
		(new Territorio(17, "Sencelles", 2, new int[]{7, 15, 16, 20, 22}, MallorcaV.button18)),
		(new Territorio(18, "Llubí", 2, new int[]{15, 22, 23, 24}, MallorcaV.button19)),
		(new Territorio(19, "Llucmajor", 2, new int[]{16, 20, 21, 22, 30, 31}, MallorcaV.button20)),
		(new Territorio(20, "Algaida", 2, new int[]{16, 17, 19, 22}, MallorcaV.button21)),
		(new Territorio(21, "Porreres", 2, new int[]{19, 22, 29, 30}, MallorcaV.button22)),
		(new Territorio(22, "Petraneu", 2, new int[]{17, 18, 19, 20, 21, 23, 29}, MallorcaV.button23)),
		(new Territorio(23, "Mariany", 2, new int[]{18, 22, 25, 29}, MallorcaV.button24)),
		(new Territorio(24, "Es Muro", 3, new int[]{13, 14, 15, 18, 25}, MallorcaV.button25)),
		(new Territorio(25, "Margalida", 3, new int[]{23, 24, 26, 29}, MallorcaV.button26)),
		(new Territorio(26, "Artà", 3, new int[]{25, 27, 28, 29}, MallorcaV.button27)),
		(new Territorio(27, "Capdepera", 3, new int[]{26, 28}, MallorcaV.button28)),
		(new Territorio(28, "Son Servera", 3, new int[]{26, 27, 29}, MallorcaV.button29)),
		(new Territorio(29, "Manacor", 3, new int[]{21, 22, 23, 25, 26, 28, 30}, MallorcaV.button30)),
		(new Territorio(30, "Es Campos", 3, new int[]{19, 21, 29, 31}, MallorcaV.button31)),
		(new Territorio(31, "Cabrera", 3, new int[]{19, 30}, MallorcaV.button32))
	};

	
	public void faseRefuerzos(int indice_boton){

		territorios[indice_boton].getBoton().setText(Integer.toString((Integer.parseInt(territorios[indice_boton].getBoton().getText()) + 1)));
		territorios[indice_boton].setSoldados(territorios[indice_boton].getSoldados() + 1);

	}

	public void elegirAtacante(int indice_boton){		

		atacante = territorios[indice_boton];

		int [] colindantes = territorios[indice_boton].getColindantes();

		for (int i = 0; i < territorios.length; i++) {

			territorios[i].getBoton().setEnabled(false);

		}

		for (int i = 0; i < colindantes.length; i++) {

			if (territorios[colindantes[i]].getJugador() != territorios[indice_boton].getJugador())
				territorios[colindantes[i]].getBoton().setEnabled(true);

		}
	}
	public void combatir(int indice_boton){

		// batalla: dados y demás
		defensor = territorios[indice_boton];
		int aux = 0;
		Boolean ordenado = false;
		int dados_en_juego = 0;

		// lanzamiento de dados
		dados_atacante[0] = (int) (Math.random() * 6);
		dados_atacante[1] = (int) (Math.random() * 6);
		dados_atacante[2] = (int) (Math.random() * 6);

		dados_defensor[0] = (int) (Math.random() * 6);
		dados_defensor[1] = (int) (Math.random() * 6);

		//determina los dados que se utilizarán
		
		if (atacante.getSoldados() == 2){

			dados_atacante[3] = 1;

		}else if (atacante.getSoldados() == 3){

			dados_atacante[3] = 2;

		}else if (atacante.getSoldados() > 3){

			dados_atacante[3] = 3;
		}

		if (defensor.getSoldados() == 1){

			dados_defensor[3] = 1;

		}else if (defensor.getSoldados() > 1){

			dados_defensor[3] = 2;
		}

		// ordenar dados de mayor a menor

		while (ordenado = false){

			ordenado = true;

			for (int i = 1; i < dados_atacante[3] ; i++) {

				if (dados_atacante[i - 1] < dados_atacante[i]){

					aux = dados_atacante[i - 1];
					dados_atacante[i - 1] = dados_atacante[i];
					dados_atacante[i] = aux;	
					ordenado = false;
				}
			}
		}

		if ((dados_defensor[3]==2) && (dados_defensor[0] < dados_defensor[1])){

			aux = dados_defensor[0];
			dados_defensor[0] = dados_defensor[1];
			dados_defensor[1] = aux;			
		}

		muertes_atacante = 0;

		if (dados_defensor[3] > dados_atacante[3]){
			
			dados_en_juego = dados_atacante[3];
		}else{
			
			dados_en_juego = dados_defensor[3];
		}
		
		
		
		for (int i = 0; i < dados_en_juego; i++) {

			if (dados_atacante[i] <= dados_defensor[i]){

				atacante.setSoldados(atacante.getSoldados() - 1);
				atacante.getBoton().setText( Integer.toString(atacante.getSoldados()) );
				muertes_atacante++;
			}
			else if (dados_atacante[i] > dados_defensor[i]){

				defensor.setSoldados(defensor.getSoldados() - 1);
				defensor.getBoton().setText( Integer.toString(defensor.getSoldados()) );
			}
		}
	}

	public static void cambiarBandera(int i){
		
		switch (i){

		case 0:
			nombre_bandera = "llonguet";
			ejercito_desc = "Dictadura del Llonguet (" + jugadores[i].getNombre() + ")";
			break;
		case 1:
			nombre_bandera = "balconia";
			ejercito_desc = "The Kingdom of Balconia (" + jugadores[i].getNombre() + ")";
			break;
		case 2:
			nombre_bandera = "beer";
			ejercito_desc = "Beer Republic (" + jugadores[i].getNombre() + ")";
			break;
		case 3:
			nombre_bandera = "pagesia";
			ejercito_desc = "Comuna de Pagesia (" + jugadores[i].getNombre() + ")";
			break;
		}
	}
	
	public static Boolean comprobarVivo(int i){
		
		Boolean resultado = true;
		
		jugadores[i].setTerritorios(0);
		
		for (int j = 0; j < territorios.length; j++) {

			if (territorios[j].getJugador() == jugadores[i].getId()){

				jugadores[i].setTerritorios(jugadores[i].getTerritorios() + 1);
			}
		}
		
		if (jugadores[i].getTerritorios() == 0){
			
			jugadores[i].setVivo(false);
			resultado = false;
		}
		return resultado;
	}
	
	public static int contarRefuerzos(int i){
		
		int resultado = 0;
		
		jugadores[i].setTerritorios(0);

		for (int j = 0; j < territorios.length; j++) {

			if (territorios[j].getJugador() == jugadores[i].getId()){
				territorios[j].getBoton().setEnabled(true);

				jugadores[i].setTerritorios(jugadores[i].getTerritorios() + 1);

			}else{
				territorios[j].getBoton().setEnabled(false);
			}
		}

		//El jugador tiene 1 refuerzo por cada 2 territorios que controla, aunque siempre recibirá al menos 3 refuerzos.
		resultado = jugadores[i].getTerritorios() / 2;
		
		// Mínimo de 3 refuerzos por turnos.
		if (resultado < 3){
			resultado = 3;
		}
		
		// Bonus de refuerzos por territorios especiales
		
		switch (i){
		
		case 0:
			if (territorios[2].getJugador() == i){
				resultado++;
			}
			break;
		case 1:
			if (territorios[13].getJugador() == i){
				resultado++;
			}
			break;
		case 2:
			if (territorios[19].getJugador() == i){
				resultado++;
			}
			break;
		case 3:
			if (territorios[29].getJugador() == i){
				resultado++;
			}
			break;
		}
		
		return resultado;
	}
	
	public static void activarAtacantes(int i){
		
		for (int j = 0; j < territorios.length; j++) {

			if ( (territorios[j].getJugador() == jugadores[i].getId()) && (territorios[j].getSoldados() > 1) ){
				territorios[j].getBoton().setEnabled(true);

			}else{
				territorios[j].getBoton().setEnabled(false);
			}
		}
	}
	
	public static Boolean comprobarVictoria(){
		
		int muertos = 0;
		
		Boolean resultado = false;
		
		for (int i = 0; i < jugadores.length; i++) {
			
			if (jugadores[i].getVivo() == false){
				
				muertos++;
			}else{
				
				ganador = jugadores[i];
			}
		}
		
		if (muertos == 3){
			
			resultado = true;
		}
		
		return resultado;
	}

	public static void introducirRanking(String nombre, int semana) throws SQLException{

		Connection mysqlCon = null;
		Statement st = null;
		
		// contar pelotones
		
		int pelotones = 0;
		
		for (int i = 0; i < territorios.length; i++) {
			
			if (territorios[i].getJugador() == ganador.getId()){
				
				pelotones += territorios[i].getSoldados();
			}
		}

		try {

			Class.forName("com.mysql.jdbc.Driver");

			mysqlCon = DriverManager.getConnection(
					"jdbc:mysql://localhost/prova_java", "root", "");

			st = mysqlCon.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS ranking("
					+ "partida INT (5) AUTO_INCREMENT PRIMARY KEY,"
					+ "nombre VARCHAR(50),"
					+ "ejercito VARCHAR(50),"
					+ "pelotones INT(5),"
					+ "semanas INT(5))"; 

			String insert = "INSERT INTO ranking " +
					"VALUES(null, '"+nombre+"','"+ ganador.getGrupo()+"', "+ pelotones +", " + semana + ");";

			st.executeUpdate(sql);
			st.executeUpdate(insert);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (mysqlCon != null)
				mysqlCon.close();
			if (st != null)
				st.close();
			System.out.println("Desconectado");
		}
	}		
}
