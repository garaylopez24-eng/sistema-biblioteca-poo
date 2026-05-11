package vistas;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {

    JLabel lblTitulo;

    JButton btnUsuarios;
    JButton btnMateriales;
    JButton btnPrestamos;
    JButton btnSalir;

    public VentanaMenu() {

        setTitle("Menu Principal");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {

        lblTitulo =
                new JLabel("SISTEMA BIBLIOTECA");

        lblTitulo.setBounds(
                120,
                30,
                300,
                40
        );

        lblTitulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        add(lblTitulo);

        btnUsuarios =
                new JButton("Usuarios");

        btnUsuarios.setBounds(
                150,
                100,
                180,
                40
        );

        add(btnUsuarios);

        btnMateriales =
                new JButton("Materiales");

        btnMateriales.setBounds(
                150,
                160,
                180,
                40
        );

        add(btnMateriales);

        btnPrestamos =
                new JButton("Prestamos");

        btnPrestamos.setBounds(
                150,
                220,
                180,
                40
        );

        add(btnPrestamos);

        btnSalir =
                new JButton("Salir");

        btnSalir.setBounds(
                150,
                280,
                180,
                40
        );

        add(btnSalir);
    }
}