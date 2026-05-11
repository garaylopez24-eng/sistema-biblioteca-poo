package vistas;

import dao.UsuarioDAO;
import modelos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUsuarios extends JFrame
        implements ActionListener {

    JLabel lblTitulo;
    JLabel lblNombre;
    JLabel lblCorreo;
    JLabel lblPassword;
    JLabel lblRol;

    JTextField txtNombre;
    JTextField txtCorreo;
    JTextField txtPassword;
    JTextField txtRol;

    JButton btnGuardar;

    public VentanaUsuarios() {

        setTitle("Modulo Usuarios");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {

        lblTitulo =
                new JLabel("REGISTRO USUARIOS");

        lblTitulo.setBounds(
                130,
                20,
                250,
                30
        );

        add(lblTitulo);

        lblNombre =
                new JLabel("Nombre:");

        lblNombre.setBounds(
                50,
                80,
                100,
                30
        );

        add(lblNombre);

        txtNombre =
                new JTextField();

        txtNombre.setBounds(
                180,
                80,
                200,
                30
        );

        add(txtNombre);

        lblCorreo =
                new JLabel("Correo:");

        lblCorreo.setBounds(
                50,
                130,
                100,
                30
        );

        add(lblCorreo);

        txtCorreo =
                new JTextField();

        txtCorreo.setBounds(
                180,
                130,
                200,
                30
        );

        add(txtCorreo);

        lblPassword =
                new JLabel("Password:");

        lblPassword.setBounds(
                50,
                180,
                100,
                30
        );

        add(lblPassword);

        txtPassword =
                new JTextField();

        txtPassword.setBounds(
                180,
                180,
                200,
                30
        );

        add(txtPassword);

        lblRol =
                new JLabel("Rol:");

        lblRol.setBounds(
                50,
                230,
                100,
                30
        );

        add(lblRol);

        txtRol =
                new JTextField();

        txtRol.setBounds(
                180,
                230,
                200,
                30
        );

        add(txtRol);

        btnGuardar =
                new JButton("Guardar Usuario");

        btnGuardar.setBounds(
                150,
                300,
                180,
                40
        );

        add(btnGuardar);

        btnGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnGuardar) {

            Usuario usuario =
                    new Usuario();

            usuario.setNombre(
                    txtNombre.getText()
            );

            usuario.setCorreo(
                    txtCorreo.getText()
            );

            usuario.setPassword(
                    txtPassword.getText()
            );

            usuario.setRol(
                    txtRol.getText()
            );

            usuario.setMora(0);

            UsuarioDAO dao =
                    new UsuarioDAO();

            dao.insertarUsuario(usuario);

            JOptionPane.showMessageDialog(
                    null,
                    "Usuario guardado"
            );
        }
    }
}