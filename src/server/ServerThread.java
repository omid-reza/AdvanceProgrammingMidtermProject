package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket myClientSocket;

	public ServerThread(Socket myClientSocket) {
		this.myClientSocket = myClientSocket;
	}
	public void run() {
		BufferedReader in = null; 
        PrintWriter out = null; 
        try {
        	in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream())); 
			out = new PrintWriter(new OutputStreamWriter(myClientSocket.getOutputStream()));
			String route = in.readLine();
			String content = in.readLine();
			out.print(Router.routeing(route,content));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
            try {                    
                in.close(); 
                out.close(); 
                myClientSocket.close();
            } catch(IOException ioe){ 
                ioe.printStackTrace(); 
            } 
        }    
	}
}
