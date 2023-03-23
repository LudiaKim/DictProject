import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import Menu.WordInsert;

public class DicMain extends JDialog {
	private JTextField tfSearch;
	private final int typeAdd = 1;
	private final int typeRemove = 2;
	private final int typeModify = 3;
	private final int typeSelect = 4;
	private static JTable table_1;
	private static JLabel lblSelectWord;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DicMain dialog = new DicMain();
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
	public DicMain() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				showTable();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setTitle("DIY \uC0AC\uC804/\uB2E8\uC5B4\uC7A5");
		setBounds(100, 100, 535, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuFile = new JMenu("파일(F)");
		mnuFile.setMnemonic('F');
		menuBar.add(mnuFile);
		
		JMenuItem mnuExit = new JMenuItem("종료(X)");
		mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		mnuExit.setMnemonic('X');
		mnuExit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0); // 종료 코드
		    }
		});
		mnuFile.add(mnuExit);
		
		JMenu mnuKor = new JMenu("\uAD6D\uC5B4\uC0AC\uC804(K)");
		mnuKor.setMnemonic('K');
		menuBar.add(mnuKor);
		
		JMenuItem mnuKWordAdd = new JMenuItem("\uB2E8\uC5B4 \uCD94\uAC00(A)...");
		mnuKWordAdd.setMnemonic('A');
		mnuKWordAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordInsert wordInsert = new WordInsert();
				wordInsert.setModal(true);
				wordInsert.setVisible(true);
			}
		});
		
		JMenuItem mnuWordGame = new JMenuItem("\uAC8C\uC784\uD558\uAE30");
		mnuWordGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flashcard1 flashcard = new Flashcard1();
				flashcard.setModal(true);
				flashcard.setVisible(true);
			}
		});
		mnuKor.add(mnuWordGame);
		
		mnuKor.addSeparator();
		mnuKWordAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnuKor.add(mnuKWordAdd);
		
		JMenuItem mnuKWordRemove = new JMenuItem("\uB2E8\uC5B4 \uC0AD\uC81C...");
		mnuKWordRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		mnuKor.add(mnuKWordRemove);
		
		JMenuItem mnuKWordModify = new JMenuItem("\uB2E8\uC5B4 \uC218\uC815...");
		mnuKWordModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnuKor.add(mnuKWordModify);
		
		JMenu mnuEng = new JMenu("\uC601\uC5B4\uC0AC\uC804(E)");
		mnuEng.setMnemonic('E');
		menuBar.add(mnuEng);
		
		JMenuItem mnuEWordAdd = new JMenuItem("\uB2E8\uC5B4 \uCD94\uAC00(i)...");
		mnuEWordAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnuEWordAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JMenuItem mnuAllEWordShow = new JMenuItem("\uC804\uCCB4 \uB2E8\uC5B4\uBCF4\uAE30...");
		mnuEng.add(mnuAllEWordShow);
		
		mnuEng.addSeparator();
		mnuEng.add(mnuEWordAdd);
		
		JMenuItem mnuEWordRemove = new JMenuItem("\uB2E8\uC5B4 \uC0AD\uC81C...");
		mnuEWordRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		mnuEng.add(mnuEWordRemove);
		
		JMenuItem mnuEWordModify = new JMenuItem("\uB2E8\uC5B4 \uC218\uC815...");
		mnuEWordModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
			}
		});
		mnuEng.add(mnuEWordModify);
		
		JMenu mnuHelp = new JMenu("도움말(H)");
		mnuHelp.setMnemonic('H');
		menuBar.add(mnuHelp);
		
		JMenuItem mnuHelp2 = new JMenuItem("Help...");
		mnuHelp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DicHelp dicHelp = new DicHelp();
				dicHelp.setModal(true);
				dicHelp.setVisible(true);
			}
		});
		mnuHelp2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnuHelp2.setMnemonic('p');
		mnuHelp.add(mnuHelp2);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnWordAdd = new JButton("");
		/*btnWordAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinBookInsert winBookInsert = new WinBookInsert();
				winBookInsert.setModal(true);
				winBookInsert.setVisible(true);
			}
		});*/
		btnWordAdd.setIcon(new ImageIcon(DicMain.class.getResource("/images/data.png")));
		toolBar.add(btnWordAdd);
		
		toolBar.addSeparator();
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					showSearchResult(tfSearch.getText());
				}
			}
		});
		
		tfSearch.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        // 텍스트 필드를 클릭하면 기본 텍스트가 사라지도록 설정
		    	tfSearch.setText("");
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        // 텍스트 필드가 포커스를 잃으면 기본 텍스트를 다시 설정
		        if (tfSearch.getText().equals("")) {
		        	tfSearch.setText("검색할 단어를 입력하세요");
		        }
		    }
		    
		});
		tfSearch.setText("검색할 단어를 입력하세요");
		tfSearch.setFont(new Font("굴림", Font.BOLD, 20));
		toolBar.add(tfSearch);
		

		tfSearch.setColumns(10);
		
		JButton btnEnter = new JButton("\uC785\uB825");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSearchResult(tfSearch.getText());
			
			}
		});
		
			
		toolBar.add(btnEnter);
		
		toolBar.addSeparator();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		
		
		//table = new JTable(dtm);
		
		
		JMenuItem mnBookBorrow = new JMenuItem("수정");
		mnBookBorrow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		mnBookBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			}
		});
		
		
		/*JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		panel.add(progressBar);*/
		
		
		lblSelectWord = new JLabel("\uD604\uC7AC \uC120\uD0DD\uD55C \uB2E8\uC5B4 :");
		panel.add(lblSelectWord);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	
		
		/*// 컬럼의 너비 정하기
        
	      //0번째 컬럼의 속성 셋팅
		 table_1.getColumnModel().getColumn(0).setMaxWidth(200);
	     table_1.getColumnModel().getColumn(0).setMinWidth(150);
	     table_1.getColumnModel().getColumn(0).setWidth(150);
	     // 1번째 ..... 이런식으로 하면 되겠죠...
	     table_1.getColumnModel().getColumn(1).setMaxWidth(500);
	     table_1.getColumnModel().getColumn(1).setMinWidth(300);
	     table_1.getColumnModel().getColumn(1).setWidth(300);
	     */
	     	     
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table_1, popupMenu);
		
		JMenuItem mnAddWord = new JMenuItem("\uB2E8\uC5B4\uCD94\uAC00");
		popupMenu.add(mnAddWord);
		
		JMenuItem mnRemoveWord = new JMenuItem("\uB2E8\uC5B4\uC0AD\uC81C");
		popupMenu.add(mnRemoveWord);
		
		
		mnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordInsert wordInsert = new WordInsert();
				wordInsert.setModal(true);
				wordInsert.setVisible(true);
				
		
			}
		});
		
		showTable();
		

		 //JTable table = new JTable();
          
	}
		

	protected void pushEnter() {
		// TODO Auto-generated method stub
		
		
	}

	protected void showSearchResult(String sText) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");
			
			//=============================================		
			String sql = "select * from wordTBL WHERE word='" + sText + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			String columnNames1[] = {"단어","뜻"};		
			DefaultTableModel dtm = new DefaultTableModel(columnNames1, 0);
			table_1.setModel(dtm);
			
			while(rs.next()) {
				Vector <String> vec = new Vector<>();
				for(int i=1;i<=2;i++) {
						vec.add(rs.getString(i));
				}
				dtm.addRow(vec);
			}
			rs.close();
			stmt.close();
			//==============================================
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e1) {
			System.out.println("DB 연결 오류");
		} 
		
	}   	/*public WinMain(DefaultTableModel dtm) {
	// TODO Auto-generated constructor stub
	this();
	table.setModel(dtm);
	}*/
	private void showTable() {	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");
			
			//=============================================		
			String sql = "select * from wordTBL";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			String columnNames1[] = {"단어","뜻"};		
			DefaultTableModel dtm = new DefaultTableModel(columnNames1, 0);
			table_1.setModel(dtm);
			
			while(rs.next()) {
				Vector <String> vec = new Vector<>();
				for(int i=1;i<=2;i++) {
						vec.add(rs.getString(i));
				}
				dtm.addRow(vec);
			}
			rs.close();
			stmt.close();
			//==============================================
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e1) {
			System.out.println("DB 연결 오류");
		} 
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					JTable source = (JTable)e.getSource();
					int row = source.rowAtPoint(e.getPoint());
					int col = source.columnAtPoint(e.getPoint());
					if(!source.isRowSelected(row))
						source.changeSelection(row, col, false, false);
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					lblSelectWord.setText("현재 선택한 단어: " + table_1.getValueAt(table_1.getSelectedRow(), 0).toString() );
				}
			}
		});
	}
	}