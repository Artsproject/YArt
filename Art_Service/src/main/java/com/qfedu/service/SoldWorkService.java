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

    /**
     * 随机获取一个可售版号
     * 查询总版数，在未售版号中随机选择一个版号
     * @return
     */
    int randomGetByWorkId(Integer workId);

    /**
     * 添加一条数据，在支付成功后执行
     * @param workId
     * @param printNo
     * @return
     */
    boolean addOneSold(Integer workId, Integer printNo);

}
