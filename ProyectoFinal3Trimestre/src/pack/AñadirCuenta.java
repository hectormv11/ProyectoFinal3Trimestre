package pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AñadirCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Cuenta c;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AñadirCuenta(Usuario usuario_logeado) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PerfilDeUsuario p = new PerfilDeUsuario(usuario_logeado);
				p.show();
				dispose();

			}
		});
		btnNewButton.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/izquierda.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(10, 11, 64, 64);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBounds(10, 83, 464, 176);
		contentPane.add(panel);
		panel.setLayout(null);



		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 113, 334, 17);
		panel.add(textField_1);

		textField = new JTextField();
		textField.setBounds(80, 89, 334, 17);
		panel.add(textField);
		textField.setColumns(10);



		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 87, 60, 23);
		panel.add(lblNewLabel);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSaldo.setBounds(10, 112, 60, 23);
		panel.add(lblSaldo);

		JComboBox comboBox = new JComboBox();

		comboBox.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBox.setBounds(10, 47, 444, 25);
		panel.add(comboBox);
		Cuenta[] listado = CuentasBD.getCuentas(usuario_logeado);
		String[] cuentasS = new String[listado.length];

		for (int i = 0; i < cuentasS.length; i++) {
			cuentasS[i] = listado[i].toString();
		}

		comboBox.setModel(new DefaultComboBoxModel(cuentasS));

		JLabel lblNewLabel_1 = new JLabel("Editar cuentas");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 444, 25);
		panel.add(lblNewLabel_1);

		for (int i = 0; i < listado.length; i++) {
			if(listado[i].toString().equals(comboBox.getSelectedItem())) {
				c = listado[i];

			}
		}

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				Cuenta[] listado = null;
				try {
					listado = CuentasBD.getCuentas(usuario_logeado);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] cuentasS = new String[listado.length];

				for (int i = 0; i < cuentasS.length; i++) {
					cuentasS[i] = listado[i].toString();
				}
				
				for (int i = 0; i < listado.length; i++) {
					if(listado[i].toString().equals(comboBox.getSelectedItem())) {
						c = listado[i];

					}
				}
				
				textField.setText(c.getNombre());
				String saldo = String.valueOf(c.getSaldo());
				textField_1.setText(saldo);

			}
		});
		
		textField.setText(c.getNombre());
		String saldo = String.valueOf(c.getSaldo());
		textField_1.setText(saldo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty()) {
					try {
						double numeroComoDouble = Double.parseDouble(textField_1.getText());
						CuentasBD.actualizarCuenta(textField.getText(), c, numeroComoDouble);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					comboBox.setVisible(false);
					Cuenta[] listado = null;
					try {
						listado = CuentasBD.getCuentas(usuario_logeado);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String[] cuentasS = new String[listado.length];

					for (int i = 0; i < cuentasS.length; i++) {
						cuentasS[i] = listado[i].toString();
					}
					
					comboBox.setModel(new DefaultComboBoxModel(cuentasS));
					String elegido = textField.getText()+ " - "+Double.parseDouble(textField_1.getText());
					comboBox.setSelectedItem(elegido);
					comboBox.setVisible(true);

				}
			}
		});
		btnGuardar.setBounds(185, 140, 89, 23);
		panel.add(btnGuardar);




		JLabel fondo1 = new JLabel("");
		fondo1.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/maxresdefault (1).jpg")));
		fondo1.setBounds(0, 0, 464, 176);
		panel.add(fondo1);

		JLabel fonfo = new JLabel("");
		fonfo.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/fondo-pantalla-fondo-concepto-negocio-patrones-fisuras-finanzas-o-economia_78677-9986 (1) (1).jpg")));
		fonfo.setBounds(0, 0, 484, 561);
		contentPane.add(fonfo);

	}
}
