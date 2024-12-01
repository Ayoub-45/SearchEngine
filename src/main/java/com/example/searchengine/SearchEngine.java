package com.example.searchengine;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name= "ServletSearch", urlPatterns = {"/Find"})
public class SearchEngine extends HttpServlet {
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        String engine= request.getParameter("engine");
        if (keyword == null || keyword.isEmpty() || engine == null || engine.isEmpty()){
            response.getWriter().write ("Keyword is required");
            return;
        }
        String redirectUrl ="";
        switch (engine){
            case "google":
                redirectUrl="https://www.google.com/search?q="+keyword;
                break;
            case "bing":
                redirectUrl="https://www.bing.com/search?q="+keyword;
                break;
                default:
                    response.getWriter().write ("Invalid Search engine");
        }
        response.sendRedirect(redirectUrl);
    }
}
