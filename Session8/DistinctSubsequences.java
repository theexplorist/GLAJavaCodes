package Session8;

class DistinctSubsequences {
	// s: given string  , t: target string , sis: starting index of s , sit: starting index of t 
    public static int helper(String s ,String t , int sis , int sit , int[][] dp){
        if(t.length()==sit){
            return 1;
        }
        if(s.length()==sis){
            return 0;
        }
        if(dp[sis][sit]!=-1){
            return dp[sis][sit];
        }
        int inc =0, exc = 0;
        if(s.charAt(sis)==t.charAt(sit)){
           inc =  helper(s , t , sis+1 , sit+1 , dp);
        }
        exc = helper(s , t ,sis+1 , sit ,  dp);
        dp[sis][sit] = inc + exc;
        return inc +exc;
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] rows:dp){
            Arrays.fill(rows , -1);
        }

        int res = helper(s , t , 0 , 0  ,dp); 
        return res;
    }
}
