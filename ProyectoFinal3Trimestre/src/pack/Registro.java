package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	private JTextField textCorreo;
	int numPulsaciones = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField_2 = new JPasswordField();
		passwordField_2.setEchoChar('*');
		passwordField_2.setBounds(240, 250, 200, 20);
		contentPane.add(passwordField_2);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(240, 168, 200, 20);
		contentPane.add(textUsuario);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Inicio i = new Inicio();
				i.show();
				dispose();

			}
		});
		btnNewButton.setIcon(new ImageIcon(Registro.class.getResource("/resources/izquierda.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(10, 11, 64, 64);
		contentPane.add(btnNewButton);

		JLabel iconoVerificar = new JLabel("");
		iconoVerificar.setVisible(false);
		iconoVerificar.setIcon(new ImageIcon(Registro.class.getResource("/resources/registrarse.png")));
		iconoVerificar.setBounds(209, 409, 64, 64);
		contentPane.add(iconoVerificar);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(240, 209, 200, 20);
		contentPane.add(passwordField);

		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(240, 291, 200, 20);
		contentPane.add(textCorreo);

		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoElectronico.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblCorreoElectronico.setBounds(10, 287, 222, 30);
		contentPane.add(lblCorreoElectronico);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar contraseña:");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarContrasea.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblConfirmarContrasea.setBounds(10, 246, 222, 30);
		contentPane.add(lblConfirmarContrasea);

		JLabel iconoPerfil = new JLabel("");
		iconoPerfil.setIcon(new ImageIcon(Registro.class.getResource("/resources/registro.png")));
		iconoPerfil.setBounds(178, 0, 128, 128);
		contentPane.add(iconoPerfil);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblUsuario.setBounds(10, 164, 222, 30);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblContrasea.setBounds(10, 205, 222, 30);
		contentPane.add(lblContrasea);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(passwordField.getText().equals(passwordField_2.getText()) && passwordField.getText().length() != 0) {
					try {
						UsuariosBD.registrarse(textUsuario.getText(), passwordField.getText(), textCorreo.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					iconoVerificar.setVisible(true);
					Inicio i = new Inicio();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					i.show();
					dispose();
				}


			}
		});
		btnRegistrarse.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRegistrarse.setBounds(166, 352, 149, 35);
		contentPane.add(btnRegistrarse);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				numPulsaciones++;
				if(numPulsaciones%2 == 0) {
					passwordField.setEchoChar('*');
					passwordField_2.setEchoChar('*');
					ImageIcon icono = new ImageIcon(Registro.class.getResource("/resources/ojo.png"));
					btnNewButton_1.setIcon(icono);
				}else {
					passwordField.setEchoChar((char)0);
					passwordField_2.setEchoChar((char)0);
					ImageIcon icono = new ImageIcon(Registro.class.getResource("/resources/ojo (1).png"));
					btnNewButton_1.setIcon(icono);
				}
				
				
			}
		});
		
		btnNewButton_1.setIcon(new ImageIcon(Registro.class.getResource("/resources/ojo.png")));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(450, 228, 24, 24);
		contentPane.add(btnNewButton_1);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Registro.class.getResource("/resources/fondoVerde.jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}
}
