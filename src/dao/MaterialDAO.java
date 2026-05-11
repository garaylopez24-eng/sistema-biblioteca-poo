package dao;

import conexion.ConexionBD;
import modelos.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialDAO {

    public void insertarMaterial(Material material) {

        String sql =
                "INSERT INTO materiales(codigo, titulo, tipo, autor, cantidad, disponibles, ubicacion) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, material.getCodigo());

            ps.setString(2, material.getTitulo());

            ps.setString(3, material.getTipo());

            ps.setString(4, material.getAutor());

            ps.setInt(5, material.getCantidad());

            ps.setInt(6, material.getDisponibles());

            ps.setString(7, material.getUbicacion());

            ps.executeUpdate();

            System.out.println(
                    "Material insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error al insertar material"
            );

            e.printStackTrace();
        }
    }

    public ArrayList<Material> listarMateriales() {

        ArrayList<Material> listaMateriales =
                new ArrayList<>();

        String sql = "SELECT * FROM materiales";

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Material material =
                        new Material();

                material.setIdMaterial(
                        rs.getInt("id_material")
                );

                material.setCodigo(
                        rs.getString("codigo")
                );

                material.setTitulo(
                        rs.getString("titulo")
                );

                material.setTipo(
                        rs.getString("tipo")
                );

                material.setAutor(
                        rs.getString("autor")
                );

                material.setCantidad(
                        rs.getInt("cantidad")
                );

                material.setDisponibles(
                        rs.getInt("disponibles")
                );

                material.setUbicacion(
                        rs.getString("ubicacion")
                );

                listaMateriales.add(material);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al listar materiales"
            );

            e.printStackTrace();
        }

        return listaMateriales;
    }
}