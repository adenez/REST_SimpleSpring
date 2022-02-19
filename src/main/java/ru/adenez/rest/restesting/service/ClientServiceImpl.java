package ru.adenez.rest.restesting.service;

import org.springframework.stereotype.Service;
import ru.adenez.rest.restesting.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    //Store for REST testing
    private static final Map<Integer, Client> CLIENT_MAP = new HashMap<>();

    //Client's ID generator
    private static final AtomicInteger CLIENT_ID = new AtomicInteger(0);

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID.incrementAndGet();
        client.setId(clientId);
        CLIENT_MAP.put(clientId, client);
    }

    @Override
    public List<Client> getAllClients() {
        return new ArrayList<>(CLIENT_MAP.values());
    }

    @Override
    public Client getClient(int id) {
        return CLIENT_MAP.get(id);
    }

    @Override
    public boolean updateClient(Client client, int id) {
        if (CLIENT_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClient(int id) {
        return CLIENT_MAP.remove(id) != null;
    }
}
