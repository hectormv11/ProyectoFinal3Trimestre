package pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NuevaCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public NuevaCategoria(String img, Usuario user, Cuenta c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 87, 414, 83);
		lblNewLabel_2.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/"+img)));
		contentPane.add(lblNewLabel_2);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 51, 414, 25);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel textoIndicarNombre = new JLabel("Indique el nombre de su nueva categoria");
		textoIndicarNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textoIndicarNombre.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoIndicarNombre.setBounds(10, 11, 414, 37);
		contentPane.add(textoIndicarNombre);

		JButton botonGuardar = new JButton("Guerdar y cerrar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CategoriasBD.añadirCategoria(textFieldNombre.getText(), user, img);
					NuevaTransaccion nv = new NuevaTransaccion(user, c);
					nv.show();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Nombre ya existente");
					e1.printStackTrace();
				}	
			}
		});
		botonGuardar.setBounds(142, 188, 150, 23);
		contentPane.add(botonGuardar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NuevaCategoria.class.getResource("/resources/maxresdefault (1).jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);

	}

	
}
