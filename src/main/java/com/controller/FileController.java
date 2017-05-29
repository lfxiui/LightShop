package com.controller;

import com.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by AgZou on 2017/5/28.
 */
@Controller
@RequestMapping("/file")

public class FileController {
    private final LightService lightService;

    @Autowired
    public FileController(LightService lightService) {
        this.lightService = lightService;
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file")CommonsMultipartFile file, HttpSession session,Integer lightId){
        Integer imageNumber=1,temp;
        temp= (Integer) session.getAttribute("imageNumber");
        if(temp==null){
            imageNumber=1;
            session.setAttribute("imageNumber",2);
        }else if(temp==2){
            imageNumber=2;
            session.setAttribute("imageNumber",3);
        }else if(temp==3){
            imageNumber=3;
            session.removeAttribute("imageNumber");
        }
        String fileName=file.getOriginalFilename();
        ServletContext sc=session.getServletContext();
        String path=sc.getRealPath("images")+"/";
        File f=new File(path);
        if(!f.exists())
            f.mkdir();
        if(!file.isEmpty()){
            try {
                FileOutputStream fos=new FileOutputStream(path+fileName);
                InputStream in=file.getInputStream();
                int b=0;
                while ((b=in.read())!=-1){
                    fos.write(b);
                }
                fos.close();
                in.close();
                lightService.updatePhoto(imageNumber,lightId,"images/"+fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "{}";
    }
}
