package cn.prefect.chen_sql_info.service;

import cn.prefect.chen_sql_info.dao.TableinfoDaoMapper;
import cn.prefect.chen_sql_info.entity.TableInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author childe  chen
 * @date 2020/9/17
 * @description :
 */
@Service
public class TableInfoServiceImpl implements TableInfoService {

    @Resource
    private TableinfoDaoMapper tableinfoDaoMapper;

    @Override
    public List<TableInfo> TableInfoShow(String tableName, String dataBaseName) {
        return tableinfoDaoMapper.TableInfoShow(tableName,dataBaseName);
    }

    @Override
    public List<String> allTableList(String dataBaseName) {
        return tableinfoDaoMapper.allTableList(dataBaseName);
    }

    @Override
    public List<String> allTableList2(String dataBaseName) {
        return tableinfoDaoMapper.allTableList2(dataBaseName);
    }
}
