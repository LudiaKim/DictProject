package univ.incheon.embedded;
import java.util.*;
 
public class MyDictionary {
    private Random randomGenerator = new Random();
    public int cnt=0;
    Vector<EngKoreanCard> wordList=new Vector<EngKoreanCard>();
    
    public void addCard(EngKoreanCard _card)
    {
        wordList.add(_card);
        cnt++;
    }
    public EngKoreanCard getCardByEng(String _english)
    {
        Iterator<EngKoreanCard> it = wordList.iterator();
        EngKoreanCard cur=null;
        while(it.hasNext()){
            cur=it.next();
            if(cur.getEngWord().equals(_english)){
                return cur;
            }
        }
        return null;
    }
    public EngKoreanCard getCardByKorean(String _korean)
    {
        Iterator<EngKoreanCard> it = wordList.iterator();
        EngKoreanCard cur=null;
        while(it.hasNext()){
            cur=it.next();
            if(cur.getKorWord().equals(_korean)){
                return cur;
            }
        }
        return null;
    }
    public EngKoreanCard getRandomCard()
    {
        int temp=randomGenerator.nextInt(cnt); 
        EngKoreanCard value=wordList.get(temp);
        return value;
    }
}