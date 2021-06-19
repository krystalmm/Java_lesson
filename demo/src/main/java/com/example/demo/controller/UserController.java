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
// UserFormのimport
import com.example.demo.form.UserForm;
// PostMappingのimport
import org.springframework.web.bind.annotation.PostMapping;
// Validatedのimport
import org.springframework.validation.annotation.Validated;
// BindingResultのimport
import org.springframework.validation.BindingResult;
// DeleteMappingのimport
import org.springframework.web.bind.annotation.DeleteMapping;
// PathVariableのimport
import org.springframework.web.bind.annotation.PathVariable;

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
	
//	getNewUserメソッドを追加！（ユーザー登録画面を返すメソッド）
	@GetMapping("/newuser")
//	引数にModelを追加
	public String getNewUser(Model model) {
//		Modelに空のUserFormを追加（HTMLテンプレートから値をセットするための設定！）
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		
//		テンプレートは src/main/resources/templates/newuser.html とする！
		return "newuser";
	}
	
//	registerUserメソッドを追加！（ユーザー登録処理）
//	HTTPメソッドはPOSTメソッドを受け付ける！
	@PostMapping("/newuser")
//	引数にUserFormを追加！（HTMLで入力されたnameやemailの値がセットされた状態で渡ってくる！）
//	引数のUserFormにValidatedアノテーションを追加！
//	registerUserメソッドの引数にBindingResultクラスを追加し、UserFormクラスのフィールドに対するバリデーションの結果を保持する！
	public String registerUser(@Validated UserForm userForm, BindingResult bindingResult) {
//		バリデーションの結果、エラーがあるかどうかチェック（hasErrorsは１つでもバリデーションエラーがあればtrueを返す！）
		if (bindingResult.hasErrors()) {
//			エラーがある場合は、ユーザー登録画面を返す
			return "newuser";
		}
		
//		UserFormの値をUserクラス(Entity)にセットする
//		実際のデータベースの１レコードに対応するEntityはUserクラス！（UserFormクラスはidのフィールドがないため、そのままデータベースに保存できない！！）
		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		
//		データベースに保存
		userRepository.save(user);
		
//		ユーザー一覧画面へリダイレクト
		return "redirect:/users";
	}
	
	
//	deleteUserメソッドを追加
//	リクエストマッピング設定を追加（http://localhost:8080/users/{ユーザーID}に対してHTTPのDELETEメソッドで受け取る！）
//	{id}のように{}で囲んだ部分はパスパラメータと呼び、可変の値が入ってくる！
	@DeleteMapping("/users/{id}")
//	処理の中でidを使えるように、引数にidを追加！@PathVariableはリクエストマッピングのパスパラメータの値を引数に紐付けるためのアノテーション！Entityの型に合わせてLong型で宣言！
	public String deleteUser(@PathVariable Long id) {
//		指定したIDのユーザーを削除
		userRepository.deleteById(id);
		
//		ユーザー一覧画面へリダイレクト
		return "redirect:/users";
	}
	
}
