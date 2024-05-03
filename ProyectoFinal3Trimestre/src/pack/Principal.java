package pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Principal(Usuario usuario_logeado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 500, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menú");
		mnNewMenu.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JLabel lblNewLabel = new JLabel("Cuenta ");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Soporte ");
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ajustes ");
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cerrar Sesion ");
		lblNewLabel_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
	}
	
	

}
