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
                    break;
                case "db.production.datasource.databaseName":
                    config.setProperty("db.production.datasource.databaseName", pc.database);
                    break;
                case "db.production.datasource.user":
                    config.setProperty("db.production.datasource.user", pc.user);
                    break;
                case "db.production.datasource.password":
                    config.setProperty("db.production.datasource.password", pc.password);
                    break;
                case "db.production.datasource.port":
                    config.setProperty("db.production.datasource.port", pc.port);
                    break;

                /*items temporary database configuration */
                case "db.common-tg-items.datasource.serverName":
                    config.setProperty("db.common-tgt-items.datasource.serverName", pc.host);
                    break;
                case "db.common-tgt-items.datasource.databaseName":
                    config.setProperty("db.common-tgt-items.datasource.databaseName", pc.idatabase);
                    break;
                case "db.common-tgt-items.datasource.user":
                    config.setProperty("db.common-tgt-items.datasource.user", pc.user);
                    break;
                case "db.common-tgt-items.datasource.password":
                    config.setProperty("db.common-tgt-items.datasource.password", pc.password);
                    break;
                case "db.common-tgt-items.datasource.port":
                    config.setProperty("db.common-tgt-items.datasource.port", pc.port);
                    break;

                /*users database configuration */
                case "db.userprofile-production.datasource.serverName":
                    config.setProperty("db.userprofile-production.datasource.serverName", pc.host);
                    break;
                case "db.userprofile-production.datasource.databaseName":
                    config.setProperty("db.userprofile-production.datasource.databaseName", pc.udatabase);
                    break;
                case "db.userprofile-production.datasource.user":
                    config.setProperty("db.userprofile-production.datasource.user", pc.user);
                    break;
                case "db.userprofile-production.datasource.password":
                    config.setProperty("db.userprofile-production.datasource.password", pc.password);
                    break;
                case "db.userprofile-production.datasource.port":
                    config.setProperty("db.userprofile-production.datasource.port", pc.port);
                    break;

                /*webapp configuration */
                case "webapp.deploy.url":
                    config.setProperty("webapp.deploy.url", "http://" + pc.thost + ":" + pc.tport);
                    break;
                case "webapp.deploy.path":
                    config.setProperty("webapp.deploy.path", pc.path);
                    break;
                case "webapp.manager":
                    config.setProperty("webapp.manager", pc.manager);
                    break;
                case "webapp.password":
                    config.setProperty("webapp.password", pc.tpassword);
                    break;
                case "webapp.baseurl":
                    config.setProperty("webapp.deploy.url", pc.url);
                    break;

                default:
                    config.setProperty(key, config.getProperty(key));
                    break;
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
