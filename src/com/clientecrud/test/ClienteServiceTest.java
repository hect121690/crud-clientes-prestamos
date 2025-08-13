package com.clientecrud.test;

import com.clientecrud.*;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private ClienteService service;

    @BeforeEach
    void setUp() {
        service = new ClienteService();
    }

    @Test
    void testCrearCliente() {
        Cliente c = new Cliente("1", "Juan", "juan@email.com", 30, TipoCliente.REGULAR);
        service.crearCliente(c);

        List<Cliente> clientes = service.obtenerClientes();
        assertEquals(1, clientes.size());
        assertEquals("Juan", clientes.get(0).nombre());
    }
}

