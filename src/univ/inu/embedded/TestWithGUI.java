package univ.inu.embedded;
import univ.incheon.embedded.EngKoreanCard;
import univ.incheon.embedded.MyDictionary;
import univ.inu.embedded.flashcard.Flashcard;
public class TestWithGUI {
    public static void main(String [] args)
    {
        MyDictionary md=new MyDictionary();
        EngKoreanCard b=new EngKoreanCard("banana");
        b.addKoreanWord("바나나");
        EngKoreanCard a=new EngKoreanCard("apple");
        a.addKoreanWord("사과");
        EngKoreanCard m=new EngKoreanCard("mango");
        m.addKoreanWord("망고");
        EngKoreanCard c=new EngKoreanCard("cherry");
        c.addKoreanWord("체리");
        EngKoreanCard k=new EngKoreanCard("kiwi");
        k.addKoreanWord("키위");
        
        md.addCard(a);
        md.addCard(b);
        md.addCard(c);
        md.addCard(m);
        md.addCard(k);
        
        Flashcard fc=new Flashcard(md);
    }
}