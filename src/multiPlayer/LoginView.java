package multiPlayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView {
		// Create objects :
		private JFrame frame;
		private JTextField name = new JTextField();
		private final JLabel TimerError = new JLabel("");

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginView window = new LoginView();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public LoginView() {
			// Create objects :
			frame = new JFrame();
			JButton btnGoToGroupingPage = new JButton("Go to Grouping page");
			JLabel nameError = new JLabel(""), lblName = new JLabel("name :");
			
			// set att to objects :
			name.setForeground(Color.decode("#002642"));
			name.setColumns(10);
			name.setBounds(231, 170, 198, 22);
			name.setFont(new Font("Tahoma", Font.BOLD, 17));

			btnGoToGroupingPage.setBounds(168, 316, 261, 47);
			btnGoToGroupingPage.setForeground(Color.decode("#840032"));
			btnGoToGroupingPage.setBackground(Color.decode("#E59500"));
			btnGoToGroupingPage.setFont(new Font("Tahoma", Font.BOLD, 17));

			nameError.setForeground(Color.RED);
			nameError.setBounds(106, 69, 396, 16);
			nameError.setFont(new Font("Tahoma", Font.BOLD, 15));
			nameError.setHorizontalAlignment(SwingConstants.CENTER);

			TimerError.setForeground(Color.RED);
			TimerError.setBounds(177, 244, 239, 16);
			TimerError.setFont(new Font("Tahoma", Font.BOLD, 15));
			TimerError.setHorizontalAlignment(SwingConstants.CENTER);

			lblName.setBounds(134, 172, 85, 16);
			lblName.setForeground(Color.decode("#E59500"));
			lblName.setFont(new Font("Tahoma", Font.BOLD, 20));

			// Add objects to form :
			frame.setResizable(false);
			frame.getContentPane().add(name);
			frame.getContentPane().add(lblName);
			frame.setBounds(620, 250, 629, 508);
			frame.getContentPane().add(btnGoToGroupingPage);
			frame.getContentPane().add(nameError);
			frame.getContentPane().add(TimerError);
			frame.getContentPane().setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setBackground(Color.decode("#840032"));

			// Events :
			name.addFocusListener(new FocusListener() {

				@Override public void focusLost(FocusEvent e) { /* TODO Auto-generated method stub */}
				
				@Override
				public void focusGained(FocusEvent e) {
					if (name.getText().length() == 0) {
						name.setBackground(Color.white);
						nameError.setText(null);
					}
				}
			});
			
			btnGoToGroupingPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (name.getText().length() == 0) {
						name.setBackground(Color.RED);
						nameError.setText("name cant be empty!");
					}else {
						GoToGroupingView();
					}
				}
			});

		}

		// Methods :
		private void GoToGroupingView() {
			frame.setVisible(false);
			Map<String, String> values = new HashMap<String, String>();
			values.put("username", name.getText());
			GroupingView.main(new String[] {}, values);
		}
}
