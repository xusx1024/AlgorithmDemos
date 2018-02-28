## 排序种类
 
| 名字 | name | 简称 | 实现 | 时间复杂度 | 是否比较大小 |
| -------- |:--------:|:--------:|:--------:|:--------:| -------- |
|冒泡排序|bubble sort|BUB|迭代|O(N<sup>2</sup>)|Y|
|插入排序|insertion sort|INS|迭代|O(N<sup>2</sup>)|Y|
|选择排序|selection sort|SEL|迭代|O(N<sup>2</sup>)|Y|
|归并排序|merge sort|MER|递归|O(N*logN)|Y|
|快速排序|quick sort|QUI|递归|O(N<sup>2</sup>)|Y|
|随机快速排序|randomized quick sort|R-Q|递归|O(N*logN)|Y|
|计数排序|counting sort|COU|NA|O(N*logN)|N|
|基数排序|radix sort|RAD|NA|O(N*logN)|N|

## 目标

#### 对什么排序?

可以比较的类型才可以排序,不失通用性的,我们使用**integer**.

#### 使用什么容器?

这里选择使用**数组**.

#### 排什么序?

升序,降序,非升序,非降序,字典序,etc.这里我们使用**非降序**.

#### 为什么排序?

假如有一个有序的数组A,基于该数组的操作都会更加容易:
- 在A中查找指定的值v
- 在A中找到最小/最大/第K个最小,最大值
- 在A中检测某个值是否唯一或删除重复的值
- 在A中记录指定值出现的次数
- 查找A和另外一个有序的数组B的交集或并集
- 查找 x ∈ A & y ∈ A,并且x+y 等于指定的值Z
- 等等...

## 排序问题是有趣的算法练习,包含许多CS思想 

#### Comparison VS non-comparison based strategies
基于策略的比较和非比较操作对比

#### iterative versus recursive implementation
迭代与递归的实现

####  Divide and Conquer paradigm 
分而治之的思想.

#### Best/Worst/Average time complexity analysis
最佳/最坏/平均时间复杂度分析

#### Randomized Algorithm
随机的算法(在本单元指随机快排)

## 排序问题的考察标准

#### 稳定性

排序算法的稳定性,是指,在两个相等的元素情况下,这两个元素的相对次序不变.<br/>
在实际工程应用中,如果我们交换的不是一个整数,而是一个很大的对象,交换元素存在一定的开销.
 


