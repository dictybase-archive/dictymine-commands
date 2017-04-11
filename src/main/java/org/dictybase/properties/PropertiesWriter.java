package org.dictybase.properties;

import org.dictybase.commands.PropertyCommand;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by cybersiddhu on 4/9/17.
 */
public class PropertiesWriter {
    private static final Logger LOGGER = Logger.getLogger(PropertiesWriter.class.getSimpleName());

    public static void writeIntermineProperties(OutputStream out, Properties config, PropertyCommand pc) {
        Enumeration en = config.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            switch (key) {
                /*production database configuration */
                case "db.production.datasource.serverName":
                    config.setProperty("db.production.datasource.serverName", pc.host);
                case "db.production.datasource.databaseName":
                    config.setProperty("db.production.datasource.databaseName", pc.database);
                case "db.production.datasource.user":
                    config.setProperty("db.production.datasource.user", pc.user);
                case "db.production.datasource.password":
                    config.setProperty("db.production.datasource.password", pc.password);
                case "db.production.datasource.port":
                    config.setProperty("config.production.datasource.port", pc.port);

                /*items temporary database configuration */
                case "db.common-tg-items.datasource.serverName":
                    config.setProperty("config.common-tgt-items.datasource.serverName", pc.host);
                case "db.common-tgt-items.datasource.databaseName":
                    config.setProperty("db.common-tgt-items.datasource.databaseName", pc.idatabase);
                case "db.common-tgt-items.datasource.user":
                    config.setProperty("db.common-tgt-items.datasource.user", pc.user);
                case "db.common-tgt-items.datasource.password":
                    config.setProperty("db.common-tgt-items.datasource.password", pc.password);
                case "db.common-tgt-items.datasource.port":
                    config.setProperty("db.common-tgt-items.datasource.port", pc.port);

                /*users database configuration */
                case "db.userprofile-production.datasource.serverName":
                    config.setProperty("db.userprofile-production.datasource.serverName", pc.host);
                case "db.userprofile-production.datasource.databaseName":
                    config.setProperty("db.userprofile-production.datasource.databaseName", pc.udatabase);
                case "db.userprofile-production.datasource.user":
                    config.setProperty("db.userprofile-production.datasource.user", pc.user);
                case "db.userprofile-production.datasource.password":
                    config.setProperty("db.userprofile-production.datasource.password", pc.password);
                case "db.userprofile-production.datasource.port":
                    config.setProperty("config.userprofile-production.datasource.port", pc.port);

                /*webapp configuration */
                case "webapp.deploy.url":
                    config.setProperty("webapp.deploy.url", "http://" + pc.thost + ":" + pc.tport);
                case "webapp.deploy.path":
                    config.setProperty("config.deploy.path", pc.path);
                case "webapp.manager":
                    config.setProperty("webapp.manager", pc.manager);
                case "webapp.password":
                    config.setProperty("webapp.password", pc.tpassword);
                case "webapp.baseurl":
                    config.setProperty("webapp.deploy.url", pc.url);

                default:
                    config.setProperty(key, config.getProperty(key));
            }
        }
        try {
            config.store(out, "generated intermine properties");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,e.toString(),e);
            e.printStackTrace();
        }
    }
}
