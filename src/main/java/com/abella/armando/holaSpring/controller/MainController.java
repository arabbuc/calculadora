package com.abella.armando.holaSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;

/**
 * Hola
 */
@Controller
public class MainController {

    @GetMapping ("/")
    @ResponseBody
    public String HolaMundo(@RequestParam("Nombre") String name,@RequestParam("edad") String edad  ){

        return "Hola: "+ name + "Tienes:"+Integer.parseInt(edad)+" años";

    }
    @GetMapping("/nuevo")
    public ModelAndView helloHtml(){
        ModelAndView respuesta= new ModelAndView("hello");
        String msg="Hola Mundo html";
        respuesta.addObject("mensaje", msg);
        return respuesta;
    }
//**************************************************************** */
    @GetMapping("/calculator")
    @ResponseBody
    public String  calculator(@RequestParam("op1") String op1,
    @RequestParam("op2") String op2,
    @RequestParam("operador") String operador)
        {
        String result;
        Double cosa;
        String salida="";
        switch (operador) {
            case "s":
                cosa=Double.parseDouble(op1)+Double.parseDouble(op2);
            break;
            case "-":
                cosa=Double.parseDouble(op1)-Double.parseDouble(op2);
            break;
            case "*":
                cosa=Double.parseDouble(op1)*Double.parseDouble(op2);
            break;
            case "/":
                cosa=Double.parseDouble(op1)/Double.parseDouble(op2);
            break;
        
            default:
                cosa=0.0;
                break;
        }
        result=cosa.toString();
        salida="El resultado de la operación es: "+ result;
        return salida;

    }
/*******************************************************************/
}