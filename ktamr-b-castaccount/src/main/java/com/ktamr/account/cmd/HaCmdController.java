package com.ktamr.account.cmd;


import com.alibaba.fastjson.JSON;
import com.ktamr.domain.HaCmd;
import com.ktamr.service.HaCmdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HaCmdController {
    @Resource
    private HaCmdService haCmdService;

//  /datamng/ha_cmd/cmd_add_do
    @RequestMapping(value ="/datamng/ha_cmd/cmd_ajax_get")
    @ResponseBody
    public String cmdajaxget(HaCmd haCmd){
        HaCmd returnID = haCmdService.returnID(haCmd);
        if(returnID!=null){
           if(returnID.getProcessing()==null){
            return returnID.getState()+": ...";
            }else {
            return returnID.getState()+returnID.getProcessing();
            }
        }
        return "失败:找不到命令(" +returnID.getId()+ ")";
    }

    /**
     * 点击小区结算上传的确定按钮
     * @param haCmd
     * @return
     */
    @RequestMapping(value ="/datamng/ha_cmd/cmd_add_do")
    @ResponseBody
    public String amdadddo(HaCmd haCmd){
        //利用三元表达式判断是否有值并赋值进去
     haCmd.setCmd(haCmd.getCmd().length() == 0 ? "<span class='fontRed'>无命令请求</span>" : haCmd.getCmd());
     haCmd.setCentorid(haCmd.getCentorid()!=null?haCmd.getCentorid():0);
        String s = haCmd.getCmd();
        String[] split = haCmd.getCmd().split(":");
        haCmd.setCmd(split[0]);
        int i = s.indexOf(':')+1;
        String s1 = s.substring(i);
        haCmd.setParms(s1);
        HaCmd returnID = haCmdService.returnID(haCmd);
        if(returnID!=null){
            return  "已经存在未完成的相同命令!";
        }else{
            Integer integer = haCmdService.insertHaCmd(haCmd);
            if(integer!=null){
                String s2 = JSON.toJSONString(integer-1);
                return s2;
            }
        }
        return null;
    }


    /**
     * 结算上传时没有选小区
     * @param haCmd
     * @return
     */
    @RequestMapping(value ="/interface_data_upload_do")
    @ResponseBody
    public String uploaddo(HaCmd haCmd){
        haCmd.setCentorid(0);
        HaCmd returnID = haCmdService.returnID(haCmd);
        if(returnID!=null){
            return  "已经存在未完成的相同命令!";
        }else{
            Integer integer = haCmdService.insertHaCmd(haCmd);
            if(integer!=null){
            return "true";
            }
        }
        return "false";
    }
}
