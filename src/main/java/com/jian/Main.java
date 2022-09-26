package com.jian;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

public class Main {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/services_db?useUnicode=true&useSSL=false&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static final String AUTHOR = "MrJan";





	public static void main(String[] args) {
		toGenerate();
	}


	public static  void toGenerate(){
		FastAutoGenerator.create(DB_URL ,USERNAME, PASSWORD)
				.globalConfig(builder -> {
					builder.author(AUTHOR) // 设置作者
							.enableSwagger() // 开启 swagger 模式
							.fileOverride() // 覆盖已生成文件
							.outputDir(".\\src\\main\\java")// 指定输出目录
							.disableOpenDir();
				})
				.packageConfig(builder -> {
					builder.parent("com.jian") // 设置父包名
							//.moduleName("com.jian") // 设置父包模块名
							.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "../../mappers")); // 设置mapperXml生成路径
				})
				.strategyConfig(builder -> {
					builder.addInclude("admin_user")// 设置需要生成的表名
							.addTablePrefix().entityBuilder().enableLombok(); // 设置过滤表前缀
				})
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();

	}

	public static void   to(){
		FastAutoGenerator.create(DB_URL ,USERNAME, PASSWORD)
				// 全局配置
				.globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者")).fileOverride())
				// 包配置
				.packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名")))
				// 策略配置
				.strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名，多个表名用,隔开:")).addTablePrefix()
						.controllerBuilder().enableRestStyle().enableHyphenStyle()
						.entityBuilder().enableLombok().build())
				/*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();


// 处理 all 情况
//		protected static List<String> getTables(String tables) {
//			return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
//		}

	}
	
}
