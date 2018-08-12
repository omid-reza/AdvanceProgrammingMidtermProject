package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import classes.Team;
import server.ServerThread;

public class Server {
	// CRAETE TEAMS :
	public static Team firstTeam=new Team();
    public static Team secondTeam=new Team();
    
	public static void main (String[] args) { 
        ServerSocket myServerSocket=null;
        ServerThread cliThread=null;
	    try {
	        myServerSocket = new ServerSocket(8000); 
	    }catch(IOException ioe) { 
	        System.exit(-1);
	    }
	    
		while(true) {                        
	        try { 
	        	Socket clientSocket = myServerSocket.accept(); 
                cliThread = new ServerThread(clientSocket);
                cliThread.start(); 
	        } catch(IOException ioe) { 
	            ioe.printStackTrace(); 
	        } 
	    }
    }
	
}
