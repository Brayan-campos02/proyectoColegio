/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabajofinal;

import javax.swing.*;

/**
 * @author brayan campos
 */
public class TrabajoFinal {

  public static void main(String[] args) {
    RegistroDePersonas regPersonas = new RegistroDePersonas();
    RegistroDePedidos regPedidos = new RegistroDePedidos();
    Polleria polleria = new Polleria(222, "Magdalena del Mar");
    Menu menu = new Menu();
    String menuClase = """
            MENU
        1. Consultar menu
        2. Agregar cliente
        3. Reportar cliente
        4. Realizar pedido
        5. Reportar pedido de un determinado cliente
        6. Cerrar"
        """;

    int opcion = 0;
    int dni;
    int telefono;
    int codigoProducto;

    String nombre;
    String direccion;
    String email;
    String fechaNacimiento;

    Cliente cliente;

    int cantidad, codigo;
    String sabor, horario;
    Pedido pedido;
    double totalKilosHelado = 0;

    while (opcion != 20) {

      opcion = Integer.parseInt(JOptionPane.showInputDialog(menuClase));

      switch (opcion) {
        case 1 -> menu.mostrarMenu();
        case 2 -> {
          dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dni del cliente"));
          cliente = polleria.buscarCliente(dni);
          if (cliente == null) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            email = JOptionPane.showInputDialog("Ingrese el e-mail");
            fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
            direccion = JOptionPane.showInputDialog("Ingrese el domicilio");
            telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono"));

            cliente = new Cliente(dni, nombre, email, fechaNacimiento, direccion, telefono);
            polleria.agregarCliente(cliente);
            regPersonas.registrarPersona(cliente);
          } else {
            JOptionPane.showMessageDialog(null, "El cliente con dni " + dni + " ya está registrado");
          }
        }
        case 3 -> JOptionPane.showMessageDialog(null, polleria.obtenerDatosDeClientes());
        case 4 -> {
          boolean continuar = true;

          while (continuar) {
            dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dni del cliente"));
            cliente = polleria.buscarCliente(dni);

            if (cliente != null) {
              codigoProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto"));
              pedido = cliente.buscarPedido(codigoProducto);

              if (pedido == null) {
                pedido = new Pedido(polleria.contarPedidosRegistrados() + 1, codigoProducto);
                cliente.agregarPedido(pedido);
                regPedidos.registrarPedidos(pedido);
                // totalKilosHelado += cantidad;
              } else {
                JOptionPane.showMessageDialog(null, "El pedido con código " + (polleria.contarPedidosRegistrados() + 1) + " ya está registrado");
              }
            } else {
              JOptionPane.showMessageDialog(null, "La persona con dni " + dni + " no está registrada");
            }

            // Preguntar si se desea continuar
            int op = JOptionPane.showConfirmDialog(null, "¿Desea realizar otro pedido?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.NO_OPTION) {
              continuar = false; // Si se selecciona "No", se sale del bucle
            }
          }
          break;
        }
        case 5 -> {
          dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI"));
          cliente = polleria.buscarCliente(dni);
          if (cliente != null) {
            String datosDePedidos = cliente.obtenerDatosDePedidos();
            double total = cliente.calcularTotalPedidos();
            JOptionPane.showMessageDialog(null, datosDePedidos + "\n\nTotal: S/" + total);
          } else {
            JOptionPane.showMessageDialog(null, "El cliente con dni " + dni + " no está registrado");
          }
          break;
        }
        case 6 -> System.exit(0);
      }
    }
  }
}
