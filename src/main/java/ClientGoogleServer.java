import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class ClientGoogleServer {
    public static void main(String[] args) throws IOException
    {
        Socket client = new Socket();
        String host = "www.google.com";
        PrintWriter pw = null;
        BufferedReader br = null;
        try
        {
            client.connect(new InetSocketAddress(host , 80));
            System.out.println("Connection established");
            //writer for socket
            pw = new PrintWriter( client.getOutputStream(), true);
            //reader for socket
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        //Host not found
        catch (UnknownHostException e)
        {
            System.err.println("Host not found : " + host);
            System.exit(1);
        }
        //Send message to server
        String message = "GET / HTTP/1.1\r\n\r\n";
        pw.println( message );
        System.out.println("Request sent");
        //Get response from server
        String response;
        while ((response = br.readLine()) != null)
        {
            System.out.println( response );
        }
        pw.close();
        br.close();
//close the socket
        client.close();
    }
}
