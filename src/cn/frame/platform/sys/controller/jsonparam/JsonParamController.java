package cn.frame.platform.sys.controller.jsonparam;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.frame.platform.common.util.spring.mvc.bind.annotation.RequestJsonParam;
import cn.frame.platform.common.util.spring.mvc.util.MapWapper;
import cn.frame.platform.sys.controller.UserModel;


@Controller
@RequestMapping("/jsonparam")  
public class JsonParamController {

    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/list?list=[1,2,34]
    //fail http://localhost:9080/springmvc-chapter6/jsonparam/list?list=[1,2,a]
    @RequestMapping("/list")  
    public String list(@RequestJsonParam("list") List<Integer> list) {
        System.out.println(list);
        return "redirect:/success";        
    }
    
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/set?set=[1,2,34]
    //fail http://localhost:9080/springmvc-chapter6/jsonparam/set?set=[1,2,a]
    @RequestMapping("/set")  
    public String set(@RequestJsonParam("set") Set<Integer> set) {
        System.out.println(set);
        return "redirect:/success";        
    }
    
    
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/array?array=[1,2,3]
    //fail http://localhost:9080/springmvc-chapter6/jsonparam/array?array=[1,2,a]
    @RequestMapping("/array")  
    public String list(@RequestJsonParam("array") int[] array) {
        System.out.println(Arrays.toString(array));
        return "redirect:/success";        
    }
    
    
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/map?map={"a":1, "b":2}
    //fail http://localhost:9080/springmvc-chapter6/jsonparam/map?map={"a":1, "b":a}
    @RequestMapping("/map")  
    public String map(@RequestJsonParam(value = "map", required=false) MapWapper<String, Integer> map) {
        System.out.println(map);
        return "redirect:/success";        
    }
    
    
    //UserModel[]
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/array2?array=[{"username":"123"},{"username":"234"}]
    @RequestMapping("/array2")  
    public String array2(@RequestJsonParam(value = "array") UserModel[] array) {
        System.out.println(Arrays.toString(array));
        return "redirect:/success";        
    }

    //List<UserModel>
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/list2?list=[{"username":"123"},{"username":"234"}]
    @RequestMapping("/list2")  
    public String list2(@RequestJsonParam(value = "list") List<UserModel> list) {
        System.out.println(list);
        return "redirect:/success";        
    }

    //Set<UserModel>
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/set2?set=[{"username":"123"},{"username":"234"}]
    @RequestMapping("/set2")  
    public String set2(@RequestJsonParam(value = "set") Set<UserModel> set) {
        System.out.println(set);
        return "redirect:/success";        
    }
    
    //Map<String, UserModel>
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/map2?map={"a":{"username":"123"},"b":{"username":"234"}}
    //暂不支持 Map<UserModel, UserModel>
    @RequestMapping("/map2")  
    public String map2(@RequestJsonParam(value = "map") MapWapper<String, UserModel> map) {
        System.out.println(map);
        return "redirect:/success";        
    }
    
    
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/model1?model={"username":123,"password":234,"realname":"zhang","workInfo":{"city":"abc","job":"abc","year":"abc"}, "schoolInfo":{"schoolType":"1","schoolName":"1","specialty":"1"}}
    //没有realname1
    //fail http://localhost:9080/springmvc-chapter6/jsonparam/model1?model={"username":123,"password":234,"realname1":123}
    @RequestMapping("/model1")  
    public String model1(@RequestJsonParam(value = "model", required=true) UserModel user) {
        System.out.println(user);
        return "redirect:/success";        
    }
    
    //ENUM
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/model2?model={"state":"normal"}
    //List<基本类型>
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/model2?model={"hobbyList":["film", "music"]}
    //Map<基本类型，基本类型>
    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/model2?model={"map":{"key":"value", "a":"b"}}    
//    @RequestMapping("/model2")  
//    public String model2(@RequestJsonParam(value = "model", required=true) DataBinderTestModel model) {
//        System.out.println(model);
//        return "redirect:/success";        
//    }
//    
//    //List<UserModel>
//    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/model3?model={"userList":[{"username":"1"},{"username":"2"}]}
//    //Map<String，UserModel>
//    //ok   http://localhost:9080/springmvc-chapter6/jsonparam/model3?model={"userMap":{"1":{"username":"1"},"2":{"username":"2"}}}
//
//    //暂不支持 类似于 Map<UserModel, UserModel> 形式
//    @RequestMapping("/model3")  
//    public String model3(@RequestJsonParam(value = "model") DataBinderTestModel model) {
//        System.out.println(model);
//        return "redirect:/success";        
//    }
    
    
    

}
