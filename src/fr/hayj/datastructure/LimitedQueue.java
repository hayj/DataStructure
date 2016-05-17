package fr.hayj.datastructure;

import java.util.LinkedList;

/**
 * Three rules for this queue :
 * <ol>
 * <li>There is a max of processing at the same time. You can manage it according to the processor or the memory capacity.</li>
 * <li>The same object can not be started if it is already in processing, so this object is added to a pending queue and wait until the first start will be finished.</li>
 * <li>The same object can not be added 2 times in a pending queue because the object already present in the pending queue will be started in the future.</li>
 * </ol>
 * This class is for long time process (not many Process) because the search for existing Process iterate an entire LinkedList. So the maxProcess can be set between 2 and 100 for example.
 * 
 * @author hayj
 */
public class LimitedQueue
{
	/**
	 * The max number of process which can start at the same time before finish
	 */
	private int maxProcess;
	/**
	 * The queue containing all process which perform the processing
	 */
	private LinkedList<Process> processing = new LinkedList<Process>();
	/**
	 * The queue containing all pending process'
	 */
	private LinkedList<Process> pending = new LinkedList<Process>();

	/**
	 * Interface that you must implements for the LimitedQueue
	 * 
	 * @author hayj
	 */
	public interface Process
	{
		public void addToQueue();

		public void start();
	}

	public LimitedQueue(int maxProcess)
	{
		this.maxProcess = maxProcess;
	}

	/**
	 * Add a Process to the LimitedQueue
	 * 
	 * @param newProcess
	 * @return true if the Process start immediately
	 */
	public synchronized boolean push(Process newProcess)
	{
		// We start the process if the processing queue is not full and the process is not already in :
		if(this.processing.size() < this.maxProcess && !this.processing.contains(newProcess))
		{
			System.out.println(newProcess + " started !");
			// We store the newProcess in this queue to know that this queue is processing :
			this.processing.addLast(newProcess);
			// We start the process :
			newProcess.start();
			return true;
		}
		// else we add the newProcess in the pending queue if it's not already in :
		else if(!this.pending.contains(newProcess))
		{
			System.out.println(newProcess + " pending !");
			this.pending.add(newProcess);
			return false;
		}
		return false;
	}

	/**
	 * You must call this method when a Process is finshed. This method start the next pending Process if exists.
	 * 
	 * @param finishedProcess
	 */
	public synchronized void finished(Process finishedProcess)
	{
		System.out.println(finishedProcess + " finished !");
		// Remove the finished process :
		this.processing.remove(finishedProcess);
		// Get the current pendingSize :
		int pendingSize = this.pending.size();
		// We search a Process to start if the pending queue is not empty :
		if(pendingSize > 0)
		{
			int index = -1;
			Process p = null;
			// While we have in the queue range and
			do
			{
				// This is the current index in the pending LinkedList :
				index++;
				// We remove the first element to push it in the processing queue :
				p = this.pending.removeFirst();
				// Repeat if the current index is lower than the snapshoted size of the pending and if the current removed Process is not yet started. Warning : if the current removed Process is not started, the push method will add it at the END of the queue, but this element will be not removed 2 times !
			} while(index < pendingSize && !this.push(p));
		}
	}

	public synchronized void setMaxProcess(int maxProcess)
	{
		this.maxProcess = maxProcess;
	}
}
