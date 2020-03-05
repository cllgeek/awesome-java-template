package com.geekjc.server.modules.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author ll
 * @date 2020年02月10日 11:21 AM
 *
 * 修改时间
 */
public abstract class BaseEntity<T extends Model<T>> extends BaseAddEntity<T>{
    /**
     * 修改时间 - 过去分词表示被动更新
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    //    @Future(message = "修改时间必须是将来时间")
    private Date gmtModified;

    /**
     * 修改人
     */
//    @TableField(value = "modifier_id", fill = FieldFill.INSERT_UPDATE)
//    private Long modifierId;
}
