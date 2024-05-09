package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class NuevaTransaccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaTransaccion frame = new NuevaTransaccion();
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
	public NuevaTransaccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 13, 454, 157);
		contentPane.add(panel_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 454, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 157, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
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
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setBackground(new Color(204, 255, 255));
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		
		
		
		
		JLabel lblNewLabel_3_7_1_1_1 = new JLabel("");
		lblNewLabel_3_7_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JLabel añadido = new JLabel("");
				añadido.setHorizontalAlignment(SwingConstants.CENTER);
				añadido.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/agregar.png")));
				panel.add(añadido);
				panel.setVisible(false);
				panel.setVisible(true);
				añadido.setMinimumSize(new Dimension(120, 120));
			}
		});
		lblNewLabel_3_7_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7_1_1_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/agregar.png")));
		panel.add(lblNewLabel_3_7_1_1_1);
		lblNewLabel_3_7_1_1_1.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cartera.png")));
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/cesta-de-la-compra.png")));
		panel.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/hogar.png")));
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_7_1 = new JLabel("");
		lblNewLabel_3_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/caja-de-regalo.png")));
		panel.add(lblNewLabel_3_7_1);
		lblNewLabel_3_7_1.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/latido-del-corazon (1).png")));
		panel.add(lblNewLabel_3_3);
		lblNewLabel_3_3.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/educacion.png")));
		panel.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_7 = new JLabel("");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/plato.png")));
		panel.add(lblNewLabel_3_7);
		lblNewLabel_3_7.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_8 = new JLabel("");
		lblNewLabel_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_8.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/gasolina.png")));
		panel.add(lblNewLabel_3_8);
		lblNewLabel_3_8.setMinimumSize(new Dimension(95, 95));
		
		JLabel lblNewLabel_3_7_1_1 = new JLabel("");
		lblNewLabel_3_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7_1_1.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/pregunta (1).png")));
		panel.add(lblNewLabel_3_7_1_1);
		lblNewLabel_3_7_1_1.setMinimumSize(new Dimension(95, 95));
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(NuevaTransaccion.class.getResource("/resources/fondoPizarra.jpg")));
		fondo.setBounds(0, 0, 484, 561);
		contentPane.add(fondo);
	}
}
