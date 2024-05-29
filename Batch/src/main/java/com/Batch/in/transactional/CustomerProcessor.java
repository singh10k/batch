package com.Batch.in.transactional;

import com.Batch.in.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product customer) throws Exception {
        return customer;
    }
}
