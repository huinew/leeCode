
##### 难度：medium
##### tag：Array、Two Pointer
https://leetcode.com/problems/container-with-most-water/

> Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

> Input: [1,8,6,2,5,4,8,3,7]

> Output: 49

本题依旧用双指针的解法来做。

解题历程：这题求的是两个竖线间的最大面积，而且面积的长度（纵高）只能取短的一方。因此就开始考虑在以横轴坐标的一头一尾设立两个游标，头部的游标每次只移动一格，而尾部的游标一直往前遍历直至遇到头部游标，遍历的过程中计算出最大面积。这种解法比较暴力，当然解出来就比较快，方案如下：

```
public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int minHeight;
        while (i <= height.length - 2){
            while(i < j){
                if (height[i] < height[j]){
                    minHeight = height[i];
                }else{
                    minHeight = height[j];
                }

                if (minHeight * (j - i) > max){
                    max = minHeight * (j - i);
                }

                j--;
            }
            j = height.length - 1;
            i++;
        }
        return max;
    }
```

上面这段解法，Runtime: 309 ms，Memory Usage: 39.8 MB；显然还有优化的地方。我们再仔细分析下题目，发现其实面积的增长，取决于比较短的纵高 * 横轴的坐标差。所以每次移动时，只需判断左右两边的纵高哪个更短，再进行面积计算会更高效些：
```
public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
```

优化后的代码，耗时2ms。
