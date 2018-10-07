package ${packageStr};

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
${importStr}

/**
 * 
 * ${entityDesc}Dao
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author} 	1.0  		${time} 	Created
 *
 * </pre>
 * @since 1.
 */
@Mapper
public interface ${className} {

    /**
     * 单个新增
     *
     * @param ${lowerEntityName}
     * @return
     */
    int add(${entityClassName} ${lowerEntityName});

    /**
     * 批量新增
     * 
     * @param list
     * @return
     */
    int addBatch(List<${entityClassName}> list);

    /**
     * 单个删除
     *
     * @param ${pkName}
     * @return
     */
    int delete(${pkType} ${pkName});

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int deleteBatch(List<Long> list);

    /**
     * 单个更新
     *
     * @param ${lowerEntityName}
     * @return
     */
    int update(${entityClassName} ${lowerEntityName});

    /**
     * 批量更新
     * 
     * @param list
     * @return
     */
    int updateBatch(List<${entityClassName}> list);

    /**
     * 查询一条
     *
     * @param ${pkName}
     * @return
     */
    ${entityClassName} get(${pkType} ${pkName});

    /**
     * 查询列表
     * 
     * @param ${lowerEntityName}
     * @return
     */
    List<${entityClassName}> queryList(${entityClassName} ${lowerEntityName});
}