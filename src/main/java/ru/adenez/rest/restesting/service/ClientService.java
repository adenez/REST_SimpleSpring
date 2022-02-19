package ru.adenez.rest.restesting.service;

import ru.adenez.rest.restesting.model.Client;

import java.util.List;

public interface ClientService {

    /**
     * Creating new Client
     *
     * @param client - client to create
     */
    void create(Client client);

    /**
     * Return all clients from list
     *
     * @return clients list
     */
    List<Client> getAllClients();

    /**
     * Return client with necessary id
     *
     * @param id - client's id
     * @return client with this id
     */
    Client getClient(int id);

    /**
     * Update client with necessary id
     *
     * @param client
     * @param id
     * @return boolean value - true if changed
     */
    boolean updateClient(Client client, int id);

    /**
     * Delete client with necessary id
     *
     * @param id
     * @return boolean value - true if deleted
     */
    boolean deleteClient(int id);

}
