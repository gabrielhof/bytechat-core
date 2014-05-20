package br.feevale.bytechat.util;

public class User {
	
	private String name;

	public User() {
		this(null);
	}
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			
			if (getName() != null && user.getName() != null) {
				return getName().equals(user.getName());
			}
			
			return false;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getName() == null ? super.hashCode() : getName().hashCode();
	}

}
