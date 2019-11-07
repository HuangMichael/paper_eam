package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LocationMapper;
import com.ruoyi.system.domain.Location;
import com.ruoyi.system.service.ILocationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 位置信息Service业务层处理
 * 
 * @author huangbin
 * @date 2019-11-07
 */
@Service
public class LocationServiceImpl implements ILocationService 
{
    @Autowired
    private LocationMapper locationMapper;

    /**
     * 查询位置信息
     * 
     * @param id 位置信息ID
     * @return 位置信息
     */
    @Override
    public Location selectLocationById(Long id)
    {
        return locationMapper.selectLocationById(id);
    }

    /**
     * 查询位置信息列表
     * 
     * @param location 位置信息
     * @return 位置信息
     */
    @Override
    public List<Location> selectLocationList(Location location)
    {
        return locationMapper.selectLocationList(location);
    }

    /**
     * 新增位置信息
     * 
     * @param location 位置信息
     * @return 结果
     */
    @Override
    public int insertLocation(Location location)
    {
        location.setCreateTime(DateUtils.getNowDate());
        return locationMapper.insertLocation(location);
    }

    /**
     * 修改位置信息
     * 
     * @param location 位置信息
     * @return 结果
     */
    @Override
    public int updateLocation(Location location)
    {
        location.setUpdateTime(DateUtils.getNowDate());
        return locationMapper.updateLocation(location);
    }

    /**
     * 删除位置信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLocationByIds(String ids)
    {
        return locationMapper.deleteLocationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除位置信息信息
     * 
     * @param id 位置信息ID
     * @return 结果
     */
    @Override
    public int deleteLocationById(Long id)
    {
        return locationMapper.deleteLocationById(id);
    }

    /**
     * 查询位置信息树列表
     * 
     * @return 所有位置信息信息
     */
    @Override
    public List<Ztree> selectLocationTree()
    {
        List<Location> locationList = locationMapper.selectLocationList(new Location());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Location location : locationList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(location.getId());
            ztree.setpId(location.getParentId());
            ztree.setName(location.getLocationName());
            ztree.setTitle(location.getLocationName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
