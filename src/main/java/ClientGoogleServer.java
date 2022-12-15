import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;

public class ClientGoogleServer {

    public static void main(String[] args) {
        Socket client = new Socket();
        String url = "https://www.google.com/";
        try{
            client.connect(new InetSocketAddress("www.google.com",443),1000);
            System.out.println("Connection accepted!!");

            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String hostname = new URL(url).getHost();

            out.println("GET / HTTP/1.0");
            out.println("Host: " + hostname);

            out.println("User-Agent: Java/19.0.1");
            out.println("Accept-Language: en-us");
            out.println("Accept: */*");
            out.println("Connection: keep-alive");
            out.println("Accept-Encoding: gzip, deflate, br");

            out.println();

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }

            in.close();
            out.close();
            client.close();


        }catch(Exception e){
            System.out.println(false + "," +e.getMessage());
        }
    }
}
