package string;

public class StringPermutations {

	int counter = 0;

	public static void main(String[] args) {
		String str = "ab";
		StringPermutations sp = new StringPermutations();
		sp.permute(str, 0, str.length() - 1);
		System.out.println(sp.counter);
	}
	void permute(String str, int l, int r) {
		if (l == r) {
			counter++;
			System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}
	String swap(String str, int l, int r) {
		char temp;
		char ch[] = str.toCharArray();
		temp = ch[l];
		ch[l] = ch[r];
		ch[r] = temp;
		str = String.valueOf(ch);
		return str;
	}
}
