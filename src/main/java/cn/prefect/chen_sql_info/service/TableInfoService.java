package cn.prefect.chen_sql_info.service;

import cn.prefect.chen_sql_info.entity.TableInfo;

import java.util.List;

public interface TableInfoService {
    public List<TableInfo>TableInfoShow(String tableName,String dataBaseName);

    List<String> allTableList(String dataBaseName);

    List<String> allTableList2(String dataBaseName);
}
