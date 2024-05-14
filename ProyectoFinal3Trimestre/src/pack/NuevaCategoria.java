package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NuevaCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaCategoria frame = new NuevaCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuevaCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
	public void guardar(int tamañoMinimo, JPanel panelprincipal) {
		
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
	
	/*private JPanel createFixedSizePanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height)); // Establecer tamaño mínimo
		panel.setLayout(new BorderLayout()); // Layout para centrar componentes si es necesario
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cartera.png")));
		panel.add(lblNewLabel_3_1);
		return panel;
	}*/

	private static void copiarArchivo(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}

}
