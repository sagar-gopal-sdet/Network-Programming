import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGoogleServer {
    public static void main(String[] args) throws IOException
    {
        Socket s = new Socket();
        String host = "www.google.com";
        PrintWriter out = null;
        BufferedReader in = null;
        try
        {
            s.connect(new InetSocketAddress(host , 80));
            System.out.println("Connection established");
            //writer for socket
            out = new PrintWriter( s.getOutputStream(), true);
            //reader for socket
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }
        //Host not found
        catch (UnknownHostException e)
        {
            System.err.println("Don't know about host : " + host);
            System.exit(1);
        }
        //Send message to server
        String message = "GET / HTTP/1.1\r\n\r\n";
        out.println( message );
        System.out.println("Request sent");
        //Get response from server
        String response;
        while ((response = in.readLine()) != null)
        {
            System.out.println( response );
        }
        out.close();
        in.close();
//close the socket
        s.close();
    }
}
