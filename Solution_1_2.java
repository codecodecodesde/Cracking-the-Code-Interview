import java.util.*;
public class Solution_1_2{
	/*easy to miss: is whitespace significant? 
					is case sensitive?
					check the length of two string at first before call isPermutation(...)*/

	//1.sort string
	public boolean isPermutation_1(String str1, String str2){
		if(str1.length() != str2.length())
			return false;

		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(Arrays.equals(c1,c2)) // attention! how to compare two array
			return true;
		else
			return false;
	}

	//2. sort string(similar to version 1, but different implementation)
	private String sort(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	public boolean isPermutation_2(String str1, String str2){
		if(str1.length() != str2.length())
			return false;

		return sort(str1).equals(sort(str2));
	}


	//3. check the identical character counts in two strings.
	public boolean isPermutation_3(String str1, String str2){
		if(str1.length() != str2.length())
			return false;

		int[] alphabet = new int[128]; // ASCII or Unicode(comminicate!!)
		for(int i = 0; i < str1.length(); i++){
			alphabet[str1.charAt(i)]++;
		}

		for(int i = 0; i < str2.length(); i++){
			alphabet[str2.charAt(i)]--;
			if(alphabet[str2.charAt(i)] < 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args){
		Solution_1_2 s = new Solution_1_2();
		System.out.println(s.isPermutation_1("amazing", "amaingz"));
		System.out.println(s.isPermutation_2("amazing", "amaingz"));
		System.out.println(s.isPermutation_3("amazing", "amaingz"));
	}
}