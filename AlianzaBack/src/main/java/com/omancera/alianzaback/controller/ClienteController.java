/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.omancera.alianzaback.controller;

/**
 *
 * @author enter
 */

import com.omancera.alianzaback.model.Cliente;
import com.omancera.alianzaback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    
    @GetMapping
    public List<Cliente> getClientes() {
        // Devuelv lista de clientes
        return clienteService.getCliente();
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarCliente(@RequestParam String sharedKey) {
        // Buscar cliente por llaave
        return clienteService.buscarPorSharedKey(sharedKey);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        //Crea cliente nuevo
        return clienteService.crearCliente(cliente); 
    }
}
