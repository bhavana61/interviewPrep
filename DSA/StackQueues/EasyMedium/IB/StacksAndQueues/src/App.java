package DSA.StackQueues.EasyMedium.IB.StacksAndQueues.src;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        StackAndQueues stackAndQueues=new StackAndQueues();
        String s="/a/./b/../../c/";
        int[] input={34, 35, 27, 42, 5, 28, 39, 20, 28};
        int[] ans=stackAndQueues.prevSmaller2(input);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
        System.out.println("Hello, World!");
    }
}

class StackAndQueues {
    public String simplifyPath(String A) {
//         Input 1:
// A = "/home/"
// Input 2:
// A = "/a/./b/../../c/"


// Example Output
// Output 1:
// "/home"
// Output 2:
// "/c"
        Stack<String> stack=new Stack<>();
        //char[] characters=A.toCharArray();
        String str;
        int n=A.length();
        for(int i=0;i<n;){
            while(i<n&&A.charAt(i)=='/')
            {
                i++;
            }
            int start = i;
            if (i >= n)
                break;
            while(i<n&&A.charAt(i)!='/')
            {
                i++;
            }
            str=A.substring(start, i);
            if(str.equalsIgnoreCase("."))
            {
                continue;
            }
            else if(str.equalsIgnoreCase(".."))
            {
                if(!stack.empty())
                {
                    stack.pop();
                }
            }
            else
            {
                stack.push(str);
            }
        }

        String res="";

        if (stack.isEmpty())
            res = "/";
        while(!stack.empty())
        {
            res="/"+stack.pop()+res;
        }
        return res;
    }

    public int[] prevSmaller(int[] A) {
        int n=A.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                ans[i]=-1;
            else{
                //{4, 5, 2, 10, 8}
                //-1
                if(A[i-1]<A[i])
                    ans[i]=A[i-1];
                else if(ans[i-1]==-1)
                {
                    ans[i]=-1;
                }
                else if(ans[i-1]<A[i]){
                    ans[i]=ans[i-1];
                }
                else{
                    ans[i]=-1;
                }
            }
        }
        return ans;
    }

    public int[] prevSmaller2(int[] A) {
        Stack<Integer> s=new Stack<>();
        int n=A.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            if(s.isEmpty()){
                ans[i]=-1;
                s.add(A[i]);
            }
            else{
                while(!s.isEmpty()){
                    if(s.peek()<A[i]){
                        ans[i]=s.peek();
                        s.push(A[i]);
                        break;
                    }
                    else{
                        s.pop();
                        if(s.isEmpty()){
                            ans[i]=-1;
                            s.add(A[i]);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
