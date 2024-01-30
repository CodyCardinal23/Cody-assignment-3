package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

	public User[] readUserDataFromFile() throws IOException {
		List<User> userList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] userData = line.split(",");
				String username = userData[0];
				String password = userData[1];
				String name = userData[2];

				userList.add(new User(username, password, name));
			}
		}
		return userList.toArray(new User[0]);

	}
}
