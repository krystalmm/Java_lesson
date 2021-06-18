package com.example.demo.controller;

// @Controllerのimport
import org.springframework.stereotype.Controller;
// @RequestMappingのimport
import org.springframework.web.bind.annotation.RequestMapping;

// アノテーションを追加（コントローラであることを宣言）
@Controller
public class IndexController {
//	アノテーションつきのメソッド追加
//	下記は「/」、トップページにマッピングすることを記述している！
	@RequestMapping("/")
	public String index() {
//		このindexは、どのテンプレートファイルを使うかを指示している！
//		この場合は、src/main/resources/templates/index.htmlがテンプレートとして使用される！
		return "index";
	}
}

