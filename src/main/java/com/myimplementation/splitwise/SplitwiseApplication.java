package com.myimplementation.splitwise;

import com.myimplementation.splitwise.commanddesignpattern.Command;
import com.myimplementation.splitwise.commanddesignpattern.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scn=new Scanner(System.in);
		System.out.println("In the Command Line Terminal mode, Enter the Commands:");

		while (true){
			String input=scn.nextLine();

			try{
				Command command= CommandRegistry.getInstance().getCommand(input);
				command.execute(input);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
