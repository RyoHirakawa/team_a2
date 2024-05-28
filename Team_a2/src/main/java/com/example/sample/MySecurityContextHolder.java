//package com.example.sample;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
//@Component
//public class MySecurityContextHolder {
//    
//    public void someMethod() {
//        // 認証情報を取得
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // 認証情報が存在し、ユーザーが認証されている場合
//        if (authentication != null && authentication.isAuthenticated()) {
//            // ユーザー名を取得
//            String username = authentication.getName();
//            
//            // ユーザーの権限情報を取得
//            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//            
//            // 権限情報を出力
//            for (GrantedAuthority authority : authorities) {
//                System.out.println("権限: " + authority.getAuthority());
//            }
//        } else {
//            // 認証されていない場合の処理
//        }
//    }
//}
