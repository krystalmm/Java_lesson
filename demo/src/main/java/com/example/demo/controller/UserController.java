package com.example.demo.controller;

import org.springframework.stereotype.Controller;
// GetMappingのimport
import org.springframework.web.bind.annotation.GetMapping;
// Autowiredのimport
import org.springframework.beans.factory.annotation.Autowired;
// UserRepositoryのimport
import com.example.demo.data.repository.UserRepository;
// Listのimport
import java.util.List;
// User entityのimport
import com.example.demo.data.entity.User;
// Modelのimport
import org.springframework.ui.Model;

@Controller
public class UserController {
	
//	@Autowiredアノテーションをつけると、Spring FrameworkのDIコンテナが自動でuserRepositoryにインスタンスを注入してくれる！
//	つけ忘れるとuserRepositoryはnullのままなので注意！
//	UserControllerにprivateなフィールド変数userRepositoryを追加！
	@Autowired
	private UserRepository userRepository;

//	@RequestMapping(path = "/users", method = RequestMethod.GET)の省略版(HTTPのメソッドGETのみ受け付ける！)
	@GetMapping("/users")
//	引数にorg.springframework.ui.Modelを追加
//	Modelクラスは、Spring BootのJava側の処理とHTMLテンプレートの間で、データの受け渡しをするためのクラス！
	public String getUsers(Model model) {
//		ユーザーリスト取得処理を追加（findAll()は全レコードを取得する！）
		List<User> users = userRepository.findAll();
		
//		Modelにusersを追加（第一引数はテンプレートでユーザーリストを呼び出すときの名前、第二引数はユーザーリストの実体！）
		model.addAttribute("users", users);
		
//		テンプレートは src/main/resources/templates/users.html とする！
		return "users";
	}
	
}
