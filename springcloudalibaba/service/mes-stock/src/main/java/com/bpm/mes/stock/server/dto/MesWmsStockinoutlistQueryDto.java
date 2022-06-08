package com.bpm.mes.stock.server.dto;

import com.bpm.mes.stock.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 仓库出入库明细表(MesWmsStockinoutlist)实体类
 *
 * @author makejava
 * @since 2022-04-22 17:58:18
 */
@Data
public class MesWmsStockinoutlistQueryDto extends PageDTO {

        private Integer id;
  
    /**
     * 出入库ID（外键
     */    
    @ApiModelProperty(value = "出入库ID（外键")
    private Integer stockInOutId;
  
    /**
     * 存放物料ID（外键）
     */    
    @ApiModelProperty(value = "存放物料ID（外键）")
    private Integer materialId;
  
    /**
     * 物料编码
     */    
    @ApiModelProperty(value = "物料编码")
    private String materialCode;
  
    /**
     * 物料名称  
     */    
    @ApiModelProperty(value = "物料名称  ")
    private String materialShortName;
  
    /**
     * 物料规格 
     */    
    @ApiModelProperty(value = "物料规格 ")
    private String materialSpec;
  
    /**
     * 计量单位（外键）
     */    
    @ApiModelProperty(value = "计量单位（外键）")
    private Integer unitsId;
  
    /**
     * 计量单位名称（外键）
     */    
    @ApiModelProperty(value = "计量单位名称（外键）")
    private String unitsName;
  
    /**
     * 仓库id 调拨分成出入2条记录
     */    
    @ApiModelProperty(value = "仓库id 调拨分成出入2条记录")
    private Integer stockId;
  
    /**
     * 仓库编码
     */    
    @ApiModelProperty(value = "仓库编码")
    private String stockCode;
  
    /**
     * 仓库名称
     */    
    @ApiModelProperty(value = "仓库名称")
    private String stockName;
  
    /**
     * 导入数量
     */    
    @ApiModelProperty(value = "导入数量")
    private BigDecimal importQty;
  
    /**
     * 计划数量
     */    
    @ApiModelProperty(value = "计划数量")
    private BigDecimal fPallet;
  
    /**
     * 实际数量
     */    
    @ApiModelProperty(value = "实际数量")
    private BigDecimal fFinished;
  
    /**
     * 成功次数
     */    
    @ApiModelProperty(value = "成功次数")
    private Integer fCount;
  
    /**
     * 出入库数量
SAP:
     */    
    @ApiModelProperty(value = "出入库数量 SAP:")
    private BigDecimal stockQty;
  
    /**
     * 开票数量（发票数量）
开票通知单回写的数量
     */    
    @ApiModelProperty(value = "开票数量（发票数量） 开票通知单回写的数量")
    private BigDecimal invoiceQty;
  
    /**
     * 对账单明细ID（外键）
     */    
    @ApiModelProperty(value = "对账单明细ID（外键）")
    private Integer supStatementListId;
  
    /**
     * 对账单ID（外键）
     */    
    @ApiModelProperty(value = "对账单ID（外键）")
    private Integer supStatementId;
  
    /**
     * 核销状态：1已核销，0未核销
     */    
    @ApiModelProperty(value = "核销状态：1已核销，0未核销")
    private String verificationState;
  
    /**
     * 退货数量
     */    
    @ApiModelProperty(value = "退货数量")
    private BigDecimal backQty;
  
    /**
     * 不含税单价
     */    
    @ApiModelProperty(value = "不含税单价")
    private BigDecimal price;
  
    /**
     * 不含税金额
     */    
    @ApiModelProperty(value = "不含税金额")
    private BigDecimal amount;
  
    /**
     * 税率
     */    
    @ApiModelProperty(value = "税率")
    private BigDecimal taxRate;
  
    /**
     * 税额
     */    
    @ApiModelProperty(value = "税额")
    private BigDecimal taxAmount;
  
    /**
     * 含税单价
     */    
    @ApiModelProperty(value = "含税单价")
    private BigDecimal taxPrice;
  
    /**
     * 价税合计（含税金额）
     */    
    @ApiModelProperty(value = "价税合计（含税金额）")
    private BigDecimal allAmount;
  
    /**
     * 保质期（天）
     */    
    @ApiModelProperty(value = "保质期（天）")
    private Integer kFPeriod;
  
    /**
     * 生产/采购日期 YYYY-MM-DD
     */    
    @ApiModelProperty(value = "生产/采购日期 YYYY-MM-DD")
    private String kFDate;
  
    /**
     * 有效期（到期日）YYYY-MM-DD
     */    
    @ApiModelProperty(value = "有效期（到期日）YYYY-MM-DD")
    private String periodDate;
  
    /**
     * 合同ID（外键）
     */    
    @ApiModelProperty(value = "合同ID（外键）")
    private Integer contractId;
  
    /**
     * 合同号
     */    
    @ApiModelProperty(value = "合同号")
    private String contractCode;
  
