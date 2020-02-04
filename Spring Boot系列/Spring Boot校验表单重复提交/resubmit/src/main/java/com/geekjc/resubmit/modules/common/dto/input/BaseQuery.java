package com.geekjc.resubmit.modules.common.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ll
 * @date 2020年02月04日 2:16 PM
 * 基类查询参数
 */
@ApiModel(description = "基类查询参数")
@Data
public class BaseQuery extends BasePageQuery {
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
}
