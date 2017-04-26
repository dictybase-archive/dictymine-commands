package org.dictybase.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.dictybase.validation.ValidateParameters;

@Parameters(commandDescription = "create a mine specific intermine properties file for target database")
public class TargetPropertyCommand {
    @Parameter(description = "intermine database host, default INTERMINE_TARGET_HOST", names = "--host", validateWith = ValidateParameters.class)
    public String host = System.getenv("INTERMINE_TARGET_HOST");

    @Parameter(names = {"-db", "--database"}, description = "intermine database, default INTERMINE_TARGET_DB", validateWith = ValidateParameters.class)
    public String database = System.getenv("INTERMINE_TARGET_DB");

    @Parameter(names = {"-u", "--user"}, description = "database user, default INTERMINE_TARGET_USER", validateWith = ValidateParameters.class)
    public String user = System.getenv("INTERMINE_TARGET_USER");

    @Parameter(names = {"-p", "--password"}, description = "database password, default from INTERMINE_TARGET_PASSWORD", validateWith = ValidateParameters.class)
    public String password = System.getenv("INTERMINE_TARGET_PASSWORD");

    @Parameter(names = "--port", description = "database port, default from INTERMINE_TARGET_PORT", validateWith = ValidateParameters.class)
    public String port = System.getenv("INTERMINE_TARGET_PORT");

    @Parameter(description = "intermine users database name, default from INTERMINE_TARGET_USERS_DB", names = {"-udb", "--users-database"}, validateWith = ValidateParameters.class)
    public String udatabase = System.getenv("INTERMINE_TARGET_USERS_DB");

    @Parameter(names = "--webapp-base", description = "the base path the intermine webapp,  default from INTERMINE_BASE_URL or http://localhost:8080")
    public String url = System.getenv("INTERMINE_BASE_URL");

    @Parameter(names = "--path", description = "url subpath or suffix(servlet context) where the webapp will be accessible, default is dictymine")
    public String path = "dictymine";

    @Parameter(names = {"-o", "--output"}, description = "Output file name, default goes to stdout")
    public String output;

    @Parameter(names = {"--help", "-h",}, help = true, validateWith = ValidateParameters.class)
    public boolean help;
}
