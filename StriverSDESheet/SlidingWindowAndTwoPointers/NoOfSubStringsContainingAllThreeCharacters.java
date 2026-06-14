package SlidingWindowAndTwoPointers;

public class NoOfSubStringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        
    }
}

//Brute Force Approach 
// public class SubstringCount {
//     public static void main(String[] args) {
//         String s = "bbacba";
//         int n = s.length();
//         int cnt = 0;

//         for (int i = 0; i < n; i++) {
//             int[] hash = new int[3];  // For 'a', 'b', 'c'

//             for (int j = i; j < n; j++) {
//                 hash[s.charAt(j) - 'a'] = 1;

//                 if (hash[0] + hash[1] + hash[2] == 3) {
//                     cnt += (n - j);
//                     break;
//                 }
//             }
//         }

//         System.out.println(cnt);
//     }
// }

