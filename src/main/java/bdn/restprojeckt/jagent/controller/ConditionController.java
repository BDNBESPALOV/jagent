package bdn.restprojeckt.jagent.controller;

import bdn.restprojeckt.jagent.model.Condition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ConditionController {
    Condition condition = new Condition(new Date(),true,"SP");

    @GetMapping("/condition")
    public Condition getCondotion(){
        return condition;
    }

}
