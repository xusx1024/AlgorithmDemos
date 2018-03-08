JDK下和Android SDK下的实现不同.这里我们看JDK的实现.



### 类说明文档

 
  Hash table based implementation of the <tt>Map</tt> interface.  This
  implementation provides all of the optional map operations, and permits
  <tt>null</tt> values and the <tt>null</tt> key.  (The <tt>HashMap</tt>
  class is roughly equivalent to <tt>Hashtable</tt>, except that it is
  unsynchronized and permits nulls.)  This class makes no guarantees as to
  the order of the map; in particular, it does not guarantee that the order
  will remain constant over time.
  
  哈希表实现了Map接口.该实现提供了所以map操作中的可选项,并且允许值和键为空.
  (HashMap和Has和Table大致相当,但是HashMap是非同步并且允许空的.)
  该类不保证map的顺序,特别地,它不保证已有的次序随时间保持不变.
  
  <p>This implementation provides constant-time performance for the basic
  operations (<tt>get</tt> and <tt>put</tt>), assuming the hash function
  disperses the elements properly among the buckets.  Iteration over
  collection views requires time proportional to the "capacity" of the
  <tt>HashMap</tt> instance (the number of buckets) plus its size (the number
  of key-value mappings).  Thus, it's very important not to set the initial
  capacity too high (or the load factor too low) if iteration performance is
  important.z
  
  假设hash功能充分将桶中的元素散列,该实现为基本操作get/put提供了固定时间的性能.
  对集合视图的迭代,需要时间和HashMap实例的容量(桶的数量)加上它的大小(K-V的数量)的值成比例.
  因此,如果迭代的性能很重要,不要把初始容量设置太大(或负载因子太小).
  
  <p>An instance of <tt>HashMap</tt> has two parameters that affect its
  performance: <i>initial capacity</i> and <i>load factor</i>.  The
  <i>capacity</i> is the number of buckets in the hash table, and the initial
  capacity is simply the capacity at the time the hash table is created.  The
  <i>load factor</i> is a measure of how full the hash table is allowed to
  get before its capacity is automatically increased.  When the number of
  entries in the hash table exceeds the product of the load factor and the
  current capacity, the hash table is <i>rehashed</i> (that is, internal data
  structures are rebuilt) so that the hash table has approximately twice the
  number of buckets
  
  一个HashMap实例有两个参数影响它的性能:初始化大小和负载因子.
  容量是hash表中桶的数量,容量的初始化就是简单的hash表中桶的创建.
  负载因子是度量hash表在自动增长之前,允许达到多满.
  当hash表中实体的数量超过当前容量和负载因子的乘积时,hash表是重新哈希的(也就是说,内部的数据结构被重建)
  因此hash表近似地拥有两倍的桶数量大小.
  
  <p>As a general rule, the default load factor (.75) offers a good
  tradeoff between time and space costs.  Higher values decrease the
  space overhead but increase the lookup cost (reflected in most of
  the operations of the <tt>HashMap</tt> class, including
  <tt>get</tt> and <tt>put</tt>).  The expected number of entries in
  the map and its load factor should be taken into account when
  setting its initial capacity, so as to minimize the number of
  rehash operations.  If the initial capacity is greater than the
  maximum number of entries divided by the load factor, no rehash
  operations will ever occur.
  
  通常情况下,默认负载因子0.75提供了一个不错的时空成本之间的权衡.大一些的值降低了空间开销但是加大了查找的成本.(影响HashMap的大部分操作包括get/put)
  当map被初始化时,map中期望实体的数量和他的负载因子应该被考虑在内,这样可以最小化重新哈希操作的数量.
  如果初始化空间比最大实体数量还要大,那就不会有重新哈希操作了.
 
  <p>If many mappings are to be stored in a <tt>HashMap</tt>
  instance, creating it with a sufficiently large capacity will allow
  the mappings to be stored more efficiently than letting it perform
  automatic rehashing as needed to grow the table.  Note that using
  many keys with the same {@code hashCode()} is a sure way to slow
  down performance of any hash table. To ameliorate impact, when keys
  are {@link Comparable}, this class may use comparison order among
  keys to help break ties.
 
  如果要把多个映射被储在HashMap实例中,创建一个足够大的空间将储存这些映射,比让table按需自动重新哈希有效的多.
  注意多个拥有相同哈希码的键肯定会拖慢任何哈希table的效率.
  要改变影响,当键是`可比较的`,本类会使用键之间的比较次序来帮助打破这些扭结.
 
  <p><strong>Note that this implementation is not synchronized.</strong>
  If multiple threads access a hash map concurrently, and at least one of
  the threads modifies the map structurally, it <i>must</i> be
  synchronized externally.  (A structural modification is any operation
  that adds or deletes one or more mappings; merely changing the value
  associated with a key that an instance already contains is not a
  structural modification.)  This is typically accomplished by
  synchronizing on some object that naturally encapsulates the map.
 
  注意该实现是非同步的.如果多线程并发访问一个HashMap,并且至少有一个线程在结构上改变这个map,他就必须是外部同步.
  (因为内部不同步嘛!看来同步工作必须要做,看是SDK做还是程序员做了 :P)(结构上的改变是指添加或删除一个或多个映射的操作,但是仅仅改变
  一个已经存在的实例的键相关联的值并不是结构改变.)
  这个典型的高技巧的,通过同步一些天然封装了映射的对象.
  
  If no such object exists, the map should be "wrapped" using the
  {@link Collections#synchronizedMap Collections.synchronizedMap}
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the map:<pre>
    Map m = Collections.synchronizedMap(new HashMap(...));</pre>
    
   如果没有这样的对象存在,map应该使用`Collections#synchronizedMap Collections.synchronizedMap`包含这些.
   这是在创建时候的最好做法,去防止非同步访问map的事故.
 
  <p>The iterators returned by all of this class's "collection view methods"
  are <i>fail-fast</i>: if the map is structurally modified at any time after
  the iterator is created, in any way except through the iterator's own
  <tt>remove</tt> method, the iterator will throw a
  {@link ConcurrentModificationException}.  Thus, in the face of concurrent
  modification, the iterator fails quickly and cleanly, rather than risking
  arbitrary, non-deterministic behavior at an undetermined time in the
  future.
 
  迭代器返回所有该类的"集合视图方法"是**速错**的:如果迭代器创建后,map的结构被改变,迭代器将会抛出`ConcurrentModificationException`.
  于是,面对并发修改,迭代器干净利落的失败,而不是在未来非确定时间,非确定行为,肆意冒险.
  
  <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: <i>the fail-fast behavior of iterators
  should be used only to detect bugs.</i>
  
  注意迭代器的速错行为不能像他说的那样保证,通俗地说,不可能在非同步的并发修改做出硬性保证.
  速错迭代器尽最大努力抛出`ConcurrentModificationException`.
  然而,根据此异常的正确性编程是错误:迭代器的速错行为应该只用来侦测漏洞.
  
  
###  HashMap的工作原理
HashMap基于hashing原理,我们使用put(k,v)存储对象,使用get(k)从HashMap中获取对象.<br/>
当调用put方法传递k,v时,会先对k调用hashCode方法,返回的hashCode用于找到bucket位置来存储Entry对象.<br/>
如果hashcode没有碰撞,直接放进bucket中,如果碰撞了,以链表的形式存在buckets之后<br/>
如果碰撞导致链表过长,就把链表转换成红黑树<br/>
如果节点已经存在就替换old value,保证key的一致性<br/>
如果bucket满了,就要resize.

### 口述

HashMap实现了map接口
用于存储键值对形式的数据
允许null的键值
HashMap是非同步的
HashMap存储着Entry(hashcode,key,value,next)对象

HashMap的工作原理,HashMap使用hash方法,通过put/get存取对象.
存储对象时,我们将k/v传递给put方法,他调用hashcode计算哈希值,得出在bucket中的位置.
如果hashcode相同,则把数据以链表的形式添加到bucket之后,如果hashcode碰撞过多,就把链表转换为红黑树.
如果节点已经存在,则k不必,替换旧的值,保证K的一致性
如果超过了默认的负载因子,需要resize一个原来长度两倍的HashMap,并且重新调用hash方法,因此map是无序的,也不能保证已有的顺序是不变的.

我们根据K来取对象,仍然通过hashcode计算hash值,得出在bucket中的位置,如果hashcode碰撞,就调用K的equals方法,找到正确的K.


### 和HashTable的区别

几乎等同的,二者都实现了Map接口.<br/>
HashMap是非同步的,HashTable是同步的.所以在单线程情况,选用HashMap,效率会高一些.<br/>
在多线程情况下,使用HashTable,也可以使用Collections.synchronizedMap(hashmap)让HashMap同步,也可以使用ConcurrentHashMap.
HashMap允许空的键值.<br/>
HashMap不能保证随着时间的推移,Map中的元素次序是不变的.





































