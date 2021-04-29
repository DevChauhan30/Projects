import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.stream.AttributeSink;
import org.graphstream.stream.ElementSink;
import org.graphstream.stream.Sink;
import org.graphstream.stream.Source;
import org.graphstream.stream.rmi.RMISink;

public class GeneratorSource implements Source, Generator {

    private Graph localGraph;
    private RMISink remoteSink;
    
    public GeneratorSource() {
    }

    /**
     * open the source
     */
    public void begin() {
    }

    /**
     *
     * @return
     */
    public boolean nextEvents() {

        localGraph.nodeAdded("g", 1, "A");
        remoteSink.nodeAdded("g", 1, "A");

        localGraph.nodeAdded("g", 2, "B");
        remoteSink.nodeAdded("g", 2, "B");

        localGraph.edgeAdded("g", 3, "AB", "B", "A", false);
        remoteSink.edgeAdded("g", 3, "AB", "B", "A", false);

        localGraph.nodeAdded("g", 4, "C");
        remoteSink.nodeAdded("g", 4, "C");

        localGraph.edgeAdded("g", 5, "AC", "C", "A", true);
        remoteSink.edgeAdded("g", 5, "AC", "C", "A", true);

        return true;
    }

    /**
     * close the source
     */
    public void end() {
    }

    /**
     *
     * @return
     */
    public Graph getLocalGraph() {
        return localGraph;
    }

    /**
     *
     * @return
     */
    public RMISink getRemoteSink() {
        return remoteSink;
    }

    @Override
    public void addSink(Sink sink) {
        
        if (sink.getClass().getTypeName() == "org.graphstream.stream.rmi.RMISink"){
            remoteSink = (RMISink) sink;
        } else {
            localGraph = (Graph) sink;
        }
        
    }

    @Override
    public void removeSink(Sink sink) {
        if (sink.getClass().getTypeName() == "org.graphstream.stream.rmi.RMISink"){
            remoteSink = null;
        } else {
            localGraph = null;
        }
    }

    @Override
    public void addAttributeSink(AttributeSink attributeSink) {
        if (attributeSink.getClass().getTypeName() == "org.graphstream.stream.rmi.RMISink"){
            remoteSink = (RMISink) attributeSink;
        } else {
            localGraph = (Graph) attributeSink;
        }
    }

    @Override
    public void removeAttributeSink(AttributeSink attributeSink) {
        if (attributeSink.getClass().getTypeName() == "org.graphstream.stream.rmi.RMISink"){
            remoteSink = null;
        } else {
            localGraph = null;
        }
    }

    @Override
    public void addElementSink(ElementSink elementSink) {
        if (elementSink.getClass().getTypeName() == "org.graphstream.stream.rmi.RMISink"){
            remoteSink = (RMISink) elementSink;
        } else {
            localGraph = (Graph) elementSink;
        }
    }

    @Override
    public void removeElementSink(ElementSink elementSink) {
        if (elementSink.getClass().getTypeName() == "org.graphstream.stream.rmi.RMISink"){
            remoteSink = null;
        } else {
            localGraph = null;
        }
    }

    @Override
    public void clearElementSinks() {
        this.clearSinks();
    }

    @Override
    public void clearAttributeSinks() {
        this.clearSinks();
    }

    @Override
    public void clearSinks() {
        localGraph = null;
        remoteSink = null;
    }

}
