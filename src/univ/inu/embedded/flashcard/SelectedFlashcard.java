package univ.inu.embedded.flashcard;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import univ.incheon.embedded.EngKoreanCard;
import univ.incheon.embedded.MyDictionary;

public class SelectedFlashcard extends JFrame {
	JPanel p=new JPanel();
    ButtonGroup bg=new ButtonGroup();
    JButton nextBtn=new JButton("Next");
    JRadioButton r1=new JRadioButton();
    JRadioButton r2=new JRadioButton();
    JRadioButton r3=new JRadioButton();
    JRadioButton r4=new JRadioButton();
    JRadioButton correct=null;
    JLabel l=new JLabel(" 영어단어 :    ");
    JTextField engField=new JTextField(15);
    MyDictionary myDictionary=new MyDictionary();
    EngKoreanCard curCard=null;
    Container c=this.getContentPane();
    Vector<String> list=null;
    public SelectedFlashcard(MyDictionary _newmd){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout());
        myDictionary=_newmd;
        curCard=myDictionary.getRandomCard();
        engField.setText(curCard.getEngWord());
        engField.setEditable(false);
        p.add(l);
        p.add(engField);
        nextBtn.addActionListener(new MyListener());
        list=myDictionary.getRandomCardToSelected(curCard);
        r1.setText(list.get(0));
        r1.addActionListener(new MyListener());
        r2.setText(list.get(1));
        r2.addActionListener(new MyListener());
        r3.setText(list.get(2));
        r3.addActionListener(new MyListener());
        r4.setText(list.get(3));
        r4.addActionListener(new MyListener());
        if(list.get(0).equals(curCard.getKorWord()))
        {
            correct=r1;
        }
        else if(list.get(1).equals(curCard.getKorWord()))
        {
            correct=r2;
        }
        else if(list.get(2).equals(curCard.getKorWord()))
        {
            correct=r3;
        }
        else if(list.get(3).equals(curCard.getKorWord()))
        {
            correct=r4;
        }
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        c.add(p);
        c.add(r1);
        c.add(r2);
        c.add(r3);
        c.add(r4);
        c.add(nextBtn);
        
        this.setSize(300,150);
        this.setVisible(true);
    }
    public class MyListener implements ActionListener{
        
        public void actionPerformed(ActionEvent E) {
            
            if(E.getSource()==nextBtn){
                curCard=myDictionary.getRandomCard();
                engField.setText(curCard.getEngWord());
                list=myDictionary.getRandomCardToSelected(curCard);
                bg.clearSelection();
                r1.setText(list.get(0));
                r2.setText(list.get(1));
                r3.setText(list.get(2));
                r4.setText(list.get(3));
                if(list.get(0).equals(curCard.getKorWord()))
                {
                    correct=r1;
                }
                else if(list.get(1).equals(curCard.getKorWord()))
                {
                    correct=r2;
                }
                else if(list.get(2).equals(curCard.getKorWord()))
                {
                    correct=r3;
                }
                else if(list.get(3).equals(curCard.getKorWord()))
                {
                    correct=r4;
                }
            }
            else
            {
                if(E.getSource()==correct){
                    System.out.println("Correct!");
                    curCard=myDictionary.getRandomCard();
                    engField.setText(curCard.getEngWord());
                    list=myDictionary.getRandomCardToSelected(curCard);
                    bg.clearSelection();
                    r1.setText(list.get(0));
                    r2.setText(list.get(1));
                    r3.setText(list.get(2));
                    r4.setText(list.get(3));
                    if(list.get(0).equals(curCard.getKorWord()))
                    {
                        correct=r1;
                    }
                    else if(list.get(1).equals(curCard.getKorWord()))
                    {
                        correct=r2;
                    }
                    else if(list.get(2).equals(curCard.getKorWord()))
                    {
                        correct=r3;
                    }
                    else if(list.get(3).equals(curCard.getKorWord()))
                    {
                        correct=r4;
                    }
                }
                else{
                    System.out.println("Wrong!");
                }
            }
        }
    }
}
