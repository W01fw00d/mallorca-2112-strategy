package juego_2112_v3;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.SystemColor;

//Vista

public class MallorcaV extends JFrame{

	protected  static final long serialVersionUID = 1L;

	protected JFrame frmMain;
	protected final static JButton button1 = new JButton("1");
	protected final static JButton button2 = new JButton("1");
	protected final static JButton button3 = new JButton("1");
	protected final static JButton button4 = new JButton("1");
	protected final static JButton button5 = new JButton("1");
	protected final static JButton button6 = new JButton("1");
	protected final static JButton button7 = new JButton("1");
	protected final static JButton button8 = new JButton("1");
	protected final static JButton button9 = new JButton("1");
	protected final static JButton button10 = new JButton("1");
	protected final static JButton button11 = new JButton("1");
	protected final static JButton button12 = new JButton("1");
	protected final static JButton button13 = new JButton("1");
	protected final static JButton button14 = new JButton("1");
	protected final static JButton button15 = new JButton("1");
	protected final static JButton button16 = new JButton("1");
	protected final static JButton button17 = new JButton("1");
	protected final static JButton button18 = new JButton("1");
	protected final static JButton button19 = new JButton("1");
	protected final static JButton button20 = new JButton("1");
	protected final static JButton button21 = new JButton("1");
	protected final static JButton button22 = new JButton("1");
	protected final static JButton button23 = new JButton("1");
	protected final static JButton button24 = new JButton("1");
	protected final static JButton button25 = new JButton("1");
	protected final static JButton button26 = new JButton("1");
	protected final static JButton button27 = new JButton("1");
	protected final static JButton button28 = new JButton("1");
	protected final static JButton button29 = new JButton("1");
	protected final static JButton button30 = new JButton("1");
	protected final static JButton button31 = new JButton("1");
	protected final static JButton button32 = new JButton("1");

	protected final static JLabel lblSoldadosMen = new JLabel("Soldados por colocar:");
	protected final static JLabel lblSoldados = new JLabel("");
	protected final static JLabel lblMen = new JLabel("");
	protected final static JButton buttonPasar= new JButton("Pasar turno");
	protected final static JTextArea txtArea = new JTextArea("");
	protected final static JLabel lblBandera = new JLabel("");
	protected final static JLabel lblMapa  = new JLabel("");
	protected final static JProgressBar progressBar = new JProgressBar();
	protected final static JMenu mnJuego = new JMenu("Juego");
	protected final static JMenuItem mntmJuegoNuevo = new JMenuItem("Juego nuevo");
	protected final static JMenu mnTutorial = new JMenu("Tutorial");
	protected final static JMenuItem mntmRisk = new JMenuItem("Risk");
	protected final static JMenuItem mntmVentana = new JMenuItem("Ventana");
	protected final static JMenu mnHistoria = new JMenu("Historia");
	protected final static JMenuItem mntmMallorca = new JMenuItem("Mallorca - 2112");
	protected final static JMenuItem mntmTheKingdomOf = new JMenuItem("The Kingdom of Balconia");
	protected final static JMenuItem mntmBeerRepublic = new JMenuItem("Beer Republic");
	protected final static JMenuItem mntmComunaDePagesia = new JMenuItem("Comuna de Pagesia");
	protected final static JMenuItem mntmDictaduraDelLlonguet = new JMenuItem("Dictadura del Llonguet");
	protected final static JMenuItem mntmRanking = new JMenuItem("Ranking");
	protected final static JButton buttonAuto = new JButton("Automático");
	private JLabel labelFondo;

	/**
	 * Create the application.
	 */
	public MallorcaV() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frmMain = new JFrame();
		frmMain.getContentPane().setBackground(new Color(0, 139, 139));
		frmMain.setTitle("[2112: La Re-reconquista de Mallorca]");
		frmMain.setBackground(Color.BLACK);
		frmMain.setBounds(0, 0, 1200, 800);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		frmMain.setResizable(false);

		button1.setBounds(96, 327, 26, 29);
		frmMain.getContentPane().add(button1);
		button1.setActionCommand("0");	

		button2.setBounds(171, 287, 26, 29);
		frmMain.getContentPane().add(button2);
		button2.setActionCommand("1");

		button3.setBounds(160, 360, 26, 29);
		frmMain.getContentPane().add(button3);
		button3.setActionCommand("2");

		button4.setBounds(244, 310, 26, 29);
		frmMain.getContentPane().add(button4);
		button4.setActionCommand("3");

		button5.setBounds(284, 241, 26, 29);
		frmMain.getContentPane().add(button5);
		button5.setActionCommand("4");

		button6.setBounds(355, 210, 26, 29);
		frmMain.getContentPane().add(button6);
		button6.setActionCommand("5");

