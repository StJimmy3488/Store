package com.example.store.cart_item;


import com.example.store.user.CustomUserDetailsService;
import com.example.store.user.MyUserDetails;
import com.example.store.user.User;
import com.example.store.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartItemController {

    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    private final CartItemService cartItemServiceService;
    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;

//    @GetMapping("/cart")
//    public String viewShoppingCart(Model model,
//                                   @AuthenticationPrincipal Authentication authentication) {
//        User user = userService.getCurrentlyLoggedIn
//            String currentPrincipalName = authentication.getName();
//
//        return "/cart/cart";
//    }

}
