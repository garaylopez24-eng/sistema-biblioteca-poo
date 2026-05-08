package main;

import dao.UsuarioDAO;
import modelos.Usuario;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        ArrayList<Usuario> listaUsuarios =
                dao.listarUsuarios();

        for (Usuario usuario : listaUsuarios) {

            System.out.println(
                    usuario.getIdUsuario()
            );

            System.out.println(
                    usuario.getNombre()
            );

            System.out.println(
                    usuario.getCorreo()
            );

            System.out.println(
                    usuario.getRol()
            );

            System.out.println(
                    usuario.getMora()
            );

            System.out.println(
                    "----------------------"
            );
        }
    }
}