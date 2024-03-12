public class Solution {

    int resultStart;
    int resultLength;

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("dabbad123"));
    }

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) return s;

        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String str, int begin, int end) {
        end = str.length() % 2 == 0 ? end + 1 : end;
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}