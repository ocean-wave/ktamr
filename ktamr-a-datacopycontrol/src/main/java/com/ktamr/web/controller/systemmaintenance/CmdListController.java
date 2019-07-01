package com.ktamr.web.controller.systemmaintenance;

import com.ktamr.ShiroUtils;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaErrrecord;
import com.ktamr.domain.HaMeterAddr;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.*;
import com.ktamr.service.HaCmdService;
import com.ktamr.service.HaErrrecordService;
import com.ktamr.service.HaMeterAddrService;
import com.ktamr.service.HaRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemmaintenance")
public class CmdListController extends BaseController {
    private  String pxePath = "datamng";

    @Autowired
    private HaCmdService haCmdService;

    @Autowired
    private HaMeterAddrService haMeterAddrService;

    @Autowired
    private HaRecordsService haRecordsService;

    @Autowired
    private HaErrrecordService haErrrecordService;

    @GetMapping("/cmdList")
    public String cmdList(ModelMap mmap){
        return pxePath+"/cmdList";
    }

    @PostMapping("/cmdListJson")
    @ResponseBody
    public Map<String, Object> cmdListJson(HaCmd params){
        startPage();
        params.getParams().put("operatorLevel", ShiroUtils.getHaOperator().getOperatorLevel());
        params.getParams().put("operatorCode", ShiroUtils.getOperatorCode());
        params.getParams().put("operatorCompanyId", ShiroUtils.getHaOperator().getOperatorCompanyId());
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("ce.centorno","area","or"));
        List<HaCmd> listCmd = haCmdService.selectCmdLeftJoinTow(params);
        return getDataTable(listCmd);
    }

    @GetMapping("/cmdResultListShow")
    public String cmdResultListShow(@RequestParam( value = "cmdid") Integer cmdid,
                                    ModelMap mmap){
        HaCmd haCmd = haCmdService.selectCmdById(cmdid);
        mmap.put("sTitle","[命令:"+haCmd.getCmd()+":"+haCmd.getParms()+"]");
        mmap.put("cmdid",cmdid);
        mmap.put("cmdName",haCmd.getCmd());
        return pxePath+"/cmdResultListShow";
    }

    @GetMapping("/htShowlog")
    public String htShowlog(@RequestParam( value = "cmdid",required = false) Integer cmdid,
                            @RequestParam( value = "showPercent",required = false) String showPercent,
                            ModelMap mmap){
        String path =this.getClass().getResource("/").getPath();
        path = path.substring(1,9)+"/ht_runtime.log";
        File file = new File(path);
        BufferedReader reader = null;
        StringBuffer str = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        int line = 1;
        int line2 = 1;
        int strLen = 1;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
            reader = new BufferedReader(isr);
            reader.read();
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                str.append(tempString+"\n");
                line++;
            }
            if("0.1".equals(showPercent)) {
                strLen = ((int)(str.length()*0.1));
                line2 = (int)(line*0.1);
                str2.append(str.substring((int) (str.length() * 0.9)));
            }else if("0.2".equals(showPercent)){
                strLen = ((int)(str.length()*0.2));
                line2 = (int)(line*0.2);
                str2.append(str.substring((int) (str.length() * 0.8)));
            }else if("0.5".equals(showPercent)){
                strLen = ((int)(str.length()*0.5));
                line2 = (int)(line*0.5);
                str2.append(str.substring((int) (str.length() * 0.5)));
            }else{
                strLen = str.length();
                line2 = line;
                str2.append(str.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Float c = Float.parseFloat(showPercent);
        mmap.put("filePath","文件位置:"+path);
        mmap.put("percentage",c == 1.0?"查看全文LOG文件：":"查看最后"+((int)(Float.parseFloat(showPercent)*100))+"%LOG文件：");
        mmap.put("b1","显示内容长度："+strLen+"/ LOG：总长"+str.length()+"");
        mmap.put("b2","共显示:"+(line2)+"行");
        mmap.put("showText",str2.toString());
        return pxePath+"/htShowlog";
    }

    @PostMapping("/cmdResultListShow1Json")
    @ResponseBody
    public Map<String, Object> cmdResultListShow1Json(@RequestParam(value = "cmd",required = false) String cmd
                                                    ,@RequestParam(value = "id",required = false) Integer id){
        startPage();
        if(cmd.equals("读表地址")){
            List<HaMeterAddr> listMeterAddr = haMeterAddrService.selectMeterAddrLeftJoinTow2(id);
            return getDataTable(listMeterAddr);
        }else {
            List<HaErrrecord> listErrrecord = haErrrecordService.selecErrrecordLeftJoinFour(id);
            return getDataTable(listErrrecord);
        }
    }

    @PostMapping("/cmdResultListShow2Json")
    @ResponseBody
    public Map<String, Object> cmdResultListShow2Json(@RequestParam(value = "cmd",required = false) String cmd
                                                     ,@RequestParam(value = "id",required = false) Integer id){
        startPage();
        if(cmd.equals("读表地址")){
            List<HaMeterAddr> listMeterAddr = haMeterAddrService.selectMeterAddrLeftJoinTow(id);
            return getDataTable(listMeterAddr);
        }else{
            List<HaRecords> listRecords = haRecordsService.selectRecordsAndErrrecordTow(id);
            return getDataTable(listRecords);
        }
    }

    @GetMapping("/cmdDelete")
    public String cmdDelete(@RequestParam(value = "cmdids",required = false) String cmdids,ModelMap mmap){
        List<HaCmd> listCmd = new ArrayList<HaCmd>();
        String[] str = cmdids.split(",");
        for(int i =0;i<str.length;i++){
            HaCmd haCmd = haCmdService.selectCmdById(Integer.parseInt(str[i]));
            listCmd.add(haCmd);
        }
        mmap.put("listCmd",listCmd);
        mmap.put("cmdids",cmdids);
        return pxePath+"/cmdDelete";
    }

    @PostMapping("/cmdDeleteAjax")
    @ResponseBody
    public String cmdDeleteAjax(@RequestParam(value = "cmdids",required = false) String cmdids){
        String[] str = cmdids.split(",");
        Integer[] cmdid = new Integer[str.length];
        for (int i =0;i<str.length;i++){
            cmdid[i] = Integer.parseInt(str[i]);
        }
        Integer result = haCmdService.deleteCmdByid(cmdid);
        return "true";
    }

    @GetMapping("/cmdAct")
    public String cmdAct(@RequestParam(value = "cmdids",required = false) String cmdids,ModelMap mmap){
        List<HaCmd> listCmd = new ArrayList<HaCmd>();
        String[] str = cmdids.split(",");
        for(int i =0;i<str.length;i++){
            HaCmd haCmd = haCmdService.selectCmdById(Integer.parseInt(str[i]));
            listCmd.add(haCmd);

        }
        mmap.put("listCmd",listCmd);
        mmap.put("cmdids",cmdids);
        return pxePath+"/cmdAct";
    }

    @PostMapping("/cmdActAjax")
    @ResponseBody
    public String cmdActAjax(@RequestParam(value = "cmdids",required = false) String cmdids,
                             @RequestParam(value = "cmd",required = false) String cmd,
                             @RequestParam(value = "parms",required = false) String parms){
        String[] str = cmdids.split(",");
        Integer[] cmdid = new Integer[str.length];
        if(str.length == 1){
            HaCmd haCmd = haCmdService.selectCmdById(Integer.parseInt(str[0]));
            if(!haCmd.getState().equals("完成") && !haCmd.getState().equals("失败")){
                return "该命令还未完成，不需要再执行";
            }
            if(haCmd.getCmd().equals("修改表底数") && haCmd.getCmd().equals("手工录入单表")){
                return "不支持的命令";
            }
            if(haCmd.getUid().equals("sys")){
                return "系统命令无法手动执行";
            }
            Integer id = haCmdService.insertCmd(Integer.parseInt(str[0]));

            //调用soket
            return "true";
        }
        for (int i =0;i<str.length;i++){
            HaCmd haCmd = haCmdService.selectCmdById(Integer.parseInt(str[i]));
            if((haCmd.getState().equals("完成") || haCmd.getState().equals("失败"))
                    && !haCmd.getCmd().equals("修改表底数") && !haCmd.getCmd().equals("手工录入单表")
                    && !haCmd.getUid().equals("sys")){
                haCmdService.insertCmd(Integer.parseInt(str[i]));

                //调用soket
            }
        }
        return "true";
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaCmd params, ExportExcelUtil exportExcelUtil)
    {
        List<HaCmd> list = null;
        if(params.getParams().get("exportType").equals("1")){
            params.getParams().put("operatorLevel", ShiroUtils.getHaOperator().getOperatorLevel());
            params.getParams().put("operatorCode", ShiroUtils.getOperatorCode());
            params.getParams().put("operatorCompanyId", ShiroUtils.getHaOperator().getOperatorCompanyId());
            params.getParams().put("getRightCondition", SqlCondition.getRightCondition("ce.centorno","area","or"));
            list =  haCmdService.selectCmdLeftJoinTow(params);
            return exportExcelUtil.init(list, "");
        }else{
            list = null;
            return exportExcelUtil.init(list, "");
        }
    }
}
