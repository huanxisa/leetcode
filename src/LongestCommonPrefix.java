public class LongestCommonPrefix {
    public String solution(String[] strs){
        if (strs.length==0){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }else {
            String strss[] = new String[(strs.length+1)/2];
            for (int i = 0; i < (strs.length+1) / 2; i++) {
                if(strs.length-2*i ==1 ){
                    strss[i] = longestCommonPrefix(strs[2*i], null);
                }else {
                    strss[i] = longestCommonPrefix(strs[2*i], strs[2*i + 1]);
                }
            }
            return solution(strss);
        }
    }

    public String longestCommonPrefix(String a,String b){
        if(null == b){
            return a;
        }else{
            for (int i = 0; i <Math.min(a.length(),b.length()) ; i++) {
                if(a.charAt(i) != b.charAt(i)){
                    return a.substring(0,i);
                }
            }
            return a.substring(0,Math.min(a.length(),b.length()));
        }
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().solution(strs));
    }
}
