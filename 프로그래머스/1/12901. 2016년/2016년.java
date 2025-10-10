class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int d = 0;
        
        if(a == 1) {
            d = b % 7;
        } else if(a == 2) {
            int mon = 31 + b;
            d = mon % 7;
        } else if(a == 3) {
            int mon = 60 + b;
            d = mon % 7;
        } else if(a == 4) {
            int mon = 91 + b;
            d = mon % 7;
        } else if(a == 5) {
            int mon = 121 + b;
            d = mon % 7;
        } else if(a == 6) {
            int mon = 152 + b;
            d = mon % 7;
        } else if(a == 7) {
            int mon = 182 + b;
            d = mon % 7;
        } else if(a == 8) {
            int mon = 213 + b;
            d = mon % 7;
        } else if(a == 9) {
            int mon = 244 + b;
            d = mon % 7;
        } else if(a == 10) {
            int mon = 274 + b;
            d = mon % 7;
        } else if(a == 11) {
            int mon = 305 + b;
            d = mon % 7;
        } else if(a == 12) {
            int mon = 335 + b;
            d = mon % 7;
        }
        
        return day[d];
    }
}