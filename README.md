LimitedQueue
============
A processing queue which allow a max number of processing at the same time and handle duplicated elements.

Three **internal rules** for this queue :

 1. There is a max of processing at the same time. You can manage it according to the processor or the memory capacity. 
 2. The same object can not be started if it is already in processing, so this object is added to a pending queue and wait for the first start to finish. 
 3. The same object can not be added 2 times in a pending queue because the object already present in the pending queue will be started in the future. 
 
This class is for long time process (not many Process) because the search for existing Process iterate an entire LinkedList. So the maxProcess can be set between 2 and 100 for example.
