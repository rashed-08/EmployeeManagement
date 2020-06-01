package com.employee.management;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EmployeeManagementApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @LocalServerPort
    private int port;
    
    
    public void setupObject() {
        
    }
    
    private String getRoot() {
        String getRootPath = "http://localhost:" + port;
        return getRootPath;
    }
    
    @Test
    @DisplayName("Get All Employee")
    public void testGetAllEmployee() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRoot() + "/employees", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}
