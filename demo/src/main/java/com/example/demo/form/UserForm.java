package com.example.demo.form;

import lombok.Data;

// Bean Validationで使うバリデーションのimport
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

// GetterとSetterを自動生成する@Data！
@Data
public class UserForm {
//	userのidはデータベースで自動生成するので、nameとemailのフィールドを用意！
//	nameへのバリデーション設定を追加（Bean Validation）
	@Size(min = 1, max = 200)
	private String name;
	
//	emailへのバリデーション設定を追加
	@Size(min = 1, max = 200)
	@Email
	private String email;
}
