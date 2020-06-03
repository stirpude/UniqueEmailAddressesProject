package com.example.restservice;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class NumOfUniqueEmailcontroller is the controller used to check unique email addresses
 */
@RestController
@EnableAutoConfiguration
public class NumOfUniqueEmailcontroller {

    /**
     *
     * @param emails
     * @param objEmail
     * @return int value of unique email addresses
     */

    /*@GetMapping("/home")
    public String home(){
        return "checkemail";
    }*/
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/checkemail")
    public int numOfUniqueEmails(@RequestParam(value = "emails1",required = false) String emails,@RequestBody Email objEmail) {

        System.out.println("The string of emails is rocket 1" + objEmail.getEmails());
        System.out.println("param is "+emails);

        //objEmail.setEmails(emails);
        System.out.println("The string of emails is " + objEmail.getEmails());
        String tempemails = objEmail.getEmails();
        String[] tempArray;
        String delimiter = ",";
        System.out.println("tempemails "+tempemails);
        tempArray = tempemails.split(delimiter);
        System.out.println("tempArray "+tempArray);

        // taking Set data structure for storing unique emails in the list
        Set<String> uniqueEmailList = new HashSet();


        // iterate over the list of emails to split the string into local and domain
        // name
        for (String email : tempArray) {
            System.out.println("Hi I am in ");
            int i = email.indexOf('@');
            String localName = email.substring(0, i);
            String doaminName = email.substring(i);

            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf('+'));
                // System.out.println("Now string is "+localName);
            }
            // Note: one should escape the specific character '.',
            // since it is treated as a regex expression.
            localName = localName.replaceAll("\\.", "");
            // System.out.println("Now removed the ."+localName);
            uniqueEmailList.add(localName + doaminName);
        }
        System.out.println("The number of unique email addresses is " + uniqueEmailList.size());
        NumOfUniqueEmail uniqueEmailObject = new NumOfUniqueEmail();
        uniqueEmailObject.setNum(uniqueEmailList.size());

       // int size =  uniqueobject.getNumOfUniqueEmail();
        //return size;
        //return "email";

        return uniqueEmailObject.getNum();

                // return new UniqueEmailNumber(uniqueEmailList.size());
    }

}
