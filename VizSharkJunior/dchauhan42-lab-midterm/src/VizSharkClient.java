import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.rmi.RMISource;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class VizSharkClient {

    RMISource source;
    Graph graph;

    public VizSharkClient() {
        try {
            // Print the developer's identity
            System.err.println(Identity.identity);

            System.setProperty("org.graphstream.ui", "javafx");
            Registry reg = LocateRegistry.createRegistry(1099);
            source = new RMISource("vizshark_client");
            graph = new MultiGraph("g");
            source.addSink(graph);
            graph.display();
        } catch (RemoteException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // Already started
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VizSharkClient client = new VizSharkClient();
    }
}
