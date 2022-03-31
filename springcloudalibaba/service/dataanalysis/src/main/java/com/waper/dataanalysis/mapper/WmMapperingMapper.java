package com.waper.dataanalysis.mapper;

import java.util.List;
import java.util.Map;

public interface WmMapperingMapper {

    /**
     * 获取未名目录
     * @param bookId
     * @return
     */
    List<Map<String,Object>> listVmCatelog(String bookId);

    /**
     * 获取学科网目录
     * @param bookId
     * @return
     */
    List<Map<String,Object>> listXKCatelog(String bookId);
}
