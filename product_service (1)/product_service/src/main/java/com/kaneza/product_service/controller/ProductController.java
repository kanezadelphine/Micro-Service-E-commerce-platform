package com.kaneza.product_service.controller;



import com.kaneza.product_service.dto.ProductDto;
import com.kaneza.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {

        return new ResponseEntity<>(
                service.createProduct(dto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> all() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> byId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(
            @PathVariable Long id,
            @RequestBody ProductDto dto) {

        return ResponseEntity.ok(service.updateProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        service.deleteProduct(id);

        return ResponseEntity.ok("Product deleted successfully.");
    }
}