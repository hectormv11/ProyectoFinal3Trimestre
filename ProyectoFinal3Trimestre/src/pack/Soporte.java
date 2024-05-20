package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Soporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Soporte frame = new Soporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Soporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Soporte.class.getResource("/resources/izquierda.png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 64, 64);
		contentPane.add(btnAtras);
		
		JLabel lblIconoBueno = new JLabel("");
		lblIconoBueno.setIcon(new ImageIcon(Soporte.class.getResource("/resources/bueno.png")));
		lblIconoBueno.setBounds(360, 11, 64, 64);
		contentPane.add(lblIconoBueno);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(173, 227, 89, 23);
		contentPane.add(btnEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 414, 130);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblComentarios = new JLabel("Deja aqui tus comentarios");
		lblComentarios.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarios.setBounds(11, 37, 414, 25);
		contentPane.add(lblComentarios);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Soporte.class.getResource("/resources/maxresdefault (1).jpg")));
		fondo.setBounds(0, 0, 434, 261);
		contentPane.add(fondo);
	}
}
