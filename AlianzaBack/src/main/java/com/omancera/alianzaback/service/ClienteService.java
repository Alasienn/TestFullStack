/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.omancera.alianzaback.service;

/**
 *
 * @author enter
 */


import com.omancera.alianzaback.model.Cliente;
import com.omancera.alianzaback.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    private List<Cliente> clientes = new ArrayList<>();
    private Long idCounter = 1L;
    
    public List<Cliente> getCliente(){
        return clienteRepository.findAll();
    }
    
     public List<Cliente> buscarPorSharedKey(String sharedKey) {
        return clienteRepository.findBySharedKey(sharedKey);
    }
     
    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /*public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Cliente> buscarPorSharedKey(String sharedKey) {
        return clientes.stream()
                .filter(cliente -> cliente.getSharedKey().equalsIgnoreCase(sharedKey))
                .collect(Collectors.toList());
    }

    public Cliente crearCliente(Cliente cliente) {
        cliente.setId(idCounter++);
        clientes.add(cliente);
        System.out.println(clientes.getClass());
        System.out.println("test");
        return cliente;
    }*/
}
