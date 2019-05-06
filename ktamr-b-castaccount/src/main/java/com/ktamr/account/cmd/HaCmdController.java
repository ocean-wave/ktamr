package com.ktamr.account.cmd;


import com.alibaba.fastjson.JSON;
import com.ktamr.domain.HaCmd;
import com.ktamr.service.HaCmdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HaCmdController {
    @Resource
    private HaCmdService haCmdService;

//  /datamng/ha_cmd/cmd_add_do
    @RequestMapping(value ="/datamng/ha_cmd/cmd_ajax_get")
    @ResponseBody
    public String cmdajaxget(HaCmd haCmd){
        List<HaCmd> returnID = haCmdService.BreturnID(haCmd);
        if(returnID.size()>0){
           if(returnID.get(0).getProcessing()==null){
            return returnID.get(0).getState()+": ...";
            }else {
            return returnID.get(0).getState()+returnID.get(0).getProcessing();
            }
        }
        return "失败:找不到命令(" +returnID.get(0).getId()+ ")";
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
        haCmd.setCentorId(haCmd.getCentorId()!=null?haCmd.getCentorId():0);
        String s = haCmd.getCmd();
        String[] split = haCmd.getCmd().split(":");
        haCmd.setCmd(split[0]);
        int i = s.indexOf(':')+1;
        String s1 = s.substring(i);
        haCmd.setParms(s1);
        List<HaCmd> returnID = haCmdService.BreturnID(haCmd);
        if(returnID.size()>0){
            return  "已经存在未完成的相同命令!";
        }else{
            Integer integer = haCmdService.BinsertHaCmd(haCmd);
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
        haCmd.setCentorId(0);
        List<HaCmd> returnID = haCmdService.BreturnID(haCmd);
        if(returnID.size()>0){
            return  "已经存在未完成的相同命令!";
        }else{
            Integer integer = haCmdService.BinsertHaCmd(haCmd);
            if(integer!=null){
            return "true";
            }
        }
        return "false";
    }
}
