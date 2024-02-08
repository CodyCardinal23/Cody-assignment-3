package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	private User[] users;

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

	public boolean usernameExists(String username) {
		if (users == null) {
			try {
				users = readUserDataFromFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateUserCredentials(String username, String password) {
		if (users == null) {
			try {
				users = readUserDataFromFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public String getUserCredentials(String usernameInput) {
		if (users == null) {
			try {
				users = readUserDataFromFile();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(usernameInput)) {
				return user.getName();
			}
		}
		return null;
	}

	public boolean checkUsername(String username) {
		if (users == null) {
			try {
				users = readUserDataFromFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkPassword(String username, String password) {
		if (users == null) {
			try {
				users = readUserDataFromFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
