package com.kortega90.desafioCliente.services;


import com.kortega90.desafioCliente.dto.ClientDTO;
import com.kortega90.desafioCliente.entities.Client;
import com.kortega90.desafioCliente.repositories.ClientRepository;
import com.kortega90.desafioCliente.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById (Long id) {
        Client client = repository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll (Pageable pageable) {
        Page<Client> rst = repository.findAll(pageable);
        return rst.map(x -> new ClientDTO(x));
    }
    @Transactional
    public ClientDTO insert (ClientDTO clientDTO) {
        Client client = new Client();
        dtoToClient (clientDTO,client);
        return new ClientDTO(repository.save(client));
    }

    @Transactional
    public ClientDTO update (long id, ClientDTO clientDTO) {

        try {
            Client client = repository.getReferenceById(id);
            dtoToClient(clientDTO,client);
            return new ClientDTO(repository.save(client));
        }
        catch (EntityNotFoundException e){
              throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }


  private void dtoToClient (ClientDTO clientDTO,Client client){
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }


}
