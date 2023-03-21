package univ.inu.embedded.flashcard;
 
import univ.incheon.embedded.*;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class Flashcard extends JDialog{
    JButton chkBtn=new JButton("check");
    JButton nextBtn=new JButton("next");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JLabel l1=new JLabel(" 영어단어");
    JLabel l2=new JLabel("우리말 뜻");
    JLabel l3=new JLabel(" 0 %");
    JTextField engField=new JTextField(20);
    JTextField korField=new JTextField(20);
    MyDictionary myDictionary=new MyDictionary();
    EngKoreanCard curCard=null;
    Container c=this.getContentPane();
    int correct=0;
    int wrong=0;
    int r=70,g=170,b=70;
    float totalQ=0;
    public Flashcard(){
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout());
        myDictionary=new MyDictionary();
        curCard=myDictionary.getRandomCard();
        engField.setText(curCard.getEngWord());
        engField.setEditable(false);
        p1.add(l1);
        p1.add(engField);
        p1.setSize(100,30);
        p2.add(l2);
        p2.add(korField);
        p2.setSize(100,30);
        chkBtn.setSize(50,30);
        chkBtn.addActionListener(new ButtonListener());
        nextBtn.setSize(50,30);
        nextBtn.addActionListener(new ButtonListener());
        p3.add(chkBtn);
        p3.add(nextBtn);
        l3.setBackground(new Color(0,0,0));
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(l3);
        c.setBackground(new Color(r,g,b));
        this.setSize(400,200);
        this.setVisible(true);
    }
    public class ButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent E) {
        
            if(E.getSource()==chkBtn){
                String temp=korField.getText();
                temp=temp.trim();
                if(curCard.getKorWord().equals(temp) && korField.getText()!=null){
                    korField.setText("정답");
                    correct++;
                    totalQ+=1;
                    float cur=(correct/totalQ)*100;
                    int curr=(int) cur;
                    l3.setText(curr+" %");
                    r=r+correct*30;
                    g=g+correct*10;
                    b=b+correct*30;
                    c.setBackground(new Color(r,g,b));
                }   
                else{
                    korField.setText("다시 한번 해보세요.");
                    wrong++;
                    totalQ+=1;
                    float cur=(correct/totalQ)*100;
                    int curr=(int) cur;
                    l3.setText(curr+" %");
                    r=r-wrong*30;
                    g=g-wrong*10;
                    b=b-wrong*30;
                    c.setBackground(new Color(r,g,b));
                }
            }
            else if(E.getSource()==nextBtn){
                korField.setText(null);
                curCard=myDictionary.getRandomCard();
                engField.setText(curCard.getEngWord());
            }
        }
    }
}