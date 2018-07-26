package com.sqlBuildUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.sqlBuildUtil.vo.ChnBizCircleVo;

public class TestMain {
    public static void main(String[] args ) throws IllegalAccessException, NoSuchFieldException {
        System.out.println("-------------");
        DOMConfigurator.configure("src/main/resources/config/log4j.xml");
        ChnBizCircleVo vo=new ChnBizCircleVo();
        Logger log=Logger.getLogger(vo.getClass());

        vo.setCircleId("12");
        vo.setCircleCode("QDBJ3468339");
        vo.setCircleName("月湖区核心商圈");
        vo.setLanId("791");
        vo.setRegionId("7913");
        vo.setStaus("00X");
        vo.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        log.info(vo.update());
        log.info(vo.select());
        log.info(vo.delete());
        log.info(vo.insert());
        ChnBizCircleVo vo2=new ChnBizCircleVo();
        Map<String,String> param=new HashMap<String,String>();
        param.put("circleId","22");
        param.put("circleCode","QDBJ567899");
        param.put("circleName","P大军阀uuuf");
        param.put("lanId","789");
        param.put("regionId","7789333");
        vo2.readFromMap(param,false);
        log.info(vo2.toString());
        ChnBizCircleVo vo3=new ChnBizCircleVo();
        Map<String,String> param2=new HashMap<String,String>();
        param2.put("circle_id","22");
        param2.put("circle_code","QDBJ567899");
        param2.put("circle_name","P大军阀uuuf");
        param2.put("lan_id","789");
        param2.put("region_id","7789333");
        vo3.readFromMap(param2,true);
        log.info(vo3.toString());
    }
}
