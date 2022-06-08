package com.bpm.mes.stock.common.vo;

import com.bpm.mes.stock.common.vo.ResultVO;
import lombok.Data;


@Data
public class PageInfoVO<T> extends ResultVO {

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页的数量
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 创建返回对象
     *
     * @param <T> T
     * @return ResponseVO
     */
    public static <T> PageInfoVO<T> createPageInfo() {
        return new PageInfoVO<>();
    }

    /**
     * 成功
     *
     * @return ResponseVO
     */
    public PageInfoVO<T> successPageInfo() {
        this.setCode(SUCCESS);
        this.setMsg(SUCCESS_MSG);
        return this;
    }
}
