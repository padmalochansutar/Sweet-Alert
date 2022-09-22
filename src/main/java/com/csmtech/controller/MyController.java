package com.csmtech.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.spi.RegisterableService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csmtech.entity.Block;
import com.csmtech.entity.Cable;
import com.csmtech.entity.Dist;
import com.csmtech.entity.Register;
import com.csmtech.entity.Village;
import com.csmtech.service.BlockService;
import com.csmtech.service.CableService;
import com.csmtech.service.DistService;
import com.csmtech.service.RegisterService;
import com.csmtech.service.VillageService;

@Controller
public class MyController {
	@Autowired
	private DistService distService;
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private VillageService villageService;
	@Autowired
	private CableService cableService;
	@Autowired
	private RegisterService registerService; 
	@GetMapping("/test")
	public String test(Model model) {
		
		model.addAttribute("distList",distService.findData());
		
		model.addAttribute("cableList",cableService.findData());
		return "register";
	}
	@GetMapping("/viewPage")
	public String data() {
		return "view";
	}
	String data="";
	@GetMapping("/getDistId")
	public void blockData(@RequestParam("distBlock")Integer id,HttpServletResponse resp ) throws IOException {
		PrintWriter pw = resp.getWriter();
		List<Block> fetchData = blockService.fetchData(id);
		data += "<option value='" + 0 + "'>" + "--SELECT--" + "</option>";
		for (Block block : fetchData) {
			data +="<option value='" +block.getBlockId() +"'>" + block.getBlockName() + "</option>";
		}
		pw.print(data);
		data=null;
	}
	@GetMapping("/getBlockId")
	public void villageData(@RequestParam("blockVillage") Integer id,HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		List<Village> villageList=villageService.fetchData(id);
		data += "<option value='" + 0 + "'>" + "--SELECT--" + "</option>";
		for (Village village : villageList) {
			data +="<option value='" +village.getVillageId() +"'>" + village.getVillageName() + "</option>";
		}
		pw.print(data);
		data=null;
		
	}
	
	@PostMapping("/saveData")
	public String saveData(@RequestParam("name")String name,@RequestParam("number")Long number,
			@RequestParam("email")String email,@RequestParam("gender")String gender,@RequestParam("dob")String date,
			@RequestParam("distId")Dist distId,@RequestParam("blockId")Block blockId,@RequestParam("villageId")Village villageId,
			@RequestParam("address")String address,@RequestParam("pin")Long pin,@RequestParam("pic")MultipartFile pic,
			@RequestParam("cableId")Cable cableId,Model model) throws ServletException, IOException
			{
		//System.out.println(distId);
		model.addAttribute("distList",distService.findData());
		model.addAttribute("cableList",cableService.findData());
		String msg="";
		String ms="";
		if(pic.isEmpty()) {
			msg="please upload file";
			model.addAttribute("message",msg);
			return "register";
		}
		if(name.equals(null) || number.equals(null) || email.equals(null) || gender.equals(null) || date.equals(null) || distId.equals(0)
				|| blockId.equals(0) || villageId.equals(0) || address.equals(null) || pin.equals(null) || cableId.equals(0)) {
			ms="All fields are manadatory";
			model.addAttribute("messag",ms);
			 
		
			return "register";
		}
//		LocalDate currentDate = LocalDate. now(); 
//		System.out.println("the date is:"+currentDate. minusYears(2));
		
		File f = new File("E:/FileUpload/" + pic.getOriginalFilename());
		BufferedOutputStream bf = null;
		try {
			byte[] bytes = pic.getBytes();
			bf = new BufferedOutputStream(new FileOutputStream(f));
			bf.write(bytes);
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	String pattern = "yyyy-MM-dd";
//		try {
//			Date da = new SimpleDateFormat(pattern).parse(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Register register=new Register();
		register.setrName(name);
		register.setEmailId(email);
		register.setGender(gender);
		try {
			register.setDate(new SimpleDateFormat(pattern).parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		register.setPic("E:/FileUpload/" + pic.getOriginalFilename());
		register.setDist(distId);
		register.setBlock(blockId);
		register.setVillage(villageId);
		register.setCable(cableId);
		register.setAddress(address);
		register.setPincode(pin);
		register.setMobileNo(number);
		String res="";
		List<Object[]> fetchData = registerService.fetchData(number,email);
		System.out.println("the data is:"+fetchData);
		try {
		for (Object[] objects : fetchData) {
			System.out.println("the number is:"+objects[0]+"the email is:"+objects[1]);
			
			if(objects[1].equals(number) ) {
				model.addAttribute("res",number);
				return "register";
				
			}
			
			else if(objects[0].equals(email)) {
				model.addAttribute("ema",email);
				return "register";
			}
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
			
		String saveData = registerService.saveData(register);
		
		if(saveData !=null) {
			model.addAttribute("data",saveData);
			return "register";
		}
		else if(saveData.equals(null)) {
			model.addAttribute("failed",1);
			return "register";
			
		}
		System.out.println("the save data is:"+saveData);
		return "redirect:./allData";
		
	}

	@GetMapping("/allData")
	public String allData(Model model) {
		 List<Register> findData = registerService.findData();
		 System.out.println("the all data is:"+findData);
		 model.addAttribute("dataList",findData);
		 model.addAttribute("cableList",cableService.findData());
		 model.addAttribute("distList",distService.findData());
		 return "view";
		
	}
	@GetMapping("/data")
public String cableData(@RequestParam("cableId") Integer cId,Model model) {
		System.out.println("the cable Id is:_"+cId);
	List<Register> findData = registerService.findData(cId);
		
		System.out.println("the cable data is:"+findData);
		//System.out.println("the cable type data is:"+register);
		 model.addAttribute("cableList",cableService.findData());
		
		model.addAttribute("dataList",findData);
	return  "view";
}
	@GetMapping("/data1")
	public String distData(@RequestParam("distId") Integer dId,Model model) {
			
		List<Register> findData = registerService.findDistId(dId);
			
			
			
			 model.addAttribute("distList",distService.findData());
			model.addAttribute("dataList",findData);
		return  "view";
}
}
