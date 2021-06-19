package com.example.demo.data.repository;

// JpaRepositoryのimport
import org.springframework.data.jpa.repository.JpaRepository;
// UserEntityをimport
import com.example.demo.data.entity.User;

// SptingDataJPAには、初めから基本的な操作が可能なインターフェースが用意されている！
// JpaRepositoryインターフェースを継承（<>の1番目にEntityクラス、2番目にプライマリーキーの型を指定！）
public interface UserRepository extends JpaRepository<User, Long> {

}
