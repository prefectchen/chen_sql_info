package cn.prefect.chen_sql_info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(value = "cn.prefect.chen_sql_info.dao.**")
public class ChenSqlInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChenSqlInfoApplication.class, args);
    }

}
