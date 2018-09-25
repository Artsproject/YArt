package com.qfedu.controller;

import com.qfedu.common.redis.RedisUtil;
import com.qfedu.common.result.R;
import com.qfedu.common.util.CookieUtil;
import com.qfedu.common.vo.AddressVo;
import com.qfedu.domain.Recaddress;
import com.qfedu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/25 0025 20:23
 */

@Controller
public class AddressController {

    private final AddressService addressService;


    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("addresslist.do")
    @ResponseBody
    public R addressList(HttpServletRequest request) {

        // TODO 这里调用用户接口获取用户ID

        List<AddressVo> addressVos = addressService.queryList(1);

        R r = R.setOK();
        r.setData(addressVos);

        return r;
    }

    @RequestMapping("addresssave.do")
    @ResponseBody
    public R addressSave(Recaddress recaddress, HttpServletRequest request) {
        // TODO 这里调用用户接口获取用户ID
        // TODO 验证提交数据
        if (recaddress != null) {
            if (addressService.save(recaddress, 1)) {
                R r = R.setOK();
                r.setData(recaddress);
                return r;
            }
        }

        return R.setERROR();
    }

    @RequestMapping("addressdefault.do")
    @ResponseBody
    public R addressDefault(Integer id, HttpServletRequest request) {
        // TODO 这里调用用户接口获取用户ID

        R r = null;
        if (id != null) {
            if (addressService.setDefault(id, 1)) {
                r = R.setOK();
            } else {
                r = R.setERROR();
                r.setMsg("设定默认操作失败，检查您的输入");
            }
        } else {
           r = R.setERROR();
           r.setMsg("需要提供参数：地址id");
        }
        return r;
    }


    @RequestMapping("addressupdate.do")
    @ResponseBody
    public R addressUpdate(Recaddress recaddress, HttpServletRequest request) {
        // TODO 这里调用用户接口获取用户ID
        // TODO 验证提交数据

        R r = null;

        if (recaddress != null && recaddress.getId() != null) {
            if (addressService.update(recaddress, 1)) {
                r = R.setOK();
            }
        } else {
            r = R.setERROR();
            r.setMsg("更新操作失败，检查您的输入");
        }

        return r;
    }


    @RequestMapping("addressdelete.do")
    @ResponseBody
    public R addressDelete(Integer id, HttpServletRequest request) {
        // TODO 这里调用用户接口获取用户ID
        R r = null;
        if (id != null) {
            if (addressService.delete(id, 1)) {
                r = R.setOK();
            } else {
                r = R.setERROR();
                r.setMsg("删除操作失败，检查您的输入");
            }
        } else {
            r = R.setERROR();
            r.setMsg("需要提供参数：地址id");
        }
        return r;
    }

}
