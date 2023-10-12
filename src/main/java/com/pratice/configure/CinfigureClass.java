package com.pratice.configure;

import java.io.InputStream;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

@Configuration
public class CinfigureClass {
	
	 public Object getYamlData(String path) {
	        Yaml yaml = new Yaml();
	        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path)) {
	            return yaml.load(inputStream);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
