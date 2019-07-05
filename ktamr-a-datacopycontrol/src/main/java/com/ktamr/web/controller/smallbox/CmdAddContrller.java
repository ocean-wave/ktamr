package com.ktamr.web.controller.smallbox;

import com.ktamr.common.utils.StringUtils;
import com.ktamr.httpClient.Client;
import com.ktamr.service.HaCmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/smallbox/haCmd")
public class CmdAddContrller {
    @Autowired
    private HaCmdService haCmdService;

    @Autowired
    private Client client;

    @PostMapping("/cmdAdd")
    @ResponseBody
    public String metersMng(@RequestParam( value = "cmd", required = false) String cmd,
                            @RequestParam( value = "centorid", required = false) String centorid){
        String str = "";
        String cmds[] = cmd.split(":");
        String parms = cmd.substring(cmd.indexOf(":")+1);
        if(StringUtils.isEmpty(cmd)){
            return "<span class='fontRed'>无命令请求</span>";
        }
        if(cmds != null && cmds.length <= 1){
            return "<span class='fontRed'>参数格式不正确</span>";
        }
        Integer id = haCmdService.selectCmdId(cmd,centorid);
        if(id != null){
            return "<span class='fontRed'>已经存在未完成的相同命令!</span>";
        }else{
            if (centorid == "" && (cmds[0].equals("单表抄表") || cmds[0].equals("开阀") || cmds[0].equals("关阀"))){
                return "<span class='fontRed'>centorid 等于null值</span>";
            }
            try {
                str = haCmdService.insertCmd(cmd,centorid).toString();
            }catch (Exception e){
                return "<span class='fontRed'>sql语句插入失败</span>";
            }
        }
        try {
            if ("接口数据上传".equals(cmds[0])) {
                return client.httpClient(str) ? "ok" : "no";
            } else {
                if (client.httpClient(cmds[0], parms)) {
                    if (centorid != "") {
                        String centorStr = haCmdService.selectCentorById(Integer.parseInt(centorid));
                        if (centorStr.substring(0, 5).equals("KT3NB")) {
                            return "<span class='fontGrey'>预执行命令</span>";
                        }
                    }
                    return str;
                }
            }
        }catch (Exception e){
            return "<span class='fontRed'>后台服务未启动</span>";
        }
        return "<span class='fontRed'>返回值不是ok,请联系管理员</span>";
    }
    @GetMapping("/getCmdAjax")
    @ResponseBody
    public String getCmdAjax(@RequestParam( value = "cmdid", required = false) Integer cmdid){
        String str= "";
        Map<String,Object> m = haCmdService.selectCmdParmsById(cmdid);
        if(m.size()>0){
            if(StringUtils.isNull(m.get("processing"))){
                str = m.get("state").toString()+":  ...";
            }else{
                str = m.get("state").toString() +": "+m.get("processing");
            }
        }else{
            str = "失败:找不到命令("+cmdid.toString()+")";
        }
        return str;
    }
}
