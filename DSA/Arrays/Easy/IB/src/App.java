import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solns solns=new Solns();
        Integer[] array = {2,3,1};
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(array));
        System.out.println(solns.makeElementsEqual(A,1));
        System.out.println("Helloxyz, World!");
    }
}
