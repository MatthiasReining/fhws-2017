package com.fhws.javaee.business.log.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author matthias
 */
public class ORMapper {

    public void save(DataSource ds, Object o) {

        String tableName = o.getClass().getSimpleName();

        System.out.println(tableName);

        String sql = "SELECT * FROM " + tableName;

        Map<String, Object> columnMap = new LinkedHashMap<>();

        try {
            ResultSet rs = ds.getConnection().createStatement().executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();

            for (int i = 0; i < columnCount; i++) {
                String columnName = rsmd.getColumnName(i + 1);

                int columnType = rsmd.getColumnType(i + 1);
                String columnTypeName = rsmd.getColumnTypeName(i + 1);

                System.out.println(columnName + " (" + columnType + " : " + columnTypeName + ")");

                String propertyName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1).toLowerCase();
                String methodName = "get" + propertyName;

                Method m = o.getClass().getMethod(methodName, new Class[0]);
                Object dataValue = m.invoke(o, new Object[0]);

                System.out.println(columnName + " : " + dataValue);
                columnMap.put(columnName, dataValue);

            }

            String sqlInsert = "INSERT INTO " + tableName + "( ";
            for (Map.Entry<String, Object> e : columnMap.entrySet()) {
                sqlInsert += e.getKey() + ", ";
            }
            sqlInsert = sqlInsert.substring(0, sqlInsert.length() - 2);

            sqlInsert += ") VALUES (";
            for (Map.Entry<String, Object> e : columnMap.entrySet()) {
                sqlInsert += "?, ";
            }
            sqlInsert = sqlInsert.substring(0, sqlInsert.length() - 2);
            sqlInsert += ")";
            
            PreparedStatement pstmt = ds.getConnection().prepareStatement(sqlInsert);
            
            System.out.println("prepared statement: " + sqlInsert);
            
            int count = 0;
            for (Map.Entry<String, Object> e : columnMap.entrySet()) {
                count++;
                pstmt.setObject(count, e.getValue());
            }
            
            pstmt.executeUpdate();

            
        } catch (Exception ex) {
            Logger.getLogger(ORMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
