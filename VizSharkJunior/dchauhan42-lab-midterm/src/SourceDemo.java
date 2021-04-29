import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomEuclideanGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.stream.Sink;
import org.graphstream.stream.rmi.RMISink;

/**
 * SourceDemo wraps a generator object and generates 500 nodes. This class is a
 * model for the methods to be implemented for the project
 */
public class SourceDemo extends GeneratorSource {

    private Generator gen;

    public SourceDemo(){
       gen = new RandomEuclideanGenerator();
    }

    @Override
    public void begin(){
        gen.begin();
    }

    @Override
    public void end(){
        gen.end();
    }

    @Override
    public boolean nextEvents(){
        for (int i = 0; i < 200; i++){
            gen.nextEvents();
        }
        return true;
    }

    /**
     * addSink will add the sink to the GeneratorSource superclass attributes
     * and will add the remote sink to the wrapped object.
     * @param sink
     */
    @Override
    public void addSink(Sink sink) {
        super.addSink(sink);
        gen.addSink(this.getRemoteSink());
    }

}
