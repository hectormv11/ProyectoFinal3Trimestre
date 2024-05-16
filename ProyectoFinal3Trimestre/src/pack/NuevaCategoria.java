package pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static String texto;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public NuevaCategoria(String img, Usuario user) {
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

		textField = new JTextField();
		textField.setBounds(10, 51, 414, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Indique el nombre de su nueva categoria");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 414, 37);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Guerdar y cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texto = textField.getText();
				dispose();
			}
		});
		btnNewButton.setBounds(155, 186, 125, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NuevaCategoria.class.getResource("/resources/maxresdefault (1).jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);

	}

	public static String getTexto() {
		return texto;
	}
}
