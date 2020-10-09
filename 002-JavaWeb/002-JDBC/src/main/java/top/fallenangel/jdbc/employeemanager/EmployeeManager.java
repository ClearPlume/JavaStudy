package top.fallenangel.jdbc.employeemanager;

import top.fallenangel.util.DBUtil;
import top.fallenangel.util.InputUtil;
import top.fallenangel.util.NormalUtil;

import java.util.List;

public class EmployeeManager {
    public static void main(String[] args) {
        new EmployeeManager().mainProcess();
    }

    /**
     * 主流程
     */
    public void mainProcess() {
        boolean running = true;

        while (running) {
            switch (mainUI()) {
                case 1:
                    if (loginUI()) {
                        boolean mainFunctionRunning = true;
                        while (mainFunctionRunning) {
                            switch (mainFunction()) {
                                case 1: {
                                    DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
                                    List<Employee> employees = DBUtil.query(Employee.class, "SELECT no, name, sal FROM t_employee");
                                    NormalUtil.showDataList(employees);
                                    System.out.print("全部数据如上。回车继续...");
                                    InputUtil.inEnter();
                                    DBUtil.close();
                                }
                                break;
                                case 2: {
                                    System.out.print("输入员工编号：");
                                    int no = InputUtil.inInt();

                                    DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
                                    Employee employee = DBUtil.querySingleRecord(Employee.class, "SELECT no, name, sal FROM t_employee WHERE no = ?", no);
                                    if (null == employee) {
                                        System.out.print("员工编号输入有误，请重新输入！");
                                        NormalUtil.sleep(1000);
                                        continue;
                                    }
                                    NormalUtil.showData(employee);
                                    System.out.print("数据如上。回车继续...");
                                    InputUtil.inEnter();
                                    DBUtil.close();
                                }
                                break;
                                case 3: {
                                    System.out.print("输入员工编号：");
                                    int no = InputUtil.inInt();
                                    System.out.print("输入员工姓名：");
                                    String name = InputUtil.inStr();
                                    System.out.print("输入员工密码：");
                                    String pwd = InputUtil.inStr();
                                    System.out.print("输入员工薪水：");
                                    double sal = InputUtil.inDouble();

                                    DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
                                    DBUtil.begin();
                                    try {
                                        if (DBUtil.update("INSERT INTO t_employee(no, name, pwd, sal) VALUES (?, ?, ?, ?)", no, name, pwd, sal) > 0) {
                                            DBUtil.commit();
                                            System.out.print("添加员工成功！回车继续...");
                                        } else {
                                            DBUtil.rollback();
                                            System.out.print("添加员工失败！回车继续...");
                                        }
                                        InputUtil.inEnter();
                                    } catch (Exception e) {
                                        DBUtil.rollback();
                                        e.printStackTrace();
                                    }
                                    DBUtil.close();
                                }
                                break;
                                case 4: {
                                    System.out.print("输入要删除的员工编号：");
                                    int no = InputUtil.inInt();

                                    DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
                                    DBUtil.begin();
                                    try {
                                        if (DBUtil.update("DELETE FROM t_employee WHERE no = ?", no) > 0) {
                                            DBUtil.commit();
                                            System.out.print("员工删除成功！回车继续...");
                                        } else {
                                            DBUtil.rollback();
                                            System.out.print("员工删除失败！回车继续...");
                                        }
                                        InputUtil.inEnter();
                                    } catch (Exception e) {
                                        DBUtil.rollback();
                                        e.printStackTrace();
                                    }
                                    DBUtil.close();
                                }
                                break;
                                case 5: {
                                    System.out.print("输入要修改的员工编号：");
                                    int no = InputUtil.inInt();

                                    DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
                                    Employee employee = DBUtil.querySingleRecord(Employee.class, "SELECT no, name, pwd, sal FROM t_employee WHERE no = ?", no);
                                    if (null == employee) {
                                        System.out.print("员工编号输入有误，请重新输入！");
                                        NormalUtil.sleep(1000);
                                        continue;
                                    }
                                    employee.setShowPwd(true);
                                    NormalUtil.showData(employee);
                                    System.out.println("要修改的员工信息如上。");

                                    DBUtil.begin();
                                    try {
                                        boolean modifying = true;
                                        while (modifying) {
                                            NormalUtil.showUI("**NO-SHOW-HEADER**", "编号", "姓名", "密码", "薪水");
                                            String column;
                                            Object data;
                                            byte modifyChoice = InputUtil.inByte();
                                            switch (modifyChoice) {
                                                case 1:
                                                    System.out.print("输入新的编号：");
                                                    column = "no";
                                                    data = InputUtil.inInt();
                                                    break;
                                                case 2:
                                                    System.out.print("输入新的姓名：");
                                                    column = "name";
                                                    data = InputUtil.inStr();
                                                    break;
                                                case 3:
                                                    System.out.print("输入新的密码：");
                                                    column = "pwd";
                                                    data = InputUtil.inStr();
                                                    break;
                                                case 4:
                                                    System.out.print("输入新的薪水：");
                                                    column = "sal";
                                                    data = InputUtil.inDouble();
                                                    break;
                                                default:
                                                    System.out.println("选择有误，请重新选择！");
                                                    NormalUtil.sleep(1000);
                                                    column = "";
                                                    data = null;
                                            }
                                            if (null != data) {
                                                DBUtil.update("UPDATE t_employee SET " + column + " = ? WHERE no = ?", data, no);
                                                DBUtil.commit();
                                                if (modifyChoice == 1) {
                                                    no = (int) data;
                                                }
                                                System.out.println("修改成功。新的信息如下：");
                                                employee = DBUtil.querySingleRecord(Employee.class, "SELECT no, name, pwd, sal FROM t_employee WHERE no = ?", no);
                                                if (null == employee) {
                                                    System.out.print("员工编号输入有误，请重新输入！");
                                                    NormalUtil.sleep(1000);
                                                    continue;
                                                }
                                                employee.setShowPwd(true);
                                                NormalUtil.showData(employee);
                                                System.out.print("是否继续修改(y/*)？");
                                                char choice = InputUtil.inChar();
                                                if (!(choice == 'y' || choice == 'Y')) {
                                                    modifying = false;
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        DBUtil.rollback();
                                        e.printStackTrace();
                                    }
                                    DBUtil.close();
                                }
                                break;
                                case 6: {
                                    mainFunctionRunning = false;
                                }
                                break;
                                default: {
                                    System.out.println("输入有误，将在1秒后回到主功能界面...");
                                    NormalUtil.sleep(1000);
                                }
                            }
                        }
                    } else {
                        NormalUtil.sleep(1000);
                    }
                    break;
                case 2:
                    if (registerUI()) {
                        System.out.println("注册成功！将返回主界面...");
                    } else {
                        System.out.println("注册失败...");
                    }
                    NormalUtil.sleep(1000);
                    break;
                case 3:
                    running = false;
                    System.out.print("Bye");
                    break;
                default:
                    System.out.println("输入有误，将在1秒后回到主界面...");
                    NormalUtil.sleep(1000);
            }
        }
    }

    /**
     * 员工管理系统主界面
     *
     * @return 用户在主界面的选择
     */
    public byte mainUI() {
        NormalUtil.showUI("", "员工登录", "员工注册", "退出系统");
        return InputUtil.inByte();
    }

    /**
     * 登录界面
     *
     * @return 登录是否成功
     */
    public boolean loginUI() {
        NormalUtil.showUI("员工管理系统", "登录");
        System.out.print("编号：");
        int no = InputUtil.inInt();
        System.out.print("密码：");
        String pwd = InputUtil.inStr();

        boolean loginSucceed = false;
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        // 判断用户是否存在
        if (DBUtil.queryRecordNum("SELECT count(no) as num FROM t_employee WHERE no = ?", no) == 1) {
            // 判断密码是否正确
            Employee employee = DBUtil.querySingleRecord(Employee.class, "SELECT no, pwd FROM t_employee WHERE no = ?", no);
            if (pwd.equals(employee.getPwd())) {
                loginSucceed = true;
            } else {
                System.out.println("编号或密码输入有误，请重试！");
            }
        } else {
            System.out.println("编号" + no + "的员工不存在！将返回主界面...");
        }
        DBUtil.close();
        return loginSucceed;
    }

    /**
     * 注册界面
     *
     * @return 注册是否成功
     */
    public boolean registerUI() {
        NormalUtil.showUI("员工管理系统", "注册");
        System.out.print("编号：");
        int no = InputUtil.inInt();
        System.out.print("姓名：");
        String name = InputUtil.inStr();
        System.out.print("密码：");
        String pwd = InputUtil.inStr();
        System.out.print("确认密码：");
        String pwdConfirm = InputUtil.inStr();
        if (!pwdConfirm.equals(pwd)) {
            System.out.println("两次输入密码不一致，请重试！");
            return false;
        }
        System.out.print("薪水：");
        String sal = InputUtil.inStr();

        boolean registerSucceed = false;
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        DBUtil.begin();
        try {
            if (DBUtil.update("INSERT INTO t_employee(no, name, pwd, sal) VALUES (?, ?, ?, ?)", no, name, pwd, sal) > 0) {
                registerSucceed = true;
            }
            DBUtil.commit();
        } catch (Exception e) {
            DBUtil.rollback();
            e.printStackTrace();
        }
        DBUtil.close();
        return registerSucceed;
    }

    /**
     * 主功能界面
     *
     * @return 用户的选择
     */
    public byte mainFunction() {
        NormalUtil.showUI("主界面", "查询所有员工", "查询员工信息", "添加员工", "删除员工", "修改员工", "退出");
        return InputUtil.inByte();
    }
}