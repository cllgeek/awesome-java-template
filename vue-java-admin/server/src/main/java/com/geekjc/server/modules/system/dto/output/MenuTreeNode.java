package com.geekjc.server.modules.system.dto.output;

import com.geekjc.server.modules.system.entity.Menu;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月28日 1:32 PM
 *
 * 菜单树节点
 */
@Data
public class MenuTreeNode extends Menu {

    List<MenuTreeNode> children = Lists.newArrayList();
}
