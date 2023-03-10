package univ.incheon.embedded;
 
import java.util.*;
 
public class EngKoreanCard {
    private String english;
    private String korean;
    public EngKoreanCard(String en)
    {
        english=en;
    }
    public void addKoreanWord(String ko)
    {
        korean=ko;
    }
    public String getEngWord()
    {
        return english;
    }
    public String getKorWord()
    {
        return korean;
    }
}
 