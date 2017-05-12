package com.entity;

import java.util.Map;

import com.args.Constant;

public class Student extends Person{
	private String id;
	private String name;
	private String password;
	private String gender;
	private String email;
	private String tel;
	private String department;
	private String classes;
	private int pflag;
	private int dflag;
	
	public Student(){
		pflag = Constant.POWER_STUDENT;
		dflag = Constant.NOTDELETE;
	}
	
	public Student(String id, String name, String password, String gender,
			String email, String tel, String department, String classes,
			int pflag, int dflag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.tel = tel;
		this.department = department;
		this.classes = classes;
		this.pflag = pflag;
		this.dflag = dflag;
	}
	public Student(Map<String,Object> map){
		this.id =(String)map.get("id");
		this.name =(String)map.get("name");
		this.password =(String)map.get("password");
		this.gender =(String)map.get("gender");
		this.email =(String)map.get("email");
		this.tel =(String)map.get("tel");
		this.department =(String)map.get("department");
		this.classes =(String)map.get("classes");
		this.pflag =(Integer)map.get("pflag");
		this.dflag =(Integer)map.get("dflag");
		
	}

	public String getId() {return id;}
	
	public void setId(String id) {this.id = id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getPassword() {return password;}
	
	public void setPassword(String password) {this.password = password;}
	
	public String getGender() {return gender;}
	
	public void setGender(String gender) {this.gender = gender;}
	
	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	public String getTel() {return tel;}

	public void setTel(String tel) {this.tel = tel;}

	public String getDepartment() {return department;}
	
	public void setDepartment(String department) {this.department = department;}
	
	public String getClasses() {return classes;}
	
	public void setClasses(String classes) {this.classes = classes;}
	
	public int getPflag() {return pflag;}
	
	public void setPflag(int pflag) {this.pflag = pflag;}
	
	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
