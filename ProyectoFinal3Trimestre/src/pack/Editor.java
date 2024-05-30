package pack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
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
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class Editor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTextField textFieldFecha;
	int tamañoMinimo = 90;
	int numSeleccionados = 0;
	Categoria catSelect = null;
	String tipo = "";
	Transaccion nueva = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Editor(Transaccion trans) throws SQLException {

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
					Principal p = new Principal(trans.getCuenta().getUser(),false, null,"Ningun filtro aplicado");
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dispose();

			}
		});
		contentPane.add(btnAtras);

		textFieldCantidad = new JTextField();
		textFieldCantidad.setToolTipText("El campo cantidad solo puede contener números.");
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(177, 55, 85, 20);
		textFieldCantidad.setText(trans.getCantidad()+"");
		((AbstractDocument) textFieldCantidad.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9.]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo cantidad solo puede contener números.");
				}
			}
		});
		textFieldCantidad.setToolTipText("El campo cantidad solo puede contener números.");
		contentPane.add(textFieldCantidad);

		JLabel textoCantidad = new JLabel("Canidad:");
		textoCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCantidad.setForeground(Color.WHITE);
		textoCantidad.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoCantidad.setBounds(78, 56, 89, 20);
		contentPane.add(textoCantidad);

		JLabel lblEditarTransaccion = new JLabel("Editar transaccion");
		lblEditarTransaccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarTransaccion.setForeground(Color.WHITE);
		lblEditarTransaccion.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblEditarTransaccion.setBounds(84, 10, 327, 34);
		contentPane.add(lblEditarTransaccion);

		JLabel textoDivisa = new JLabel("EUR");
		textoDivisa.setHorizontalAlignment(SwingConstants.CENTER);
		textoDivisa.setForeground(Color.WHITE);
		textoDivisa.setFont(new Font("Consolas", Font.PLAIN, 20));
		textoDivisa.setBounds(264, 56, 57, 24);
		contentPane.add(textoDivisa);

		JRadioButton redioButtonIngreso = new JRadioButton("Ingreso");
		redioButtonIngreso.setForeground(Color.WHITE);
		redioButtonIngreso.setFont(new Font("Consolas", Font.PLAIN, 15));
		redioButtonIngreso.setContentAreaFilled(false);
		redioButtonIngreso.setBounds(327, 54, 85, 23);
		contentPane.add(redioButtonIngreso);

		JRadioButton redioButtonGasto = new JRadioButton("Gasto");
		redioButtonGasto.setForeground(Color.WHITE);
		redioButtonGasto.setFont(new Font("Consolas", Font.PLAIN, 15));
		redioButtonGasto.setContentAreaFilled(false);
		redioButtonGasto.setBounds(327, 93, 85, 23);
		contentPane.add(redioButtonGasto);

		textFieldFecha = new JTextField();
		textFieldFecha.setToolTipText("El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");
		textFieldFecha.setText("2000-12-31");
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(177, 91, 133, 20);
		textFieldFecha.setText(trans.getFecha()+"");
		((AbstractDocument) textFieldFecha.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9-]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");
				}
			}
		});
		textFieldFecha.setToolTipText("El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");
		contentPane.add(textFieldFecha);

		JLabel textoFecha = new JLabel("Fecha:");
		textoFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		textoFecha.setForeground(Color.WHITE);
		textoFecha.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoFecha.setBounds(78, 92, 89, 20);
		contentPane.add(textoFecha);

		JLabel textoComentario = new JLabel("Comentario:");
		textoComentario.setHorizontalAlignment(SwingConstants.CENTER);
		textoComentario.setForeground(Color.WHITE);
		textoComentario.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoComentario.setBounds(11, 123, 464, 20);
		contentPane.add(textoComentario);

		JTextArea textAreaComentario = new JTextArea();
		textAreaComentario.setBounds(12, 144, 462, 32);
		textAreaComentario.setText(trans.getComentario());
		contentPane.add(textAreaComentario);

		JLabel linkLabelIconos = new JLabel("<html><a href=''>Sugerencia de iconos para tus nuevas categorias\r\n</a></html>");
		linkLabelIconos.setHorizontalAlignment(SwingConstants.CENTER);
		linkLabelIconos.setForeground(Color.WHITE);
		linkLabelIconos.setFont(new Font("Dialog", Font.PLAIN, 15));
		linkLabelIconos.setBackground(Color.WHITE);
		linkLabelIconos.setBounds(11, 187, 464, 20);
		contentPane.add(linkLabelIconos);

		JLabel textoCategorias = new JLabel("Categorias:");
		textoCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		textoCategorias.setForeground(Color.WHITE);
		textoCategorias.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoCategorias.setBounds(11, 213, 464, 20);
		contentPane.add(textoCategorias);

		JPanel panelCategorias = new JPanel();
		panelCategorias.setBackground(new Color(204, 255, 255));
		panelCategorias.setBounds(1, 239, 482, 285);
		contentPane.add(panelCategorias);
		panelCategorias.setLayout(new GridLayout(0, 5, 0, 0));

		JButton botonAñadir = new JButton("Añadir");
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double numero = 0;
				
				if(numSeleccionados > 1){
					JOptionPane.showMessageDialog(null, "Más de una categoria seleccionada, deseleccione toda y seleccione la que quiera");
					return;
				}

				if(!textFieldCantidad.getText().equals("")) {
					numero = Double.parseDouble(textFieldCantidad.getText());
				}
				String fechaStr = textFieldFecha.getText();  // La cadena que representa la fecha en formato yyyy-MM-dd
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");  // Define el formato de la fecha
				Date sqlDate = null;
				try {
					LocalDate localDate = LocalDate.parse(fechaStr, formato);  // Convierte la cadena a LocalDate
					sqlDate = Date.valueOf(localDate);  // Convierte LocalDate a java.sql.Date

				} catch (DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
					return;
					// Maneja la excepción si la cadena no tiene el formato correcto
				}


				nueva = new Transaccion(trans.getId(),numero, trans.getCuenta(), catSelect, sqlDate, textAreaComentario.getText(), tipo);

				try {
					TransaccionesBD.updateTransaccion(nueva);
					JOptionPane.showMessageDialog(null, "Editado con exito, puede salir de esta ventana");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				

			}
		});
		botonAñadir.setBounds(193, 531, 89, 23);
		contentPane.add(botonAñadir);

		JLabel linkLabel_1 = new JLabel("");
		linkLabel_1.setIcon(new ImageIcon(Editor.class.getResource("/resources/maxresdefault (1).jpg")));
		linkLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		linkLabel_1.setForeground(Color.WHITE);
		linkLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		linkLabel_1.setBackground(Color.WHITE);
		linkLabel_1.setBounds(10, 187, 464, 20);
		contentPane.add(linkLabel_1);

		ButtonGroup ingresosGastos = new ButtonGroup();
		ingresosGastos.add(redioButtonGasto);
		ingresosGastos.add(redioButtonIngreso);
		if(trans.getTipo().equals("I")) {
			tipo = "I";
			redioButtonIngreso.setSelected(true);
			redioButtonGasto.setSelected(false);
		}else {
			tipo = "G";
			redioButtonGasto.setSelected(true);
			redioButtonIngreso.setSelected(false);
		}


		ArrayList<Categoria> categoriaArray = CategoriasBD.getCategorias(trans.getCuenta().getUser());

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
						catSelect = new Categoria(actual.getNombre(), trans.getCuenta().getUser(), actual.getRuta());
					}
				}
			});

		}



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

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Editor.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}
}
