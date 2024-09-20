package com.example.demo.Controller;

import com.example.demo.DTO.*;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ResponseData<ProductDTO>>> getProducts(@RequestParam int page, @RequestParam int take) {
        Page<ProductDTO> productPage = productService.getProducts(page, take);

        ResponseData<ProductDTO> responseData = new ResponseData<>(
                productPage.getContent(),
                productPage.getNumber(),
                productPage.getSize(),
                (int) productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.hasPrevious(),
                productPage.hasNext()
        );

        ApiResponse<ResponseData<ProductDTO>> response = new ApiResponse<>(
                true,
                responseData,
                "Success",
                "/products/list",
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id); // ResourceNotFoundException sẽ được ném ra nếu không tìm thấy
        ApiResponse<ProductDTO> response = new ApiResponse<>(
                true,
                product,
                "Product found",
                "/products/" + id,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        ProductDTO createdProduct = productService.createProduct(createProductDTO);
        ApiResponse<ProductDTO> response = new ApiResponse<>(
                true,
                createdProduct,
                "Product created successfully",
                "/products/new",
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // ResourceNotFoundException sẽ được ném ra nếu không tìm thấy
        ApiResponse<Void> response = new ApiResponse<>(
                true,
                null,
                "Product deleted successfully",
                "/products/" + id,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(@PathVariable Long id, @RequestBody UpdateDTO updatedProductDTO) {
        ProductDTO updatedProduct = productService.updateProduct(id, updatedProductDTO); // ResourceNotFoundException sẽ được ném ra nếu không tìm thấy
        ApiResponse<ProductDTO> response = new ApiResponse<>(
                true,
                updatedProduct,
                "Product updated successfully",
                "/products/" + id,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }
}
