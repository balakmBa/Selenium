package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class duplicate {

    public static void main(String[] args) {
        int[] a = {1,1,0,2,3,4,5,6,7,8,9,10,1,2,2,3,3,3,4,10};

        for(int i=0;i<a.length;i++){
            for(int j=1;j<a.length;j++){
                if(a[i]==a[j]){
                    System.out.println(a[i]);
                }
            }
        }
        List<Integer> b=new ArrayList<>();
        for(int k=0;k<a.length;k++){
            b.add(a[k]);
        }
        HashMap<Integer,Integer> mp= new HashMap<>();

        for(int m=0;m<b.size();m++){

            if (mp.containsKey(b.get(m))){
                mp.put(b.get(m),mp.get(b.get(m))+1 );
            }
            else {
                mp.put(b.get(m),1);

            }

        }
        System.out.println(mp);
        System.out.println(reversestring("ala"));
        System.out.println(factorial(5));
        System.out.println(vowelsInString("strIng"));
        System.out.println(checkSpecialzCharacters("bala"));
        System.out.println(checkSpecialzCharacters("bala*"));

        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        System.out.println(Math.sqrt(24));
        System.out.println(Double.MIN_VALUE);
        System.out.println(1.0/0.0);
        System.out.println(1.0/0);
        System.out.println(0/0.0);
        //System.out.println(0/0);
        //System.out.println(1/0);
        System.out.println(0.1*3);

        //



    }

    public static String reversestring(String str){
        char[] revchar=str.toCharArray();
        String revstr = "";
        for(int i=revchar.length-1;i>=0;i--){
            revstr=revstr+revchar[i];

        }
        return revstr;
    }


    public static int factorial(int n){
        int i;
if(n==1){
    return 1;
}
else {
     return (n*factorial(n-1));
}

    }

  public static boolean vowelsInString(String vowelStr){
      char[] c= vowelStr.toCharArray();
      boolean b=vowelStr.toLowerCase().matches(".*[aeiou].*");
      for (int i = 0; i <c.length ; i++) {
          System.out.println(c[i]);
      }
      return b;

  }

  public static boolean checkSpecialzCharacters(String spc){
        boolean b=spc.matches(".*[~`@#$%^*,.><;:'\"].*");


        return b;
  }

}
