package com.controller;

import com.entity.Wishlist;
import com.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Wishlist")
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    //获取收藏夹信息
    @RequestMapping("/WishlistInfo")
    public String getWishlistById(Model model, HttpSession session){
        model.addAttribute("wishlist",wishlistService.getWishlist((Integer) session.getAttribute("userId")));
        return "Wishlist";
    }
    //删除收藏夹里的商品
    @RequestMapping("/deleteWishlist")
    public String deleteWishlistById(int wishlistId){
        wishlistService.deleteWishlist(wishlistId);
        return "redirect:WishlistInfo";
    }
    public void addWishlist(Wishlist wishlist) {

    }
    public void updateWishlist(int UserId){

    }


}
