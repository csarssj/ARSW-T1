package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

/**
 * @version 2.0
 * @author Ceseg
 * 10/09/20.
 * 
 */
@Service
public class PrimeServiceStub implements PrimeService
{	
	private List<FoundPrime> primes = new CopyOnWriteArrayList<>();
	public PrimeServiceStub () {
		FoundPrime p1 = new FoundPrime();
		p1.setUser("James");
		p1.setPrime("5");
		primes.add(p1);
		
		FoundPrime p2 = new FoundPrime();
		p2.setUser("CR7");
		p2.setPrime("7");
		primes.add(p2);
	}
    @Override
    public void addFoundPrime( FoundPrime foundPrime )
    {
        boolean existe = false;
    	for(FoundPrime p:primes) {
        	if(p.equals(foundPrime)) {
        		existe = true;
        	}
        }
    	if(!existe) {
    		primes.add(foundPrime);
    	}
        
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        //TODO
        return primes;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        for(FoundPrime p:primes) {
        	if(p.getPrime().equalsIgnoreCase(prime)) {
        		return p;
        	}
        }
        return null;
    }
}
