
import java.util.List;
import java.util.*;
public class StudentSolver{
 public static ArrayList<Integer>solve(ArrayList<Integer>initialOrder, ArrayList<ArrayList<Integer>> magic){
    ArrayList<Integer> a = new ArrayList<Integer>();
    for (int i =0;i<initialOrder.size()-1;i++){
        a.add(0);
    }
     System.out.println(a);
     return a;
  }
/*public static void main (String [] args){
    ArrayList<Integer>initialOrder= new ArrayList<Integer>();
    initialOrder.add(0);
    initialOrder.add(1);
    initialOrder.add(2);
    initialOrder.add(3);
    initialOrder.add(4);
    
    solve(initialOrder);
  }*/
}