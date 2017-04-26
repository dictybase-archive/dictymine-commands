package org.dictybase.properties;

import org.dictybase.commands.BuildPropertyCommand;
import org.dictybase.commands.TargetPropertyCommand;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropertiesWriter {
    private static final Logger LOGGER = Logger.getLogger(PropertiesWriter.class.getSimpleName());

    public static void writeTargetIntermineProperties(OutputStream out, Properties config, TargetPropertyCommand tc) {
        Enumeration en = config.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            switch (key) {
                /*production database configuration */
                case "db.production.datasource.serverName":
                    config.setProperty("db.production.datasource.serverName", tc.host);
                    break;
                case "db.production.datasource.databaseName":
                    config.setProperty("db.production.datasource.databaseName", tc.database);
                    break;
                case "db.production.datasource.user":
                    config.setProperty("db.production.datasource.user", tc.user);
                    break;
                case "db.production.datasource.password":
                    config.setProperty("db.production.datasource.password", tc.password);
                    break;
                case "db.production.datasource.port":
                    config.setProperty("db.production.datasource.port", tc.port);
                    break;

                /*users database configuration */
                case "db.userprofile-production.datasource.serverName":
                    config.setProperty("db.userprofile-production.datasource.serverName", tc.host);
                    break;
                case "db.userprofile-production.datasource.databaseName":
                    config.setProperty("db.userprofile-production.datasource.databaseName", tc.udatabase);
                    break;
                case "db.userprofile-production.datasource.user":
                    config.setProperty("db.userprofile-production.datasource.user", tc.user);
                    break;
                case "db.userprofile-production.datasource.password":
                    config.setProperty("db.userprofile-production.datasource.password", tc.password);
                    break;
                case "db.userprofile-production.datasource.port":
                    config.setProperty("db.userprofile-production.datasource.port", tc.port);
                    break;

                /*webapp configuration */
                case "webapp.baseurl":
                    if (tc.url == null || tc.url.trim().isEmpty()) {
                        config.setProperty("webapp.baseurl", "http://localhost:8080");
                    } else {
                        config.setProperty("webapp.baseurl", tc.url);
                    }
                    break;
                case "webapp.path":
                    config.setProperty("webapp.path", tc.path);
                    break;
                default:
                    break;
            }
        }

    }

    public static void writeBuildIntermineProperties(OutputStream out, Properties config, BuildPropertyCommand pc) {
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
                case "db.common-tgt-items.datasource.serverName":
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
                case "superuser.account":
                    config.setProperty("superuser.account", pc.superuser);
                    break;
                case "superuser.initialPassword":
                    config.setProperty("superuser.initialPassword", pc.superpass);
                default:
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
