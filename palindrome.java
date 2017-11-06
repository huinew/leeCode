package leeCode;

public class Palindrome {
    /* 判断是否为字母或数字 */
	public static boolean isAlpha(int c) {
		if ((c >= 'a' && c <= 'z')
			|| (c >= 'A' && c <= 'Z')
			|| (c >= '0' && c <='9')) {
			return true;
		}
		return false;
	}
	
	public boolean isPalindrome(String A) {
		if (A == null) {
			return true;
		}
		A = A.toLowerCase();
		int end = A.length() - 1;
		int start = 0;
		while (start < end) {
			while(!isAlpha(A.charAt(start)) && (start < end)) {
				start++;
			}
			while(!isAlpha(A.charAt(end)) && (start < end)) {
				end--;
			}
			if (A.charAt(start) != A.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
