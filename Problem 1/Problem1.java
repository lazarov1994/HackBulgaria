/**
 * @author Lazar Lazarov
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Problem1 {

	public static void primesInAnInterval(int a, int b){
		
		if(a>=b || a<0 || b<0 ){
    		System.out.println("Invalid input");	
    	}
		else{
		ArrayList<Integer> c = new ArrayList<Integer>();
		if(a==1 || a==0){
			c.add(1);
		}
        boolean[] isPrime = new boolean[b + 1];
        //Arrays.fill(isPrime, Boolean.TRUE);
        for (int i = 2; i <= b; i++) {
            isPrime[i] = true;
        }

        
        for (int i = 2; i <= Math.sqrt(b) ; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= b; j=j+i) {
                    isPrime[j] = false;
                }
            }
        }
        
        	for(int i = a ; i<=b ; i++){
			if(isPrime[i]){
				c.add(i);
			}
		}
        	
        	//System.out.println(c);
        	}
		//return c;
	}

	public static void main(String[] args) {

		

		long start = System.currentTimeMillis();
		primesInAnInterval(1,10000000);
		System.out.println("The program was execfuted for: "
				+ (System.currentTimeMillis() - start) + " milliseconds.");
		
	}
}
