public class Solution_1_4{

	//O(N) N is the length of the string
	public boolean isPermOfPan_1(String str){
		int[] table = new int[26];
		for(char c: str.toCharArray()){//compact code
			if(c >= 'a' && c <= 'z')
				table[c - 'a']++; //case insensitive
		}

		int oddMarker = 0;
		for(int i : table){//compact code
			if(oddMarker > 1)
				return false;
			if(i % 2 != 0)
				oddMarker++;
		}
		return true;
	}

	//use bit vector
	public boolean isPermOfPan_2(String str){
		int bitvector = 0;
		for(char c: str.toCharArray()){
			if(c >= 'a' && c <= 'z')
				bitvector = bitvector ^ (1 << (c - 'a'));
		}

		if((bitvector & (bitvector - 1)) != 0)
			return false;
		else
			return true;

	}

	public static void main(String[] args){
		Solution_1_4 s  = new Solution_1_4();
		System.out.println(s.isPermOfPan_1("abc kacb"));
		System.out.println(s.isPermOfPan_2("abc acb"));
	}
		
}