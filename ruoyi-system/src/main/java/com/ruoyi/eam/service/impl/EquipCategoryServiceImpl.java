package com.ruoyi.eam.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.eam.mapper.EquipCategoryMapper;
import com.ruoyi.eam.domain.EquipCategory;
import com.ruoyi.eam.service.IEquipCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备类别Service业务层处理
 * 
 * @author huangbin
 * @date 2019-11-07
 */
@Service
public class EquipCategoryServiceImpl implements IEquipCategoryService 
{
    @Autowired
    private EquipCategoryMapper equipCategoryMapper;

    /**
     * 查询设备类别
     * 
     * @param id 设备类别ID
     * @return 设备类别
     */
    @Override
    public EquipCategory selectEquipCategoryById(Long id)
    {
        return equipCategoryMapper.selectEquipCategoryById(id);
    }

    /**
     * 查询设备类别列表
     * 
     * @param equipCategory 设备类别
     * @return 设备类别
     */
    @Override
    public List<EquipCategory> selectEquipCategoryList(EquipCategory equipCategory)
    {
        return equipCategoryMapper.selectEquipCategoryList(equipCategory);
    }

    /**
     * 新增设备类别
     * 
     * @param equipCategory 设备类别
     * @return 结果
     */
    @Override
    public int insertEquipCategory(EquipCategory equipCategory)
    {
        equipCategory.setCreateTime(DateUtils.getNowDate());
        return equipCategoryMapper.insertEquipCategory(equipCategory);
    }

    /**
     * 修改设备类别
     * 
     * @param equipCategory 设备类别
     * @return 结果
     */
    @Override
    public int updateEquipCategory(EquipCategory equipCategory)
    {
        equipCategory.setUpdateTime(DateUtils.getNowDate());
        return equipCategoryMapper.updateEquipCategory(equipCategory);
    }

    /**
     * 删除设备类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEquipCategoryByIds(String ids)
    {
        return equipCategoryMapper.deleteEquipCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备类别信息
     * 
     * @param id 设备类别ID
     * @return 结果
     */
    @Override
    public int deleteEquipCategoryById(Long id)
    {
        return equipCategoryMapper.deleteEquipCategoryById(id);
    }
}
