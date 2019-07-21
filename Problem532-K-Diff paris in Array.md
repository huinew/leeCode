### 532.K-diff Pairs in an Array 

### Descrption
> Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

**Example 1:**

Input: [3, 1, 4, 1, 5], k = 2

Output: 2 

Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

**Example 2:**

Input:[1, 2, 3, 4, 5], k = 1

Output: 4

Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

**Example 3:**

Input: [1, 3, 1, 5, 4], k = 0

Output: 1

Explanation: There is one 0-diff pair in the array, (1, 1).

Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].

### 解题思路
1. 凡是遇到这种找出位置相差k，或是两个数相差K的问题，都可以考虑用**双指针跑步法**来处理。
具体来说，一般是设置两个变量指向元素的位置，一个遍历得慢一些，一个遍历的快一些，将跑的快的元素值和跑得慢的元素值按题目要求进行比对。
2. 由于这里面有元素重复，而且题目要求重复的元素不算，所以我们要进行元素去重。这里推荐有两种去重方式，第一种是先对元素所在的数组进行排序，指针遍历到重复的元素就往后走；第二种是利用Set集合的特性（不会存重复的元素）

### Solution1（Java解法）
```
 public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int i = 0, j = 1, count = 0;
        while (i < nums.length && j < nums.length) {
            while(j < nums.length && nums[j] - nums[i] < k) j++;
            if (j+1 < nums.length && nums[j] == nums[j+1]) j++;
            if (j < nums.length && nums[j]-nums[i] == k) {
                if (i != j) count++;
                j++;
            }
            while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
            i++;
        }
        return count;
    }
```

### Solution2 (Java解法)
```

    public int findPairs(int[] nums, int k) {
        if (nums.length ==0 || nums.length ==1){
            return 0;
        }
        if (k<0){
            return 0;
        }
        Set<Integer> repeatSet = new HashSet<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            if (!numSet.add(num)){
                repeatSet.add(num);
            }
        }

        int count = 0;
        for (Integer element : numSet){
            if (numSet.contains(element +k) &&(k!=0)){
                count++;
            }
        }

        if (k==0){
            return repeatSet.size();
        }
        return count;
    }
```

