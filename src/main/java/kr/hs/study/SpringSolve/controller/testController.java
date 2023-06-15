package kr.hs.study.SpringSolve.controller;

import kr.hs.study.SpringSolve.dto.test4;
import kr.hs.study.SpringSolve.dto.test5;
import kr.hs.study.SpringSolve.dto.test6;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/test4")
    public String test4(){
        return "test4";
    }

    @PostMapping("/test4")
    public String test4(@ModelAttribute test4 dto, Model model){
        int n = dto.getN();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) list.add("Daniel");

        model.addAttribute("list",list);
        return "result4";
    }

    @GetMapping("/test5")
    public String test5(){
        return "test5";
    }

    @PostMapping("/test5")
    public String test5(@ModelAttribute test5 dto, Model model){
        int n = dto.getN(), m = dto.getM();
        List<String> list = new ArrayList<>();

        if(n > m){
            for(int i = m; i <= n; i++) list.add(String.valueOf(i));
        } else {
            for(int i = n; i <= m; i++) list.add(String.valueOf(i));
        }

        model.addAttribute("list",list);
        return "result5";
    }

    @GetMapping("/test6")
    public String test6(){
        return "test6";
    }

    @PostMapping("/test6")
    public String test6(@ModelAttribute test6 dto, Model model){
        int n = dto.getN();
        int sum = 0;

        for(int i = 1; i<=n; i++) if(i%5==0) sum += i;

        model.addAttribute("result", sum);
        return "result6";
    }
}


