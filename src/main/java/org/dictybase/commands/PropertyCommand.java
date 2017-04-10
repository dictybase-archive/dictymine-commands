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

    @Parameter(names={"--tomcat-host", "-th"}, description = "tomcat host, default from TOMCAT_SERVICE_HOST", validateWith = ValidateParameters.class)
    public String thost = System.getenv("TOMCAT_SERVICE_HOST");

    @Parameter(names={"--tomcat-port", "-tport"}, description = "tomcat port, default from TOMCAT_SERVICE_PORT", validateWith = ValidateParameters.class)
    public String tport = System.getenv("TOMACAT_SERVICE_PORT");

    @Parameter(names={"--path", "--webapp-path"}, description = "the patch suffix for the webapp access, default from INTERMINE_WEBAPP_PATH", validateWith = ValidateParameters.class)
    public String path = System.getenv("INTERMINE_WEBAPP_PATH");

    @Parameter(names = "--webapp-url", description = "the public url in which the intermine webapp will be available, default from INTERMINE_WEBAPP_URL", validateWith = ValidateParameters.class)
    public String url = System.getenv("INTERMINE_WEBAPP_URL");

    @Parameter(names = {"--tomcat-manager", "-tm"}, description = "tomcat manager user name, default from TOMCAT_MANAGER", validateWith = ValidateParameters.class)
    public String manager = System.getenv("TOMCAT_MANAGER");

    @Parameter(names = {"--tomcat-password", "-tp"}, description = "tomcat manager password, default from TOMCAT_PASSWORD", validateWith = ValidateParameters.class)
    public String tpassword = System.getenv("TOMCAT_PASSWORD");

    @Parameter(names={"-o","--out", "--output"}, description = "Output file name, default goes to stdout")
    public String output;

    @Parameter(names="--help", help = true, validateWith = ValidateParameters.class)
    public boolean help;
}
