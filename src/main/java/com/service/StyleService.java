package com.service;

import com.dao.StyleDAO;
import com.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Service
@Transactional
public class StyleService {
    @Autowired
    StyleDAO styleDAO;
    //addStyle
    public void addStyle(Style style){
styleDAO.addStyle(style);
    }
    public boolean deleteStyle(Style style){
return  styleDAO.deleteStyle(style);
    }

    public boolean updateStyle(Style style){
return styleDAO.updateStyle(style);
    }
}
