
public class Test {

	public static void main(String[] args) {
		char[] s = {'H', 'E', 'L','L', 'O'};
		System.out.println(s);
		
		reverseString(s);
		

	}
	
	
	 public static void reverseString(char[] s) {
	        
	      char[] k = new char [s.length];
	        for (int i = 0; i<s.length; i++) {
	        	k[i] = s[i];
	        }
	        
	      int i = 0;
	      int j = s.length-1;
	        
	        while (i < k.length)
	        {
	            s[i] = k[j];
	            i++;
	            j--;
	        }
	        System.out.println(s);
	    }

}
