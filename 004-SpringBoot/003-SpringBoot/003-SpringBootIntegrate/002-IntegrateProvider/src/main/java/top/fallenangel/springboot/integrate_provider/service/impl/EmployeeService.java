package top.fallenangel.springboot.integrate_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;
import top.fallenangel.springboot.integrate_interface.model.entity.Employee;
import top.fallenangel.springboot.integrate_interface.service.IEmployeeService;
import top.fallenangel.springboot.integrate_provider.model.mapper.EmployeeMapper;

import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Service
@Service(interfaceClass = IEmployeeService.class, version = "1.0.0", timeout = 15000)
public class EmployeeService implements IEmployeeService {
    private final EmployeeMapper employeeMapper;
    private final RedisTemplate<String, String> redis;

    public EmployeeService(EmployeeMapper employeeMapper, RedisTemplate<String, String> redis) {
        this.employeeMapper = employeeMapper;
        this.redis = redis;
    }

    @Override
    public Employee view(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count() {
        String employeeCount = redis.opsForValue().get("employeeCount");
        int count;

        if (employeeCount == null) {
            count = employeeMapper.count();
            redis.opsForValue().set("employeeCount", String.valueOf(count), 15, TimeUnit.SECONDS);
        } else {
            employeeCount = redis.opsForValue().get("employeeCount");
            assert employeeCount != null;
            count = Integer.parseInt(employeeCount);
        }

        return count;
    }
}
