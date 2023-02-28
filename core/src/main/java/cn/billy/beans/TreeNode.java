package cn.billy.beans;

import java.util.List;

import lombok.Data;

/**
 *
 */
@Data
public class TreeNode {

	private long id;

	private String name;

	private List<TreeNode> subnodes;

	public TreeNode(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
