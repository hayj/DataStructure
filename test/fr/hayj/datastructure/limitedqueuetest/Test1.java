package fr.hayj.datastructure.limitedqueuetest;

import fr.hayj.datastructure.Utils;

public class Test1
{
	public static void main(String[] args)
	{

		// Init :
		Generation gen1 = new Generation();
		Generation gen2 = new Generation();
		Generation gen3 = new Generation();
		Generation gen4 = new Generation();
		Generation gen5 = new Generation();
		Generation gen6 = new Generation();
		Generation gen7 = new Generation();
		Generation gen8 = new Generation();
		Generation gen9 = new Generation();

		// Start all gens :
		gen1.addToQueue();
		gen1.addToQueue();
		gen1.addToQueue();
		gen2.addToQueue();
		gen3.addToQueue();
		gen5.addToQueue();
		gen6.addToQueue();
		gen7.addToQueue();
		gen7.addToQueue();
		Utils.sleep(3000);
		gen3.addToQueue();
		gen4.addToQueue();
		gen5.addToQueue();
		gen1.addToQueue();
		gen1.addToQueue();
		gen6.addToQueue();
		Utils.sleep(3000);
		gen7.addToQueue();
		gen1.addToQueue(); 
		gen8.addToQueue();
		gen9.addToQueue();
		Utils.sleep(3000);
		for(int i = 0 ; i < 100 ; i++)
			gen1.addToQueue();

	}
}