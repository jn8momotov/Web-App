package ru.mirea;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ServletTags extends HttpServlet {

    // Получение списка тегов
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        String str = "";
        if (req.getParameter("search") != null) {
            String search = req.getParameter("search");
            ArrayList<Tag> list = Dictionary.searchToListTags(search);
            str = Dictionary.getTags(list);
        }
        else {
            str = Dictionary.getTags(Dictionary.listTags);
        }
        pw.println(str);
    }

    // Удаление тега по мнемонике
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        String str = Dictionary.deleteTag(req.getParameter("mnemo"));
        pw.println(str);
    }

    // Изменение тега по мнемонике
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        String str = Dictionary.setTag(req.getParameter("mnemo"), req.getParameter("name"));
        pw.println(str);
    }

    // Метод определяющий, какой метод вызвать
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("mnemo") != null) {
            if (req.getParameter("name") != null) {
                doPut(req, resp);
            }
            else doDelete(req, resp);
        }
        else doGet(req, resp);
    }

}
