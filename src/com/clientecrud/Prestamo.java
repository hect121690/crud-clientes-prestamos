package com.clientecrud;

import java.time.LocalDate;

public class Prestamo {
    private String id;
    private double monto;
    private String clienteId;
    private LocalDate fecha;
    private EstadoPrestamo estado;

    public Prestamo(String id, double monto, String clienteId, LocalDate fecha, EstadoPrestamo estado) {
        this.id = id;
        this.monto = monto;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public double getMonto() { return monto; }
    public String getClienteId() { return clienteId; }
    public LocalDate getFecha() { return fecha; }
    public EstadoPrestamo getEstado() { return estado; }
    public void setEstado(EstadoPrestamo estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Prestamo[id=" + id + ", monto=" + monto + ", clienteId=" + clienteId +
               ", fecha=" + fecha + ", estado=" + estado + "]";
    }
}

