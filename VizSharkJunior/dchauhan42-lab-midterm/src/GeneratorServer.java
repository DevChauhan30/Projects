import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.rmi.RMISink;

import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class GeneratorServer {

    public static void main(String[] args){

        RMISink sink = null;
        try {
            // Print the developer's identity
            System.err.println(Identity.identity);

            // Set up the network first

            String URL = "127.0.0.1";

            for (int i = 0; i < args.length; i++){
                // -c address
                // ip address of the client that will display the graph
                // If running both from the local machine, you may ignore this parameter
                if (args[i].equals("-c")){
                    URL = args[i+1];
                }
            }
            Registry reg = LocateRegistry.createRegistry(1098);

            // Set up RMI by checking the local ip address
            final DatagramSocket socket = new DatagramSocket();
            socket.connect(InetAddress.getByName(URL), 1099);
            String localhost = socket.getLocalAddress().getHostAddress();

            System.setProperty("java.rmi.server.hostname", localhost);

            // Create the graph (sink - e.g., the destination for the graph information) and
            // the local graph model
            sink = new RMISink();
            sink.register("//" + URL + "/vizshark_client");

            Graph g = new MultiGraph("g");

            // Create the generator and add BOTH a local graph
            // and the remote sink to the Generator. Adding both
            // will ensure the data is sent to the viz client
            GeneratorSource gen = new SourceDemo();
            gen.addSink(sink);
            gen.addSink(g);

            gen.begin();

            if (gen.nextEvents()) {
                Thread.sleep(250);
            }

            gen.end();

            sink.unregister("//" + URL + "/vizshark_client");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException iob) {
            iob.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
