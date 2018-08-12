package index;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Index {
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() throws FileNotFoundException{
		initialize();
	}

	private void initialize() {
		//CREATE OBJECTS :
		frame = new JFrame();		
		JButton btnSinglePlayer = new JButton("Single Player");
		
		
		JButton singlePlayerInfo = new JButton("!"),
		 		multiPlayerInfo = new JButton("!"),
				btnMultiPlayer = new JButton("Multi PLayer");
		
		JLabel info = new JLabel(""),
				lblFastTyper = new JLabel("FAst Typer");

		// ADD ATT TO OBJECTS :
		btnMultiPlayer.setBounds(465, 274, 126, 25);

		btnSinglePlayer.setBounds(91, 274, 126, 25);

		lblFastTyper.setHorizontalAlignment(SwingConstants.CENTER);
		lblFastTyper.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblFastTyper.setForeground(Color.ORANGE);
		lblFastTyper.setBounds(195, 64, 285, 152);
		
		singlePlayerInfo.setBounds(50, 274, 37, 25);
		
		multiPlayerInfo.setBounds(594, 274, 37, 25);

		info.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info.setVerticalAlignment(SwingConstants.TOP);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBounds(50, 382, 657, 67);

		//ADD OBJECTS TO FRAME :
		frame.setResizable(false);
		frame.getContentPane().add(info);
		frame.setBounds(100, 100, 736, 497);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblFastTyper);
		frame.getContentPane().add(btnMultiPlayer);
		frame.getContentPane().add(btnSinglePlayer);
		frame.getContentPane().add(multiPlayerInfo);
		frame.getContentPane().add(singlePlayerInfo);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//EVENTS :
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				singlePlayer.LoginView.main(null);
			}
		});

		btnMultiPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				multiPlayer.LoginView.main(null);
			}
		});

		multiPlayerInfo.addMouseListener(new  MouseListener() {
			
			@Override public void mouseReleased(MouseEvent e) { /* TODO Auto-generated method stub */ }
			@Override public void mouseClicked(MouseEvent e) { /* TODO Auto-generated method stub */ }
			@Override public void mousePressed(MouseEvent e) { /* TODO Auto-generated method stub */ }
			
			@Override
			public void mouseExited(MouseEvent e) {
				info.setText(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				info.setText("<html>multi player : <br> - play with others <br> - time is just 4 min!</html>");	
			}
		});

		singlePlayerInfo.addMouseListener(new MouseListener() {
			
			@Override public void mouseReleased(MouseEvent e) { /* TODO Auto-generated method stub */ }
			@Override public void mousePressed(MouseEvent e) { /* TODO Auto-generated method stub */ }			
			@Override public void mouseClicked(MouseEvent e) { /* TODO Auto-generated method stub */ }

			@Override
			public void mouseExited(MouseEvent e) {
				info.setText(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				info.setText("<html>single player : <br> - can playe between 20 sec to 10 min</html>");
			}
		});
	}
}