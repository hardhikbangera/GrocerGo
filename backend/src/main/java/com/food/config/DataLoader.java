package com.food.config;



import com.food.Repository.Item_detailsRepository;
import com.food.model.Item_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private Item_detailsRepository itemDetailsRepo;
    
    @Override
    public void run(String... args) throws Exception {
    	Item_detailsRepository itemDetailsRepository;
        if (itemDetailsRepo.count() == 0){

            // Rice Items
            Item_details rice1 = new Item_details();
            rice1.setName("Basmati Rice Premium");
            rice1.setDescription("Long grain aromatic rice ideal for biryani or pulao.");
            rice1.setPrice(749.0);
            rice1.setImage_url("/images/Basmati Rice Premium.webp");
            rice1.setCategory("Rice");
            
            itemDetailsRepo.save(rice1);

            Item_details rice2 = new Item_details();
            rice2.setName("Sona Masoori Rice");
            rice2.setDescription("Medium-grain fluffy rice perfect for daily meals.");
            rice2.setPrice(549.0);
            rice2.setCategory("Rice");
            rice2.setImage_url("/images/Sona Masoori Rice.jpg");
            itemDetailsRepo.save(rice2);

            Item_details rice3 = new Item_details();
            rice3.setName("Brown Rice");
            rice3.setDescription("Unpolished whole grain rice rich in fiber.");
            rice3.setPrice(699.0);
            rice3.setCategory("Rice");
            rice3.setImage_url("/images/Brown Rice.avif");
            itemDetailsRepo.save(rice3);

            Item_details rice4 = new Item_details();
            rice4.setName("Parboiled Rice");
            rice4.setDescription("Pre-cooked rice that cooks quickly and holds nutrients.");
            rice4.setPrice(499.0);
            rice4.setCategory("Rice");
            rice4.setImage_url("/images/Parboiled Rice.jpg");
            itemDetailsRepo.save(rice4);

            Item_details rice5 = new Item_details();
            rice5.setName("Idly Rice");
            rice5.setDescription("Short-grain rice, ideal for making soft idli and crispy dosa.");
            rice5.setPrice(429.0);
            rice5.setCategory("Rice");
            rice5.setImage_url("/images/Idly Rice.jpg");
            itemDetailsRepo.save(rice5);

            // Daal Items
            Item_details dal1 = new Item_details();
            dal1.setName("Toor Dal (Arhar Dal)");
            dal1.setDescription("Protein-rich yellow lentil popular in Indian households.");
            dal1.setPrice(189.0);
            dal1.setCategory("Dal");
            dal1.setImage_url("/images/Toor Dal (Arhar Dal).jpg");
            itemDetailsRepo.save(dal1);

            Item_details dal2 = new Item_details();
            dal2.setName("Moong Dal");
            dal2.setDescription("Light, easy-to-digest, and full of essential nutrients.");
            dal2.setPrice(179.0);
            dal2.setCategory("Dal");
            dal2.setImage_url("/images/Moong Dal.jpg");
            itemDetailsRepo.save(dal2);

            Item_details dal3 = new Item_details();
            dal3.setName("Chana Dal");
            dal3.setDescription("Split chickpeas rich in protein and good for snacks and curries.");
            dal3.setPrice(169.0);
            dal3.setCategory("Dal");
            dal3.setImage_url("/images/Chana Dal.webp");
            itemDetailsRepo.save(dal3);

            Item_details dal4 = new Item_details();
            dal4.setName("Masoor Dal");
            dal4.setDescription("Quick-cooking red lentils with high protein content.");
            dal4.setPrice(159.0);
            dal4.setCategory("Dal");
            dal4.setImage_url("/images/Masoor Dal.webp");
            itemDetailsRepo.save(dal4);

            // Essentials
            Item_details salt = new Item_details();
            salt.setName("Iodized Salt");
            salt.setDescription("Refined iodized salt to maintain healthy metabolism.");
            salt.setPrice(25.0);
            salt.setCategory("Essentials");
            salt.setImage_url("/images/Iodized Salt.jpg");
            itemDetailsRepo.save(salt);

            Item_details sugar = new Item_details();
            sugar.setName("Refined Sugar");
            sugar.setDescription("Fine-grained refined sugar for everyday use.");
            sugar.setPrice(49.0);
            sugar.setCategory("Essentials");
            sugar.setImage_url("/images/Refined Sugar.jpg");
            itemDetailsRepo.save(sugar);

            // Additional grocery items
            Item_details flour = new Item_details();
            flour.setName("Whole Wheat Flour");
            flour.setDescription("Freshly milled whole wheat flour for baking and cooking.");
            flour.setPrice(259.0);
            flour.setCategory("Flour");
            flour.setImage_url("/images/Whole Wheat Flour.webp");
            itemDetailsRepo.save(flour);

            Item_details oil1 = new Item_details();
            oil1.setName("Sunflower Oil");
            oil1.setDescription("Refined sunflower oil for healthy cooking.");
            oil1.setPrice(110.0);
            oil1.setCategory("Oil");
            oil1.setImage_url("/images/Sunflower Oil.jpg");
            itemDetailsRepo.save(oil1);
            
            Item_details oil2 = new Item_details();
            oil2.setName("Sesame Oil");
            oil2.setDescription("Sesame oil is used for cooking, lighting lamps.");
            oil2.setPrice(110.0);
            oil2.setCategory("Oil");
            oil2.setImage_url("/images/Sesame Oil.webp");
            itemDetailsRepo.save(oil2);

            Item_details tea = new Item_details();
            tea.setName("Assam Tea");
            tea.setDescription("Strong and refreshing Assam black tea.");
            tea.setPrice(150.0);
            tea.setCategory("Beverages");
            tea.setImage_url("/images/Assam Tea.webp");
            itemDetailsRepo.save(tea);

            Item_details coffee = new Item_details();
            coffee.setName("Ground Coffee");
            coffee.setDescription("Rich and aromatic ground coffee powder.");
            coffee.setPrice(210.0);
            coffee.setCategory("Beverages");
            coffee.setImage_url("/images/Ground Coffee.jpg");
            itemDetailsRepo.save(coffee);

            Item_details saltRock = new Item_details();
            saltRock.setName("Rock Salt");
            saltRock.setDescription("Natural rock salt with minerals.");
            saltRock.setPrice(35.0);
            saltRock.setCategory("Essentials");
            saltRock.setImage_url("/images/Rock Salt.jpg");
            itemDetailsRepo.save(saltRock);

            Item_details jaggery = new Item_details();
            jaggery.setName("Organic Jaggery");
            jaggery.setDescription("Unrefined organic jaggery for natural sweetness.");
            jaggery.setPrice(75.0);
            jaggery.setCategory("Essentials");
            jaggery.setImage_url("/images/Organic Jaggery.webp");
            itemDetailsRepo.save(jaggery);

            System.out.println("✅ 20 grocery food items added successfully.");
        }

    }
}

