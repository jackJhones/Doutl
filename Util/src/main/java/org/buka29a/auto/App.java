package org.buka29a.auto;

import org.buka29a.auto.business.User;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        Map<String, Object> userData_1 = new HashMap<>();
        userData_1.put("id", 100);
        userData_1.put("first_Name", "Alex");
        userData_1.put("last_Name", "Hoffman");
        userData_1.put("active", true);

        User user = new User().initialize(userData_1);
        System.out.println(user.toMap());
        System.out.println(user.initializedFields());
        System.out.println(user.notInitializedFields());

        Map<String, Object> userData_2 = new HashMap<>();
        userData_2.put("id", "101");
        userData_2.put("firstName", 1000L);
        userData_2.put("active", "false");

        User user2 = new User().initialize(userData_2);
        System.out.println(user2.toMap());
        System.out.println(user2.initializedFields());
        System.out.println(user2.notInitializedFields());

    }
}
