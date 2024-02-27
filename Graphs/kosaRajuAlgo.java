import java.util.*;
public class kosaRajuAlgo 
{
    static class Edge
    {
        int src,dest;
        public Edge(int s,int d)
        {
            this.src=s;
            this.dest=d;
        }
    }    
    public static void createGraph(ArrayList<Edge>graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    public static void topoSort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer>s)
    {
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest])
            {
                topoSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    //reverse DFS
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[])
    {
       vis[curr]=true; 
       System.out.print(curr+" ");
       for(int i=0;i<graph[curr].size();i++)
       {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest])
            {
                dfs(graph,e.dest,vis);
            }
       }
    }
    public static void kosaRaju(ArrayList<Edge>graph[],int v)
    {
        //3*O(V+E)
        //step1 -> topological sort
        Stack<Integer>s=new Stack<>();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(!vis[i])
            {
                topoSort(graph, i, vis, s);
            }
        }
        //step2 -> transpose graph
        ArrayList<Edge>transpose[]=new ArrayList[v];
        for(int i=0;i<transpose.length;i++)
        {
            //re-initializing
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<graph[i].size();j++)
            {
                //reversing edges
                Edge e=graph[i].get(j);//e.src->e.dest
                transpose[e.dest].add(new Edge(e.dest,e.src));//e.dest->e.src
            }
        }
        //step3 -> do DFS acc. to stack nodes on transpose graph
        while(!s.isEmpty())
        {
            int curr=s.pop();
            if(!vis[curr])
            {
                System.out.print("SCC->");
                dfs(transpose,curr,vis);//s.c.c.
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        kosaRaju(graph, v);
    }
}