package com.example.demo.model;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactModel {
	private String name;
	private String kana_name;
	private String post_code;
	private String address;    
	private String email;
	private String phone;
	private String body;
	@AssertTrue(message = "個人情報の取り扱いにチェックを打たない場合はお問い合わせできません")
	private boolean consent;

}
