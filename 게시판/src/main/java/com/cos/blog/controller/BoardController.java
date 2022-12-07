package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 컨트롤로에서 세션을 어떻게 찾는지?
	// @AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"", "/"})
	public String index(Model model, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.글목록(pageable));
		return "index"; // viewResolver 작동!!
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		
		return "board/detail";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/updateForm";
	}
	
	// USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	/*
	@GetMapping("/board/notice")
	public String saveForm() {
		return "board/saveForm";
	}

	@GetMapping("/board/news")
	public String saveForm() {
		return "board/saveForm";
	}*/

	@GetMapping("/board/roadmap")
	public String roadmap() {
		return "board/roadmap";
	}

	@GetMapping("/board/roadmapDetail")
	public String roadmapDetail(@RequestParam(value = "gitName")String gitName, Model model) {
		model.addAttribute("gitName", gitName);
		return "board/roadmapDetail";
	}


	@GetMapping("/board/redirect")
	public String redirect(@RequestParam(value = "occupation")String occupation) {
		final String url = "redirect:https://roadmap.sh/" + occupation;
		return url;
	}

}
