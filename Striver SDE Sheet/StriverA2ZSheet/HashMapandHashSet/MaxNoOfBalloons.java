package HashMapandHashSet;
import java.util.*;

public class MaxNoOfBalloons {
    public static int maxNumberOfBalloons(String text) 
    {
           HashMap<Character,Integer> countext = new HashMap<>();
           for (char c : text.toCharArray()) 
           {
              countext.put(c,countext.getOrDefault(c,0)+1);
           }

           String reqtext ="balloon";
           HashMap<Character,Integer> balloon = new HashMap<>();
           for (char k : reqtext.toCharArray()) 
           {
              balloon.put(k,balloon.getOrDefault(k,0)+1);
           }

        //Set<Character> availableSet = balloon.keySet();
           int res = Integer.MAX_VALUE;
           for(Character ch : balloon.keySet())
           {
              int required = balloon.getOrDefault(ch,0);
              int available = countext.getOrDefault(ch, 0);
              res=Math.min(res, available / required);
           }
        
        return res;

    }
    public static void main(String[] args) {
        // String text ="loonbalxballpoon";
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text));
    }
    
}