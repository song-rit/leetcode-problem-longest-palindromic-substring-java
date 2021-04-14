class Solution {
    public String longestPalindrome(String s) {

        String palindrome = "";
        int length = s.length();

        if(length == 1) {
            return s;
        }

        int h = length % 2 == 0 ? (length / 2) : ((length / 2) + 1);
        int t = h;

        while(h >= 0 && t <= length){
            for(int j = (length / 2); j >= 0; j--) {


                if(j < h) {
                    String subStr = s.substring(j, h);
                    if(isPalindrome(subStr)){
                        if(palindrome.length() < subStr.length()){
                            palindrome = subStr;
                        }
                    }
                } else {
                    String subStr = s.substring(h, j);
                    if(isPalindrome(subStr)){
                        if(palindrome.length() < subStr.length()){
                            palindrome = subStr;
                        }
                    }
                }

                if((j + (length / 2)) < t) {
                    String subStr = s.substring(j + (length / 2), t);
                    if(isPalindrome(subStr)){
                        if(palindrome.length() < subStr.length()){
                            palindrome = subStr;
                        }
                    }
                }
                else {
                    String subStr = s.substring(t, j + (length / 2));
                    if(isPalindrome(subStr)){
                        if(palindrome.length() < subStr.length()){
                            palindrome = subStr;
                        }
                    }
                }

                String subStr2 = s.substring(j, t);
                if(isPalindrome(subStr2)){
                    if(palindrome.length() < subStr2.length()){
                        palindrome = subStr2;
                    }
                }

            }

            // String subStr = s.substring(t, length);
            // if(isPalindrome(subStr)){
            //     if(palindrome.length() < subStr.length()){
            //         palindrome = subStr;
            //     }
            // }

            String subStr2 = s.substring(h, t);
            if(isPalindrome(subStr2)){
                if(palindrome.length() < subStr2.length()){
                    palindrome = subStr2;
                }
            }

            String subStr3 = s.substring(h, length);
            if(isPalindrome(subStr3)){
                if(palindrome.length() < subStr3.length()){
                    palindrome = subStr3;
                }
            }

            String subStr4 = s.substring(0, t);
            if(isPalindrome(subStr4)){
                if(palindrome.length() < subStr4.length()){
                    palindrome = subStr4;
                }
            }

            t++;
            h--;
        }

        return palindrome;
    }

    private boolean isPalindrome(String s) {
        int length = s.length();

        char[] ch = s.toCharArray();
        for(int i = 0; i < length / 2; i++) {
            if(ch[i] != ch[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}