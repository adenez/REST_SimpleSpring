/**
 * Use Postman or other program to do GET/POST/PUT/DELETE request
 */
package ru.adenez.rest.restesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adenez.rest.restesting.model.Client;
import ru.adenez.rest.restesting.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<?> getAll() {
        final List<Client> clientList = clientService.getAllClients();

        return (clientList != null && !clientList.isEmpty()) ?
                new ResponseEntity<>(clientList, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") int id) {
        final Client client = clientService.getClient(id);

        return client != null ?
                new ResponseEntity<>(client, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean isUpdated = clientService.updateClient(client, id);

        return isUpdated ?
                new ResponseEntity<>(client, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") int id) {
        final boolean isDeleted = clientService.deleteClient(id);

        return isDeleted ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
