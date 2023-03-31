package com.Insurance.Insurance_Management_System.Service;

import com.Insurance.Insurance_Management_System.Models.Client;
import com.Insurance.Insurance_Management_System.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public String createClient(Client client){
        clientRepository.save(client);
        return "Client Added Successfully";
    }

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    public Client findClientById(int clientId){
       return clientRepository.findById(clientId).get();
    }

    public String updateClientInformation(int clientId, Long newMobileNumber, String newAddress){
        Client client = clientRepository.findById(clientId).get();
        client.setAddress(newAddress);
        client.setMobileNumber(newMobileNumber);
        clientRepository.save(client);
        return "Client Information Update Successfully";
    }

    public void deleteClient(int clientId){
       clientRepository.deleteById(clientId);
    }

}
