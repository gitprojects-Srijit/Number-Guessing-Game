import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Game_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputtxt;
	JLabel roundlbl;
	JLabel output1blb;
	JLabel output3lbl;
	
	private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    int totalScore = 0, i = 1;
    int attempts = 0, number = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_1 frame = new Game_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game_1() {
		
		 Random random = new Random();
		
		 number = random.nextInt(MAX_RANGE) + MIN_RANGE;
         
		 //System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUMBER GUESSING GAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(170, 30, 214, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Instructions :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(33, 63, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-> Total Number Of Rounds : 3");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 89, 394, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("-> Attempts To Guess Number In Each Round : 10");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(33, 114, 394, 14);
		contentPane.add(lblNewLabel_2_1);
		
		roundlbl = new JLabel("Round 1: Guess the number between 1 and 100 in 10 attempts.");
		roundlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		roundlbl.setBounds(33, 148, 489, 14);
		contentPane.add(roundlbl);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Your guess : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(33, 191, 138, 20);
		contentPane.add(lblNewLabel_4);
		
		inputtxt = new JTextField();
		inputtxt.setBounds(170, 193, 86, 20);
		contentPane.add(inputtxt);
		inputtxt.setColumns(10);
		
		output1blb = new JLabel("");
		output1blb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		output1blb.setBounds(33, 226, 500, 20);
		contentPane.add(output1blb);
		
		output3lbl = new JLabel("");
		output3lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		output3lbl.setBounds(33, 301, 500, 20);
		contentPane.add(output3lbl);
		
		JButton submitbtn = new JButton("Submit");
		submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(attempts < MAX_ATTEMPTS)
				 	{
				 		int guess_number = Integer.parseInt( inputtxt.getText().toString());
			            attempts = attempts + 1;

			            if (guess_number == number) 
			            {
			                int score = MAX_ATTEMPTS - attempts;
			                totalScore = totalScore + score;
			                output1blb.setText("Hurray! Number Guessed Successfully. Attempts = "+score+". Round Score = "+score);
			                
			                
			                if(i<MAX_ROUNDS)
							{
			                	i++;
				                Random random = new Random();
				                number = random.nextInt(MAX_RANGE) + MIN_RANGE;
				                attempts = 0;
				                
				                roundlbl.setText("Round "+i+": Guess the number between "+MIN_RANGE+" and "+MAX_RANGE+" in "+MAX_ATTEMPTS+" attempts.");
				                output3lbl.setText("Start Round: "+i);
				                
				                inputtxt.setText("");
							}
			                else
							{
								output1blb.setText("Game Over. Total Score = "+totalScore);
								output3lbl.setText("");
								inputtxt.setText("");
								
								inputtxt.setVisible(false);
								submitbtn.setVisible(false);
								lblNewLabel_4.setVisible(false);
							}
			            }
			            
			            else if (guess_number < number) {
			            	output1blb.setText("The number is greater than "+guess_number+". Try Again. Attempts Left = "+(MAX_ATTEMPTS - attempts)+".\n");
			            	inputtxt.setText("");
			            }

			            else if (guess_number > number) {
			            	output1blb.setText("The number is less than "+guess_number+". Try Again.  Attempts Left = "+(MAX_ATTEMPTS - attempts));
			            	inputtxt.setText("");
			            }
				 	};
				 	
				 	if (attempts == MAX_ATTEMPTS) {
				 		output1blb.setText("\nRound ="+i+". Attempts = 0");
				 		output3lbl.setText("The Random Number Is : "+ number);
				 		
				 		output1blb.setText("Game Over. Total Score = "+totalScore);
			
						inputtxt.setVisible(false);
						submitbtn.setVisible(false);
						lblNewLabel_4.setVisible(false);
			        }
				}
				
			
		});
		submitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		submitbtn.setBounds(270, 192, 89, 23);
		contentPane.add(submitbtn);
				
		roundlbl.setText("Round "+i+": Guess the number between "+MIN_RANGE+" and "+MAX_RANGE+" in "+MAX_ATTEMPTS+" attempts.");
	}
}