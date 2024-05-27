package com.example.sample.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample.form.ItemForm;
import com.example.sample.model.Item;
import com.example.sample.repository.ItemRepository;

@Controller
public class ItemController {

	private final ItemRepository itemRepository;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	// トップページ表示
	@GetMapping("/")
	public String index() {
		return "top";
	}

	// 商品一覧表示
	@GetMapping("/items")
	public String items(Model model) {
		List<Item> itemList = itemRepository.findByOrderById();
		model.addAttribute("items", itemList);

		return "items";
	}

	// [新規登録]
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("itemForm", new ItemForm());
		
		return "create";
	}

	// 登録画面の処理
	// [登録]
	@PostMapping("/create")
	@Transactional
	public String doCreate(
			@Validated @ModelAttribute ItemForm itemform, 
			BindingResult bindingResult){

		if (bindingResult.hasErrors()) {
			return "create";
		}
	
		itemRepository.save(itemform.toItemEntity());
		
		return "redirect:/items";
	}

	//	[キャンセル]
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/items";
	}

	// 更新画面表示
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		Item item = itemRepository.findById(id).get();
		model.addAttribute("itemForm", item);

		return "update";
	}

	// 更新画面の処理
	@PostMapping("/update")
	@Transactional
	public String doUpdate(
			@AuthenticationPrincipal UserDetails user,
			@Validated @ModelAttribute ItemForm itemform,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "update";
		}
		
		boolean isAdmin = user.getAuthorities().stream()
			      .anyMatch(auth -> "ROLE_ADMIN".equals(auth.getAuthority()));

		if (isAdmin) {
		    itemRepository.save(itemform.toItemEntity());
		  } else {
		    Item item = itemRepository.findById(itemform.getId()).get();
		    if (item.getName().equals(itemform.getName())
		        && item.getPrice().equals(Integer.valueOf(itemform.getPrice()))) {
		      itemRepository.save(itemform.toItemEntity());
		    } else {
		      return "/error/403";
		    }
		  }
		
		return "redirect:/items";
	}

	// 削除処理
	@PostMapping("/delete")
	@Transactional
	public String delete(@RequestParam Integer id) {
		itemRepository.deleteById(id);

		return "redirect:/items";
	}

}
