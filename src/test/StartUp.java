package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class StartUp {

	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		File configFile = new File(StartUp.class.getResource("/generatorConfig.xml").toURI());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		
		DefaultShellCallback shellCallback = new DefaultShellCallback(true);
		
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
		myBatisGenerator.generate(null);
	}

}
