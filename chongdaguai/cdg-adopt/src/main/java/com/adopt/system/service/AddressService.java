package com.adopt.system.service;

import com.cdg.common.constant.SystemConstants;
import com.cdg.db.system.dao.AdoptSysAddressMapper;
import com.cdg.db.system.model.AdoptSysAddress;
import com.cdg.db.system.model.AdoptSysAddressExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huayu
 * @date 2018/4/18 下午2:25
 */
@Service
public class AddressService {
    private static final Logger log = LoggerFactory.getLogger(AddressService.class);
    @Autowired
    private AdoptSysAddressMapper adoptSysAddressMapper;

    private static List<String> provinceList = null;
    private static HashMap<String, List<String>> provinceCityMap = null;
    private static HashMap<String, List<String>> cityAreaMap = null;

    /**
     * 获取地址
     * @param type
     * @param par
     * @return
     */
    public List<String> getAddress(byte type, String par) {

        List<String> addressList = null;
        if (SystemConstants.ADDRESS_TYPE_PROVINCE == type) {
            addressList = this.getProvinceList();
        } else if (SystemConstants.ADDRESS_TYPE_CITY == type) {
            addressList = this.getCityListByProvince(par);
        } else if (type == SystemConstants.ADDRESS_TYPE_AREA) {
            addressList = this.getAreaListByCity(par);
        }

        return addressList;
    }
    /**
     * 获得省份列表
     * @return
     */
    public List<String> getProvinceList() {
        if (provinceList == null) {
            synchronized (this) {
                if (provinceList == null) {
                    initAddressMap();
                }
            }
        }

        return provinceList;
    }

    /**
     * 获取省份下面的城市列表
     * @param province
     * @return
     */
    public List<String> getCityListByProvince(String province) {
        if (provinceCityMap == null) {
            synchronized (this) {
                if (provinceCityMap == null) {
                    initAddressMap();
                }
            }
        }

        return provinceCityMap == null ? null : provinceCityMap.get(province);
    }

    /**
     * 获取城市下边的县 区 列表
     * @param city
     * @return
     */
    public List<String> getAreaListByCity(String city) {
        if (cityAreaMap == null) {
            synchronized (this) {
                if (cityAreaMap == null) {
                    initAddressMap();
                }
            }
        }

        return cityAreaMap == null ? null : cityAreaMap.get(city);
    }

    /**
     * 初始化 地址map
     */
    public void initAddressMap() {
        if (provinceList == null) {
            synchronized (this) {
                if (provinceList == null) {
                    getAddressFromDB();
                }
            }
        }
    }
    /**
     * 从数据库中查询地址信息 添加到缓存中
     */
    public void getAddressFromDB() {
        //省份list
        List<String> loadProvinceList = new ArrayList<>();
        //省份对应城市的map
        HashMap<String, List<String>> loadProvinceCityMap = new HashMap<>();
        //城市对应县区的map
        HashMap<String, List<String>> loadCityAreaMap = new HashMap<>();

        try {

            AdoptSysAddressExample addressExample = new AdoptSysAddressExample();
            addressExample.createCriteria().andTypeEqualTo(SystemConstants.ADDRESS_TYPE_PROVINCE);
            //pl
            List<AdoptSysAddress> pList = adoptSysAddressMapper.selectByExample(addressExample);

            if (pList != null) {
                for (AdoptSysAddress p : pList) {
                    //获得该省份下的城市列表
                    AdoptSysAddressExample cityExample = new AdoptSysAddressExample();
                    cityExample.createCriteria().andTypeEqualTo(SystemConstants.ADDRESS_TYPE_CITY).andPidEqualTo(p.getAddressId());
                    //cl
                    List<AdoptSysAddress> cityList = adoptSysAddressMapper.selectByExample(cityExample);
                    //城市名称List cList
                    List<String> cityNameList = new ArrayList<String>();

                    if (cityList != null) {

                        for (AdoptSysAddress c : cityList) {

                            cityNameList.add(c.getName());
                            //查询该该城市下面对应的县区
                            AdoptSysAddressExample areaExample = new AdoptSysAddressExample();
                            areaExample.createCriteria().andTypeEqualTo(SystemConstants.ADDRESS_TYPE_AREA).andPidEqualTo(c.getAddressId());
                            List<AdoptSysAddress> areaList = adoptSysAddressMapper.selectByExample(areaExample);
                            //县区 名称list
                            List<String> areaNameList = new ArrayList<String>();

                            if (areaList != null) {
                                for (AdoptSysAddress a : areaList) {

                                    areaNameList.add(a.getName());
                                }
                            }

                            loadCityAreaMap.put(c.getName(), areaNameList);
                        }
                    }

                    loadProvinceList.add(p.getName());

                    loadProvinceCityMap.put(p.getName(), cityNameList);


                }

                provinceList = loadProvinceList;

                provinceCityMap = loadProvinceCityMap;

                cityAreaMap = loadCityAreaMap;

            }

        } catch (Exception e) {
            log.error("getAddressFromDB exception", e);
        }
    }

    public String[] caseParseAddr(String address) {
        HashMap<String, List<String>> addrMap = getProvinceCityMap();

        String[] addr = { null, null };
        if (addrMap != null && address != null) {

            for (Map.Entry<String, List<String>> en : addrMap.entrySet()) {
                String province = en.getKey();
                int p = address.indexOf(province);
                if (p == 0) {
                    addr[0] = province;
                    for (String city : en.getValue()) {
                        int c = address.indexOf(city, p);
                        if (c >= p && c <= p + province.length() + 1) {
                            addr[1] = city;
                            break;
                        }
                    }

                    break;
                }
            }

            // only start with city
            if (addr[1] == null) {
                for (Map.Entry<String, List<String>> en : addrMap.entrySet()) {
                    String province = en.getKey();
                    for (String city : en.getValue()) {
                        int c = address.indexOf(city);
                        if (c == 0) {
                            addr[0] = province;
                            addr[1] = city;
                            break;
                        }
                    }

                }

            }

        }

        return addr;
    }

    private HashMap<String, List<String>> getProvinceCityMap() {
        if (provinceCityMap == null) {
            synchronized (this) {
                if (provinceCityMap == null) {
                    initAddressMap();
                }
            }
        }

        return provinceCityMap;
    }
}
