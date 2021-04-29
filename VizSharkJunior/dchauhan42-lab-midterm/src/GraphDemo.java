import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class GraphDemo {

    private Graph graph;

    public GraphDemo(){
        System.setProperty("org.graphstream.ui", "javafx");

        graph = new MultiGraph("g");
        graph.setAttribute("ui.stylesheet", "url('file://graph.css')");


        Node A = graph.addNode("A");
        A.setAttribute("label", "A");
        Node B = graph.addNode("B");
        B.setAttribute("label", "B");
        Node C = graph.addNode("C");
        C.setAttribute("label", "C");
        Node D = graph.addNode("D");
        D.setAttribute("label", "D");
        Node E = graph.addNode("E");
        E.setAttribute("label", "E");

        Edge AB = graph.addEdge("AB", A, B, true);
        Edge BC = graph.addEdge("BC", B, C);
        Edge CE = graph.addEdge("CE", C, E);
        Edge AE = graph.addEdge("AE", A, E);
        Edge ED = graph.addEdge("ED", E, D);
        graph.display();
    }

    public static void main(String[] args){
        GraphDemo client = new GraphDemo();
    }
}
