package connectionthreads;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class client {
    public static void main(String[] args) {
        System.out.println("Start Networking ");
        //int port = Integer.parseInt(args[0]);
        try{
            Socket client = new Socket("localhost", 3000);
            String receivedText = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            while(!receivedText.equalsIgnoreCase("over and out")) {
                /*Code to receive text from Server.*/

                receivedText = br.readLine();
                System.out.println("Data from Server: " + receivedText);

                /*Code to send text to Server.*/
                Scanner sc = new Scanner(System.in);
                System.out.println("Reply to Server: ");

                String clientText = sc.nextLine();
                pw.println(clientText);
                pw.flush();
            }
            pw.close();
            br.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
