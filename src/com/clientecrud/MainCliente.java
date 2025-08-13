package com.clientecrud;

public class MainCliente {
    public static void main(String[] args) {
        ClienteService service = new ClienteService();

        Cliente c1 = new Cliente("1", "Juan", "juan@email.com", 30, TipoCliente.REGULAR);
        Cliente c2 = new Cliente("2", "Ana", "ana@email.com", 25, TipoCliente.VIP);

        service.crearCliente(c1);
        service.crearCliente(c2);

        service.aplicarDescuento(c1);
        service.aplicarDescuento(c2);

        service.actualizarCliente("1", "juan.perez@email.com", TipoCliente.VIP);
        service.eliminarCliente("2");
    }
}
