package fr.hayj.datastructure.limitedqueuetest;
import fr.hayj.datastructure.LimitedQueue;
import fr.hayj.datastructure.Utils;

public class Generation implements LimitedQueue.Process
{
	static LimitedQueue queue = new LimitedQueue(3);
	public static int nextID = 1;
	private int id;

	Generation()
	{
		this.id = Generation.nextID++;
	}

	public String toString()
	{
		return "Generation " + this.id;
	}

	public void addToQueue()
	{
		Generation.queue.push(this);
	}

	@Override
	public void start()
	{
		new Thread()
		{
			@Override
			public void run()
			{
				Utils.sleep(1000);
				Generation.queue.finished(Generation.this);
			}
		}.start();
	}
}