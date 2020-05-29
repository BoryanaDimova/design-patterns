package onlineChatRoom;

public class ChatRoomMain {

	public static void main(String[] args) {
		
		 ChatRoomMediator chatRoomMediator = new ChatRoomMediator();
		 UserFactory factory = new ChatUserFactory();
	        User user1 = factory.createChatUser(ChatUserType.User, chatRoomMediator, "User 1", null);
	        User user2 = factory.createChatUser(ChatUserType.User, chatRoomMediator, "User 2", null);
	        User user3 = factory.createChatUser(ChatUserType.User, chatRoomMediator, "User 3", null);
	  
	        user1.send("test");
	        user2.send("bot");
	        user3.send("addbot");
	        user1.send("addBot");
	        
	        user2.send("caterrpillar");
	        user1.send("addBot");
	        user2.send("car");
	        user3.send("I love my kitten!");
	        user2.send("I love my cat too!");
	        
	}
}