		button7.setBounds(308, 287, 26, 29);
		frmMain.getContentPane().add(button7);
		button7.setActionCommand("6");

		button8.setBounds(380, 251, 26, 29);
		frmMain.getContentPane().add(button8);
		button8.setActionCommand("7");

		button9.setBounds(226, 230, 26, 29);
		frmMain.getContentPane().add(button9);
		button9.setActionCommand("8");

		button10.setBounds(294, 177, 26, 29);
		frmMain.getContentPane().add(button10);
		button10.setActionCommand("9");

		button11.setBounds(369, 139, 26, 29);
		frmMain.getContentPane().add(button11);
		button11.setActionCommand("10");

		button12.setBounds(440, 88, 26, 29);
		frmMain.getContentPane().add(button12);
		button12.setActionCommand("11");

		button13.setBounds(520, 67, 26, 29);
		frmMain.getContentPane().add(button13);
		button13.setActionCommand("12");

		button14.setBounds(550, 115, 26, 29);
		frmMain.getContentPane().add(button14);
		button14.setActionCommand("13");

		button15.setBounds(461, 149, 26, 29);
		frmMain.getContentPane().add(button15);
		button15.setActionCommand("14");

		button16.setBounds(461, 210, 26, 29);
		frmMain.getContentPane().add(button16);
		button16.setActionCommand("15");

		button17.setBounds(325, 347, 26, 29);
		frmMain.getContentPane().add(button17);
		button17.setActionCommand("16");

		button18.setBounds(417, 298, 26, 29);
		frmMain.getContentPane().add(button18);
		button18.setActionCommand("17");

		button19.setBounds(509, 251, 26, 29);
		frmMain.getContentPane().add(button19);
		button19.setActionCommand("18");

		button20.setBounds(393, 447, 26, 29);
		frmMain.getContentPane().add(button20);
		button20.setActionCommand("19");

		button21.setBounds(417, 360, 26, 29);
		frmMain.getContentPane().add(button21);
		button21.setActionCommand("20");

		button22.setBounds(520, 403, 26, 29);
		frmMain.getContentPane().add(button22);
		button22.setActionCommand("21");

		button23.setBounds(520, 327, 26, 29);
		frmMain.getContentPane().add(button23);
		button23.setActionCommand("22");

		button24.setBounds(575, 270, 26, 29);
		frmMain.getContentPane().add(button24);
		button24.setActionCommand("23");

		button25.setBounds(537, 177, 26, 29);
		frmMain.getContentPane().add(button25);
		button25.setActionCommand("24");

		button26.setBounds(605, 210, 26, 29);
		frmMain.getContentPane().add(button26);
		button26.setActionCommand("25");

		button27.setBounds(710, 230, 26, 29);
		frmMain.getContentPane().add(button27);
		button27.setActionCommand("26");

		button28.setBounds(779, 241, 26, 29);
		frmMain.getContentPane().add(button28);
		button28.setActionCommand("27");

		button29.setBounds(710, 298, 26, 29);
		frmMain.getContentPane().add(button29);
		button29.setActionCommand("28");

		button30.setBounds(644, 378, 26, 29);
		frmMain.getContentPane().add(button30);
		button30.setActionCommand("29");

		button31.setBounds(550, 498, 26, 29);
		frmMain.getContentPane().add(button31);
		button31.setActionCommand("30");

		button32.setBounds(428, 669, 26, 29);
		frmMain.getContentPane().add(button32);
		button32.setActionCommand("31");

