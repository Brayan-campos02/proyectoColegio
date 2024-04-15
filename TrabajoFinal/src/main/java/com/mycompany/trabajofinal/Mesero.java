package com.mycompany.trabajofinal;

public class Mesero extends Persona {
  private int codigo;
  private String turno;
  private Pedido pedidoAsignado;

  public Mesero(int dni, String nombre, String fechaNacimiento, String direccion, int telefono, int codigo, String turno) {
    super(dni, nombre, fechaNacimiento, direccion, telefono);
    this.codigo = codigo;
    this.turno = turno;
    this.pedidoAsignado = null;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }

  public Pedido getPedidoAsignado() {
    return pedidoAsignado;
  }

  public void asignarPedido(Pedido pedido) {
    this.pedidoAsignado = pedido;
  }

}