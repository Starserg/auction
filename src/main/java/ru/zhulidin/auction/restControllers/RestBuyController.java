package ru.zhulidin.auction.restControllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zhulidin.auction.entities.Product;
import ru.zhulidin.auction.entities.User;
import ru.zhulidin.auction.repositories.ProductRepository;

import java.util.Calendar;
import java.util.Date;


@RestController
public class RestBuyController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/buyOne", method = RequestMethod.GET, produces = "application/json")
    public String buyOne(@AuthenticationPrincipal User user, @RequestParam(name = "id") Product product) {
        product.setBuyer(user);
        product.setPrice(product.getRedemptionPrice());
        product.setAvailable(false);
        productRepository.save(product);
        return new Gson().toJson("success");
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET, produces = "application/json")
    public String buy(@AuthenticationPrincipal User user, @RequestParam(name = "id") Product product) {
        if (product.isAvailable()) {

            if (product.getDateCreated().getTime() + 120000 < Calendar.getInstance().getTime().getTime()) {
                product.setAvailable(false);
                productRepository.save(product);
                return new Gson().toJson("Время истекло");

            }
            product.setBuyer(user);
            product.setPrice(product.getPrice() + (int) ((product.getPrice() * 10) / 100));
            productRepository.save(product);
        }

        return new Gson().toJson("success");
    }


}