		lblMapa.setBounds(29, 6, 800, 739);
		frmMain.getContentPane().add(lblMapa);
		lblMapa.setIcon(new ImageIcon("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/mapa.jpg"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(841, 312, 353, 217);
		frmMain.getContentPane().add(scrollPane);
		txtArea.setEditable(false);
		txtArea.setToolTipText("Crónicas de la guerra");

		scrollPane.setViewportView(txtArea);
		lblSoldadosMen.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSoldadosMen.setForeground(Color.WHITE);
		lblSoldadosMen.setBounds(848, 254, 144, 16);

		// el Máximo de espacios que cabrán en txtArea serán 40.

		frmMain.getContentPane().add(lblSoldadosMen);
		lblSoldados.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSoldados.setForeground(Color.WHITE);
		lblSoldados.setBounds(1017, 254, 78, 16);

		frmMain.getContentPane().add(lblSoldados);

		progressBar.setMaximum(32);
		progressBar.setValue(0);
		progressBar.setForeground(Color.LIGHT_GRAY);
		progressBar.setBounds(841, 279, 353, 20);
		frmMain.getContentPane().add(progressBar);
		lblMen.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMen.setForeground(Color.WHITE);

		lblMen.setBounds(848, 230, 191, 16);
		frmMain.getContentPane().add(lblMen);

		buttonPasar.setBounds(927, 620, 174, 29);
		frmMain.getContentPane().add(buttonPasar);
		buttonPasar.setActionCommand("");
		buttonPasar.setText("Terminar fase");

		lblBandera.setBounds(854, 19, 324, 200);
		frmMain.getContentPane().add(lblBandera);
		
		buttonAuto.setActionCommand("");
		buttonAuto.setBounds(927, 669, 174, 29);
		frmMain.getContentPane().add(buttonAuto);
		buttonAuto.setActionCommand("automatico");
		buttonAuto.setToolTipText("Repartir los refuerzos restantes aleatoriamente");
		
		labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/fondo.jpg"));
		labelFondo.setBounds(0, 0, 1200, 800);
		frmMain.getContentPane().add(labelFondo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		frmMain.setJMenuBar(menuBar);
		mnJuego.setBackground(Color.DARK_GRAY);
		
		menuBar.add(mnJuego);
		mnJuego.add(mntmJuegoNuevo);
		mnJuego.add(mntmRanking);
		mnTutorial.setBackground(Color.DARK_GRAY);
		menuBar.add(mnTutorial);		
		mnTutorial.add(mntmRisk);		
		mnTutorial.add(mntmVentana);		
		mnHistoria.setBackground(Color.DARK_GRAY);
		menuBar.add(mnHistoria);		
		mntmMallorca.setBackground(Color.WHITE);
		mnHistoria.add(mntmMallorca);		
		mnHistoria.add(mntmDictaduraDelLlonguet);
		mntmDictaduraDelLlonguet.setActionCommand("llonguet");
		mnHistoria.add(mntmTheKingdomOf);	
		mnHistoria.add(mntmBeerRepublic);	
		mnHistoria.add(mntmComunaDePagesia);	
		
		mntmJuegoNuevo.setActionCommand("nuevo");
		mntmRanking.setActionCommand("ranking");
		mntmRisk.setActionCommand("risk");
		mntmVentana.setActionCommand("ventana");
		mntmMallorca.setActionCommand("mallorca");
		mntmTheKingdomOf.setActionCommand("balconia");
		mntmBeerRepublic.setActionCommand("beer");
		mntmComunaDePagesia.setActionCommand("pagesia");
	}

	void addControllerListener (ActionListener listenerForButtons){

		button1.addActionListener(listenerForButtons);
		button2.addActionListener(listenerForButtons); 
		button3.addActionListener(listenerForButtons); 
		button4.addActionListener(listenerForButtons); 
		button5.addActionListener(listenerForButtons); 
		button6.addActionListener(listenerForButtons); 
		button7.addActionListener(listenerForButtons); 
		button8.addActionListener(listenerForButtons); 
		button9.addActionListener(listenerForButtons); 
		button10.addActionListener(listenerForButtons); 
		button11.addActionListener(listenerForButtons); 
		button12.addActionListener(listenerForButtons); 
		button13.addActionListener(listenerForButtons); 
		button14.addActionListener(listenerForButtons); 
		button15.addActionListener(listenerForButtons); 
		button16.addActionListener(listenerForButtons); 
		button17.addActionListener(listenerForButtons); 
		button18.addActionListener(listenerForButtons); 
		button19.addActionListener(listenerForButtons); 
		button20.addActionListener(listenerForButtons); 
		button21.addActionListener(listenerForButtons); 
		button22.addActionListener(listenerForButtons); 
		button23.addActionListener(listenerForButtons); 
		button24.addActionListener(listenerForButtons); 
		button25.addActionListener(listenerForButtons); 
		button26.addActionListener(listenerForButtons); 
		button27.addActionListener(listenerForButtons); 
		button28.addActionListener(listenerForButtons); 
		button29.addActionListener(listenerForButtons); 
		button30.addActionListener(listenerForButtons); 
		button31.addActionListener(listenerForButtons); 
		button32.addActionListener(listenerForButtons); 
		
		buttonPasar.addActionListener(listenerForButtons); 
		buttonAuto.addActionListener(listenerForButtons);
		
		mntmJuegoNuevo.addActionListener(listenerForButtons);
		mntmRanking.addActionListener(listenerForButtons);
		mntmRisk.addActionListener(listenerForButtons);
		mntmVentana.addActionListener(listenerForButtons);
		mntmMallorca.addActionListener(listenerForButtons);
		mntmDictaduraDelLlonguet.addActionListener(listenerForButtons);
		mntmTheKingdomOf.addActionListener(listenerForButtons);
		mntmBeerRepublic.addActionListener(listenerForButtons);
		mntmComunaDePagesia.addActionListener(listenerForButtons);
	}
}

