package com.adopt.user.service;

import com.adopt.user.model.AddressModel;
import com.cdg.common.constant.StateConstants;
import com.cdg.db.enhance.dao.NativeSqlMapper;
import com.cdg.db.user.dao.AdoptUserAddressMapper;
import com.cdg.db.user.model.AdoptUserAddress;
import com.cdg.db.user.model.AdoptUserAddressExample;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhenghao
 * @description
 * @date 2018/1/10 13:51
 */
@Service
public class UserAddressService {
    @Autowired
    private AdoptUserAddressMapper userAddressMapper;
    @Autowired
    private NativeSqlMapper nativeSqlMapper;

    /**
     * @param
     * @return
     * @description 添加地址
     * @date 13:53 2018/1/10
     * @author zhenghao
     */
    public Long addUserAddress(AdoptUserAddress userAddress, Long userId) {

        // 先查看是否有地址默认地址，如果没有，则添加的为默认地址
        AdoptUserAddressExample example = new AdoptUserAddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andAddressStateEqualTo((byte) 3);
        List<AdoptUserAddress> adoptUserAddresses = userAddressMapper.selectByExample(example);
        if (adoptUserAddresses == null || adoptUserAddresses.size() <= 0) {
            userAddress.setAddressState((byte) 3);
        } else {
            userAddress.setAddressState(StateConstants.ENABLE_STATE);
        }
        userAddress.setUserId(userId);
        userAddress.setCreateTime(System.currentTimeMillis());
        userAddress.setUpdateTime(System.currentTimeMillis());
        userAddressMapper.insertSelective(userAddress);
        return userAddress.getUserAddressId();
    }

    /**
     * @param
     * @return
     * @description 获的地址列表
     * @date 14:19 2018/1/10
     * @author zhenghao
     */
    public List<AddressModel> getUserAddressList(Long userId) {
        // AdoptUserAddressExample example = new AdoptUserAddressExample();
        // example.createCriteria().andUserIdEqualTo(userId).andAddressStateEqualTo(StateConstants.ENABLE_STATE);
        // List<AdoptUserAddress> adoptUserAddresses =
        // userAddressMapper.selectByExample(example);
        //
        Map<String, Object> params = new HashedMap();
        params.put("userId", userId);
        params.put("state1", StateConstants.ENABLE_STATE);
        params.put("state2", (byte) 3);
        List<AdoptUserAddress> adoptUserAddresses = nativeSqlMapper.selectAddressByUserIdAndState(params);

        List<AddressModel> addressModelList = new ArrayList<>();
        adoptUserAddresses.forEach(address -> {
            AddressModel addressModel = new AddressModel();
            BeanUtils.copyProperties(address, addressModel);
            if (address.getAddressState() == (byte) 3) {
                addressModel.setDefaultAddress(true);
            }
            addressModelList.add(addressModel);
        });

        return addressModelList;
    }

    /**
     * @param
     * @return
     * @description 获得地址详细信息
     * @date 14:22 2018/1/10
     * @author zhenghao
     */
    public AdoptUserAddress getUserAddressInfo(Long addressId) {
        AdoptUserAddress adoptUserAddress = userAddressMapper.selectByPrimaryKey(addressId);
        return adoptUserAddress;
    }

    /**
     * @param
     * @return
     * @description 更新地址信息
     * @date 14:23 2018/1/10
     * @author zhenghao
     */
    public void updateAdoptUserAddress(AdoptUserAddress userAddress) {
        userAddress.setUpdateTime(System.currentTimeMillis());
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    /**
     * @param
     * @return
     * @description 获取地址信息
     * @date 14:23 2018/1/10
     * @author zhenghao
     */
    public AdoptUserAddress getAddress(Long userId, String addressId) {
        if (null == addressId || "null".equals(addressId) || addressId.isEmpty()) {
            return getDefaultAddress(userId);
        } else {
            return getUserAddressInfo(Long.valueOf(addressId));
        }
    }

    /**
     * @param
     * @return
     * @description 获得用户的默认地址
     * @date 0:15 2018/2/6
     * @author zhenghao
     */
    public AdoptUserAddress getDefaultAddress(Long userId) {
        AdoptUserAddressExample example = new AdoptUserAddressExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria().andUserIdEqualTo(userId);
        List<AdoptUserAddress> adoptUserAddresses = userAddressMapper.selectByExample(example);
        if (adoptUserAddresses == null || adoptUserAddresses.size() <= 0) {
            return null;
        }
        AdoptUserAddress result = new AdoptUserAddress();
        // 获得默认地址
        for (AdoptUserAddress adoptUserAddress : adoptUserAddresses) {
            if (adoptUserAddress.getAddressState() == 3) {
                return adoptUserAddress;
            }
        }
        return adoptUserAddresses.get(0);
    }

    /**
     * @param
     * @return
     * @description 设置默认地址
     * @date 0:27 2018/2/9
     * @author zhenghao
     */
    public void setDefaultAddress(Long userId, AdoptUserAddress address) {
        // 先把默认地址 修改为 非默认地址
        AdoptUserAddressExample example = new AdoptUserAddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andAddressStateEqualTo((byte) 3);
        List<AdoptUserAddress> adoptUserAddresses = userAddressMapper.selectByExample(example);
        if (adoptUserAddresses != null && adoptUserAddresses.size() > 0) {
            AdoptUserAddress adoptUserAddress = adoptUserAddresses.get(0);
            adoptUserAddress.setAddressState(StateConstants.ENABLE_STATE);
            userAddressMapper.updateByPrimaryKeySelective(adoptUserAddress);
        }
        // 将新的地址更新为默认地址
        userAddressMapper.updateByPrimaryKeySelective(address);
    }

    /**
     * @param
     * @return
     * @description 删除用户地址
     * @date 18:36 2018/2/26
     * @author zhenghao
     */
    public void delUserAddress(Long addressId) {
        userAddressMapper.deleteByPrimaryKey(addressId);
    }


}
