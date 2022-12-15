import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class PageSourceClientProgramming {
    public static void main(String[] args) {
        Scanner inpt = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String url = inpt.next();
        TCPConnect(url);
    }
    public static void TCPConnect(String url) {
        try {
            String hostname = new URL(url).getHost();
            System.out.println("Loading contents of Server: " + hostname);
            InetAddress ia = InetAddress.getByName(hostname);
            String ip = ia.getHostAddress();
            System.out.println(ip + " is IP Adress for  " + hostname);
            String path = new URL(url).getPath();
            System.out.println("Requested Path on the server: " + path);
            Socket socket = new Socket(ip, 80);

            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            if (hostname != url) {
                //Request Line
                out.println("GET " + path + " HTTP/1.1");
                out.println("Host: " + hostname);
                //Header Lines
                out.println("User-Agent: Java/13.0.2");
                out.println("Accept-Language: en-us");
                out.println("Accept: */*");
                out.println("Connection: keep-alive");
                out.println("Accept-Encoding: gzip, deflate, br");
                // Blank Line
                out.println();
            } else {
                //Request Line
                out.println("GET / HTTP/1.0");
                out.println("Host: " + hostname);
                //Header Lines
                out.println("User-Agent: Java/13.0.2");
                out.println("Accept-Language: en-us");
                out.println("Accept: */*");
                out.println("Connection: keep-alive");
                out.println("Accept-Encoding: gzip, deflate, br");
                // Blank Line
                out.println();
            }

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            // Close our streams
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Invalid URl");
            e.printStackTrace();
        }
    }
}
