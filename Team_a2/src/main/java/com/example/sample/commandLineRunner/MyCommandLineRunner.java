package com.example.sample.commandLineRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("コマンドラインランナー開始");
    	
        System.out.println("コマンドラインランナー終了"); 
    }
    

}