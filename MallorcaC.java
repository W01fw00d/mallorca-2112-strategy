package juego_2112_v3;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

// Controlador

public class MallorcaC {

	protected static MallorcaM m;
	protected static MallorcaV v;
	protected static MensajeC c2;
	
	static Boolean espera = true;
	static Boolean espera1 = true;   // Boolean para mantener en bucle los pequeños while interiores
	static Boolean espera2 = true;
	static Boolean espera3 = true;
	static Boolean espera_med = true;  // Boolean para mantener en bucle el while medio.
	static Boolean victoria = false;   // Cuando victoria sea true, se saldrá del bucle del while externo y acabará el juego
	static Boolean continuar = true;  // se envía a Principal para indicarle si ha de reiniciar el juego
	
	static int refuerzos;
	static int [] calendario = {1, 1}; // {semanas de juego, num de acontecimiento}, cada vez que los jugadores completan sus cuatro turnos pasa una semana.

	static String fase = "refuerzos";
	
	static int jug;
	
//	static Clip clip;
//	static Boolean comp_clip = false;
	
	static Boolean cambio = false;

	public MallorcaC(MallorcaM m, MallorcaV v){

		this.m = m;
		this.v = v;

		this.v.addControllerListener(new ControllerListener());
	}

	protected class ControllerListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			// si se presiona el botón "Pasar turno", el programa sale del bucle exterior
			if(e.getActionCommand().equals("automatico")){
				
				randomRefuerzos();	
			
			}else if (e.getActionCommand().equals("pasarRefuerzos")){

				espera1 = false;
				refuerzos = 0;
				
			}else if (e.getActionCommand().equals("pasarAtaque")){
			
				espera2 = false;
				espera3 = false;
				espera_med = false;
				
			}else if (e.getActionCommand().equals("volver")){
				
				espera3 = false;	
				
			//}else if (e.getActionCommand().equals("nuevo")){
			
			}else if (e.getActionCommand().equals("risk") || e.getActionCommand().equals("ventana")||
					e.getActionCommand().equals("mallorca")||e.getActionCommand().equals("llonguet")||
					e.getActionCommand().equals("balconia")||e.getActionCommand().equals("beer")||e.getActionCommand().equals("pagesia")){
				
				c2.mostrarMensaje(e.getActionCommand());
				
			//}else if (e.getActionCommand().equals("ranking")){
			}else{
				
				accionBotonTerritorios(Integer.parseInt(e.getActionCommand()));
			}
		}
	}

	public void accionBotonTerritorios(int indice_boton){

		if (fase.equals("refuerzos")){

			m.faseRefuerzos(indice_boton);
			espera = false;
			espera1 = false;

		}else if (fase.equals("elegir_atacante")){

			m.elegirAtacante(indice_boton);
			
			v.buttonPasar.setActionCommand("volver");
			v.buttonPasar.setText("Volver");
			v.buttonPasar.setToolTipText("Anular la selección actual de territorio");
			
			espera2 = false;

		}else if (fase.equals("elegir_objetivo")){

			m.combatir(indice_boton);

			if (m.defensor.getSoldados() == 0 ){

				int jugador_perdedor = m.defensor.getJugador();
				
				conquistarTerritorio(m.dados_atacante, m.muertes_atacante);
				
				Boolean vivo = m.comprobarVivo(jugador_perdedor);
				
				if (vivo == false){
					
					v.txtArea.setText(v.txtArea.getText() + "(" + calendario[1] + ") ¡" + m.jugadores[jugador_perdedor].getNombre() + 
							" ha sido derrotado!\n");
				}
			}

			espera3 = false;
		}
	}
	
	public void conquistarTerritorio(int[] dados_atacante, int muertes_atacante) {

		// atacante conquista defensor

		m.jugadores[m.defensor.getJugador()].setTerritorios(m.jugadores[m.defensor.getJugador()].getTerritorios() - 1);
		m.jugadores[m.atacante.getJugador()].setTerritorios(m.jugadores[m.atacante.getJugador()].getTerritorios() + 1);
		
		m.defensor.setJugador(m.atacante.getJugador());
		m.defensor.setSoldados(dados_atacante[3] - muertes_atacante);
		m.defensor.getBoton().setText( Integer.toString(m.defensor.getSoldados()) );
		pintarTerritorio(m.defensor);
		m.atacante.setSoldados( m.atacante.getSoldados() - (dados_atacante[3] - muertes_atacante) );
		m.atacante.getBoton().setText( Integer.toString(m.atacante.getSoldados()) );

		m.defensor.getBoton().setToolTipText(m.defensor.getNombre() + " (" + m.jugadores[m.atacante.getJugador()].getNombre() + ")");
		v.txtArea.setText(v.txtArea.getText() + "(" + calendario[1] + ") " + m.jugadores[m.atacante.getJugador()].getNombre() + 
				" ha conquistado " + m.defensor.getNombre()+ ".\n");
		calendario[1]++;
		
		v.progressBar.setValue(m.jugadores[m.atacante.getJugador()].getTerritorios());
		v.progressBar.setToolTipText("Territorios conquistados: " + v.progressBar.getValue() + "/" + v.progressBar.getMaximum());
	}
	
	public static void pintarMapa(){

		for (int i = 0; i < m.territorios.length; i++) {

			m.territorios[i].getBoton().setFont(new Font("Lucida Grande", Font.BOLD, 15));
		}

		// Ponerle una ayuda desplegable a todos los territorios.
		for (int i = 0; i < m.territorios.length; i++) {

			m.territorios[i].getBoton().setToolTipText(m.territorios[i].getNombre() + 
					" (" + m.jugadores[m.territorios[i].getJugador()].getNombre() + ")");
		}
	}

	public static void pintarTerritorio(Territorio territorio){

		Color color_aux = new Color(0, 0, 0);

		switch (territorio.getJugador()){

		case 0:
			//color_aux = new Color(115, 41, 35);
			color_aux = Color.RED;
			break;
		case 1:
			//color_aux = new Color(61, 128, 121);
			color_aux = Color.BLUE;
			break;
		case 2:
			//color_aux = new Color(139, 110, 0);
			color_aux = Color.ORANGE;
			break;
		case 3:
			color_aux = new Color(26, 116, 60);
			//color_aux = Color.GREEN;
			break;
		}

		territorio.getBoton().setForeground(color_aux);
	}

	public static Boolean juego(){

		//		try {
		//			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
		//				new File("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/audio/llonguet_theme.wav").getAbsoluteFile());
		//				try {
		//					clip = AudioSystem.getClip();
		//					clip.start();
		//				} catch (LineUnavailableException e) {
		//					e.printStackTrace();
		//				}
		//		} catch (UnsupportedAudioFileException e1) {
		//			e1.printStackTrace();
		//		} catch (IOException e1) {
		//			e1.printStackTrace();
		//		}
		
		//playSound(0);

		Thread t = new Thread() {
			@Override
			public void run(){

				v.buttonPasar.setActionCommand("");
				v.buttonPasar.setEnabled(false);

				v.buttonAuto.setVisible(true);

				fase = "refuerzos";

				for (jug = 0; jug < m.jugadores.length; jug++) {
					//Comienza colocacion inicial de tropas
					
					cambio = true;
					//playSound(jug);   ////////////
					
					refuerzos = 20;

					/*if (jug == 2){

						refuerzos = 1000;   //////////////////// ROMPIENDO EL JUEGO
					}else{
						refuerzos = 1;
					}*/

					m.cambiarBandera(jug);

					v.lblBandera.setIcon(new ImageIcon("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/" 
							+ m.nombre_bandera + ".jpg"));
					v.lblBandera.setToolTipText(m.ejercito_desc);

					for (int j = 0; j < m.territorios.length; j++) {

						if (m.territorios[j].getJugador() == m.jugadores[jug].getId()){
							m.territorios[j].getBoton().setEnabled(true);
						}else{
							m.territorios[j].getBoton().setEnabled(false);
						}
					}

					while (refuerzos > 0){

						v.lblSoldados.setText(Integer.toString(refuerzos));
						v.lblSoldadosMen.setText("Refuerzos: ");

						espera = true;

						while (espera == true){
							System.out.println("");
						}

						refuerzos--;
					}
				}
	
				v.buttonPasar.setEnabled(true);

				while (victoria == false){

					v.txtArea.setText(v.txtArea.getText() + "[Semana " + calendario[0] + "]\n");

					calendario[0]++;
					calendario[1] = 1;

					for (jug = 0; jug < m.jugadores.length && victoria == false; jug++) {

						if (m.jugadores[jug].getVivo() == true){

							//playSound(jug);   ////////////
							
							m.cambiarBandera(jug);

							v.lblBandera.setIcon(new ImageIcon("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/" 
									+ m.nombre_bandera + ".jpg"));
							v.lblBandera.setToolTipText(m.ejercito_desc);

							fase = "refuerzos";
							v.lblSoldadosMen.setText("Refuerzos: ");
							v.lblMen.setText("Fase refuerzos");

							// "Reactivamos" los territorios según si son del jugador actual, y contamos cuantos tiene ya.

							refuerzos = m.contarRefuerzos(jug);

							v.progressBar.setValue(m.jugadores[jug].getTerritorios());
							v.progressBar.setToolTipText("Territorios conquistados: " + v.progressBar.getValue() + "/" 
									+ v.progressBar.getMaximum());

							v.buttonPasar.setActionCommand("pasarRefuerzos");
							v.buttonPasar.setText("Terminar refuerzos");
							v.buttonPasar.setToolTipText("Terminar la fase de refuerzos y pasar a la siguiente");

							v.buttonAuto.setVisible(true);

							//								if (m.jugadores[i].getTerritorios() > 25){
							//									playSound(9);
							//								}else{
							//									playSound(i);
							//								}


						/*	if (jug == 2){

								refuerzos = 1000;   //////////////////// ROMPIENDO EL JUEGO
							}else{
								refuerzos = 1;
							}*/

							while (refuerzos > 0){

								v.lblSoldados.setText(Integer.toString(refuerzos));

								espera1 = true;

								while (espera1 == true){
									System.out.println("");
								}

								refuerzos--;
							}

							espera_med = true;

							while (espera_med == true){

								//turno batalla

								v.lblSoldados.setText("");
								v.lblSoldadosMen.setText("");
								v.lblMen.setText("Elige pelotón de ataque");

								v.buttonPasar.setActionCommand("pasarAtaque");
								v.buttonPasar.setText("Terminar ataque");
								v.buttonPasar.setToolTipText("Terminar la fase de combate y terminar el turno");

								v.buttonAuto.setVisible(false);

								fase = "elegir_atacante";

								m.activarAtacantes(jug);

								espera2 = true;
								espera3 = true;

								while (espera2 == true){
									System.out.println("");
								}

								v.lblMen.setText("Elige un objetivo");
								fase = "elegir_objetivo";

								while ((espera3 == true)){
									System.out.println("");
								}
							}
							victoria = m.comprobarVictoria();
						}
					}
				}
			}
		};
		t.start();

		victoria = false;

		while (victoria == false){

			System.out.println("");
		}

		try {
			c2.mostrarMensajeVictoria(m.ganador, calendario[0]);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		v.frmMain.dispose();

		return continuar;
	}

	public static void randomRefuerzos(){

		ArrayList <Territorio> territorios_jugador = new ArrayList<Territorio>();

		int elegido;

		for (int i = 0; i < m.territorios.length; i++) {

			if (m.territorios[i].getJugador() == jug){
				territorios_jugador.add(m.territorios[i]);
			}
		}

		while (refuerzos > 0){

			elegido = (int) (Math.random() * territorios_jugador.size());
			territorios_jugador.get(elegido).getBoton().setText(Integer.toString((Integer.parseInt(territorios_jugador.get(elegido).getBoton().getText()) + 1)));
			territorios_jugador.get(elegido).setSoldados(territorios_jugador.get(elegido).getSoldados() + 1);
			refuerzos--;
		}

		espera = false;
		espera1 = false;
	}

	//Funciona pero consume mucha RAM, por alguna razón... y slo puede ejecutar .wav , tal vez usar otra libreria???
	public static void playSound(){

		String archivo = "";

		int aleatorio = (int) (Math.random() * 4);
		
		switch (aleatorio){

		case 0:
			archivo = "llonguet_theme";
			break;
		case 1:
			archivo = "balconia_theme";
			break;
		case 2:
			archivo = "beer_theme";
			break;
		case 3:
			archivo = "pagesia_theme";
			break;
//		case 9:
//			archivo = "victoria";
		}
		
		try {
			FileInputStream fis;
			final Player player;
			fis = new FileInputStream(
					"/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/audio/" + archivo + ".mp3");
			BufferedInputStream bis = new BufferedInputStream(fis);

			player = new Player(bis); // Llamada a constructor de la clase Player

			Thread t2 = new Thread() {
				@Override
				public void run(){

					try {
						player.play();
						
						while (cambio = false){
							
							System.out.println("");
						}
						
						player.close();
						
					} catch (JavaLayerException e) {
						e.printStackTrace();
					}          
				}
			};
			t2.start();

		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		/*try {
			if (comp_clip == true){
				clip.close();
			}
			comp_clip = true;

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
					new File("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/audio/" 
							+ archivo + ".wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}*/

	}
}
