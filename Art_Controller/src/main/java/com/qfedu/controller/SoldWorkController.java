package com.qfedu.controller;

import com.qfedu.common.result.R;
import com.qfedu.service.SoldWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作品售出信息访问接口
 *
 * 作者：lienzhao
 * 时间：2018/9/27 0027 16:25
 */

@Controller
public class SoldWorkController {

    @Autowired
    private SoldWorkService soldWorkService;

    /**
     * 获取多版作品的可售版号
     * @param workId
     * @return
     */
    @RequestMapping("printsonsail.do")
    @ResponseBody
    public R printsOnSail(Integer workId) {
        R r = null;
        if (workId != null) {
            Integer[] nos = soldWorkService.queryOnSailByWorkId(workId);
            if (nos != null && nos.length > 0) {
                r = R.setOK();
                r.setData(nos);
            } else {
                r = R.setERROR();
                r.setMsg("作品没有可售信息");
            }
        } else {
            r = R.setERROR();
            r.setMsg("需要提供作品Id");
        }
        return r;
    }


}
