package univ.inu.embedded;
import univ.incheon.embedded.EngKoreanCard;
import univ.incheon.embedded.MyDictionary;
import univ.inu.embedded.flashcard.Flashcard;
public class TestWithGUI {
    public static void main(String [] args)
    {
        MyDictionary md=new MyDictionary();
        EngKoreanCard b=new EngKoreanCard("banana");
        b.addKoreanWord("�ٳ���");
        EngKoreanCard a=new EngKoreanCard("apple");
        a.addKoreanWord("���");
        EngKoreanCard m=new EngKoreanCard("mango");
        m.addKoreanWord("����");
        EngKoreanCard c=new EngKoreanCard("cherry");
        c.addKoreanWord("ü��");
        EngKoreanCard k=new EngKoreanCard("kiwi");
        k.addKoreanWord("Ű��");
        
        md.addCard(a);
        md.addCard(b);
        md.addCard(c);
        md.addCard(m);
        md.addCard(k);
        
        Flashcard fc=new Flashcard(md);
    }
}