package com.ktamr.service.impl;

import com.ktamr.domain.HaImportcustom;
import com.ktamr.domain.HaMetertype;
import com.ktamr.domain.HaPricestandard;
import com.ktamr.mapper.HaImportCustomMapper;
import com.ktamr.service.HaImportCustomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HaImportCustomServiceImpl implements HaImportCustomService {

    @Resource
    private HaImportCustomMapper haImportCustomMapper;

    @Override
    public List<HaImportcustom> HaImportcustomList(HaImportcustom haImportcustom) {
        return haImportCustomMapper.HaImportcustomList(haImportcustom);
    }

    @Override
    public Integer addImportCustom(List<Map<String, Object>> params) {
        return haImportCustomMapper.addImportCustom(params);
    }

    @Override
    public Integer deleteImportCustom(HaImportcustom haImportcustom) {
        return haImportCustomMapper.deleteImportCustom(haImportcustom);
    }

    @Override
    public Integer checkCustomTemporary(HaImportcustom haImportcustom) {
        return haImportCustomMapper.checkCustomTemporary(haImportcustom);
    }

    @Override
    public Integer collationData(HaImportcustom haImportcustom) {
        return haImportCustomMapper.collationData(haImportcustom);
    }

    @Override
    public Integer customAddrCheck1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck1(haImportcustom);
    }

    @Override
    public Integer customAddrCheck2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck2(haImportcustom);
    }

    @Override
    public Integer customAddrCheck3(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck3(haImportcustom);
    }

    @Override
    public Integer customAddrCheck4(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck4(haImportcustom);
    }

    @Override
    public Integer customAddrCheck5(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck5(haImportcustom);
    }

    @Override
    public Integer customAddrCheck6(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck6(haImportcustom);
    }

    @Override
    public Integer customAddrCheck7(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck7(haImportcustom);
    }

    @Override
    public Integer customAddrCheck8(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customAddrCheck8(haImportcustom);
    }

    @Override
    public Integer customNoCheck1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customNoCheck1(haImportcustom);
    }

    @Override
    public Integer customNoCheck2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customNoCheck2(haImportcustom);
    }

    @Override
    public Integer customNoCheck3(HaImportcustom haImportcustom) {
        return haImportCustomMapper.customNoCheck3(haImportcustom);
    }

    @Override
    public Integer meterNumCheck1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.meterNumCheck1(haImportcustom);
    }

    @Override
    public Integer meterNumCheck2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.meterNumCheck2(haImportcustom);
    }

    @Override
    public Integer meterNumCheck3(HaImportcustom haImportcustom) {
        return haImportCustomMapper.meterNumCheck3(haImportcustom);
    }

    @Override
    public Integer centorCollectorCheck1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.centorCollectorCheck1(haImportcustom);
    }

    @Override
    public Integer centorCollectorCheck2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.centorCollectorCheck2(haImportcustom);
    }

    @Override
    public Integer centorCollectorCheck3(HaImportcustom haImportcustom) {
        return haImportCustomMapper.centorCollectorCheck3(haImportcustom);
    }

    @Override
    public Integer meterTypeCheck1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.meterTypeCheck1(haImportcustom);
    }

    @Override
    public Integer meterTypeCheck2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.meterTypeCheck2(haImportcustom);
    }

    @Override
    public Integer chargeTypeCheck1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.chargeTypeCheck1(haImportcustom);
    }

    @Override
    public Integer chargeTypeCheck2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.chargeTypeCheck2(haImportcustom);
    }

    @Override
    public Integer serialNumber1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.serialNumber1(haImportcustom);
    }

    @Override
    public Integer serialNumber2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.serialNumber2(haImportcustom);
    }

    @Override
    public Integer serialNumber3(HaImportcustom haImportcustom) {
        return haImportCustomMapper.serialNumber3(haImportcustom);
    }

    @Override
    public Integer serialNumber4(HaImportcustom haImportcustom) {
        return haImportCustomMapper.serialNumber4(haImportcustom);
    }

    @Override
    public Integer checkAddOrUpdate1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.checkAddOrUpdate1(haImportcustom);
    }

    @Override
    public Integer checkAddOrUpdate2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.checkAddOrUpdate2(haImportcustom);
    }

    @Override
    public Integer checkAddOrUpdate3(HaImportcustom haImportcustom) {
        return haImportCustomMapper.checkAddOrUpdate3(haImportcustom);
    }

    @Override
    public Integer checkAddOrUpdate4(HaImportcustom haImportcustom) {
        return haImportCustomMapper.checkAddOrUpdate4(haImportcustom);
    }

    @Override
    public HaPricestandard tpriceStandard() {
        return haImportCustomMapper.tpriceStandard();
    }

    @Override
    public HaMetertype tmeterType(String tpriceStandard) {
        return haImportCustomMapper.tmeterType(tpriceStandard);
    }

    @Override
    public Integer completeAddDefaultValues(String tmeterType, String tpriceStandard, HaImportcustom haImportcustom) {
        return haImportCustomMapper.completeAddDefaultValues(tmeterType,tpriceStandard,haImportcustom);
    }

    @Override
    public Integer completeAddDefaultValues2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.completeAddDefaultValues2(haImportcustom);
    }

    @Override
    public Integer queryAllHaImportCustomCount(HaImportcustom haImportcustom) {
        return haImportCustomMapper.queryAllHaImportCustomCount(haImportcustom);
    }

    @Override
    public Integer addsCount(HaImportcustom haImportcustom) {
        return haImportCustomMapper.addsCount(haImportcustom);
    }

    @Override
    public Integer updsCount(HaImportcustom haImportcustom) {
        return haImportCustomMapper.updsCount(haImportcustom);
    }

    @Override
    public Integer addRoomByExport1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.addRoomByExport1(haImportcustom);
    }

    @Override
    public Integer addRoomByExport2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.addRoomByExport2(haImportcustom);
    }

    @Override
    public Integer addCustomByExport1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.addCustomByExport1(haImportcustom);
    }

    @Override
    public Integer addCustomByExport2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.addCustomByExport2(haImportcustom);
    }

    @Override
    public Integer updateMeterRoomByExport1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.updateMeterRoomByExport1(haImportcustom);
    }

    @Override
    public Integer updateMeterRoomByExport2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.updateMeterRoomByExport2(haImportcustom);
    }

    @Override
    public Integer addMeterByExport(HaImportcustom haImportcustom) {
        return haImportCustomMapper.addMeterByExport(haImportcustom);
    }

    @Override
    public Integer updateMeterByExport1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.updateMeterByExport1(haImportcustom);
    }

    @Override
    public Integer updateMeterByExport2(HaImportcustom haImportcustom) {
        return haImportCustomMapper.updateMeterByExport2(haImportcustom);
    }

    @Override
    public Integer updateCustomByExport1(HaImportcustom haImportcustom) {
        return haImportCustomMapper.updateCustomByExport1(haImportcustom);
    }

    @Override
    public Integer updateCustomByExport2(String fileName, String operatorCode, String msg) {
        return haImportCustomMapper.updateCustomByExport2(fileName,operatorCode,msg);
    }
}
