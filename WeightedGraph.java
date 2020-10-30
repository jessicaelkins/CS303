import java.util.*;
import java.io.*;

public class WeightedGraph
{
    static class Edge
    {
        int source;
        int destination;
        double weight;

        public Edge(int source, int destination, double weight)
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph
    {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices)
        {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];

            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++)
            {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, double weight)
        {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph()
        {
            for (int i = 0; i <vertices ; i++)
            {
                LinkedList<Edge> list = adjacencylist[i];

                for (int j = 0; j <list.size() ; j++)
                {
                    System.out.println( i + " - " + list.get(j).destination + " : " +  list.get(j).weight);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException
    {
		//initializing new graph with 2546 vertices
		Graph graph = new Graph(2547);

		//importing the file
		String fileName = "mediumDG.txt";
		String line = null;

		BufferedReader inputFile = new BufferedReader(new FileReader(fileName));

		LinkedList<String> v1List = new LinkedList<String>();
		LinkedList<String> v2List = new LinkedList<String>();
		LinkedList<String> wList = new LinkedList<String>();


		while((line = inputFile.readLine()) != null)
		{
			String[] input = line.split("\\s");
			input = line.trim().split("\\s+");
			v1List.add(input[0]);
			v2List.add(input[1]);
			wList.add(input[2]);
		}

		inputFile.close();

		//converting linked list to string array
		String[] v1Array = v1List.toArray(new String[0]);
		String[] v2Array = v2List.toArray(new String[0]);
		String[] wArray = wList.toArray(new String[0]);

		int[] v1 = new int[v1Array.length];
		int[] v2 = new int[v2Array.length];
		double[] w = new double[wArray.length];

		// converting arrays from string to integer
		for(int i = 0; i < v1Array.length; i++)
		{
			v1[i] = Integer.parseInt(v1Array[i]);
		}

		for(int i = 0; i < v2Array.length; i++)
		{
			v2[i] = Integer.parseInt(v2Array[i]);
		}

		for(int i = 0; i < wArray.length; i++)
		{
			w[i] = Double.parseDouble(wArray[i]);
		}

		for(int i = 0; i < v1.length; i++)
		{
			//adding all the vertices into the graph
			graph.addEdge(v1[i], v2[i], w[i]);
		}

		graph.printGraph();

	}

}