    /**
     * 合同明细ID（外键）
     */    
    @ApiModelProperty(value = "合同明细ID（外键）")
    private Integer contractListId;
  
    /**
     * 源单类型（关联表单）
1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表
     */    
    @ApiModelProperty(value = "源单类型（关联表单） 1采购订单，2生产工单，3移库单，4调拨单，5出货单，6盘点表")
    private String sourceType;
  
    /**
     * 源单号ID（关联表单）
     */    
    @ApiModelProperty(value = "源单号ID（关联表单）")
    private Integer sourceId;
  
    /**
     * 源单号（关联表单）
     */    
    @ApiModelProperty(value = "源单号（关联表单）")
    private String sourceCode;
  
    /**
     * 源单明细ID
     */    
    @ApiModelProperty(value = "源单明细ID")
    private Integer sourceListId;
  
    /**
     * 采购（销售）订单ID（外键）
     */    
    @ApiModelProperty(value = "采购（销售）订单ID（外键）")
    private Integer orderId;
  
    /**
     * 采购（销售）订单编号
     */    
    @ApiModelProperty(value = "采购（销售）订单编号")
    private String orderCode;
  
    /**
     * 采购（销售）订单明细ID（ 外键）
     */    
    @ApiModelProperty(value = "采购（销售）订单明细ID（ 外键）")
    private Integer orderListId;
  
    /**
     * 生产任务ID（外键）
     */    
    @ApiModelProperty(value = "生产任务ID（外键）")
    private Integer taskId;
  
    /**
     * 生产任务编码
     */    
    @ApiModelProperty(value = "生产任务编码")
    private String taskCode;
  
    /**
     * 任务投料明细ID（ 外键）
     */    
    @ApiModelProperty(value = "任务投料明细ID（ 外键）")
    private Integer taskListId;
  
    /**
     * 销售开票申请ID
     */    
    @ApiModelProperty(value = "销售开票申请ID")
    private Integer saleApplyInvoiceId;
  
    /**
     * 销售开票申请明细
     */    
    @ApiModelProperty(value = "销售开票申请明细")
    private Integer saleApplyInvoiceListId;
  
    /**
     * 特殊库存编号：ERP带入；上传时回传 不允许更改
     */    
    @ApiModelProperty(value = "特殊库存编号：ERP带入；上传时回传 不允许更改")
    private String eRPSpeStock;
  
    /**
     * 相关对象：ERP带入；上传时回传 不允许更改
     */    
    @ApiModelProperty(value = "相关对象：ERP带入；上传时回传 不允许更改")
    private String eRPOfObject;
  
    /**
     * 审核人ID（登陆人）
     */    
    @ApiModelProperty(value = "审核人ID（登陆人）")
    private Integer checkerId;
  
    /**
     * 审核人名称
     */    
    @ApiModelProperty(value = "审核人名称")
    private String checkerName;
  
    /**
     * 审核时间
     */    
    @ApiModelProperty(value = "审核时间")
    private LocalDateTime checkerTime;
  
    /**
     * 执行状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6完成；7关闭；
     */    
    @ApiModelProperty(value = "执行状态：1新建；2部分分配；3完全分配；4部分拣货；5完全拣货；6完成；7关闭；")
    private String state;
  
    /**
     * 行号（回传ERP单据时需要）
     */    
    @ApiModelProperty(value = "行号（回传ERP单据时需要）")
    private String lineNumbe;
  
    /**
     * 组织编码ID（外键）
     */    
    @ApiModelProperty(value = "组织编码ID（外键）")
    private Integer organizationId;
  
    /**
     * 组织编码
     */    
    @ApiModelProperty(value = "组织编码")
    private String organizationCode;
  
    /**
     * 组织名称
     */    
    @ApiModelProperty(value = "组织名称")
    private String organizationName;
  
    /**
     * 公司ID
     */    
    @ApiModelProperty(value = "公司ID")
    private Integer fCompanyId;
  
    /**
     * 公司编码
     */    
    @ApiModelProperty(value = "公司编码")
    private String fEnCode;
  
    /**
     * 公司简称
     */    
    @ApiModelProperty(value = "公司简称")
    private String fShortName;
  
    /**
     * 创建人ID
     */    
    @ApiModelProperty(value = "创建人ID")
    private Integer createId;
  
    /**
     * 创建人名称
     */    
    @ApiModelProperty(value = "创建人名称")
    private String createName;
  
    /**
     * 创建时间
     */    
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
  
    /**
     * 修改人人ID
     */    
    @ApiModelProperty(value = "修改人人ID")
    private Integer updateId;
  
    /**
     * 修改人名称
     */    
    @ApiModelProperty(value = "修改人名称")
    private String updateName;
  
    /**
     * 修改时间
     */    
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;
  
    /**
     * 备注
     */    
    @ApiModelProperty(value = "备注")
    private String remark;
  
    /**
     * 0无效，1有效，默认1
     */    
    @ApiModelProperty(value = "0无效，1有效，默认1")
    private String isValid;
  
}

