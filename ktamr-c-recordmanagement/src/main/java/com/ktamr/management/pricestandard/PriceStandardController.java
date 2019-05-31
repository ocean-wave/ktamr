package com.ktamr.management.pricestandard;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaFeestandard;
import com.ktamr.domain.HaMetertype;
import com.ktamr.domain.HaPricestandard;
import com.ktamr.service.HaFeestandardService;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaMetertypeService;
import com.ktamr.service.HaPricestandardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/priceStandard")
public class PriceStandardController extends BaseController {

    @Resource
    private HaPricestandardService haPricestandardService;

    @Resource
    private HaMetertypeService haMetertypeService;

    @Resource
    private HaFeestandardService haFeestandardService;

    @Resource
    private HaMeterService haMeterService;

    @RequestMapping("/price_list")
    public String price_list(HaMetertype haMetertype, Model model){
        List<HaMetertype> haMetertypes = haMetertypeService.watchTypeList(haMetertype);
        model.addAttribute("haMetertypes",haMetertypes);
        return "priceStandard/price_list";
    }

    @RequestMapping("/price_add")
    public String price_add(HaMetertype haMetertype,Model model){
        List<HaMetertype> haMetertypes = haMetertypeService.watchTypeList(haMetertype);
        model.addAttribute("haMetertypes",haMetertypes);
        return "priceStandard/price_add";
    }

    @RequestMapping("/price_update")
    public String price_update(HaMetertype haMetertype, HaPricestandard haPricestandard, Model model, Integer priceId){
        List<HaMetertype> haMetertypes = haMetertypeService.watchTypeList(haMetertype);
        haPricestandard.setPricestandId(priceId);
        HaPricestandard haPricestandards = haPricestandardService.updateByIdHaPricestandard(haPricestandard);
        model.addAttribute("haMetertypes",haMetertypes);
        model.addAttribute("haPricestandards",haPricestandards);
        model.addAttribute("priceId",priceId);
        return "priceStandard/price_update";
    }

    @RequestMapping("/fee_add")
    public String fee_add(Model model,String priceId){
        model.addAttribute("priceId",priceId);
        return "priceStandard/fee_add";
    }

    @RequestMapping("/fee_update")
    public String fee_update(HaFeestandard haFeestandard, Model model, Integer feeId){
        haFeestandard.setFeeId(feeId);
        HaFeestandard haFeestandards = haFeestandardService.UpdateByIdHaFeestandard(haFeestandard);
        model.addAttribute("haFeestandards",haFeestandards);
        model.addAttribute("feeId",feeId);
        return "priceStandard/fee_update";
    }

    @RequestMapping("/price_del")
    public String price_del(HaPricestandard haPricestandard,Model model,Integer priceId){
        haPricestandard.setPricestandId(priceId);
        HaPricestandard haPricestandards = haPricestandardService.updateByIdHaPricestandard(haPricestandard);
        model.addAttribute("haPricestandards",haPricestandards);
        model.addAttribute("priceId",priceId);
        return "priceStandard/price_del";
    }

    @RequestMapping("/fee_del")
    public String fee_del(HaFeestandard haFeestandard, Model model,Integer feeId){
        haFeestandard.setFeeId(feeId);
        HaFeestandard haFeestandards = haFeestandardService.UpdateByIdHaFeestandard(haFeestandard);
        model.addAttribute("haFeestandards",haFeestandards);
        model.addAttribute("feeId",feeId);
        return "priceStandard/fee_del";
    }

    @RequestMapping("/priceListJson")
    @ResponseBody
    public Object pricelistjson(HaPricestandard haPricestandard){
        startPage();
        List<HaPricestandard> haPricestandardsList = haPricestandardService.HaPricestandardList(haPricestandard);
        Map<String, Object> map = getDataTable(haPricestandardsList);
        return map;
    }

    @RequestMapping("/queryHaFeestandard")
    @ResponseBody
    public Object queryhafeestandard(HaFeestandard haFeestandard){
//        haFeestandard.setPricestandid(1);
        List<HaFeestandard> haFeestandards = haFeestandardService.HaFeestandardList(haFeestandard);
        if(haFeestandards!=null){
            return haFeestandards;
        }
        return null;
    }

    @RequestMapping("/AddHaFeestandard")
    @ResponseBody
    public Object addHaFeestandard(HaFeestandard haFeestandard,String name){
        Integer addHaFeestandard = haFeestandardService.addHaFeestandard(haFeestandard);
        if(addHaFeestandard==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/AddPricestandard")
    @ResponseBody
    public Object addPricestandard(HaPricestandard haPricestandard){
        haPricestandard.setCreateTime(new Date());
        haPricestandard.setModifyTime(new Date());
        Integer addPricestandard = haPricestandardService.addHaPricestandard(haPricestandard);
        if(addPricestandard==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/UpdatePricestandard")
    public  @ResponseBody Object updatePricestandard(HaPricestandard haPricestandard){
        Integer updateHaPricestandard = haPricestandardService.updateHaPricestandard(haPricestandard);
        if(updateHaPricestandard==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/UpdateHaFeestandard")
    @ResponseBody
    public Object updateHaFeestandard(HaFeestandard haFeestandard){
        Integer haFeestandards = haFeestandardService.updateHaFeestandard(haFeestandard);
        if(haFeestandards==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeletePricestandard")
    @ResponseBody
    public Object deletePricestandard(HaPricestandard haPricestandard){
        Integer priceUsed = haMeterService.isPriceUsed(haPricestandard.getPricestandId());
        if(priceUsed==0){
            Integer haPricestandards = haPricestandardService.deleteHaPricestandard(haPricestandard);
            if(haPricestandards==1){
                return "true";
            }
        }else{
            return "false";
        }
        return null;
    }

    @RequestMapping("/DeleteHaFeestandard")
    @ResponseBody
    public Object deleteHaFeestandard(HaFeestandard haFeestandard){
        Integer haFeestandards = haFeestandardService.deleteHaFeestandard(haFeestandard);
        if(haFeestandards==1){
            return "true";
        }
        return "false";
    }

}
