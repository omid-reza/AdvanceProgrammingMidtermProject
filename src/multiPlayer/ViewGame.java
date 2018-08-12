package multiPlayer;

import classes.User;
import server.SendToServer;
import classes.Time;
import java.util.Map;
import java.awt.Font;
import classes.Letter;
import java.awt.Color;
import java.util.Timer;
import classes.DeadLine;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.TimerTask;
import javax.swing.JButton;
import java.awt.EventQueue;
import javax.swing.JSeparator;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import javax.swing.JProgressBar;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;

public class ViewGame extends JFrame{

	private static final long serialVersionUID = 1L;

    // Global variables :
	private static String player;
	private static int min=1,
					second=0,
					milisecond=0;

	public static void main(String[] args, String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					player=username;
					ViewGame frame = new ViewGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
    // Call classes :
    Letter LetterClass=new Letter();
    DeadLine DeadLineClass=new DeadLine();
    User UserClass=new User(player);
    Time AllTime=new Time(min,second,milisecond);
    
    // Create objects that we need in methods :
    private boolean waitForGo=false;
    private JProgressBar power = new JProgressBar(),
    		TeamPower = new JProgressBar();;

    private JLabel Letter = new JLabel("")
            , deadline = new JLabel(DeadLineClass.getTimer()+"")
            , minTimeLeft = new JLabel(AllTime.getMin()+"")
            , secondTimeLeft = new JLabel(AllTime.getSecond()+"")
            , miliSecondTimeLeft= new JLabel(AllTime.getMillisecond()+"");

    private Timer deadlineTimer = new Timer()
            ,levelTimer= new Timer()
            ,timeLeftTimer= new Timer()
            ,colorSetTimer= new Timer()
            ,waitTGoTimer=new Timer();

    public ViewGame() {
        // Create other objects that we don't need theme in methods :
        JPanel contentPane = new JPanel();
        JDesktopPane desktopPane = new JDesktopPane();
        JLabel label_1 = new JLabel("Time left :"),
                lblNewLabel = new JLabel("My Power :"),
                label = new JLabel("User :"),
                lblTypeTheLetters = new JLabel("type the letters as quickly as possbile"),
                lblNewLabel_1 = new JLabel("Deadline :"),
                user = new JLabel(player),
                label_5 = new JLabel(":"),
                label_6 = new JLabel(":");

        JButton btnExit = new JButton("Exit");

        JSeparator separator = new JSeparator();
        
        //set att to objects :
        lblNewLabel_1.setBounds(142, 330, 81, 23);
        lblNewLabel_1.setForeground(new Color(0, 0, 128));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

        lblNewLabel.setBounds(30, 140, 89, 14);
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

        label_1.setBounds(253, 13, 101, 14);
        label_1.setForeground(new Color(0, 0, 128));
        label_1.setFont(new Font("Tahoma", Font.ITALIC, 16));

        label_5.setBounds(421, 1, 18, 38);
        label_5.setForeground(Color.DARK_GRAY);
        label_5.setFont(new Font("Tahoma", Font.BOLD, 19));

        label_6.setBounds(496, 1, 18, 38);
        label_6.setForeground(Color.DARK_GRAY);
        label_6.setFont(new Font("Tahoma", Font.BOLD, 19));

        user.setBounds(82, 13, 126, 38);
        user.setForeground(Color.DARK_GRAY);
        user.setFont(new Font("Tahoma", Font.BOLD, 15));

        label.setBounds(12, 13, 75, 38);
        label.setForeground(new Color(0, 0, 128));
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        btnExit.setBorder(null);
        btnExit.setBounds(472, 319, 89, 23);
        btnExit.setForeground(Color.DARK_GRAY);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        minTimeLeft.setBounds(366, 1, 31, 38);
        minTimeLeft.setFont(new Font("Tahoma", Font.BOLD, 14));
        minTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);

        secondTimeLeft.setBounds(451, 0, 31, 38);
        secondTimeLeft.setFont(new Font("Tahoma", Font.BOLD, 14));
        secondTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);

