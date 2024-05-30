package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class BalanceEconomico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public BalanceEconomico(Cuenta c, Transaccion[] trans) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel gastosSem = new JLabel("<dynamic>");
		gastosSem.setHorizontalAlignment(SwingConstants.CENTER);
		gastosSem.setBounds(397, 241, 66, 14);
		String gSem = TransaccionesBD.getBalance(c, 3, "G");
		
		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal p;
				try {
					p = new Principal(c.getUser(), false, trans, "Ningun filtro aplicado");
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Balance económico");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(84, 14, 316, 64);
		contentPane.add(lblNewLabel_2);
		btnAtras.setIcon(new ImageIcon(BalanceEconomico.class.getResource("/resources/izquierda (1).png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 64, 64);
		contentPane.add(btnAtras);
		gastosSem.setText(gSem);
		contentPane.add(gastosSem);
		
		JLabel gastosAño = new JLabel("<dynamic>");
		gastosAño.setHorizontalAlignment(SwingConstants.CENTER);
		gastosAño.setBounds(20, 241, 138, 14);
		String gAño = TransaccionesBD.getBalance(c, 1, "G");
		gastosAño.setText(gAño);
		contentPane.add(gastosAño);
		
		JLabel gastosMes = new JLabel("<dynamic>");
		gastosMes.setHorizontalAlignment(SwingConstants.CENTER);
		gastosMes.setBounds(212, 241, 138, 14);
		String gMes = TransaccionesBD.getBalance(c, 2, "G");
		gastosMes.setText(gMes);
		contentPane.add(gastosMes);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gastosdel ultimo año          Gastos del ultimo mes         Gastos hoy");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 205, 464, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel ingresosmes = new JLabel("New label");
		ingresosmes.setHorizontalAlignment(SwingConstants.CENTER);
		ingresosmes.setBounds(212, 138, 138, 14);
		String iSem = TransaccionesBD.getBalance(c, 2, "I");
		ingresosmes.setText(iSem);
		contentPane.add(ingresosmes);
		
		JLabel ingresosHoy = new JLabel("New label");
		ingresosHoy.setHorizontalAlignment(SwingConstants.CENTER);
		ingresosHoy.setBounds(397, 138, 66, 14);
		String iDia = TransaccionesBD.getBalance(c, 3, "I");
		ingresosHoy.setText(iDia);
		contentPane.add(ingresosHoy);
		
		JLabel ingresosAño = new JLabel("New label");
		ingresosAño.setHorizontalAlignment(SwingConstants.CENTER);
		ingresosAño.setBounds(20, 138, 138, 14);
		String iAño = TransaccionesBD.getBalance(c, 1, "I");
		ingresosAño.setText(iAño);
		contentPane.add(ingresosAño);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresos del ultimo año          Ingresos del ultimo mes         Ingresos hoy");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 102, 464, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(BalanceEconomico.class.getResource("/resources/Captura de pantalla 2024-05-30 013410.png")));
		lblNewLabel_3.setBounds(10, 102, 464, 69);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(BalanceEconomico.class.getResource("/resources/Captura de pantalla 2024-05-30 013505.png")));
		lblNewLabel_3_1.setBounds(10, 205, 464, 69);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BalanceEconomico.class.getResource("/resources/equilibrio.png")));
		lblNewLabel.setBounds(410, 14, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(BalanceEconomico.class.getResource("/resources/fondoVerde.jpg")));
		fondo.setBounds(0, 0, 484, 321);
		contentPane.add(fondo);
	}

}
