package com.geekjc.spring_security_04.modules.system.dto.output;

import com.google.common.collect.Lists;
import com.geekjc.spring_security_04.modules.system.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 *  <p> 菜单树节点 </p>
 *
 * @description :
 * @author : ll
 * @date : 2019/8/19 18:54
 */
@Data
public class MenuTreeNode extends Menu {

    List<MenuTreeNode> children = Lists.newArrayList();

}
