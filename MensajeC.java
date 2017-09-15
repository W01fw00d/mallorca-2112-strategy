package juego_2112;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class MensajeC{

	protected static MallorcaM m;
	protected static MallorcaV v;
	protected static MensajeV v2;
	protected static MallorcaC c;
	protected static Boolean espera = true;
	protected static String nombre_jugador = "";
	
	
	public MensajeC(MallorcaM m, MensajeV v2){

		this.m = m;
		this.v2 = v2;
		this.v2.addControllerListener(new ControllerListener());
	}

	protected class ControllerListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if (e.getActionCommand().equals("cancel")){
				
				c.continuar = false;
				espera = false;
				v2.dispose();
				//v.frmMain.setVisible(false);
				
			}else{
				
				espera = false;
				v2.dispose();
			}
		}
	}
	
	public static void mostrarMensaje(String action){
		
		String nombre = "";
		String imagen = "";
		String texto = "";
		Color color = Color.WHITE;
		
		switch (action){

		case "risk":
			nombre = "Reglas del Risk";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/risk.jpg";
			texto = "El Risk es básicamente un juego de mesa de estrategia por turnos cuyo objetivo es conquistar todo el mapa. "
					+ "En este caso, vamos a jugar a una versión simplificada ambientada en Mallorca."
					+ " Hay cuatro jugadores, cada uno comienza con 8 territorios bajo su control y 20 soldados para repartir entre ellos."
					+ " Durante el turno de cada jugador, se siguen las siguientes etapas:\n\n- Refuerzos: el jugador recibe 1 soldado por cada "
					+ "2 territorios en su posesión. Además, si posee el territorio que le da bonus (ver Historia) obtendrá un soldado extra."
					+ " Los puede colocar donde desee.\n\n- Combate: durante este fase, el jugador eligirá uno de sus"
					+ "territorios (solo se puede atacar si se tiene más de un soldado) y un territorio adjacente a éste, que sea propiedad "
					+ "de un adversario. Entonces se producirá un combate cuyo resultado dependerá de la suerte. El atacante envía todos los soldados "
					+ "que pueda, hasta un máximo de 3. El defensor, se protegerá con un máximo de 2 soldados. Se lanza un dado de 6 caras por cada soldado, "
					+ "y se compara cada par de dados atacante/defensor ordenándolos de mayor a menor. Quien tenga la puntuación más alta, mata al soldado "
					+ "enemigo. Si hay empate, muere el soldado atacante. Si el jugador defensor se queda sin soldados en ese territorio, éste es conquistado "
					+ "por el atacante, que trasladará allí a todos sus soldados supervivientes al ataque.\n\nEl juego termina cuando solo queda un jugador "
					+ "en pie, dominando la totalidad del mapa. ";
			break;
		case "ventana":
			nombre = "Descripción de la ventana de juego";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/ventana.jpg";
			texto = "- Mantén el cursor sobre cualquier elemento de la ventana que no entiendas durante el juego para ver un mensaje de ayuda."
					+ "\n\n- La barra superior te permite elegir entre iniciar una nueva partida, ver los rankings de jugadores que han completado "
					+ "el juego, leer tutoriales como éste o aprender sobre Mallorca 2112."
					+ "\n\n- Cada botón que aparece sobre el mapa representa los soldados estacionados en cada territorio de Mallorca. El color del "
					+ "botón indica de quién es propiedad. Mantén el cursor para comprobar el nombre del territorio y su actual propietario"
					+ "\n\n- La barra de progreso que aparece debajo de la bandera indica el porcentaje de territorios que posee el actual jugador: "
					+ "¡Cuando la barra se llene querrá decir que has ganado!\n\n- Más abajo, encontrarás un registro de los acontecimientos importantes "
					+ "de la partida: quién conquista qué, quién ha sido derrotado o cuantas rondas (semanas) han transcurrido desde el comienzo del juego"
					+ "\n\n- En la esquina inferior derecha tienes un botón para terminar cada una de las etapas de tu turno, en caso de que no quieras "
					+ "obtener refuerzos o no quieras atacar. Una vez has seleccionado uno de tus territorios para atacar con él, puedes pulsar este "
					+ "botón para echarte atrás (cobarde... ¡Ejem!)";
			break;
		case "mallorca":
			nombre = "2112 - La re-reconquista de Mallorca";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/mallorca.jpg";
			texto = "Hace 10 años (Agosto de 2102), todos los países se ensarzaron en una gran guerra nuclear que devastó todo el planeta. "
					+ "Solo Mallorca parece haber sobrevivido sin sufrir ningún impacto directo, aunque el invierno nuclear ha cambiado"
					+ " para siempre la forma de vivir de sus gentes. Los recursos son escasos, los civiles han tomado las armas "
					+ "y se han organizado en 4 grupos armados, los hoteles se han convertido en cuarteles y en Palma se han levantado "
					+ "barricadas en los puentes de la Riera, dividiendo la ciudad en dos bandos.\n\nLa guerra está más presente que nunca "
					+ "en este mundo, y lo que comenzaron siendo pequeñas escaramuzas ha derivado en una guerra abierta por toda la isla "
					+ "entre La Dictadura del Llonguet, The Kingdom of Balconia, Beer Republic y Comuna de Pagesia. Cada bando con sus "
					+ "propios ideales y política... ¿Quién logrará hacerse con el control de Mallorca?";
			break;
		case "llonguet":
			nombre = "Llonguet - Dictadura del Llonguet";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/llonguet_pre.jpg";
			texto = "El Apocalipsis Nuclear trastornó las reglas del mundo como las conocíamos hasta ahora, y sacó en gran medida lo peor de la gente."
					+ " Aquella oscuridad, aquella violencia que todos llevábamos escondida. \n\n"
					+ "Surgió un hombre en el oeste de Palma, un tipo duro que se hacia llamar “El Llonguet”. Cruel, intolerante y violento; pero fuerte."
					+ " Derrotó a todo aquél que intento oponerse a él, logrando que además se unieran a su grupo, "
					+ "que fue aumentando hasta extenderse por gran parte del oeste de Mallorca.\n\nEl Llonguet es ambicioso, el Llonguet lo quiere todo. "
					+ "De momento, controlar la isla es su objetivo principal. Después de eso… quién sabe…\n\n*Lema: “El Mundo es para los Fuertes”"
					+ "\n\n\n[Bonus: Torneo Dragonera]\nReunes a los más aguerridos en tu torneo de lucha semanal en Calvià para convencerles que te sigan. "
					+ "Si posees este territorio, ganas +1 refuerzo cada turno.";
			color = Color.RED;
			break;
		case "balconia":
			nombre = "Miriam IV - The Kingdom of Balconia";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/balconia_pre.jpg";
			texto = "Miriam IV de la Familia Wellington se encontraba navegando en su yate en la costa de la Tramuntana cuando cayeron las bombas. "
					+ "Observó de primera mano el caos y la desesperación que se desató entre el resto de veraneantes procedentes de su país natal. "
					+ "Sim embargo, cuando hizo pública su presencia en la isla, los ánimos parecieron calmarse. Todo el mundo comenzó a acudir a ella "
					+ "en busca de una guía, de una salvadora. Miriam, que siempre creyó que su familia lleva el derecho de gobernar en la sangre, no "
					+ "vaciló en tomar el control de su gente y organizarlos. Habiendo logrado unificar el norte de la Tramuntana, solo queda llevar la "
					+ "vieja y buena monarquía al resto de pueblos que habitan la isla…\n\n*Lema: “¡Viva la Reina!”\n\n\n[Bonus: Nombramiento de Caballero] "
					+ "Nombras caballeros en Alcúdia los fines de semana. Si posees este territorio, ganas +1 refuerzo cada turno.";
			color = Color.BLUE;
			break;
		case "beer":
			nombre = "Alten - Beer Republic";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/beer_pre.jpg";
			texto = "Cuando cayeron las bombas, los veraneantes del sur de la isla corrieron hacia el aeropuerto, con la esperanza de poder volver "
					+ "a casa. Pero pronto descubrieron que no quedaba hogar al que regresar. Así que retomaron su actividad favorita del verano: "
					+ "beber cerveza. Pero, desgraciadamente, las existencias de cerveza se agotaron y tuvieron que pasar por una desagradable "
					+ "sensación de sobriedad. Por suerte, un viejo sabio se acercó a ellos y les habló de “La Leyenda de la Fuente Inagotable "
					+ "de Cerveza”. Muchos eran exceptivos al principio, pero el Delirium Tremens provocó que todos terminaran creyendo en la "
					+ "Fuente como si la hubieran visto con sus propios ojos. El pueblo votó, y eligieron al anciano como su líder espiritual "
					+ "y líder militar. La Fuente tiene que estar en algún lugar de la isla. Si logran controlar al resto de pueblos, seguro que "
					+ "entre ellos alguien sabrá dónde está…\n\n*Lema: “Aquello que cree la mayoría es la Verdad”\n\n\n[Bonus: Oktoberfest semanal] "
					+ "Celebras el Oktoberfest en Llucmajor periódicamente, y los borra...asistentes se unen a tu causa. Si posees este territorio, "
					+ "ganas +1 refuerzo cada turno.";
			color = Color.ORANGE;
			break;
		case "pagesia":
			nombre = "Tomeu - Comuna de Pagesia";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/pagesia_pre.jpg";
			texto = "Ante el fin del mundo, algunas personas vieron oportunidad donde otros solo veían tragedia: la oportunidad de librarse "
					+ "del pasado corrupto de la humanidad y volver a comenzar. Esta gente, que huyeron de las otras facciones que se fueron "
					+ "organizando en la isla, han decidido dedicar su tiempo al cultivo de la tierra y la reconstrucción en lugar de a desvalijar "
					+ "almacenes olvidados o atacar a otros pueblos. Sin embargo, las otras facciones cada vez se organizan mejor y son más agresivas."
					+ " A esta agrupación de campesinos no les queda ya más remedio que unirse a la batalla, con el fin último de unificar la isla y "
					+ "traer la paz de nuevo a estas tierras.\n\n*Lema: “Siempre se puede volver a empezar”\n\n\n[Bonus: Domesticación intensiva] "
					+ "Las cabras, vacas, cerdos y demás pueden llegar a ser aliados muy poderosos. Si posees Manacor, ganas +1 refuerzo "
					+ "cada turno.";
			color = new Color(26, 116, 60);
			break;
		}
		
		v2.lblTemaMensaje.setText(nombre);
		v2.lblTemaMensaje.setForeground(color);
		v2.lblImagen.setIcon(new ImageIcon(imagen));
		v2.txtpnTexto.setText(texto);
		
		v2.lblTipoMensaje.setText("Historia");
		v2.lblotraPartida.setText("");
		v2.okButton.setVisible(false);
		v2.cancelButton.setText("Cerrar");
		v2.cancelButton.setActionCommand("");
		v2.lblNombre.setText("");
		v2.txtNombre.setVisible(false);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				v2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v2.setVisible(true);
			}
		});
		
