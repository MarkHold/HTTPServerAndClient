package Problem1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Markus Lykonhold on 08/04/17.
 */
public class HTTPServerClass {

    public static void main(String[] args) {

        int portNumber = 4000;         // creating an Int for the port, which is already defined.

        ServerSocket serverSocket = null;                       //Creating the server socket

        try {                                                       //First of we set the serverSocket to the port
            // and see if it connects
            serverSocket = new ServerSocket(portNumber);

            System.out.println("connection started");
git
        } catch (IOException e) {                                       //If not , an exception will be thrown
            System.out.println("Could not connect to port");}


        try {                                                           // then we try to accept the connection
            while (true) {
                 Socket s = serverSocket.accept();
                (new HTTPClientClass(s)).run();
            }
        } catch (IOException e) {                                       //If not, an exception will be thrown
            System.out.println("accept failed");
            System.exit(1);
        }

    }
}
