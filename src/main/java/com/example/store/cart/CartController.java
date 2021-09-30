package com.example.store.cart;

import com.example.store.cart_item.CartItem;
import com.example.store.cart_item.CartItemService;
import com.example.store.product.Product;
import com.example.store.product.ProductService;
import com.example.store.product_image.ProductImageService;
import com.example.store.user.UserService;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final UserService userService;
    private final ProductImageService productImageService;

//    @PostMapping("/add_product_to_cart/{id}")
//    public String addProductToCart(
//            @ModelAttribute("cart_item") CartItem cartItem,
//            @ModelAttribute("id") Product product) {
//
////        RandomStringGenerator sessionId = new RandomStringGenerator.Builder()
////                .withinRange('0', 'z')
////                .filteredBy(LETTERS, DIGITS)
////                .build();
//
//        String sessionId = session.getId();
//        Cart cart = new Cart();
//        cart.setSessionId(sessionId.toString());
//        cart.setCartToken(sessionId.toString());
//        cartService.saveOrUpdateCart(cart);
//        Long newCartId = cartService.getBySessionId(sessionId.toString());
//        //TODO - Continue when Custom Security is finished
//
//        cartItemService.saveOrUpdateCartItem(cartItem);
//
//
//        return "cart/cart";
//    }

}
