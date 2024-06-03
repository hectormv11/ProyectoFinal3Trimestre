package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EstasDeAcuerdo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	boolean flag = false;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EstasDeAcuerdo(Usuario usuario_logeado, Transaccion trans) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 148);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Estas seguro de que quieres eliminarla?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Si");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					TransaccionesBD.eliminarTransaccion(trans);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error inesperado");
					e1.printStackTrace();
				}
				
				double saldoActualizado = trans.getCuenta().getSaldo();
				
				if(trans.getTipo().equals("I")) {
					saldoActualizado -= trans.getCantidad();
				}else {
					saldoActualizado += trans.getCantidad();
				}
				
				try {
					CuentasBD.actualizarCuenta(trans.getCuenta().getNombre(), trans.getCuenta(), saldoActualizado);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error inesperado");
					return;

				}
				
				try {
					Principal p = new Principal(usuario_logeado, false, null, "Ningun filtro aplicado");
					p.show();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error inesperado");
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(94, 67, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Principal p = new Principal(usuario_logeado, false, null, "Ningun filtro aplicado");
					p.show();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error inesperado");
					e1.printStackTrace();
				}
				
			}
		});
		btnNo.setBounds(262, 67, 89, 23);
		contentPane.add(btnNo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EstasDeAcuerdo.class.getResource("/resources/fondoVerde.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 109);
		contentPane.add(lblNewLabel_1);
	}
}
