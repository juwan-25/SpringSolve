package kr.hs.study.SpringSolve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testController {
    @GetMapping("/test1")
    public String test1(@RequestParam("n") int n,
                        @RequestParam("m") int m,
                        Model model) {
        int sum = 0;
        for(int i = n; i<=m; i++) sum += i;

        model.addAttribute("result", sum);

        return "result";
    }

    @GetMapping("/test2")
    public String test2(@RequestParam("n") int n,
                        Model model) {
        List<String> list = new ArrayList<>();

        for(int i = 1; i<=100; i++) if(i%n==0) list.add(String.valueOf(i));

        model.addAttribute("list",list);

        return "result2";
    }

    @GetMapping("/test3")
    public String test3(@RequestParam("n") int n,
                        Model model) {
        int sum = 0, cnt = 0;
        for(int i = 100; i<=999; i++) {
            if(i%n==0){
                sum += i;
                cnt++;
            }
        }

        model.addAttribute("sum", sum);
        model.addAttribute("cnt", cnt);

        return "result3";
    }
}


