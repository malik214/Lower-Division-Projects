
public class Shuffle {

	public static void main(String[] args) {
		String s = "codeleet";
		System.out.println(s);
		
		int indices[] = {4,5,6,7,0,2,1,3};
		
		System.out.println(restoreString(s, indices));
		
	}
	
	
	
	
	   public static String restoreString(String s, int[] indices) {
		    
	        int n = s.length();
	        char t[] = new char [n];
	        
	        for (int i = 0; i< n; i++)
	        {
	            int pos = indices[i];
	            t[pos] = s.charAt(i);
	        }
	        
	        
	        String result = "";
	        
	        for (int i =0; i<t.length; i++)
	        {
	            result += t[i];
	        }
	        
	        return result;
	    }

}
