# Number Theory & Digit Math Pattern

## Core Idea

Work with digits (`% 10`, `/ 10`), fast exponentiation, primes (sieve), and GCD.
Watch for integer overflow — use `long` when accumulating.

---

## Recognition Questions

1. Reverse digits / palindrome number / happy number?
2. Compute x^n efficiently?
3. Count primes / gcd / base conversion?

If YES -> number theory.

## Green Flags

- "reverse integer", "palindrome number"
- "pow(x, n)", "count primes"

---

## Templates

**Fast Power (exponentiation by squaring)**

```java
double myPow(double x, long n) {
    if (n < 0) { x = 1 / x; n = -n; }
    double res = 1;
    while (n > 0) {
        if ((n & 1) == 1) res *= x;
        x *= x;
        n >>= 1;
    }
    return res;
}
```

**Reverse Integer (overflow-safe)**

```java
int rev = 0;
while (x != 0) {
    int digit = x % 10; x /= 10;
    if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) return 0;
    rev = rev * 10 + digit;
}
return rev;
```

**Count Primes (Sieve of Eratosthenes)**

```java
boolean[] notPrime = new boolean[n];
int count = 0;
for (int i = 2; i < n; i++) {
    if (!notPrime[i]) {
        count++;
        for (long j = (long)i * i; j < n; j += i) notPrime[(int)j] = true;
    }
}
return count;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 50 | Pow(x, n) | Medium | https://leetcode.com/problems/powx-n/ |
| 7 | Reverse Integer | Medium | https://leetcode.com/problems/reverse-integer/ |
| 9 | Palindrome Number | Easy | https://leetcode.com/problems/palindrome-number/ |
| 204 | Count Primes | Medium | https://leetcode.com/problems/count-primes/ |
| 202 | Happy Number | Easy | https://leetcode.com/problems/happy-number/ |
| 43 | Multiply Strings | Medium | https://leetcode.com/problems/multiply-strings/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Pow(x, n) | Amazon, Meta, Google, LinkedIn |
| Reverse Integer | Amazon, Apple, Bloomberg |
| Multiply Strings | Meta, Amazon, Google |
| Happy Number | Amazon, Google, Uber |

**FAANG focus:** Pow(x, n) tests fast exponentiation; Multiply Strings is a common Meta
big-number question.
