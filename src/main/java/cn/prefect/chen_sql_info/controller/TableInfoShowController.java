package cn.prefect.chen_sql_info.controller;

import cn.prefect.chen_sql_info.config.DataSourceType;
import cn.prefect.chen_sql_info.config.DynamicDataSource;
import cn.prefect.chen_sql_info.entity.TableInfo;
import cn.prefect.chen_sql_info.service.TableInfoService;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author childe  chen
 * @date 2020/9/17
 * @description :
 */
@Controller
public class TableInfoShowController {

    @Resource
    private TableInfoService tableInfoService;

//    @RequestMapping("/show")
////    @ResponseBody
//    public String TableInfoShowFunction(Model model){
//
//        List<List<TableInfo>> allInfoList = new ArrayList<List<TableInfo>>();
//
//        List<String> allTableList = tableInfoService.allTableList("cust_02");
//
//        allTableList.forEach((a)->{
//            List<TableInfo> infoList = tableInfoService.TableInfoShow(a,"cust_02");
//            infoList.forEach((b)->{
//                if( b.getColumn_remark().equals("")){
//                    b.setColumn_remark("空");
//                }
//            });
//            allInfoList.add(infoList);
//        });
//
//        System.out.println(allTableList.size());
//        System.out.println(allInfoList.size());
//        model.addAttribute("arr",allInfoList);
//        return  "index.html";
//    }

    @RequestMapping("/show")
  @ResponseBody
    public List<String> TableInfoShowFunction(Model model){



        List<String> allTableList = tableInfoService.allTableList2("test");
        return allTableList;

    }

    @RequestMapping("/show2")
  @ResponseBody
    public List<String> TableInfoShowFunction2(Model model){
        List<String> allTableList = tableInfoService.allTableList2("test");
        return allTableList;
    }


    @Bean
    public DynamicDataSource DataSource(@Qualifier("PrimaryDataSource") DataSource primaryDataSource) {

        //这个地方是比较核心的targetDataSource 集合是我们数据库和名字之间的映射
        Map<Object, Object> targetDataSource = new HashMap<>();

        targetDataSource.put(DataSourceType.DataBaseType.Primary, primaryDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();

        dataSource.setTargetDataSources(targetDataSource);

        dataSource.setDefaultTargetDataSource(primaryDataSource);//设置默认对象

        return dataSource;
    }

    // 将这个对象放入Spring容器中
    @Bean(name = "PrimaryDataSource")
    // 表示这个数据源是默认数据源
    @Primary
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
//    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource getDateSource1() {
        //可以在此处调用相关接口获取数据库的配置信息进行 DataSource 的配置
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cust_02?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("PrimaryDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));//设置我们的xml文件路径
        return bean.getObject();
    }



}
