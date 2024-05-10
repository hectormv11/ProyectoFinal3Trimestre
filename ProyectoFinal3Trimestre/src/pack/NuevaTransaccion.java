package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Cursor;

public class NuevaTransaccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NuevaTransaccion(Usuario usuario_logeado, Cuenta c) throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 464, 64);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabel_1_1_1 = new JLabel("Comentario:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 159, 464, 20);
		contentPane.add(lblNewLabel_1_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 127, 155, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("Categorias:");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 253, 464, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Cuentas:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 91, 172, 20);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 89, 155, 22);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("EUR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(290, 51, 57, 24);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(192, 51, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 274, 484, 287);
		contentPane.add(scrollPane_1);

		JPanel panelprincipal = new JPanel();
		scrollPane_1.setViewportView(panelprincipal);
		panelprincipal.setBackground(new Color(204, 255, 255));
		panelprincipal.setLayout(new GridLayout(0, 5, 0, 0));
		
		
		JPanel panelAñadir = new JPanel();
		panelAñadir.setPreferredSize(new Dimension(95,95)); // Establecer tamaño mínimo
		panelAñadir.setLayout(new BorderLayout()); // Layout para centrar componentes si es necesario
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cartera.png")));
		panelAñadir.add(lblNewLabel_3_1);
		panelAñadir.setBackground(new Color(204, 255, 255));
		panelprincipal.add(panelAñadir);
		
		Transaccion[] trans = TransaccionesBD.getTransacciones(c, usuario_logeado);
		
		for (int i = 0; i < 99; i++) {
			JPanel nuevo = createFixedSizePanel(95,95);
			nuevo.setBackground(new Color(204, 255, 255));
			panelprincipal.add(nuevo);
		}
		
		panelAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JPanel jp = createFixedSizePanel(95,95);
				jp.setBackground(new Color(204, 255, 255));
				panelprincipal.add(jp);
				panelprincipal.setVisible(false);
				panelprincipal.setVisible(true);
			}
		});

		/*JLabel lblNewLabel_3_7_1_1_1 = new JLabel("");
		lblNewLabel_3_7_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_7_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JLabel añadido = new JLabel("");
				añadido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				añadido.setHorizontalAlignment(SwingConstants.CENTER);
				añadido.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/agregar.png")));
				panel.add(añadido);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		lblNewLabel_3_7_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7_1_1_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/agregar.png")));
		panel.add(lblNewLabel_3_7_1_1_1);*/

		/*JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cartera.png")));
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cesta-de-la-compra.png")));
		panel.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/hogar.png")));
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_7_1 = new JLabel("");
		lblNewLabel_3_7_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/caja-de-regalo.png")));
		panel.add(lblNewLabel_3_7_1);


		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/latido-del-corazon (1).png")));
		panel.add(lblNewLabel_3_3);


		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/educacion.png")));
		panel.add(lblNewLabel_3_2);


		JLabel lblNewLabel_3_7 = new JLabel("");
		lblNewLabel_3_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/plato.png")));
		panel.add(lblNewLabel_3_7);

		JLabel lblNewLabel_3_8 = new JLabel("");
		lblNewLabel_3_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_8.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/gasolina.png")));
		panel.add(lblNewLabel_3_8);

		JLabel lblNewLabel_3_7_1_1 = new JLabel("");
		lblNewLabel_3_7_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7_1_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/pregunta (1).png")));
		panel.add(lblNewLabel_3_7_1_1);*/
		
		

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}
	
	private JPanel createFixedSizePanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height)); // Establecer tamaño mínimo
		panel.setLayout(new BorderLayout()); // Layout para centrar componentes si es necesario
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cartera.png")));
		panel.add(lblNewLabel_3_1);
		return panel;
	}
	
	
}
