package vistas;

import dao.PrestamoDAO;
import modelos.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrestamos extends JFrame
        implements ActionListener {

    JLabel lblTitulo;
    JLabel lblIdUsuario;
    JLabel lblIdMaterial;
    JLabel lblFechaPrestamo;
    JLabel lblFechaDevolucion;

    JTextField txtIdUsuario;
    JTextField txtIdMaterial;
    JTextField txtFechaPrestamo;
    JTextField txtFechaDevolucion;

    JButton btnRegistrar;

    public VentanaPrestamos() {

        setTitle("Modulo Prestamos");

        setSize(500, 450);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {

        lblTitulo =
                new JLabel("REGISTRO PRESTAMOS");

        lblTitulo.setBounds(
                150,
                20,
                250,
                30
        );

        add(lblTitulo);

        lblIdUsuario =
                new JLabel("ID Usuario:");

        lblIdUsuario.setBounds(
                50,
                80,
                120,
                30
        );

        add(lblIdUsuario);

        txtIdUsuario =
                new JTextField();

        txtIdUsuario.setBounds(
                200,
                80,
                180,
                30
        );

        add(txtIdUsuario);

        lblIdMaterial =
                new JLabel("ID Material:");

        lblIdMaterial.setBounds(
                50,
                140,
                120,
                30
        );

        add(lblIdMaterial);

        txtIdMaterial =
                new JTextField();

        txtIdMaterial.setBounds(
                200,
                140,
                180,
                30
        );

        add(txtIdMaterial);

        lblFechaPrestamo =
                new JLabel("Fecha Prestamo:");

        lblFechaPrestamo.setBounds(
                50,
                200,
                120,
                30
        );

        add(lblFechaPrestamo);

        txtFechaPrestamo =
                new JTextField();

        txtFechaPrestamo.setBounds(
                200,
                200,
                180,
                30
        );

        add(txtFechaPrestamo);

        lblFechaDevolucion =
                new JLabel("Fecha Devolucion:");

        lblFechaDevolucion.setBounds(
                50,
                260,
                140,
                30
        );

        add(lblFechaDevolucion);

        txtFechaDevolucion =
                new JTextField();

        txtFechaDevolucion.setBounds(
                200,
                260,
                180,
                30
        );

        add(txtFechaDevolucion);

        btnRegistrar =
                new JButton("Registrar Prestamo");

        btnRegistrar.setBounds(
                140,
                330,
                200,
                40
        );

        add(btnRegistrar);

        btnRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegistrar) {

            Prestamo prestamo =
                    new Prestamo();

            prestamo.setIdUsuario(
                    Integer.parseInt(
                            txtIdUsuario.getText()
                    )
            );

            prestamo.setIdMaterial(
                    Integer.parseInt(
                            txtIdMaterial.getText()
                    )
            );

            prestamo.setFechaPrestamo(
                    txtFechaPrestamo.getText()
            );

            prestamo.setFechaDevolucion(
                    txtFechaDevolucion.getText()
            );

            prestamo.setEstado(
                    "ACTIVO"
            );

            PrestamoDAO dao =
                    new PrestamoDAO();

            dao.registrarPrestamo(
                    prestamo
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Prestamo registrado"
            );
        }
    }
}