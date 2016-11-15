package cn.jshop.manager.controller.item;

import cn.jshop.common.domain.TreeNode;
import cn.jshop.manager.service.item.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * Created by 郭旭辉 on 2016/10/20.
 */

@Controller
@RequestMapping(value = "/item/cat")
public class ItemCatController {

    @Autowired
    private IItemCatService itemCatService;

    @ResponseBody
    @RequestMapping(value = "/getChildCat")
    public List<TreeNode> getChildCat(@RequestParam(defaultValue = "0") Integer pId){
        return itemCatService.getChildCat(pId);
    }


}
