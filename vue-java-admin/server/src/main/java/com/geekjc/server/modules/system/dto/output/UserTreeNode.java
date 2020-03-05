package com.geekjc.server.modules.system.dto.output;

import com.geekjc.server.modules.system.entity.User;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author ll
 * @date 2020年02月29日 5:35 PM
 *
 * 用户树节点
 */
@Data
public class UserTreeNode extends User {

    List<UserTreeNode> children = Lists.newArrayList();
}
