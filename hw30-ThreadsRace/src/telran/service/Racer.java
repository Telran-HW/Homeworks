package telran.service;

import java.util.Random;

public class Racer extends Thread{
	
	private final static int MIN_SLEEP = 2;
	private final static int MAX_SLEEP = 5;
	static int winner = 0;
    static boolean isWinner = false;
    
    int id = 0;
	int distance = 0;

	Random random = new Random();

	public Racer(int id, int distance) {
		super();
		this.id = id;
		this.distance = distance;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= distance; i++) {
			System.out.println("Thread: " + id + " step " + i + " nanoTime: " + System.nanoTime());
			try {
				Thread.sleep(random.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP);
			} catch (InterruptedException e) {
			}
		}
		
		if (!isWinner) { 
	        isWinner = true;
	        winner = id;
	        System.out.println("\nThread #" + id + " finished FIRST!" + " millisTime" + System.currentTimeMillis() + "\n");
	    }
		
	}
	
	

}
