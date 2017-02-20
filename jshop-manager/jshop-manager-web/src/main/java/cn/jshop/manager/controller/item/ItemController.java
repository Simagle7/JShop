package cn.jshop.manager.controller.item;

import cn.jshop.common.exception.BizException;
import cn.jshop.common.utils.ERRORCODE;
import cn.jshop.common.utils.RETURNCODE;
import cn.jshop.common.utils.User.UserContext;
import cn.jshop.manager.param.item.ItemParam;
import cn.jshop.manager.param.item.ItemParamEx;
import cn.jshop.manager.service.item.IDimensionRelService;
import cn.jshop.manager.service.item.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 郭旭辉 on 2016/10/20.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private IItemService itemService;
    @Autowired
    private IDimensionRelService dimensionRelService;

    /**
     * 分页查询商品数据
     *
     * @param paramEx  查询参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，分页集合
     */
    @RequestMapping(value = "/list")
    public ModelAndView queryPage(ItemParamEx paramEx, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize) {
        return itemService.queryPage(paramEx, pageNo, pageSize);
    }

    /**
     * 添加视图弹窗
     * @return  返回，视图
     */
    @RequestMapping(value = "/add")
    public String loadAddBounced() {
        return "item/add";
    }

    /**
     * 保存商品条目
     *
     * @param paramEx 商品信息参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public String saveItem(ItemParamEx paramEx) {
        return itemService.saveItem(paramEx, UserContext.getCurrentUser());
    }



    /**
     * 调用更新视图弹窗
     *
     * @param id 商品id
     * @return 返回，视图与数据
     */
    @RequestMapping(value = "/update")
    public ModelAndView update(Long id) {
        return itemService.update(id);
    }

    /**
     * 保存一条跟新信息
     * @param paramEx   更新参数
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/updateItem")
    public String updateItem(ItemParamEx paramEx) {
        return itemService.updateItem(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 商品参数规格弹框
     * @param itemId    商品id
     * @param cid       商品分类id
     * @return  返回，视图与数据
     */
    @RequestMapping(value = "/loadDimension")
    public ModelAndView loadDimension(long itemId, long cid){
        return dimensionRelService.loadDimension(itemId, cid);
    }

    /**
     * 删除一条商品信息
     * @param id    商品id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(Long id){
        if(itemService.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    /**
     * 启用、停售商品
     * @param itemParam 更新参数（商品id，状态，0：正常，1：停售）
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disabledOrEnable")
    public String disabledOrEnable(ItemParam itemParam){
        if(itemService.updateMap(itemParam.toMap()) > 0){
            return RETURNCODE.SUCCESS_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

}
