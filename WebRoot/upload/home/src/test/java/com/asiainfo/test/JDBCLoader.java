/*
 * Copyright (c) 2009 Kongzhong.com
 * Last Modified By $Author: wangzg $ @ $Date: 2009/04/21 06:27:53 $
 * Current CVS Version Number: $Revision: 1.1 $
 */
package com.asiainfo.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author wzg
 * @version $Id: JDBCLoader.java,v 1.5 2009/04/16 04:05:19
 */
public class JDBCLoader {

    private static final Logger logger = Logger.getLogger(JDBCLoader.class);
    private final Connection connection;

    public JDBCLoader(Connection connection) {
        this.connection = connection;
    }

    /**
     * 
     * @param line
     * @return
     */
    private static String filterSql(String line) {
        return line.replaceAll(";", "");
    }

    /**
     * The sql file to load, relative to the classpath
     * 
     * @param sqlfile
     */
    public void run(String sqlfile) {
        BufferedReader reader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(this.getClass().getResource(sqlfile).getFile());
            reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                if (!StringUtils.isEmpty(line)) {
                    logger.debug("JDBCLoader: [Running] " + line);
                    this.runStatement(filterSql(line));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }
            } catch (SQLException e1) {
                // e1.printStackTrace();
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e) {
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private void runStatement(String sql) throws SQLException {
        Statement s = this.connection.createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public static void main(String... args) {
        String line = "test\rsdfdf\nsddf";
        System.out.println(line);
        System.out.println(filterSql(line));

    }

}
