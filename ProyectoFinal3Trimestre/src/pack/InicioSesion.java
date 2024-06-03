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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoUsuario;
	private JPasswordField textoContraseña;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/resources/presupuesto (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Inicio i = new Inicio();
				i.show();
				dispose();

			}
		});
		btnNewButton_1.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/izquierda (1).png")));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(10, 11, 64, 64);
		contentPane.add(btnNewButton_1);

		textoContraseña = new JPasswordField();
		textoContraseña.setEchoChar('*');
		textoContraseña.setBounds(162, 253, 160, 20);
		contentPane.add(textoContraseña);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(162, 173, 160, 20);
		contentPane.add(textoUsuario);
		textoUsuario.setColumns(10);

		JLabel contraseñaLabel = new JLabel("Contraseña");
		contraseñaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contraseñaLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		contraseñaLabel.setBounds(182, 212, 120, 30);
		contentPane.add(contraseñaLabel);

		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		usuarioLabel.setBounds(182, 132, 120, 30);
		contentPane.add(usuarioLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/resumen-superficie-texturas-muro-piedra-hormigon-blanco (1).jpg")));
		lblNewLabel_1.setBounds(143, 131, 200, 150);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuario = textoUsuario.getText();
				String passw = textoContraseña.getText();

				try {
					Usuario logeado = UsuariosBD.doLogin(usuario, passw);
					Principal principal = new Principal(logeado,false, null,"Ningun filtro aplicado");
					principal.show();
					dispose();
				} catch (SQLException e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error Usuario o contraseña incorreto");
				}

			}
		});

		btnNewButton.setBounds(201, 307, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/dolar_128_.gif")));
		btnNewButton_2.setBounds(186, 388, 128, 128);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(172, 377, 150, 150);
		contentPane.add(btnNewButton_3);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/fondo-pantalla-fondo-concepto-negocio-patrones-fisuras-finanzas-o-economia_78677-9986 (1) (1).jpg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel);
	}
}
