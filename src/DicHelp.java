import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DicHelp extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DicHelp dialog = new DicHelp();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DicHelp() {
		setResizable(false);
		setTitle("도움말");
		setBounds(100, 100, 339, 177);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DicHelp.class.getResource("/images/ludia.jpg")));
		lblNewLabel.setBounds(24, 10, 106, 120);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("만든사람: 김루디아");
		lblNewLabel_1.setBounds(149, 10, 155, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("연락처: 010-4193-7001");
		lblNewLabel_1_1.setBounds(149, 42, 155, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("email: pipipi9022@gmail.com");
		lblNewLabel_1_1_1.setBounds(149, 74, 167, 15);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(149, 106, 97, 23);
		getContentPane().add(btnNewButton);

	}
}
