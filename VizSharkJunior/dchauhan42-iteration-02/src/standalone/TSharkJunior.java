package standalone;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.stream.AttributeSink;
import org.graphstream.stream.ElementSink;
import org.graphstream.stream.Sink;
import standalone.TSharkData;

import java.io.*;
import java.util.Scanner;

public class TSharkJunior extends standalone.GeneratorJunior {

    private int netInterface;

    public TSharkJunior(Graph graph, int netI) {
        super(graph);
        this.netInterface = netI;
    }
    public void begin() {
        String cmd = "tshark -T fields -e frame.number -e frame.time_relative -e _ws.col.Protocol -e ip.proto -e ip.src -e ip.dst -e tcp.srcport -e tcp.dstport -e udp.srcport -e udp.dstport -E header=n -E separator=, -E quote=d -E occurrence=f -i " + this.netInterface;

        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()), 512);
            this.setScan(new Scanner(output));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
