package com.example.demo.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity  // このクラスをEntity（データベースのテーブルの1レコードを表現するクラス）として使うためのアノテーション
@Data  // Getter、Setterを省略するためのLombokのアノテーション
public class User {
//	userテーブルのid
	@Id  // userテーブルのプライマリーキーidにつけるアノテーション
//	@GeneratedValueはプライマリーキーが自動生成される場合に付与する！
//	引数のstrategy = GenerationType.IDENTITYは、MySQLのauto_incrementで自動生成してる場合に指定する！
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

//	userテーブルのname
	private String name;

//	userテーブルのemail
	private String email;
}
