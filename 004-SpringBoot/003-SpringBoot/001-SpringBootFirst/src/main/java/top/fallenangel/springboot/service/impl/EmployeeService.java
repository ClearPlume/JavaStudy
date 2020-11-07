package top.fallenangel.springboot.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.fallenangel.springboot.model.entity.Employee;
import top.fallenangel.springboot.model.mapper.EmployeeMapper;
import top.fallenangel.springboot.service.IEmployeeService;

import java.util.concurrent.TimeUnit;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeMapper employeeMapper;
    private final RedisTemplate<String, String> redis;

    public EmployeeService(EmployeeMapper employeeMapper, RedisTemplate<String, String> redis) {
        this.employeeMapper = employeeMapper;
        this.redis = redis;
    }

    @Override
    public Employee get(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count() {
        int count;
        String employeeCount = redis.opsForValue().get("employeeCount");

        if (employeeCount == null) {
            synchronized (this) {
                employeeCount = redis.opsForValue().get("employeeCount");

                if (employeeCount == null) {
                    count = employeeMapper.count();
                    redis.opsForValue().set("employeeCount", String.valueOf(count), 10, TimeUnit.SECONDS);
                    System.out.println("从数据库读数据");
                } else {
                    count = Integer.parseInt(employeeCount);
                    System.out.println("从缓存读数据");
                }
            }
        } else {
            count = Integer.parseInt(employeeCount);
            System.out.println("从缓存读数据");
        }
        return count;
    }
}