package org.example;

public class Javaengin {
    public static void main(String[] args) {
        Product product = new Product();
        product.setDiscount(5);

        Product product2 = new Product();

        //getProduct product2 = new Product();

        Product product3 = new Product();

        Product[] products={product,product2,product3};
        for(Product product4:products)
        {
            System.out.println(product4.getDiscount());
        }
        IndividualCustomer individualCustomer = new IndividualCustomer ();
        individualCustomer.setId(1);
        individualCustomer.setPhone("0522222222");
        individualCustomer.setCustomerNumber ("12345");
        individualCustomer.setFirstName("Engin");
        individualCustomer.setLastName("Demirog");
        CorporateCustomer corporateCustomer = new CorporateCustomer ();
        corporateCustomer .setId(2);
        corporateCustomer.setXcompanyName ("Kodlama.io");
        corporateCustomer.setPhone("0533333333");
        corporateCustomer.setTaxNumber ("11111111111");
        corporateCustomer.setCustomerNumber ("54321");
        Customer[] customers={individualCustomer,corporateCustomer};
        for (Customer cus:customers){
            System.out.println(cus.getCustomerNumber());
        }
    }

}
