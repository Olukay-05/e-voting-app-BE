package com.semicolonafrica.evoting;

import com.semicolonafrica.evoting.data.models.Admin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EVotingApplication {

	public static void main(String[] args) {

		SpringApplication.run(EVotingApplication.class, args);
	}
}
