package httpservertut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
/**
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class, serving one client at a time.
 * 
 * @author https://javarevisited.blogspot.com/2015/06/how-to-create-http-server-in-java-serversocket-example.html
 */
public class HTTPServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Listening for connection on port 8080 ....");
		while(true) {
			try(Socket clientSocket = server.accept()){
			/*Valasz a kliensnek*/
			Date today = new Date();
			String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
			clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			
			/*adatok a kliensrol*/
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			while(!line.isEmpty())
			{
				System.out.println(line);
				line = reader.readLine();
			}
			}
			
		}

	}

}