//		espera = true;
//		
//		while (espera == true) {
//			System.out.println("");
//		}
	}
	
	public static void mostrarMensajeVictoria(Jugador ganador, int semana) throws SQLException{
		
		String jugador = "";
		String nombre = "";
		String imagen = "";
		String texto = "";
		
		switch (ganador.getId()){

		case 0:
			jugador = "Llonguet";
			nombre = "Dictadura del Llonguet - Llonguet";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/llonguet_post.jpg";
			texto = "Tras conquistar toda la isla, cualquiera se hubiera conformado con reinar sobre lo que queda de la civilización humana...\n\n"
					+ "Excepto un hombre como Llonguet. \n\nNo, en su lugar ha decidido utilizar un barco que encontró en Cabrera para cruzar el mar en busca "
					+ "de nuevos horizontes por donde expandirse. \n\nY es que, para un pez tan grande, una pecera tan pequeña es asfixiante.\n\nLlonguet es ahora "
					+ "el más fuerte de la isla pero... ¿Será el más fuerte del mundo?";
			break;
		case 1:
			jugador = "Miriam IV";
			nombre = "The Kingdom of Balconia - Miriam IV";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/balconia_post.jpg";
			texto = "Ahora que al fin todo niño, mujer y hombre de estas tierras sabe quién tiene el derecho real de gobernar, Miriam IV puede descansar.\n\n"
					+ "O no... \n\nLas obligaciones de una buena monarca no terminan nunca: saludar desde el balcón, comer bien, procrear, ahorcar traidores... "
					+ "\n\nPero Miriam IV no desfallecerá, pues ama a su pueblo casi tanto como a si misma y cree en la libertad bien dirigida. "
					+ "\n\n¿Pero qué ha sido de los líderes de las demás facciones? ¿Habrán logrado escapar y reunirse para formar maléficos planes de traición?,"
					+ " se preguntan los consejeros de Miriam IV... ";
			break;
		case 2:
			jugador = "Alten";
			nombre = "Beer Republic - Alten";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/beer_post.jpg";
			texto = "¿Quién iba a decir que la Fuente había estado todo el tiempo en Dragonera...?\n\n"
					+ "Ahora que hay cerveza para todos, los ánimos parecen haberse calmado. Pero al anciano Alten le preocupa que la fuente "
					+ "no sea tan innagotable como se cree... y ahora intenta convencer a los isleños de la necesidad de surcar el mar en "
					+ "busca del legendario País Perdido de la Cebada.";
			break;
		case 3:
			jugador = "Tomeu";
			nombre = "Comuna de Pagesia - Tomeu";
			imagen = "/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/pagesia_post.jpg";
			texto = "Paz... al fin. \n\n"
					+ "¿Pero a qué precio? \n\nHa sido duro, y muchas sacrificios han tenido que hacerse, pero parece que el orden vuelve a reinar en la isla. "
					+ "\n\n¿Ha valido la pena? ¿Hay esperanza para la humanidad en esta tierra yerma sumida en un perpetuo invierno nuclear? "
					+ "\n\nNo conoces la respuesta, pero seguiras viendo verdes llanuras donde los demás vean desierto.";
			break;
		}
		
		v2.lblTemaMensaje.setText(nombre);
		v2.lblImagen.setIcon(new ImageIcon(imagen));
		v2.txtpnTexto.setText(texto);
		v2.lblTipoMensaje.setText("¡VICTORIA!   ");
		v2.lblotraPartida.setText("¿Otra partida?");
		v2.okButton.setVisible(true);
		v2.cancelButton.setText("No, me voy");
		v2.cancelButton.setActionCommand("cancel");
		
		v2.lblNombre.setText("Introduce tu nombre:");
		v2.txtNombre.setVisible(true);
		v2.txtNombre.setText(jugador);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				v2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v2.setVisible(true);
				//v2.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
			}
		});
		
		espera = true;
		
		while (espera == true) {
			System.out.println("");
		}
		
		nombre_jugador = v2.txtNombre.getText();
		
		m.introducirRanking(nombre_jugador, semana);
		
		v2.dispose();
	}
}

	
