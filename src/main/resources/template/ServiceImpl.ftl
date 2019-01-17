package ${packageStr};

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import ${serviceType};
import ${entityType};
import ${daoType};
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * ${entityDesc}service服务类
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author}    1.0  ${time} Created
 *
 * </pre>
 * @since 1.
 */
@Service
public class ${entityName}Service {

    private Logger logger = LoggerFactory.getLogger(${entityName}ServiceImpl.class);

    @Resource
    private ${entityName}Mapper ${lowerEntityName}Dao;

    @Override
    public void add${entityName}(${entityName} ${lowerEntityName}){
        if (${lowerEntityName} == null) {
            logger.info("bean不能为空");
        }
        ${lowerEntityName}Dao.add(${lowerEntityName});
    }

    @Override
    public void addBatch${entityName}(List<${entityName}> list){
        if (list == null || list.size() == 0) {
            logger.info("list不能为空");
        }
        ${lowerEntityName}Dao.addBatch(list);
    }

    @Override
    public void delete${entityName}(${pkType} ${pkName}){
        if (${pkName} == null) {
            logger.info("id不能为空");
        }
        ${lowerEntityName}Dao.delete(${pkName});
    }

    @Override
    public void deleteBatch${entityName}(List<Long> list){
        if (list == null || list.size() == 0) {
            logger.info("list不能为空");
        }
        ${lowerEntityName}Dao.deleteBatch(list);
    }

    @Override
    public void update${entityName}(${entityName} ${lowerEntityName}){
        if (${lowerEntityName} == null) {
            logger.info("vo不能为空");
        }
        ${lowerEntityName}Dao.update(${lowerEntityName});
    }

    @Override
    public void updateBatch${entityName}(List<${entityName}> list){
        if (list == null || list.size() == 0) {
            logger.info("list不能为空");
        }
        ${lowerEntityName}Dao.updateBatch(list);
    }

    <#--
    @Override
        public Page<${entityName}> find${entityName}Page(${entityName}QueryCommand command){
            logger.info("分页查询：{}", command);
            ${entityName}Vo vo = command.getVo();
            PageVo pageVo = command.getPageVo();
            return ${lowerEntityName}Dao.find${entityName}Page(pageVo, vo);
        }
    -->

    @Override
    public ${entityName} get${entityName}(${pkType} ${pkName}){
        if (${pkName} == null) {
            logger.info("id不能为空");
        }
        return ${lowerEntityName}Dao.get(${pkName});
    }

    @Override
    public List<${entityName}> query${entityName}List(${entityName} ${lowerEntityName}){
        return ${lowerEntityName}Dao.queryList(${lowerEntityName});
    }
}
