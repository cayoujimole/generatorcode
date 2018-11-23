package ${packageStr};

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 * ${entityDesc}实体
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author} 	1.0  ${time} Created
 *
 * </pre>
 * @since 1.
 */
@Data
@Table(name = "${tableName}")
public class ${className} extends BaseEntity {
    private static final long serialVersionUID = ${serialVersionNum};
    
${propertiesStr}
${methodStr}

}