package com.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
    public String index(@RequestParam(value="firstname", required = false) String paramFirstName, @RequestParam(value="lastname", required = false) String paramLastName, @RequestParam(value="times", required = false) String paramTimes) {
		String userNameString;
		
        if(paramFirstName == null && paramLastName == null) {
        	userNameString = "Hello Human";
        } else if(paramLastName == null) {
        	userNameString = "Hello " + paramFirstName;
        } else if (paramFirstName == null) {
        	userNameString = "Hello " + paramLastName;
        } else {
        	userNameString = "Hello " + paramFirstName + " " + paramLastName;
        }
        
        if(paramTimes != null && Integer.parseInt(paramTimes) > 1) {
        	for(int i = 0; i < Integer.parseInt(paramTimes) - 1; i++) {
        		userNameString += " Hello " + (paramFirstName != null ? paramFirstName : "") + " " + (paramLastName != null ? paramLastName : "");
        	}
        }
        
        return userNameString;
    }

}
