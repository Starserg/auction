package ru.zhulidin.auction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zhulidin.auction.entities.Product;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("addproduct")
    public String getAddProduct(Model model) {
        return "addproduct";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("addproduct")
    public String addProduct(
            @RequestParam("file") MultipartFile file,
            @RequestParam String categoryTemp,
            @Valid Product product,
            BindingResult bindingResult,
            Model model
    ) throws IOException {

        if (bindingResult.hasErrors() || StringUtils.isEmpty(categoryTemp)){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            System.out.println("errors");
            return "addproduct";
        } else {
           productService.add(product.getName(), product.getPrice(), product.getRedemptionPrice(), product.getDescription(), file);
        }

         return "redirect:/product/" + productService.findByName(product.getName()).getId();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("editproduct/{productCurrent}")
    public String editProduct(
            @PathVariable Product productCurrent,
            @RequestParam("file") MultipartFile file,
            @RequestParam String categoryTemp,
            @Valid Product product,
            BindingResult bindingResult,
            Model model

    ) throws IOException {
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            System.out.println("errors");

            model.addAttribute("product", product);
            return "redirect:/product/" + productCurrent.getId();
        } else {
            productService.updateProduct(productCurrent, product.getName(), product.getPrice(), product.getDescription(), product.getRedemptionPrice(), file, product.isAvailable());
        }
        return "redirect:/product/" + productCurrent.getId();
    }
}
