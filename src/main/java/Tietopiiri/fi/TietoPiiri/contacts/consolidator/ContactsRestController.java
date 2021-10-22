/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietopiiri.fi.TietoPiiri.contacts.consolidator;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author totato
 */
@RestController
public class ContactsRestController {
    
    @Autowired
    ContactService contactService;
    
    
    String API_Key = "abcdefg";
    
    //endpoint which takes List of contacts and adds only viable contacts
    @RequestMapping(value = "/contacts/add/{apikey}", method = RequestMethod.POST)
    public List<Contact> addContact(@RequestBody List<Contact> contacts,
            @PathVariable String apikey){
        
        //API-Key checker
        if (apikey.equals(API_Key)){
            
        // making sure contacts contains firstname, lastname, and email
        List<Contact> validatedList = contacts
                .stream()
                .filter(c -> !c.getEmail().isEmpty() &&
                        !c.getFirstName().isEmpty() &&
                        !c.getLastName().isEmpty())
                .collect(Collectors.toList());
        //console log accepted contacts
        System.out.println(validatedList);
        
        return contactService.addContact(validatedList);
        }
        
        return null;
        
    }
        
}
