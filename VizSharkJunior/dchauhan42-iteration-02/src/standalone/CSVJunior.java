package standalone;

import org.graphstream.graph.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVJunior extends standalone.GeneratorJunior {

    private String filename;

    public CSVJunior(Graph graph, String fn) {
        super(graph);
        this.filename = fn;
    }

    @Override
    public void begin() {
        File file = new File(filename);
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }
}

