package onlineChatRoom;

public abstract class User {

    protected RoomMediator chatRoomMediator;
    protected String nickname;

    public User(RoomMediator mediator, String name) {
        this.chatRoomMediator = mediator;
        this.nickname = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message, User sender); 
    
	public void changeRoomMediator(RoomMediator mediator) {
		this.chatRoomMediator = mediator;
		
	}
}
