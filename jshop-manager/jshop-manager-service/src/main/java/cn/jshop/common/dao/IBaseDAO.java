package cn.jshop.common.dao;


import cn.jshop.common.domain.BaseDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * create by 郭旭辉
 * @param <T>
 */
public interface IBaseDAO<T extends BaseDomain> {

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
    public int updateMap(@Param("map") Map<String, Object> entityMap);

    /**
     * 通用的更新操作
     * @param updateMap 需要更新的值
     * @param conditionMap 需要被更新的条件
     */
    public int updateByCondition(@Param("update") Map<String, Object> updateMap, @Param("condition") Map<String, Object> conditionMap);

    /**
     * map类型数据的新增
     * @param entityMap
     */
    public int insertMap(@Param("map") Map<String, Object> entityMap);

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
    public int deleteByProperty(@Param("property") String property, @Param("value") Object value);

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
     * @return 返回泛型参数类型对象，如何取到泛型类型参数，请参看{@link #getEntityClass()}
     */
//    public T findOne(@Param("property") String property, @Param("value") Object value);

    /**
     * 增加排序支持
     * @param property
     * @param value
     * @param orderBy
     * @param sortBy
     * @return
     */
    public T findOne(@Param("property") String property, @Param("value") Object value, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 根据任意（单一）属性和属性值进行集合查询
     *
     * @param property
     *            进行对象匹配的属性
     * @param value
     *            进行对象匹配的属性值
     * @return 返回泛型参数类型的对象集合，如何取到泛型类型参数，请参看{@link #getEntityClass()}
     */
//    public List<T> findList(@Param("property") String property, @Param("value") Object value);

    /**
     * 增加排序支持
     * @param property
     * @param value
     * @param orderBy
     * @param sortBy
     * @return
     */
    public List<T> findList(@Param("property") String property, @Param("value") Object value, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 根据传入的泛型参数类型查询该类型对应表中的所有数据，返回一个集合对象
     *
     * @return 返回泛型参数类型的对象集合，如何取到泛型类型参数，请参看{@link #getEntityClass()}
     */
//    public List<T> findAll();

    /**
     * 增加排序支持
     * @param orderBy
     * @param sortBy
     * @return
     */
    public List<T> findAll(@Param("orderBy") String orderBy, @Param("sortBy") String sortBy);
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
//    public List<T> queryPage(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 增加排序支持
     * @param condition
     * @param offset
     * @param rows
     * @param orderBy
     * @param sortBy
     * @return
     */
    public List<T> queryPage(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows,
                             @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    public List<T> queryPage(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows,
                             @Param("orderBy") String orderBy, @Param("sortBy") String sortBy, @Param("selector") Map<String, Object> selector);

    /**
     * 根据任意属性和属性值进行对象模糊查询
     *
     * @param property
     *            进行对象匹配的属性
     * @param value
     *            进行对象匹配的模糊属性值
     * @return
     */
//    public List<T> like(@Param("property") String property, @Param("value") Object value);

    /**
     * 增加排序支持

     * @param orderBy
     * @param sortBy
     * @return
     */
    public List<T> like(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);
    public List<T> like(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy, @Param("selector") Map<String, Object> selector);

    /**
     * 根据条件集合进行指定类型对象集合查询
     *
     * @param condition
     *            进行查询的条件集合
     * @return 返回泛型参数类型的对象集合，如何取到泛型类型参数，请参看{@link #getEntityClass()}
     */
    public List<T> queryList(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);
    public List<T> queryList(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy, @Param("selector") Map<String, Object> selector);

    /**
     * 根据条件集合进行指定类型单一对象查询
     *
     * @param condition
     *            进行查询的条件集合
     * @return 返回泛型参数类型的对象，如何取到泛型类型参数，请参看{@link #getEntityClass()}，
     */
//    public T queryOne(Map<String, Object> condition);
    public T queryOne(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     *
     * @param condition
     * @param orderBy
     * @param sortBy
     * @param selector  查询器，不进行不必要字段的查询，这样 生成的 model  在http传递给客户端时依赖fastjson的特性 就不会传递出去，减少带宽依赖
     * @return
     */
    public T queryOne(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy, @Param("selector") Map<String, Object> selector);

    /**
     * 根据条件进行数量的查询
     *
     * @param condition
     * @return 返回符合条件的泛型参数对应表中的数量
     */
    public int count(Map<String, Object> condition);

    /**
     * 增加排序支持  和 queryPage匹配
     * @param condition
     * @param orderBy
     * @param sortBy
     * @return
     */
//    public int count(Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

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
    public T updateOrSave(@Param("condition") T t, @Param("condition") Long id);

    /**
     * 根据泛型类型，执行最原始的sql
     *
     * @param mapperId
     * @param obj
     * @return 返回泛型类型对象，如果返回多个结果集会抛出异常，如果要返回多个结果集，请参看
     *         {@link #selectList(String, Object)}
     */
    public T selectOne(@Param("condition") String mapperId, @Param("condition") Object obj);

    /**
     * 根据泛型类型，执行最原始的sql
     *
     * @param mapperId
     * @param obj
     * @return 返回泛型类型对象集合，如果要返回单个结果对象，请参看{@link #selectOne(String, Object)}
     */
    public List<T> selectList(@Param("condition") String mapperId, @Param("condition") Object obj);

    /**
     * 根据原生sql查询获取返回的值[模型动态化]
     * @return
     */
    public List<Map> queryBySql(@Param("executeSql") String executeSql);
    public Long queryBySqlCount(@Param("executeSqlCount") String executeSql);

    /**
     * 取得泛型类型
     *
     * @return
     */
    public Class<T> getEntityClass();

}
