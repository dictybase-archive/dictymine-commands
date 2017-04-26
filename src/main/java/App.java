/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.dictybase.commands.BuildPropertyCommand;
import org.dictybase.commands.TargetPropertyCommand;
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

    private OutputStream getWriter(String output) throws UnsupportedOperationException, SecurityException, IOException {
        if (output != null && output.trim().length() != 0) try {
            Path path = Paths.get(output).getParent();
            if (Files.notExists(path, NOFOLLOW_LINKS)) try {
                Files.createDirectory(path);
            } catch (UnsupportedOperationException | IOException | SecurityException ex) {
                LOGGER.log(Level.SEVERE, ex.toString(), ex);
                throw ex;
            }
            return new FileOutputStream(output);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        return new FileOutputStream(FileDescriptor.out);
    }

    public static void main(String... args) throws IOException {
        InputStream in = App.class.getResourceAsStream("intermine.properties");
        Properties config = new Properties();
        try {
            config.load(in);
            App app = new App();
            JCommander jc = new JCommander(app);
            BuildPropertyCommand bc = new BuildPropertyCommand();
            TargetPropertyCommand tc = new TargetPropertyCommand();
            jc.addCommand("createbuildproperties", bc, "buildprops");
            jc.addCommand("createtargetproperties", tc, "targetprops");
            jc.parse(args);
            if (app.help) {
                jc.usage();
                return;
            }
            String cmd = jc.getParsedCommand();
            switch (cmd) {
                case "createbuildproperties":
                case "buildprops":
                    if (bc.help) {
                        jc.usage();
                        return;
                    }
                    PropertiesWriter.writeBuildIntermineProperties(app.getWriter(bc.output), config, bc);
                    break;
                case "createtargetproperties":
                case "targetprops":
                    if (tc.help) {
                        jc.usage();
                        return;
                    }
                    PropertiesWriter.writeTargetIntermineProperties(app.getWriter(tc.output), config, tc);
                    break;
                default:
                    LOGGER.log(Level.WARNING, "wrong command " + cmd);
                    break;
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
    }
}
