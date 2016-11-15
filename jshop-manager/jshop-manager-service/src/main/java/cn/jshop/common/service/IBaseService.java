package cn.jshop.common.service;


import cn.jshop.common.dao.IBaseDAO;
import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.utils.SqlOrderEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/3/10.
 */
public interface IBaseService<D extends IBaseDAO,T extends BaseDomain> {

    public D getDao();

    /**
     * 新增一条数据
     *
     * @param entity
     */
    public int add(T entity);

    /**
     * 修改一条数据
     *
     * @param entity
     *            要更新的实体对象
     */
    public int edit(T entity);

    /**
     * 删除一条数据
     *
     * @param id
     */
    public int delete(Object id);

    /**
     * 查看一条确定的数据
     *
     * @param id
     * @return
     */
    public T view(Object id);

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition
     *            查询条件
     * @param offset
     *            偏移
     * @param rows
     *            查询条数
     * @return 返回Pager对象
     */
    public List<T> listByPage(Map<String, Object> condition, int offset, int rows);
    public List<T> listByPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 保存单一对象，如果要保存多个对象集合，
     *
     * @param entity
     */
    public int insert(T entity);

    /**
     * 更新对象,如果属性为空，则不会进行对应的属性值更新,如果有属性要更新为null，请参看{@link #updateNull(T)}
     *
     * @param entity
     *            要更新的实体对象
     */
    public int update(T entity);


    public int insertMap(Map<String, Object> entityMap);

    public int updateMap(Map<String, Object> entityMap);

    /**
     * 更新对象,如果属性为空，会进行对应的属性值更新,如果有属性不想更新为null，请参看{@link #update(T)}
     *
     * @param entity
     */
    public int updateNull(T entity);

    /**
     * 根据id删除对象
     *
     * @param id
     */
    public int deleteById(Object id);

    /**
     * 根据list(ids)删除对象
     *
     * @param list
     */
    public int deleteByIds(List list);

    /**
     * 根据条件集合删除对象
     *
     * @param condition
     */
    public int deleteByCondition(Map<String, Object> condition);

    /**
     * 根据属性和属性值删除对象
     *
     * @param property
     * @param value
     */
    public int deleteByProperty(String property, Object value);

    /**
     * 根据id进行对象查询
     *
     * @param id
     * @return
     */
    public T fetch(Object id);

    /**
     * 根据任意属性和属性值进行对象查询，如果返回多个对象，将抛出异常
     *
     * @param property
     *            进行对象匹配的属性
     * @param value
     *            进行对象匹配的属性值
     * @return 返回泛型参数类型对象，
     */
    public T findOne(String property, Object value);

    /**
     * 根据任意（单一）属性和属性值进行集合查询
     *
     * @param property
     *            进行对象匹配的属性
     * @param value
     *            进行对象匹配的属性值
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> findList(String property, Object value);
    public List<T> findList(String property, Object value, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据传入的泛型参数类型查询该类型对应表中的所有数据，返回一个集合对象
     *
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> findAll();
    public List<T> findAll(String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition
     *            查询条件
     * @param offset
     *            偏移
     * @param rows
     *            查询条数
     * @return 返回Pager对象
     */
    public List<T> queryPage(Map<String, Object> condition, int offset, int rows);
    public List<T> queryPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);
    public List<T> queryPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selectorpage);

    /**
     * 根据任意属性和属性值进行对象模糊查询
     *
//     * @param property
     *            进行对象匹配的属性
//     * @param value
     *            进行对象匹配的模糊属性值
     * @return
     */
    public List<T> like(Map<String, Object> condition);
    public List<T> like(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);
    public List<T> like(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

    /**
     * 根据条件集合进行指定类型对象集合查询
     *
     * @param condition
     *            进行查询的条件集合
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> queryList(Map<String, Object> condition, String orderBy, String sortBy);
    public List<T> queryList(Map<String, Object> condition, String orderBy, String sortBy, Map<String, Object> selector);

    /**
     * 根据条件集合进行指定类型单一对象查询
     *
     * @param condition
     *            进行查询的条件集合
     * @return 返回泛型参数类型的对象
     */
    public T queryOne(Map<String, Object> condition);
    public T queryOne(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);
    public T queryOne(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

    /**
     * 根据条件进行数量的查询
     *
     * @param condition
     * @return 返回符合条件的泛型参数对应表中的数量
     */
    public int count(Map<String, Object> condition);
//    public int count(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 该方法只有在主键为long时才有用，如果主键为其他数据类型进行使用，则会抛出异常
     *
     * @name selectMaxId
     * @active 查询实体对应表最大Id
     * @time 上午10:04:05
     * @exception/throws 如果主键类型不为long，会抛出类型转换异常
     * @return 返回泛型参数对应表的主键最大值
     */
    public Object selectMaxId();

    /**
     * 更新或保存，涉及到Mabatis使用的bean只是一个简单的值对象，不能进行id的注解，不知道哪个是主键，所以，必须同时指定t的主键值
     *
     * @param t
     *            要更新或保存的对象
     * @param id
     *            要更新或保存的对象的id
     * @return 返回更新或保存的对象。
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws IllegalArgumentException
     */
    public void updateOrSave(T t, Object id);

    /**
     * 根据泛型类型，执行最原始的sql
     *
     * @param mapperId
     * @param obj
     * @return 返回泛型类型对象，如果返回多个结果集会抛出异常，如果要返回多个结果集，请参看
     *         {@link #selectList(String, Object)}
     */
    public T selectOne(String mapperId, Object obj);

    /**
     * 根据泛型类型，执行最原始的sql
     *
     * @param mapperId
     * @param obj
     * @return 返回泛型类型对象集合，如果要返回单个结果对象，请参看{@link #selectOne(String, Object)}
     */
    public List<T> selectList(String mapperId, Object obj);


    /**
     * 通用的更新操作
     * @param updateMap 需要更新的值
     * @param conditionMap 需要被更新的条件
     */
    public int updateByCondition(Map<String, Object> updateMap, Map<String, Object> conditionMap);

}