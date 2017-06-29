
package courierMap;
/**
 * Implementation of directed, weighed graph using a HashMap to represent adjacency list.
 *
 * @author marcinkossakowski on 9/24/14.
 */

// For file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WeighedDigraph {
    private HashMap<Integer, ArrayList<WeighedDigraphEdge>> adj = new HashMap(); // adjacency-list

    public WeighedDigraph() {}

    /**
     * Instantiate graph from file with data
     * @param file
     * @throws IOException
     */
    public WeighedDigraph(String file) throws IOException {
        @SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s");

            if (parts.length == 3) {
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);
                double weight = Double.parseDouble(parts[2]);

                addEdge(new WeighedDigraphEdge(from, to, weight));
            }
        }
    }

    /**
     * @param vertex
     * @return list of edges vertex is connected to.
     */
    public ArrayList<WeighedDigraphEdge> edgesOf(int vertex) {
        return adj.get(vertex);
    }

    /**
     * @return list of all edges in the graph.
     */
    public ArrayList<WeighedDigraphEdge> edges() {
        ArrayList list = new ArrayList<WeighedDigraphEdge>();

        for (int from : adj.keySet()) {
            ArrayList<WeighedDigraphEdge> currentEdges = adj.get(from);
            for (WeighedDigraphEdge e : currentEdges) {
                list.add(e);
            }
        }
        return list;
    }

    /**
     * @return iterable of all vertices in the graph.
     */
    public Iterable<Integer> vertices() {
        HashSet set = new HashSet();
        for (WeighedDigraphEdge edge : edges()) {
            set.add(edge.from());
            set.add(edge.to());
        }

        return set;
    }

    /**
     * @return size of adjacency list
     */
    public int size() { return adj.size(); }

    

    /**
     * Add new edge to the system.
     * @param newEdge
     */
    public void addEdge(WeighedDigraphEdge newEdge) {
        // create empty connection set
        if (!adj.containsKey(newEdge.from()))
            adj.put(newEdge.from(), new ArrayList<WeighedDigraphEdge>());

        ArrayList<WeighedDigraphEdge> currentEdges = adj.get(newEdge.from());

        /* Check if edge already exists,
         * if it is, replace it with new one assuming it needs to be updated */
        boolean edgeExists = false;
        for (int i = 0; i < currentEdges.size(); i++) {
            if (currentEdges.get(i).to() == newEdge.to()) {
                currentEdges.set(i, newEdge);
                edgeExists = true;
                break;
            }
        }

        if (!edgeExists)
            currentEdges.add(newEdge);

        adj.put(newEdge.from(), currentEdges);
    }

    /**
     * Graph Tests
     * @param args
     */
    public static void main(String args[]) {
        WeighedDigraph graph = new WeighedDigraph();

        WeighedDigraphEdge edge1 = new WeighedDigraphEdge(1, 2, 2.0);
        WeighedDigraphEdge edge2 = new WeighedDigraphEdge(2, 1, 2.0);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        System.out.print(graph);
    }
    
    /**
     * @return string representation of digraph
     */
    public String toString() {
        String out = "";
        for (int from : adj.keySet()) {
            ArrayList<WeighedDigraphEdge> currentEdges = adj.get(from);
            out += from + " -> ";

            if (currentEdges.size() == 0)
                out += "-,";

            for (WeighedDigraphEdge edge : currentEdges)
                out += edge.to() + " @ " + edge.weight() + ", ";

            out += "\n";
        }

        return out;
    }

	public double findWeight(int i, int j, ArrayList<Integer> path) {
		double value = 0.0;
		for(int pather=0; pather<path.size()-1; pather++) {
			ArrayList<WeighedDigraphEdge> egraph = adj.get(path.get(pather));
			for(WeighedDigraphEdge weight : egraph) {
				if(weight.to() == path.get(pather+1)) {
					value = value+weight.weight();
				}
			}
		}
		return value;
	}
}
