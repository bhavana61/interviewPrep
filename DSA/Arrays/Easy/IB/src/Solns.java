import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Solns {
    //Array Math
    public int solve(ArrayList<Integer> A, int B) {
            int ans=0;
            int size=A.size();
            for(int i=0;i<B;i++){
                ans+=A.get(i);
            }
            int max=ans;
            /*
             *  A = [5, -2, 3 , 1, 2]
             *       0   1  2   3  4
                B = 3
             */
            for(int j=size-1;j>=size-B;j--){
                ans+=(A.get(j)-A.get(B-1-(size-1-j)));
                if(ans>max)
                max=ans;
            }
            return max;
    }
  
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        /*
         * A = [0, 1, 1]
           B = [0, 1, 2]
         */
        int ans=0;
        for(int i=0;i<(A.size()-1);i++){
               ans+=Math.max(Math.abs(A.get(i+1)-A.get(i)),Math.abs(B.get(i+1)-B.get(i)));
        }
        return ans;
    }

    public int lightCorrider(ArrayList<Integer> A, int B) {
        ArrayList<Integer> a=new ArrayList<>();
        TreeSet<Integer> lowValue = new TreeSet<Integer>(); 
        lowValue.lower(6);
        return 0;
    }

    public int maximumSumTriplet(ArrayList<Integer> A) {
       int ans=0;
       // [2, 5, 3, 1, 4, 9]
       int size=A.size();
       int[] suffixArray=new int[size];
       suffixArray[size-1]=Integer.MIN_VALUE;
       for(int i=size-2;i>=0;i--){
        suffixArray[i]=Math.max(A.get(i+1), suffixArray[i+1]);
       }
       TreeSet<Integer> treeSet=new TreeSet<>();
       treeSet.add(Integer.MIN_VALUE);
       for(int i=0;i<(size-1);i++)
       {
        if(suffixArray[i]>A.get(i)){
        ans=Math.max(ans,treeSet.lower(A.get(i))+A.get(i)+suffixArray[i]);
        }
        treeSet.add(A.get(i));
       }
       return ans;
    }

    public int maxSubArray(final List<Integer> A) {
        int ans=A.get(0);
        int max=A.get(0);
        for(int i=1;i<A.size();i++){
            if((A.get(i)+ans)>A.get(i)){
                ans=(ans+A.get(i));
            }
            else{
                ans=A.get(i);
            }
            max=Math.max(ans, max);
        }
        return max;
    }
   
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        List<Integer> real=new ArrayList<>();
        ArrayList<Integer> answer=new ArrayList<>();
        int n=A.size();
        for(int i=0;i<n;i++){
            if(A.get(i)!=0)
            {
                real=A.subList(i, n);
                break;
            }
        }
        Collections.reverse(real);
        if(real.size()==0){
            real.add(1);
            return (ArrayList)real;
        }
        int carry=1;
        for(int i=0;i<real.size();i++){
            carry=real.get(i)+carry;
            answer.add(carry%10);
            carry=carry/10;
        }
        if(carry!=0)
        {
            answer.add(carry);
        }
        Collections.reverse(answer);
        return answer;
    }

    public int maxArr(ArrayList<Integer> A) {


        // int ans=0;
        // int n=A.size();
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=i;j<n;j++){
        //         ans=Math.max(ans,Math.abs(A.get(i)-A.get(j))+Math.abs(i-j));
        //     }
        // }      
        // return ans;
        int maxSum=A.get(0);
        int maxDiff=A.get(0);
        int minSum=A.get(0);
        int minDiff=A.get(0);

        for(int i=0;i<A.size();i++){
            maxSum=Math.max(maxSum,A.get(i)+i);
            minSum=Math.min(minSum,A.get(i)+i);
        }
        int sumsRes=maxSum-minSum;

        for(int i=0;i<A.size();i++){
            maxDiff=Math.max(maxDiff,A.get(i)-i);
            minDiff=Math.min(minDiff,A.get(i)-i);
        }
        int difRes=maxDiff-minDiff;

        return Math.max(sumsRes,difRes);
    }

    public int maxMin(ArrayList<Integer> A) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++){
            if(A.get(i)>max)
            max=A.get(i);
            if(A.get(i)<min)
            min=A.get(i);
        }
        return max+min;
    }

    public int perfectPeak(ArrayList<Integer> A) {
        int n=A.size();
        int[] leftMax=new int[n];
        leftMax[0]=A.get(0);
        int[] rightMin=new int[n];
        rightMin[n-1]=A.get(n-1);
        //5, 1, 4, 3, 6, 8, 10, 7, 9
        //5  5  5  5  5  6  8  10 10            //leftMax 
        //         6  7  7  7   9  9     //rightMin
        for(int i=1;i<n-1;i++){
             leftMax[i]=Math.max(leftMax[i-1], A.get(i-1));
        }
        for(int i=n-2;i>0;i--){
            rightMin[i]=Math.min(rightMin[i+1], A.get(i+1));
       }
       for(int i=1;i<n-1;i++){
               if(leftMax[i]<A.get(i)&&A.get(i)<rightMin[i]){
                  return 1;
               }
       }
        return 0;
    }

    public ArrayList<Integer> moveZeroes(ArrayList<Integer> A) {
        int zeroPointer=Integer.MAX_VALUE;
        int nonZeroPointer=Integer.MAX_VALUE;
        int n=A.size();
        for(int i=0;i<n;i++){
            if(A.get(i)==0){
                zeroPointer=i;
                break;
            }
        }
        for(int i=zeroPointer;i<n;i++){
            if(A.get(i)!=0){
                nonZeroPointer=i;
                break;
            }
        }
        for(int i=zeroPointer;i<n;){
            if(nonZeroPointer>n-1)
            break;
            if(A.get(i)==0){
                int temp=A.get(zeroPointer);
                A.set(zeroPointer, A.get(nonZeroPointer));
                A.set(nonZeroPointer, temp);
                while(zeroPointer<n&&A.get(zeroPointer)!=0){
                    zeroPointer++;
                }
                if(zeroPointer<n){
                    i=zeroPointer;
                }
                else{
                    break;
                }
                while(nonZeroPointer<n&&A.get(nonZeroPointer)==0){
                    nonZeroPointer++;
                }
            }
        }
        return A;
    }


    public int makeElementsEqual(ArrayList<Integer> A, int B) {
        int subtract=A.get(0)-B;
        int add=A.get(0)+B;
        int nothing=A.get(0);
        for(int i=1;i<A.size();i++){
            int subtractI=A.get(i)-B;
            int addI=A.get(i)+B;
            int nothingI=A.get(i);
            if((subtractI!=subtract||(subtractI!=add || subtractI!=nothing))||
            (addI!=subtract||(addI!=add || addI!=nothing))||
            (nothingI!=subtract||(nothingI!=add || nothingI!=nothing)))
            {
                return 0;
            }
        }
        return 1;
    }
}
