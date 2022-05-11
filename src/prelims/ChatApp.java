package prelims;

import prelims.UserInterface.SignInWindowUI;

public class ChatApp {
    public static void main(String[] args){
        try {
            run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    static void run(){
        SignInWindowUI initiateChatApp = new SignInWindowUI();
        initiateChatApp.setVisible(true);
    }
}
