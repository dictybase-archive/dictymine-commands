package org.dictybase.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.dictybase.validation.ValidateParameters;

@Parameters(commandDescription = "create a mine specific intermine properties file")
public class PropertyCommand {
    @Parameter(description = "intermine database host, default INTERMINE_SERVICE_HOST", names = "--host", validateWith = ValidateParameters.class)
    public String host = System.getenv("INTERMINE_SERVICE_HOST");

    @Parameter(names={"-db","--database"}, description = "intermine database, default INTERMINE_DB", validateWith = ValidateParameters.class)
    public String database = System.getenv("INTERMINE_DB");

    @Parameter(names = {"-u", "--user"}, description = "database user, default INTERMINE_USER", validateWith = ValidateParameters.class)
    public String user = System.getenv("INTERMINE_USER");

    @Parameter(names = {"-p","--password"}, description = "database password, default from INTERMINE_PASSWORD", validateWith = ValidateParameters.class)
    public String password = System.getenv("INTERMINE_PASSWORD");

    @Parameter(names = "--port", description = "database port, default from INTERMINE_PORT", validateWith = ValidateParameters.class)
    public String port = System.getenv("INTERMINE_PORT");

    @Parameter(description = "intermine items database name, default from INTERMINE_ITEMS_DB", names = {"-idb", "--items-database"}, validateWith = ValidateParameters.class)
    public String idatabase = System.getenv("INTERMINE_ITEMS_DB");

    @Parameter(description = "intermine users database name, default from INTERMINE_USERS_DB", names = {"-udb", "--users-database"}, validateWith = ValidateParameters.class)
    public String udatabase = System.getenv("INTERMINE_USERS_DB");

    @Parameter(names = "--webapp-url", description = "the public url in which the intermine webapp will be available, default from INTERMINE_WEBAPP_URL", validateWith = ValidateParameters.class)
    public String url = System.getenv("INTERMINE_WEBAPP_URL");

    @Parameter(names = {"-o", "--output"}, description = "Output file name, default goes to stdout")
    public String output;

    @Parameter(names = {"-sa", "--superuser"}, description = "Superuser account for dictymine")
    public String superuser = System.getenv("DICTYMINE_SUPERUSER");

    @Parameter(names = {"-sp", "--superuser-pass"}, description = "Superuser password")
    public String superpass = System.getenv("DICTYMINE_SUPER_PASS");

    @Parameter(names = {"--help", "-h",}, help = true, validateWith = ValidateParameters.class)
    public boolean help;
}
