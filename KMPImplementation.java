class KMPImplementation
{
	
	static char[] pat;
	
	static int[] preProcess(String s){
		char[] c = s.toCharArray();
		pat = c;
		int N = c.length;
		int[] prefix = new int[N];
		int i = 1,j = 0;prefix[0] = 0;
		for(;i<N;++i){
			if(c[i] == c[j]){
				++j;
				prefix[i] = j;
			}
			else{
				if(j!=0){
					j = prefix[j-1];
					while(j>0 && c[i]!=c[j]){
						j = prefix[j-1];
					}
					if(c[i] == c[j]){
						prefix[i] = ++j;
					}
					else{
						prefix[i] = j;
					}
				}
				else{
					prefix[i] = j;
				}
			}
		}
		return prefix;
	}
	
	static ArrayList<Integer> KMPAlgo(int[] pre,String s){
		char[] txt = s.toCharArray();
		int i = 0, j =0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(i < txt.length){
			if(txt[i] == pat[j]){
				++i;
				++j;
			}
			else{
				if(j!=0){
					j = pre[j-1];
				}
				else{
					++i;
				}
			}
			if(j == pre.length){
				ans.add(i-j);
				j = 0;
			}
		}
		return ans;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] pre = preProcess(s);
		s = sc.next();
		ArrayList<Integer> ans = KMPAlgo(pre,s);
		for(int a : ans){
			System.out.println(a);
		}
	}
}
