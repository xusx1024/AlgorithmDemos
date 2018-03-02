## 排序种类
 
<table>
   <tr>
      <td colspan="7" align="center">排序算法分析</td>
   </tr>
   <tr>
      <td rowspan="2" align="center">类别</td>
      <td rowspan="2" align="center">排序方法</td>
      <td colspan="3" align="center">时间复杂度</td>
      <td >空间复杂度</td>
      <td rowspan="2">稳定性</td>
   </tr>
   <tr>
      <td>平均情况</td>
      <td>最好情况</td>
      <td>最坏情况</td>
      <td>辅助存储</td>
    </tr>
   <tr>
    <td  rowspan="2" align="center">插入排序</td>
      <td>直接插入</td>
      <td>O(n^2)</td>
      <td>O(n)</td>
      <td>O(n^2)</td>
      <td>O(1)</td>
      <td>稳定</td>
   </tr>
   <tr>
      <td>shell排序</td>
      <td>O(n^1.3)</td>
      <td>O(n)</td>
      <td>O(n^2)</td>
      <td>O(1)</td>
      <td>不稳定</td>
   </tr>
   <tr>
      <td  rowspan="2" align="center">选择排序</td>
      <td>直接选择</td>
      <td>O(n^2)</td>
      <td>O(n^2)</td>
      <td>O(n^2)</td>
      <td>O(1)</td>
      <td>不稳定</td>
   </tr>
   <tr>
      <td>堆排序</td>
      <td>O(n*logn)</td>
      <td>O(n*logn)</td>
      <td>O(n*logn)</td>
      <td>O(1)</td>
      <td>不稳定</td>
   </tr>
   <tr>
      <td  rowspan="2" align="center">交换排序</td>
      <td>冒泡排序</td>
      <td>O(n^2)</td>
      <td>O(n)</td>
      <td>O(n^2)</td>
      <td>O(1)</td>
      <td>稳定</td>
   </tr>
   <tr>
      <td>快速排序</td>
      <td>O(n*logn)</td>
      <td>O(n*logn)</td>
      <td>O(n^2)</td>
      <td>O(n*logn)</td>
      <td>不稳定</td>
   </tr>
   <tr>
      <td colspan="2"align="center">归并排序</td>
      <td>O(n*logn)</td>
      <td>O(n*logn)</td>
      <td>O(n*logn)</td>
      <td>O(1)</td>
      <td>稳定</td>
   </tr>
   <tr>
      <td colspan="2" align="center">基数排序</td>
      <td>O(d*(r+n))</td>
      <td>O(d*(rd + n))</td>
      <td>O(d*r(r+n))</td>
      <td>O(rd+n)</td>
      <td>稳定</td>
   </tr>
</table>

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
