class Solution {
    public List<List<String>> groupAnagrams(String[] source) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (source == null) return result;
		    Map<String, ArrayList<String>> multiMap = new HashMap<String, ArrayList<String>>();
		    for (String src :source) {
			      char[] strChar = src.toCharArray();
			      Arrays.sort(strChar);
			      String strSorted = String.valueOf(strChar);
                              if (multiMap.containsKey(strSorted)) {
                                        ArrayList<String> aList = multiMap.get(strSorted);
				        aList.add(src);
				        multiMap.put(strSorted,  aList);
			      } else {
				        ArrayList<String> aList = new ArrayList<String>();
				        aList.add(src);
				        multiMap.put(strSorted, aList);
			      }
		   }
		
		   Set<String> keySet = multiMap.keySet();
		   for (String key : keySet) {
			    ArrayList<String> aList = multiMap.get(key);
			    Collections.sort(aList);
			    result.add(aList);
		   }
		   return result;
    }
}
