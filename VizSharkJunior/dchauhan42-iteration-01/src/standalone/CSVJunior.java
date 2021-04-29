package standalone;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.stream.AttributeSink;
import org.graphstream.stream.ElementSink;
import org.graphstream.stream.Sink;
import standalone.TSharkData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Basic CSV Generator
 */
public class CSVJunior implements Generator {

    private Graph graph;
    private Scanner scan;
    private String filename;


    /**
     * Initializes the class
     * @param graph2 Used to display network data
     * @param filename2 Filename for the CSV input data
     */
    public CSVJunior(Graph graph2, String filename2){
        filename = filename2;
        graph = graph2;
        
    }

    /**
     * instantiates the CSV processing by opening the file and instantiating the Scanner object 
     * to be used by the nextEvents method
     */
    @Override
    public void begin() {
        File file = new File(filename);
        try {
            scan= new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * processes the data by using the scanner object (e.g., while (scan.hasNext())). 
     * @return returns true if at least one entity (a Node or an Edge) is read and added to a graph.
     */
    @Override
    public boolean nextEvents() {

        boolean added_entity = false;

        while(scan.hasNext()) {
            TSharkData data = new TSharkData(scan.nextLine());

            String to = data.getSrcIP();
            String from = data.getDstIP();
            String edge = from + ":" + to;

            Edge e = graph.getEdge(edge);
            if(e == null){
                Node n1 = graph.getNode(to);
                if(n1 == null){
                    Node dstIP = graph.addNode(to);
                    dstIP.setAttribute("label", data.getDstIP());
                }
                Node n2 = graph.getNode(from);
                if(n2 == null){
                    Node srcIP = graph.addNode(from);
                    srcIP.setAttribute("label", data.getSrcIP());
                }

                e = graph.addEdge(edge, from, to, true);
                e.setAttribute("label", 1);

                added_entity = true;
            } else {
                Integer weight = (Integer) e.getAttribute("label");
                e.setAttribute("label", weight + 1);
            }

        }

        return added_entity;
    }

    /**
     * ends processing by closing the Scanner object by calling the close() method
     */
    @Override
    public void end() {

        scan.close();
    }

    @Override
    public void addSink(Sink sink) {
        this.graph = (Graph) sink;
    }

    @Override
    public void removeSink(Sink sink) {
        this.graph = null;
    }

    @Override
    public void addAttributeSink(AttributeSink attributeSink) {
        this.graph = (Graph) attributeSink;
    }

    @Override
    public void removeAttributeSink(AttributeSink attributeSink) {
        this.graph = null;
    }

    @Override
    public void addElementSink(ElementSink elementSink) {
        this.graph = (Graph) elementSink;
    }

    @Override
    public void removeElementSink(ElementSink elementSink) {
        this.graph = null;
    }

    @Override
    public void clearElementSinks() {
        this.graph = null;
    }

    @Override
    public void clearAttributeSinks() {
        this.graph = null;
    }

    @Override
    public void clearSinks() {
        this.graph = null;
    }
}
