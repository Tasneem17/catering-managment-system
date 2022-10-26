/*  HomeController.java
    Starting point of controller
    Author: Wilbur Deano Smith (220003033)
    Date: 18 August 2022
*/
package za.ac.cput.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

//    Testing controller
//    This will display Hello in the browser when going to localhost:8080/home/hello

    @GetMapping("/hello")
    public String hello(){
        return "What is the ";
    }
}
