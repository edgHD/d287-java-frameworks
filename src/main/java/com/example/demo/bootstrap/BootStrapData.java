package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

        // Add sample ingredients (parts) if the part repository is empty
        if (partRepository.count() == 0) {
            InhousePart flour = new InhousePart();
            flour.setName("Flour");
            flour.setPrice(1.99);
            flour.setInv(100);

            InhousePart sugar = new InhousePart();
            sugar.setName("Sugar");
            sugar.setPrice(0.99);
            sugar.setInv(50);

            InhousePart eggs = new InhousePart();
            eggs.setName("Eggs");
            eggs.setPrice(3.99);
            eggs.setInv(30);

            InhousePart butter = new InhousePart();
            butter.setName("Butter");
            butter.setPrice(2.49);
            butter.setInv(40);

            InhousePart vanillaExtract = new InhousePart();
            vanillaExtract.setName("Vanilla Extract");
            vanillaExtract.setPrice(5.49);
            vanillaExtract.setInv(20);

            partRepository.save(flour);
            partRepository.save(sugar);
            partRepository.save(eggs);
            partRepository.save(butter);
            partRepository.save(vanillaExtract);
        }

        // Add sample baked goods (products) if the product repository is empty
        if (productRepository.count() == 0) {
            Product sugarCookies = new Product(1, "Sugar Cookies", 9.99, 15);
            Product vanillaCupcakes = new Product(2, "Vanilla Cupcakes", 12.99, 10);
            Product sourdoughBread = new Product(3, "Sourdough Bread", 4.99, 20);
            Product croissants = new Product(4, "Croissants", 8.99, 12);
            Product fruitTarts = new Product(5, "Fruit Tarts", 14.99, 8);

            productRepository.save(sugarCookies);
            productRepository.save(vanillaCupcakes);
            productRepository.save(sourdoughBread);
            productRepository.save(croissants);
            productRepository.save(fruitTarts);
        }
    }
}
