package vistas;

import dao.MaterialDAO;
import modelos.Material;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMateriales extends JFrame
        implements ActionListener {

    JLabel lblTitulo;
    JLabel lblCodigo;
    JLabel lblTituloMaterial;
    JLabel lblTipo;
    JLabel lblAutor;
    JLabel lblCantidad;
    JLabel lblUbicacion;

    JTextField txtCodigo;
    JTextField txtTitulo;
    JTextField txtTipo;
    JTextField txtAutor;
    JTextField txtCantidad;
    JTextField txtUbicacion;

    JButton btnGuardar;
    JButton btnListar;

    JTable tablaMateriales;

    JScrollPane scrollTabla;

    DefaultTableModel modeloTabla;

    public VentanaMateriales() {

        setTitle("Modulo Materiales");

        setSize(900, 550);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes() {

        lblTitulo =
                new JLabel("REGISTRO MATERIALES");

        lblTitulo.setBounds(
                300,
                20,
                300,
                30
        );

        add(lblTitulo);

        lblCodigo =
                new JLabel("Codigo:");

        lblCodigo.setBounds(
                30,
                80,
                100,
                30
        );

        add(lblCodigo);

        txtCodigo =
                new JTextField();

        txtCodigo.setBounds(
                140,
                80,
                180,
                30
        );

        add(txtCodigo);

        lblTituloMaterial =
                new JLabel("Titulo:");

        lblTituloMaterial.setBounds(
                30,
                130,
                100,
                30
        );

        add(lblTituloMaterial);

        txtTitulo =
                new JTextField();

        txtTitulo.setBounds(
                140,
                130,
                180,
                30
        );

        add(txtTitulo);

        lblTipo =
                new JLabel("Tipo:");

        lblTipo.setBounds(
                30,
                180,
                100,
                30
        );

        add(lblTipo);

        txtTipo =
                new JTextField();

        txtTipo.setBounds(
                140,
                180,
                180,
                30
        );

        add(txtTipo);

        lblAutor =
                new JLabel("Autor:");

        lblAutor.setBounds(
                30,
                230,
                100,
                30
        );

        add(lblAutor);

        txtAutor =
                new JTextField();

        txtAutor.setBounds(
                140,
                230,
                180,
                30
        );

        add(txtAutor);

        lblCantidad =
                new JLabel("Cantidad:");

        lblCantidad.setBounds(
                30,
                280,
                100,
                30
        );

        add(lblCantidad);

        txtCantidad =
                new JTextField();

        txtCantidad.setBounds(
                140,
                280,
                180,
                30
        );

        add(txtCantidad);

        lblUbicacion =
                new JLabel("Ubicacion:");

        lblUbicacion.setBounds(
                30,
                330,
                100,
                30
        );

        add(lblUbicacion);

        txtUbicacion =
                new JTextField();

        txtUbicacion.setBounds(
                140,
                330,
                180,
                30
        );

        add(txtUbicacion);

        btnGuardar =
                new JButton("Guardar");

        btnGuardar.setBounds(
                50,
                400,
                120,
                40
        );

        add(btnGuardar);

        btnGuardar.addActionListener(this);

        btnListar =
                new JButton("Listar");

        btnListar.setBounds(
                200,
                400,
                120,
                40
        );

        add(btnListar);

        btnListar.addActionListener(this);

        modeloTabla =
                new DefaultTableModel();

        modeloTabla.addColumn("ID");

        modeloTabla.addColumn("Codigo");

        modeloTabla.addColumn("Titulo");

        modeloTabla.addColumn("Tipo");

        modeloTabla.addColumn("Autor");

        modeloTabla.addColumn("Cantidad");

        modeloTabla.addColumn("Disponibles");

        modeloTabla.addColumn("Ubicacion");

        tablaMateriales =
                new JTable(modeloTabla);

        scrollTabla =
                new JScrollPane(tablaMateriales);

        scrollTabla.setBounds(
                360,
                80,
                500,
                350
        );

        add(scrollTabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnGuardar) {

            Material material =
                    new Material();

            material.setCodigo(
                    txtCodigo.getText()
            );

            material.setTitulo(
                    txtTitulo.getText()
            );

            material.setTipo(
                    txtTipo.getText()
            );

            material.setAutor(
                    txtAutor.getText()
            );

            material.setCantidad(
                    Integer.parseInt(
                            txtCantidad.getText()
                    )
            );

            material.setDisponibles(
                    Integer.parseInt(
                            txtCantidad.getText()
                    )
            );

            material.setUbicacion(
                    txtUbicacion.getText()
            );

            MaterialDAO dao =
                    new MaterialDAO();

            dao.insertarMaterial(material);

            JOptionPane.showMessageDialog(
                    null,
                    "Material guardado"
            );
        }

        if (e.getSource() == btnListar) {

            modeloTabla.setRowCount(0);

            MaterialDAO dao =
                    new MaterialDAO();

            ArrayList<Material> listaMateriales =
                    dao.listarMateriales();

            for (Material material : listaMateriales) {

                Object[] fila = {

                        material.getIdMaterial(),

                        material.getCodigo(),

                        material.getTitulo(),

                        material.getTipo(),

                        material.getAutor(),

                        material.getCantidad(),

                        material.getDisponibles(),

                        material.getUbicacion()
                };

                modeloTabla.addRow(fila);
            }
        }
    }
}