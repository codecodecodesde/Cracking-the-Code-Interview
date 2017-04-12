public class Solution_1_5{

	public boolean isOneAway(String str1, String str2){
		if(str1.length() == str2.length()){
			int check = 0;
			for(int i = 0; i < str1.length(); i++){
				if(str1.charAt(i) != str2.charAt(i)){
					if(check != 0)
						return false;
					check = 1;//attention!!!
				}
					
			}
			return true;
		}

		else if(Math.abs(str1.length() - str2.length()) == 1){
			int check = 0;
			int length = 0;

			//compacted code
			String s1 = str1.length() > str2.length()? str1 : str2; //longer
			String s2 = str1.length() > str2.length()? str2 : str1; //shorter
			
			for(int i = 0, j = 0; j < s2.length(); i++, j++){
				if(s1.charAt(i) != s2.charAt(j)){
					if(check != 0)
						return false;

					i++;
					check = 1;
				}
			}
			return true;
		}

		else
			return false;
	}

	public static void main(String[] args){
		Solution_1_5 s = new Solution_1_5();
		System.out.print(s.isOneAway("aple", "apple"));
	}


}