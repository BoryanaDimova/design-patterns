package onlineChatRoom;

public abstract class UserFactory {

	public abstract User createUser(ChatUserType userType, RoomMediator mediator, String nickname, User creator);

	public User createChatUser(ChatUserType userType, RoomMediator mediator, String nickname, User creator) {
		return createUser(userType, mediator, nickname, creator);
	}

}
