package com.amisa.sprintevolution.digitalgoldwallet;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
 
public class Validation {
	public static int extractId(String endpoint) {
        String[] parts = endpoint.split("/");
        String idString = parts[parts.length - 1]; 
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid taskId in the endpoint");
        }
    }
}