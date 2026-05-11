package dao;

import conexion.ConexionBD;
import modelos.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrestamoDAO {

    public void registrarPrestamo(
            Prestamo prestamo
    ) {

        String sql =
                "INSERT INTO prestamos(id_usuario, id_material, fecha_prestamo, fecha_devolucion, estado) " +
                        "VALUES (?, ?, ?, ?, ?)";

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setInt(
                    1,
                    prestamo.getIdUsuario()
            );

            ps.setInt(
                    2,
                    prestamo.getIdMaterial()
            );

            ps.setString(
                    3,
                    prestamo.getFechaPrestamo()
            );

            ps.setString(
                    4,
                    prestamo.getFechaDevolucion()
            );

            ps.setString(
                    5,
                    prestamo.getEstado()
            );

            ps.executeUpdate();

            System.out.println(
                    "Prestamo registrado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar prestamo"
            );

            e.printStackTrace();
        }
    }
}