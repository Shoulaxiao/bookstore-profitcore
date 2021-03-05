package com.shoulaxiao.dao;

import com.shoulaxiao.entity.orderRecordDO;
import com.shoulaxiao.entity.orderRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderRecordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    long countByExample(orderRecordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int deleteByExample(orderRecordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int insert(orderRecordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int insertSelective(orderRecordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    List<orderRecordDO> selectByExample(orderRecordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    orderRecordDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") orderRecordDO record, @Param("example") orderRecordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") orderRecordDO record, @Param("example") orderRecordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(orderRecordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(orderRecordDO record);
}