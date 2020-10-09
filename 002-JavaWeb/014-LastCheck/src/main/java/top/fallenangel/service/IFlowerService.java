package top.fallenangel.service;

import org.apache.ibatis.annotations.Param;
import top.fallenangel.bean.Classify;
import top.fallenangel.bean.Flower;
import top.fallenangel.bean.FlowerVO;

import java.util.List;
import java.util.Map;

public interface IFlowerService {
    /**
     * 分页列出鲜花
     *
     * @param flowerVO 查询条件
     * @return 每页的鲜花
     */
    List<Map<String, Object>> list(FlowerVO flowerVO);

    /**
     * 列出鲜花总数
     *
     * @return 总数
     */
    int count(FlowerVO flowerVO);

    /**
     * 通过id查找鲜花
     *
     * @param f_id 鲜花id
     * @return 鲜花
     */
    Map<String, Object> query(int f_id);

    /**
     * 列出鲜花种类
     *
     * @return 鲜花种类
     */
    List<Classify> classifies();

    /**
     * 添加鲜花
     *
     * @param flower 要添加的鲜花
     */
    void insert(Flower flower);

    /**
     * 根据id删除鲜花
     *
     * @param f_id id数组
     */
    void delete(int[] f_id);

    /**
     * 重整表格主键id
     *
     * @param tb_name 要重整的表格
     */
    void resetF_id(String tb_name);

    /**
     * 更新鲜花信息
     *
     * @param flower 鲜花
     */
    void modify(Flower flower);
}