package com.aston.springWeb.mapper;

import com.aston.springWeb.config.SpringConfig;
import com.aston.springWeb.dto.ProductDescriptionDto;
import com.aston.springWeb.dto.ProductDto;
import com.aston.springWeb.dto.SaleDto;
import com.aston.springWeb.dto.UserDto;
import com.aston.springWeb.entity.Product;
import com.aston.springWeb.entity.ProductDescription;
import com.aston.springWeb.entity.Sale;
import com.aston.springWeb.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringJUnitWebConfig
@ContextConfiguration(classes = SpringConfig.class)
class AllMapperTest {

    @Autowired
    private ProductDescriptionMapper productDescriptionMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductListMapper productListMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserListMapper userListMapper;
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private SaleListMapper saleListMapper;
    @Autowired
    private CycleAvoidingMappingContext context;

    private static ProductDescription productDescription;
    private static ProductDescriptionDto productDescriptionDto;
    private static Product product;
    private static ProductDto productDto;
    private static Sale sale;
    private static SaleDto saleDto;
    private static User user;
    private static UserDto userDto;
    private static List<Product> productList = new ArrayList<>();
    private static List<ProductDto> productDtoList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();
    private static List<UserDto> userDtoList = new ArrayList<>();
    private static List<Sale> sales = new ArrayList<>();
    private static List<SaleDto> saleDtoList = new ArrayList<>();


