package com.ohgiraffers.management.product.view;

import com.ohgiraffers.common.SearchCondition;
import com.ohgiraffers.management.product.controller.ProductController;
import com.ohgiraffers.management.product.model.dto.ProductDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductMenu {
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        ProductController productController = new ProductController();

        do {
            System.out.println("======== Product Info 관리 ========");
            System.out.println("생산 및 판매 제품 정보 관리 화면입니다.");
            System.out.println("===================================");
            System.out.println("1. 전체 제품 정보 조회");
            System.out.println("2. 조건부 제품 정보 조회");
            System.out.println("3. 신규 제품 정보 등록");
            System.out.println("4. 기존 제품 정보 수정");
            System.out.println("5. 제품 삭제");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("===================================");
            System.out.println("원하는 관리 메뉴의 번호를 입력해 주세요 : ");
            int selectMenu = sc.nextInt();
            String searchValue = "";

            switch (selectMenu) {
                case 1 : productController.selectAllProductList(); break;
                case 2 : productController.selectProductByCondition(inputSearchCondition()); break;
                case 3 : productController.registNewProduct(inputNewProductInfo()); break;
                case 4 : productController.modifyProductInfo(inputModifyProductInfo()); break;
                case 5 : productController.deleteProduct(inputProductCode()); break;
                case 9 : System.out.println("========상위 메뉴로 이동합니다.========"); return;
                default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }

        } while(true);
    }

    private static SearchCondition inputSearchCondition() {

        Scanner sc = new Scanner(System.in);
        String searchOption = "";
        String searchValue = "";

        System.out.println("===================================");
        System.out.println("조회하고 싶은 조건을 선택하세요. ");
        System.out.println("===================================");
        System.out.println("1. 제품명으로 조회");
        System.out.println("===================================");
        System.out.println("원하는 조건의 번호를 입력해 주세요 : ");
        int selectMenu = sc.nextInt();

        switch (selectMenu) {
            case 1 :
                sc.nextLine();
                searchOption = "productName";
                System.out.println("조회할 제품명을 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 9 : System.out.println("========상위 메뉴로 이동합니다.========"); return null;
            default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
        }

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setOption(searchOption);
        searchCondition.setValue(searchValue);

        return searchCondition;
    }


    private static ProductDTO inputNewProductInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("등록할 새로운 제품 정보를 입력하세요. ");
        System.out.println("===================================");
        ProductDTO productDTO = new ProductDTO();
        getProductInfo(productDTO);
        System.out.println("===================================");

        return productDTO;
    }

    private static ProductDTO inputModifyProductInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("수정할 제품 정보를 입력하세요. ");
        System.out.println("===================================");
        System.out.println("수정 대상 제품코드를 입력해 주세요 : ");
        int productCode = Integer.parseInt(sc.nextLine());

        ProductDTO productDTO = new ProductDTO();


        getProductInfo(productDTO);

        productDTO.setProductCode(productCode);

        System.out.println("===================================");

        return productDTO;
    }


    private static ProductDTO getProductInfo(ProductDTO productDTO) {
        Scanner sc = new Scanner(System.in);

        System.out.println("제품명을 입력해 주세요 : ");
        String productName = sc.nextLine();
        System.out.println("제품의 원가를 입력해 주세요 : ");
        int productPrice = sc.nextInt();

        productDTO.setProductName(productName);
        productDTO.setProductPrice(productPrice);

        return productDTO;
    }

    private static Map<String, String> inputProductCode() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("삭제할 제품의 코드를 입력해 주세요 : ");
        String productCode = sc.nextLine();
        System.out.println("===================================");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("productCode", productCode);

        return parameter;
    }
}
