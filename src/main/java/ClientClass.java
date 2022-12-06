import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class ClientClass {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 4000);
            String receivedText = "";
            while(!receivedText.equalsIgnoreCase("over and out")) {
                /*Code to receive text from Server.*/
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                receivedText = br.readLine();
                System.out.println("Data from Server: " + receivedText);

                /*Code to send text to Server.*/
                Scanner sc = new Scanner(System.in);
                System.out.println("Reply to Server: ");
                PrintWriter pw = new PrintWriter(client.getOutputStream());
                String clientText = sc.nextLine();
                pw.println(clientText);
                pw.flush();
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
