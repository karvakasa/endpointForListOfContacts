/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietopiiri.fi.TietoPiiri.contacts.consolidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author totato
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String phonenumber;
    private String city;
}
