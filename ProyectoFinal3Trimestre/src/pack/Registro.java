package pack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JOptionPane;

public class Registro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUsuario;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JTextField textCorreo;
    int numPulsaciones = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registro frame = new Registro();
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
    public Registro() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 100, 500, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        passwordField2 = new JPasswordField();
        passwordField2.setEchoChar('*');
        passwordField2.setBounds(240, 290, 200, 20);
        passwordField2.setToolTipText("La contraseña puede contener letras, números y los siguientes caracteres especiales: !@#$%^&*()_+=-");
        contentPane.add(passwordField2);

        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        textUsuario.setBounds(240, 208, 200, 20);
        textUsuario.setToolTipText("El campo usuario solo puede contener letras y números.");
        contentPane.add(textUsuario);

        // Añadir restricción al campo textUsuario
        ((AbstractDocument) textUsuario.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z0-9ñÑ]*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "El campo usuario solo puede contener letras y números.");
                }
            }
        });

        JButton btnAtras = new JButton("");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inicio i = new Inicio();
                i.show();
                dispose();
            }
        });
        btnAtras.setIcon(new ImageIcon(Registro.class.getResource("/resources/izquierda (1).png")));
        btnAtras.setContentAreaFilled(false);
        btnAtras.setBorderPainted(false);
        btnAtras.setBounds(10, 11, 64, 64);
        contentPane.add(btnAtras);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(240, 249, 200, 20);
        passwordField.setToolTipText("La contraseña puede contener letras, números y los siguientes caracteres especiales: !@#$%^&*()_+=-");
        contentPane.add(passwordField);

        // Añadir restricción a los campos passwordField y passwordField2
        DocumentFilter passwordFilter = new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z0-9!@#$%^&*()_+=-]*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña solo puede contener letras, números y los siguientes caracteres especiales: !@#$%^&*()_+=-");
                }
            }
        };
        ((AbstractDocument) passwordField.getDocument()).setDocumentFilter(passwordFilter);
        ((AbstractDocument) passwordField2.getDocument()).setDocumentFilter(passwordFilter);

        textCorreo = new JTextField();
        textCorreo.setColumns(10);
        textCorreo.setBounds(240, 331, 200, 20);
        textCorreo.setToolTipText("El correo electrónico solo puede contener letras, números y los siguientes caracteres: @._-");
        contentPane.add(textCorreo);

        // Añadir restricción al campo textCorreo
        ((AbstractDocument) textCorreo.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z0-9@._-]*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico solo puede contener letras, números y los siguientes caracteres: @._-");
                }
            }
        });

        JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
        lblCorreoElectronico.setHorizontalAlignment(SwingConstants.CENTER);
        lblCorreoElectronico.setFont(new Font("Consolas", Font.PLAIN, 18));
        lblCorreoElectronico.setBounds(10, 327, 222, 30);
        contentPane.add(lblCorreoElectronico);

        JLabel lblConfirmarContrasea = new JLabel("Confirmar contraseña:");
        lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirmarContrasea.setFont(new Font("Consolas", Font.PLAIN, 18));
        lblConfirmarContrasea.setBounds(10, 286, 222, 30);
        contentPane.add(lblConfirmarContrasea);

        JLabel iconoPerfil = new JLabel("");
        iconoPerfil.setIcon(new ImageIcon(Registro.class.getResource("/resources/registro.png")));
        iconoPerfil.setBounds(178, 0, 128, 128);
        contentPane.add(iconoPerfil);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 18));
        lblUsuario.setBounds(10, 204, 222, 30);
        contentPane.add(lblUsuario);

        JLabel lblContrasea = new JLabel("Contraseña:");
        lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 18));
        lblContrasea.setBounds(10, 245, 222, 30);
        contentPane.add(lblContrasea);

        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBorderPainted(false);
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(passwordField.getPassword()).equals(new String(passwordField2.getPassword())) && passwordField.getPassword().length != 0) {
                    try {
                        UsuariosBD.registrarse(textUsuario.getText(), new String(passwordField.getPassword()), textCorreo.getText());
                        Usuario user = UsuariosBD.obtenerUsuario(textUsuario.getText());
                        CuentasBD.registrarCuenta("default", user, 0.0);
                        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                    } catch (SQLException e1) {
    					JOptionPane.showMessageDialog(null, "Usuario ya registrado");
    					return;
                    }
                    
                    Inicio i = new Inicio();
                    i.show();
                    dispose();
                }else {
					JOptionPane.showMessageDialog(null, "Algun campo vacio");
                }
            }
        });
        btnRegistrarse.setFont(new Font("Dialog", Font.PLAIN, 20));
        btnRegistrarse.setBounds(166, 392, 149, 35);
        contentPane.add(btnRegistrarse);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numPulsaciones++;
                if(numPulsaciones % 2 == 0) {
                    passwordField.setEchoChar('*');
                    passwordField2.setEchoChar('*');
                    ImageIcon icono = new ImageIcon(Registro.class.getResource("/resources/ojo.png"));
                    btnNewButton_1.setIcon(icono);
                } else {
                    passwordField.setEchoChar((char)0);
                    passwordField2.setEchoChar((char)0);
                    ImageIcon icono = new ImageIcon(Registro.class.getResource("/resources/ojo (1).png"));
                    btnNewButton_1.setIcon(icono);
                }
            }
        });
        
        btnNewButton_1.setIcon(new ImageIcon(Registro.class.getResource("/resources/ojo.png")));
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBounds(450, 268, 24, 24);
        contentPane.add(btnNewButton_1);

        JLabel fondo = new JLabel("");
        fondo.setIcon(new ImageIcon(Registro.class.getResource("/resources/fondoVerde.jpg")));
        fondo.setBounds(0, 0, 484, 561);
        contentPane.add(fondo);
    }
}
