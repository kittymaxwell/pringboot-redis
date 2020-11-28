package com;
 
import java.sql.SQLException;
import java.util.Scanner;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

public class MyBatisPlusGenerator {
	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotBlank(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}
	public static void main(String[] args) throws SQLException {
		        String projectPath = System.getProperty("user.dir");
		        //1. 全局配置
				GlobalConfig config = new GlobalConfig();
				config.setActiveRecord(true) // 是否支持AR模式
					  .setAuthor("Rambo") // 作者
		              .setOutputDir(projectPath + "/src/main/java")// 生成路径
					  .setFileOverride(true)  // 文件覆盖
					  .setIdType(IdType.AUTO) // 主键策略
					  .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I 如IEmployeeService
						.setSwagger2(true)//实体属性 Swagger2 注解
		 			  .setBaseResultMap(true)//生成基本的resultMap
		 			  .setBaseColumnList(true);//生成基本的SQL片段 
				
				//2. 数据源配置
				DataSourceConfig  dsConfig  = new DataSourceConfig();
				dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
						.setDriverName("com.mysql.cj.jdbc.Driver")
						.setUrl("jdbc:mysql://47.107.177.115:3306/plugin_dev?useUnicode=true&autoReconnect=true&allowMultiQueries=true&useSSL=false&allowPublicKeyRetrieval=true")
						.setUsername("root")
						.setPassword("qwer1234");

				//3. 包名策略配置
				PackageConfig pkConfig = new PackageConfig();
				pkConfig.setParent("com.rambo.plugin.module")
						.setModuleName("advise")
						.setMapper("mapper")//dao
						.setService("service")//servcie
						.setController("controller")//controller
						.setEntity("entity")
						.setXml("mapper");//mapper.xml

				//4. 策略配置globalConfiguration中
				StrategyConfig strategy = new StrategyConfig();
				strategy.setNaming(NamingStrategy.underline_to_camel);
				strategy.setColumnNaming(NamingStrategy.underline_to_camel);
				//strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
				strategy.setEntityLombokModel(true);
				strategy.setRestControllerStyle(true);
				// 公共父类
				//strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
				// 写于父类中的公共字段
				strategy.setSuperEntityColumns("id");
				strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
				strategy.setControllerMappingHyphenStyle(true);
				strategy.setTablePrefix(pkConfig.getModuleName() + "_");
				

				
				//5. 整合配置
				AutoGenerator  ag = new AutoGenerator();
				ag.setGlobalConfig(config)
				  .setDataSource(dsConfig)
				  .setStrategy(strategy)
				  .setPackageInfo(pkConfig);
				
				//6. 执行
				ag.execute();
	}
 
}