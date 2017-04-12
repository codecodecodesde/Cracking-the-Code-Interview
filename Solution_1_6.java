import java.lang.*;

public class Solution_1_6{

	//assumming only 'a' - 'z'!

	//it works only when the character order is not significant
	public String compressedString_Wrong(String str){
		int[] alphabet = new int[26];
		for(int i = 0; i < str.length(); i++){
			alphabet[str.charAt(i)-'a']++;
		}
		StringBuilder s = new StringBuilder();
		s.append(str.charAt(0));
		s.append(alphabet[str.charAt(0)-'a']);
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) != str.charAt(i - 1)){
				s.append(str.charAt(i));
				s.append(alphabet[str.charAt(i)-'a']);
			}
		}

		if(str.length() < s.length())
			return str;
		else
			return new String(s);//?
	}

	//compress string at first and then compare the length(return the shorter one)
	public String compressString_1(String str){
		StringBuilder compressed = new StringBuilder();
		int countCounsecutive = 0;
		for(int i = 0; i < str.length(); i++){
			countCounsecutive++;

			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
				compressed.append(str.charAt(i));
				compressed.append(countCounsecutive);
				countCounsecutive = 0;
			}
		}

		return compressed.length() < str.length()? compressed.toString() : str;
	}

	//check the length of two string at first, and then compress the string if it is necessary
	public String compressString_2(String str){

		int finalLength = countCompression(str);
		if(finalLength >= str.length())
			return str;
		int countCounsecutive = 0;
		StringBuilder compressed = new StringBuilder(finalLength);
		for(int i = 0; i< str.length(); i++){
			countCounsecutive++;

			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
				compressed.append(str.charAt(i));
				compressed.append(countCounsecutive);

				countCounsecutive = 0;
			}
		}
		return compressed.toString();
	}

	private int countCompression(String str){
		int sumLength = 0;
		int countCounsecutive = 0;
		for(int i = 0; i< str.length(); i++){
			countCounsecutive++;

			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
				sumLength = sumLength+ 1 + String.valueOf(countCounsecutive).length();
				countCounsecutive = 0;
			}
			
		}
		return sumLength;
	}

	public static void main(String[] args){
		Solution_1_6 s = new Solution_1_6();
		System.out.println(s.compressedString_Wrong("aabbccaaa"));
		System.out.println(s.compressString_1("aabbccaaa"));
		System.out.println(s.compressString_2("aabbccaaa"));

	}
}