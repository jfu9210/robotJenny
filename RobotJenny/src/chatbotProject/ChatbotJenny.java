package chatbotProject;

public class ChatbotJenny implements Topic {
	
	private String[] keywords;
	private String[] question;
	private String[] excuse;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;

	public ChatbotJenny() {
		String[] temp = {"date", "free", "hang out", "dating"}; //girlfriend
		String[] temp3 = {"why not", "why", "why don't", "how come"};
		String[] temp4 = {"I have a lot of homework today.", "I have work.", "I have some family business I need to go to."};
		keywords = temp;
		question = temp3;
		excuse = temp4;
		goodbyeWord = "bye";
		secretWord = "EXO";
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
				return true;
		}
		return false;
	}
	public boolean questioned(String response) {
		for(int i = 0; i < question.length; i++) {
			if(ChatbotMain.findKeyword(response, question[i], 0) >= 0) {
				return true;
			}
		}	
		return false;
	}
	public void startChatting(String response) {
		ChatbotMain.print("No, sorry.");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(questioned(response)) {
				int idx = (int) Math.floor(Math.random() * excuse.length);
				ChatbotMain.print(excuse[idx]);
			}else
				if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
					chatting = false;
					ChatbotMain.chatbot.startTalking();
				}else
					if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
						ChatbotMain.print("OMG you guessed my favorite thing ever! Are you free this week?");
					}else
						ChatbotMain.print("Huh. I don't really get you. Tell me something else.");
		}
	}

}
