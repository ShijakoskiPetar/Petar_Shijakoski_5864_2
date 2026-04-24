import java.net.*;
import java.io.*;
public class Server {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter outputToClient = null;
        BufferedReader inputFromClient = null;

        try {
            System.out.println("Starting server on port " + SERVER_PORT + "...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is running and waiting for client connections...");


            clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getInetAddress());


            outputToClient = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
            inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            String clientGreeting = inputFromClient.readLine();
            System.out.println("Client says: " + clientGreeting);
            outputToClient.println("Hello, client! Ready to perform calculations.");


            int number1 = Integer.parseInt(inputFromClient.readLine());
            System.out.println("Received first number: " + number1);

            int number2 = Integer.parseInt(inputFromClient.readLine());
            System.out.println("Received second number: " + number2);


            int sum = number1 + number2;
            outputToClient.println(sum);
            System.out.println("Sent result to client: " + sum);

        } catch (IOException e) {
            System.err.println("Error occurred in server: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format received from client: " + e.getMessage());
        } finally {

            try {
                if (outputToClient != null) outputToClient.close();
                if (inputFromClient != null) inputFromClient.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
                System.out.println("Server shutdown complete.");
            } catch (IOException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}

