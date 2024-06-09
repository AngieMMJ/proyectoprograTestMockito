// EditarUsuarioTest.java
package com.cursojava.curso;

import com.cursojava.curso.utils.EditarUsuario;
import com.cursojava.curso.utils.ConexionBaseDatos;
import com.cursojava.curso.models.Usuario;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EditarUsuarioTest {

    @Mock
    private ConexionBaseDatos conexionMock;

    private EditarUsuario editarUsuario;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        editarUsuario = new EditarUsuario(conexionMock);
    }

    @Test
    public void testEditarUsuarioExitoso() {
        Usuario usuario = new Usuario("nombre", "correo@example.com", "nuevaContraseña");
        when(conexionMock.actualizarUsuario(usuario)).thenReturn(true);

        boolean resultado = editarUsuario.editar(usuario);

        assertTrue(resultado);
        verify(conexionMock).actualizarUsuario(usuario);
    }

    @Test
    public void testEditarUsuarioFallido() {
        Usuario usuario = new Usuario("nombre", "correo@example.com", "nuevaContraseña");
        when(conexionMock.actualizarUsuario(usuario)).thenReturn(false);

        boolean resultado = editarUsuario.editar(usuario);

        assertFalse(resultado);
        verify(conexionMock).actualizarUsuario(usuario);
    }
}
