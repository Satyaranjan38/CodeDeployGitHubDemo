package com.pratice.service;

import com.yaml.Employee;

public interface YamlService {

	boolean updateFile(String owner, String repoName, String filePath, String content, String commitMessage);
   
	
}
