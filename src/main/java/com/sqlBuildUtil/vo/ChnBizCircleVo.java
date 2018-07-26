package com.sqlBuildUtil.vo;

import com.sqlBuildUtil.annotation.TableField;
import com.sqlBuildUtil.annotation.TableName;
import com.sqlBuildUtil.annotation.TablePKField;
import com.sqlBuildUtil.sqlbuilder.BaseVo;
import com.sqlBuildUtil.sqlbuilder.IVO;

/**
 * TableName表名注解，table表名，fieldNameConver是否需要驼峰命名转换成下划线命名
 */
@TableName(table = "chn_biz_circle",fieldNameConvert = true)
public class ChnBizCircleVo extends BaseVo implements IVO {

    @TablePKField
    public String circleId;

    @TableField
    public String circleCode;

    @TableField
    public String circleName;

    @TableField
    public String lanId;

    @TableField
    public String regionId;

    /**
     * type=TYPE_DATE日期格式，dateFormat日期格式化方式
     */
    @TableField(type = TableField.TYPE_DATE,dateFormat = TableField.DATE_FORMAT_DD)
    public String createDate;

    @TableField
    public String staus;

    public ChnBizCircleVo(){
        setSelf();
    }
    public void setSelf() {
        self=this;
    }

    public String getCircleCode() {
        return circleCode;
    }

    public void setCircleCode(String circleCode) {
        this.circleCode = circleCode;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getLanId() {
        return lanId;
    }

    public void setLanId(String lanId) {
        this.lanId = lanId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    @Override
    public String toString() {
        return "ChnBizCircleVo{" +
                "circleId='" + circleId + '\'' +
                ", circleCode='" + circleCode + '\'' +
                ", circleName='" + circleName + '\'' +
                ", lanId='" + lanId + '\'' +
                ", regionId='" + regionId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", staus='" + staus + '\'' +
                '}';
    }
}
