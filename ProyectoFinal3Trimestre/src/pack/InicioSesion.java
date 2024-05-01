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
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		usuarioLabel.setBounds(182, 94, 120, 30);
		contentPane.add(usuarioLabel);
		
		JLabel contraseñaLabel = new JLabel("Contraseña");
		contraseñaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contraseñaLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		contraseñaLabel.setBounds(182, 174, 120, 30);
		contentPane.add(contraseñaLabel);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(162, 135, 160, 20);
		contentPane.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textoContraseña = new JPasswordField();
		textoContraseña.setBounds(162, 215, 160, 20);
		contentPane.add(textoContraseña);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/administracion-de-empresas.gif")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel);
	}
}
