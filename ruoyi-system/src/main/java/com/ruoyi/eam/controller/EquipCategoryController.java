package com.ruoyi.web.controller.eam;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.eam.domain.EquipCategory;
import com.ruoyi.eam.service.IEquipCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备类别Controller
 * 
 * @author huangbin
 * @date 2019-11-07
 */
@Controller
@RequestMapping("/eam/equipCategory")
public class EquipCategoryController extends BaseController
{
    private String prefix = "eam/equipCategory";

    @Autowired
    private IEquipCategoryService equipCategoryService;

    @RequiresPermissions("eam:equipCategory:view")
    @GetMapping()
    public String equipCategory()
    {
        return prefix + "/equipCategory";
    }

    /**
     * 查询设备类别列表
     */
    @RequiresPermissions("eam:equipCategory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EquipCategory equipCategory)
    {
        startPage();
        List<EquipCategory> list = equipCategoryService.selectEquipCategoryList(equipCategory);
        return getDataTable(list);
    }

    /**
     * 导出设备类别列表
     */
    @RequiresPermissions("eam:equipCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EquipCategory equipCategory)
    {
        List<EquipCategory> list = equipCategoryService.selectEquipCategoryList(equipCategory);
        ExcelUtil<EquipCategory> util = new ExcelUtil<EquipCategory>(EquipCategory.class);
        return util.exportExcel(list, "equipCategory");
    }

    /**
     * 新增设备类别
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备类别
     */
    @RequiresPermissions("eam:equipCategory:add")
    @Log(title = "设备类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EquipCategory equipCategory)
    {
        return toAjax(equipCategoryService.insertEquipCategory(equipCategory));
    }

    /**
     * 修改设备类别
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EquipCategory equipCategory = equipCategoryService.selectEquipCategoryById(id);
        mmap.put("equipCategory", equipCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备类别
     */
    @RequiresPermissions("eam:equipCategory:edit")
    @Log(title = "设备类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EquipCategory equipCategory)
    {
        return toAjax(equipCategoryService.updateEquipCategory(equipCategory));
    }

    /**
     * 删除设备类别
     */
    @RequiresPermissions("eam:equipCategory:remove")
    @Log(title = "设备类别", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(equipCategoryService.deleteEquipCategoryByIds(ids));
    }
}
