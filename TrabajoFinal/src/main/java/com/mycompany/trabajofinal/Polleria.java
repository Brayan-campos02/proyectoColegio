/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajofinal;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author brayan campos
 */
public class Polleria {

    private int ruc;
    private String sede;

    Hashtable<Integer, Cliente> clientes = new Hashtable<Integer, Cliente>();
    Hashtable<Integer, Pedido> pedidos = new Hashtable<Integer, Pedido>();

    public Polleria(int ruc, String sede) {
        this.ruc = ruc;
        this.sede = sede;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Hashtable<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Hashtable<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Hashtable<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Hashtable<Integer, Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    //METODOS
    //metodo cliente

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public Cliente buscarCliente(int dni) {
        return clientes.get(dni);
    }
    //metodo repartidor

    //metodo mesero
    public String obtenerDatosDeClientes() {
        Cliente c;
        String dx = "";
        Enumeration<Cliente> enu = clientes.elements();
        while (enu.hasMoreElements()) {
            c = enu.nextElement();
            dx = dx + c.toString() + "\n";
        }
        return dx;
    }

    public int contarPedidosRegistrados() {
        int totalPedidos = 0;

        Collection<Cliente> clientesValues = clientes.values();

        for (Cliente cliente : clientesValues) {
            totalPedidos += cliente.getPedidos().size();
        }
        return totalPedidos;
    }

    @Override
    public String toString() {
        return "Polleria: \n"
                + "   ruc=" + ruc
                + "   sede=" + sede;
    }

}
