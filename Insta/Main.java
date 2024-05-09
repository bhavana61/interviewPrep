package Insta;

public class Main {

    public static void main(String[] args) {
       // May1stReversePrefix may1stReversePrefix=new May1stReversePrefix();
        //var ans=may1stReversePrefix.reversePrefix("abcedefd",'d');
       // May2nd may2nd=new May2nd();
       // may2nd.findMaxK()
        int[] nums ={1, 3, -1, -3, 5, 3, 6, 7};
        //System.out.println(may2nd.findMaxK(nums));
        MMT mmt=new MMT();
        //A = [1, 3, -1, -3, 5, 3, 6, 7]
        //
        //    B = 3
        System.out.println("xyz");
        System.out.println(mmt.slidingWindowMax(nums,3));
    }
}