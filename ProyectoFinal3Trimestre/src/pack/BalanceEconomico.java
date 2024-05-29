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
	public BalanceEconomico(Cuenta c) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ingresosmes = new JLabel("New label");
		ingresosmes.setHorizontalAlignment(SwingConstants.CENTER);
		ingresosmes.setBounds(212, 122, 138, 14);
		String dAMes = TransaccionesBD.getBalance(c, 2, "I");
		ingresosmes.setText(dAMes);
		contentPane.add(ingresosmes);
		
		JLabel ingresosHoy = new JLabel("New label");
		ingresosHoy.setHorizontalAlignment(SwingConstants.CENTER);
		ingresosHoy.setBounds(397, 122, 66, 14);
		String dDia = TransaccionesBD.getBalance(c, 3, "I");
		ingresosHoy.setText(dDia);
		contentPane.add(ingresosHoy);
		
		JLabel ingresosAño = new JLabel("New label");
		ingresosAño.setHorizontalAlignment(SwingConstants.CENTER);
		ingresosAño.setBounds(20, 122, 138, 14);
		String dAño = TransaccionesBD.getBalance(c, 1, "I");
		ingresosAño.setText(dAño);
		contentPane.add(ingresosAño);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresos del ultimo año          Ingresos del ultimo mes         Ingresos hoy");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 86, 464, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BalanceEconomico.class.getResource("/resources/fondoVerde.jpg")));
		lblNewLabel.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel);
	}

}
