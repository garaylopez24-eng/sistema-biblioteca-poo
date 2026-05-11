package vistas;

import dao.UsuarioDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame
        implements ActionListener {

    JLabel lblTitulo;
    JLabel lblUsuario;
    JLabel lblPassword;

    JTextField txtUsuario;
    JPasswordField txtPassword;

    JButton btnLogin;

    public VentanaLogin() {

        setTitle("Sistema Biblioteca");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {

        lblTitulo = new JLabel("LOGIN");

        lblTitulo.setBounds(160, 20, 100, 30);

        lblTitulo.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        add(lblTitulo);

        lblUsuario = new JLabel("Correo:");

        lblUsuario.setBounds(50, 80, 100, 30);

        add(lblUsuario);

        txtUsuario = new JTextField();

        txtUsuario.setBounds(150, 80, 180, 30);

        add(txtUsuario);

        lblPassword = new JLabel("Password:");

        lblPassword.setBounds(50, 130, 100, 30);

        add(lblPassword);

        txtPassword = new JPasswordField();

        txtPassword.setBounds(150, 130, 180, 30);

        add(txtPassword);

        btnLogin = new JButton("Iniciar Sesion");

        btnLogin.setBounds(120, 200, 150, 40);

        add(btnLogin);

        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLogin) {

            String correo =
                    txtUsuario.getText();

            String password =
                    txtPassword.getText();

            UsuarioDAO dao = new UsuarioDAO();

            boolean loginCorrecto =
                    dao.validarLogin(
                            correo,
                            password
                    );

            if (loginCorrecto) {

                JOptionPane.showMessageDialog(
                        null,
                        "Bienvenido al sistema"
                );

                new VentanaMenu();

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Credenciales incorrectas"
                );
            }
        }
    }
}