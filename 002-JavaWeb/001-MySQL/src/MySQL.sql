# noinspection NonAsciiCharactersForFile
# 查询每个部门最高薪水的员工信息
select EMPNO, ENAME, emp.DEPTNO
from emp
         inner join
     (select max(SAL) as MAX_SAL,
             DEPTNO
      from emp
      group by DEPTNO) as tb_max_sal
     on emp.DEPTNO = tb_max_sal.DEPTNO
where SAL = MAX_SAL
order by emp.DEPTNO;

# 哪些人薪水在部门平均薪水之上
select EMPNO, ENAME, SAL, tb_avg_sal.DEPTNO
from emp
         inner join
     (select DEPTNO,
             avg(SAL) as AVG_SAL
      from emp
      group by DEPTNO) as tb_avg_sal on emp.DEPTNO = tb_avg_sal.DEPTNO
where SAL > AVG_SAL;

# 查询部门中每个员工的薪水等级
select EMPNO, ENAME, SAL, GRADE
from emp
         inner join salgrade on SAL between LOSAL and HISAL;

# 查询薪水最高的员工（不能用max聚合函数）
select EMPNO, ENAME, SAL
from emp
order by SAL desc
limit 1;

# 查询平均薪水最高的部门编号
select DEPTNO,
       avg(SAL) as AVG_SAL
from emp
group by DEPTNO
order by AVG_SAL desc
limit 1;

# 查询平均薪水最低的部门名称
select DEPTNO,
       (SELECT DNAME from dept where emp.DEPTNO = dept.DEPTNO) as DNAME,
       avg(SAL)                                                as AVG_SAL
from emp
group by DEPTNO
order by AVG_SAL
limit 1;

# 查询薪水最高的前五名员工
select EMPNO, ENAME, SAL
from emp
order by SAL desc
limit 5;

# 查询薪水最高的第六到第十名员工
select EMPNO, ENAME, SAL
from emp
order by SAL desc
limit 5, 5;

# 查询最后入职的五名员工信息
select EMPNO, ENAME, SAL, HIREDATE
from emp
order by HIREDATE desc
limit 5;

# 查询每个薪水等级的员工人数
select GRADE, count(EMPNO) as NUM
from emp
         right outer join salgrade on SAL between LOSAL and HISAL
group by GRADE
order by GRADE;

# 查询所有员工及其领导的姓名
select e.ENAME as 员工,
       l.ENAME as 领导
from emp as e
         left outer join emp as l on e.MGR = l.EMPNO;

# 列出受雇日期早于其直接上级的所有员工的编号,姓名,部门名称
select tb_hire.EMPNO                                               as 编号,
       tb_hire.员工,
       (select DNAME from dept where tb_hire.DEPTNO = dept.DEPTNO) as 部门名称
from (select e.EMPNO,
             e.ENAME    as 员工,
             e.HIREDATE as 员工受雇日期,
             e.DEPTNO,
             l.HIREDATE as 领导受雇日期
      from emp as e
               inner join emp as l on e.MGR = l.EMPNO) as tb_hire
where tb_hire.员工受雇日期 < tb_hire.领导受雇日期;

# 列出至少有5个员工的所有部门
select DEPTNO,
       (select DNAME from dept where emp.DEPTNO = dept.DEPTNO) as DNAME,
       count(EMPNO)                                            as NUM
from emp
group by DEPTNO
having NUM >= 5;

# 列出薪金比"SMITH"多的所有员工信息
select emp.*
from emp,
     (select SAL from emp where ENAME = 'smith') as tb_smith_sal
where emp.SAL > tb_smith_sal.SAL;

# 列出所有工种为"CLERK"的员工姓名及其部门名称
select ENAME,
       (select DNAME from dept where emp.DEPTNO = dept.DEPTNO) as DNAME
from emp
where JOB = 'clerk';

# 列出最低薪金大于1500的各种工作及从事此工作的全部雇员人数
select JOB,
       min(SAL)     as MIN_SAL,
       count(EMPNO) as NUM
from emp
group by JOB
having MIN_SAL > 1500;

# 列出在部门"SALES"<销售部>工作的员工的姓名,假定不知道销售部的部门编号
select EMPNO, ENAME
from emp,
     (select DEPTNO from dept where DNAME = 'sales') as tb_sales_no
where emp.DEPTNO = tb_sales_no.DEPTNO;

# 列出薪金高于公司平均薪金的所有员工,所在部门,上级领导,雇员的工资等级
select e.EMPNO,
       e.ENAME,
       (select DNAME from dept where dept.DEPTNO = e.DEPTNO)            as 部门,
       l.ENAME                                                          as 领导,
       (select GRADE from salgrade where e.SAL between LOSAL and HISAL) as GRADE
from emp as e
         left outer join emp as l on e.MGR = l.EMPNO,
     (select avg(SAL) as AVG_SAL from emp) as tb_avg_sal
where e.SAL > tb_avg_sal.AVG_SAL;

# 列出与"SCOTT"从事相同工作的所有员工及部门名称
select EMPNO,
       ENAME,
       (select DNAME from dept where dept.DEPTNO = emp.DEPTNO) as DNAME
from emp
         inner join
         (select JOB from emp where ENAME = 'scott') tb_scott_job
         on emp.JOB = tb_scott_job.JOB
where ENAME <> 'scott';

# 列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金，部门名称
select EMPNO,
       ENAME,
       SAL,
       (select DNAME from dept where dept.DEPTNO = emp.DEPTNO) as DNAME
from emp
         inner join
         (select max(sal) as MAX_SAL from emp where DEPTNO = 30) as tb_dept30_sal
         on emp.SAL > tb_dept30_sal.MAX_SAL;

# 列出在每个部门工作的员工数量,平均工资
select DEPTNO,
       (select DNAME from dept where emp.DEPTNO = dept.DEPTNO) as DNAME,
       count(EMPNO)                                            as NUM,
       avg(SAL)                                                as AVG_SAL
from emp
group by DEPTNO;

# 列出所有员工的姓名、部门名称和工资
select EMPNO,
       ENAME,
       (select DNAME from dept where emp.DEPTNO = dept.DEPTNO) as DNAME,
       SAL
from emp;

# 列出所有部门的详细信息和人数
select dept.*,
       count(EMPNO) as NUM
from emp
         inner join dept on emp.DEPTNO = dept.DEPTNO
group by emp.DEPTNO;

# 列出各种工作的最低工资
select JOB,
       (min(SAL)) as MIN_SAL
from emp
group by JOB;

# 列出各个部门的MANAGER(领导)的最低薪金
select EMPNO,
       ENAME,
       (min(SAL)) as MINSAL
from emp
where JOB = 'manager'
group by DEPTNO;

# 列出所有员工的年工资,按年薪从低到高排序
select EMPNO,
       ENAME,
       (SAL * 12 + ifnull(COMM, 0)) as INCOME
from emp
order by INCOME;

# 列出任职日期超过30年的员工
select emp.EMPNO,
       ENAME,
       tb_work_year.WORK_YEAR as WORK_YEAR
from emp
         inner join
     (select EMPNO, timestampdiff(year, HIREDATE, now()) as WORK_YEAR from emp) as tb_work_year
     on emp.EMPNO = tb_work_year.EMPNO
where tb_work_year.WORK_YEAR > 35;