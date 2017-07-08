package org.wangss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wangss.Mapper.PersonMapper;
import org.wangss.Model.Person;
import org.wangss.Model.PersonExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangss on 2017/7/8.
 */

@Controller
public class IndexController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("index")
    public ModelAndView index(){

        Map map = new HashMap<String,String>();
        PersonExample example = new PersonExample();
        List<Person> users = personMapper.selectByExample(example);
        map.put("para1",users);
        return new ModelAndView("index",map);
    }
}