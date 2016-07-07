package cn.frame.platform.sys.controller.formmodel;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.frame.platform.common.util.spring.mvc.bind.annotation.FormModel;
import cn.frame.platform.common.util.spring.mvc.util.MapWapper;
import cn.frame.platform.sys.controller.UserModel;


@Controller
@RequestMapping("/formmodel")  
public class FormModelController {

    //ok   http://localhost:9080/springmvc-chapter6/formmodel/user?user.username=zhang&user.password=123
    @RequestMapping("/user/{user.realname}")  
    public String user(@FormModel("user") UserModel user) {
        System.out.println(user);
        return "redirect:/success";        
    }
    
    //ok   http://localhost:9080/springmvc-chapter6/formmodel/array1?array[0]=zhang&array[1]=li
    @RequestMapping("/array1")  
    public String array1(@FormModel("array") String[] array) {
        System.out.println(Arrays.toString(array));
        return "redirect:/success";        
    }
    
    //ok   http://localhost:9080/springmvc-chapter6/formmodel/array2?array[0].username=zhang&array[0].password=123&array[1].username=li
    @RequestMapping("/array2")  
    public String array2(@FormModel("array") UserModel[] array) {
        System.out.println(Arrays.toString(array));
        return "redirect:/success";        
    }
    
    
  //ok   http://localhost:9080/springmvc-chapter6/formmodel/list1?list[0]=123&list[1]=234
    @RequestMapping("/list1")  
    public String list1(@FormModel("list") List<Integer> list) {
        System.out.println(list);
        return "redirect:/success";        
    }
    
    //ok   http://localhost:9080/springmvc-chapter6/formmodel/list2?list[0].username=zhang&list[1].username=li
    @RequestMapping("/list2")  
    public String list2(@FormModel("list") List<UserModel> list) {
        System.out.println(list);
        return "redirect:/success";        
    }
    
    //ok   http://localhost:9080/springmvc-chapter6/formmodel/map1?map['0']=123&map["1"]=234
    @RequestMapping("/map1")  
    public String map1(@FormModel("map") MapWapper<String, Integer> map) {
        System.out.println(map);
        return "redirect:/success";        
    }
  //ok   http://localhost:9080/springmvc-chapter6/formmodel/map2?map['0'].password=123&map['0'].username=123&map["1"].username=234
    @RequestMapping("/map2")  
    public String map2(@FormModel("map") MapWapper<Integer, UserModel> map) {
        System.out.println(map);
        return "redirect:/success";        
    }
}
