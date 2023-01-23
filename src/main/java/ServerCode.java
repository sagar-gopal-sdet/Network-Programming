import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class ServerCode {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4000);
            System.out.println("Waiting for client");


            String receivedText = "";


            while(!receivedText.equalsIgnoreCase("over and out")) {
                Socket s = server.accept();
                System.out.println("Server is connected");
                /*Code to tranfer text to client*/
                Scanner sc = new Scanner(System.in);
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                System.out.println("Reply to Client: ");
                String serverText = sc.nextLine();
                pw.println(serverText);
                pw.flush();

                /*Code to receiver text from client*/
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                receivedText = br.readLine();
                System.out.println("Data from Client: " + receivedText);
            }


        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
