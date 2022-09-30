package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Hashem
 */
public class NoteServlet extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = "";
        String infos = "";

        BufferedReader text = new BufferedReader(new FileReader(new File(path)));
         title = text.readLine ();
        String line;
        
        while ((line = text.readLine()) != null){
         infos = line + infos;
        }
        String info = infos.replace("<text>", "\r\n");
        text.close();
        
        Note note = new Note(title, info);
        request.setAttribute("note", note);
        String editAcc = request.getParameter("edit");
        
        if(editAcc == null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
        else
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        return;    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String info = request.getParameter("content");
        
        String infos =  info.replace("\r\n", "<text>");
        
        Note note = new Note(title, infos);
        
        request.setAttribute("note", note);
        
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)));
        
        pw.write(title + "\n" + info);
        pw.close();
       
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
        
    }
}