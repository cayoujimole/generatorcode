<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${namespace}">
  <resultMap id="BaseResultMap" type="${entityType}">
${resultMap}
  </resultMap>
  
  <!-- 基本列 -->
  <sql id="${tableName}">
    ${baseColumn}
  </sql>
  
  <!-- 单个插入 -->
  <insert id="add" parameterType="${entityType}" useGeneratedKeys="true" keyProperty="${pkName}">
    insert into ${tableName}
    <trim prefix="(" suffix=")" suffixOverrides=",">
${insertIfColumns}
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
${insertIfProps}
    </trim>
  </insert>
  
  <!-- 批量新增 -->
  <insert id="addBatch" parameterType="java.util.List">
    INSERT INTO ${tableName}
    (${insertBatchColumns})
    VALUES
    <foreach collection="list" item="item" index="index" separator=",">
       (${insertBatchProps})
    </foreach>
  </insert>

  <!-- 删除 -->
  <update id="delete" parameterType="${pkType}" >
    delete from ${tableName}
    where ${pkColumn} = <#noparse>#{${pkName},jdbcType=${pkType}}</#noparse>
  </update>

  <!-- 批量删除 -->
  <update id="deleteBatch" parameterType="java.util.List" >
    <foreach collection="list" item="item" index="index" open="" close="" separator=";">
        delete from ${tableName}
        where ${pkColumn} = <#noparse>#{item,jdbcType=${pkType}}</#noparse>
    </foreach>
  </update>
  
  <!-- 单个更新 -->
  <update id="update" parameterType="${entityType}">
    update ${tableName}
    <set>
${updateColProps}
    </set>
    where ${pkColumn} = <#noparse>#{${pkName},jdbcType=${pkType}}</#noparse>
  </update>
  
  <!-- 批量更新 -->
  <update id="updateBatch" parameterType="java.util.List">
    <foreach collection="list" item="item" index="index" open="" close="" separator=";">  
        UPDATE ${tableName}
        <set>
${updateBatchColProps}
        </set>
        WHERE ${pkColumn} = <#noparse>#{${pkName},jdbcType=${pkType}}</#noparse>
    </foreach> 
  </update>

  <!-- 单个查询 -->
    <select id="get" parameterType="${pkType}" resultMap="BaseResultMap">
      SELECT
      <include refid="${tableName}" />
      FROM ${tableName}
      WHERE ${pkColumn} = <#noparse>#{${pkName},jdbcType=${pkType}}</#noparse>
    </select>

  <!-- 查询所有 -->
  <select id="queryList" parameterType="${entityType}" resultMap="BaseResultMap">
    SELECT
    <include refid="${tableName}" />
    FROM ${tableName}
    WHERE 1=1
${findListConditon}
  </select>
  
  <!-- 分页查询
  <select id="find" parameterType="com.winit.common.query.Searchable" resultMap="BaseResultMap">
    SELECT
    <include refid="${tableName}" />
    FROM ${tableName}
    WHERE 1=1
  </select> -->
  
</mapper>