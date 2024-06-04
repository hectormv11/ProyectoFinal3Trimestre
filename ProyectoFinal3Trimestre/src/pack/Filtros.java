package pack;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;


public class Filtros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtroCantidad;
	private JTextField filtroFecha;
	int tamañoMinimo = 90;
	int numSeleccionados = 0;
	Categoria catSelect = null;
	String tipo = "";

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Filtros(Cuenta c, Usuario usuario_logeado) throws SQLException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Filtros.class.getResource("/resources/presupuesto (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



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
		lblNewLabel_2.setBounds(84, 11, 316, 78);
		contentPane.add(lblNewLabel_2);

		filtroFecha = new JTextField();
		filtroFecha.setColumns(10);
		filtroFecha.setBounds(236, 140, 150, 20);
		contentPane.add(filtroFecha);
		((AbstractDocument) filtroFecha.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9-]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");
				}
			}
		});
		filtroFecha.setToolTipText("El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");
		filtroFecha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if(filtroFecha.getText().equals("")) {
					filtroFecha.setText("2000-12-31");
				}

			}
		});
		filtroFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(filtroFecha.getText().equals("2000-12-31")) {
					filtroFecha.setText("");
				}
			}
		});
		filtroFecha.setText("2000-12-31");

		filtroCantidad = new JTextField();
		filtroCantidad.setBounds(236, 104, 150, 20);
		contentPane.add(filtroCantidad);
		filtroCantidad.setColumns(10);
		filtroCantidad.setText("0.0");
		((AbstractDocument) filtroCantidad.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9.]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo cantidad solo puede contener números.");
				}
			}
		});
		filtroCantidad.setToolTipText("El campo cantidad solo puede contener números.");
		filtroCantidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if(filtroCantidad.getText().equals("")) {
					filtroCantidad.setText("0.0");
				}

			}
		});
		filtroCantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(filtroCantidad.getText().equals("0.0")) {
					filtroCantidad.setText("");
				}
			}
		});

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

		ButtonGroup ingresosGastos = new ButtonGroup();
		ingresosGastos.add(redioButtonGasto);
		ingresosGastos.add(redioButtonIngreso);

		redioButtonIngreso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(redioButtonIngreso.isSelected()) {
					tipo = "I";
				}

			}
		});
		redioButtonGasto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(redioButtonGasto.isSelected()) {
					tipo = "G";
				}
			}
		});


		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setIcon(new ImageIcon(Editor.class.getResource("/resources/izquierda (1).png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 64, 64);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cantidad = Double.parseDouble(filtroCantidad.getText());
				Date utilDate = null;
				if(!filtroFecha.getText().equals("2000-12-31")) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dateString = filtroFecha.getText();
					try {
						LocalDate localDate = LocalDate.parse(dateString,formatter);  // Convierte la cadena a LocalDate
						utilDate = Date.valueOf(localDate);  // Convierte LocalDate a java.sql.Date

					} catch (DateTimeParseException e1) {
						JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
						return;
						// Maneja la excepción si la cadena no tiene el formato correcto
					}
				}
				
				String frase = "Ningun filtro aplicado";
				int aplicados = 0;
				
				if(cantidad != 0.0 || utilDate != null || catSelect != null || !tipo.equals("")) {
					aplicados = 1;
				}
				
				if(aplicados != 0) {
					frase = "- Filtros apicados: ";
				}
				
				if(cantidad != 0.0) {
					frase += "Cantidad -";
				}
				if(utilDate != null) {
					frase += " fecha -";
				}
				if(catSelect != null) {
					frase += " categoria -";
				}
				if(!tipo.equals("")) {
					frase += " tipo -";
				}

				try {
					Principal p = new Principal(c.getUser(), true, TransaccionesBD.getTansFiltros(usuario_logeado, c, cantidad, utilDate, catSelect, tipo), frase);
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dispose();

			}
		});
		contentPane.add(btnAtras);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Filtros.class.getResource("/resources/fondoPizarra.jpg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel);
	}
}
