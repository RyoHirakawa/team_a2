package com.example.sample.commandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sample.service.StudentService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("コマンドラインランナー開始");
    	
        System.out.println("コマンドラインランナー終了"); 
    }
}