package multiPlayer;

import java.util.Map;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import server.SendToServer;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;

			 
public class SummeryView {
	
	// Create Objects :
	private JFrame frame;
	private JLabel lblResualt = new JLabel("");
	
	// CREATE VARIABLE :
	private static String username;
	private static int myteamPower=Integer.parseInt(SendToServer.send("readTeamPowers", username))
					,enemyTeamPower=Integer.parseInt(SendToServer.send("readEnemyPowers", username));
	
	public static void main(String[] args, Map<String, String> values) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					username = values.get("username");
					SummeryView window = new SummeryView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SummeryView() {

		frame = new JFrame();

		JLabel labelUser = new JLabel(""),
				lblUser = new JLabel("User : ");
		JButton btnExit = new JButton("Exit");

		// ser att to objects :
		btnExit.setBounds(448, 373, 97, 25);
		btnExit.setForeground(new Color(0, 0, 128));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblUser.setBounds(110, 29, 156, 25);
		lblUser.setForeground(new Color(0, 255, 127));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);

		labelUser.setText(username);
		labelUser.setBounds(278, 29, 156, 25);
		labelUser.setForeground(new Color(0, 255, 127));
		labelUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		labelUser.setHorizontalAlignment(SwingConstants.CENTER);

		frame.setResizable(false);
		frame.setBounds(620, 250, 616, 490);
		frame.getContentPane().setBackground(new Color(255, 165, 0));

		// add objects to form :
		frame.getContentPane().add(lblUser);
		frame.getContentPane().add(labelUser);
		frame.getContentPane().add(btnExit);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMyTeamPower = new JLabel("My Team Power :");
		lblMyTeamPower.setForeground(Color.decode("#002642"));
		lblMyTeamPower.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMyTeamPower.setBounds(40, 121, 155, 16);
		frame.getContentPane().add(lblMyTeamPower);
		
		JLabel lblEnemyTeamPower = new JLabel("Enemy Team Power : ");
		lblEnemyTeamPower.setForeground(Color.decode("#002642"));
		lblEnemyTeamPower.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnemyTeamPower.setBounds(12, 188, 183, 16);
		frame.getContentPane().add(lblEnemyTeamPower);
		
		JProgressBar myTeamProgress = new JProgressBar();
		myTeamProgress.setBounds(219, 123, 218, 23);
		myTeamProgress.setValue(myteamPower);
		myTeamProgress.setForeground(Color.GREEN);
		myTeamProgress.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(myTeamProgress);
		
		JProgressBar enemyPowerProgress = new JProgressBar();
		enemyPowerProgress.setBounds(219, 190, 218, 23);
		enemyPowerProgress.setValue(enemyTeamPower);
		enemyPowerProgress.setForeground(Color.GREEN);
		enemyPowerProgress.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(enemyPowerProgress);
		
		lblResualt.setBounds(57, 349, 240, 59);
		frame.getContentPane().add(lblResualt);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setWinner();
		
		// Events :

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void setWinner() {
		String resualt;
		if (myteamPower > enemyTeamPower) {
			resualt="WIN!";
		}else if(myteamPower < enemyTeamPower) {
			resualt="LOSE!";
		}else {
			resualt="EQUAL!";
		}
		lblResualt.setText(resualt);
	}
}