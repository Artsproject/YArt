package com.qfedu.service;

/**
 * 作者：lienzhao
 * 时间：2018/9/20 0020 19:38
 *
 * 作品版号管理服务接口
 * 版号管理分析：
 *      前端展示作品详情页面，有多版信息的作品可能用到该服务。
 *
 * 提供接口：获取作品版数
 * 提供接口：获取已售版号
 * 提供接口：随机选择一个未售版号
 * 提供接口：添加一条数据（t_soldwork）
 *
 */
public interface SoldWorkService {

    Integer getPrintCountByWorkId(Integer workId);


    Integer[] querySoldByWorkId(Integer workId);

    Integer[] queryOnSailByWorkId(Integer workId);

    /**
     * “随机”获取一个可售版号
     * @param workId
     * @return 如果是多版，返回大于0的整数，如果是独版，返回0
     */
    Integer randomGetByWorkId(Integer workId);

    /**
     * 更新一条数据（更新flag=1表示已售），在支付成功后执行
     * @param workId
     * @param printNo
     * @return
     */
    boolean setOneSold(Integer workId, Integer printNo);

}
