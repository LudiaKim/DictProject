package Menu;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class MyFrame extends JFrame {

	 public MyFrame() {
	        setTitle("JTable ����");
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        Object[][] data = {{"�̸�1", "��ȭ��ȣ1"}, {"�̸�2", "��ȭ��ȣ2"}};
	        String[] columnNames = {"�̸�", "��ȭ��ȣ"};

	        JTable table = new JTable(data, columnNames);

	        // ù ��° �� �ʺ� 100���� ����
	        TableColumn column0 = table.getColumnModel().getColumn(0);
	        column0.setPreferredWidth(50);

	        // �� ��° �� �ʺ� 200���� ����
	        TableColumn column1 = table.getColumnModel().getColumn(1);
	        column1.setPreferredWidth(200);

	        add(table);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new MyFrame();
	    }
	}
