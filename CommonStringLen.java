package leeCode;

public class CommonStringLen {
	public int getCommonStrLen(char[] str1, char[] str2) {
		if (str1 == null 
			|| str2 == null) {
			return 0;
		}
		int maxLen = 0;
		int length = 0;
		int i = 0;
		int j = 0;
		for (; i < str1.length;i++) {
			for (j = 0 ;j < str2.length; j++) {
				while(j < str2.length && str1[i] == str2[j]) {
					length++;
					if (maxLen < length) {
						maxLen = length;
					}
					i++;
					j++;
				}
				length = 0;
			}
			
		}
		
		return maxLen;
	}
	public static void main(String[] args) {
		CommonStringLen commonStr = new CommonStringLen();
		String strA = "vfff";
		String strB = "RBCE";
		int len = commonStr.getCommonStrLen(strA.toCharArray(), strB.toCharArray());
		System.out.println(len);
	}
}
