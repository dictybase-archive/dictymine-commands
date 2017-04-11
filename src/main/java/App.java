/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.dictybase.commands.PropertyCommand;
import org.dictybase.properties.PropertiesWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;


public class App {
    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;

    private static final Logger LOGGER = Logger.getLogger(App.class.getSimpleName());

    private OutputStream getWriter(PropertyCommand pc) throws UnsupportedOperationException, SecurityException, IOException {
        if (pc.output != null && pc.output.trim().length() != 0) try {
            Path path = Paths.get(pc.output).getParent();
            if (Files.notExists(path, NOFOLLOW_LINKS)) try {
                Files.createDirectory(path);
            } catch (UnsupportedOperationException | IOException | SecurityException ex) {
                LOGGER.log(Level.SEVERE, ex.toString(), ex);
                throw ex;
            }
            return new FileOutputStream(pc.output);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        return new FileOutputStream(FileDescriptor.out);
    }

    public static void main(String... args) {
        InputStream in = App.class.getResourceAsStream("intermine.properties");
        Properties config = new Properties();
        try {
            config.load(in);
            App app = new App();
            JCommander jc = new JCommander(app);
            PropertyCommand pc = new PropertyCommand();
            jc.addCommand("createproperties", pc, "createprops");
            jc.parse(args);
            if (app.help) {
                jc.usage();
                return;
            }
            switch (jc.getParsedCommand()) {
                case "createproperties":
                    if (pc.help) {
                        jc.usage();
                        return;
                    }
                    PropertiesWriter.writeIntermineProperties(app.getWriter(pc), config, pc);
                default:
                    System.err.println("wrong command");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
