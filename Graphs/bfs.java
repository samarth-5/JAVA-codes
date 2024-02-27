import java.util.*;
class bfs
{
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
    public static void bfsearch(ArrayList<Edge>graph[])
    {
        boolean visited[]=new boolean[graph.length]; 
        for(int i=0;i<graph.length;i++)
        {
            if(!visited[i])
            {
                bfsearchUtil(graph, visited);//For disjoint graphs
            }
        }       
    }
    public static void bfsearchUtil(ArrayList<Edge>graph[],boolean visited[])//O(v+e)
    {
        Queue<Integer>q=new LinkedList<>();
        q.add(0);//source=0
        while(!q.isEmpty())
        {
            int curr=q.remove();
            if(!visited[curr])//if current is not visited then visit current
            {
                System.out.print(curr+" ");
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++)
                {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void dfsearch(ArrayList<Edge>graph[])
    {
        boolean visited[]=new boolean[graph.length]; 
        for(int i=0;i<graph.length;i++)
        {
            if(!visited[i])
            {
                dfsearchUtil(graph,i,visited);//For disjoint graphs
            }
        }  
    }
    public static void dfsearchUtil(ArrayList<Edge>graph[],int curr,boolean visited[])//O(v+e)
    {
        //visit              
        System.out.print(curr+" ");
        visited[curr]=true;  
        //now call for its neighbours
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);
            if(!visited[e.dest])
            {
                dfsearchUtil(graph, e.dest, visited);
            }
        }
    }
    public static void main(String[] args) 
    {
        int v=7;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.println("Breadth First Search:");
        bfsearch(graph);
        System.out.println("Depth First Search:");
        dfsearch(graph);
    }
}