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
	private JLabel lblPerfil;
	Cuenta c;
	boolean flag;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("rawtypes")
	public Principal(Usuario usuario_logeado, boolean arrayTrans, Transaccion[] arrT, String filtros) throws SQLException {
		flag = arrayTrans;
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

		lblPerfil = new JLabel("Perfil ");
		lblPerfil.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPerfil.setIcon(new ImageIcon(Principal.class.getResource("/resources/usuario.png")));
		lblPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PerfilDeUsuario ibc = new PerfilDeUsuario(usuario_logeado);
				ibc.show();
				dispose();

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPerfil.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPerfil.setForeground(Color.BLACK);
			}
		});
		lblPerfil.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblPerfil);

		JLabel lblNewLabel_4 = new JLabel("                    ");
		menuBar.add(lblNewLabel_4);

		JComboBox comboBoxCuentas = new JComboBox();
		comboBoxCuentas.setFont(new Font("Dialog", Font.PLAIN, 13));
		menuBar.add(comboBoxCuentas);
		panelTransacciones = new JPanel();
		panelTransacciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		Cuenta[] listado = CuentasBD.getCuentas(usuario_logeado);
		String[] cuentasS = new String[listado.length];

		for (int i = 0; i < cuentasS.length; i++) {
			cuentasS[i] = listado[i].toString();
		}

		comboBoxCuentas.setModel(new DefaultComboBoxModel(cuentasS));


		JLabel lblNewLabel_4_1 = new JLabel("            ");
		menuBar.add(lblNewLabel_4_1);

		JButton lblBalance = new JButton("");
		lblBalance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBalance.setToolTipText("Balance económico");
		lblBalance.setBorderPainted(false);
		lblBalance.setContentAreaFilled(false);
		lblBalance.setIcon(new ImageIcon(Principal.class.getResource("/resources/archivos.png")));
		lblBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BalanceEconomico b;
				try {
					b = new BalanceEconomico(c, TransaccionesBD.getTransacciones(c, usuario_logeado));
					b.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dispose();

			}
		});
		lblBalance.setFont(new Font("Dialog", Font.PLAIN, 15));
		menuBar.add(lblBalance);

		setContentPane(panelTransacciones);
		panelTransacciones.setLayout(null);
		JButton lblFiltros = new JButton("");
		lblFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Filtros f;
				try {
					f = new Filtros(c, usuario_logeado);
					f.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();

			}
		});
		lblFiltros.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFiltros.setToolTipText("Filtros");

		JLabel filtrosAplicados = new JLabel("");
		filtrosAplicados.setHorizontalAlignment(SwingConstants.CENTER);
		filtrosAplicados.setForeground(new Color(0, 0, 0));
		filtrosAplicados.setFont(new Font("Arial", Font.PLAIN, 15));
		filtrosAplicados.setBounds(10, 67, 464, 20);
		filtrosAplicados.setText(filtros);
		panelTransacciones.add(filtrosAplicados);

		JLabel filtrosAplicadosFondo = new JLabel("");
		filtrosAplicadosFondo.setIcon(new ImageIcon(Principal.class.getResource("/resources/maxresdefault (1).jpg")));
		filtrosAplicadosFondo.setHorizontalAlignment(SwingConstants.CENTER);
		filtrosAplicadosFondo.setForeground(Color.WHITE);
		filtrosAplicadosFondo.setFont(new Font("Arial", Font.PLAIN, 15));
		filtrosAplicadosFondo.setBounds(9, 67, 464, 20);
		panelTransacciones.add(filtrosAplicadosFondo);

		lblFiltros.setIcon(new ImageIcon(Principal.class.getResource("/resources/lupa.png")));
		lblFiltros.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFiltros.setContentAreaFilled(false);
		lblFiltros.setBorderPainted(false);
		lblFiltros.setBounds(435, 17, 32, 32);
		panelTransacciones.add(lblFiltros);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Principal.class.getResource("/resources/circulo (2).png")));
		lblNewLabel_5.setBounds(418, 1, 64, 64);
		panelTransacciones.add(lblNewLabel_5);

		JLabel lblTransacciones = new JLabel("Transacciones");
		lblTransacciones.setForeground(new Color(255, 255, 255));
		lblTransacciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransacciones.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblTransacciones.setBounds(111, 21, 263, 40);
		panelTransacciones.add(lblTransacciones);

		JLabel lblNuevaTransaccion = new JLabel("");
		lblNuevaTransaccion.setToolTipText("Nueva Transaccion");
		lblNuevaTransaccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNuevaTransaccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					NuevaTransaccion nt = new NuevaTransaccion(usuario_logeado, c);
					nt.show();
					dispose();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		lblNuevaTransaccion.setIcon(new ImageIcon(Principal.class.getResource("/resources/documento.png")));
		lblNuevaTransaccion.setBounds(210, 446, 64, 64);
		panelTransacciones.add(lblNuevaTransaccion);

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBounds(8, 97, 467, 342);
		panelTransacciones.add(panelContenedor);
		panelContenedor.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelContenedor.add(scrollPane);

		Box panelContainer = Box.createVerticalBox();
		scrollPane.setViewportView(panelContainer);



		for (int i = 0; i < listado.length; i++) {
			if(listado[i].toString().equals(comboBoxCuentas.getSelectedItem())) {
				c = listado[i];

			}
		}

		comboBoxCuentas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				flag = false;

				panelContainer.removeAll();
				panelContainer.setVisible(false);
				for (int i = 0; i < listado.length; i++) {
					if(listado[i].toString().equals(comboBoxCuentas.getSelectedItem())) {
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
					panelContainer.add(getExamplePanel(trans[i]));
				}

				panelContainer.setVisible(true);
			}
		});
		Transaccion[] trans = null;
		if(flag == false) {
			trans = TransaccionesBD.getTransacciones(c, usuario_logeado);
		}else {

			trans = arrT;
		}


		int startIndex = 0;

		if(trans.length > 10) {
			startIndex = trans.length - 10;
		}

		for (int i = startIndex; i < trans.length; i++) {
			panelContainer.add(getExamplePanel(trans[i]));
		}
		
		JLabel lblSoporte = new JLabel("Soporte ");
		lblSoporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoporte.setIcon(new ImageIcon(Principal.class.getResource("/resources/centro-de-llamadas.png")));
		lblSoporte.setHorizontalTextPosition(SwingConstants.LEADING);
		lblSoporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSoporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Soporte s;
				try {
					s = new Soporte(c, TransaccionesBD.getTransacciones(c, usuario_logeado));
					s.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();

			}
			@Override
			public void mouseEntered(MouseEvent e) {

				lblSoporte.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSoporte.setForeground(Color.BLACK);
			}
		});
		lblSoporte.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblSoporte);
		
		JLabel lblCerrarSesion = new JLabel("Cerrar Sesion ");
		lblCerrarSesion.setHorizontalTextPosition(SwingConstants.LEADING);
		lblCerrarSesion.setIcon(new ImageIcon(Principal.class.getResource("/resources/cerrar-sesion.png")));
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio i = new Inicio();
				i.show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrarSesion.setForeground(Color.BLACK);
			}
		});
		lblCerrarSesion.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		mnNewMenu.add(lblCerrarSesion);
		

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Principal.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, -32, 484, 550);
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

				Editor ed = null;
				try {
					ed = new Editor(trans);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ed.show();
				dispose();

			}
		});
		panel.setLayout(gl_panel);
		if(trans.getTipo().equals("I")) {
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
