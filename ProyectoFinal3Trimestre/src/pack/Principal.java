package pack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.Box;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Principal(Usuario usuario_logeado) throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setContentAreaFilled(false);
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/resources/menu (1).png")));
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		lblNewLabel = new JLabel("Cuenta ");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/resources/usuario.png")));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PerfilDeUsuario ibc = new PerfilDeUsuario(usuario_logeado);
				ibc.show();
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.BLACK);
			}
		});
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Soporte ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/resources/centro-de-llamadas.png")));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblNewLabel_1.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ajustes ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/resources/apoyo-tecnico.png")));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cerrar Sesion ");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_3.setIcon(new ImageIcon(Principal.class.getResource("/resources/cerrar-sesion.png")));
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio i = new Inicio();
				i.show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("                        ");
		menuBar.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 13));
		menuBar.add(comboBox);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		String[] listado = CuentasBD.getCuentas(usuario_logeado);
		comboBox.setModel(new DefaultComboBoxModel(listado));
		
		JLabel lblNewLabel_4_1 = new JLabel("            ");
		menuBar.add(lblNewLabel_4_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/resources/archivos.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		menuBar.add(btnNewButton);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Border bordeBotonAñadir = BorderFactory.createLineBorder(Color.WHITE, 0);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ultimas transacciones");
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_6_1.setBounds(111, 48, 263, 40);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(Principal.class.getResource("/resources/mas (1).png")));
		lblNewLabel_6.setBounds(210, 440, 64, 64);
		contentPane.add(lblNewLabel_6);
		
		JPanel panelContenedor = new JPanel();
		panelContenedor.setBounds(10, 99, 464, 330);
		contentPane.add(panelContenedor);
		panelContenedor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelContenedor.add(scrollPane);
		
		Box container = Box.createVerticalBox();
		scrollPane.setViewportView(container);
		
		for(int i=0;i<10;i++) {
			container.add(getExamplePanel());
		}
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Principal.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, -32, 484, 561);
		contentPane.add(fondo);
		
	}
	
	public JPanel getExamplePanel(Transaccion trans) {
		
		JPanel examplePanel = new JPanel();
		examplePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel imagen_1 = new JLabel("" + trans.getCantidad());
		
		JLabel nombreProducto_1 = new JLabel("Coca Cola 2L.");
		nombreProducto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		nombreProducto_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel precioProducto_1 = new JLabel("2.49 €");
		precioProducto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		GroupLayout gl_examplePanel = new GroupLayout(examplePanel);
		gl_examplePanel.setHorizontalGroup(
			gl_examplePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 271, Short.MAX_VALUE)
				.addGroup(gl_examplePanel.createSequentialGroup()
					.addGap(8)
					.addComponent(imagen_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_examplePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(nombreProducto_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addComponent(precioProducto_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_examplePanel.createSequentialGroup()
							.addGap(102))))
		);
		gl_examplePanel.setVerticalGroup(
			gl_examplePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 91, Short.MAX_VALUE)
				.addGroup(gl_examplePanel.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_examplePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(imagen_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_examplePanel.createSequentialGroup()
							.addComponent(nombreProducto_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(precioProducto_1)
							.addGap(12))))
		);
		examplePanel.setLayout(gl_examplePanel);
		return examplePanel;
	}
	
	/*
	
	*/
}
