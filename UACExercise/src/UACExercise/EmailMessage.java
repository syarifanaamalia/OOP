package UACExercise;

public class EmailMessage extends Message {

	public EmailMessage(ILogin login, String sender, String recipient, String content) {
		super(login, sender, recipient, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String username, String password) {
		 if(login.authenticate(username, password)) {
			 System.out.println("Email Sent Form " + sender + " to " + recipient + ": " + content);
		 } else {
			 System.out.println("Email authentication failed for user: " + username);
		 }

	}

}
