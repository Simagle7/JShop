package cn.jshop.manager.controller.item;

import cn.jshop.manager.service.item.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * Created by 郭旭辉 on 2016/10/20.
 */

@Controller
@RequestMapping(value = "/item/cat")
public class ItemCatController {

    @Autowired
    private IItemCatService itemCatService;

    /**
     * 获取分类树节点
     * @param pId       父节点，0：根节点
     * @param allIn     是否全部节点，true：是（默认），false：否
     * @return 返回，节点集合
     */
    @ResponseBody
    @RequestMapping(value = "/getChildCat")
    public List getChildCat(@RequestParam(defaultValue = "0") Integer pId, @RequestParam(defaultValue = "true")Boolean allIn){
        return itemCatService.getChildCat(pId, allIn);
    }

    /**
     * 返回分类视图
     *
     * @return 返回，分类视图
     */
    @RequestMapping(value = "/catTree")
    public ModelAndView loadCatBounced(@RequestParam(defaultValue = "true")Boolean allIn) {
        return new ModelAndView("category/catTree").addObject("allIn",allIn);
    }

}
