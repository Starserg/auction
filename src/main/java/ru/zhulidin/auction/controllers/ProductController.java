package ru.zhulidin.auction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zhulidin.auction.entities.Product;
import ru.zhulidin.auction.entities.User;
import ru.zhulidin.auction.helpers.ErrorHelpers.ControllerUtils;
import ru.zhulidin.auction.services.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("{productID}")
    public String getProduct(@PathVariable("productID") Product product, Model model) {
        model.addAttribute("product", product);
        return "product";
    }


    @GetMapping("addproduct")
    public String getAddProduct(Model model) {
        return "addproduct";
    }


    @PostMapping("addproduct")
    public String addProduct(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file,
            @Valid Product product,
            BindingResult bindingResult,
            Model model
    ) throws IOException {

        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            System.out.println("errors");
            return "addproduct";
        } else {
           productService.add(user, product.getName(), product.getPrice(), product.getRedemptionPrice(), product.getDescription(), file);
        }

         return "redirect:/product/" + productService.findByName(product.getName()).getId();
    }

    @GetMapping("boughtproducts")
    public String getBoughtProduct(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("products", productService.findByBuyer(user));
        return "boughtproducts";
    }
}
