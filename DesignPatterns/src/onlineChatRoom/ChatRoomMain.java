package onlineChatRoom;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatRoomMain {

	public static void main(String[] args) {
		ConsoleChatHelper helper = new ConsoleChatHelper();
		 ChatRoomMediator chatRoomMediator = new ChatRoomMediator();
		 UserFactory factory = new ChatUserFactory();
	        User user1 = factory.createChatUser(ChatUserType.User, chatRoomMediator, "User 1", null);
	        User user2 = factory.createChatUser(ChatUserType.User, chatRoomMediator, "User 2", null);
	        User user3 = factory.createChatUser(ChatUserType.User, chatRoomMediator, "User 3", null);
	        
	        BufferedReader reader =  
	                   new BufferedReader(new InputStreamReader(System.in)); 
	        boolean exit = false;
	        System.out.println("----- Commands to use: -------");
	        System.out.println("Enter the command 'quit' to exit.");
	        System.out.println("Enter the command 'user' to chose the user and send message from his name.");
	        System.out.println("------------------------------\n\n");
	        do {
	        	  System.out.print("Enter command:");
		          String command = "";
				try {
					command = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          switch (command.toLowerCase()) {
					case "user": {
						helper.chooseUserAndSendMessage(new User[]{user1, user2, user3});
						break;
					}
					case "quit": {
						exit = true;
						break;
					}
				}
	        	
	        }while(!exit);
	        
	        try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
//	        user1.send("test");
//	        user2.send("bot");
//	        user3.send("addbot");
//	        user1.send("addBot");
//	        
//	        user2.send("caterrpillar");
//	        user1.send("addBot");
//	        user2.send("car");
//	        user3.send("I love my kitten!");
//	        user2.send("I love my cat too!");
//	        
//	        user2.send("Thanks!");
	}
}