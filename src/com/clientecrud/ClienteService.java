package com.clientecrud;

import java.util.*;
import java.util.logging.Logger;

public class ClienteService {
    private static final Logger logger = Logger.getLogger(ClienteService.class.getName());
    private List<Cliente> clientes = new ArrayList<>();

    // Crea cliente
    public void crearCliente(Cliente c) {
        clientes.add(c);
        logger.info("Cliente creado: " + c);
    }

    // Obtiene todos
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    // Actualiza cliente por ID
    public boolean actualizarCliente(String id, String nuevoEmail, TipoCliente nuevoTipo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.id().equals(id)) {
                Cliente actualizado = new Cliente(c.id(), c.nombre(), nuevoEmail, c.edad(), nuevoTipo);
                clientes.set(i, actualizado);
                logger.info("Cliente actualizado: " + actualizado);
                return true;
            }
        }
        return false;
    }

    // Elimina cliente por ID
    public boolean eliminarCliente(String id) {
        Iterator<Cliente> it = clientes.iterator();
        while(it.hasNext()) {
            Cliente c = it.next();
            if(c.id().equals(id)) {
                it.remove();
                logger.info("Cliente eliminado: " + c);
                return true;
            }
        }
        return false;
    }

    // Acción según tipo de cliente usando Pattern Matching con switch para tipoCliente
    public void aplicarDescuento(Cliente c) {
        switch(c.tipoCliente()) {
            case VIP -> logger.info("Cliente VIP recibe descuento especial!");
            case REGULAR -> logger.info("Cliente REGULAR sin descuento.");
        }
    }
}

