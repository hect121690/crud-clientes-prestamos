# CRUD de Clientes y Préstamos

Este proyecto implementa un sistema de gestión de **clientes** y **préstamos** en memoria, utilizando las características de **Java 17**, incluyendo **Records**, **Enums** y **Pattern Matching**.
Se incluyen pruebas unitarias, logs, y un contrato de interfaz en **OpenAPI 2.0** para documentar la API.

- Gestión de clientes (CRUD).
- Gestión de préstamos (CRUD).
- Cálculo de intereses según el tipo de cliente usando **Pattern Matching**.
- Documentación con **OpenAPI 2.0 (Swagger)**.

<img width="1280" height="512" alt="image" src="https://github.com/user-attachments/assets/d52ed74e-9e18-451d-8568-6fd672b1b45c" />

## Tecnologías
- Java 17
- Spring Boot
- OpenAPI 2.0 / Swagger

## Funcionalidades
### Clientes
- Crear cliente.
- Obtener todos los clientes.
- Actualizar cliente por ID.
- Eliminar cliente por ID.
- Tipos de cliente: VIP (5% interés), REGULAR (10% interés).

### Préstamos
- Crear préstamo.
- Obtener préstamos activos.
- Actualizar estado (PENDIENTE / PAGADO).
- Eliminar préstamo.
- Calcular monto total con intereses.

## Autor
- Hector J Barenas Lopez
