package com.ohgiraffers.management.product.controller;

import com.ohgiraffers.common.SearchCondition;
import com.ohgiraffers.management.product.model.dto.ProductDTO;
import com.ohgiraffers.management.product.model.service.ProductService;
import com.ohgiraffers.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {

    // * 주석을 지우고 Controller 역할에 해당하는 내용을 작성하세요.

    // 1. 자주 사용할 Service와 Print 객체를 선언하고, Controller 객체 생성 시 생성되도록 작성하세요.

    private final ProductPrint productPrint;
    private final ProductService productService;

    public ProductController() {
        productPrint = new ProductPrint();
        productService = new ProductService();
    }

    public void selectAllProductList() {

        // 2. 전체 제품 목록을 조회하는 메소드
        //    (조건 1) Service 객체를 호출하여 List<ProductDTO> 타입으로 전체 제품 목록을 조회하세요.
        //    (조건 2) 제품 목록이 비어있지 않은 경우, Print 객체를 통해 제품 목록을 출력하세요.
        //    (조건 3) 제품 목록이 없는 경우, Print 객체를 통해 조회 결과가 없다는 오류 메세지를 출력하세요.

        List<ProductDTO> allProductList = productService.selectAllProductList();

        if(allProductList != null && !allProductList.isEmpty()) {
            productPrint.printAllProductList(allProductList);
        } else {
            productPrint.printErrorMessage("selectAllProductList");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if(productList != null && !productList.isEmpty()) {
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("selectProductList");
        }

    }

    public void registNewProduct(ProductDTO product) {

        if(productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("registProduct");
        } else {
            productPrint.printErrorMessage("registProduct");
        }

    }

    public void modifyProductInfo(ProductDTO product) {


        if(productService.modifyProductInfo(product)) {
            productPrint.printSuccessMessage("modifyProduct");
        } else {
            productPrint.printErrorMessage("modifyProduct");
        }

    }

    public void deleteProduct(Map<String, String> parameter) {

        if(productService.deleteProduct(parameter)) {
            productPrint.printSuccessMessage("deleteProduct");
        } else {
            productPrint.printErrorMessage("deleteProduct");
        }

    }

}
