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
    
    
    public Vector<String> getRandomCardToSelected(EngKoreanCard ans)
    {
        Vector<String> randomCard=new Vector<String>();
        randomCard.setSize(4);
        int f=randomGenerator.nextInt(4); //답이 위치한 index
        
        for(int i=0;i<4;i++)
        {
            if(i!=f)
            {
                int temp=randomGenerator.nextInt(cnt); 
                String value=wordList.get(temp).getKorWord();
            
                while((randomCard.contains(value)) || (value.equals(ans.getKorWord())))
                {
                    temp=randomGenerator.nextInt(cnt); 
                    value=wordList.get(temp).getKorWord();
                }
                randomCard.add(i,value);
            }
            else
            {
                randomCard.add(i,ans.getKorWord());
            }
        }
        return randomCard;
    }

	public void input(MyDictionary myDictionary) {
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
        
        myDictionary.addCard(a);
        myDictionary.addCard(b);
        myDictionary.addCard(c);
        myDictionary.addCard(m);
        myDictionary.addCard(k);
	}

	
}