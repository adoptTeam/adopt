package com.adopt.littlepet.model;

import com.cdg.common.constant.ToolsConstants;
import com.cdg.common.utils.DateUtils;
import com.cdg.db.pet.model.AdoptLittlePet;
import org.springframework.util.StringUtils;
/**
 * @author huayu
 * @date 2018/4/18 下午2:10
 */
public class LittlePetViewModel extends AdoptLittlePet{
    private String strSex;
    private String strBirthControl;
    private String[] photo;
    private String age;
    private String strVaccineTime;
    private String[] arrayComments;
    private String strCreateTime;
    private String strBirthDay;

    public String getStrBirthDay() {
        return DateUtils.longToDateString(this.birthday);
    }
    public String getStrSex() {
        strSex = this.sex == 0 ? "雌性" : "雄性";
        return strSex;
    }

    public String getStrBirthControl() {
        strBirthControl = this.birthControl == 1 ? "已绝育" : "未绝育";
        return strBirthControl;
    }

    public String[] getPhoto() {
        if (StringUtils.isEmpty(headPortraits)) {
            return null;
        }
        photo = headPortraits.split(ToolsConstants.SPLIT_SEPARATOR);
        return photo;
    }

    public String getAge() {
        long now = System.currentTimeMillis();
        int years = DateUtils.getYearsDiff(now, this.birthday);
        int months = DateUtils.getMonthsAfterYears(now, this.birthday);
        age = years + "岁";
        if (months != 0) {
            age = age + months + "个月";
        }
        return age;
    }

    public String getStrVaccineTime() {
        strVaccineTime = DateUtils.longToDateString(this.vaccineTime);
        return strVaccineTime;
    }

    public String[] getArrayComments() {
        if (StringUtils.isEmpty(this.comment)) {
            return null;
        }
        arrayComments = this.comment.split(ToolsConstants.SPLIT_SEPARATOR);
        return arrayComments;
    }

    public String getStrCreateTime() {
        long now = System.currentTimeMillis();
        int years = DateUtils.getYearsDiff(now, this.createTime);
        if (years > 0) {
            strCreateTime = years + "年前";
            return strCreateTime;
        }
        int months = DateUtils.getMonthsDiff(now, this.createTime);
        if (months > 0) {
            strCreateTime = months + "个月前";
            return strCreateTime;
        }
        int days = DateUtils.getDaysDiff(now, this.createTime);
        if (days > 0) {
            strCreateTime = days + "天前";
            return strCreateTime;
        }
        strCreateTime = "今天";
        return strCreateTime;
    }
    public LittlePetViewModel() {

    }
    public LittlePetViewModel(AdoptLittlePet adoptLittlePet) {
        this.petId = adoptLittlePet.petId;
        this.name = adoptLittlePet.name;
        this.sex = adoptLittlePet.sex;
        this.birthday = adoptLittlePet.birthday;
        this.breed = adoptLittlePet.breed;
        this.weight = adoptLittlePet.weight;
        this.birthControl = adoptLittlePet.birthControl;
        this.location = adoptLittlePet.location;
        this.vaccineTime = adoptLittlePet.vaccineTime;
        this.petTell = adoptLittlePet.petTell;
        this.comment = adoptLittlePet.comment;
        this.headPortraits = adoptLittlePet.headPortraits;
        this.browseCount = adoptLittlePet.browseCount;
        this.petState = adoptLittlePet.petState;
        this.createTime = adoptLittlePet.createTime;
        this.updateTime = adoptLittlePet.updateTime;
    }

}
