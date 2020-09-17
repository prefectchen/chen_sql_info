package cn.prefect.chen_sql_info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "cn.prefect.chen_sql_info.dao.TableinfoDaoMapper")
public class ChenSqlInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChenSqlInfoApplication.class, args);
    }

}
