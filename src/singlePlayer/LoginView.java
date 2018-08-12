package singlePlayer;

import java.util.Map;
import java.awt.Font;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class LoginView {
	// Create VARIABLES :
	private String[] secondArray = { "0", "10", "20", "30", "40", "50" },
			minArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" },
			miliSecondArray = { "0", "100", "200", "300", "400", "500", "600", "700", "800", "900" },
			levelArray = { "easy", "normal", "hard" };
	// Create objects :
	private JFrame frame;
	private JTextField name = new JTextField();
	private final JLabel TimerError = new JLabel("");
	private final JButton btnDeafualtTime = new JButton("Deafualt Time");

	private JComboBox MincomboBox = new JComboBox(minArray), secondcomboBox = new JComboBox(secondArray),
			milisecondComboBox = new JComboBox(miliSecondArray), levelcomboBox = new JComboBox(levelArray);

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
		// Create objects :a
		frame = new JFrame();
		JButton btnStart = new JButton("start");
		JLabel nameError = new JLabel(""), lblMin = new JLabel("min  :"), lblName = new JLabel("name :"),
				lblSecond = new JLabel("second :"), lblMiliSecond = new JLabel("mili second :");

		// set att to objects :
		name.setColumns(10);
		name.setBounds(228, 110, 171, 22);
		name.setFont(new Font("Tahoma", Font.BOLD, 17));

		MincomboBox.setBounds(94, 196, 46, 22);

		secondcomboBox.setBounds(247, 196, 46, 22);

		milisecondComboBox.setBounds(463, 196, 46, 22);

		btnStart.setBounds(235, 387, 97, 25);
		btnStart.setForeground(new Color(50, 205, 50));
		btnStart.setBackground(new Color(255, 250, 240));
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 17));

		nameError.setForeground(Color.RED);
		nameError.setBounds(106, 69, 396, 16);
		nameError.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameError.setHorizontalAlignment(SwingConstants.CENTER);

		TimerError.setForeground(Color.RED);
		TimerError.setBounds(177, 244, 239, 16);
		TimerError.setFont(new Font("Tahoma", Font.BOLD, 15));
		TimerError.setHorizontalAlignment(SwingConstants.CENTER);

		btnDeafualtTime.setBounds(445, 244, 139, 25);
		btnDeafualtTime.setForeground(new Color(0, 0, 128));
		btnDeafualtTime.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblMin.setBounds(27, 199, 70, 16);
		lblMin.setForeground(new Color(0, 0, 139));
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblSecond.setBounds(152, 199, 90, 16);
		lblSecond.setForeground(new Color(0, 0, 139));
		lblSecond.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblMiliSecond.setBounds(305, 196, 133, 16);
		lblMiliSecond.setForeground(new Color(0, 0, 139));
		lblMiliSecond.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblName.setBounds(133, 113, 85, 16);
		lblName.setForeground(new Color(0, 0, 128));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));

		// Add objects to form :
		frame.setResizable(false);
		frame.getContentPane().add(name);
		frame.getContentPane().add(lblMin);
		frame.getContentPane().add(lblName);
		frame.setBounds(620, 250, 629, 508);
		frame.getContentPane().add(btnStart);
		frame.getContentPane().add(nameError);
		frame.getContentPane().add(lblSecond);
		frame.getContentPane().add(TimerError);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(MincomboBox);
		frame.getContentPane().add(lblMiliSecond);
		frame.getContentPane().add(secondcomboBox);
		frame.getContentPane().add(btnDeafualtTime);
		frame.getContentPane().add(milisecondComboBox);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 165, 0));

		levelcomboBox.setBounds(27, 318, 70, 22);
		frame.getContentPane().add(levelcomboBox);

		// Events :
		name.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (name.getText().length() == 0) {
					name.setBackground(Color.white);
					nameError.setText(null);
				}
			}
		});

		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) {
					name.setBackground(Color.RED);
					nameError.setText("name field can not be empty!");
				} else {
					if (MincomboBox.getSelectedItem() == "0" && secondcomboBox.getSelectedItem() == "0"
							&& milisecondComboBox.getSelectedItem() == "0") {
						MincomboBox.setForeground(Color.red);
						secondcomboBox.setForeground(Color.red);
						milisecondComboBox.setForeground(Color.red);
						TimerError.setText("Time can't be zero!");
					} else {
						goTOViewGameMethod();
					}
				}

			}
		});

		MincomboBox.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusGained(FocusEvent e) {
				setTimerBackMethod();
			}
		});

		secondcomboBox.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusGained(FocusEvent e) {
				setTimerBackMethod();
			}
		});

		milisecondComboBox.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusGained(FocusEvent e) {
				setTimerBackMethod();
			}
		});

		btnDeafualtTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				defaultMehod();
			}
		});
	}

	// Methods :
	private void goTOViewGameMethod() {
		frame.setVisible(false);
		Map<String, String> values = new HashMap<String, String>();
		values.put("username", name.getText());
		values.put("level", levelcomboBox.getSelectedItem().toString());
		values.put("min", MincomboBox.getSelectedItem().toString());
		values.put("second", secondcomboBox.getSelectedItem().toString());
		values.put("milisecond", milisecondComboBox.getSelectedItem().toString());
		ViewGame.main(new String[] {}, values);
	}

	private void defaultMehod() {
		MincomboBox.setSelectedItem("1");
		secondcomboBox.setSelectedItem("0");
		milisecondComboBox.setSelectedItem("0");

	}

	private void setTimerBackMethod() {
		TimerError.setText(null);
		MincomboBox.setForeground(Color.BLACK);
		secondcomboBox.setForeground(Color.BLACK);
		milisecondComboBox.setForeground(Color.BLACK);
	}
}