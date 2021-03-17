package com.cpiaoju.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.cpiaoju.common.BaseController;
import com.cpiaoju.common.JsonResult;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.config.Constant;
import com.cpiaoju.common.utils.Query;
import com.cpiaoju.system.model.DictDO;
import com.cpiaoju.system.service.DictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-29 18:28:07
 */

@Controller
@RequestMapping("/system/dict")
public class DictController extends BaseController {
	@Autowired
	private DictService dictService;

	@GetMapping()
	String dict() {
		return "system/dict/dict.html";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageResult list(@RequestParam Map<String, Object> params) {
		params.put("delFlag","0");
		Query query = new Query(params);
		List<DictDO> list = dictService.list(query);
		int count = dictService.count(query);
		return new PageResult<>(list, count);
	}

	@GetMapping("/add")
	String add(Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("parentId",0);
		List<DictDO> list = dictService.list(map);
		model.addAttribute("dictList",list);
		return "system/dict/add.html";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",0);
        List<DictDO> list = dictService.list(map);
        model.addAttribute("dictList",list);

		DictDO dict = dictService.get(id);
		model.addAttribute("dict", dict);
		return "system/dict/edit.html";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public JsonResult save(DictDO dict) {
		dict.setDelFlag(Constant.UN_DELETE_FLAG);
		if (dictService.save(dict) > 0) {
			return JsonResult.ok();
		}
		return JsonResult.error("添加失败");
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(DictDO dict) {
        if (dictService.update(dict) > 0) {
            return JsonResult.ok();
        }
		return JsonResult.error("编辑失败");
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public JsonResult remove(Long id) {
		DictDO dictDO = new DictDO();
		dictDO.setId(id);
		dictDO.setDelFlag(Constant.DELETE_FLAG);
		if (dictService.update(dictDO) > 0) {
			return JsonResult.ok();
		}
		return JsonResult.error("删除字段失败");
	}


	@GetMapping("/type")
	@ResponseBody
	public List<DictDO> listType() {
		return dictService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "common/dict/add";
	}

	@ResponseBody
	@GetMapping("/list/{type}")
	public List<DictDO> listByType(@PathVariable("type") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", type);
		List<DictDO> dictList = dictService.list(map);
		return dictList;
	}
}
