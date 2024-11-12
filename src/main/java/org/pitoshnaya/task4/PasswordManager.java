package org.pitoshnaya.task4;

import java.util.HashMap;
import java.util.Map;

public class PasswordManager {




    public void addPassword(String username, String password){
        Map<String, String> pass = new HashMap<>();
        pass.put("Gairbek", "senior1994");
        pass.put("Temirkhan", "senior1992");
        System.out.println(pass);
    }
    public boolean checkPassword(String username, String password){
        return true;
    }
}
