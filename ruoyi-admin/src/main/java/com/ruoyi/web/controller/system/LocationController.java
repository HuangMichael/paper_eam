package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.Location;
import com.ruoyi.system.service.ILocationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 位置信息Controller
 * 
 * @author huangbin
 * @date 2019-11-07
 */
@Controller
@RequestMapping("/eam/location")
public class LocationController extends BaseController
{
    private String prefix = "eam/location";

    @Autowired
    private ILocationService locationService;

    @RequiresPermissions("eam:location:view")
    @GetMapping()
    public String location()
    {
        return prefix + "/location";
    }

    /**
     * 查询位置信息树列表
     */
    @RequiresPermissions("eam:location:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Location> list(Location location)
    {
        List<Location> list = locationService.selectLocationList(location);
        return list;
    }

    /**
     * 导出位置信息列表
     */
    @RequiresPermissions("eam:location:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Location location)
    {
        List<Location> list = locationService.selectLocationList(location);
        ExcelUtil<Location> util = new ExcelUtil<Location>(Location.class);
        return util.exportExcel(list, "location");
    }

    /**
     * 新增位置信息
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("location", locationService.selectLocationById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存位置信息
     */
    @RequiresPermissions("eam:location:add")
    @Log(title = "位置信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Location location)
    {
        return toAjax(locationService.insertLocation(location));
    }

    /**
     * 修改位置信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Location location = locationService.selectLocationById(id);
        mmap.put("location", location);
        return prefix + "/edit";
    }

    /**
     * 修改保存位置信息
     */
    @RequiresPermissions("eam:location:edit")
    @Log(title = "位置信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Location location)
    {
        return toAjax(locationService.updateLocation(location));
    }

    /**
     * 删除
     */
    @RequiresPermissions("eam:location:remove")
    @Log(title = "位置信息", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(locationService.deleteLocationById(id));
    }

    /**
     * 选择位置信息树
     */
    @GetMapping(value = { "/selectLocationTree/{id}", "/selectLocationTree/" })
    public String selectLocationTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("location", locationService.selectLocationById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载位置信息树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = locationService.selectLocationTree();
        return ztrees;
    }
}
