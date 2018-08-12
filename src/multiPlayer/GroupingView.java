package multiPlayer;

import java.awt.EventQueue;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import server.SendToServer;

public class GroupingView {
	
	//CREATE GLOBAL VARIABLES :
	public static String username="";
	private JFrame frame;
	private Timer refreshTeams;
	
	public static void main(String[] args, Map<String, String> values) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					username=values.get("username");
					GroupingView window = new GroupingView();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//CONSTRUCTOR :
	public GroupingView() throws IOException {
		// INSERT USER TO TEAM :
		SendToServer.send("insertUser", username);
		// CREATE AND SET FORM : 
		initialize();
		
	}

	private void initialize() throws FileNotFoundException {
		// CREATE LOCAL OBJECTS :
		frame = new JFrame();
		refreshTeams= new Timer();
		JLabel lblTeamA = new JLabel("Team A"),
							 lblTeamB = new JLabel("Team B"),
							 status = new JLabel("Waiting For Other Players ..."),
							 firstTeamMembers = new JLabel("<html>1. "+SendToServer.send("readFirstTeamNames", "0")+"<br>2. "+SendToServer.send("readFirstTeamNames", "1")+"<br>3. "+SendToServer.send("readFirstTeamNames", "2")+"<br>4. "+SendToServer.send("readFirstTeamNames", "3")+"</html>"),
							 secondTeamMembers = new JLabel("<html>1. "+SendToServer.send("readSecondTeamNames", "0")+"<br>2. "+SendToServer.send("readSecondTeamNames", "1")+"<br>3. "+SendToServer.send("readSecondTeamNames", "2")+"<br>4. "+SendToServer.send("readSecondTeamNames", "3")+"</html>");
							 
		// SET ATT TO OBJECTS :
		frame.setBounds(100, 100, 607, 445);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblTeamA.setBounds(88, 76, 56, 16);
		lblTeamA.setForeground(Color.DARK_GRAY);
		lblTeamA.setFont(new Font("Tahoma", Font.BOLD, 15));

		
		lblTeamB.setBounds(412, 76, 56, 16);
		lblTeamB.setForeground(Color.DARK_GRAY);
		lblTeamB.setFont(new Font("Tahoma", Font.BOLD, 15));
		

		firstTeamMembers.setBounds(33, 116, 181, 157);
		firstTeamMembers.setForeground(new Color(0, 0, 255));
		firstTeamMembers.setVerticalAlignment(SwingConstants.TOP);
		firstTeamMembers.setFont(new Font("Tahoma", Font.PLAIN, 17));
		firstTeamMembers.setHorizontalAlignment(SwingConstants.LEFT);

		secondTeamMembers.setBounds(327, 117, 250, 156);
		secondTeamMembers.setForeground(new Color(220, 20, 60));
		secondTeamMembers.setVerticalAlignment(SwingConstants.TOP);
		secondTeamMembers.setHorizontalAlignment(SwingConstants.LEFT);
		secondTeamMembers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		status.setBounds(146, 286, 195, 16);
		status.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// INSERT OBJECTS TO FRORM : 
		frame.getContentPane().add(status);
		frame.getContentPane().add(lblTeamA);
		frame.getContentPane().add(lblTeamB);
		frame.getContentPane().add(firstTeamMembers);
		frame.getContentPane().add(secondTeamMembers);
		
//		 TIMER TO SEE ALIVE INSERTED MEMBERS TO TEAM :
		refreshTeams.schedule(new TimerTask() {
			@Override
			public void run() {
				firstTeamMembers.setText("<html>1. "+SendToServer.send("readFirstTeamNames", "0")+"<br>2. "+SendToServer.send("readFirstTeamNames", "1")+"<br>3. "+SendToServer.send("readFirstTeamNames", "2")+"<br>4. "+SendToServer.send("readFirstTeamNames", "3")+"</html>");
				secondTeamMembers.setText("<html>1. "+SendToServer.send("readSecondTeamNames", "0")+"<br>2. "+SendToServer.send("readSecondTeamNames", "1")+"<br>3. "+SendToServer.send("readSecondTeamNames", "2")+"<br>4. "+SendToServer.send("readSecondTeamNames", "3")+"</html>");
				if ((SendToServer.send("firstTeamMembersCount").equals("4")) && (SendToServer.send("secondTeamMembersCount").equals("4"))) {
					frame.setVisible(false);
					ViewGame.main(new String[] {},username);
					refreshTeams.cancel();
				}
			}
		}, 0,100);

	}
}