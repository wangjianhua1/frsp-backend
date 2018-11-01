package com.frsp.utils;

import com.frsp.common.enums.ErrcodeEnum;
import com.frsp.vo.ResultVO;

public class ResultVOUtils {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setStatus(1);
        resultVO.setErrcode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * 分页形式返回
     *
     * @param object
     * @param total
     * @return
     */
    public static ResultVO successTotal(Object object, Integer total) {
        ResultVO resultVO = success(object);
        resultVO.setTotal(total);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO success(Object object, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setStatus(1);
        resultVO.setErrcode(0);
        resultVO.setMsg(msg);
        return success(resultVO);
    }

    public static ResultVO error(Integer errcode, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(0);
        resultVO.setErrcode(errcode);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(ErrcodeEnum errcodeEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(0);
        resultVO.setErrcode(errcodeEnum.getCode());
        resultVO.setMsg(errcodeEnum.getMessage());
        return resultVO;
    }
}
