public class Solution_1_9{
	public boolean isRotation(String str1, String str2){

		//check the corner case!!! DON'T FORGET IT!
		if(str2.length() != str1.length() || str1.length() == 0)
			return false;

		String concatenated = str2 + str2;
		if(concatenated.contains(str1))
			return true;
		else
			return false;
	}

	public static void main(String[] args){
		Solution_1_9 s = new Solution_1_9();
		System.out.print(s.isRotation("erbottlewat", "bottlewater"));
	}
}