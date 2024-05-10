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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Cursor;

public class NuevaTransaccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int tamañoMinimo = 90;

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
					
					try {
						copiarArchivo(origen, destino); //copiamos el archivo
						//textArea.append("COPIADO!");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/"+nombreArchivo)));
					añadido.add(lblNewLabel_3_1);
					añadido.setBackground(new Color(204, 255, 255));
					panelprincipal.add(añadido);
					panelprincipal.setVisible(false);
					panelprincipal.setVisible(true);

					
				}else {
					//si se cancela la subida
					//...
				}
				
				
				
				
			}
		});


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

	private static void copiarArchivo(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}

}
