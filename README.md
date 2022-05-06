# leetcodeworkspace
leetcode问题：
- 对于全局变量，每次一定要重新初始化，否则编译器多次测试时，会复用这个全局变量
- 一定注意特殊输入的问题, 边界值往往是最容易忽略的
- 针对大数问题，超范围是常态，Go中默认使用Int64，可以避免java中很多范围判断问题
- 
约定：[1] 代表经典问题，[2] 代表特殊题型
### 二刷
第3题. 快慢指针+set数组

第4题. 两个有序数组中找中位数（二分法）

第5题. [1]``动态规划——寻找最长子串`` 动态方程：d[i][j] = d[i+1][j-1] & s[i] = s[j] 

第6题. [2]**Z字形存储**，建立n行个字符串，依次按规律添加进对应字符串中

第7题. [2]**整数反转**  判断是否越界，只需要依次翻转并判断n是否大于MAX_VALUE/10,最后一位翻转时判断n是否等于MAX_VALUE/10且最后一位>7或<-8

第8题. [2]**字符串转换整数**   模式匹配

第10题. [1]``动态规划——模式匹配`` 

第11题. [1]``左右双指针——寻找最大容积``   小的一边向内移动，直到left==right，记录到的最大的容积即为结果

第12题. [1]``贪心——转罗马字符``  每次找当前数字可以匹配的最大字符 

第15题. [1]``左右双指针——寻找三数之和``  固定一个数，另两个数采用左右双指针，寻找符合条件的值。采用先排序，后针对相同值跳过，实现去重

第16题. [1]``左右双指针——寻找最接近三数之和``

第17题. [2]**字符串拼接**    电话号码的字母组合

第18题. [1]``左右双指针——寻找四数之和``

