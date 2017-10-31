package leeCode;

public class KMPStrstr {
	static void calcNext(String str, int[] next) {
		if (str == null) {
			return;
		}

		int i = 0;
		int j = -1;
		next[0] = -1;

		while(i < str.length()) {
			if ((j == -1 ) || (str.charAt(i) == str.charAt(j))) {
				next[++i] = ++j;
			} else {
				j = next[j];
			}
		}
	}

	public int KMPFindStr(String heystack, String needle) {
		if (heystack == null || needle == null) {
			return -1;
		}
		int[] next = new int[needle.length()];
		calcNext(needle, next);
		return 0;
	}
}
