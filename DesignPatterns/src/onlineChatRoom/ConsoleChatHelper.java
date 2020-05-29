package onlineChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleChatHelper {

	public void chooseUserAndSendMessage(User[] users) {
		 BufferedReader reader =  
                 new BufferedReader(new InputStreamReader(System.in)); 
		sendMessageFormUser(reader, chooseUser(reader, users));
	}
	
	
	private User chooseUser(BufferedReader reader, User[] users) {
		Boolean validUser = false;
		User u = null;
		do {
			Integer userId = 0;
			System.out.print("Please choose the user who will send the message: ");
			try {
				userId = Integer.valueOf(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Invalid User! Please choose different Id!");
				continue;
			}

			switch (userId) {
				case 1: {
					u = users[0];
					validUser = true;
					break;
				}
				case 2: {
					u = users[1];
					validUser = true;
					break;
				}
				case 3: {
					u = users[2];
					validUser = true;
					break;
				}
				default: {
					System.out.println("Invalid User! Please choose different Id!");
					validUser = false;
					break;
				}
			}
		} while (!validUser);

		return u;
	}
	
	private void sendMessageFormUser( BufferedReader reader, User user) {
		System.out.print("Please write the message: ");
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

}
