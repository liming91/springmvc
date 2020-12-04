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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 整合持久层，业务层，表现层
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    private final static Logger log =  LoggerFactory.getLogger(ItemsController.class);

    @Autowired
    private ItemsService itemService;

    @ModelAttribute("itemsType")
    public Map<String,Object> itemsType(){
        Map<String,Object> itemsType = new HashMap<>();
        itemsType.put("办公","电脑");
        itemsType.put("娱乐","手机");
        return  itemsType;
    }
    /**
     * 商品查询
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryItems",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
        //测试forward转发后request是否可以共享
        log.debug("测试forward转发后request是否可以共享id："+request.getParameter("id"));
        ModelAndView model = new ModelAndView();
        List<ItemsCustom> itemsList = itemService.findItemsList(itemsQueryVo);
        model.addObject("itemsList",itemsList);
        model.setViewName("/items/itemsList");
        return model;
    }

    /**
     *  商品修改
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    public String editItems(Model model, @RequestParam(value = "id",required = true,defaultValue = "") Integer items_id) throws Exception{
        ItemsCustom itemsCustom = itemService.findItemsById(items_id);
        //自定义异常类
        if(itemsCustom == null){
            throw new CustomException("商品为空，联系管理员");
        }
        //ModelAndView model = new ModelAndView();
        //model.addObject("itemsCustom",itemsCustom);
        //model.setViewName("/items/editItems");
        model.addAttribute("itemsCustom",itemsCustom);
        return "/items/editItems";
    }

    /**
     * 商品信息修改提交
     * @throws Exception
     */

    @RequestMapping(value = "/editItemsSubmit",method = {RequestMethod.POST})
    public String editItemsSubmit(HttpServletRequest request, @RequestParam(value = "id") Integer id, ItemsCustom itemsCustom) throws Exception{
            itemService.updateItemsById(id,itemsCustom);
        //重定向
        //return  "redirect:/items/queryItems.action";
        //转发
        return "forward:/items/queryItems.action";
    }

    /**
     * 批量删除
     * @param items_id
     * @return
     */
    @RequestMapping(value = "/deleteItemsBatch",method = {RequestMethod.POST})
    public String deleteItemsBatch(Integer[] items_id){
        itemService.deleteBatchItems(items_id);
        return "forward:/items/queryItems.action";
    }

    /**
     * 批量修改的页面
     * @param request
     * @param items_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateView")
    public ModelAndView updateView(HttpServletRequest request,Integer[] items_id) throws Exception {
        ModelAndView model = new ModelAndView();
        ItemsQueryVo itemsQueryVo =new ItemsQueryVo();
        itemsQueryVo.setId(items_id);
        List<ItemsCustom> itemsList = itemService.findItemsList(itemsQueryVo);
        model.addObject("itemsList",itemsList);
        model.setViewName("/items/updateView");
        return model;

    }

    @RequestMapping("/updateItemsBatch")
    public String updateItemsBatch(ItemsQueryVo itemsQueryVo){
        itemService.updateBatchItems(itemsQueryVo.getItemsCustomList());
        return "forward:/items/queryItems.action";
    }
}
