/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ti.umy.RupiahConverter;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.ConverterProcess;
/**
 *
 * @author muhammad dzaki
 */
@Controller
public class ConverterController {
    
    @RequestMapping("/inputData")
    public String getData(HttpServletRequest data, Model conv){
        String inputRp = data.getParameter("inputRupiah");
        
        Double Rupiah = Double.valueOf(inputRp);
        
        ConverterProcess Conv = new ConverterProcess();
        
        Double Dollar = Conv.Dollar(Rupiah);
        Double Euro = Conv.Euro(Rupiah);
        Double Yen = Conv.Yen(Rupiah);
        Double Rupee = Conv.Rupee(Rupiah);
        Double Ringgit = Conv.Ringgit(Rupiah);
        
        conv.addAttribute("outDollar", Dollar);
        conv.addAttribute("outEuro", Euro);
        conv.addAttribute("outYen", Yen);
        conv.addAttribute("outRupee", Rupee);
        conv.addAttribute("outRinggit", Ringgit);
        
        return "viewConverter";
    }
}
