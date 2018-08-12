package singlePlayer;

import java.util.Map;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

public class SummeryView {
	// Create Objects :
	private JFrame frame;
	// Create VARIABLES :
	private static String username, correctAnswers, allAnswers, correctLetter, allLetter;

	public static void main(String[] args, Map<String, String> values) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					correctAnswers = values.get("correctAnswers");
					allAnswers = values.get("allAnswers");
					correctLetter = values.get("correctLetter");
					allLetter = values.get("allLetter");
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
				lblUser = new JLabel("User : "),
				AllLetter = new JLabel(allLetter),
				lblLetters = new JLabel("Letters"),
				lblAnswers = new JLabel("Answers"),
				ALlAnswers = new JLabel(allAnswers),
				CorrectLetter = new JLabel(correctLetter),
				CorrectAnswer = new JLabel(correctAnswers),
				lblCorrecyAnswerFrom = new JLabel("Correct letter from "),
				lblCorrectAnswertfrom = new JLabel("Correct answer from ");

		JButton btnExit = new JButton("Exit"), btnTryAgain = new JButton("try again");

		// ser att to objects :
		btnExit.setBounds(448, 373, 97, 25);
		btnExit.setForeground(new Color(0, 0, 128));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblCorrecyAnswerFrom.setBounds(143, 121, 235, 16);
		lblCorrecyAnswerFrom.setForeground(new Color(105, 105, 105));
		lblCorrecyAnswerFrom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCorrecyAnswerFrom.setHorizontalAlignment(SwingConstants.CENTER);

		CorrectLetter.setBounds(75, 112, 56, 31);
		CorrectLetter.setForeground(new Color(0, 128, 0));
		CorrectLetter.setFont(new Font("Tahoma", Font.BOLD, 25));
		CorrectLetter.setHorizontalAlignment(SwingConstants.CENTER);

		AllLetter.setBounds(390, 121, 41, 19);
		AllLetter.setForeground(new Color(0, 0, 0));
		AllLetter.setFont(new Font("Tahoma", Font.BOLD, 25));

		lblLetters.setBounds(351, 121, 235, 16);
		lblLetters.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLetters.setForeground(SystemColor.controlDkShadow);
		lblLetters.setHorizontalAlignment(SwingConstants.CENTER);

		lblCorrectAnswertfrom.setBounds(143, 179, 235, 16);
		lblCorrectAnswertfrom.setForeground(SystemColor.controlDkShadow);
		lblCorrectAnswertfrom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCorrectAnswertfrom.setHorizontalAlignment(SwingConstants.CENTER);

		lblAnswers.setBounds(413, 185, 132, 16);
		lblAnswers.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnswers.setForeground(SystemColor.controlDkShadow);
		lblAnswers.setHorizontalAlignment(SwingConstants.CENTER);

		CorrectAnswer.setBounds(75, 170, 56, 31);
		CorrectAnswer.setForeground(new Color(0, 128, 0));
		CorrectAnswer.setFont(new Font("Tahoma", Font.BOLD, 25));
		CorrectAnswer.setHorizontalAlignment(SwingConstants.CENTER);

		ALlAnswers.setForeground(Color.BLACK);
		ALlAnswers.setBounds(390, 182, 41, 19);
		ALlAnswers.setFont(new Font("Tahoma", Font.BOLD, 25));

		lblUser.setBounds(110, 29, 156, 25);
		lblUser.setForeground(new Color(0, 255, 127));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);

		labelUser.setText(username);
		labelUser.setBounds(278, 29, 156, 25);
		labelUser.setForeground(new Color(0, 255, 127));
		labelUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		labelUser.setHorizontalAlignment(SwingConstants.CENTER);

		btnTryAgain.setBounds(429, 312, 132, 31);
		btnTryAgain.setForeground(new Color(0, 0, 128));
		btnTryAgain.setFont(new Font("Tahoma", Font.BOLD, 20));

		frame.setResizable(false);
		frame.setBounds(620, 250, 616, 490);
		frame.getContentPane().setBackground(new Color(255, 165, 0));

		// add objects to form :
		frame.getContentPane().add(lblUser);
		frame.getContentPane().add(labelUser);
		frame.getContentPane().add(btnExit);
		frame.getContentPane().add(AllLetter);
		frame.getContentPane().add(lblLetters);
		frame.getContentPane().add(lblAnswers);
		frame.getContentPane().add(ALlAnswers);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnTryAgain);
		frame.getContentPane().add(CorrectAnswer);
		frame.getContentPane().add(CorrectLetter);
		frame.getContentPane().add(lblCorrecyAnswerFrom);
		frame.getContentPane().add(lblCorrectAnswertfrom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Events :
		btnTryAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginView.main(new String[] {});
			}
		});

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}