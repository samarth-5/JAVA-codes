import java.util.*;
public class cycleDetection 
{
    static class Edge
    {
        int src,dest;
        Edge(int s,int d)
        {
            this.src=s;
            this.dest=d;
        }
    }    
    static void createGraphUG(ArrayList<Edge>graph[])
    {
        //Adjacency list 
        //         0 - 3
        //       / |   |
        //      1  |   4
        //       \ |
        //         2
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
                                              
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2)); 

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
    public static boolean detectCycleUG(ArrayList<Edge>graph[])//undirected graph
    {
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!visited[i])
            {
                if(detectCycleUtilUG(graph, visited, i, -1))
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycleUtilUG(ArrayList<Edge>graph[],boolean visited[],int curr,int par)
    {//O(v+e)
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);
            //case 1-neighbour not visited
            if(!visited[e.dest])
            {
                if(detectCycleUtilUG(graph,visited,e.dest,curr))
                return true;
            }
            //case 2-visted neighbour=true & neighbour not= par
            else if(visited[e.dest] && e.dest != par)
            return true; 
            //case 3-visted neighbour=true & neighbour = par
            //then continue;
        }
        return false;
    }
    public static void createGraphDG(ArrayList<Edge>graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }
    public static boolean detectCycleDG(ArrayList<Edge>graph[])
    {
        boolean visited[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!visited[i])
            {
                if(detectCycleUtilDG(graph, i, visited,stack))
                return true;
            }
        }
        return false;
    } 
    public static boolean detectCycleUtilDG(ArrayList<Edge>graph[],int curr,boolean visited[],boolean stack[])
    {
        visited[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);
            if(stack[e.dest])
            {
                return true;
            }
            if(!visited[e.dest])
            {
                if(detectCycleUtilDG(graph,e.dest,visited,stack))
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        //int v=5;
        int v=4;
        ArrayList<Edge>graph[]=new ArrayList[v];
        //createGraphUG(graph);
        createGraphDG(graph);
        //System.out.println(detectCycleUG(graph));
        System.out.println(detectCycleDG(graph));
    }
}