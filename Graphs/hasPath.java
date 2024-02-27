import java.util.*;
public class hasPath
{ 
    //if disjoint graphs are their
    static class Edge
    {
        int src,dest,wt;
        Edge(int s,int d,int w)
        {
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    static void createGraph(ArrayList<Edge>graph[])
    {
        //Adjacency list 
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));//       1 - 3 
        graph[0].add(new Edge(0, 2, 1));//     /       \
                                        //   0      |    5 - 6
        graph[1].add(new Edge(1, 0, 1));//     \       /
        graph[1].add(new Edge(1, 3, 1));//      2 - 4 

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }
    public static boolean path(ArrayList<Edge>graph[],int src,int dest,boolean visited[])//O(v+e)
    {
        //dfs approach
        //case 1
        if(src==dest)
        return true;
        //case 2
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++)
        {
            Edge e=graph[src].get(i);
            if(!visited[e.dest] && path(graph, e.dest, dest, visited))
            return true;
        }
        //else
        return false;
    }
    public static void main(String[] args) 
    {
        int v=7;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        boolean visited[]=new boolean[v];
        System.out.println(path(graph, 0, 7, visited));
    }
}
