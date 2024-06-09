// EliminarUsuarioTest.java
package com.cursojava.curso;

import com.cursojava.curso.utils.EliminarUsuario;
import com.cursojava.curso.utils.ConexionBaseDatos;
import com.cursojava.curso.models.Usuario;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EliminarUsuarioTest {

    @Mock
    private ConexionBaseDatos conexionMock;

    private EliminarUsuario eliminarUsuario;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        eliminarUsuario = new EliminarUsuario(conexionMock);
    }

    @Test
    public void testEliminarUsuarioExitoso() {
        Usuario usuario = new Usuario("nombre", "correo@example.com", "contraseña");
        when(conexionMock.borrarUsuario(usuario)).thenReturn(true);

        boolean resultado = eliminarUsuario.eliminar(usuario);

        assertTrue(resultado);
        verify(conexionMock).borrarUsuario(usuario);
    }

    @Test
    public void testEliminarUsuarioFallido() {
        Usuario usuario = new Usuario("nombre", "correo@example.com", "contraseña");
        when(conexionMock.borrarUsuario(usuario)).thenReturn(false);

        boolean resultado = eliminarUsuario.eliminar(usuario);

        assertFalse(resultado);
        verify(conexionMock).borrarUsuario(usuario);
    }
}
