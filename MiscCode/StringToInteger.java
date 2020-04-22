package MiscCode;

public class StringToInteger {
    public int stringToint(String str) {
        // emoty input
        if (str.length() == 0) {
            return 0;
        }
        int start = 0;
        
        // if the string starts with '0' followed by a
        // character which is not an integer
        if (str.charAt(start) == '0' &&
                ((start + 1) < str.length() && !checkValidString(str, start + 1))) {
            return 0;
        }
       
        // move the pointer ignoring all the spaces and all the '0's
        while (start < str.length() && (str.charAt(start) == ' ' || str.charAt(start) == '0')) {
            start++;
        }

        boolean negative = false;
        // mark negative input to be used later for the result.
        if (start < str.length() && str.charAt(start) == '-') {
            negative = true;
        }
        
        // starting with either a '+' or a '-' 
        if (start < str.length() && (str.charAt(start) == '+' || str.charAt(start) == '-')) {
            if (str.length() == 1) {
                return 0;
            }
            if (!checkValidString(str, start + 1)) {
                return 0;
            } else {
                start = start + 1;
            }
        }
        
        while (start < str.length() && str.charAt(start) == '0') {
            start++;
        }

        int result = 0;
        int mult = 10;
        char[] ch = str.toCharArray();
        boolean overflow = false;
        int len = 0;
        int prev = 0;
        
        for (int i = start; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                result = result * mult + Character.getNumericValue(ch[i]);
                len = len + 1;
                // if a overflow occurs then the int value moves to INT_MIN_VALUE and
                // adds up the overflowed int value to the INT_MIN_VALUE.
                // to find such scenario compare with previous value which is current value / 10.
                // if that value has not changed due to overflow, then it is not a overflow.
                // overflow will change the value to make it either negative or add the remnant to make 
                // it positive. check those cases in following condition.
                if (len > 10 || result < 0 || prev != result / 10) {
                    overflow = true;
                    break;
                }
                prev = result;
            } else {
                return (
                        negative == false ? result : (-1) * result);
            }
        }

        if (overflow) {
            return (
                    negative == false ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        }

        return (
                negative == false ? result : (-1) * result);
    }

    public boolean checkValidString(String str, int pos) {
        if (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
            return true;
        }
        return false;
    }
}
