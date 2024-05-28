package pack;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Filtros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	int tamañoMinimo = 90;
	int numSeleccionados = 0;
	Categoria catSelect = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Filtros(Cuenta c, Usuario usuario_logeado) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setIcon(new ImageIcon(Editor.class.getResource("/resources/izquierda (1).png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 64, 64);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Principal p = new Principal(c.getUser(), true);
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();

			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 274, 484, 287);
		contentPane.add(scrollPane_1);
		
		JPanel panelCategorias = new JPanel();
		scrollPane_1.setViewportView(panelCategorias);
		panelCategorias.setBackground(new Color(204, 255, 255));
		panelCategorias.setLayout(new GridLayout(0, 5, 0, 0));
		
		ArrayList<Categoria> categoriaArray = CategoriasBD.getCategorias(usuario_logeado);
		
		for (int i = 0; i < categoriaArray.size(); i++) {

			JPanel nuevo = new JPanel();
			nuevo.setPreferredSize(new Dimension(tamañoMinimo,tamañoMinimo));
			nuevo.setLayout(new BorderLayout());
			JLabel labelFoto = new JLabel("");
			labelFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
			labelFoto.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/"+categoriaArray.get(i).getRuta())));
			nuevo.add(labelFoto);
			nuevo.setBackground(new Color(204, 255, 255));
			panelCategorias.add(nuevo);

			Categoria actual = categoriaArray.get(i);
			nuevo.addMouseListener(new MouseAdapter() {

				int toques = 0;
				@Override
				public void mouseClicked(MouseEvent e) {
					toques++;
					if(toques%2 == 0) {
						numSeleccionados--;
						nuevo.setBackground(new Color(204, 255, 255));
					}else {
						numSeleccionados++;
						nuevo.setBackground(new Color(255, 255, 129));
						catSelect = new Categoria(actual.getNombre(), usuario_logeado, actual.getRuta());
					}
				}
			});

		}
		
		JRadioButton redioButtonIngreso = new JRadioButton("Ingreso");
		redioButtonIngreso.setForeground(Color.WHITE);
		redioButtonIngreso.setFont(new Font("Consolas", Font.PLAIN, 15));
		redioButtonIngreso.setContentAreaFilled(false);
		redioButtonIngreso.setBounds(141, 200, 85, 23);
		contentPane.add(redioButtonIngreso);
		
		JRadioButton redioButtonGasto = new JRadioButton("Gasto");
		redioButtonGasto.setForeground(Color.WHITE);
		redioButtonGasto.setFont(new Font("Consolas", Font.PLAIN, 15));
		redioButtonGasto.setContentAreaFilled(false);
		redioButtonGasto.setBounds(236, 200, 85, 23);
		contentPane.add(redioButtonGasto);
		
		JLabel lblNewLabel_2 = new JLabel("Filtros");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 464, 78);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(236, 140, 150, 20);
		contentPane.add(textField_2);
		
		textField = new JTextField();
		textField.setBounds(236, 104, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Filtrar por fecha:");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(76, 136, 150, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Filtrar por tipo:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(76, 168, 310, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Filtrar por categoria:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(76, 238, 310, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Filtrar por cantidad:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(76, 100, 150, 25);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnAtras);
		
		ButtonGroup ingresosGastos = new ButtonGroup();
		ingresosGastos.add(redioButtonGasto);
		ingresosGastos.add(redioButtonIngreso);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Filtros.class.getResource("/resources/fondoPizarra.jpg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel);
	}
}
