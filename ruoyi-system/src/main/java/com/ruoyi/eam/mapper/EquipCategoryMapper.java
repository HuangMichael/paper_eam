package com.ruoyi.eam.mapper;

import com.ruoyi.eam.domain.EquipCategory;
import java.util.List;

/**
 * 设备类别Mapper接口
 * 
 * @author huangbin
 * @date 2019-11-07
 */
public interface EquipCategoryMapper 
{
    /**
     * 查询设备类别
     * 
     * @param id 设备类别ID
     * @return 设备类别
     */
    public EquipCategory selectEquipCategoryById(Long id);

    /**
     * 查询设备类别列表
     * 
     * @param equipCategory 设备类别
     * @return 设备类别集合
     */
    public List<EquipCategory> selectEquipCategoryList(EquipCategory equipCategory);

    /**
     * 新增设备类别
     * 
     * @param equipCategory 设备类别
     * @return 结果
     */
    public int insertEquipCategory(EquipCategory equipCategory);

    /**
     * 修改设备类别
     * 
     * @param equipCategory 设备类别
     * @return 结果
     */
    public int updateEquipCategory(EquipCategory equipCategory);

    /**
     * 删除设备类别
     * 
     * @param id 设备类别ID
     * @return 结果
     */
    public int deleteEquipCategoryById(Long id);

    /**
     * 批量删除设备类别
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquipCategoryByIds(String[] ids);
}
