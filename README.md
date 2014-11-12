CS146 Programming Project II:
Build a program that implements a min-max heap (of integers). Your ADT must support the following operations:
buildMinMaxHeap(int array) given an array of integers. Int peekMin()
Int peekMax()
Int deleteMin()
Int deleteMax()
Insert(int element)
printMinMaxHeap()
Your program should accept a file containing commands on what to do, i.e. one command per line. As an example an input file containing:
buildMinMaxHeap : 1, 4, 2, 3, 7, 6, 10 peekMin
peekMax
insert 25
insert 107
printMinMaxHeap
will direct your program to create a min-max heap with the given elements, will print the minimum, will print the maximum, will insert 25 and then 107, and finally print the resulting heap as one level per line starting with the root the standard output.