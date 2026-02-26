package com.example.serendipfinalproject;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    public static List<User> getSampleUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("Noa", "noa@paster.co.il", "054-691-1133"));
        users.add(new User("Maya", "mayam1250@gmail.com", "052-676-3600"));
        users.add(new User("Roni", "ronirabi33@gmail.com", "054-255-6050"));
        users.add(new User("Shay", "shayrokban@gmail.com", "054-351-8866"));

        return users;
    }
}
