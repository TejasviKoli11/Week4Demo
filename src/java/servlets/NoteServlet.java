package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Tejasvi
 */
public class NoteServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
// to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();
        br.close();
        
        Note note = new Note(title,contents);
        request.setAttribute("note",note);
        
        String page = request.getParameter("page");
        
        String jspPages = page == null ? "/WEB-INF/viewnote.jsp" : "/WEB-INF/editnote.jsp";
        
        getServletContext().getRequestDispatcher(jspPages).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         String title = request.getParameter("title");
         String contents = request.getParameter("contents");
         
         Note note = new Note(title,contents);
        request.setAttribute("note",note);
        
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        pw.println(title);
        pw.print(contents);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
    }

}