    @BeforeAll
    static void init() {
        productDescription = new ProductDescription();
        productDescription.setId(1);
        productDescription.setProductId(1);
        productDescription.setBrand("Makita");
        productDescription.setType("electric tool");
        productDescription.setCountryOfOrigin("Japan");
        productDescription.setIssueDate(LocalDate.now());
        productDescriptionDto = new ProductDescriptionDto(
                productDescription.getId(),
                productDescription.getProductId(),
                productDescription.getCountryOfOrigin(),
                productDescription.getType(),
                productDescription.getBrand(),
                productDescription.getIssueDate()
        );
        product = new Product();
        product.setId(1);
        product.setProductName("drill");
        product.setAmount(10);
        product.setProductPrice(10.5);
        product.setDescription(productDescription);
        product.setSales(sales);
        product.setBuyers(userList);
        productDto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getAmount(),
                productDescriptionDto,
                userDtoList,
                saleDtoList
        );
        productList.add(product);
        productDtoList.add(productDto);
        user = new User();
        user.setId(1);
        user.setLogin("alex@");
        user.setPassword("111");
        user.setName("Alexandr");
        user.setSurname("Ivanov");
        user.setUsersRole(1);
        user.setOrders(sales);
        user.setPurchases(productList);
        userDto = new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getUsersRole(),
                productDtoList,
                saleDtoList
        );
        userList.add(user);
        userDtoList.add(userDto);
        sale = new Sale();
        sale.setId(1);
        sale.setBuyer(user);
        sale.setPurchase(product);
        sale.setDateOfSale(LocalDate.now());
        sale.setAmountSale(2);
        saleDto = new SaleDto(
                sale.getId(),
                productDto,
                userDto,
                sale.getDateOfSale(),
                sale.getAmountSale()
        );
        sales.add(sale);
        saleDtoList.add(saleDto);
    }

    @AfterAll
    static void destroy() {
        productDescription = null;
        productDescriptionDto = null;
        product = null;
        productDto = null;
        user = null;
        userDto = null;
        sale = null;
        saleDto = null;
        productList = null;
        productDtoList = null;
        userList = null;
        userDtoList = null;
        sales = null;
        saleDtoList = null;
    }

    @Test
    void successfulMapProductDescription() {
        ProductDescriptionDto productDescDto = productDescriptionMapper.map(productDescription);
        ProductDescription productDescr = productDescriptionMapper.map(productDescriptionDto);
        Assertions.assertAll(
                () -> Assert.assertEquals(productDescr, productDescription),
                () -> Assert.assertEquals(productDescDto, productDescDto)
        );
    }

    @Test
    void MapToProductDescriptionNull() {
        ProductDescription prodDescr = null;
        ProductDescriptionDto prodDescrDto = null;
        ProductDescriptionDto productDescDto = productDescriptionMapper.map(prodDescr);
        ProductDescription productDescription1 = productDescriptionMapper.map(prodDescrDto);
        Assertions.assertAll(
                () -> Assert.assertNull(productDescDto),
                () -> Assert.assertNull(productDescription1)
        );
    }

    @Test
    void successfulMapProduct() {
        Product prod = productMapper.map(productDto, context);
        ProductDto prodDto = productMapper.map(product, context);
        List<User> users = prod.getBuyers();
        List<Sale> sales1 = prod.getSales();
        List<UserDto> userDtos = prodDto.getBuyers();
        List<SaleDto> saleDtos = prodDto.getSales();
        Assertions.assertAll(
                () -> Assert.assertEquals(product, prod),
                () -> Assert.assertEquals(productDto, prodDto),
                () -> Assert.assertEquals(users, userList),
                () -> Assert.assertEquals(userDtos, userDtoList),
                () -> Assert.assertEquals(sales1, sales),
                () -> Assert.assertEquals(saleDtos, saleDtoList)
        );
    }

    @Test
    void MapToProductNull() {
        Product prod = null;
        ProductDto prodDto = null;
        ProductDto prDto = productMapper.map(prod, context);
        Product pr = productMapper.map(prodDto, context);
        Assertions.assertAll(
                () -> Assert.assertNull(prDto),
                () -> Assert.assertNull(pr)
        );
    }


    @Test
    void successfulMapToProductList() {
        List<Product> products = productListMapper.mapList(productDtoList, context);
        List<ProductDto> dtoProducts = productListMapper.mapListDto(productList, context);
        Assertions.assertAll(
                () -> Assert.assertEquals(productList, products),
                () -> Assert.assertEquals(productDtoList, dtoProducts)
        );
    }

    @Test
    void MapToProductListNull() {
        List<Product> productNull = null;
        List<ProductDto> dtoProductsNull = null;
        List<Product> products = productListMapper.mapList(dtoProductsNull, context);
        List<ProductDto> dtoProducts = productListMapper.mapListDto(productNull, context);
        Assertions.assertAll(
                () -> Assert.assertNull(products),
                () -> Assert.assertNull(dtoProducts)
        );
    }

    @Test
    void successfulMapToUser() {
        User us = userMapper.map(userDto, context);
        UserDto usDto = userMapper.map(user, context);
        List<Product> list = us.getPurchases();
        List<ProductDto> listDto = usDto.getPurchases();
        Assertions.assertAll(
                () -> Assert.assertEquals(us, user),
                () -> Assert.assertEquals(usDto, userDto),
                () -> Assert.assertEquals(list, productList),
                () -> Assert.assertEquals(listDto, productDtoList)
        );
    }

    @Test
    void mapToUserNull() {
        User usNull = null;
        UserDto usDtoNull = null;
        User us = userMapper.map(usDtoNull, context);
        UserDto usDto = userMapper.map(usNull, context);
        Assertions.assertAll(
                () -> Assert.assertNull(us),
                () -> Assert.assertNull(usDto)
        );
    }

    @Test
    void mapToUserList() {
        List<User> usList = userListMapper.mapUserDtoList(userDtoList, context);
        List<UserDto> usDtoList = userListMapper.mapUserList(userList, context);
        Assertions.assertAll(
                () -> Assert.assertEquals(userList, usList),
                () -> Assert.assertEquals(userDtoList, usDtoList)
        );
    }

    @Test
    void mapToUserListNull() {
        List<User> users = null;
        List<UserDto> userDtos = null;
        List<User> usList = userListMapper.mapUserDtoList(userDtos, context);
        List<UserDto> usDtoList = userListMapper.mapUserList(users, context);
        Assertions.assertAll(
                () -> Assert.assertNull(usList),
                () -> Assert.assertNull(usDtoList)
        );
    }

    @Test
    void successfulMapSale() {
        Sale sa = saleMapper.map(saleDto, context);
        SaleDto saDto = saleMapper.map(sale, context);
        Assertions.assertAll(
                () -> Assert.assertEquals(sale, sa),
                () -> Assert.assertEquals(saleDto, saDto)
        );
    }

    @Test
    void mapSaleNull() {
        Sale saNull = null;
        SaleDto saDtoNull = null;
        Sale sa = saleMapper.map(saDtoNull, context);
        SaleDto saDto = saleMapper.map(saNull, context);
        Assertions.assertAll(
                () -> Assert.assertNull(sa),
                () -> Assert.assertNull(saDto)
        );
    }

    @Test
    void mapSaleList() {
        List<Sale> saleList = saleListMapper.mapSaleDto(saleDtoList, context);
        List<SaleDto> saleDtos = saleListMapper.mapSale(sales, context);
        Assertions.assertAll(
                () -> Assert.assertEquals(sales, saleList),
                () -> Assert.assertEquals(saleDtos, saleDtos)
        );
    }

    @Test
    void mapSaleListNull() {
        List<Sale> saNull = null;
        List<SaleDto> saDtoNull = null;
        List<Sale> sal = saleListMapper.mapSaleDto(saDtoNull, context);
        List<SaleDto> salDto = saleListMapper.mapSale(saNull, context);
        Assertions.assertAll(
                () -> Assert.assertNull(sal),
                () -> Assert.assertNull(salDto)
        );
    }


}