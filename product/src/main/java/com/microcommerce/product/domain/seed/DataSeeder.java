package com.microcommerce.product.domain.seed;

import com.microcommerce.product.domain.entity.Brand;
import com.microcommerce.product.domain.entity.Category;
import com.microcommerce.product.domain.entity.Product;
import com.microcommerce.product.repository.BrandRepository;
import com.microcommerce.product.repository.CategoryRepository;
import com.microcommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        seedProductData();
    }

    private void seedProductData() {
        if (productRepository.count() == 0) {
            List<Product> products = new ArrayList<>();

            Brand brand1 = brandRepository.save(new Brand(null, "Apple"));
            Brand brand2 = brandRepository.save(new Brand(null, "Eti"));
            Brand brand3 = brandRepository.save(new Brand(null, "Starbucks"));
            Brand brand4 = brandRepository.save(new Brand(null, "Casio"));
            Brand brand5 = brandRepository.save(new Brand(null, "Microsoft"));

            Category category1 = categoryRepository.save(new Category(null, "Electronic", "Electronic devices"));
            Category category2 = categoryRepository.save(new Category(null, "Self-care", "Personal beauty"));
            Category category3 = categoryRepository.save(new Category(null, "Food", "All kind of food"));
            Category category4 = categoryRepository.save(new Category(null, "Snack", "Bon apetit!"));
            Category category5 = categoryRepository.save(new Category(null, "Clothes", "Your new clothes"));

            products.add(new Product(null, "Iphone X", "Great phone by Apple", "https://picsum.photos/400/400", BigDecimal.valueOf(10000), Long.valueOf(100), category1, brand1));
            products.add(new Product(null, "Iphone 11", "Great phone by Apple version 11", "https://picsum.photos/400/400", BigDecimal.valueOf(12000), Long.valueOf(200), category1, brand1));
            products.add(new Product(null, "Iphone 12", "Great phone by Apple version 12", "https://picsum.photos/400/400", BigDecimal.valueOf(13000), Long.valueOf(300), category1, brand1));
            products.add(new Product(null, "Iphone 12 S", "Great phone by Apple version 12 S", "https://picsum.photos/400/400", BigDecimal.valueOf(13500), Long.valueOf(400), category1, brand1));
            products.add(new Product(null, "Iphone 12 XS", "Great phone by Apple version 12 XS", "https://picsum.photos/400/400", BigDecimal.valueOf(14000), Long.valueOf(100), category1, brand1));
            products.add(new Product(null, "Iphone 13", "Great phone by Apple version 13", "https://picsum.photos/400/400", BigDecimal.valueOf(14000), Long.valueOf(200), category1, brand1));
            products.add(new Product(null, "Key Holder", "Attractive DesignMetallic materialFour key hooksReliable & DurablePremium Quality", "https://picsum.photos/400/400", BigDecimal.valueOf(110), Long.valueOf(20), category2, brand3));
            products.add(new Product(null, "Handcraft Chinese style", "Great phone by Apple 13 S", "https://picsum.photos/400/400", BigDecimal.valueOf(150), Long.valueOf(30), category2, brand2));
            products.add(new Product(null, "3D Embellishment Art Lamp", "3D led lamp sticker Wall sticker 3d wall art light on/off button  cell operated (included)", "https://picsum.photos/400/400", BigDecimal.valueOf(200), Long.valueOf(100), category3, brand4));
            products.add(new Product(null, "Flying Wooden Bird", "Package Include 6 Birds with Adhesive Tape Shape: 3D Shaped Wooden Birds Material: Wooden MDF, Laminated 3.5mm", "https://picsum.photos/400/400", BigDecimal.valueOf(310), Long.valueOf(100), category4, brand2));
            products.add(new Product(null, "Plant Hanger For Home", "Boho Decor Plant Hanger For Home Wall Decoration Macrame Wall Hanging Shelf", "https://picsum.photos/400/400", BigDecimal.valueOf(220), Long.valueOf(100), category5, brand4));
            products.add(new Product(null, "Gulab Powder 50 Gram", "Dry Rose Flower Powder Gulab Powder 50 Gram • Treats Wounds", "https://picsum.photos/400/400", BigDecimal.valueOf(10), Long.valueOf(100), category4, brand5));
            products.add(new Product(null, "Origin Fruit juicer", "Original fauji cereal muesli 250gm box pack original fauji cereals muesli fruit nuts flakes breakfast cereal break fast faujicereals cerels cerel foji fouji", "https://picsum.photos/400/400", BigDecimal.valueOf(40), Long.valueOf(100), category3, brand2));
            products.add(new Product(null, "Orange Essence Food Flavou", "Specifications of Orange Essence Food Flavour For Cakes and Baking Food Item", "https://picsum.photos/400/400", BigDecimal.valueOf(50), Long.valueOf(100), category4, brand2));
            products.add(new Product(null, "Daal Masoor 500 grams", "Fine quality Branded Product Keep in a cool and dry place", "https://picsum.photos/400/400", BigDecimal.valueOf(200), Long.valueOf(100), category5, brand3));
            products.add(new Product(null, "Freckle Treatment Cream- 15gm", "Fair & Clear is Pakistan's only pure Freckle cream which helpsfade Freckles, Darkspots and pigments. Mercury level is 0%, so there are no side effects.", "https://picsum.photos/400/400", BigDecimal.valueOf(410), Long.valueOf(100), category4, brand4));
            products.add(new Product(null, "Skin Beauty Serum.", "Product name: rorec collagen hyaluronic acid white face serum riceNet weight: 15 m", "https://picsum.photos/400/400", BigDecimal.valueOf(250), Long.valueOf(100), category2, brand5));
            products.add(new Product(null, "Oil Free Moisturizer 100ml", "Dermive Oil Free Moisturizer with SPF 20 is specifically formulated with ceramides, hyaluronic acid & sunscreen.", "https://picsum.photos/400/400", BigDecimal.valueOf(50), Long.valueOf(100), category2, brand2));
            products.add(new Product(null, "Tree Oil 30ml", "Tea tree oil contains a number of compounds, including terpinen-4-ol, that have been shown to kill certain bacteria,", "https://picsum.photos/400/400", BigDecimal.valueOf(220), Long.valueOf(100), category5, brand2));
            products.add(new Product(null, "Hyaluronic Acid Serum", "L'Oral Paris introduces Hyaluron Expert Replumping Serum formulated with 1.5% Hyaluronic Acid", "https://picsum.photos/400/400", BigDecimal.valueOf(420), Long.valueOf(100), category3, brand3));
            products.add(new Product(null, "Eau De Perfume Spray", "Genuine  Al-Rehab spray perfume from UAE/Saudi Arabia/Yemen High Quality", "https://picsum.photos/400/400", BigDecimal.valueOf(500), Long.valueOf(100), category4, brand4));
            products.add(new Product(null, "Fog Scent Xpressio Perfume", "Product details of Best Fog Scent Xpressio Perfume 100ml For Men cool long lasting perfumes for Men", "https://picsum.photos/400/400", BigDecimal.valueOf(210), Long.valueOf(100), category1, brand5));

            productRepository.saveAll(products);
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        /*
        */
        return products;
    }
}
