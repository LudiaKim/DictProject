package Menu;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class MyFrame extends JFrame {

	 public MyFrame() {
	        setTitle("JTable 예제");
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        Object[][] data = {{"이름1", "전화번호1"}, {"이름2", "전화번호2"}};
	        String[] columnNames = {"이름", "전화번호"};

	        JTable table = new JTable(data, columnNames);

	        // 첫 번째 열 너비를 100으로 설정
	        TableColumn column0 = table.getColumnModel().getColumn(0);
	        column0.setPreferredWidth(50);

	        // 두 번째 열 너비를 200으로 설정
	        TableColumn column1 = table.getColumnModel().getColumn(1);
	        column1.setPreferredWidth(200);

	        add(table);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new MyFrame();
	    }
	}
