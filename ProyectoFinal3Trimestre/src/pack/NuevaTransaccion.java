package pack;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.SQLException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;

import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.Toolkit;

public class NuevaTransaccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtYyyymmdd;
	int tamañoMinimo = 90;
	int numSeleccionados = 0;
	Categoria catSelect = null;
	String nombreDelArchivo = "";
	String tipo = "";


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NuevaTransaccion(Usuario usuario_logeado, Cuenta c) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevaTransaccion.class.getResource("/resources/presupuesto (1).png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel linkLabelIconos = new JLabel("<html><a href=''>Sugerencia de iconos para tus nuevas categorias\r\n</a></html>");
		linkLabelIconos.setFont(new Font("Dialog", Font.PLAIN, 15));
		linkLabelIconos.setForeground(new Color(255, 255, 255));
		linkLabelIconos.setBackground(new Color(255, 255, 255));
		linkLabelIconos.setHorizontalAlignment(SwingConstants.CENTER);
		linkLabelIconos.setBounds(10, 187, 464, 20);
		linkLabelIconos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		linkLabelIconos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirEnlace("https://www.flaticon.es/");
			}
		});
		
		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Principal p = new Principal(usuario_logeado, false, null,"Ningun filtro aplicado");
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				
			}
		});
		btnAtras.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/izquierda (1).png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 16, 64, 64);
		contentPane.add(btnAtras);

		// Añadir el JLabel al JFrame
		getContentPane().add(linkLabelIconos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 464, 34);
		contentPane.add(scrollPane);

		JTextArea textAreaComentario = new JTextArea();
		scrollPane.setViewportView(textAreaComentario);

		JLabel textoComentario = new JLabel("Comentario:");
		textoComentario.setHorizontalAlignment(SwingConstants.CENTER);
		textoComentario.setForeground(Color.WHITE);
		textoComentario.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoComentario.setBounds(10, 123, 464, 20);
		contentPane.add(textoComentario);

		txtYyyymmdd = new JTextField();
		txtYyyymmdd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if(txtYyyymmdd.getText().equals("")) {
					txtYyyymmdd.setText("2000-12-31");
				}

			}
		});
		txtYyyymmdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtYyyymmdd.getText().equals("2000-12-31")) {
					txtYyyymmdd.setText("");
				}
			}
		});
		txtYyyymmdd.setText("2000-12-31");
		txtYyyymmdd.setColumns(10);
		txtYyyymmdd.setBounds(176, 91, 133, 20);
		contentPane.add(txtYyyymmdd);
		((AbstractDocument) txtYyyymmdd.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9-]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");
				}
			}
		});
		txtYyyymmdd.setToolTipText("El campo fecha solo puede contener números y guiones con el formato yyyy-mm-dd.");

		JLabel textoCategorias = new JLabel("Categorias:");
		textoCategorias.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoCategorias.setForeground(new Color(255, 255, 255));
		textoCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		textoCategorias.setBounds(10, 213, 464, 20);
		contentPane.add(textoCategorias);

		JLabel textoDivisa = new JLabel("EUR");
		textoDivisa.setHorizontalAlignment(SwingConstants.CENTER);
		textoDivisa.setFont(new Font("Consolas", Font.PLAIN, 20));
		textoDivisa.setForeground(new Color(255, 255, 255));
		textoDivisa.setBounds(263, 56, 57, 24);
		contentPane.add(textoDivisa);

		textField = new JTextField();
		textField.setBounds(176, 55, 85, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9.]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo cantidad solo puede contener números.");
				}
			}
		});
		textField.setToolTipText("El campo cantidad solo puede contener números.");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 238, 484, 287);
		contentPane.add(scrollPane_1);

		JPanel panelCategorias = new JPanel();
		scrollPane_1.setViewportView(panelCategorias);
		panelCategorias.setBackground(new Color(204, 255, 255));
		panelCategorias.setLayout(new GridLayout(0, 5, 0, 0));


		JPanel panelAñadir = new JPanel();
		panelAñadir.setPreferredSize(new Dimension(tamañoMinimo,tamañoMinimo)); // Establecer tamaño mínimo
		panelAñadir.setLayout(new BorderLayout()); // Layout para centrar componentes si es necesario
		JLabel lblPorDefecto = new JLabel("");
		lblPorDefecto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPorDefecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorDefecto.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/agregar.png")));
		panelAñadir.add(lblPorDefecto);
		panelAñadir.setBackground(new Color(204, 255, 255));
		panelCategorias.add(panelAñadir);

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

		panelAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JPanel añadido = new JPanel();
				añadido.setPreferredSize(new Dimension(tamañoMinimo,tamañoMinimo));
				añadido.setLayout(new BorderLayout());
				JLabel lblNewLabel_3_1 = new JLabel("");
				lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);

				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Imágenes PNG y JPG", "jpg", "png"); //Creamos un filtro de archivos
				chooser.setFileFilter(filter); //Aplicamos el filtro de archivos
				int returnVal = chooser.showOpenDialog(contentPane); //Abrimos el selector de archivos

				String nombreArchivo = "";

				if(returnVal == JFileChooser.APPROVE_OPTION) { //si se selecciona correctamente el archivo

					nombreArchivo = chooser.getSelectedFile().getName(); //ejemplo: foto.png
					String rutaArchivo = chooser.getSelectedFile().getAbsolutePath(); //ejemplo: C:/User/Pablo/Escritorio/foto.png

					File origen = new File(rutaArchivo);//archivo de origen
					File destino = new File(NuevaTransaccion.class.getResource("/resources/").getPath()+nombreArchivo);//archivo de destino

					//genero un numero aleatorio y le cambio el nombre para que las imagenes no tengan el mismo nombre de ruta
					Random random = new Random();
					int numeroAleatorio = 10000 + random.nextInt(99999);

					String rutaArchivoNuevo = NuevaTransaccion.class.getResource("/resources/").getPath()+numeroAleatorio+".png";
					File archivoNuevo = new File(rutaArchivoNuevo);

					destino.renameTo(archivoNuevo);

					//copio el archivo a la carpeta del proyecto
					if(copiarArchivo(origen, destino) == 0) {

						JOptionPane.showMessageDialog(null, "Problema desconocido, intentelo de nuevo");

					}else {
						System.out.println(archivoNuevo.getName());
						NuevaCategoria nv = new NuevaCategoria(archivoNuevo.getName(), usuario_logeado, c);
						nv.show();
						dispose();
					}

				}else {
					System.out.println("-------");
				}

			}
		});
		

		JRadioButton redioButtonIngreso = new JRadioButton("Ingreso");
		redioButtonIngreso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(redioButtonIngreso.isSelected()) {
					tipo = "I";
				}
			}
		});
		redioButtonIngreso.setFont(new Font("Consolas", Font.PLAIN, 15));
		redioButtonIngreso.setForeground(new Color(255, 255, 255));
		redioButtonIngreso.setContentAreaFilled(false);
		redioButtonIngreso.setBounds(326, 54, 85, 23);
		contentPane.add(redioButtonIngreso);

		JRadioButton redioButtonGasto = new JRadioButton("Gasto");
		redioButtonGasto.setFont(new Font("Consolas", Font.PLAIN, 15));
		redioButtonGasto.setForeground(new Color(255, 255, 255));
		redioButtonGasto.setContentAreaFilled(false);
		redioButtonGasto.setBounds(326, 93, 85, 23);
		contentPane.add(redioButtonGasto);
		
		redioButtonGasto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(redioButtonGasto.isSelected()) {
					tipo = "G";
				}
			}
		});

		ButtonGroup ingresosGastos = new ButtonGroup();
		ingresosGastos.add(redioButtonGasto);
		ingresosGastos.add(redioButtonIngreso);

		JButton botonAñadir = new JButton("Añadir");
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double numero = 0;

				if(numSeleccionados == 1 && !txtYyyymmdd.getText().equals("") && !txtYyyymmdd.getText().equals("2000-12-31") && (redioButtonIngreso.isSelected() || redioButtonGasto.isSelected())) {

					if(!textField.getText().equals("")) {
						numero = Double.parseDouble(textField.getText());
					}
					String fechaStr = txtYyyymmdd.getText();  // La cadena que representa la fecha en formato yyyy-MM-dd
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
					Transaccion trans = new Transaccion(0,numero, c, catSelect, sqlDate, textAreaComentario.getText(), tipo);
					try {
						if(numero != 0) {
							TransaccionesBD.añadirTransaccion(trans);
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					
					double saldoActualizado = c.getSaldo();
					
					if(tipo.equals("I")) {
						saldoActualizado += Double.parseDouble(textField.getText());
					}else {
						saldoActualizado -= Double.parseDouble(textField.getText());
					}
					
					try {
						CuentasBD.actualizarCuenta(c.getNombre(), c, saldoActualizado);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error inesperado");
						return;

					}

					try {
						if(numero != 0) {
							Principal p = new Principal(usuario_logeado,false, null,"Ningun filtro aplicado");
							p.show();
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Algun campo vacio");
						}

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}else if(numSeleccionados > 1){
					JOptionPane.showMessageDialog(null, "Más de una categoria seleccionada");
				}else {
					JOptionPane.showMessageDialog(null, "Algun campo vacio o fecha de ejemplo usada");
				}
				
			}
		});
		botonAñadir.setBounds(192, 531, 89, 23);
		contentPane.add(botonAñadir);

		JLabel textoFecha = new JLabel("Fecha:");
		textoFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		textoFecha.setForeground(Color.WHITE);
		textoFecha.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoFecha.setBounds(77, 92, 89, 20);
		contentPane.add(textoFecha);

		JLabel textoCantidad = new JLabel("Canidad:");
		textoCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCantidad.setForeground(Color.WHITE);
		textoCantidad.setFont(new Font("Consolas", Font.PLAIN, 15));
		textoCantidad.setBounds(77, 56, 89, 20);
		contentPane.add(textoCantidad);

		JLabel textoNuevaTransaccion = new JLabel("Nueva transacción");
		textoNuevaTransaccion.setHorizontalAlignment(SwingConstants.CENTER);
		textoNuevaTransaccion.setForeground(Color.WHITE);
		textoNuevaTransaccion.setFont(new Font("Consolas", Font.PLAIN, 20));
		textoNuevaTransaccion.setBounds(84, 11, 327, 34);
		contentPane.add(textoNuevaTransaccion);

		JLabel linkLabel_1 = new JLabel("");
		linkLabel_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/maxresdefault (1).jpg")));
		linkLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		linkLabel_1.setForeground(Color.WHITE);
		linkLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		linkLabel_1.setBackground(Color.WHITE);
		linkLabel_1.setBounds(10, 188, 464, 20);
		contentPane.add(linkLabel_1);


		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}

	private static int copiarArchivo(File source, File dest) {
		try {
			Files.copy(source.toPath(), dest.toPath());
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	private void abrirEnlace(String url) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