第19题. [1]``快慢双指针(遍历链表``——删除倒数第n个数``   快指针比慢指针多走n+1步，然后开始一起向后遍历，快指针到末尾，慢指针刚好指向n-1  

第20题. [2]**有效的括号**  字符匹配

第22题. [2]**括号生成** 递归遍历

第23题. [1]``分治法——合并K个升序链表``  两两合并，层层向上递归（go里面还用了一下多线程）

第24题. [1]``快慢指针——两两交换链表中的节点``

第25题. [1]``快慢指针——K个一组翻转链表``  206题的进化版，相当于多次调用206

第206题. [1]``快慢指针——翻转链表``

第26，27题. [1]``快慢指针——移除元素``  快指针做判断，慢指针做原地新数组的上界，每当快指针发现满足条件的数据时，将其添加到原地新数组nums[slow++]

第28题. [1]``KMP算法——匹配子字符串``

第29题. [2]**两数相除**   long处理溢出，异或^ 实现符号判别，移位实现除法

第30题. [2]**串联所有单词的子串**   重点在于字典单词等长！！！利用一个map进行比较，map中记录字典中的单词及其出现次数，每当在子串中发现则将其-1，为-1或不在map中则是不匹配，继续向后查找

第31题. [2]**下一个排列**  从后向前，找到正序结构(a[i] > a[i - 1]``,将i-1与后半段中大于且最接近a[i-1] 的数与其交换，最后将i,length-1的数正序

第32题. [2]**最长有效括号**    left，right分别记录左右括号的的值，正序逆序分别遍历一次。left==right时记录当前长度，left<right时归零当前长度(针对'(````(``'``,同时需要逆序再次遍历(针对'((``'``

第33题. [2]**搜索旋转排序数组**    先遍历找到旋转位置，前数组为原数组后半部分，后数组为原数组前半部分，根据target大小选择在哪个数组进行二分查找

第34题. [1]``二分查找——查找连续重复数字的左右边界``   通过两次二分查找分别查找左右边界，重点在于当mid==target时的判断。

第36题. [2]**有效的数独**  构建3个9*9矩阵来判重。即9个9维的记录数组，分别记录0,1,2,3,4,5,6,7,8是否出现。注意判断出现在哪个3*3格子只需i/3*3 + j/3 

第37题. [1]``DFS——解数独``   通过DFS递归+回溯每一个 '.' 位置上可能填入的数字，并通过36中的方法进行合法性判定

第38题. [2]**外观数列**   

第39题. [1]``DFS——组合总和``   注意Go数组和指针的用法！！！通过DFS递归+回溯找出一个数列中和为n的所有情况

第40题. [1]``DFS——组合总和II``  数组排序后，通过DFS进行遍历，使用candidates[i] != candidates[i-1]去重

第43题. [2]**大数乘、大数加**  乘需要按照竖式乘法，将num1的每一位与num2相乘(按位相乘，末尾追加num1当前位所在位数的0``，

第加法注意写法：while(point1>0||point2>0||mark>0``{ t1=point1>0?num1[point1]:0  t2=point2>0?num2[point2]:0 res=三者之和%10 mark=三者之和/10}

第45题. [1]``动态规划——跳跃游戏``  从后向前，如果可以跳到末尾则置为1，否则比较该位置可以跳到的几个位置，选出最小次数a，则该位置跳跃次数为a+1

第46题. [1]``DFS——全排列``   找出给出数组的全部排列方式。用一个mark数组记录给出数组的使用情况，每一个DFS均对数组进行for循环遍历。



第260题. [1]``位运算——只出现一次的数字``  所有数取异或得到两个单频数字的异或结果x，通过x&-x得到二者不相同的最低位，由此将原数组一分为二，分别包含两个单频数字，对两数组求异或，得到结果

### 一刷

第29题. 大数除 
第43题. 大数乘，大数加  

第34题. 用两边二分搜索找到元素起始和终止位置

第39,40,46,79,90题. 深度搜索  

第48题. 矩阵旋转

第49题. 对String数组中的字符串分类

第50题. 快速计算n次方

第53题. 计算最大子序和（很帅的动态规划）

第54 59题. 模拟矩阵输出与生成

第56题. 合并相交区间(重写排序规则``

第55题. 是否可以到达终点（贪心问题.）

第61题. 寻找移动后新的头结点（先把链表转为循环链表）

第62,63,64题. 二维数组内寻找路径数（递归，使用数组记录，避免重复计算）（动态规划）
```
动态规划问题.一定是从小到大，比如我一开始列的dp[i][j]=dp[i+1][j]+dp[i][j+1](即i，j到终点的路径数等于i+1,j和i，j+1到终点的路径数之和
也就是说我将问题.转化为了从大到小求解(显然这里dp[n][m]为最小，即0
实际上应该是dp[i][j] = dp[i-1][j] + dp[i][j-1](即到达i，j的路径数等于到达i-1,j和i,j-1的路径数之和（显然这里dp[0][i]和dp[j,0]最小，即1）
```
第69题. 二分法实现平方根计算

第71题. 字符串匹配问题.。（论字符串拼接与substring的速度差距）

第73题. 使用常数量额外空间对存在0的行列置0

第75题. 双指针实现将大于a的数与小于a的数分别放在a两边（荷兰国旗问题.）

第77，78题. 深度遍历寻找所有可能的数字组合 VS 字典序 法，移位+位运算实现数字组合(89``

``补充other/FindALLGroup（给一个数组，找出其所有组合（组合需按原数组顺序））``

第79题. 路径搜索（DFS）

第80题. 字符串删除重复字符

第33，81题. 二分查找进阶，搜索一个旋转数组中是否存在指定值

第82题. 快慢指针实现删除重复元素

第86题. 链表中将大于x的放在后面，小于x的放在后面，同时不改变这两部分的原顺序(链表的截取与插入)

第88题. [1]``两个不等长的数组都需要遍历到末尾，可采用||嵌套&&的方式进行遍历,注意是或者而不是且``

第89题. 再一次考察移位+位运算，同时引入递归（涉及二进制运算要先观察目标数字生成规律）

第90题. DFS(注意剪枝操作)

第91题. 动态规划（题.目要求返回结果数量，应该想到动态规划）

第92题. 利用[1]``递归回溯``，只扫描一遍链表来旋转链表

第93题. 递归查找所有满足题.意的字符串划分形式

第94题. 迭代实现二叉树中序遍历

第95题. 递归生成所有类型的二叉搜索树（注意如何保存所有根节点，以往我会在递归完毕时，通过新建一个数组复制所有遍历数组值来保存一种情况）(显然此题.思路更好--动态生成所有节点
```java
List<Integer> temp = new ArrayList<>(existlist``;
for (int i:existlist`` {
     temp.add(i``;
}
res.add(temp``;
```
第96题. 动态规划计算生成二叉树个数，即某点的二叉树个数等于左右子树数量的笛卡尔积[1]``列递推式时不要把递推变量与题.目变量混淆，最好选择新的符号做递推变量``

第98题. 中序遍历观察二叉树是否是排序二叉树，重点在于使用pre记录中序遍历上一节点的值

第100, 101题. 不要总想着用一个节点进行递归，``这里我们使用左右两个指针同时递归左右子树，来检验是否左右相等或中心对称``

第102,103题. 层序遍历二叉树 

第105题. 根据中序，先序数组构建二叉树

第106题. 根据中序，后序数组构建二叉树


第109题. 链表生成平衡二叉树``快慢指针可以很好的实现链表确定范围的问题.``

第116题. 完全二叉树每个节点生成next指向它的右侧节点(左子树指向右子树，右子树指向root.next的左子树``

第117题. 使用一个链表进行层次遍历，关键在于引入一个len记录当前链表长度，再往链表后面加子节点，我们对当前层只遍历len次即可


第120题. 动态规划求最短路径[1]``动态规划问题.一定要将原问题.翻转过来，比如这道题.问从顶端到达底端的最短距离，我们引入数组matrix[i][j]表示的就是i,j到达顶端的距离``

第125题. 比较字符串是否是回文串，我们使用Character.toLowerCase 来避免大小写和数字的判断

第133题. DFS 与 BFS 进行图的复制

第136题. [2]**只出现一次的数字** 位运算 异或运算

第137题. [2]**只出现一次的数字,其他数字出现三次** [3*(a+b+c`` - (a+a+a+b+b+b+c``] / 2

第141题. [2]**链表是否成环**  快慢指针 fast向后2，slow向后1，根据能否追上判断有无链表环 

第142题. [2]**链表是否成环**  快慢指针，fast向后2，slow向后1，mark记录向后次数，追上时，通过mark+1即可得 环的长度。之后fast在head向后mark+1步，slow在head，fast追到slow时就是环起点

第144题. 145 前序 后序迭代遍历

第147题. 直接插入排序 148 归并排序      ---均针对链表

第150题. 逆波兰表达式，使用栈，每次遇到符号位时，对栈顶的两个值做相应运算

第151题. 栈实现反转字符串中的单词序列

第152题. 计算最大子序乘积（结合53题.）这里需要同时维护一个

第153题. 154 旋转后的升序数组，找最小值。使用二分法进行搜索``二分法通用模板while(left+1<right``.退出后判断取值left||right,优势在于不用考虑mid+1&mid-1&mid的各个边界条件``

第155题. MinStack [1]``加入一数据时，不仅存储该数据的val，同时一并存储当前整个数组的minVal；建立新的结构体arrayNum（int val；int minVal；）``

第160题. 数学问题.，两个指针分别由headA，headB开始绕环，一定会在交点相遇

第164题. [1]``基数排序``

第165题. 使用字符串直接进行分割后比较，或者使用双指针，配合n = n*10 + 下一位字符完成比较（这样做既无需比较.之后的0，并且还无需将所有字符拼成字符串后再转为int）

第166题. 两数相除

第168题. [1]``进制转换``1到26的26进制转化，由于A=1.....Z=26 不存在0，所以需要考虑按普通算法，有情况会造成第n位取A，n-1位取0；实际应该为第n-1位取Z。循环引入columnNumber --（使得1-26变为0-25）

第169题. [1]``摩尔投票法``寻找众数，t从指向第一个开始，相同count+1，不同count-1。count减为零则t指向当前位置的下一位。最终指向的一定是众数

第172题. 计算乘法末尾有多少个0，就是乘数中的因子一共包含多少个5

第175题. —— 178  180 ——185 196为SQL试题.

第179题. 精髓之处：有两个int a和b，如果我们希望比较ab大还是ba大，只需要将其拼接为字符串'ab'与'ba'直接比较 ``字符串比大小是按位比较ASCII码的大小``

第187题. 输出所有长度为10且出现次数大于1的子串

第189题. [1]``数组整体后移k位``  while(start<end``{swap(nums[start++],nums[end--]``}   依次由(0,n-1``(0,k-1``(k,n-1``调用while循环

第190题. [1]``位运算``  与1相与可以求得一个数的最低位，配合新数左移+原数右移操作即可得到原数的逆转数  

第191题. [1]``位运算``  与1相与可以求得一个数的最低位，配合原数右移操作即可得到为1的位个数

第192题. - 195 bash脚本

第198题. [1]``动态规划``寻找间隔子数组中的最大值

第199题. 层次遍历

第200题. 递归寻找路径，发现所有被孤立的'1'[1]``思路：遍历二维数组，一旦发现'1'，则进入递归寻找所有相邻1并全部置为'x'。遍历完成后，进入几次递归，就说明有几块相互隔绝的'1'群组``

第201题. left —— right内所有数字相与 == left 与 right的公共二进制前缀，并结合将前缀后续补0    如[5,7]  0101与0111  即是01结合00=0100  4 

第202题. [1]``标准``取一个数字的每一位

第203题. [1]``标准``遍历删除链表的某几个元素

第204题. 寻找质数（从2开始遍历，去除2的所有倍数，去除3的所有倍数，4已被去除，继续向后遍历，去除5的所有倍数。。。剩余未去除的都是质数）

第206题. [1]``标准``   反转链表，只需要三个指针分别指向连续的三个元素，前两个指针负责翻转，后一个指针负责记录当前位置。每一次交换后，三个指针同时向后移动一位

第207题. [1]``拓扑排序`` 利用二维数组que保存每一结点的所有前置结点，flag记录每一结点是否安全。DFS循环遍历所有路径

第208题. [1]``前缀查询树`` 利用struct{Trie[26];bool Endflag}存储录入的字符串，并判断字符串是否存在或是否为前缀

第209题. [1]``快慢指针——滑动窗口`` 通过滑动窗口查找数组内满足条件的最短子数组

第211题. 同207,在基础上增加通配符'.'  (只需要对通配符节点遍历其26个子节点即可``

第213题. [1]``本是线性查找，头尾相连后如何解决`` 同198，只需在此基础上分为0-n-1与1-n两次查找即可

第216题. [1]``标准``go指针与数组的完美示例

第219题. hashmap中只需要存放满足条件的最靠后元素(因为是向后遍历``，而无需存放满足条件的所有元素。

第220题. [1]``滑动窗口，桶排序``滑动窗口：循环i向后一位，则删除一个之前存在桶中的第i-k元素。桶排序：根据特定条件将不同元素放入不同队列中(本题.中用的是hashmap``

第221题. [1]``动态规划``二维矩阵中查询最大矩形 dp[i][j] = Min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]`` + 1   暴力算法，向右下遍历

第222题. [1]``完全二叉树计算节点数`` 

第223题. [1]``计算两个随机矩形相交部分的面积`` 

第224题. [1]``加减法计算器`` 展开所有括号，利用栈对符号进行存储 

第225题. [2]**双队列实现栈`` 新加元素放入A头，B数组拷贝至A，再将A数组整体拷贝至B

第226题. [2]**经典问题.`` 翻转二叉树左右子树

第227题. [1]``基本计算器``  计算加减乘除法

第229题. [1]``摩尔投票法——加强版`` 寻找个数大于1/3的数，即先通过摩尔投票找到个数最多的两个数，再判断其是否超过1/3

第230题. [1]``寻找排序二叉树中第n小的值`` 中序遍历，借助go多线程

第231题. [1]``位运算`` 判断一个数是否等于2的幂，位运算，n & n-1 ==0  则是，反之不是 

第232题. [2]**双栈实现队列** A中元素出栈并压入B，将新元素压入B，将B中元素全部出栈并压入A

第234题. [2]**链表是否回文**  快慢指针找到中心点，再依次比较前后元素

第235题. [2]**搜索二叉树最近父节点**  成立条件：两节点分别位于自己的两侧。 递归查找第一个符合条件的节点

第236题. [2]**二叉树最近父节点**  找到目标节点返回1，否则返回0，某节点左右子树同时返回1，则为最近父节点

第238题. [2]**除自身以外数组的乘积**  使用left，right分别记录左右累乘积，每个位置分别相当于左边累乘 与 右边累乘的积

第239题. [2]**记录滑动窗口最大值**  维护一个队列，队列元素由大到小排列，队头为窗口最大元素

第240题. [2]**搜索二维矩阵**  搜索二维矩阵，查找目标元素

第241题. [1]``递归分治``  以符号位分割为左右两部分，得到所有可能组合结果

第242题. [2]**字母异位词**  s，t两个字符串用一个数组记录，s遇到+1，t遇到-1 最终为0则说明出现次数相同 

第257题. [2]**寻找二叉树所有路径**  递归回溯

第258题. [2]**各位循环累加直到小于10**

第263题. [2]**判断是否为丑数**

第264题. [2]**寻找第n个丑数——堆与三指针**   堆：每次取出堆中最小的，乘以2,3,5 再形成新堆   三指针：三指针指向的位置每次分别乘2,3,5，最小的乘积放入数组，对应指针向后一个，  

第268题. [2]**136转思路解决** 永远明确一个数字与自身相异或得0

第274题.、275 [2]**寻找H指数**  二分法

第278题. [2]**寻找分界点**  二分法，mid=l+(n-l``/2   防止溢出(当n，l均超过int的一半，相加会溢出``

第279题. [1]``动态规划**  查找一个数可以被分为最少多少个平方和的和

第282题. [1]``递归回溯**   一串数字通过插入运算符，使其运算结果为指定值

第284题. [2]**窥探迭代器**  迭代器的查看元素与后移指针是绑定操作(next``  我们希望只查看元素不后移指针(peek``  引入cache缓存处理

第287题. [2]**找出重复数**  类似于成环问题.141,142  查找quick，slow相交点，再找到环入口

第289题. [2]**生命游戏——原地变换矩阵**  在原矩阵基础上，原地将矩阵每个位置，根据该点周围8个点的原矩阵值转换为新值

第292题. [2]**Nim游戏**  每人每次拿1-3个，也就是说，如果给对手留下4的倍数个，则一定可以赢。所以return n%4!=0   即初始不为4的倍数，我们先手一定可以给对手留4的倍数个

第295题. [2]**数据流中位数**  找到数据流中的中位数。通过一个大顶堆，一个小顶堆配合，大顶堆的堆顶小于小顶堆的堆顶，中位数即为大顶堆堆顶或者大小堆顶和/2

第297题. [2]**树的序列化与反序列化** 深度遍历实现树-->字符串，如何生成一棵树（采用深度遍历，每一步新建root，并通过返回值给root.Left和root.Right赋值）

第299题. [2]**猜数字游戏**  secret和guess两个数字，判断他们值一致但是位数不一致的数字个数bNum，使用一个map，map[secret]++ map[guess]--， bNum一定不是最后才求，而是随着遍历递增

第300题. [2]**寻找最长递增子序列**  状态转移方程 dp[i] = max(dp[j]`` + 1      (dp[j]<dp[i]   0<j<i``

第301题. [2]**BFS解决删除最少括号，使括号合法**  每一轮迭代删除一个符号，并将其结果加入set数组，如果set中有合法值，立刻返回，即为删除最少情况下的合法值

第303、304题 [2]**需要多次计算一维，二维数组n-m之和**   先将0-i(0<=i<=n``之和都存储与数组sum中，则0-i之和==sum[i] i-j之和==sum[j]-sum[i-1]

第306题 [2]**累加数**  判断一个字符串是否符合前两个之和为第三个数   F(n``=F(n - 1``+F(n - 2``

第309题 [1]``动态规划`` 有多个维度（每一步有多个可能状态），即需要列出多个动态方程

第1114题 [1]``多线程``使用信号量或原子类实现顺序操作
