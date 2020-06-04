package com.example.restservice;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
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
     * @param emails
     * @param objEmail
     * @return int value of unique email addresses
     */


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/checkemail")
    public String numOfUniqueEmails(@RequestParam(value = "emails1", required = false) String emails, @RequestBody Email objEmail) {

        String uniqeEmailNum = "";

        //try catch block to check if input string email is null, we can also use validation @NotNull for the business logic
        try {


            String tempemails = objEmail.getEmails();
            String[] tempArray;
            String delimiter = ",";
            // Add all business valdiation here
            //we can also throw a exception and return a value
            if (tempemails == "" || tempemails == null) {
                uniqeEmailNum = "The input email is blank,please provide non-empty email list ";
                return uniqeEmailNum;

            }

            tempArray = tempemails.split(delimiter);
            // taking Set data structure for storing non duplicate unique emails in the list
            Set<String> uniqueEmailList = new HashSet();

            // iterate over the list of emails to split the string into local and domain name and check

            for (String email : tempArray) {
                int i = email.indexOf('@');
                String localName = email.substring(0, i);
                String domainName = email.substring(i);

                if (localName.contains("+")) {
                    localName = localName.substring(0, localName.indexOf('+'));
                }

                // Note: one should escape the specific character '.',
                // since it is treated as a regex expression.
                localName = localName.replaceAll("\\.", "");
                uniqueEmailList.add(localName + domainName);
            }

            NumOfUniqueEmail uniqueEmailObject = new NumOfUniqueEmail();
            uniqueEmailObject.setNum(uniqueEmailList.size());

            uniqeEmailNum = Integer.toString(uniqueEmailObject.getNum());
            System.out.println("The number of unique email addresses is :  "+uniqeEmailNum);
            return uniqeEmailNum;

        } catch (Exception ex) {

            System.out.println("The input email is blank,please provide non-empty email list ");
            uniqeEmailNum = ex.getMessage();
            return uniqeEmailNum;
        } finally {
            uniqeEmailNum = "";
        }


    }

}
