package String;

public class IsSubsequence
{

    public boolean isSubsequence(String s , String t)
    {
           int i =0,j=0;

           while(i < s.length() &&  j < t.length())
           {
                if(s.charAt(i) == t.charAt(j))
                {
                     i++;
                }

                j++;
           }

           return i == s.length();
    }

    
    public static void main (String args[])
    {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(subsequence.isSubsequence("axc", "ahbgdc")); // false
    }
}