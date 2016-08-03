/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ZAlgorithm
{
	
	static int[] Zfunc(char[] pt){
		int L = 0, R = 0, n = pt.length;
		int[] ans = new int[n];
		ans[0] = 0;
		for(int k = 1;k < n;++k){
			if(k > R){
				L = R = k;
				while(R < n && pt[R] == pt[R-L]){
					++R;
				}
				ans[k] = R-L;
				--R;
			}
			else{
				int k1 = k - L;
				if(ans[k1] < R - k + 1){
					ans[k] = ans[k1];
				}
				else{
					L = k;
					while(R < n && pt[R] == pt[R-L])++R;
					ans[k] = R-L;--R;
				}
			}
		}
		return ans;
	}
	
	static ArrayList<Integer> match(String pat, String text){
		char[] p = pat.toCharArray();
		char[] t = text.toCharArray();
		char[] newString = new char[p.length + t.length];
		int itr = 0;
		for(char c : p){
			newString[itr++] = c;
		}
		for(char c : t){
			newString[itr++] = c;
		}
		int[] ans = Zfunc(newString);
		itr = p.length + 1;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(;itr<ans.length;++itr){
			if(ans[itr] == p.length){
				al.add(itr - p.length);
			}
		}
		return al;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Testing code
		String a = "tea";
		String b = "abcdteavtea";
		ArrayList<Integer> ans = match(a,b);
		for(int i : ans){
			System.out.println(i);
		}
	}
}
