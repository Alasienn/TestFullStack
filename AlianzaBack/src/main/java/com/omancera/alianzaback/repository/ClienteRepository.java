/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.omancera.alianzaback.repository;

import com.omancera.alianzaback.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author enter
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findBySharedKey(String sharedKey);
}
