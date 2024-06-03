package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

public class Ajustes extends JFrame {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Ajustes(Usuario user, Transaccion trans) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		
		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setBounds(10, 11, 64, 64);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Principal p = new Principal(user,false,null,"Ningun filtro aplicado");
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();

			}
		});
		getContentPane().setLayout(null);
		btnAtras.setIcon(new ImageIcon(Ajustes.class.getResource("/resources/izquierda (1).png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		getContentPane().add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 103, 464, 142);
		getContentPane().add(panel);
		
		JLabel cantidad = new JLabel("Cantidad:");

		JLabel fecha = new JLabel("Fecha:");

		JLabel comentario = new JLabel("Comentario:");

		String texto = String.valueOf(trans.getCantidad());
		JLabel cantidadTexto = new JLabel(texto);

		String texto1 = String.valueOf(trans.getFecha());
		JLabel fechaTexto = new JLabel(texto1);

		JButton editar = new JButton("Editar");
		editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel categoria = new JLabel("Categoria:");
		categoria.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Principal.class.getResource("/resources/"+trans.getCat().getRuta())));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane_1 = new JScrollPane();



		JLabel lblNewLabel = new JLabel("");
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setText(trans.getComentario());
		textArea.setEditable(false);


		editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Editor ed = null;
				try {
					ed = new Editor(trans);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ed.show();
				dispose();

			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cantidad, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(fecha, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(comentario, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cantidadTexto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(206)
									.addComponent(categoria, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(fechaTexto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
							.addGap(3)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(editar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(42)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cantidad)
							.addGap(11)
							.addComponent(fecha)
							.addGap(11)
							.addComponent(comentario))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cantidadTexto)
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(categoria)
								.addComponent(fechaTexto)))
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editar)
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(20)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnEliminar)))))
		);
		panel.setLayout(gl_panel);
		if(trans.getTipo().equals("I")) {
			Color backgroundColor = new Color(168, 255, 150);
			panel.setBackground(backgroundColor);
		}else {
			Color backgroundColor = new Color(255, 150, 150);
			panel.setBackground(backgroundColor);
		}
	}
}
