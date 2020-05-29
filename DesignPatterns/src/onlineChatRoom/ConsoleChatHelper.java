package onlineChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConsoleChatHelper {

	private String invalidUserMessage = "Invalid User! Please choose different Id!";
	
	public void chooseUserAndSendMessage(User[] users) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		sendMessageFormUser(reader, chooseUser(reader, users));
	}

	private User chooseUser(BufferedReader reader, User[] users)  {
		Boolean validUser = false;
		User u = null;
		do {

			Integer userId = 0;
			System.out.print(
					"Please choose the user who will send the message (Write the number of the user (from 1 to 3)): ");
			try {
				userId = Integer.valueOf(reader.readLine());
			} catch(Exception e){
				formatMessage(invalidUserMessage);
				continue;
		    }

			Map<String, Object> map = new HashMap();
			switch (userId) {
				case 1: {
					map = canSetUser(validUser, users[0]);
					break;
				}
				case 2: {
					map = canSetUser(validUser, users[1]);
					break;
				}
				case 3: {
					map = canSetUser(validUser, users[2]);
					break;
				}
				default: {
					formatMessage(invalidUserMessage);
					validUser = false;
					break;
				}
			}
			validUser = Boolean.valueOf((boolean) map.get("isValid"));
			u = (User) map.get("user");

		} while (!validUser);

		return u;
	}

	private Map<String, Object> canSetUser(Boolean validUser, User user) {
		Map<String, Object> map = new HashMap();
		validUser = user.canSendMessage();
		map.put("isValid", validUser);
		if (validUser) {
			map.put("user", user);
		} else {
			formatMessage("\tThe User with nickname ~" + user.nickname
					+ "~ was removed from the chatroom and cannot send messages.");	
			map.put("user", null);
		}

		return map;
	}

	private void sendMessageFormUser(BufferedReader reader, User user) {
		System.out.print("Please write a message (to activate the bot, text 'addBot'): ");
		String message = "";
		try {
			message = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~\n");
		user.send(message);
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	private void formatMessage(String message) {
		System.out.println("\n~~~~~~~~~~~~~~ Output ~~~~~~~~~~~~~\n");
		System.out.println(message);
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
}
