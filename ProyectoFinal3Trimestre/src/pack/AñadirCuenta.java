package pack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class AñadirCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldSaldo;
	Cuenta c;
	private JTextField textFieldSaldo2;
	private JTextField textFieldNombre2;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AñadirCuenta(Usuario usuario_logeado) throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PerfilDeUsuario p = new PerfilDeUsuario(usuario_logeado);
				p.show();
				dispose();

			}
		});
		
		JLabel labelFotoCheck = new JLabel("");
		labelFotoCheck.setVisible(false);
		labelFotoCheck.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/registrarse.png")));
		labelFotoCheck.setHorizontalAlignment(SwingConstants.CENTER);
		labelFotoCheck.setBounds(10, 430, 464, 64);
		contentPane.add(labelFotoCheck);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setVisible(false);
		lblNewLabel_3_1.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/maxresdefault (1).jpg")));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(180, 430, 121, 64);
		contentPane.add(lblNewLabel_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 270, 464, 137);
		contentPane.add(panel_1);
		
		textFieldSaldo2 = new JTextField();
		textFieldSaldo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				labelFotoCheck.setVisible(false);
				lblNewLabel_3_1.setVisible(false);
				
			}
		});
		textFieldSaldo2.setText("");
		textFieldSaldo2.setColumns(10);
		textFieldSaldo2.setBounds(80, 65, 334, 17);
		panel_1.add(textFieldSaldo2);
		((AbstractDocument) textFieldSaldo2.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
				if (text.matches("[0-9.]*")) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "El campo saldo solo puede contener números.");
				}
			}
		});
		textFieldSaldo2.setToolTipText("El campo saldo solo puede contener números.");
		
		textFieldNombre2 = new JTextField();
		((AbstractDocument) textFieldNombre2.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "El campo nombre solo puede contener letras y números.");
                }
            }
        });
		textFieldNombre2.setToolTipText("El campo nombre solo puede contener letras y números.");
		textFieldNombre2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				labelFotoCheck.setVisible(false);
				lblNewLabel_3_1.setVisible(false);
				
			}
		});
		textFieldNombre2.setText((String) null);
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(80, 41, 334, 17);
		panel_1.add(textFieldNombre2);
		
		JLabel lblNombre2 = new JLabel("Nombre:");
		lblNombre2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNombre2.setBounds(10, 39, 60, 23);
		panel_1.add(lblNombre2);
		
		JLabel lblSaldo2 = new JLabel("Saldo:");
		lblSaldo2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblSaldo2.setBounds(10, 64, 60, 23);
		panel_1.add(lblSaldo2);
		
		JLabel lblAñadirCuentas = new JLabel("Añadir cuentas");
		lblAñadirCuentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirCuentas.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblAñadirCuentas.setBounds(10, 11, 444, 25);
		panel_1.add(lblAñadirCuentas);
		
		JButton btnGuardar2 = new JButton("Guardar");
		btnGuardar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textFieldNombre2.getText().equals("") && !textFieldSaldo2.getText().equals("")) {
					double saldo = Double.parseDouble(textFieldSaldo2.getText());
					try {
						CuentasBD.registrarCuenta(textFieldNombre2.getText(), usuario_logeado, saldo);
						textFieldNombre2.setText("");
						textFieldSaldo2.setText("");
						labelFotoCheck.setVisible(true);
						lblNewLabel_3_1.setVisible(true);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Nombre o saldo mal largos de lo permitido");
						e1.printStackTrace();
					}
				}
			}
		});
		btnGuardar2.setBounds(185, 98, 89, 23);
		panel_1.add(btnGuardar2);
		
		JLabel fondo1_1 = new JLabel("");
		fondo1_1.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/maxresdefault (1).jpg")));
		fondo1_1.setBounds(0, 0, 464, 137);
		panel_1.add(fondo1_1);
		btnAtras.setIcon(new ImageIcon(AñadirCuenta.class.getResource("/resources/izquierda (1).png")));
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 64, 64);
		contentPane.add(btnAtras);

		JPanel panel = new JPanel();
		panel.setBounds(10, 83, 464, 176);
		contentPane.add(panel);
		panel.setLayout(null);



		textFieldSaldo = new JTextField();
		textFieldSaldo.setColumns(10);
		textFieldSaldo.setBounds(80, 113, 334, 17);
		panel.add(textFieldSaldo);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(80, 89, 334, 17);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);



		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNombre.setBounds(10, 87, 60, 23);
		panel.add(lblNombre);

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

		JLabel lblEdiarCuentas = new JLabel("Editar cuentas");
		lblEdiarCuentas.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblEdiarCuentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdiarCuentas.setBounds(10, 11, 444, 25);
		panel.add(lblEdiarCuentas);

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
				
				textFieldNombre.setText(c.getNombre());
				String saldo = String.valueOf(c.getSaldo());
				textFieldSaldo.setText(saldo);

			}
		});
		
		textFieldNombre.setText(c.getNombre());
		String saldo = String.valueOf(c.getSaldo());
		textFieldSaldo.setText(saldo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				if(!textFieldNombre.getText().isEmpty() && !textFieldSaldo.getText().isEmpty()) {
					try {
						double numeroComoDouble = Double.parseDouble(textFieldSaldo.getText());
						CuentasBD.actualizarCuenta(textFieldNombre.getText(), c, numeroComoDouble);
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
					String elegido = textFieldNombre.getText()+ " - "+Double.parseDouble(textFieldSaldo.getText());
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
