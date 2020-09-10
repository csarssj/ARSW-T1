package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?>  getPrimes()
    {
    	List<FoundPrime> primes = null;
    	primes = primeService.getFoundPrimes();
    	return new ResponseEntity<>(primes, HttpStatus.ACCEPTED);
    }
    
    @RequestMapping( value = "/primes/{primenumber}", method = GET )
    public ResponseEntity<?> getPrime(@PathVariable String primenumber)
    {
    	FoundPrime prime = primeService.getPrime(primenumber);
    	return new ResponseEntity<>(prime,HttpStatus.ACCEPTED);
    }
    
    @RequestMapping( value = "/primes", method = POST )
    public ResponseEntity<?> getPrime(@RequestBody FoundPrime prime)
    {
        primeService.addFoundPrime(prime);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //TODO implement additional methods provided by PrimeService



}
