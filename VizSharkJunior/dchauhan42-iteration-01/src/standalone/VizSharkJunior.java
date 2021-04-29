package standalone;

import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VizSharkJunior {

    private Graph graph;
    private CSVJunior csv;

    public VizSharkJunior(String longcapture) {
        // Set the program to run using javafx GUI system
        System.setProperty("org.graphstream.ui", "javafx");

        // Create a new multigraph
        this.graph = new MultiGraph("g");

        // Create a stylesheet for nicely displaying the graph nodes and edges
        this.graph.setAttribute("ui.stylesheet", "url('file://graph.css')");

        // Configure the graph
        this.csv = new CSVJunior(graph, longcapture);
        this.graph.display();

        // Begin reading and displaying data on the graph
        this.csv.begin();
        this.csv.nextEvents();
        this.csv.end();

        demo(longcapture);
    }

    public void demo(String longcapture){

        File file = new File(longcapture);
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                TSharkData data = new TSharkData(line);
                System.out.println(data);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String longcapture = "data/longcapture.csv";
        VizSharkJunior client = new VizSharkJunior(longcapture);
    }
}
