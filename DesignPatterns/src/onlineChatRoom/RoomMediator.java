package onlineChatRoom;

public interface RoomMediator {
	void sendMessage(String message, User user);

	void addUser(User user);

	void removeUser(User user);
}