package com.ming.controller;

import com.ming.exception.CustomException;
import com.ming.po.ItemsCustom;
import com.ming.po.ItemsQueryVo;
import com.ming.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 整合持久层，业务层，表现层
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    private final static Logger log = LoggerFactory.getLogger(ItemsController.class);

    @Autowired
    private ItemsService itemService;

    @ModelAttribute("itemsType")
    public Map<String, Object> itemsType() {
        Map<String, Object> itemsType = new HashMap<>();
        itemsType.put("办公", "电脑");
        itemsType.put("娱乐", "手机");
        return itemsType;
    }

    /**
     * 商品查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryItems", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
        //测试forward转发后request是否可以共享
        log.debug("测试forward转发后request是否可以共享id：" + request.getParameter("id"));
        ModelAndView model = new ModelAndView();
        List<ItemsCustom> itemsList = itemService.findItemsList(itemsQueryVo);
        model.addObject("itemsList", itemsList);
        model.setViewName("/items/itemsList");
        return model;
    }

    /**
     * 商品修改
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems", method = {RequestMethod.GET, RequestMethod.POST})
    public String editItems(Model model, @RequestParam(value = "id", required = true, defaultValue = "") Integer items_id) throws Exception {
        ItemsCustom itemsCustom = itemService.findItemsById(items_id);
        //自定义异常类
        if (itemsCustom == null) {
            throw new CustomException("商品为空，联系管理员");
        }
        //ModelAndView model = new ModelAndView();
        //model.addObject("itemsCustom",itemsCustom);
        //model.setViewName("/items/editItems");
        model.addAttribute("itemsCustom", itemsCustom);
        return "/items/editItems";
    }

    /**
     * 商品信息修改提交
     *
     * @throws Exception
     */
    @RequestMapping(value = "/editItemsSubmit", method = {RequestMethod.POST})
    public String editItemsSubmit(HttpServletRequest request, @RequestParam(value = "id") Integer id, ItemsCustom itemsCustom,
                                  MultipartFile multipartFile) throws Exception {
        //图片原名称
        String file_name = multipartFile.getOriginalFilename();
        //上传图片
        if (multipartFile != null && file_name != null && file_name.length() > 0) {
            //存储图片的物理路径
            String img_path = "E:\\javacode\\idea_workspace\\springmvc_img\\";
            //新图片名称
            String new_file_name = UUID.randomUUID() + file_name.substring(file_name.lastIndexOf("."));
            //创建文件实例
            File file = new File(img_path + new_file_name);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                System.out.println("创建目录:" + file);
            }
            // 写入文件
            multipartFile.transferTo(file);
            itemsCustom.setPic(new_file_name);
        }
        itemService.updateItemsById(id, itemsCustom);
        //重定向
        //return  "redirect:/items/queryItems.action";
        //转发
        return "forward:/items/queryItems.action";
    }

    /**
     * 批量删除
     *
     * @param items_id
     * @return
     */
    @RequestMapping(value = "/deleteItemsBatch", method = {RequestMethod.POST})
    public String deleteItemsBatch(Integer[] items_id) {
        itemService.deleteBatchItems(items_id);
        return "forward:/items/queryItems.action";
    }

    /**
     * 批量修改的页面
     *
     * @param request
     * @param items_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateView")
    public ModelAndView updateView(HttpServletRequest request, Integer[] items_id) throws Exception {
        ModelAndView model = new ModelAndView();
        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        itemsQueryVo.setId(items_id);
        List<ItemsCustom> itemsList = itemService.findItemsList(itemsQueryVo);
        model.addObject("itemsList", itemsList);
        model.setViewName("/items/updateView");
        return model;

    }

    @RequestMapping("/updateItemsBatch")
    public String updateItemsBatch(ItemsQueryVo itemsQueryVo) {
        itemService.updateBatchItems(itemsQueryVo.getItemsCustomList());
        return "forward:/items/queryItems.action";
    }

    /**
     * 根据id查询商品，使用RESTful风格
     * mapping中的id将这个url位置的参数传到PathVariable注解指定的名称中
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/itemsView/{id}")
    public ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {
       ItemsCustom itemsCustom = itemService.findItemsById(id);
       return itemsCustom;
    }
}
