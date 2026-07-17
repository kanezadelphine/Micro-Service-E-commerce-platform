package com.example.adminService;

import org.springframework.boot.SpringApplication;

public class TestAdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AdminServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
