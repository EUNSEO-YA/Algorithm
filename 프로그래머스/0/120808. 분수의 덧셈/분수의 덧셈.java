class Solution {
    public int GCD(int a, int b) {
        if (a%b==0) return b;
        else {
            return GCD(b, a%b);
        }
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int bunja = numer1 * denom2 + numer2 * denom1;
        int bunmo = denom1 * denom2;
        
        int gcd = GCD(bunja, bunmo);
  
        return new int[] {bunja/gcd, bunmo/gcd};
    }
}