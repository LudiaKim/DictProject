package univ.inu.embedded.flashcard;
import univ.incheon.embedded.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Flashcard extends JFrame{
    JButton chkBtn=new JButton("check");
    JButton nextBtn=new JButton("next");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JLabel l1=new JLabel("영어단어");
    JLabel l2=new JLabel("우리말 뜻");
    JTextField engField=new JTextField(20);
    JTextField korField=new JTextField(20);
    MyDictionary myDictionary=new MyDictionary();
    EngKoreanCard curCard=null;
    
    public Flashcard(MyDictionary _newmd){
        Container c=this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout());
        myDictionary=_newmd;
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
        c.add(p1);
        c.add(p2);
        c.add(p3);
        this.setSize(400,200);
        this.setVisible(true);
    }
}