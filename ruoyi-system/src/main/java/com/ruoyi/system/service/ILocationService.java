package com.ruoyi.system.service;

import com.ruoyi.system.domain.Location;
import java.util.List;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 位置信息Service接口
 * 
 * @author huangbin
 * @date 2019-11-07
 */
public interface ILocationService 
{
    /**
     * 查询位置信息
     * 
     * @param id 位置信息ID
     * @return 位置信息
     */
    public Location selectLocationById(Long id);

    /**
     * 查询位置信息列表
     * 
     * @param location 位置信息
     * @return 位置信息集合
     */
    public List<Location> selectLocationList(Location location);

    /**
     * 新增位置信息
     * 
     * @param location 位置信息
     * @return 结果
     */
    public int insertLocation(Location location);

    /**
     * 修改位置信息
     * 
     * @param location 位置信息
     * @return 结果
     */
    public int updateLocation(Location location);

    /**
     * 批量删除位置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLocationByIds(String ids);

    /**
     * 删除位置信息信息
     * 
     * @param id 位置信息ID
     * @return 结果
     */
    public int deleteLocationById(Long id);

    /**
     * 查询位置信息树列表
     * 
     * @return 所有位置信息信息
     */
    public List<Ztree> selectLocationTree();
}
