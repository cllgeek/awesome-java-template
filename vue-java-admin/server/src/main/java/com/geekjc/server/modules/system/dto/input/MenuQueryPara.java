package com.geekjc.server.modules.system.dto.input;

import com.geekjc.server.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ll
 * @date 2020年02月21日 10:55 AM
 */
@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class MenuQueryPara extends BasePageQuery {
    @ApiModelProperty(value = "id")
    private Integer id;
}
