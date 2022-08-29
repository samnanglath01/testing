package untitled.src;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.max;
import java.util.*;
public class Hello {


    ArrayList<int[]> arrList = new ArrayList<int[]>();
    private int vertices; // No. of vertices
    private ArrayList<Integer>[] adj; // adjacency list
    private int Edge;
    public int inV[]= new int [100000];
    public int outV[]=new int [100000];
    private ArrayList<Integer> path= new ArrayList<>(); // store ans
    // Constructor
    Hello(int numOfVertices)
    {
        // initialise vertex count
        this.vertices = numOfVertices;
        // initialise adjacency list
        // utility method to initialise adjacency list
        adj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
            //  in[i]=0;
        }
        // System.out.print(out[1]);
    }


    // add edge u-v
    public void getEdge(int outV[],int u)
    {
        int a=  adj[1].get(0);
        //System.out.print("Edge: "+a);
    }
    public void addEdge(Integer u, Integer v)
    {
        adj[u].add(v);
        inV[v]++;
        outV[u]++;
        // System.out.println(outV[3]);
        // System.out.println(in[3]);
    }
    public int Startpoint()
    {
        int start=0;
        for (int i = 0;i<vertices;i++){
            if (outV[i]-inV[i]==1)
            {
                start++;
            }
        }
        return start;
    }
    public int Endpoint()
    {
        int end=0;
        for (int i = 0;i<vertices;i++){
            if (inV[i]-outV[i]==1)
            {
                end++;
            }
        }
        return end;
    }
    public int findStart()
    {
        int startVertice=0;
        // System.out.println(out[3]);
        //  System.out.println(in[3]);
        for (int i = 0;i<vertices;i++)
        {
            if (outV[i]-inV[i]==1)
            {
                return i;
            }
            if (outV[i]>0)
            {
                startVertice =i;
            }
        }

        return startVertice;
    }
    public ArrayList<Integer> Depth(int position){
        //int b= adj[position-1].get(out[position]-1);
        //  System.out.println(b);

        int []arr=new int[2];
        //int []arr=new int[2];

        while (outV[position]!=0){
            // arr[0]=position;
            // arrList.add(arr);
            // int c= outV[position];
            // System.out.println("number of List at position"+position+": "+c);
            // System.out.print("Before: "+position);
            // int w= adj[position].get(0);
            // System.out.println(": "+w);
            // arr[0]=position;
            int next= adj[position].get(--outV[position]);
            // System.out.println("next Value: "+next);
            // int q= adj[position].get(outV[position]);
            // System.out.print("after: "+position);
            // System.out.println(": "+q);
            //arr[1]=next;
            //arrList.add(arr);
            //System.out.print(next);
            // Depth(next);
            // arr[1]=next;
            //arrList.add(arr);
            Depth(next);
        }
        // System.out.println("exit");
        //getEdge(outV,position);
        //System.out.print(position);
        //System.out.println(next);

        //arr[0]=(position);
        path.add(position);
        // arrList.add(arr);
        //Collections.reverse(path);
        //System.out.print("int b: "+b);
        // System.out.print(position);
        return path;


    }


    public static ArrayList<int[]> solve(ArrayList<int[]>dominos)
    {
        int [] pair= new int [1];
        int vertice=-1;
        ArrayList<int[]> List = new ArrayList<int[]>();
        ArrayList<Integer>aa = new ArrayList<>();
        for ( int i = 0; i< dominos.size();i++)
        {
            pair =dominos.get(i);
            for (int j=0;j<2;j++)
            {
                vertice = max(vertice, pair[j]);

            }
        }
        int[] Arr=new int[1];
        Hello graph = new Hello(vertice+1);
        for (int i =0 ; i<dominos.size();i++){
            Arr=dominos.get(i);
            graph.addEdge(Arr[0],Arr[1]);
        }
        int a= graph.findStart();
        //  System.out.println("start at: "+a);
        //Collections.reverse(graph.Depth(a));
        //System.out.println(graph.Depth(a));
        // List=graph.Depth(a);
        //System.out.println(graph.Depth(a).toArray());
        //Collections.reverse(graph.Depth(a));
        aa= graph.Depth(a);
        // System.out.println(aa.get(6));
        // System.out.println("size: "+aa.size());
        //System.out.println(aa);
        for (int i = aa.size()-1; i>=0;i--){
            int [] array= new int [2];
            if (i>0){
                array[0]=aa.get(i);
                array[1]=aa.get(i-1);
                List.add(array);

            }
            else {}
        }
        //System.out.println(List);
        return List;
    }
    public static void main (String [] args)
    {
        ArrayList<int[]> t = new ArrayList<int[]>();
        int[] arr1 = {1,1};
        int[] arr2 = {3,1};
        int[] arr3 = {2,1};
        int[] arr4 = {1,3};
        int[] arr5 = {2,2};
        int[] arr6 = {1,2};
        int [] arr7=  {3,6};
        int [] arr8={6,6};
        t.add(arr1);
        t.add(arr2);
        t.add(arr3);
        t.add(arr4);
        t.add(arr5);
        t.add(arr6);
        t.add(arr7);
        t.add(arr8);
        System.out.println(Arrays.deepToString(solve (t).toArray()));
        // solve (t);
    }
}	
		
    /*test graph= new test (4);
        graph.addEdge(1,1);
        graph.addEdge(3,1);
        graph.addEdge(2,1);
        graph.addEdge(1,3);
        graph.addEdge(2,2);
        graph.addEdge(1,2);
        int a= graph.findStart();
       System.out.println(Arrays.deepToString(graph.Depth(a).toArray()));
       
       
       // graph.Depth(a);*/
    

    