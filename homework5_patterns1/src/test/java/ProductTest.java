import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void TestProduct() {
        Product product1 = Product.builder()
                .id(1)
                .title("title")
                .description("desc")
                .cost(1)
                .weight(2)
                .length(3)
                .height(4)
                .build();


        assertEquals(product1.getTitle(), "title");
        assertEquals(product1.getDescription(), "desc");
        assertEquals(product1.getCost(), 1);
        assertEquals(product1.getLength(), 3);
        assertEquals(product1.getWeight(), 2);
        assertEquals(product1.getHeight(), 4);
    }
}
