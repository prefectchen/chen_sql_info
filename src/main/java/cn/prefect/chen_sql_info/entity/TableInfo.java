package cn.prefect.chen_sql_info.entity;

import lombok.*;

/**
 * @author childe  chen
 * @date 2020/9/17
 * @description : 表信息实体类
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TableInfo {
    private Integer id;
    private String table_name;
    private String column_name;
    private String column_type;
    private String column_remark;


}
