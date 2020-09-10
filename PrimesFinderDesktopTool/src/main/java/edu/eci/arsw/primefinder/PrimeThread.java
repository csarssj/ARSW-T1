package edu.eci.arsw.primefinder;

import java.math.BigInteger;

import edu.eci.arsw.math.MathUtilities;

public class PrimeThread extends Thread {
	private BigInteger a;
	private BigInteger b;
	private PrimesResultSet prs;
	private boolean end=false;
	private boolean pause=false;
	public PrimeThread(int _a, int _b,PrimesResultSet prs) {
		//this.a = _a;
		//this.a = _b;
		this.a = new BigInteger(String.valueOf(_a));
		this.b = new BigInteger(String.valueOf(_b));
		this.prs = prs;
		
	}
	public void run() {
        MathUtilities mt=new MathUtilities();
        
        int itCount=0;
    
        BigInteger i=a;
        while (i.compareTo(b)<=0){
        	if (pause) {
        		synchronized(this) {
        			try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        	}else {
        		itCount++;
            	if (mt.isPrime(i)){
                	prs.addPrime(i);
            	}
            
            	i=i.add(BigInteger.ONE);
        	}
        	//System.out.println("PrimeThread:" + prs.getPrimes());
        	end = true;
        }
	}
	public synchronized void Pause() {
		this.pause = true;
	}

	public synchronized void resumen() {
		this.pause = false;
		this.notifyAll();
	}
	public boolean isEnd() {
		return end;
	}
}
