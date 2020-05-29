package onlineChatRoom;

public class ChatUser extends User {

	public ChatUser(RoomMediator mediator, String name) {
		super(mediator, name);
		mediator.addUser(this);
	}

	@Override
	public void send(String message) {
		System.out.println("\tThe User with nickname ~" + this.nickname + "~ sent: '" + message + "'.");
		chatRoomMediator.sendMessage(message, this);

	}

	@Override
	public void receive(String message, User sender) {
		System.out.println("\t\tThe User with nickname ~" + this.nickname + "~ received: '" + message +"'.");
	}
}