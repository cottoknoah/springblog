package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollController {
    @GetMapping("/roll-dice")

    public String viewRollDice() {
        return "dice";
    }
    //    create a method that rolls a dice 1 - 6 from user input?
//    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)
//    @ResponseBody
//    public String rollDice(@PathVariable int n) {
////        return Math.floor(Math.random() * 6);
////        return String.valueOf(num1 + num2); ----Cleaner use!
//    }



    @PostMapping("/roll-dice/n")
    public  String returnDiceNumber(@RequestParam(name = "roll") String roll, Model model){
        model.addAttribute("roll", roll);
        return "dice roll";

    }

}
