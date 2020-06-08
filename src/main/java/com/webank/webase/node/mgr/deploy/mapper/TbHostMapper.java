package com.webank.webase.node.mgr.deploy.mapper;

import java.util.List;

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

import com.webank.webase.node.mgr.deploy.entity.TbHost;

public interface TbHostMapper {

    @Delete({
            "delete from tb_host",
            "where agency_id = #{agencyId,jdbcType=INTEGER}"
    })
    int deleteByAgencyId(@Param("agencyId") Integer agencyId);

    @Select({
            "select",
            TbHostSqlProvider.ALL_COLUMN_FIELDS,
            "from tb_host",
            "where agency_id = #{agencyId,jdbcType=INTEGER}"
    })
    List<TbHost> selectByAgencyId(@Param("agencyId") int agencyId);

    @Select({
            "select",
            TbHostSqlProvider.ALL_COLUMN_FIELDS,
            "from tb_host",
            "where ip = #{ip,jdbcType=VARCHAR}"
    })
    List<TbHost> selectByIp(@Param("ip") String ip);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_host
     *
     * @mbg.generated
     */
    @Delete({
        "delete from tb_host",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_host
     *
     * @mbg.generated
     */
    @InsertProvider(type=TbHostSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TbHost record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_host
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, agency_id, agency_name, ip, ssh_user, ssh_port, root_dir, docker_port, status, ",
        "create_time, modify_time",
        "from tb_host",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="agency_id", property="agencyId", jdbcType=JdbcType.INTEGER),
        @Result(column="agency_name", property="agencyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="ssh_user", property="sshUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="ssh_port", property="sshPort", jdbcType=JdbcType.SMALLINT),
        @Result(column="root_dir", property="rootDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="docker_port", property="dockerPort", jdbcType=JdbcType.SMALLINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TbHost selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_host
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TbHostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbHost record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_host
     *
     * @mbg.generated
     */
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn = "id")
    @Insert({
    "<script>",
        "insert into tb_host (agency_id, ",
        "agency_name, ip, ",
        "ssh_user, ssh_port, ",
        "root_dir, docker_port, ",
        "status, create_time, ",
        "modify_time)",
        "values<foreach collection=\"list\" item=\"detail\" index=\"index\" separator=\",\">(#{detail.agencyId,jdbcType=INTEGER}, ",
        "#{detail.agencyName,jdbcType=VARCHAR}, #{detail.ip,jdbcType=VARCHAR}, ",
        "#{detail.sshUser,jdbcType=VARCHAR}, #{detail.sshPort,jdbcType=SMALLINT}, ",
        "#{detail.rootDir,jdbcType=VARCHAR}, #{detail.dockerPort,jdbcType=SMALLINT}, ",
        "#{detail.status,jdbcType=TINYINT}, #{detail.createTime,jdbcType=TIMESTAMP}, ",
        "#{detail.modifyTime,jdbcType=TIMESTAMP})</foreach></script>",
    })
    int batchInsert(java.util.List<TbHost> list);

}