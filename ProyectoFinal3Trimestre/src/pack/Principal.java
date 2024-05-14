package pack;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Box;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelTransacciones;
	private JLabel lblNewLabel;
	Cuenta c;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("rawtypes")
	public Principal(Usuario usuario_logeado) throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setToolTipText("Menú");
		mnNewMenu.setContentAreaFilled(false);
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/resources/menu (1).png")));
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);

		lblNewLabel = new JLabel("Perfil ");
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



			}
			@Override
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

		JLabel lblNewLabel_4 = new JLabel("                    ");
		menuBar.add(lblNewLabel_4);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 13));
		menuBar.add(comboBox);
		panelTransacciones = new JPanel();
		panelTransacciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		Cuenta[] listado = CuentasBD.getCuentas(usuario_logeado);
		String[] cuentasS = new String[listado.length];

		for (int i = 0; i < cuentasS.length; i++) {
			cuentasS[i] = listado[i].toString();
		}

		comboBox.setModel(new DefaultComboBoxModel(cuentasS));


		JLabel lblNewLabel_4_1 = new JLabel("            ");
		menuBar.add(lblNewLabel_4_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Balance económico");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/resources/archivos.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		menuBar.add(btnNewButton);

		setContentPane(panelTransacciones);
		panelTransacciones.setLayout(null);
		Border bordeBotonAñadir = BorderFactory.createLineBorder(Color.WHITE, 0);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setToolTipText("Filtros");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/resources/lupa.png")));
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(427, 27, 32, 32);
		panelTransacciones.add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Principal.class.getResource("/resources/circulo (2).png")));
		lblNewLabel_5.setBounds(410, 11, 64, 64);
		panelTransacciones.add(lblNewLabel_5);

		JLabel lblNewLabel_6_1 = new JLabel("Transacciones");
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_6_1.setBounds(111, 39, 263, 40);
		panelTransacciones.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				NuevaTransaccion nt = null;
				try {
					nt = new NuevaTransaccion(usuario_logeado, c);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nt.show();
				dispose();

			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(Principal.class.getResource("/resources/documento.png")));
		lblNewLabel_6.setBounds(210, 440, 64, 64);
		panelTransacciones.add(lblNewLabel_6);

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBounds(8, 87, 467, 342);
		panelTransacciones.add(panelContenedor);
		panelContenedor.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelContenedor.add(scrollPane);

		Box container = Box.createVerticalBox();
		scrollPane.setViewportView(container);



		for (int i = 0; i < listado.length; i++) {
			if(listado[i].toString().equals(comboBox.getSelectedItem())) {
				c = listado[i];

			}
		}

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				container.removeAll();
				container.setVisible(false);
				for (int i = 0; i < listado.length; i++) {
					if(listado[i].toString().equals(comboBox.getSelectedItem())) {
						c = listado[i];

					}
				}
				Transaccion[] trans = null;
				try {
					trans = TransaccionesBD.getTransacciones(c, usuario_logeado);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				int startIndex = 0;

				if(trans.length > 10) {
					startIndex = trans.length - 10;
				}

				for (int i = startIndex; i < trans.length; i++) {
					container.add(getExamplePanel(trans[i]));
				}

				container.setVisible(true);
			}
		});

		Transaccion[] trans = TransaccionesBD.getTransacciones(c, usuario_logeado);

		int startIndex = 0;

		if(trans.length > 10) {
			startIndex = trans.length - 10;
		}

		for (int i = startIndex; i < trans.length; i++) {
			container.add(getExamplePanel(trans[i]));
		}

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Principal.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, -32, 484, 561);
		panelTransacciones.add(fondo);

	}

	public JPanel getExamplePanel(Transaccion trans) {

		//--------------------------------------------------------------------------------------------------------------------------//

		JPanel panel = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(border);
		
		JLabel cantidad = new JLabel("Cantidad:");
		
		JLabel fecha = new JLabel("Fecha:");
		
		JLabel comentario = new JLabel("Comentario:");
		
		String texto = String.valueOf(trans.getCantidad());
		JLabel cantidadTexto = new JLabel(texto);
		
		String texto1 = String.valueOf(trans.getFecha());
		JLabel fechaTexto = new JLabel(texto1);
		
		JButton editar = new JButton("Editar");
		editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel categoria = new JLabel("Categoria:");
		categoria.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Principal.class.getResource("/resources/"+trans.getCat().getRuta())));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		
		JLabel lblNewLabel = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cantidad, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(fecha, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(comentario, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cantidadTexto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addComponent(fechaTexto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(206)
									.addComponent(categoria, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addGap(5)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(editar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(36)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cantidad)
							.addGap(11)
							.addComponent(fecha)
							.addGap(11)
							.addComponent(comentario))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cantidadTexto)
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(fechaTexto)
								.addComponent(categoria)))
						.addComponent(lblNewLabel_5))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(editar)
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
		);
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setText(trans.getComentario());
		textArea.setEditable(false);
		
		
		editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Editor ed = new Editor(trans);
				ed.show();
				dispose();
				
			}
		});
		panel.setLayout(gl_panel);
		if(trans.getTipo().equals("i")) {
			Color backgroundColor = new Color(168, 255, 150);
			panel.setBackground(backgroundColor);
		}else {
			Color backgroundColor = new Color(255, 150, 150);
			panel.setBackground(backgroundColor);
		}


		//--------------------------------------------------------------------------------------------------------------------------//

		return panel;
	}
}
