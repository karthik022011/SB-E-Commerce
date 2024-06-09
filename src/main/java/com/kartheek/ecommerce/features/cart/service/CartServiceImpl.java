package com.kartheek.ecommerce.features.cart.service;

import com.kartheek.ecommerce.admin.product.entity.Product;
import com.kartheek.ecommerce.admin.product.repository.ProductRepository;
import com.kartheek.ecommerce.features.cart.entity.Cart;
import com.kartheek.ecommerce.features.cart.entity.CartItem;
import com.kartheek.ecommerce.features.cart.model.CartItemDTO;
import com.kartheek.ecommerce.features.cart.model.request.AddToCartReqDTO;
import com.kartheek.ecommerce.features.cart.model.CartDTO;
import com.kartheek.ecommerce.features.cart.repository.CartItemRepository;
import com.kartheek.ecommerce.features.cart.repository.CartRepository;
import com.kartheek.ecommerce.user.entity.RegisterUser;
import com.kartheek.ecommerce.user.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public String addProductToCart(AddToCartReqDTO addToCartReqDTO) {
        // Get the Cart by passing userid
        Optional<Cart> optionalCart = cartRepository.findById(addToCartReqDTO.getUserId());
        Cart cart = optionalCart.get();
        //Get the product
        Optional<Product> product = productRepository.findById(addToCartReqDTO.getProductId());
        Product currentProduct = product.get();
        //Check that product already contains in cart ot not
        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(cart.getCartId(), addToCartReqDTO.getProductId());
        if (cartItem == null) {
            // If the item is not in the cart, create a new cart item
            cartItem = new CartItem();
            cartItem.setProduct(currentProduct);
            cartItem.setQuantity(addToCartReqDTO.getQuantity());
            cartItem.setCart(cart);
          //  cart.getCartItems().add(cartItem);
            cart.setCartTotalProducts(cart.getCartTotalProducts() + 1);
        } else {
            // If the item is already in the cart, update the quantity
            cartItem.setQuantity(cartItem.getQuantity() + addToCartReqDTO.getQuantity());
            cart.setCartTotalProducts(cart.getCartTotalProducts());
        }
        cart.setCartTotalPrice(cart.getCartTotalPrice() + (currentProduct.getPrice() * addToCartReqDTO.getQuantity()));
        // Save the cart
        cartItemRepository.save(cartItem);
        return "Product Added to Cart";
    }

    @Override
    public String removeProductFromCart(Long cartId, Long productId) {
        return null;
    }

    @Override
    public CartDTO getCart(Long userId) {
        Optional<Cart> optionalCart = cartRepository.findById(userId);
        Cart cart = optionalCart.get();

        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
        List<CartItemDTO> cartItemDTOs = cart.getCartItems().stream()
                .map(this::convertToCartItemDTO)
                .collect(Collectors.toList());
        cartDTO.setCartItems(cartItemDTOs);
        return cartDTO;
    }

    private CartItemDTO convertToCartItemDTO(CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemDTO.class);
    }

    @Override
    public String  createCart(Long userId) {
        Optional<RegisterUser> optionalRegisterUser = userInfoRepository.findById(userId);
        Cart cart = new Cart();
        cart.setUser(optionalRegisterUser.get());
        cartRepository.save(cart);
        return "Cart Created";
    }
}
