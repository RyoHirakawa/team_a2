package com.example.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.sample.model.Item;
import com.example.sample.model.Role;
import com.example.sample.repository.ItemRepository;
import com.example.sample.repository.RoleRepository;

import jakarta.annotation.PostConstruct;


@Configuration
public class DataLoader {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ItemRepository itemRepository;

    
    @PostConstruct
    public void loadRoles() {
        if (roleRepository.findByName("USER") == null) {
            Role userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);
        }
        
        if (itemRepository.findByName("漢字ドリル") == null) {
            Item item = new Item();
            item.setStockQuantity(50);
            item.setPrice(780);
            item.setName("漢字ドリル");
            itemRepository.save(item);
        }
    }
}
