public class Solution_1_3{

	//1.count #space; create a new char[] to write from starting to end
	public String replaceSpace_1(String str, int trueLength){
		int spacecount = 0;
		for(int i = 0; i < trueLength; i++){
			if(str.charAt(i) == ' ')
				spacecount++;
		}

		int index = trueLength + spacecount * 2;//" "->"%20"
		char[] c = new char[index];
		for(int i = 0, j = 0; i < trueLength; i++){
			if(str.charAt(i) == ' '){
				c[j] = '%';
				c[j+1] = '2';
				c[j+2] = '0';
				j = j + 3;
			}
			else{
				c[j] = str.charAt(i);
				j++;
			}
		}

		String s = new String(c);
		return s;
	}


	//2.count #space; rewrite the char[] from end to starting
	//assuming that the string has sufficient space at the end to hold the additional characters
	public String replaceSpace_2(char[] c, int trueLength){
		int spacecount = 0, i = 0, index;
		for(i = 0 ; i < trueLength; i++){
			if(c[i] == ' ')
				spacecount++;
		}


		index = trueLength + spacecount * 2;
//		if(trueLength < c.length)
//			c[trueLength] = '\0';//???
		for(i = trueLength -1; i >= 0; i--){
			if(c[i] == ' '){
				c[index - 1] = '0';
				c[index - 2] = '2';
				c[index - 3] = '%';
				index = index - 3;
			}
			else{
				c[index - 1] = c[i];
				index--;
			}
		}
		return new String(c,0,trueLength + spacecount * 2 );
	}

	public int findLastCharacter(char[] c){
		for(int i = c.length - 1; i >= 0; i--){
			if(c[i] != ' ')
				return i;
		}
		return -1;
	}

	public static void main(String[] args){
		Solution_1_3 s = new Solution_1_3();
		String str = "Mr John Smith       ";

		System.out.println("test method1: " + "\""+s.replaceSpace_1(str,13)+"\"");

		char[] arr = str.toCharArray();
		int trueLength = s.findLastCharacter(arr) + 1;
		System.out.println("test method2: " + "\""+s.replaceSpace_2(arr, trueLength)+"\"");
		
	}

} 