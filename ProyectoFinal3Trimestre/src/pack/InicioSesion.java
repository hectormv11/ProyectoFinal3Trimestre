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
import javax.swing.JOptionPane;
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
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textoContraseña = new JPasswordField();
		textoContraseña.setBounds(162, 215, 160, 20);
		contentPane.add(textoContraseña);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(162, 135, 160, 20);
		contentPane.add(textoUsuario);
		textoUsuario.setColumns(10);

		JLabel contraseñaLabel = new JLabel("Contraseña");
		contraseñaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contraseñaLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		contraseñaLabel.setBounds(182, 174, 120, 30);
		contentPane.add(contraseñaLabel);

		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		usuarioLabel.setBounds(182, 94, 120, 30);
		contentPane.add(usuarioLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/resumen-superficie-texturas-muro-piedra-hormigon-blanco (1).jpg")));
		lblNewLabel_1.setBounds(143, 93, 200, 150);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuario = textoUsuario.getText();
				String passw = textoContraseña.getText();

				try {
					Usuario logeado = UsuariosBD.doLogin(usuario, passw);
					Principal principal = new Principal(logeado);
					principal.show();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error Usuario incorreto");
				}

			}
		});
		
		btnNewButton.setBounds(201, 269, 89, 23);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/fondo-pantalla-fondo-concepto-negocio-patrones-fisuras-finanzas-o-economia_78677-9986 (1) (1).jpg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel);
		
		//Intento de key listener
		
		contentPane.setFocusable(true);
		
		contentPane.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                //Aqui no funcionara
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    //JOptionPane.showMessageDialog(contentPane, "Has pulsado Enter");
                	
                	btnNewButton.doClick(0);
                }
                /*if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }*/
            }
            public void keyReleased(KeyEvent e){
                //Aqui tambien puedes insertar el codigo
            }
        });
	}
	
}
