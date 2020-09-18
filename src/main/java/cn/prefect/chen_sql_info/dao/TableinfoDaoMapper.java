package cn.prefect.chen_sql_info.dao;

import cn.prefect.chen_sql_info.entity.TableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TableinfoDaoMapper {

    public List<TableInfo> TableInfoShow(@Param("tableName") String tableName,@Param("dataBaseName") String dataBaseName);

    List<String> allTableList(@Param("dataBaseName") String dataBaseName);

    List<String> allTableList2(@Param("dataBaseName") String dataBaseName);
}