        miliSecondTimeLeft.setBounds(515, 1, 31, 38);
        miliSecondTimeLeft.setFont(new Font("Tahoma", Font.BOLD, 14));
        miliSecondTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);

        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setResizable(false);
        setContentPane(contentPane);
        setBounds(620, 250, 650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane.setBounds(0, 0, 650, 500);
        desktopPane.setBackground(new Color(255, 165, 0));

        separator.setBounds(0, 113, 622, 2);  
        
        deadline.setBounds(285, 318, 53, 46);
        deadline.setFont(new Font("Tahoma", Font.BOLD, 15));
    
        lblTypeTheLetters.setBounds(180, 392, 226, 14);
        power.setValue(100);
        power.setForeground(Color.GREEN);
        power.setBounds(120, 140, 218, 23);
        power.setBackground(Color.LIGHT_GRAY);

        Letter.setBounds(169, 239, 237, 66);
        Letter.setFont(new Font("Stencil", Font.PLAIN, 53));
        Letter.setHorizontalAlignment(SwingConstants.CENTER);
        Letter.setText(LetterClass.getrandomletter(UserClass.getLevel()));

		desktopPane.add(user);
        desktopPane.add(power);
        desktopPane.add(label);
        desktopPane.add(Letter);
        desktopPane.add(label_1);
        desktopPane.add(label_5);
        desktopPane.add(label_6);
        desktopPane.add(btnExit);
        desktopPane.add(deadline);
        desktopPane.add(separator);
        contentPane.add(desktopPane);
        desktopPane.add(minTimeLeft);
        desktopPane.add(lblNewLabel);
        desktopPane.add(lblNewLabel_1);
        desktopPane.add(secondTimeLeft);
        desktopPane.add(lblTypeTheLetters);
		desktopPane.add(miliSecondTimeLeft);
		
		JLabel lblTeamPower = new JLabel("Team Power :");
		lblTeamPower.setForeground(new Color(0, 0, 128));
		lblTeamPower.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTeamPower.setBounds(247, 70, 101, 14);
		desktopPane.add(lblTeamPower);
		
		TeamPower.setValue(100);
		TeamPower.setForeground(Color.GREEN);
		TeamPower.setBackground(Color.LIGHT_GRAY);
		TeamPower.setBounds(359, 70, 218, 23);
		desktopPane.add(TeamPower);

        // timer scheduals :
		    // note : time custumized for levels(Every 5 Second -> level+1 )
        schedualwaitTGoTimerMethod();
        schedualColorTimerMethod();
        schedualLevelTimerMethod();
        schedualdeadlineTimerMethod();
        schedualTimeLeftTimerMethod();
        
		// Events :
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	goToSummeryMethod();
            }
        });

        power.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                powerchanged();
            }
        });

        addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyPressed(KeyEvent event) {
				
				if (waitForGo == false) 
					KeyPressedMethod(event);
				
			}
		});

	}

    private void schedualwaitTGoTimerMethod() {
    	waitTGoTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (SendToServer.send("finishOrNot").equals("1")) {
					goToSummeryMethod();
				}
			}
		}, 0,5000);
		
	}

	// Methods :
    private void schedualTimeLeftTimerMethod() {
        timeLeftTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                AllTime.Timer();
                if (AllTime.getMin()==0 && AllTime.getMillisecond()==0 && AllTime.getSecond()==0) {
                	goToSummeryMethod();
                }
                minTimeLeft.setText(AllTime.getMin()+"");
                if (AllTime.getMin()== 0 && AllTime.getSecond()== 10 && AllTime.getMillisecond()==99){
                    minTimeLeft.setForeground(Color.RED);
                    secondTimeLeft.setForeground(Color.RED);
                    miliSecondTimeLeft.setForeground(Color.RED);
                }
                secondTimeLeft.setText(AllTime.getSecond()+"");
                miliSecondTimeLeft.setText(AllTime.getMillisecond()+"");
            }
        }, 0, 1);
    }

    private void schedualdeadlineTimerMethod() {
        deadlineTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(DeadLineClass.getTimer()<0) {
                	SendToServer.send("lessPower", player);
                    UserClass.powerChange(-5);
                    power.setValue(UserClass.getPower());
                    TeamPower.setValue(Integer.parseInt(SendToServer.send("readTeamPowers", player)));
                    Letter.setText(LetterClass.getrandomletter(UserClass.getLevel()));
                    DeadLineClass.setTimer(UserClass.getLevel());
                    deadline.setText(DeadLineClass.getTimer()+"");
                }
                deadline.setText(DeadLineClass.lessTime());
            }
        }, 0, 1);
    }

    private void schedualLevelTimerMethod() {
        levelTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                UserClass.setLevel(UserClass.getLevel()+1);
            }
        }, 0, 5000);
    }

    private void schedualColorTimerMethod() {
        colorSetTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Letter.setForeground(Color.black);
            }
        },1,500);

    }

    private void KeyPressedMethod(KeyEvent event) {
    	
        String input = event.getKeyChar()+"";
        String goal = Letter.getText();
        
        if (LetterClass.LetterChecker(goal,input)) {
            SendToServer.send("insertPower", player);
            UserClass.powerChange(5);
            power.setValue(UserClass.getPower());
            Letter.setForeground(Color.green);
        }else {
        	SendToServer.send("lessPower", player);
            UserClass.powerChange(-5);
            power.setValue(UserClass.getPower());
            Letter.setForeground(Color.RED);
            if (power.getValue() == 0) {
            	waitGo();
            }
        }      

          
        LetterClass.setAnswer(LetterClass.getAnswer()+input);
        int ResualtCheckAnswerCheck = LetterClass.CheckAnswer(goal);
        
        if(ResualtCheckAnswerCheck != -1) {
        	LetterClass.ClearAnswer();
        	Letter.setText(LetterClass.getrandomletter(UserClass.getLevel()));
        	DeadLineClass.setTimer(UserClass.getLevel());
        	deadline.setText(DeadLineClass.getTimer()+"");
        }
        
        TeamPower.setValue(Integer.parseInt(SendToServer.send("readTeamPowers", player)));
    }

    private void waitGo() {
    	deadlineTimer.cancel();
        colorSetTimer.cancel();
        levelTimer.cancel();
        waitForGo=true;
	}

	private void goToSummeryMethod() {
        
        waitGo();
        waitTGoTimer.cancel();

    	if (isVisible()) {
	    	Map<String, String> values=new HashMap<String , String>();
			values.put("username", player);
			setVisible(false);
            SummeryView.main(new String[] {},values);
    	}
	}

    private ChangeListener powerchanged() {
    	
        if(power.getValue()==0) {
        	waitGo();
    	}

    	String color = UserClass.PowerChangedColor(power.getValue());
    	power.setForeground(Color.decode(color));
        return null;
    }
}
