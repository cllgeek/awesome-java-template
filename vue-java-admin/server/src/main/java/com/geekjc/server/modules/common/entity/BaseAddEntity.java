package com.geekjc.server.modules.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author ll
 * @date 2020年02月10日 11:11 AM
 *
 * 创建日期
 */
@Getter
@Setter
public abstract class BaseAddEntity<T extends Model<T>> extends Model<T> {
    /**
     * 创建日期 - 现在时表示主动创建
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    @Past(message = "创建时间必须是过去时间")
    private Date gmtCreate;

    /**
     * 创建人
     */
//    @TableField(value = "creator_id", fill = FieldFill.INSERT)
//    private Long creatorId;
    /**
     * 是否可用
     */
//    @TableField(fill = FieldFill.INSERT)
//    private Boolean availableFlag;
}
