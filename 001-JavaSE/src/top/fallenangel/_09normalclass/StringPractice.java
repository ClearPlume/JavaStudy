package top.fallenangel._09normalclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"SameParameterValue", "SpellCheckingInspection"})
public class StringPractice {
    public static void main(String[] args) {
        arrayIterator(1, 2, 3);
        arrayIterator('x', 'y', 'z');
        arrayIterator("a", "b", "c");
        arrayIterator(true, false, false, true);

        System.out.println();

        arrayIterator(joint("1,2,3,4,5,6,7,8,9,10"));
        arrayIterator(joint("a,b,c,d,e,f,g,h"));

        System.out.println();

        SQLConverter.preparedStatement("INSERT INTO ? (?, ?, ?, ?, ?) VALUES (?, ?, ?, ?, ?)");
        SQLConverter.setStatement(1, "tb_stu");
        SQLConverter.setStatement(2, "id");
        SQLConverter.setStatement(3, "name");
        SQLConverter.setStatement(4, "age");
        SQLConverter.setStatement(5, "sex");
        SQLConverter.setStatement(6, "grade");
        SQLConverter.setInt(7, 1);
        SQLConverter.setString(8, "张三");
        SQLConverter.setInt(9, 20);
        SQLConverter.setString(10, "男");
        SQLConverter.setInt(11, 2);
        System.out.println("INSERT INTO ? (?, ?, ?, ?, ?) VALUES (?, ?, ?, ?, ?)");
        System.out.println(SQLConverter.getSql());

        System.out.println();

        SQLExtract.setStatement("INSERT INTO b    (c, d, e, f, g) VALUES (h, i, j, k, l)");
        SQLExtract.format("?");
        System.out.println(SQLExtract.getStatement());
        System.out.println("\n********************************************************************************\n");

        SQLExtract.setStatement("INSERT    INTO  tb_stu (id, name, age, sex, grade) VALUES (1, '张三', 20, '男', 2)");
        SQLExtract.format("?");
        System.out.println(SQLExtract.getStatement());
        System.out.println("\n********************************************************************************\n");

        pickData("action");

        System.out.println();

        String str1 = "sdfhsdiauofhasdifhsdfghds";
        String str2 = "sdfhsdiau1ofhasdifhsdfghds";
        System.out.println(str1 + "都是字母：" + str1.matches("[a-zA-Z]+"));
        System.out.println(str2 + "都是字母：" + str2.matches("[a-zA-Z]+"));
        String str3 = "5345648645645645645645";
        String str4 = "53456486s45645645645645";
        System.out.println(str3 + "都是数字：" + str3.matches("\\d*"));
        System.out.println(str4 + "都是数字：" + str4.matches("\\d*"));
    }

    /**
     * 遍历任意数组
     *
     * @param arr 数组
     * @param <T> 类型参数
     */
    @SafeVarargs
    static <T> void arrayIterator(T... arr) {
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if (i < arr.length - 1) {
                result.append(", ");
            }
        }
        result.append(']');
        System.out.println(result);
    }

    static String[] joint(String data) {
        return data.split(",");
    }

    static void pickData(String keyWord) {
        String src = "<action>student</action><action>teacher</action><action>class</action><action>school</action>";
        String[] splits = src.split("<" + keyWord + ">|</" + keyWord + ">");
        for (String res : splits) {
            if (!"".equals(res)) {
                System.out.print(res + "    ");
            }
        }
        System.out.println();
    }
}

class SQLConverter {
    private static StringBuilder sql;
    private static List<StatementEntry> statements;

    public static void preparedStatement(String sql) {
        SQLConverter.sql = new StringBuilder(sql);
        statements = new ArrayList<>();
        for (int i = 0; i < sql.length(); i++) {
            if (sql.charAt(i) == '?') {
                statements.add(new StatementEntry(i));
            }
        }
    }

    /**
     * 设置sql语句体
     *
     * @param parameterSerialNumber “?”的第一个是“1”，第二个是“2”...
     * @param state                 要替换的部分
     */
    public static void setStatement(int parameterSerialNumber, String state) {
        statements.get(parameterSerialNumber - 1).setValue(state);
    }

    public static void setInt(int parameterSerialNumber, int value) {
        setStatement(parameterSerialNumber, Integer.toString(value));
    }

    public static void setString(int parameterSerialNumber, String value) {
        statements.get(parameterSerialNumber - 1).setValue('\'' + value + '\'');
    }

    public static String getSql() {
        Collections.reverse(statements);
        statements.forEach(statement -> sql.replace(statement.getKey(), statement.getKey() + 1, statement.getValue()));
        return sql.toString();
    }
}

class SQLExtract {
    private static String statement;

    public static void setStatement(String statement) {
        SQLExtract.statement = statement;
    }

    public static String getStatement() {
        return statement;
    }

    public static void format(String replacement) {
        System.out.println(statement);
        statement = statement.replaceAll("(?<=[(\\s,])'?\\b[\\u4e00-\\u9fa5\\w]+\\b'?(?=[(),])|(?<=(?i)INSERT\\s\\+INTO\\s\\+)\\b\\w+?\\b?\\s*?(?=\\()", replacement);
    }
}

class StatementEntry {
    private final int key;
    private String value;

    public StatementEntry(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}