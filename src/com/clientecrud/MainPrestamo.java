package com.clientecrud;

import java.time.LocalDate;

public class MainPrestamo {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        PrestamoService prestamoService = new PrestamoService(clienteService);

        // Crear clientes
        Cliente c1 = new Cliente("1", "Juan", "juan@email.com", 30, TipoCliente.REGULAR);
        Cliente c2 = new Cliente("2", "Ana", "ana@email.com", 25, TipoCliente.VIP);
        clienteService.crearCliente(c1);
        clienteService.crearCliente(c2);

        /* Crear préstamos*/
        Prestamo p1 = new Prestamo("p1", 1000, "1", LocalDate.now(), EstadoPrestamo.PENDIENTE);
        Prestamo p2 = new Prestamo("p2", 1000, "2", LocalDate.now(), EstadoPrestamo.PENDIENTE);
        prestamoService.crearPrestamo(p1);
        prestamoService.crearPrestamo(p2);

        /* Calcular monto total con interes por tipo de cliente*/
        
        // 1100 (Monto 1000 + 10% para Cliente Regular)
        System.out.println("Monto total " + c1.nombre() + ": " + prestamoService.calcularMontoTotal(p1));
        // 1050 (Monto 1000 + 5% para Cliente VIP)
        System.out.println("Monto total " + c2.nombre() + ": " + prestamoService.calcularMontoTotal(p2)); 

        /* Obtener activos*/
        System.out.println("Préstamos activos: " + prestamoService.obtenerPrestamosActivos());
        
        /* Actualizar estado*/
        prestamoService.actualizarEstado("p1", EstadoPrestamo.PAGADO);
        System.out.println("Cliente " + c1.nombre() + ": Estado de prestamo (" + p1.getEstado() + ")");

        /* Obtener activos*/
        System.out.println("Préstamos activos: " + prestamoService.obtenerPrestamosActivos());
       
        /* Eliminar préstamo*/
        prestamoService.eliminarPrestamo("p2");
    }
}

