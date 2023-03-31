package com.Insurance.Insurance_Management_System.Controller;

import com.Insurance.Insurance_Management_System.Models.Client;
import com.Insurance.Insurance_Management_System.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/allClient")
    public ResponseEntity getAllClient(){
        List<Client> clientList = clientService.getAllClient();
        return new ResponseEntity<>(clientList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/findById")
    public ResponseEntity findClientById(@RequestParam int ClientId){
        Client client = clientService.findClientById(ClientId);
        return new ResponseEntity<>(client,HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity createClient(@RequestBody Client client){
        String str = clientService.createClient(client);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

    @PutMapping("/updateInfo")
    public ResponseEntity updateClientInformation(@RequestParam int clientId,@RequestParam Long newMobileNumber,@RequestParam String newAddress){
        String str = clientService.updateClientInformation(clientId,newMobileNumber,newAddress);
        return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteClient(@RequestParam int clientId){
        clientService.deleteClient(clientId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

}
