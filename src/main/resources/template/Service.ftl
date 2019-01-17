package ${packageStr};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Service
public class ${className} {

    private Logger logger = LoggerFactory.getLogger(${entityName}Service.class);

    @Autowired
    private ${entityName}Mapper ${lowerEntityName}Mapper;

}
