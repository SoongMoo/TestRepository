package Controller.Json;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;

@Controller
public class JsonController {
	@Autowired
	LoginRepository loginRepository;
	
	@RequestMapping(value= "jsonMian")
	public String jsonMain() {
		return "json/jsonMain";
	}
	@RequestMapping(value= "/json1")
	public String jsonForm1() {
		return "json/jsonTest";
	}
	@RequestMapping(value= "/json2")
	public String jsonForm2() {
		return "json/jsonTest1";
	}
	@RequestMapping(value= "/json3")
	public String jsonForm3() {
		return "json/jsonTest2";
	}
	@RequestMapping(value= "/json4")
	public String jsonForm4() {
		return "json/jsonTest3";
	}
	@RequestMapping(value= "/ajax3.seo", method=RequestMethod.GET)
	public ModelAndView AjaxView( @RequestParam("id") String id)  {  
	    System.out.println("ModelAndView");
		ModelAndView mav= new ModelAndView();

	    MemberDTO member = new MemberDTO();
	    member.setUserId(id);
	    member = loginRepository.selectByUserId(member);
	    System.out.println(member.getUserName());
	    mav.addObject("member",member);
	    mav.setViewName("jsonView");
	    return mav;
	}
	@RequestMapping(value= "/ajax2.seo", method=RequestMethod.GET)
	public @ResponseBody MemberDTO AjaxView2(@RequestParam("id") String id,
	        HttpServletResponse response)  {
		MemberDTO member = new MemberDTO();
	    member.setUserId(id);
	    member = loginRepository.selectByUserId(member);

	    return member;
	}
	@RequestMapping(value= "/ajax1.seo", method=RequestMethod.GET)
	public void AjaxView1(   @RequestParam("id") String id,
	        HttpServletResponse response)  {

	    ObjectMapper mapper = new ObjectMapper();
	    
	    MemberDTO person = new MemberDTO();
	    person.setUserId(id);
	    person = loginRepository.selectByUserId(person);
	    
	    try {
	    	response.setCharacterEncoding("utf-8");
	    	 response.getWriter().print(mapper.writeValueAsString(person));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}
	@RequestMapping(value= "/ajax.seo", method=RequestMethod.GET)
	public void AjaxView(  
	        @RequestParam("id") String id,
	        HttpServletResponse response)  {
		response.setCharacterEncoding("utf-8");
	    String personJson;
	    MemberDTO member = new MemberDTO();
	    member.setUserId(id);
	    member = loginRepository.selectByUserId(member);
	    if(member != null){
	        personJson = "{\"id\":\""+member.getUserId()
	                    +"\",\"name\":\""+member.getUserName()
	                    +"\",\"password\":\""+member.getUserPw()
	                    +"\",\"email\":\""+member.getUserEmail()
	                    +"\"}";
	    }
	    else{
	        personJson = "null";
	    }
	    try {
	        response.getWriter().print(personJson);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}
}
