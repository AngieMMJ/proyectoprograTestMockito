// RegistrarUsuarioTest.java
package com.cursojava.curso;

import com.cursojava.curso.utils.RegistrarUsuario;
import com.cursojava.curso.utils.ConexionBaseDatos;
import com.cursojava.curso.models.Usuario;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RegistrarUsuarioTest {

    @Test
    public void testRegistrarUsuarioExitoso() {
        Usuario usuario = new Usuario("nombre", "correo@example.com", "contraseña");
        when(conexionMock.insertarUsuario(usuario)).thenReturn(true);

        boolean resultado = registrarUsuario.registrar(usuario);

        assertTrue(resultado);
        verify(conexionMock).insertarUsuario(usuario);
    }

    @Test
    public void testRegistrarUsuarioFallido() {
        Usuario usuario = new Usuario("nombre", "correo@example.com", "contraseña");
        when(conexionMock.insertarUsuario(usuario)).thenReturn(false);

        boolean resultado = registrarUsuario.registrar(usuario);

        assertFalse(resultado);
        verify(conexionMock).insertarUsuario(usuario);
    }
}
