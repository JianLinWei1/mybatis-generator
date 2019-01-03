package com.jian.dao;

import com.jian.entity.Tmember;
import com.jian.entity.TmemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TmemberMapper {
    long countByExample(TmemberExample example);

    int deleteByExample(TmemberExample example);

    int deleteByPrimaryKey(String memberId);

    int insert(Tmember record);

    int insertSelective(Tmember record);

    List<Tmember> selectByExampleWithRowbounds(TmemberExample example, RowBounds rowBounds);

    List<Tmember> selectByExample(TmemberExample example);

    Tmember selectByPrimaryKey(String memberId);

    int updateByExampleSelective(@Param("record") Tmember record, @Param("example") TmemberExample example);

    int updateByExample(@Param("record") Tmember record, @Param("example") TmemberExample example);

    int updateByPrimaryKeySelective(Tmember record);

    int updateByPrimaryKey(Tmember record);
}