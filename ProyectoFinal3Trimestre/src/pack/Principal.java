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
import javax.swing.border.EtchedBorder;
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
import java.text.SimpleDateFormat;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
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
		
		JLabel lblNewLabel_6_1 = new JLabel("Ultimas transacciones");
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_6_1.setBounds(111, 39, 263, 40);
		panelTransacciones.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(Principal.class.getResource("/resources/documento.png")));
		lblNewLabel_6.setBounds(210, 440, 64, 64);
		panelTransacciones.add(lblNewLabel_6);
		
		JPanel panelContenedor = new JPanel();
		panelContenedor.setBounds(10, 87, 464, 342);
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
					// TODO Auto-generated catch block
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
	
    /*public JPanel getExamplePanel(Transaccion trans) {
        JPanel examplePanel = new JPanel();
        examplePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

        JLabel cantidadLabel = new JLabel("Cantidad:");
        JLabel cantidadValueLabel = new JLabel(String.valueOf(trans.getCantidad()));

        JLabel categoriaLabel = new JLabel("Categoría:");
        JLabel categoriaValueLabel = new JLabel(trans.getCat().getNombre());

        JLabel comentarioLabel = new JLabel("Comentario:");
        JLabel comentarioValueLabel = new JLabel(trans.getComentario());

        JLabel fechaLabel = new JLabel("Fecha:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JLabel fechaValueLabel = new JLabel(dateFormat.format(trans.getFecha()));

        GroupLayout layout = new GroupLayout(examplePanel);
        examplePanel.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cantidadLabel)
                        .addComponent(categoriaLabel)
                        .addComponent(comentarioLabel)
                        .addComponent(fechaLabel))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cantidadValueLabel)
                        .addComponent(categoriaValueLabel)
                        .addComponent(comentarioValueLabel)
                        .addComponent(fechaValueLabel))
                    .addContainerGap(150, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cantidadLabel)
                        .addComponent(cantidadValueLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(categoriaLabel)
                        .addComponent(categoriaValueLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comentarioLabel)
                        .addComponent(comentarioValueLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaLabel)
                        .addComponent(fechaValueLabel))
                    .addContainerGap(26, Short.MAX_VALUE))
        );

        return examplePanel;
    }*/
	
	public JPanel getExamplePanel(Transaccion trans) {
		
		JPanel examplePanel = new JPanel();
        examplePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

        JLabel cantidadLabel = new JLabel("Cantidad:");
        JLabel cantidadValueLabel = new JLabel(String.valueOf(trans.getCantidad()));

        JLabel categoriaLabel = new JLabel("Categoría:");
        JLabel categoriaValueLabel = new JLabel(trans.getCat().getNombre());

        JLabel comentarioLabel = new JLabel("Comentario:");
        JLabel comentarioValueLabel = new JLabel(trans.getComentario());

        JLabel fechaLabel = new JLabel("Fecha:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JLabel fechaValueLabel = new JLabel(dateFormat.format(trans.getFecha()));

        GroupLayout layout = new GroupLayout(examplePanel);
        examplePanel.setLayout(layout);

        JButton boton = new JButton("Editar");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	
            
            }
        });

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadLabel)
                            .addComponent(categoriaLabel)
                            .addComponent(comentarioLabel)
                            .addComponent(fechaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadValueLabel)
                            .addComponent(categoriaValueLabel)
                            .addComponent(comentarioValueLabel)
                            .addComponent(fechaValueLabel))
                        .addContainerGap(150, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(250, Short.MAX_VALUE)
                        .addComponent(boton)
                        .addContainerGap())
            );

            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cantidadLabel)
                            .addComponent(cantidadValueLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(categoriaLabel)
                            .addComponent(categoriaValueLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comentarioLabel)
                            .addComponent(comentarioValueLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaLabel)
                            .addComponent(fechaValueLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton)
                        .addContainerGap())
        );
		return examplePanel;
    }
	
}
