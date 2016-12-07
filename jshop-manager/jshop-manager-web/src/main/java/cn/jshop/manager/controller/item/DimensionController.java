package cn.jshop.manager.controller.item;

import cn.jshop.manager.param.item.DimensionParam;
import cn.jshop.manager.service.item.IDimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 郭旭辉 on 2016/10/20.
 */
@Controller
@RequestMapping(value = "/item/dimension")
public class DimensionController {

    @Autowired
    private IDimensionService dimensionService;

    /**
     * 分页查询商品规格参数模板
     *
     * @param param  查询参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，视图与数据
     */
    @RequestMapping(value = "/list")
    public ModelAndView queryPage(DimensionParam param, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize) {
        return dimensionService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 添加视图弹窗
     * @return  返回，视图
     */
    @RequestMapping(value = "/add")
    public String loadAddBounced() {
        return "dimension/add";
    }

//    /**
//     * 保存商品条目
//     *
//     * @param paramEx 商品信息参数
//     * @return 返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
//    public String saveItem(ItemParamEx paramEx) {
//        return itemService.saveItem(paramEx, UserContext.getCurrentUser());
//    }
//
//
//
//    /**
//     * 调用更新视图弹窗
//     *
//     * @param id 商品id
//     * @return 返回，视图与数据
//     */
//    @RequestMapping(value = "/update")
//    public ModelAndView update(Long id) {
//        return itemService.update(id);
//    }
//
//    /**
//     * 保存一条跟新信息
//     * @param paramEx   更新参数
//     * @return  返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/updateItem")
//    public String updateItem(ItemParamEx paramEx) {
//        return itemService.updateItem(paramEx, UserContext.getCurrentUser());
//    }
//
//    /**
//     * 删除一条商品信息
//     * @param id    商品id
//     * @return  返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/deleteOne")
//    public String deleteOne(Long id){
//        if(itemService.deleteById(id) > 0){
//            return RETURNCODE.DELETE_COMPLETE.getMessage();
//        }
//        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
//    }
//
//    /**
//     * 启用、停售商品
//     * @param itemParam 更新参数（商品id，状态，0：正常，1：停售）
//     * @return  返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/disabledOrEnable")
//    public String disabledOrEnable(ItemParam itemParam){
//        if(itemService.updateMap(itemParam.toMap()) > 0){
//            return RETURNCODE.SUCCESS_COMPLETE.getMessage();
//        }
//        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
//    }

}
