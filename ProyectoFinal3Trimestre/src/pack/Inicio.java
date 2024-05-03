package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Inicio extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("LA HUCHA DEL C€RDITO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/resources/presupuesto (1).png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Registro = new JButton("Registrarse");
		Registro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Registro.setBorderPainted(false);
		Registro.setForeground(new Color(255, 255, 255));
		Registro.setFont(new Font("Consolas", Font.PLAIN, 15));
		Registro.setBackground(new Color(0, 16, 53));
		Registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				registro.show();
				dispose();
				
			}
		});
		Registro.setBounds(159, 361, 170, 50);
		contentPane.add(Registro);
		
		JButton iniciarSesion = new JButton("Inicio de sesión");
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciarSesion.setForeground(new Color(255, 255, 255));
		iniciarSesion.setFont(new Font("Consolas", Font.PLAIN, 15));
		iniciarSesion.setBackground(new Color(0, 16, 53));
		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InicioSesion inicioSesion = new InicioSesion();
				inicioSesion.show();
				dispose();
				
			}
		});
		iniciarSesion.setBounds(159, 300, 170, 50);
		contentPane.add(iniciarSesion);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/resources/_de3cce87-5082-4ac5-9301-938179dc1a2b (2).jpg")));
		lblNewLabel.setBounds(178, 131, 128, 128);
		contentPane.add(lblNewLabel);
		
		JLabel nombreAplicacion = new JLabel(".");
		nombreAplicacion.setFont(new Font("Consolas", Font.PLAIN, 15));
		nombreAplicacion.setHorizontalAlignment(SwingConstants.CENTER);
		nombreAplicacion.setBounds(159, 77, 170, 43);
		contentPane.add(nombreAplicacion);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Inicio.class.getResource("/resources/fondo-pantalla-fondo-concepto-negocio-patrones-fisuras-finanzas-o-economia_78677-9986 (1) (1).jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}
}
