import java.util.*;

public class Solution_1_1{

	//HashSet
	public boolean isUnique_1(String str){
		HashSet<Character> h = new HashSet<>();

		for(int i=0; i< str.length(); i++){
			h.add(str.charAt(i));
		}

		if(h.size() < str.length())
			return false;
		else
			return true;
	}


	//create alphabet--need to clarify your assumption with your interviewer
	public boolean isUnique_2(String str){
		if(str.length() > 128)
			return false;//!!!

		boolean[] charset = new boolean[128];
		for(int i = 0; i< str.length(); i++){
			if(charset[str.charAt(i)])
				return false;
			else
				charset[str.charAt(i)] = true;
		}
		return true;
	}

	//if you are allowed to modified the string, sorting this string works
	public boolean isUnique_3(String str){
		char[] c = str.toCharArray();//!!! new?
		Arrays.sort(c);
		for(int i = 1; i < c.length; i++){
			if(c[i] == c[i-1])
				return false;
		}
		return true;
	}

	//assumming this string only includes a-z
	//use bit vector
	public boolean isUnique_4(String str){
		int check = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 'a'; // attention! priority
			if((check & (1 << val)) > 0) // expr > 0: the ith position in check is 1 (duplicated!)
				return false;
			check |= (1 << val);// mark the ith postion in check as 1. (appeared!)
		}
		return true;
	}

	public static void main(String[] args){
		Solution_1_1 s = new Solution_1_1();
		System.out.println(s.isUnique_1("example"));
		System.out.println(s.isUnique_2("example"));
		System.out.println(s.isUnique_3("example"));
		System.out.println(s.isUnique_4("example"));
	}
}