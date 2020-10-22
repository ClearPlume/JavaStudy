package top.fallenangel.crm.template;

import java.util.List;

public interface ITemplateService<T> {
    ITemplateDao<T> getDao();

    int save(T record);

    int delete(Integer[] id);

    int update(T record);

    T get(Integer id);

    List<T> list();
}