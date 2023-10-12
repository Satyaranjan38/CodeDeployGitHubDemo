package com.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pratice.serviceimpl.GitHubService;

@RestController
@RequestMapping("/git")
public class GitHubController {
	@Value("${github.yaml.url}")
    private String githubYamlUrl;

    private final RestTemplate restTemplate;

    public GitHubController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getdata")
    public ResponseEntity<String> getYamlData() {
        return restTemplate.getForEntity(githubYamlUrl, String.class);
    }
    
    
    @Autowired
    private GitHubService gitHubService;
    
    @PostMapping("/update-yaml")
    public String updateYamlFile(@RequestBody String newYamlContent) {
        String commitMessage = "Update emp.yaml"; // Commit message

        boolean success = gitHubService.updateYamlFile(newYamlContent, commitMessage);

        if (success) {
            return "YAML file updated successfully!";
	
        }
		return commitMessage;
    }
}
