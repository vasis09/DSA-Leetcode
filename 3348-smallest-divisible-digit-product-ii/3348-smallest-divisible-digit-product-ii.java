import java.util.Arrays;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into prime counts [2, 3, 5, 7]
        int[] required = new int[4];
        int[] primes = {2, 3, 5, 7};
        
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                required[i]++;
                t /= primes[i];
            }
        }
        if (t > 1) return "-1"; // Impossible prime factor

        int n = num.length();
        int firstZero = num.indexOf('0');

        // Step 2: Pre-calculate factor requirements for each prefix in O(N)
        // prefixReq[i] holds factors needed by prefix num[0...i-1]
        int[][] prefixReq = new int[n + 1][4];
        prefixReq[0] = required.clone();
        
        int validUntil = (firstZero == -1) ? n : firstZero;
        for (int i = 0; i < validUntil; i++) {
            prefixReq[i + 1] = prefixReq[i].clone();
            removeDigitFactors(prefixReq[i + 1], num.charAt(i) - '0');
        }

        // Check if num itself is valid
        if (firstZero == -1 && isSatisfied(prefixReq[n])) {
            return num;
        }

        // Step 3: Backward scan using O(1) prefix lookup
        for (int i = Math.min(n - 1, validUntil); i >= 0; i--) {
            int curDigit = num.charAt(i) - '0';

            for (int nextDigit = curDigit + 1; nextDigit <= 9; nextDigit++) {
                int[] tempReq = prefixReq[i].clone();
                removeDigitFactors(tempReq, nextDigit);

                String neededSuffix = getMinDigits(tempReq);
                int spaceLeft = n - 1 - i;

                if (neededSuffix.length() <= spaceLeft) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(nextDigit);
                    
                    int ones = spaceLeft - neededSuffix.length();
                    for (int k = 0; k < ones; k++) sb.append('1');
                    
                    sb.append(neededSuffix);
                    return sb.toString();
                }
            }
        }

        // Step 4: If same length fails, extend by 1 or more digits
        String neededDigits = getMinDigits(required);
        int targetLen = Math.max(n + 1, neededDigits.length());
        
        StringBuilder sb = new StringBuilder();
        int ones = targetLen - neededDigits.length();
        for (int k = 0; k < ones; k++) sb.append('1');
        sb.append(neededDigits);
        
        return sb.toString();
    }

    private void removeDigitFactors(int[] p, int d) {
        if (d <= 1) return;
        if (d == 2) p[0] = Math.max(0, p[0] - 1);
        else if (d == 3) p[1] = Math.max(0, p[1] - 1);
        else if (d == 4) p[0] = Math.max(0, p[0] - 2);
        else if (d == 5) p[2] = Math.max(0, p[2] - 1);
        else if (d == 6) { p[0] = Math.max(0, p[0] - 1); p[1] = Math.max(0, p[1] - 1); }
        else if (d == 7) p[3] = Math.max(0, p[3] - 1);
        else if (d == 8) p[0] = Math.max(0, p[0] - 3);
        else if (d == 9) p[1] = Math.max(0, p[1] - 2);
    }

    private String getMinDigits(int[] p) {
        int p2 = p[0], p3 = p[1], p5 = p[2], p7 = p[3];

        int c9 = p3 / 2; p3 %= 2;
        int c8 = p2 / 3; p2 %= 3;
        int c7 = p7;
        int c6 = (p2 > 0 && p3 > 0) ? 1 : 0;
        p2 -= c6; p3 -= c6;
        int c5 = p5;
        int c4 = p2 / 2; p2 %= 2;
        int c3 = p3;
        int c2 = p2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c2; i++) sb.append('2');
        for (int i = 0; i < c3; i++) sb.append('3');
        for (int i = 0; i < c4; i++) sb.append('4');
        for (int i = 0; i < c5; i++) sb.append('5');
        for (int i = 0; i < c6; i++) sb.append('6');
        for (int i = 0; i < c7; i++) sb.append('7');
        for (int i = 0; i < c8; i++) sb.append('8');
        for (int i = 0; i < c9; i++) sb.append('9');

        return sb.toString();
    }

    private boolean isSatisfied(int[] req) {
        return req[0] == 0 && req[1] == 0 && req[2] == 0 && req[3] == 0;
    }
}