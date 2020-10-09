package top.fallenangel.util;

import org.intellij.lang.annotations.Language;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

public class DBUtil {
    private static Connection conn = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    /**
     * 获取数据库连接
     *
     * @param resourceBundleName 配置文件名
     */
    public static void connection(String resourceBundleName, ClassLoader loader) {
        try {
            InputStream resourceStream = loader.getResourceAsStream(resourceBundleName);
            assert resourceStream != null;
            ResourceBundle resourceBundle = new PropertyResourceBundle(resourceStream);
            Class.forName(resourceBundle.getString("driver"));
            conn = DriverManager.getConnection(resourceBundle.getString("url"), resourceBundle.getString("username"), resourceBundle.getString("password"));
            pst = conn.prepareStatement("SELECT DEPTNO, DNAME, LOC FROM dept");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行DML语句
     *
     * @param sql    SQL语句
     * @param params 参数
     * @return 影响行数
     */
    public static int update(@Language("MySQL") String sql, Object... params) {
        int result = 0;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 执行DML语句
     *
     * @param sql    SQL语句
     * @param params 数组形式的参数
     * @return 影响行数
     */
    public static int update(@Language("MySQL") String sql, Object params) {
        int result = 0;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < Array.getLength(params); i++) {
                pst.setObject(i + 1, Array.get(params, i));
            }
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询符合条件的数据集合
     *
     * @param clazz  数据行对象的Class对象
     * @param sql    SQL语句
     * @param params SQL语句参数，可不填
     * @return 查询结果集
     */
    public static <T> List<T> query(Class<T> clazz, @Language("MySQL") String sql, Object... params) {
        List<T> tList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                Constructor<T> constructor = clazz.getConstructor();
                T t = constructor.newInstance();
                extractDataFromResult(t);
                tList.add(t);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return tList;
    }

    public static List<Map<String, Object>> query(@Language("MySQL") String sql, Object... params) {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                ResultSetMetaData rowHeader = rs.getMetaData();
                for (int i = 1; i <= rowHeader.getColumnCount(); i++) {
                    row.put(rowHeader.getColumnName(i), rs.getObject(i));
                }
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 查询单条记录
     *
     * @param clazz  数据行对象的Class对象
     * @param sql    SQL语句
     * @param params SQL语句的参数
     * @return 查询结果对象。若查找失败，返回null
     */
    public static <T> T querySingleRecord(Class<T> clazz, @Language("MySQL") String sql, Object... params) {
        T t = null;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();
            if (rs.next()) {
                Constructor<T> constructor = clazz.getConstructor();
                t = constructor.newInstance();
                extractDataFromResult(t);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 查询实体某字段数
     *
     * @param sql    查询SQL语句
     * @param params SQL语句参数
     * @return 记录数
     */
    public static int queryRecordNum(@Language("MySQL") String sql, Object... params) {
        int num = -1;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    private static <T> void extractDataFromResult(T t) throws SQLException {
        Map<String, Object> properties = new HashMap<>();
        ResultSetMetaData metaData = rs.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            properties.put(metaData.getColumnName(i), rs.getObject(i));
        }
        BeanUtil.populate(t, properties);
    }

    /**
     * 开启事务
     */
    public static void begin() {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务提交
     */
    public static void commit() {
        try {
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     */
    public static void rollback() {
        try {
            conn.rollback();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接，释放资源
     */
    public static void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}