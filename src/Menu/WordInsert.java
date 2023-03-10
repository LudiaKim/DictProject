package Menu;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class WordInsert extends JDialog {
	private JTextField tfWord;
	private JTextField tfMean;

	//private String sUrl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordInsert dialog = new WordInsert();
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
	public WordInsert() {
		setResizable(false);
		setModal(true);
		setTitle("\uB0B4 \uB2E8\uC5B4 \uB9CC\uB4E4\uAE30 (\uB2E8\uC5B4 \uC785\uB825\uCC3D)");
		setBounds(100, 100, 421, 253);
		getContentPane().setLayout(null);
		
		/*String imgUrl = "https://shopping-phinf.pstatic.net/main_3246352/32463527641.20230207163644.jpg";
		sUrl = imgUrl;
		imgUrl = "<html><img src='" + imgUrl + "' width=150 height=200></html>";*/
		
		JLabel lblWord = new JLabel("\uB2E8\uC5B4:");
		lblWord.setBounds(26, 25, 57, 15);
		getContentPane().add(lblWord);
		
		JLabel lblMean = new JLabel("\uB73B:");
		lblMean.setBounds(26, 55, 57, 15);
		getContentPane().add(lblMean);
		
		
	
		tfWord = new JTextField();		
		tfWord.setBounds(65, 22, 116, 21);
		tfWord.setColumns(10);
		getContentPane().add(tfWord);
		
		JButton btnAdd = new JButton("�߰�");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWord();
				dispose();
			}
		});
		btnAdd.setBounds(261, 164, 123, 34);
		getContentPane().add(btnAdd);
		
		JButton btnDup = new JButton("�ߺ�Ȯ��");
		btnDup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isDuplicated(tfWord.getText())) {
					JOptionPane.showMessageDialog(null, "�̹� �����ϴ� �ܾ� �Դϴ�");
				}else {
					tfMean.requestFocus();
				}
			}
		});
		btnDup.setBounds(222, 21, 97, 23);
		getContentPane().add(btnDup);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 57, 319, 97);
		getContentPane().add(scrollPane);
		
		tfMean = new JTextField();
		scrollPane.setViewportView(tfMean);
		tfMean.setColumns(10);

	}

	protected void addWord() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");			
			//=============================================		
			String sql = "insert into wordTBL values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tfWord.getText());
			pstmt.setString(2, tfMean.getText());
			pstmt.executeUpdate();
			
			pstmt.close();			
			//==============================================
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e1) {
			System.out.println("DB ���� ����");
		} 		
	}

	protected boolean isDuplicated(String sWord) {
		//DB ���� => �����ϴ��� select������ �Ǵ��ϱ�
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");			
			//=============================================		
			String sql = "select count(*) from wordTBL where word='" + sWord + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getInt(1) == 1) // �ߺ�
					return true;
				else
					return false;
			}
			rs.close();
			stmt.close();
			//==============================================
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e1) {
			System.out.println("DB ���� ����");
		} 
		return false;
	}

	protected boolean isDigit(String temp) {
		if(temp.matches("\\d+"))
			return true;
		else 
			return false;
	}
}
