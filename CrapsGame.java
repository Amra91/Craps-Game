/*
 *  (Game: craps) Craps is a popular dice game played in casinos. 
 *  Write a program to play a variation of the game, 
 *  as follows: Roll two dice. 
 *  Each die has six faces representing values 1, 2, …, and 6, respectively. 
 *  Check the sum of the two dice. 
 *  If the sum is 2, 3, or 12 (called craps), you lose; 
 *  if the sum is 7 or 11 (called natural), you win; 
 *  if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), 
 *  a point is established. 
 *  Continue to roll the dice until either a 7 or the same point value is rolled. 
 *  If 7 is rolled, you lose. 
 *  Otherwise, you win. 
 *  
 *  Your program acts as a single player. Here are some sample runs.
 */
public class CrapsGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//suma bacanja dvije kocke
		int sum = rolled();
		/*
		 * ako je rezultat bacanja dvije kocke 2,3,12 (naziva se craps)
		 * tada ste izgubili
		 */
		
		if ((sum == 2) || (sum ==3)|| (sum == 12)){
			System.out.println( "You rolled " + sum);
			System.out.println("You lose.");
			
		}
		/*
		 * ako je rezultat bacanja dvije kocke 7 ili 11 (naziva se natural)
		 * tada ste pobijedili
		 */
		else if ((sum == 7) || (sum==11)){
			System.out.println( "You rolled " + sum);
			System.out.println("You win.");
		}
		/*
		 * ako je rezultat bacanja dvije kocke 4,5,6,8,9,10
		 * point je onaj rezultat koji ste dobili 
		 */
		
		else {
			System.out.println( "You rolled " + sum);
			System.out.println("Point is " + sum );
			
			/*do while petljom stimuliramo ponovno bacanje kocke dve dok ne 
				dobijemo isti broj ili 7, ako dobijemo isti point broj pobjedjujemo. 
				Ako dobijemo sedmicu prije pointa gubimo.
			
			 */
			int nextPoint;
			do {
			    nextPoint= rolled();
			    System.out.println("Next rolled is " + nextPoint);
			   } 
			
			while (!(nextPoint==7 || nextPoint==sum));
				
				
			if (nextPoint==7){
				System.out.println("You lose.");
			}
			else if (nextPoint==sum) {
				System.out.println("You win.");
			}
			
		}
	}
		
		public static int rolled (){
			//prva kocka
			int a = 1+(int)(Math.random() *6);
			//druga kocka
			int b = 1+(int)(Math.random() *6);	
			
			return a+b;
			
	}

}
