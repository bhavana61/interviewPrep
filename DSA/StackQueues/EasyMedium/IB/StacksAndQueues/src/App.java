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
