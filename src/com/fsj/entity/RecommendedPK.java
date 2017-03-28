package com.fsj.entity;

import java.io.Serializable;

// 被推荐详情类
public class RecommendedPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Custom custom;// 被推荐人（主键1）
	private Users users;// 推荐人（主键2）

	public RecommendedPK() {
		super();
	}

	public RecommendedPK(Custom custom, Users users) {
		super();
		this.custom = custom;
		this.users = users;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custom == null) ? 0 : custom.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecommendedPK other = (RecommendedPK) obj;
		if (custom == null) {
			if (other.custom != null)
				return false;
		} else if (!custom.equals(other.custom))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

}
