package com.ohgiraffers.management.product.view;

import com.ohgiraffers.common.SearchCondition;
import com.ohgiraffers.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // 주석을 지우고 다음 네 가지 메소드를 작성하세요.

    public void printAllProductList(List<ProductDTO> allProductList) {

        System.out.println("=========전체 제품 정보 목록==========");
        for(ProductDTO product : allProductList) {
            System.out.println(product);
        }
        System.out.println("===================================");

    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        String searchOption = "";
        switch (searchCondition.getOption()) {
            case "productName" : searchOption = "제품명 검색 결과"; break;
        }

        System.out.println("=========" + searchOption + " 목록==========");
        for(ProductDTO product : productList) {
            System.out.println(product);
        }
        System.out.println("=====================================");

    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
        case "registProduct" : successMessage = "신규 제품을 등록하였습니다. 환영합니다!"; break;
        case "modifyProduct" : successMessage = "제품 정보를 수정하였습니다. 감사합니다!"; break;
        case "deleteProduct" : successMessage = "제품 정보를 삭제하였습니다. 수고하셨습니다."; break;
        }

        System.out.println(successMessage);
        System.out.println("===================================");
    }

    public void printErrorMessage(String errorCode) {

       String errorMessage = "";

        switch (errorCode) {
            case "selectList":
                errorMessage = "메뉴 목록 조회에 실패했습니다.";
                break;
        }
        System.out.println(errorMessage);
    }

}
