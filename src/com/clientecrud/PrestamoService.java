package com.clientecrud;

import java.util.*;
import java.util.logging.Logger;

public class PrestamoService {
    private static final Logger logger = Logger.getLogger(PrestamoService.class.getName());
    private List<Prestamo> prestamos = new ArrayList<>();
    private ClienteService clienteService;
    
    private static final double TASA_VIP = 0.05; // 5%
    private static final double TASA_REGULAR = 0.10; // 10% 

    public PrestamoService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Crear préstamo
    public void crearPrestamo(Prestamo p) {
        prestamos.add(p);
        logger.info("Préstamo creado: " + p);
    }

    // Obtener todos los préstamos activos (PENDIENTE)
    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        for(Prestamo p : prestamos) {
            if(p.getEstado() == EstadoPrestamo.PENDIENTE) {
                activos.add(p);
            }
        }
        return activos;
    }

    // Actualizar estado del préstamo
    public boolean actualizarEstado(String id, EstadoPrestamo nuevoEstado) {
        for(Prestamo p : prestamos) {
            if(p.getId().equals(id)) {
                p.setEstado(nuevoEstado);
                logger.info("Estado de préstamo actualizado: " + p);
                return true;
            }
        }
        return false;
    }

    // Eliminar préstamo
    public boolean eliminarPrestamo(String id) {
        Iterator<Prestamo> it = prestamos.iterator();
        while(it.hasNext()) {
            Prestamo p = it.next();
            if(p.getId().equals(id)) {
                it.remove();
                logger.info("Préstamo eliminado: " + p);
                return true;
            }
        }
        return false;
    }

    // Calcular monto total a pagar según tipo de cliente
    public double calcularMontoTotal(Prestamo p) {
        Cliente cliente = clienteService.obtenerClientes().stream()
                .filter(c -> c.id().equals(p.getClienteId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        double tasa = switch(cliente.tipoCliente()) {
            case VIP -> TASA_VIP;
            case REGULAR -> TASA_REGULAR;
        };

        return p.getMonto() * (1 + tasa);
    }
}

