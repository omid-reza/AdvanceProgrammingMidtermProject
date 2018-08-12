package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SendToServer {
	private static Socket socket=null;
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static String send(String route) {
		return send(route, "");
	}
	
	public static String send(String route,String content) {
		try {
			socket = new Socket("127.0.0.1", 8000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.println(route);
			out.println(content);
			out.flush();
			return(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
		
	}
}
