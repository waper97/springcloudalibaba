package com.bpm.mes.stock.server.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gl
 * 2021-07-29
 */
public class CommonConstantUtils {

    /**
     * 盘点状态：1新增 、2实盘中、3实盘 4、调账
     */
    public static final String STOCKCHECK_STATE_ONE = "1";
    public static final String STOCKCHECK_STATE_TWO = "2";
    public static final String STOCKCHECK_STATE_THREE = "3";
    public static final String STOCKCHECK_STATE_FOUR = "4";
    public static final String STOCKCHECK_STATE_FIVE= "5";
    public static final String STOCKCHECK_STATE_SIX= "6";

    /**
     * 移库状态：1新增，2审核
     */
    public static final String STOCKMOVENPLACE_STATE_ADD = "1";
    public static final String STOCKMOVENPLACE_STATE_CHECK = "2";

    /**
     * 逻辑删除标志 1-删除 2-未删除
     */
    public static final String DELETE = "0";
    public static final String NOT_DELETE = "1";

    /**
     * 仓库状态：1在用，0停用，9盘点
     */
    public static final String CTOCK_STATE_ISUSE = "1";
    public static final String CHECK_STATE_DEACTIVATE = "0";
    public static final String CHECK_STATE_INVENTORY = "9";

    /**
     * 操作属性：1入库、2出库
     */
    public static final String PROPERT_IN = "1";
    public static final String PROPERT_OUT = "2";
    /**
     * 仓库类型单据标识：1采购入库、2出库
     */
    public static final String INOUTTYPE_INIT = "INIT"; //初始化
    public static final String INOUTTYPE_CIN = "CIN";//采购入库
    public static final String INOUTTYPE_DIN = "DIN";//成品入库
    public static final String INOUTTYPE_BIN = "BIN";//半成品入库
    public static final String INOUTTYPE_QIN = "QIN";//其他入库
    public static final String INOUTTYPE_DBIN = "DBIN";//调拨单入库
    public static final String INOUTTYPE_DBOUT = "DBOUT";//调拨单出库
    public static final String INOUTTYPE_PIN = "PIN";//盘点入库
    public static final String INOUTTYPE_XOUT = "XOUT";//销售出库
    public static final String INOUTTYPE_QOUT = "QOUT";//其他出库
    public static final String INOUTTYPE_POUT = "POUT";//盘点出库
    public static final String INOUTTYPE_SOUT = "SOUT";//领料出库

    /**
     * 初始化入库任务编码 IN开头-入库 OUT开头-出库
     */
    public static final String INOUTTYPETYPECODE_IN = "IN01";
    public static final String INOUTTYPETYPECODE_OUT = "OUT01";

    /**
     * 初始化入库任务编码 IN开头-入库 OUT开头-出库
     */
    public static final String STOCKRULE_RULECODE_IN = "1-01";
    public static final String STOCKRULE_RULECODE_OUT = "2-01";

    /**
     * 调拨单状态 状态：1新建；2调拨中；3调拨完成；4已上传；5取消上传
     */
    public static final String STOCKPO_STATE_ONE = "1";
    public static final String STOCKPO_STATE_TWO = "2";
    public static final String STOCKPO_STATE_THREE = "3";
    public static final String STOCKPO_STATE_FOUR = "4";
    public static final String STOCKPO_STATE_FIVE = "5";
//    public static final String STOCKPO_STATE_SIX = "6";
//    public static final String STOCKPO_STATE_SEVEN = "7";
//    public static final String STOCKPO_STATE_EIGHT = "8";
//    public static final String STOCKPO_STATE_NINE = "9";
    /**
     * 初始化调拨单编码 IN开头-入库 OUT开头-出库
     */
    public static final String STOCKPO_CODE = "TB"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"001";

    /**
     * 出库单编码 IN开头-入库 OUT开头-出库
     */
    public static final String STOCKMOVEPLACE_CODE = "M"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"001";

    /**
     * 出入库单编码 IN开头-入库 OUT开头-出库
     */
    public static final String STOCKINOUTCODE_IN = "IN"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"001";
    public static final String STOCKINOUTCODE_OUT = "OUT"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"001";
    /**
     * 出入库批次
     */
    public static final String STOCKINOUTCODE_INBATCHNO = new SimpleDateFormat("yyMMdd").format(new Date())+"01";

    /**
     * 执行状态：1新建；2入库中；3入库完成；4已上传； 5取消上传；6检验中；7检验成功；8检验不合格；9出库中；10出库完成；
     */
    public static final String STOCKINOUT_STATE_ONE = "1";
    public static final String STOCKINOUT_STATE_TWO = "2";
    public static final String STOCKINOUT_STATE_THREE = "3";
    public static final String STOCKINOUT_STATE_FOUR = "4";
    public static final String STOCKINOUT_STATE_FIVE = "5";
    public static final String STOCKINOUT_STATE_SIX = "6";
    public static final String STOCKINOUT_STATE_SEVEN = "7";
    public static final String STOCKINOUT_STATE_EIGHT = "8";
    public static final String STOCKINOUT_STATE_NINE = "9";
    public static final String STOCKINOUT_STATE_TEN = "10";
    /**
     * 源单类型（关联表单）1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
     */
    public static final String STOCKINOUT_SOURCETYPE_ONE = "1";
    public static final String STOCKINOUT_SOURCETYPE_TWO = "2";
    public static final String STOCKINOUT_SOURCETYPE_THREE = "3";
    public static final String STOCKINOUT_SOURCETYPE_FOUR = "4";
    public static final String STOCKINOUT_SOURCETYPE_FIVE = "5";
    public static final String STOCKINOUT_SOURCETYPE_SIX = "6";

    /**
     * 出入库状态：1入库、2出库
     */
    public static final String STOCKINOUT_IN = "1";
    public static final String STOCKINOUT_OUT = "2";

    /**
     * 初始化仓库库位层数
     */
    public static final Integer STOCKPLACE_LAYERNUM = 0;

    /**
     * 是否叶结点（1是，0否）
     */
    public static final String IS_LEAF_YES = "1";
    public static final String IS_LEAF_NO = "0";

    /**
     * 状态：0闲置、1占用、2满仓
     */
    public static final String STOCKPLACE_TYPE_SETASIDE = "0";
    public static final String STOCKPLACE_TYPE_OCCUPY = "1";
    public static final String STOCKPLACE_TYPE_FULLHOUSES = "2";

    /**
     * 红蓝字   1蓝字；2红字
     */
    public static final String STOCKINOUT_FROB_RED = "2";
    public static final String STOCKINOUT_FROB_BLUE = "1";
}
