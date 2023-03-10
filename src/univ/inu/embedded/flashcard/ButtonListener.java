package univ.inu.embedded.flashcard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import univ.incheon.embedded.EngKoreanCard;
import univ.incheon.embedded.MyDictionary;

	public class ButtonListener implements ActionListener{

			JTextField engField=new JTextField(20);
		    JTextField korField=new JTextField(20);
		    JButton chkBtn=new JButton("check");
		    JButton nextBtn=new JButton("next");
		    EngKoreanCard curCard=null;
		    MyDictionary myDictionary=new MyDictionary();
		    
            public void actionPerformed(ActionEvent E) {
            
                if(E.getSource()==chkBtn){
                    String temp=korField.getText();
                    temp=temp.trim();
                    
                    if(curCard.getKorWord().equals(temp) && korField.getText()!=null){
                        korField.setText("정답");
                    }
                    else{
                        korField.setText("다시 한번 해보세요.");
                    }
                }
                else if(E.getSource()==nextBtn){
                    korField.setText(null);
                    curCard=myDictionary.getRandomCard();
                    engField.setText(curCard.getEngWord());
               
                }
	}

}
