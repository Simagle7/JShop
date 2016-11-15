package cn.jshop.manager.controller.item;

import cn.jshop.common.utils.User.UserContext;
import cn.jshop.manager.param.item.ItemParamEx;
import cn.jshop.manager.service.item.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 郭旭辉 on 2016/10/20.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @RequestMapping(value = "/item")
    public String queryPage(){
        return "item/list";
    }

    @RequestMapping(value = "/add")
    public String loadAddBounced(){
        return "item/add";
    }

    /**
     * 保存商品条目
     * @param paramEx   商品信息参数
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public String saveItem(ItemParamEx paramEx){
        return  itemService.saveItem(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 返回分类视图
     * @return  返回，分类视图
     */
    @RequestMapping(value = "/catTree")
    public String loadCatBounced(){
        return "item/catTree";
    }

    @RequestMapping(value = "/addImages")
    public String addImages(){
        return "item/addImages";
    }

}
