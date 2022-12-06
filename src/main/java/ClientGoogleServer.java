import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientGoogleServer {

    public static void main(String[] args) {
        Socket client = new Socket();
        try{
            client.connect(new InetSocketAddress("www.google.com",443),1000);
            System.out.println(true);
        }catch(Exception e){
            System.out.println(false + "," +e.getMessage());
        }
    }
}
