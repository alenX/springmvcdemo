package org.wangss.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wangss.Model.SysRoleAuth;
import org.wangss.Model.SysRoleAuthExample;
import org.wangss.Model.SysRoleAuthKey;

public interface SysRoleAuthMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int countByExample(SysRoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int deleteByExample(SysRoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int deleteByPrimaryKey(SysRoleAuthKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int insert(SysRoleAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int insertSelective(SysRoleAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    List<SysRoleAuth> selectByExample(SysRoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    SysRoleAuth selectByPrimaryKey(SysRoleAuthKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysRoleAuth record, @Param("example") SysRoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int updateByExample(@Param("record") SysRoleAuth record, @Param("example") SysRoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int updateByPrimaryKeySelective(SysRoleAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_auth
     *
     * @mbggenerated Sun Jul 16 18:08:29 CST 2017
     */
    int updateByPrimaryKey(SysRoleAuth record);
}