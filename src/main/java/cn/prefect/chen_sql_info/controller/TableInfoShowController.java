package cn.prefect.chen_sql_info.controller;

import cn.prefect.chen_sql_info.entity.TableInfo;
import cn.prefect.chen_sql_info.service.TableInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author childe  chen
 * @date 2020/9/17
 * @description :
 */
@Controller
public class TableInfoShowController {

    @Resource
    private TableInfoService tableInfoService;

    @RequestMapping("/show")
//    @ResponseBody
    public String TableInfoShowFunction(Model model){

        List<List<TableInfo>> allInfoList = new ArrayList<List<TableInfo>>();

        List<String> allTableList = tableInfoService.allTableList("cust_app");

        allTableList.forEach((a)->{
            List<TableInfo> infoList = tableInfoService.TableInfoShow(a,"cust_app");
            infoList.forEach((b)->{
                if( b.getColumn_remark().equals("")){
                    b.setColumn_remark("空");
                }
            });
            allInfoList.add(infoList);
        });

        System.out.println(allTableList.size());
        System.out.println(allInfoList.size());
        model.addAttribute("arr",allInfoList);
        return  "index.html";
    }

}
