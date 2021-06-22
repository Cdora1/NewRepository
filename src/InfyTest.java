
public class InfyTest {

	private static int  FindMaxInsert(String str) {
        int amount =0;
         char forbiddenChar = 'a';
        if (str.contains("aaa")){
            amount = -1;
        }

        else {
            if (str.length() == 1){
                if (str.charAt(0) == forbiddenChar)
                    amount = 1; 
                else
                    amount = 4; // B - > aaBaa
            }
            else if (str.length() == 2)
            {
                if ((str.charAt(0) == forbiddenChar && str.charAt(1) != forbiddenChar) || (str.charAt(0) != forbiddenChar && str.charAt(1) == forbiddenChar))
                    amount = 3; 
            }

            else if (str.length() > 2)
            {
                if (str.indexOf(0) != forbiddenChar)
                    amount += 2;
                if (str.indexOf(str.length()-1)!= forbiddenChar)
                    amount += 2;

                for (int i = 0; i < str.length() - 2; i += 2){
                    char first = str.charAt(i);
                    char middle = str.charAt(i + 1);
                    char last = str.charAt(i + 2);


                    if (first == forbiddenChar && middle == forbiddenChar && last == forbiddenChar)
                        amount += 0; 


                    else if (first == forbiddenChar && middle == forbiddenChar && last != forbiddenChar)
                        amount += 0; 

                    else if (first == forbiddenChar && middle != forbiddenChar && last == forbiddenChar)
                        amount += 2; 

                    else if (first == forbiddenChar && middle != forbiddenChar && last == forbiddenChar)
                        amount += 0; 

                    else if (first == forbiddenChar && middle != forbiddenChar && last != forbiddenChar)
                        amount += 3;

                    else if (first != forbiddenChar && middle == forbiddenChar && last != forbiddenChar)
                        amount += 1;

                    else if (first != forbiddenChar && middle != forbiddenChar && last == forbiddenChar)
                        amount += 3;  

                    else if (first != forbiddenChar && middle != forbiddenChar && last != forbiddenChar)
                        amount += 4; 
                }
            } 
        }

        return amount;

    }

	public static void main(String args[]) {
		System.out.println(solution("aabab"));
	}
	
	static int solution(String s) {
	    int count_As = 0, count_others = 0, s_len = s.length();
	    for (int i = 0; i < s_len; ++i) {
	        if (s.charAt(i) == 'a') {
	            count_As++;
	        }
	        else {
	            count_others++;
	            count_As = 0;
	        }
	        if (count_As == 3) {
	            return -1;
	        }
	    }
	    return 2 * (count_others + 1) - (s_len - count_others);
	}




}
