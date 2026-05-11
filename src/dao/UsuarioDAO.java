package dao;

import conexion.ConexionBD;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario) {

        String sql =
                "INSERT INTO usuarios(nombre, correo, password, rol, mora) " +
                        "VALUES (?, ?, ?, ?, ?)";

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRol());
            ps.setDouble(5, usuario.getMora());

            ps.executeUpdate();

            System.out.println("Usuario insertado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al insertar usuario");
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> listarUsuarios() {

        ArrayList<Usuario> listaUsuarios =
                new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setIdUsuario(
                        rs.getInt("id_usuario")
                );

                usuario.setNombre(
                        rs.getString("nombre")
                );

                usuario.setCorreo(
                        rs.getString("correo")
                );

                usuario.setPassword(
                        rs.getString("password")
                );

                usuario.setRol(
                        rs.getString("rol")
                );

                usuario.setMora(
                        rs.getDouble("mora")
                );

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar usuarios");
            e.printStackTrace();
        }

        return listaUsuarios;
    }

    public boolean validarLogin(
            String correo,
            String password
    ) {

        String sql =
                "SELECT * FROM usuarios " +
                        "WHERE correo = ? AND password = ?";

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, correo);

            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            System.out.println("Error en login");

            e.printStackTrace();
        }

        return false;
    }
}