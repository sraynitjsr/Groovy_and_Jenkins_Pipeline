import java.util.logging.*;

public class HelloWorld {
    private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());  
    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello World");
    }
}
