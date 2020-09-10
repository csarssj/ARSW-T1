package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @version 2.0
 * @author Ceseg
 * 10/09/20.
 * 
 */
@RestController
public class PrimesController
{
	@Autowired
    PrimeService primeService;


    @RequestMapping( value = "/primes", method = GET )
    public List<FoundPrime> getPrimes()
    {
        return primeService.getFoundPrimes();
    }
    
    @RequestMapping( value = "/primes/{primenumber}", method = GET )
    public FoundPrime getPrime(@PathVariable String primenumber)
    {
        return primeService.getPrime(primenumber);
    }
    
    @RequestMapping( value = "/primes", method = POST )
    public void getPrime(@RequestBody FoundPrime prime)
    {
        primeService.addFoundPrime(prime);
    }
    //TODO implement additional methods provided by PrimeService



}
