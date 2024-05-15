package pack;

import java.awt.EventQueue;

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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;

import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NuevaTransaccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 464, 64);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabel_1_1_1 = new JLabel("Comentario:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 123, 464, 20);
		contentPane.add(lblNewLabel_1_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 91, 155, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("Categorias:");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 217, 464, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Cuenta:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(23, 55, 89, 20);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(122, 53, 155, 22);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("EUR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(279, 19, 57, 24);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(192, 18, 85, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 238, 484, 287);
		contentPane.add(scrollPane_1);

		JPanel panelprincipal = new JPanel();
		scrollPane_1.setViewportView(panelprincipal);
		panelprincipal.setBackground(new Color(204, 255, 255));
		panelprincipal.setLayout(new GridLayout(0, 5, 0, 0));


		JPanel panelAñadir = new JPanel();
		panelAñadir.setPreferredSize(new Dimension(tamañoMinimo,tamañoMinimo)); // Establecer tamaño mínimo
		panelAñadir.setLayout(new BorderLayout()); // Layout para centrar componentes si es necesario
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/agregar.png")));
		panelAñadir.add(lblNewLabel_3_1);
		panelAñadir.setBackground(new Color(204, 255, 255));
		panelprincipal.add(panelAñadir);

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
			panelprincipal.add(nuevo);
			
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
					//textArea.append("Copiando a la carpeta \"resources\"...");
					File origen = new File(rutaArchivo);
					File destino = new File(NuevaTransaccion.class.getResource("/resources/").getPath()+nombreArchivo);
					//textArea.append("\n");

					NuevaCategoria nv = new NuevaCategoria(nombreArchivo, usuario_logeado);
					nv.show();

					try {
						copiarArchivo(origen, destino); //copiamos el archivo
						//textArea.append("COPIADO!");
					} catch (IOException e1) {
						//e1.printStackTrace();
					}

					lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/"+nombreArchivo)));
					añadido.add(lblNewLabel_3_1);
					añadido.setBackground(new Color(204, 255, 255));
					panelprincipal.add(añadido);
					panelprincipal.setVisible(false);
					panelprincipal.setVisible(true);

					nombreDelArchivo = nombreArchivo;

					lblNewLabel_3_1.addMouseListener(new MouseAdapter() {

						int toques = 0;
						@Override
						public void mouseClicked(MouseEvent e) {
							toques++;
							if(toques%2 == 0) {
								numSeleccionados--;
								lblNewLabel_3_1.setBackground(new Color(204, 255, 255));
							}else {
								numSeleccionados++;
								lblNewLabel_3_1.setBackground(new Color(255, 255, 129));
								catSelect = new Categoria(NuevaCategoria.getTexto(), usuario_logeado, nombreDelArchivo);
							}
						}
					});


				}else {
					//si se cancela la subida
					//...
				}

			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ingreso");
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					tipo = "I";
				}else {
					tipo = "G";
				}

			}
		});
		rdbtnNewRadioButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setContentAreaFilled(false);
		rdbtnNewRadioButton.setBounds(316, 53, 158, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Gasto");
		rdbtnNewRadioButton_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setContentAreaFilled(false);
		rdbtnNewRadioButton_1.setBounds(316, 90, 158, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		ButtonGroup ingresosGastos = new ButtonGroup();
		ingresosGastos.add(rdbtnNewRadioButton_1);
		ingresosGastos.add(rdbtnNewRadioButton);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double numero = 0;
				
				if(numSeleccionados == 1) {
					
					if(!textField.getText().equals("")) {
						numero = Double.parseDouble(textField.getText());
					}
					String fechaStr = textField_1.getText();  // La cadena que representa la fecha en formato yyyy-MM-dd
			        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");  // Define el formato de la fecha
			        Date sqlDate = null;
			        try {
			            LocalDate localDate = LocalDate.parse(fechaStr, formato);  // Convierte la cadena a LocalDate
			            sqlDate = Date.valueOf(localDate);  // Convierte LocalDate a java.sql.Date
			           
			        } catch (DateTimeParseException e1) {
			            e1.printStackTrace();  // Maneja la excepción si la cadena no tiene el formato correcto
			        }
			        Transaccion trans = new Transaccion(0,numero, c, catSelect, sqlDate, textArea.getText(), tipo);
					try {
						TransaccionesBD.añadirTransaccion(trans);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						Principal p = new Principal(usuario_logeado);
						p.show();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(numSeleccionados == 0 || numero == 0 || textField_1.getText().equals("") || (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected())){
					JOptionPane.showMessageDialog(null, "Algun campo vacio");
				}else {
					JOptionPane.showMessageDialog(null, "Más de una categoria seleccionada");
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(192, 531, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_1 = new JLabel("Fecha:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(23, 92, 89, 20);
		contentPane.add(lblNewLabel_1_1);

		


		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}

	private static void copiarArchivo(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}

}
