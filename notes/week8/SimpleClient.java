import java.io.OutputStream;
import java.net.Socket;
public class SimpleClient {
    public static void main(String[] args) {
        String host="localhost";
        int port=27931;
        try(Socket socket=new Socket(host,port)){
            System.out.println("Connected to"+host+":"+port);
            String message="Hello from SimpleClient";
            OutputStream out=socket.getOutputStream();
            out.write(message.getBytes());
            out.flush();
            System.out.println("Message sent:"+message);
        }catch(Exception e){
            System.err.println("Client error:"+e.getMessage());
        }
        System.out.println("Client closed.");
    }
}