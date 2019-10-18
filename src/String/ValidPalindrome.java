package String;

/*
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 * 直接模拟就可以了
 * */

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if(s==null) return true;
		int left = 0;
		int right = s.length()-1;
		s = s.toLowerCase();
		
		while(left<=right) {
			while(!isDigitalOrAlpha(s.charAt(left))&&left<right) left++;
			while(!isDigitalOrAlpha(s.charAt(right))&&right>left) right--;
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
    }
	
	public boolean isDigitalOrAlpha(char t) {
		if((t<='9' && t>='0') || (t<='z'&&t>='a')) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("race a car"));
	}

}
