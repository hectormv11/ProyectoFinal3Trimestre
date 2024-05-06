package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class PerfilDeUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordTexto;
	int numPulsaciones = 0;
	static Usuario user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilDeUsuario frame = new PerfilDeUsuario(user);
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
	public PerfilDeUsuario(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel confirmar = new JLabel("Pulsa de nuevo el boton para confirmar");
		confirmar.setVisible(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Principal p = new Principal(user);
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();

			}
		});
		btnNewButton.setIcon(new ImageIcon(PerfilDeUsuario.class.getResource("/resources/izquierda.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(10, 11, 64, 64);
		contentPane.add(btnNewButton);
		confirmar.setHorizontalAlignment(SwingConstants.CENTER);
		confirmar.setBounds(175, 381, 250, 14);
		contentPane.add(confirmar);

		passwordTexto = new JPasswordField();
		passwordTexto.setEchoChar('*');
		passwordTexto.setEditable(false);
		passwordTexto.setBounds(175, 350, 250, 20);
		contentPane.add(passwordTexto);
		passwordTexto.setText(user.getPass());

		JButton botonEditar = new JButton("");
		botonEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				passwordTexto.setEditable(true);
				confirmar.setVisible(true);
				numPulsaciones++;
				if(numPulsaciones%2 == 0) {
					passwordTexto.setEditable(false);
					confirmar.setVisible(false);
					if(passwordTexto.getText().length() != 0) {
						try {
							UsuariosBD.actualizarContraseña(user, passwordTexto.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						passwordTexto.setText(user.getPass());
					}

				}

			}
		});
		botonEditar.setContentAreaFilled(false);
		botonEditar.setBorderPainted(false);
		botonEditar.setIcon(new ImageIcon(PerfilDeUsuario.class.getResource("/resources/editar.png")));
		botonEditar.setBounds(435, 347, 24, 24);
		contentPane.add(botonEditar);

		JLabel usuarioTexto = new JLabel("");
		usuarioTexto.setBounds(175, 280, 299, 20);
		contentPane.add(usuarioTexto);
		usuarioTexto.setText(user.getUsuario());

		JLabel emailTexto = new JLabel("");
		emailTexto.setBounds(175, 314, 299, 20);
		contentPane.add(emailTexto);
		emailTexto.setText(user.getEmail());

		JLabel labelContraseña = new JLabel("Contraseña:");
		labelContraseña.setHorizontalAlignment(SwingConstants.TRAILING);
		labelContraseña.setFont(new Font("Consolas", Font.PLAIN, 20));
		labelContraseña.setBounds(10, 349, 135, 24);
		contentPane.add(labelContraseña);


		JLabel labelCorreo = new JLabel("E-mail:");
		labelCorreo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelCorreo.setFont(new Font("Consolas", Font.PLAIN, 20));
		labelCorreo.setBounds(10, 314, 135, 24);
		contentPane.add(labelCorreo);

		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		labelUsuario.setFont(new Font("Consolas", Font.PLAIN, 20));
		labelUsuario.setBounds(10, 279, 135, 24);
		contentPane.add(labelUsuario);

		JLabel chincheta = new JLabel("");
		chincheta.setIcon(new ImageIcon(PerfilDeUsuario.class.getResource("/resources/suministros-escolares.png")));
		chincheta.setBounds(220, 88, 24, 24);
		contentPane.add(chincheta);

		JLabel iconoPerfil = new JLabel("");
		iconoPerfil.setIcon(new ImageIcon(PerfilDeUsuario.class.getResource("/resources/usuario (1).png")));
		iconoPerfil.setBounds(178, 102, 128, 128);
		contentPane.add(iconoPerfil);

		JLabel fondoPerfil = new JLabel("");
		fondoPerfil.setIcon(new ImageIcon(PerfilDeUsuario.class.getResource("/resources/fondoVerde.jpg")));
		fondoPerfil.setBounds(0, 0, 484, 561);
		contentPane.add(fondoPerfil);
	}
}
