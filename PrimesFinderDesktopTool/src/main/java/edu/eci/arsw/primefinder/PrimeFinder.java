package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder{
        
	private static List<PrimeThread> primes;
	public static void findPrimesN(int a, int b, PrimesResultSet prs, int hilos) {
		//	  BigInteger a=_a;
        //  BigInteger b=_b;
		int total = b-a;
		int count = total/hilos;
		int mod = total%hilos;
		//List<PrimeThread> primes = new LinkedList<>();
		primes = new LinkedList<>();
		for(int i = 0; i < hilos;i++){
			if(i == hilos-1) {
				//PrimeThread hilo = new PrimeThread(BigInteger.valueOf((i*count)),BigInteger.valueOf((i*count)+mod),prs);
				PrimeThread hilo = new PrimeThread((i*count),(i*count)+mod,prs);
				primes.add(hilo);
				hilo.start();
			}else {
				PrimeThread hilo = new PrimeThread((i*count),(i*count)+count,prs);
				primes.add(hilo);
				hilo.start();
			}
		}
		for(PrimeThread p : primes) {
			try {
				p.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static List<PrimeThread> getPrimes() {
		return primes;
	}
        
	/*public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs){
            
                BigInteger a=_a;
                BigInteger b=_b;

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
                
	}*/
	
	
	
	
	
}
