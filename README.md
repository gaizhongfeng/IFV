# Array

## arrayOperator

### 1. mergeOrderedArrays 合并两个有序数组

两个按 **非递减顺序** 排列的整数数组 `nums1` 和 `nums2`，另有两个整数 `m` 和 `n` ，分别表示 `nums1` 和 `nums2` 中的元素数目。**合并** `nums2` 到 `nums1` 中，使合并后的数组同样按 **非递减顺序** 排列。

**注意：**最终，合并后数组不应由函数返回，而是存储在数组 `nums1` 中。为了应对这种情况，`nums1` 的初始长度为 `m + n`，其中前 `m` 个元素表示应合并的元素，后 `n` 个元素为 `0` ，应忽略。`nums2` 的长度为 `n` 。

**示例 1：**

```
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
```

**示例 2：**

```
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
```

**示例 3：**

```
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
```



***使用方式***

```java
int[] nums1 = new int[]{ 1,2,3,0,0,0};
int[] nums2 = new int[]{2,5,6};
int m = 3,  n = 3;
arrayOperator.mergeOrderedArrays(nums1, m, nums2, n);
System.out.println(Arrays.toString(nums1));
```



### 2. removeElement**移除指定元素**

给定一个数组 `nums` 和一个值 `val`，移除所有数值等于 `val` 的元素

**示例 ：**

```
输入：nums = [3,2,2,3], val = 3
返回：[2,2]
```

```
输入：nums = [0,1,2,2,3,0,4,2], val = 2
返回：[0,1,4,0,3]
```

***使用方式***

```java
int[] nums = new int[]{3,2,2,3};
int val = 3;
int resultLength = arrayOperator.removeElement(nums , val);
System.out.println(Arrays.copyOfRange(nums, 0, resultLength));
```

### 3. removeDuplicates 删除有序数组中重复元素

一个 **非严格递增排列** 的数组 `nums` ，删除重复出现的元素，使每个元素 **只出现一次** ，返回删除后数组的新长度。元素的 **相对顺序**与原来数组保持 **一致** 

**示例 1：**

```
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

可以使用进行截取数组，resultLength为 removeDuplicates(nums) 的返回值
Arrays.copyOfRange(nums, 0, resultLength);
```

**示例 2：**

```
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。

可以使用进行截取数组，resultLength为 removeDuplicates(nums) 的返回值
Arrays.copyOfRange(nums, 0, resultLength);
```

***使用方式***

```java
int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
int resultLength = arrayOperator.removeDuplicates(nums);
Arrays.copyOfRange(nums, 0, resultLength);
```

###  4. removeDuplicates 删除有序数组中重复元素II

一个有序数组 `nums` ， **原地** 删除重复出现的元素，使得出现次数超过两次的元素**只出现两次** ，返回删除后数组的新长度

**示例 1：**

```
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
```

**示例 2：**

```
输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
```



**思路及解法**

 因为给定数组是有序的，所以相同元素必然连续。我们可以使用双指针解决本题，遍历数组检查每一个元素是否应该被保留，如果应该被保留，就将其移动到指定位置。具体地，我们定义两个指针 slow 和 fast 分别为慢指针和快指针，其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度，即 nums[fast]  表示待检查的第一个元素，nums[slow−1] 为上一个应该被保留的元素所移动到的指定位置。

因为要求相同元素最多出现两次而非一次，所以我们需要检查上上个应该被保留的元素 nums[slow−2] 是否和当前待检查元素 nums[fast] 相同。当且仅当 nums[slow−2]=nums[fast]时，当前待检查元素 nums[fast]不应该被保留（因为此时必然有 nums[slow−2]=nums[slow−1]=nums[fast]。最后，slow 即为处理好的数组的长度。

特别地，数组的前两个数必然可以被保留，因此对于长度不超过 2的数组，我们无需进行任何处理，对于长度超过 2的数组，我们直接将双指针的初始值设为 2即可。



































