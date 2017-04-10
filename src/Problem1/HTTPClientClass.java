package Problem1;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

/**
    Created by Markus Lykonhold on 08/04/17.
 */
public class HTTPClientClass implements Runnable {

    //the clientsocket is created here
    protected Socket clientSocket = null;

    //here we bind the socket with the class
    public HTTPClientClass(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    //the method for opening the stream, taking the request and responsing
    public void run() {
        try {
            //input and output streams for the socket
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();


           /*a time variable in order to log the time it takes to
           proccess the request
            */
            long time = System.currentTimeMillis();


            //here we write to the localhost, we send in the http resposne
            //and the html page details as well as request proccess time.
            output.write(("HTTP/1.1 200 OK\n\n<html><body>" +
                    "Singlethreaded Server: " + time +"</body></html>").getBytes());

            //here we close the streams and print out the time in the console
            input.close();
            output.close();

            int seconds = (int) (time / 1000) % 60 ;
            System.out.println("Request proccess time: " + seconds);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}

