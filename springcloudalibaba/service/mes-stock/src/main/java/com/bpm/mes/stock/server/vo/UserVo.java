package com.bpm.mes.stock.server.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 仓库出入库主表(MesWmsStockinout)实体类
 *
 * @author makejava
 * @since 2022-04-24 09:23:58
 */
@Data
public class UserVo{

        /**
         * 用户ID
         */
        @ApiModelProperty(value = "用户ID")
        private Integer userId;
        /**
         * 公司ID
         */
        @ApiModelProperty(value = "公司ID")
        private Integer companyId;
        /**
         * 公司编码
         */
        @ApiModelProperty(value = "公司编码")
        private String companyCode;
        /**
         * 公司简称
         */
        @ApiModelProperty(value = "公司简称")
        private String companyName;
        /**
         * 公司ID
         */
        @ApiModelProperty(value = "公司ID")
        private Integer FcompanyId;
        /**
         * 公司编码
         */
        @ApiModelProperty(value = "公司编码")
        private String FcompanyCode;
        /**
         * 公司简称
         */
        @ApiModelProperty(value = "公司简称")
        private String FcompanyName;
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


}

