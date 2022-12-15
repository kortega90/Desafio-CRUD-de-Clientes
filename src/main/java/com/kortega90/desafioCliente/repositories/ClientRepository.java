package com.kortega90.desafioCliente.repositories;

import com.kortega90.desafioCliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository <Client, Long> {
}
