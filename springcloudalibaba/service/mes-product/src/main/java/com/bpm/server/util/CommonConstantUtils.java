package com.bpm.server.util;

/**
 * @author gl
 * 2021-07-29
 */
public class CommonConstantUtils {

    /**
     * 作业报工状态：1新建；2已上传；3取消上传
     */
    public static final String TASKWORKREPORT_STATUS_ONE = "1";
    public static final String TASKWORKREPORT_STATUS_TWO = "2";
    public static final String TASKWORKREPORT_STATUS_THREE = "3";
    /**
     * 消耗报工状态：1新建；2已上传；3取消上传
     */
    public static final String CONSUMEWORKREPORT_STATUS_ONE = "1";
    public static final String CONSUMEWORKREPORT_STATUS_TWO = "2";
    public static final String CONSUMEWORKREPORT_STATUS_THREE = "3";
    /**
     * 入库报工状态：1新建；2已上传；3取消上传
     */
    public static final String INWORKREPORT_STATUS_ONE = "1";
    public static final String INWORKREPORT_STATUS_TWO = "2";
    public static final String INWORKREPORT_STATUS_THREE = "3";

    /**
     * 月生产订单状态：1新建；2已上传
     */
    public static final Integer MONTHLY_STATUS_ONE = 1;
    public static final Integer MONTHLY_STATUS_TWO = 2;

    /**
     * 逻辑删除标志 0-删除 1-未删除
     */
    public static final String DELETE = "0";
    public static final String NOT_DELETE = "1";
}
