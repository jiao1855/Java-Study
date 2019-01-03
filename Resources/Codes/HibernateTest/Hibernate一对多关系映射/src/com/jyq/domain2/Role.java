package com.jyq.domain2;

import java.util.HashSet;
import java.util.Set;

/*
 * CREATE TABLE `sys_role` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL COMMENT '��ɫ����',
  `role_memo` varchar(128) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
 */

public class Role {
	private Long role_id;
	private String role_name;
	private String role_memo;
	
	//���ö�Զ��ϵ��һ����ɫ���԰�������û�
	private Set<User> users = new HashSet<User>();
	
	
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_memo() {
		return role_memo;
	}
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}
}
