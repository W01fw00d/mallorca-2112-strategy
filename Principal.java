package juego_2112;

import java.awt.EventQueue;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JDialog;

import javazoom.jl.decoder.JavaLayerException;

public class Principal {

	public static void main(String[] args) {

		Boolean continuar = true;
		
		final MallorcaV v = new MallorcaV();
		final MallorcaM m = new MallorcaM();
		final MallorcaC c = new MallorcaC(m, v);
		final MensajeV v2 = new MensajeV();
		final MensajeC c2 = new MensajeC(m, v2);
		
		while (continuar){

			EventQueue.invokeLater(new Runnable() {
				public void run() {

					c.pintarMapa();

					for (int i = 0; i < m.territorios.length; i++) {

						c.pintarTerritorio(m.territorios[i]); 
					}

					try {
						v.frmMain.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

//			try {
//				c2.mostrarMensajeVictoria(m.ganador, 30);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			c.playSound();
				
			continuar = c.juego();

		}

		
		//c2.mostrarMensajeVictoria(m.jugadores[0]);
		
		//c2.mostrarMensaje("llonguet");
	}
}

