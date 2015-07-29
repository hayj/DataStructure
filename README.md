LimitedQueue
============
A processing queue which allow a max number of processing at the same time and handle duplicated elements.

Three **internal rules** for this queue :

 1. There is a max of processing at the same time. You can manage it according to the processor or the memory capacity. 
 2. The same object can not be started if it is already in processing, so this object is added to a pending queue and wait for the first start to finish. 
 3. The same object can not be added 2 times in a pending queue because the object already present in the pending queue will be started in the future. 
 
This class is for long time process (not many Process) because the search for existing Process iterate an entire LinkedList. So the maxProcess can be set between 2 and 100 for example.

ShortSortedStack
================

This stack can store objects sorted according to an order. The order must be short (1 to 100) and not function of the data bulk. For each order, a LinkedList allows a O(1) pop and a O(1) push. Each pop return the shortest order (and latest pushed element).

This data structure is used for example in *fr.hayj.dawglevdist*.

Trie
====

This data structure is a generic implementation of the "Trie". It can store any object which implements Trie.Tokenizable. It can also store a sub-trie at all leaf to handle multi-word dictionary.

MultiMap
========

A map which supports multiple values per key.

Pair
====

Equivalent to Pair C++ class.

GenerationQueue
===============

Perform an ordered execution of process.

LimitedHashMap
==============

A HashMap which store a specified max number of values. Use LimitedLinkedList to perform a fast clean at each put.

Others
======

 * **LimitedLinkedList** : a linked list which store a specified max number of values.
 * **HeadedLinkedList** : a simlpe linked list with only the head and the next at each node.
 * **StringTree** : a tree structure which store strings.
 