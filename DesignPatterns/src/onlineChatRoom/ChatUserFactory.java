package onlineChatRoom;


public class ChatUserFactory extends UserFactory {

	@Override
	public User createUser(ChatUserType userType, RoomMediator mediator, String nickname, User creator) {
		User user = null;
		
		switch(userType) {
		  case User:
		    user = new ChatUser(mediator, nickname);
		    break;
		  case Bot:
		    user = ChatBot.getInstance(mediator, nickname, creator);
		    break;
		}
		
		return user;
	}

}
