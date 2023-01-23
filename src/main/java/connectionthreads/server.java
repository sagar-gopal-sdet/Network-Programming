package connectionthreads;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {
        //static int count = 0;
        public static void main(String[] args) throws IOException {
            try {
                ServerSocket server = new ServerSocket(3000);
                System.out.println("Waiting for client");

                while (true) {
                    System.out.println("Server is connected");
                    new ClientHandler(server.accept()).start();
                }
            }catch (IOException e) {
                    e.printStackTrace();
                }
        }
        }


    class ClientHandler extends Thread {
        private final Socket s;
        public ClientHandler(Socket s) {
            this.s = s;
        }
        public void run()
        {
            while(true) {
                try {
                    String receivedText = "";
                    PrintWriter pw = new PrintWriter(s.getOutputStream());
                    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

                        /*Code to tranfer text to client*/
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Reply to Client: ");
                        String serverText = sc.nextLine();
                        pw.println(serverText);
                        pw.flush();

                        /*Code to receiver text from client*/
                        receivedText = br.readLine();
                        System.out.println("Data from Client: " + receivedText);
                        if(receivedText.equalsIgnoreCase("over and out")){
                            pw.close();
                            br.close();
                            break;

                        }

                } catch (
                        IOException e) {
                    e.printStackTrace();
                }



            }
        }
    }


