package juego_2112;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;

public class MensajeV extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JLabel lblImagen;
	protected JLabel lblTemaMensaje;
	protected JLabel lblotraPartida;
	protected JButton okButton;
	protected JButton cancelButton;
	protected JTextPane txtpnTexto;
	protected JLabel lblTipoMensaje;
	protected JTextField txtNombre;
	protected JLabel lblNombre;
	private JLabel labelFondo;

	/**
	 * Create the dialog.
	 */
	public MensajeV() {
		getContentPane().setBackground(SystemColor.textHighlight);
		setBackground(Color.LIGHT_GRAY);
		
		setBounds(100, 100, 1200, 600);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(28, 108, 600, 400);
		contentPanel.add(lblImagen);
		
		lblTemaMensaje = new JLabel("");
		lblTemaMensaje.setForeground(Color.WHITE);
		lblTemaMensaje.setFont(new Font("Luminari", Font.BOLD, 22));
		lblTemaMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaMensaje.setBounds(424, 55, 458, 41);
		contentPanel.add(lblTemaMensaje);
		
		lblTipoMensaje = new JLabel();
		lblTipoMensaje.setForeground(Color.WHITE);
		lblTipoMensaje.setFont(new Font("Monotype Corsiva", Font.BOLD, 32));
		lblTipoMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoMensaje.setBounds(550, 6, 218, 41);
		contentPanel.add(lblTipoMensaje);
		
		txtpnTexto = new JTextPane();
		txtpnTexto.setEditable(false);
		txtpnTexto.setBounds(667, 108, 504, 400);
		contentPanel.add(txtpnTexto);
		
		labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("/Users/Gabriel/Programming/workspace/entornosDesarrollo/src/juego_2112/imagenes/fondo.jpg"));
		labelFondo.setBounds(0, 0, 1200, 600);
		contentPanel.add(labelFondo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				lblotraPartida = new JLabel();
				buttonPane.add(lblotraPartida);
			}
			
			lblNombre = new JLabel("");
			buttonPane.add(lblNombre);
			
			txtNombre = new JTextField();
			buttonPane.add(txtNombre);
			txtNombre.setColumns(10);
			{
				okButton = new JButton("Venga, va");
				okButton.setActionCommand("ok");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("No, me voy");
				cancelButton.setActionCommand("cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	void addControllerListener (ActionListener listenerForButtons){

		okButton.addActionListener(listenerForButtons);
		cancelButton.addActionListener(listenerForButtons); 
	}
}
