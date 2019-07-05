package com.ktamr.management.area;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.export.ExcelUtil;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.*;
import com.ktamr.service.*;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.shiro.util.StringUtils.split;

@Controller
@RequestMapping("/room")
public class RoomController extends BaseController {

    @Resource
    private HaRoomService haRoomService;

    @Resource
    private HaCollectorService haCollectorService;

    @Resource
    private HaCentorService haCentorService;

    @Resource
    private HaPricestandardService haPricestandardService;

    @Resource
    private HaMeterService haMeterService;

    @Resource
    private HaDayFreezeService haDayFreezeService;

    @Resource
    private HaMonFreezeService haMonFreezeService;

    @Resource
    private HavMeterinfoService havMeterinfoService;

    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaReplaceRecordsService haReplaceRecordsService;

    @Resource
    private HaCmdService haCmdService;

    @RequestMapping("/JumpRoomMeterAdd")
    public String JumpRoomMeterAdd(String cmdName, Integer buildingId, Model model) {
        List<HaPricestandard> haPricestandardList = haPricestandardService.PriceStandardGenOptionSelected();
        model.addAttribute("haPricestandardList", haPricestandardList);
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("buildingId", buildingId);
        return "area/room_meter_add";
    }

    @RequestMapping("/JumpRoomMeterDel")
    public String JumpRoomMeterDel(Integer meterId, Integer roomId, Model model) {
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        HaRoom room = haRoomService.delByIdHaRoom(haRoom);
        HaMeter haMeter = new HaMeter();
        haMeter.setMeterId(meterId);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);
        HaPricestandard haPricestandards = haPricestandardService.queryPName(meter.getPricestandId());
        model.addAttribute("room", room);
        model.addAttribute("meter", meter);
        model.addAttribute("haPricestandards", haPricestandards);
        model.addAttribute("meterId", meterId);
        return "area/room_meter_del";
    }

    @RequestMapping("/JumpRoomMeterUpdate")
    public String JumpRoomMeterUpdate(Integer roomId, Integer meterId, Model model, HaCentor haCentor,HaCollector haCollector) {
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        HaRoom room = haRoomService.delByIdHaRoom(haRoom);
        HaMeter haMeter = new HaMeter();
        haMeter.setMeterId(meterId);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);

        HaPricestandard haPricestandards = haPricestandardService.queryPName(meter.getPricestandId());
        List<HaPricestandard> pricestandards = haPricestandardService.queryPriceStandardList();
        HaRoom byHaRoomAreaId = haRoomService.getByHaRoomAreaId(roomId);
        HaRoom byHaRoomBuildingId = haRoomService.getByHaRoomBuildingId(roomId);
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        HaCentor centor = haCentorService.updateByDeviceType(meter.getCentorId());
        //查询所对应的全部集采器信息
        haCentor.setDeviceType(centor.getDeviceType());
        haCentor.getParams().put("getRightCondition", SqlCondition.getRightCondition("centorNo", "centor", "and"));
        List<HaCentor> haCentors = haCentorService.DeviceByWhere(haCentor);
        haCollector.setCentorId(meter.getCentorId());
        haCollector.setCollectorId(meter.getCollectorId());
        List<HaCollector> haCollectors = haCollectorService.CollectorByWhere(haCollector);
        model.addAttribute("room", room);
        model.addAttribute("meter", meter);
        model.addAttribute("haPricestandards", haPricestandards);
        model.addAttribute("meterId", meterId);
        model.addAttribute("roomId", roomId);
        model.addAttribute("pricestandard", pricestandards);
        model.addAttribute("byHaRoomAreaId", byHaRoomAreaId);
        model.addAttribute("byHaRoomBuildingId", byHaRoomBuildingId);
        model.addAttribute("haArea", haArea);
        model.addAttribute("centor", centor);
        model.addAttribute("haCentors", haCentors);
        model.addAttribute("haCollectors", haCollectors);
        return "area/room_meter_update";
    }

    @RequestMapping("/JumpRoomDel")
    public String JumpRoomDel(Integer roomId, Model model) {
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        HaRoom room = haRoomService.delByIdHaRoom(haRoom);
        Integer countNum = haMeterService.meterCountNum(roomId);
        model.addAttribute("room", room);
        model.addAttribute("roomId", roomId);
        model.addAttribute("countNum", countNum);
        return "area/room_del";
    }

    @RequestMapping("/QueryAllRoomJson")
    @ResponseBody
    public Object queryAllRoomJson(HaRoom haRoom) {
        startPage();
        haRoom.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areaNo","area","AND"));
        List<HaRoom> allRoom = haRoomService.queryAllRoomC(haRoom);
        Map<String, Object> map = getDataTable(allRoom);
        return map;
    }

    @RequestMapping("/rowIdMeter")
    @ResponseBody
    public Object rowIdMeter(HaMeter haMeter,String rowId){
        startPage();
        String[] rowIds = split(rowId);
        for(int i=0;i<rowIds.length;i++){
            String rowId1 = rowIds[i];
            haMeter.setMeterId(Integer.valueOf(rowId1));
            List<HaMeter> rowIdMeter = haMeterService.getRowIdMeter(haMeter);
            Map<String, Object> map = getDataTable(rowIdMeter);
            return map;
        }
        return null;
    }

    @RequestMapping("/LoadDeviceOption")
    @ResponseBody
    public Object loadDeviceOption(String deviceType, Integer deviceId) {
        if (deviceId != null) {
            List<HaCollector> collectorByDeviceId = haCollectorService.collectorByDeviceId(deviceId);
            return collectorByDeviceId;
        } else {
            if (deviceType.equals("centor")) {
                List<HaCentor> centors = haCentorService.deviceTypeCentor();
                return centors;
            } else if (deviceType.equals("ccentor")) {
                List<HaCentor> ccentors = haCentorService.deviceTypeCcentor();
                return ccentors;
            } else if (deviceType.equals("handDevice")) {
                List<HaCentor> handDevice = haCentorService.deviceTypehandDevice();
                return handDevice;
            }
        }
        return null;
    }

    @RequestMapping("/RoomMeterAdd")
    @ResponseBody
    public Object roomMeterAdd(HaRoom haRoom, HaMeter haMeter) {
        Integer addHaRoomC = haRoomService.addHaRoomC(haRoom);
        if (addHaRoomC == 1) {
            HaRoom lastId = haRoomService.getLastId();
            haMeter.setRoomId(lastId.getRoomId());
            Integer addHaMeter = haMeterService.addHaMeter(haMeter);
            return "true";
        }
        return "false";
    }

    @RequestMapping("/RoomMeterDel")
    @ResponseBody
    public Object roomMeterDel(Integer meterId, HaMeter haMeter) {
        haMeter.setMeterId(meterId);
        Integer meter = haMeterService.deleteHaMeter(haMeter);
//        Integer dayFreeze = haDayFreezeService.delHaDayFreeze(meterId);
//        Integer monFreeze = haMonFreezeService.delHaMonFreeze(meterId);
        if (meter == 1) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/RoomDel")
    @ResponseBody
    public Object roomDel(Integer roomId) {
        Integer roomC = haRoomService.deleteHaRoomC(roomId);
        if (roomC == 1) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/ChangeForm")
    @ResponseBody
    public Object changeForm(HavMeterinfo havMeterinfo) {
        startPage();
        List<HavMeterinfo> havMeterinfos = havMeterinfoService.changeFormByAreaId(havMeterinfo);
        Map<String, Object> map = getDataTable(havMeterinfos);
        return map;
    }

    @RequestMapping("/UpdateRoom")
    @ResponseBody
    public Object updateRoom(String opType, @Param("meterId") Integer meterId, Integer centorId, Integer collectorId, Integer meterNumber,float pnumber,@Param("selMeterId") Integer selMeterId, HaRoom haRoom, HaMeter haMeter, HttpSession session) {
        Object centorDevNo = null;
        Object mMeterSequences = null;
        Object nconf = null;
        String operatorCode = (String)session.getAttribute("operatorCode");
        if (opType.equals("updateMeter")) {
            Integer haRoomC = haRoomService.updateHaRoomC(haRoom);
            if (centorId == null) {
                centorDevNo=("X");
                centorId = null;
            } else {
                HaCentor haCentor = haCentorService.centorDevNo(centorId);
                centorDevNo = haCentor.getCentorId();
                HaCentor centorDevDescription = haCentorService.centorDevDescription(centorId);
                if (centorDevDescription.getDescription().substring(0, 5).equals("KT4EW")) {
                    mMeterSequences = haMeterService.mMeterSequence(meterId);
                    if (((HaMeter) mMeterSequences).getMeterSequence() == 0) {
                        mMeterSequences = haMeterService.mMeterSequence2(centorId, centorId);
                        if (mMeterSequences.equals("") || mMeterSequences.equals(0)) {
                            mMeterSequences.equals(1);
                        } else if (((HaMeter) mMeterSequences).getMeterSequence() - 0 > 65535) {
                            mMeterSequences = null;
                        }
                    }
                }
            }
            if (collectorId == null || collectorId == -1) {
                nconf=("X");
                collectorId = null;
            } else {
                nconf = haCollectorService.getNconf(collectorId);
            }
            String addr = centorDevNo.toString() + nconf + meterNumber;
            haMeter.setAddr(addr);
            haMeter.setMeterNumber(meterNumber);
            haMeter.setMeterId(meterId);
            Integer meter = haMeterService.updateHaMeter(haMeter);

            HaMeter orIgNumbers = haMeterService.orIgNumber(meterId);
            HaMeter orImeterNumbers = haMeterService.orImeterNumber(meterId);
            double orIgNumber = orIgNumbers.getGnumber();
            long orImeterNumber = orImeterNumbers.getMeterNumber();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String setupTime = sdf.format(haMeter.getStartTime());
            if(pnumber!=orIgNumber){
                haReplaceRecordsService.addHaReplaceRecords(orImeterNumber,orIgNumber,operatorCode,meterId);
                haMeterService.noCheck(meterId);
                haMeterService.checkButNoSettlement(setupTime,orImeterNumber,pnumber,meterId);
                haCmdService.addHaCmdMeter(meterNumber,operatorCode,orIgNumber,pnumber);
            }
            if (haRoomC == 1 && meter == 1) {
                return "true";
            }
            return false;
        } else if (opType.equals("changeMeter")) {
            Integer haRoomC = haRoomService.updateHaRoomC(haRoom);
            if (haRoomC == 1) {
                if(haMeter.getMeterId()!=null){
                    Integer updateNullRoomId = haMeterService.updateNullRoomId(haMeter.getMeterId());
                }else {
                    Integer updateNullRoomId2 = haMeterService.updateNullRoomId2(haMeter.getRoomId(), haMeter.getAreaId(), selMeterId);
                }
                return "true";
            }else {
                return false;
            }
        }
        return null;
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping("/CustomerExport")
    @ResponseBody
    public void customerExport(HttpServletRequest request, HttpServletResponse response, Integer areaId) throws Exception {
        List<HaRoom> rooms = haRoomService.customExport(areaId);

        //excel标题
        String[] title = {"用户编号", "*用户名称", "小区名称", "楼栋名称", "房间名称", "表号", "*表通道号", "*表序号", "*厂商码", "所属集中器编号", "所属采集器地址", "*表类型", "*总分表", "表底数", "*装表时间", "收费类型", "*倍率", "*性别", "*手机号码", "*账户余额"};

        //excel文件名
        String fileName = "kt-userTable" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "sheet1";

        String[][] content = new String[rooms.size()][];
        for (int i = 0; i < rooms.size(); i++) {
            content[i] = new String[title.length];
            HaRoom obj = rooms.get(i);
            try {
                content[i][0] = obj.getHaCustom().getCustNo(); //用户编号
            } catch (Exception e) {
                e.printStackTrace();
                content[i][0] = "";
            }
            try {
                content[i][1] = obj.getHaCustom().getName(); //用户名称
            } catch (Exception e) {
                e.printStackTrace();
                content[i][1] = "";
            }
            content[i][2] = obj.getHaArea().getHaName(); //小区名称
            content[i][3] = obj.getHaBuilding().getName(); //楼栋名称
            content[i][4] = obj.getName(); //房间名称
            try {
                content[i][5] = String.valueOf(obj.getHaMeter().getMeterNumber()); //表号
            } catch (Exception e) {
                e.printStackTrace();
                content[i][5] = "";
            }
            try {
                content[i][6] = obj.getHaMeter().getMeterChannel().toString(); //表通道号
            } catch (Exception e) {
                e.printStackTrace();
                content[i][6] = "";
            }
            try {
                content[i][7] = obj.getHaMeter().getMeterSequence().toString(); //表序号
            } catch (Exception e) {
                e.printStackTrace();
                content[i][7] = "";
            }
            try {
                content[i][8] = String.valueOf(obj.getHaMeter().getVendorId()); //厂商码
            } catch (Exception e) {
                e.printStackTrace();
                content[i][8] = "";
            }
            try {
                content[i][9] = obj.getHaCentor().getCentorNo(); //所属集中器编号
            } catch (Exception e) {
                e.printStackTrace();
                content[i][9] = "";
            }
            try {
                content[i][10] = obj.getHaCollector().getNconf().toString(); //所属采集器地址
            } catch (Exception e) {
                e.printStackTrace();
                content[i][10] = "";
            }
            try {
                content[i][11] = obj.getHaMetertype().getName(); //表类型
            } catch (Exception e) {
                e.printStackTrace();
                content[i][11] = "";
            }
            try {
                content[i][12] = String.valueOf(obj.getHaMeter().getIsBranch()); //总分表
            } catch (Exception e) {
                e.printStackTrace();
                content[i][12] = "";
            }
            try {
                content[i][13] = String.valueOf(obj.getHaMeter().getGnumber()); //表底数
            } catch (Exception e) {
                e.printStackTrace();
                content[i][13] = "";
            }
            try {
                content[i][14] = String.valueOf(obj.getHaMeter().getStartTime()); //装表时间
            } catch (Exception e) {
                e.printStackTrace();
                content[i][14] = "";
            }

            try {
                content[i][15] = obj.getHaPricestandard().getName(); //收费类型
            } catch (Exception e) {
                e.printStackTrace();
                content[i][15] = "";
            }
            try {
                content[i][16] = String.valueOf(obj.getHaMeter().getRate()); //倍率
            } catch (Exception e) {
                e.printStackTrace();
                content[i][16] = "";
            }
            try {
                content[i][17] = obj.getHaCustom().getSex(); //性别
            } catch (Exception e) {
                e.printStackTrace();
                content[i][17] = "";
            }
            try {
                content[i][18] = obj.getHaCustom().getMobil(); //手机号码
            } catch (Exception e) {
                e.printStackTrace();
                content[i][18] = "";
            }
            try {
                content[i][19] = String.valueOf(obj.getHaCustom().getBalance()); //余额
            } catch (Exception e) {
                e.printStackTrace();
                content[i][19] = "";
            }
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加时验证楼栋名字
     * @param haRoom
     * @return
     */
    @RequestMapping("/addingCellValidation")
    @ResponseBody
    public String addingCellValidation(HaRoom haRoom){
        Integer addingCellValidation = haRoomService.addingCellValidation(haRoom);
        if(addingCellValidation==1){
            return "True";
        }
        return "false";
    }

}
