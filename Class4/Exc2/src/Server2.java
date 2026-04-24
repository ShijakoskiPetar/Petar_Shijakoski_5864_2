import java.io.*;
import java.net.*;
class Server2 {

    private static final int PORT = 8080;

    public static void main(String argv[]) {

        String clientMessage;
        String uppercaseMessage;
        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            System.out.println("Waiting for clients...");


            while(true) {

                Socket connectionSocket = serverSocket.accept();
                System.out.println("Client connected from: " + connectionSocket.getInetAddress());


                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream toClient = new DataOutputStream(
                        connectionSocket.getOutputStream());


                clientMessage = fromClient.readLine();
                System.out.println("Received: " + clientMessage);


                uppercaseMessage = clientMessage.toUpperCase() + '\n';


                toClient.writeBytes(uppercaseMessage);
                System.out.println("Sent: " + uppercaseMessage.trim());


                connectionSocket.close();
                System.out.println("Client disconnected. Waiting for new connections...\n");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {

            try {
                if (serverSocket != null) {
                    serverSocket.close();
                    System.out.println("Server socket closed.");
                }
            } catch (IOException e) {
                System.err.println("Error closing server socket: " + e.getMessage());
            }
        }
    }
}