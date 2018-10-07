package ${packageStr};

import java.util.List;
import ${entityType};

/**
 * 
 * ${entityDesc}服务service
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author}    1.0  ${time} Created
 *
 * </pre>
 * @since 1.
 */
public interface ${className} {

    /**
     * 单个新增
     * 
     * @param ${lowerEntityName}
     * @return
     */
    void add${entityName}(${entityName} ${lowerEntityName});

    /**
     * 批量新增
     * 
     * @param list
     * @return
     */
    void addBatch${entityName}(List<${entityName}> list);

    /**
     * 单个删除
     * 
     * @param ${pkName}
     * @return
     */
    void delete${entityName}(${pkType} ${pkName});

    /**
     * 批量删除
     * 
     * @param list
     * @return
     */
    void deleteBatch${entityName}(List<Long> list);

    /**
     * 单个更新
     * 
     * @param ${lowerEntityName}
     * @return
     */
    void update${entityName}(${entityName} ${lowerEntityName});

    /**
     * 批量更新
     * 
     * @param list
     * @return
     */
    void updateBatch${entityName}(List<${entityName}> list);

    /**
     * 单个查询
     * 
     * @param ${pkName}
     * @return
     */
    ${entityName} get${entityName}(${pkType} ${pkName});

    <#--
    /**
     * 分页查询
     * 
     * @param command
     * @return
     */
    Page<${entityName}> find${entityName}Page(${entityName}QueryCommand command);
    -->

    /**
     * bean条件查询
     * 
     * @param ${lowerEntityName}
     * @return
     */
    List<${entityName}> query${entityName}List(${entityName} ${lowerEntityName});
}
