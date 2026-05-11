package vistas;

import dao.UsuarioDAO;
import modelos.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    JButton btnListar;

    JTable tablaUsuarios;

    JScrollPane scrollTabla;

    DefaultTableModel modeloTabla;

    public VentanaUsuarios() {

        setTitle("Modulo Usuarios");

        setSize(800, 500);

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
                280,
                20,
                250,
                30
        );

        add(lblTitulo);

        lblNombre =
                new JLabel("Nombre:");

        lblNombre.setBounds(
                30,
                80,
                100,
                30
        );

        add(lblNombre);

        txtNombre =
                new JTextField();

        txtNombre.setBounds(
                120,
                80,
                180,
                30
        );

        add(txtNombre);

        lblCorreo =
                new JLabel("Correo:");

        lblCorreo.setBounds(
                30,
                130,
                100,
                30
        );

        add(lblCorreo);

        txtCorreo =
                new JTextField();

        txtCorreo.setBounds(
                120,
                130,
                180,
                30
        );

        add(txtCorreo);

        lblPassword =
                new JLabel("Password:");

        lblPassword.setBounds(
                30,
                180,
                100,
                30
        );

        add(lblPassword);

        txtPassword =
                new JTextField();

        txtPassword.setBounds(
                120,
                180,
                180,
                30
        );

        add(txtPassword);

        lblRol =
                new JLabel("Rol:");

        lblRol.setBounds(
                30,
                230,
                100,
                30
        );

        add(lblRol);

        txtRol =
                new JTextField();

        txtRol.setBounds(
                120,
                230,
                180,
                30
        );

        add(txtRol);

        btnGuardar =
                new JButton("Guardar");

        btnGuardar.setBounds(
                50,
                300,
                120,
                40
        );

        add(btnGuardar);

        btnGuardar.addActionListener(this);

        btnListar =
                new JButton("Listar");

        btnListar.setBounds(
                190,
                300,
                120,
                40
        );

        add(btnListar);

        btnListar.addActionListener(this);

        modeloTabla =
                new DefaultTableModel();

        modeloTabla.addColumn("ID");

        modeloTabla.addColumn("Nombre");

        modeloTabla.addColumn("Correo");

        modeloTabla.addColumn("Rol");

        modeloTabla.addColumn("Mora");

        tablaUsuarios =
                new JTable(modeloTabla);

        scrollTabla =
                new JScrollPane(tablaUsuarios);

        scrollTabla.setBounds(
                350,
                80,
                400,
                300
        );

        add(scrollTabla);
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

        if (e.getSource() == btnListar) {

            modeloTabla.setRowCount(0);

            UsuarioDAO dao =
                    new UsuarioDAO();

            ArrayList<Usuario> listaUsuarios =
                    dao.listarUsuarios();

            for (Usuario usuario : listaUsuarios) {

                Object[] fila = {

                        usuario.getIdUsuario(),

                        usuario.getNombre(),

                        usuario.getCorreo(),

                        usuario.getRol(),

                        usuario.getMora()
                };

                modeloTabla.addRow(fila);
            }
        }
    }
}