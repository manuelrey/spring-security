package com.manuelrey.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manuelrey.dao.ClientRepository;
import com.manuelrey.entities.Client;
	
@Controller
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value="/user/index")
	public String index(Model model,
			@RequestParam(name="page", defaultValue="0")int p,
			@RequestParam(name="size", defaultValue="4")int s,
			@RequestParam(name="key", defaultValue="")String se){
		Page<Client> pageClients=
				clientRepository.search("%"+se+"%", new PageRequest(p,s));
		
		model.addAttribute("listClients", pageClients.getContent());
		int[] pages = new int[pageClients.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCurrent", p);
		model.addAttribute("key", se);
		return "clients";
	}
	@RequestMapping(value="/admin/delete", method=RequestMethod.GET)
	public String delete(Long id, String key, int page, int size){
		clientRepository.delete(id);
		return "redirect:/user/index?page="+page+"&size="+size+"&key="+key;
	}
	
	@RequestMapping(value="/admin/add", method=RequestMethod.GET)
	public String addClient(Model model){
		model.addAttribute("client", new Client());
		return "addClient";
	}
	
	@RequestMapping(value="/admin/edit", method=RequestMethod.GET)
	public String edit(Model model, Long id){
		Client p=clientRepository.findOne(id);
		model.addAttribute("client", p);
		return "editClient";
	}
	
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String save(Model model,@Valid Client client, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "addClient";
		clientRepository.save(client);
		return "confirmation";
	}
	
	@RequestMapping(value="/")
	public String home(){
		return "redirect:/user/index";
	}
	
	@RequestMapping(value="/403")
	public String accessDenied(){
		return "403";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
}
