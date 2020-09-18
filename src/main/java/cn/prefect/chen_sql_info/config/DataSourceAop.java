package cn.prefect.chen_sql_info.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author childe  chen
 * @date 2020/9/18
 * @description :
 */
@Aspect
@Component
public class DataSourceAop {
//    //在primary方法前执行
//    @Before("execution(* cn.prefect.chen_sql_info.controller.TableInfoShowController.TableInfoShowFunction(..))")
//    public void setDataSource2test01() {
//        System.err.println("Primary业务");
//        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Primary);
//    }
//
//    //在secondary方法前执行
//    @Before("execution(* cn.prefect.chen_sql_info.controller.TableInfoShowController.TableInfoShowFunction2(..))")
//    public void setDataSource2test02() {
//        System.err.println("Secondary业务");
//        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Secondary);
//    }
}