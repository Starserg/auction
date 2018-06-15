package ru.zhulidin.auction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.zhulidin.auction.entities.Product;
import ru.zhulidin.auction.entities.User;
import ru.zhulidin.auction.helpers.fileHelpers.FileHelper;
import ru.zhulidin.auction.repositories.ProductRepository;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${generalPicture}")
    private String generalPicture;

    public void add(User user, String title, Integer price, Integer redemptionPrice, String description, MultipartFile file)
            throws IOException {
        Product product = new Product(title, price, description, redemptionPrice);
        String path = FileHelper.loadFile(file, uploadPath);
        if (!StringUtils.isEmpty(path)) {
            product.setImageUrl(path);
        } else {
            product.setImageUrl(generalPicture);
        }
        product.setDateCreated(new Date(Calendar.getInstance().getTimeInMillis()));
        product.setAvailable(true);
        product.setOwner(user);
        productRepository.save(product);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
    public List<Product> findByOwner(User user) {
        return productRepository.findByOwner(user);
    }
    public List<Product> findByBuyer(User user) {
        return productRepository.findByOwner(user);
    }


    public void updateProduct(Product product, String name, Integer price, String description, Integer redemptionPrice, MultipartFile file, boolean available)
            throws IOException {
        if (!StringUtils.isEmpty(name)) {
            product.setName(name);
        }

        if (!StringUtils.isEmpty(description)) {
            product.setDescription(description);
        }

        String path = FileHelper.loadFile(file, uploadPath);
        if (!StringUtils.isEmpty(path)) {
            product.setImageUrl(path);
        }

        if (price != null) {
            product.setPrice(price);
        }

        product.setAvailable(available);

        product.setRedemptionPrice(redemptionPrice);

        productRepository.save(product);
    }

    public List<Product> findByAvailable(boolean available) {
        return productRepository.findAllByAvailable(available);
    }
}
