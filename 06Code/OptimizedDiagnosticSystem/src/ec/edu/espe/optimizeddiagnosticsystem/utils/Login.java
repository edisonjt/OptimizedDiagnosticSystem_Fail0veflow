/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.optimizeddiagnosticsystem.utils;

import ec.edu.espe.filemanager.utils.Data;

/**
 *
 * @author luist
 */
public class Login {

    public boolean system(String pass) {
        boolean validate = false;
        if (Data.find("PassDocSystem.csv", pass).equalsIgnoreCase(pass)) {
            validate = true;
        } else if (Data.find("PassNursSystem.csv", pass).equalsIgnoreCase(pass)) {
            validate = true;
        } else if (pass.equalsIgnoreCase("rootpass")) {
            validate = true;
        }         
        return validate;
    }
    
    public boolean loginHistoryUpdater(String user, String pass) {
        boolean validate = false;

        String chain = Data.find("users.csv", user);

        String[] split = chain.split(",");
        String p1 = split[0];

        if (p1.equalsIgnoreCase(user)) {
            String p2 = split[1];
            if (p1.equalsIgnoreCase(user) && p2.equalsIgnoreCase(pass)) {
                validate = true;
            }
        }

        return validate;
    }

   
}
