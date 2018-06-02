package com.adopt.user.controller;

import com.adopt.common.controller.BaseController;
import com.adopt.user.model.AddressModel;
import com.adopt.user.service.UserAddressService;
import com.cdg.common.utils.ServletUtils;
import com.cdg.db.user.model.AdoptUser;
import com.cdg.db.user.model.AdoptUserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhenghao
 * @description
 * @date 2018/1/10 13:55
 */

@Controller
@RequestMapping("/userAddress")
public class UserAddressController extends BaseController {
	@Autowired
	private UserAddressService userAddressService;

	/**
	 * @description 添加用户地址
	 * @param
	 * @date 13:57 2018/1/10
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping("/addUserAddress")
	@CrossOrigin
	public void addUserAddress(HttpServletRequest req, HttpServletResponse res, AdoptUserAddress userAddress) {

		AdoptUser user = this.getUserInfo(req);
		Long userId = user == null ? 1 : user.getUserId();
		Long userAddressId = userAddressService.addUserAddress(userAddress, userId);
		ServletUtils.toJson(userAddressId,req, res);
	}

	/**
	 * @description 获得地址列表
	 * @param
	 * @date 13:57 2018/1/10
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping("/getUserAddressList")
	@CrossOrigin
	public void getUserAddressList(HttpServletRequest req, HttpServletResponse res) {
		AdoptUser user = this.getUserInfo(req);
		Long userId = user == null ? 6 : user.getUserId();
		List<AddressModel> userAddressList = userAddressService.getUserAddressList(userId);
		ServletUtils.toJson(userAddressList, req, res);
	}

	/**
	 * @description 获得地址信息
	 * @param
	 * @date 13:57 2018/1/10
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping("/getUserAddressInfo")
	@CrossOrigin
	public void getUserAddressInfo(HttpServletRequest req, HttpServletResponse res, Long addressId) {
		AdoptUserAddress userAddressInfo = userAddressService.getUserAddressInfo(addressId);
		ServletUtils.toJson(userAddressInfo, req, res);
	}
	/**
	 * @description 更新地址信息
	 * @param
	 * @date 13:57 2018/1/10
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping(value = "/updateAdoptUserAddress", method = RequestMethod.POST)
	@CrossOrigin
	public void updateAdoptUserAddress(HttpServletRequest req, HttpServletResponse res, AdoptUserAddress userAddress) {
		userAddressService.updateAdoptUserAddress(userAddress);
		ServletUtils.toJson(req, res);
	}
	/**
	 * @description 获得默认地址
	 * @param
	 * @date 0:17 2018/2/6
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping("/getDefaultAddress")
	@CrossOrigin
	public void getDefaultAddress(HttpServletRequest req, HttpServletResponse res) {
		AdoptUser user = this.getUserInfo(req);
		String addressId = req.getParameter("addressId");
		AdoptUserAddress defaultAddress = userAddressService.getAddress(user.getUserId(),addressId);
 		ServletUtils.toJson(defaultAddress, req, res);
	}

	/**
	 * @description 设置默认地址
	 * @param
	 * @date 0:17 2018/2/6
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping("/setDefaultAddress")
	@CrossOrigin
	public void setDefaultAddress(HttpServletRequest req, HttpServletResponse res, AdoptUserAddress address) {
		AdoptUser user = this.getUserInfo(req);
		if (user==null){
			userAddressService.setDefaultAddress(5L, address);
		}else {
			userAddressService.setDefaultAddress(user.getUserId(), address);
		}
		ServletUtils.toJson(req, res);
	}

	/**
	 * @description 设置默认地址
	 * @param
	 * @date 0:17 2018/2/6
	 * @return
	 * @author zhenghao
	 */
	@RequestMapping("/delUserAddress")
	@CrossOrigin
	public void delUserAddress(HttpServletRequest req, HttpServletResponse res, Long addressId) {
		userAddressService.delUserAddress(addressId);
		ServletUtils.toJson(req, res);
	}
}
