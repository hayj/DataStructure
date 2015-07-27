package fr.hayj.datastructure;

import java.util.LinkedList;

/**
 * Perform an ordered execution of process
 * 
 * @author hayj
 */
public class GenerationQueue<Process>
{
	private LinkedList<Process> queue = new LinkedList<Process>();
	private GenerationQueueListener listener;

	public interface Process
	{
		public void startGeneration();

		public void stopEvent();
	}

	public interface GenerationQueueListener
	{
		public void onfinished();
	}

	public GenerationQueue(GenerationQueueListener listener)
	{
		this.listener = listener;
	}

	public synchronized void add(Process process)
	{
		// If the queue is empty, we must start the first entry :
		if(this.queue.isEmpty())
			process.startGeneration();
		// Then we add the page to the list :
		this.queue.addLast(process);
	}

	public synchronized void next()
	{
		// Remove the previous page :
		this.queue.removeFirst();
		// If we have an other page to start :
		if(!this.queue.isEmpty())
		{
			// Peek (not remove) and start the first element :
			this.queue.peek().startGeneration();
		}
		// Else we can clear the queue :
		else
			this.listener.onfinished();
	}
}