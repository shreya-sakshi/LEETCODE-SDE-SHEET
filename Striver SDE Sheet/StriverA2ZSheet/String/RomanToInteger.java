package String;



import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
    public int romanToInt(String s) {
        // Map to store Roman numeral values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // If current value is less than the next value, subtract it
            if (i + 1 < n && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt("IX")); // Output: 9
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994
    }
}
