package pack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class Ajustes extends JFrame {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Ajustes(Usuario user) {

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
	}
}
