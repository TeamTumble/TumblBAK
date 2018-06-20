package com.tumbl.admin.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class OpenCrypt {
	/**************************************************************
	 * * 참고 : 해시 함수(hash function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 * 매핑하는 함수이다. 해시 함수에 의해
	 * 얻어지는 값은 해시 값, 해시 코드, * 해시 체크섬 또는 간단하게 해시라고 한다. * 해쉬함수중에는 암호학적
	 * 해쉬함수(Cryptographic Hash Function)와 * 비암호학적 해쉬함수로 구분되곤 한다. 암호학적 해쉬함수의 종류로는
	 * MD5, * SHA계열 해쉬함수가 있으며 비암호학적 해쉬함수로는 CRC32등이 있다.
	 **************************************************************/
	// 해시함수를 이용해 패스워드 암호화 작업을 수행한다
	public static byte[] getSHA256(String source, String salt) {
		byte byteData[] = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(source.getBytes());
			md.update(salt.getBytes());
			byteData = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return byteData;
	}
}