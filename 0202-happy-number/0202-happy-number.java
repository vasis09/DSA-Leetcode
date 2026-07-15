class Solution {
    public boolean isHappy(int n) {

        
        HashSet<Integer> seen = new HashSet<>();
        
        // Loop runs until n becomes 1 (happy) or we hit a cycle (unhappy)
        while (n != 1) {
            // Calculate the sum of the squares of the digits of n
            int nextNumber = getNext(n);
            
            // If the set already contains this sum, we've detected a loop
            if (seen.contains(nextNumber)) {
                return false;
            }
            
            // Otherwise, record this number and update n
            seen.add(nextNumber);
            n = nextNumber;
        }
        
        return true;
    }
    
    // Helper method to split a number into digits and return the sum of their squares
    private int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10;
            totalSum += digit * digit;
            num /= 10;
        }
        return totalSum;
    }}