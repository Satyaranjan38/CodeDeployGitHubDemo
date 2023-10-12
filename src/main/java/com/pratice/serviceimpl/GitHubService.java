package com.pratice.serviceimpl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@Service
public class GitHubService {

	
	
	@Value("${github.api.url}")
    private String apiUrl;

    @Value("${github.api.token}")
    private String apiToken;

    @Value("${github.repo.owner}")
    private String owner;

    @Value("${github.repo.name}")
    private String repoName;

    @Value("${github.repo.path}")
    private String filePath;

    private final RestTemplate restTemplate;

    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean updateYamlFile(String newYamlContent, String commitMessage) {
        String url = apiUrl + "/repos/" + owner + "/" + repoName + "/contents/" + filePath;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Get current file content
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Map<String, Object>>() {});
        String currentContent = new String(Base64.getDecoder().decode((String) response.getBody().get("content")));

        String currentSha = (String) response.getBody().get("sha");

        // Create a new commit object with the new content
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("message", commitMessage);
        requestBody.put("content", Base64.getEncoder().encodeToString(newYamlContent.getBytes()));
        requestBody.put("sha", currentSha);

        // Send a PUT request to update the file
        ResponseEntity<Map<String, Object>> updateResponse = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(requestBody, headers), new ParameterizedTypeReference<Map<String, Object>>() {});

        return updateResponse.getStatusCode().is2xxSuccessful();
    }
}
