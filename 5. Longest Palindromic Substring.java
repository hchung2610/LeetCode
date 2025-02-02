class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(); 
        if (len < 2) {
            return s; 
        }
        int count = 1; 
        boolean[][] valid = new boolean[len][len]; 
        for (int i = 0; i < len; i++) {
            valid[i][i] = true; 
        }
        int begin = 0; 
        //case for two characters are similar in a row
        for (int j = 0; j < len - 1; j++) {
            if (s.charAt(j) == s.charAt(j + 1)) {
                valid[j][j+1] = true; 
                count = 2; 
                begin = j; 
            }
        }
        //normale case to check if palindrom 
        //range start from 3 and could go up to the length of a string 
        for (int range = 3; range <= len; range++) {
            //we want to check every possible substring existed in a string that satisfy the requirement
            for (int start = 0; range + start - 1 < len; start++) {
                int th = range + start - 1; 
                if (s.charAt(start) == s.charAt(th) && valid[start + 1][th - 1]) {
                    valid[start][th] =  true; 
                    count = range; 
                    begin = start; 
                }
            }
        }
        return s.substring(begin, begin + count);
    }
}