package edu.eci.arsw.primefinder;

import java.math.BigInteger;

import edu.eci.arsw.math.MathUtilities;

public class PrimeThread extends Thread {
	private BigInteger a;
	private BigInteger b;
	private PrimesResultSet prs;
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
            itCount++;
            if (mt.isPrime(i)){
                prs.addPrime(i);
            }

            i=i.add(BigInteger.ONE);
        }
	}
}
