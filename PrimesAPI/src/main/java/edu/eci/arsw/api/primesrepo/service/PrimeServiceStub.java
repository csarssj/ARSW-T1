package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
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
        //TODO
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
        //TODO
        return null;
    }
}
