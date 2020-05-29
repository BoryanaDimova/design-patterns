package onlineChatRoom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class ChatRoomMediator implements RoomMediator {
	private List<User> users;

	public ChatRoomMediator() {
		this.users = new CopyOnWriteArrayList<>();
	}

	@Override
	public void sendMessage(String message, User user) {
		for (User u : this.users) {
			// message should not be received by the user sending it
			if (u == user) {
				continue;
			}
			u.receive(message, user);

		}
		checkifShouldAddBot(message, user);
		
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void removeUser(User userToDelete) {
		this.users.remove(userToDelete);
		userToDelete.changeRoomMediator(null);
	}

	private void checkifShouldAddBot(String message, User user) {
		if (!("addBot".equals(message))) {
			return;
		}

		new ChatUserFactory().createChatUser(ChatUserType.Bot, this, "Bot", user);
	}
}