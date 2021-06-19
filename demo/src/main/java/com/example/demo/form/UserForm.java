package com.example.demo.form;

import lombok.Data;

// GetterとSetterを自動生成する@Data！
@Data
public class UserForm {
//	userのidはデータベースで自動生成するので、nameとemailのフィールドを用意！
	private String name;
	private String email;
}
