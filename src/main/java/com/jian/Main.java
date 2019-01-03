package com.jian;

import org.mybatis.generator.api.ShellRunner;

public class Main {
	public static void main(String[] args) {
		args = new String[] { "-configfile", "src\\main\\resources\\mybatis-generator-config.xml", "-overwrite" };
		ShellRunner.main(args);
	}
	
}
