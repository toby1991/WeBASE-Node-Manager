package com.webank.webase.node.mgr.deploy.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.webank.webase.node.mgr.deploy.entity.TbChain;

public interface TbChainMapper {

    /**
     * TODO. 删除 Result 看能否成功执行
     */
    @Select({
            "select ", TbChainSqlProvider.ALL_COLUMN_FIELDS, " from tb_chain ",
            "where chain_name = #{chainName,jdbcType=VARCHAR}"
    })
    TbChain getByChainName(@Param("chainName") String chainName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    @Delete({
        "delete from tb_chain",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    @InsertProvider(type=TbChainSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TbChain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, chain_name, chain_desc, version, encrypt_type, chain_status, create_time, modify_time",
        "from tb_chain",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="chain_name", property="chainName", jdbcType=JdbcType.VARCHAR),
        @Result(column="chain_desc", property="chainDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="encrypt_type", property="encryptType", jdbcType=JdbcType.TINYINT),
        @Result(column="chain_status", property="chainStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TbChain selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TbChainSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbChain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_chain
     *
     * @mbg.generated
     */
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn = "id")
    @Insert({
    "<script>",
        "insert into tb_chain (chain_name, ",
        "chain_desc, version, ",
        "encrypt_type, chain_status, ",
        "create_time, modify_time)",
        "values<foreach collection=\"list\" item=\"detail\" index=\"index\" separator=\",\">(#{detail.chainName,jdbcType=VARCHAR}, ",
        "#{detail.chainDesc,jdbcType=VARCHAR}, #{detail.version,jdbcType=VARCHAR}, ",
        "#{detail.encryptType,jdbcType=TINYINT}, #{detail.chainStatus,jdbcType=TINYINT}, ",
        "#{detail.createTime,jdbcType=TIMESTAMP}, #{detail.modifyTime,jdbcType=TIMESTAMP})</foreach></script>"
    })
    int batchInsert(java.util.List<TbChain> list);
}