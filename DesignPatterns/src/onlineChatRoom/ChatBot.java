package onlineChatRoom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBot extends User {

	private static ChatBot instance;

	private Pattern pattern = Pattern.compile("\\w+");
	private Matcher matcher;

	private ChatBot(RoomMediator mediator, String name) {
		super(mediator, name);
		mediator.addUser(this);
		// TODO Auto-generated constructor stub
	}

	private ChatBot(RoomMediator mediator, String name, User creator) {
		super(mediator, name);
		mediator.addUser(this);
		System.out.println("The user with nickname ~" + creator.nickname + "~ added the bot in the room.");
	}

	public static ChatBot getInstance(RoomMediator mediator, String name, User creator) {
		if (instance == null) {
			instance = new ChatBot(mediator, name, creator);
		}
		return instance;
	}

	@Override
	public void send(String message) {
		if (message.isEmpty()) {
			return;
		}
		System.out.println("\tThe Bot with nickname ~" + this.nickname + "~ sent: '" + message + "'.");
		chatRoomMediator.sendMessage(message, this);
	}

	@Override
	public void receive(String message, User sender) {
		System.out.println("\t\tThe Bot with nickname ~" + this.nickname + "~ received: '" + message + "'.");
		checkMessageForForbiddenWord(message, sender);
	}

	private void checkMessageForForbiddenWord(String message, User sender) {
		matcher = pattern.matcher(message);
		while (matcher.find()) {
			if ("cat".equals(matcher.group().toLowerCase())) {
				chatRoomMediator.removeUser(sender);
				System.out.println("The Bot with nickname ~" + this.nickname + " removed the user with nickname ~"
						+ sender.nickname + "~ for using the forbidden word --'cat'-- in his message '" + message
						+ "'.");
				this.send("The word 'cat' is forbidden in this chat room!!!");
				break;
			}
		}
	}
}
