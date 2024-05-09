package Insta;


import java.util.*;

/*
Given an array A , representing seats in each row of a stadium.
You need to sell tickets to B people. Each seat costs equal to the number of vacant seats
in the row it belongs to. The task is to maximize the profit by selling the tickets to B people.Problem
Constraints 1 <= |A| <= 100000 & 1 <= B <= 1000000
Input Format: First argument is the array A. Second argument is integer B. Output Format:
Return one integer, the answer to the problem.
Example Input Input 1: A = [2, 3] B = 3;k
Input 2: A = [1, 4] B = 2
Example Output
Output 1: 7
Output 2: 7
Example Explanation
Explanation 1:First you serve the seat with number = 3. Then with 2 and then with 2. hence answer = 3 + 2 + 2 = 7.
Explanation 2:You give both tickets from the row with 4 seats. 4 + 3 = 7.
 */



/*

Given an array of integers A.  There is a sliding window of size B which is moving from the
very left of the array to the very right.

You can only see the w numbers in the window. Each time the sliding window moves
rightwards by one position. You have to find the maximum for each window.

The following example will give you more clarity.

The array A is [1 3 -1 -3 5 3 6 7], and B is 3.

Window position	            Max

———————————-	            ————————-
0   1   2   3  4  5  6  7
[1  3  -1] -3  5  3  6  7	3
[1,2]


1 [3  -1  -3] 5  3  6  7	3
[1,2,3]

1  3 [-1  -3  5] 3  6  7	5
[-1 -3]-add 5
[4]

1  3  -1 [-3  5  3] 6  7	5
[5 3]

1  3  -1  -3 [5  3  6] 7	6
[6]

1  3  -1  -3  5 [3  6  7]	7
[7]

Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Note: If B > length of the array, return 1 element with the max of the array.

Input Format

The first argument given is the integer array A.

The second argument given is the integer B.

Output Format

Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]

For Example

Input 1:

    A = [1, 3, -1, -3, 5, 3, 6, 7]

    B = 3

Output 1:

    C = [3, 3, 5, 5, 6, 7]
 */
public class MMT {
    public int profitSeat(int[] input,int B){
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new OurCustomComparator());
        for(int i=0;i<input.length;i++){
            pq.add(input[i]);
        }
        for(int i=0;i<B;i++){
            if(!pq.isEmpty()){
                ans+=pq.peek();
                int temp=(pq.poll()-1);
                pq.add(temp);
            }
        }
        return ans;
    }

    class OurCustomComparator implements Comparator<Integer> {
        public int compare(Integer s1, Integer s2){
         return s2-s1;
        }
    }

    //The array A is [1 3 -1 -3 5 3 6 7], and B is 3.
    public List<Integer> slidingWindowMax(int[] input,int b){
        List<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<b;i++){
            if(dq.isEmpty()){
                dq.add(i);
            }
            else{
                while(input[i]>=input[dq.getFirst()]){
                    dq.removeFirst();
                    dq.add(i);
                }
            }
        }
        ans.add(input[dq.getFirst()]);
        if(b>input.length){
            return ans;
        }
        for(int i=b;i<input.length;i++){
            if((i-b)==dq.getFirst()){
               dq.pollFirst();
            }
            while(!dq.isEmpty()){
                if(input[dq.getLast()]<=input[i])
                dq.removeLast();
                else{
                    dq.add(i);
                    break;
                }
            }
            if(dq.isEmpty())
                dq.add(i);
            ans.add(input[dq.getFirst()]);
        }
        return ans;
    }


}
