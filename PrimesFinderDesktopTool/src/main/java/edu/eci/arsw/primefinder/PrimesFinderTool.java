package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) {
		            
            int maxPrim=1000;
            
            PrimesResultSet prs=new PrimesResultSet("john");
            
            PrimeFinder.findPrimesN(1, 1000, prs,4);
            //PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("100"), prs);
            
     
            
            boolean task_not_finished = true;
            while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                        int count = 0;
                    	for (PrimeThread p: PrimeFinder.getPrimes()) {
                    		if(p.isEnd()) {
                    			count ++;
                    		}
                    		p.resumen();
                    		if(count == PrimeFinder.getPrimes().size()) {
                    			task_not_finished = false;
                    		}
                    	}
                    }
                    else{
                    	for (PrimeThread p: PrimeFinder.getPrimes()) {
                    		p.Pause();
                    	}
                        System.out.println("User working again!");
                    }
                    System.out.println("Prime numbers found:");
                    
                    System.out.println(prs.getPrimes());
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        
            
            
            
            
	}
	
}


