package com.LearnSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.LearnSpring.Model.Animal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ListAnimalController {
	
	@RequestMapping("/getListAnimal")
	@ResponseBody
	public List<Animal> getAnimals(HttpServletRequest request){
		String idString = request.getParameter("id");
		if(idString != null && idString.equals("1")) {
			Animal animal = new Animal(1, "Con gà", "Gà con");
			Animal animal1 = new Animal(2, "Con chó", "Chó con");
			Animal animal2 = new Animal(3, "Con heo", "heo con");
			Animal animal3 = new Animal(4, "Con khỉ", "khỉ con");
			Animal animal4 = new Animal(5, "Con vịt", "vịt con");
			Animal animal5 = new Animal(6, "Con chuột", "chuột con");
			
			List<Animal> list = new ArrayList<>();
			list.add(animal);
			list.add(animal1);
			list.add(animal2);
			list.add(animal3);
			list.add(animal4);
			list.add(animal5);
			return list;
		}else {
			Animal animal = new Animal(1, "Chỉ có 1 con nha em trai", "Wrong");			
			List<Animal> list = new ArrayList<>();
			list.add(animal);
			return list;
		}
		
	}
	
	
	@RequestMapping("/listanimal")
	public String animal(Model model,  HttpServletRequest request) {
		Animal animal = new Animal(1, "Con gà", "Gà con");
		Animal animal1 = new Animal(2, "Con chó", "Chó con");
		Animal animal2 = new Animal(3, "Con heo", "heo con");
		Animal animal3 = new Animal(4, "Con khỉ", "khỉ con");
		Animal animal4 = new Animal(5, "Con vịt", "vịt con");
		Animal animal5 = new Animal(6, "Con chuột", "chuột con");
		
		List<Animal> list = new ArrayList<Animal>();
		list.add(animal);
		list.add(animal1);
		list.add(animal2);
		list.add(animal3);
		list.add(animal4);
		list.add(animal5);

		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/redirect")
	public RedirectView  redirect() {
	    return new RedirectView("/");
	}
}
