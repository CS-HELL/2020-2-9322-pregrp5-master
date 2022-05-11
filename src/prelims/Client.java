package prelims;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {
    private static String userName;
    private static Socket socket;

    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public Client(String userName_, Socket clientSocket_){
        userName = userName_;
        socket = clientSocket_;
    }

    public static void setUserName(String userName_){
        userName = userName_;
    }
    public static String getuserName(){return userName;}

    public static void setClientSocket(Socket socket_){
        socket = socket_;
    }
    public static Socket getClientSocket(){
        return socket;
    }

    public void setObjectInputStream(ObjectInputStream ObjectInputStream){
        in = ObjectInputStream;
    }
    public static ObjectInputStream getObjectInputStream(){return in;}

    public void setObjectOutputStream(ObjectOutputStream ObjectOutputStream){
        out = ObjectOutputStream;
    }
    public static ObjectOutputStream getObjectOutputStream(){return out;}

}
